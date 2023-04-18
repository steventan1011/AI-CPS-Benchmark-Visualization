import os
import scipy.io as spio
import pandas as pd


def loadmat(filename):
    """
    this function should be called instead of direct spio.loadmat
    as it cures the problem of not properly recovering python dictionaries
    from mat files. It calls the function check keys to cure all entries
    which are still mat-objects
    """
    data = spio.loadmat(filename, struct_as_record=False, squeeze_me=True)
    return _check_keys(data)


def _check_keys(dic):
    """
    checks if entries in dictionary are mat-objects. If yes
    todict is called to change them to nested dictionaries
    """
    for key in dic:
        if isinstance(dic[key], spio.matlab.mio5_params.mat_struct):
            dic[key] = _todict(dic[key])
    return dic


def _todict(matobj):
    """
    A recursive function which constructs from matobjects nested dictionaries
    """
    dic = dict()
    for strg in matobj._fieldnames:
        elem = matobj.__dict__[strg]
        if isinstance(elem, spio.matlab.mio5_params.mat_struct):
            dic[strg] = _todict(elem)
        else:
            dic[strg] = elem
    return dic


def mat2json(mat_path, filepath=None):
    """
    Parameters:
        mat_path: mat文件的地址
        filepath: 如果不填，则默认储存为mat同名json文件；否则以filepath为名储存
    """
    matlabFile = loadmat(mat_path)
    # pop all those dumb fields that don't let you jsonize file
    matlabFile.pop('__header__')
    matlabFile.pop('__version__')
    matlabFile.pop('__globals__')
    # jsonize the file - orientation is 'index'
    matlabFile = pd.Series(matlabFile).to_json()

    if filepath:
        with open(filepath, 'w') as f:
            f.write(matlabFile)
    else:
        filepath = os.path.splitext(os.path.split(mat_path)[1])[0] + '.json'
        with open(filepath, 'w') as f:
            f.write('[')
            f.write(matlabFile)
            f.write(']')

if __name__ == '__main__':
    mat_path = "C:/users/steve/desktop/AFC_eval_NN_3_15_1_DDPG_result_overall.mat"
    mat2json(mat_path)