import Layout from "@/layout/index.vue";


const LRRouter = [{
    path: '/LR',
    component: Layout,
    redirect: '/LR/intro',
    name: 'LR',
    meta: {
        title: 'LR',
        icon: 'ElementPlus'
    },
  children: [
        {
            path: '/LR/intro',
            component: () => import('@/views/LR/intro/index.vue'),
            name: 'LR-intro',
            meta: { title: 'LR Intro',  icon: 'MenuIcon' }
        },
        {
            path: '/LR/radarTraditionalDRL',
            component: () => import('@/views/LR/radarTD/index.vue'),
            name: 'LR-radarTD',
            meta: { title: 'Radar Chart (DRL)',  icon: 'MenuIcon' }
        },
        {
            path: '/LR/radarHybrid',
            component: () => import('@/views/LR/radarH/index.vue'),
            name: 'LR-radarH',
            meta: { title: 'Radar Chart (Hybrid)',  icon: 'MenuIcon' }
        },
        {
            path: '/LR/detail',
            component: () => import('@/views/LR/ComprehensiveTable/index.vue'),
            name: 'LR-comprehensive',
            meta: { title: 'Details', icon: 'MenuIcon'}
        },
    ]
}]

export default LRRouter;
