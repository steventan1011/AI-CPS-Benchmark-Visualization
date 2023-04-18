<template>
  <div class="app-container">
    <div ref="chartsRef" class="app-echarts"></div>
  </div>
</template>

<script lang="ts" setup>
import {ref,onMounted} from "vue";
import * as echarts from 'echarts'
import {useResizeElement} from '@/hooks/useResizeElement'

const chartsRef = ref<HTMLElement | null>()
let options  = {
  normal: {
    top: 200,
    left: 300,
    width: 500,
    height: 400,
    zIndex: 6,
    backgroundColor: "",
  },
  color: ["rgba(245, 166, 35, 1)", "rgba(19, 173, 255, 1)"],
  title: {
    show: true,
    text: "Performance comparison on systems with traditional and DRL controllers",
    left: "33%",
    top: "1%",
    textStyle: {
      fontSize: 18,
      // color: "#fff",
      fontStyle: "normal",
      fontWeight: "normal",
    },
  },
  // tooltip: {
  //   show: true,
  //   trigger: "item",
  // },
  legend: {
    show: true,
    icon: "circle",
    left: "40%",
    top: "90%",
    orient: "horizontal",
    textStyle: {
      fontSize: 14,
      // color: "#fff",
    },
    data: ["Traditional", "DDPG", "PPO", "A2C"],
  },
  radar: {
    center: ["50%", "50%"],
    radius: "70%",
    startAngle: 90,
    splitNumber: 4,
    shape: "circle",
    splitArea: {
      areaStyle: {
        color: ["transparent"],
      },
    },
    axisLabel: {
      show: false,
      fontSize: 18,
      color: "#fff",
      fontStyle: "normal",
      fontWeight: "normal",
    },
    axisLine: {
      show: true,
      lineStyle: {
        color: "grey", //
      },
    },
    splitLine: {
      show: true,
      lineStyle: {
        color: "grey", //
      },
    },
    indicator: [
      {
        name: "Safety",
        max: 1,
      },
      {
        name: "MAE",
        max: 1,
      },
      {
        name: "MAXERR",
        max: 1,
      },
      {
        name: "SteadyState",
        max: 1,
      },
      {
        name: "Resilience",
        max: 1,
      },
    ],
  },
  series: [
    {
      name: "Traditional",
      type: "radar",
      symbol: "circle",
      symbolSize: 10,
      areaStyle: {
        normal: {
          color: "rgba(245, 166, 35, 0.2)",
        },
      },
      itemStyle: {
        color: "rgba(245, 166, 35, 1)",
        borderColor: "rgba(245, 166, 35, 0.3)",
        borderWidth: 10,
      },
      lineStyle: {
        normal: {
          type: "dashed",

          color: "rgba(245, 166, 35, 1)",
          width: 2,
        },
      },
      data: [[0.98, 0.95, 0.2, 0.97,0.98]],
    },
    {
      name: "DDPG",
      type: "radar",
      symbol: "circle",
      symbolSize: 10,
      itemStyle: {
        normal: {
          color: "rgba(19, 173, 255, 1)",
          borderColor: "rgba(19, 173, 255, 0.4)",
          borderWidth: 10,
        },
      },
      areaStyle: {
        normal: {
          color: "rgba(19, 173, 255, 0.2)",
        },
      },
      lineStyle: {
        normal: {
          color: "rgba(19, 173, 255, 1)",
          width: 2,
          type: "dashed",
        },
      },
      data: [[0.98, 0.82, 0.93, 0.97,0.98]],
    },
    {
      name: "PPO",
      type: "radar",
      symbol: "circle",
      symbolSize: 10,
      itemStyle: {
        normal: {
          color: "rgba(255, 51, 255, 1)",
          borderColor: "rgba(255, 51, 255, 0.4)",
          borderWidth: 10,
        },
      },
      areaStyle: {
        normal: {
          color: "rgba(255, 51, 255, 0.2)",
        },
      },
      lineStyle: {
        normal: {
          color: "rgba(255, 51, 255, 1)",
          width: 2,
          type: "dashed",
        },
      },
      data: [[0.05, 0.05, 0.07, 0.58, 0.28]],
    },
    {
      name: "A2C",
      type: "radar",
      symbol: "circle",
      symbolSize: 10,
      itemStyle: {
        normal: {
          color: "rgba(0, 204, 0, 1)",
          borderColor: "rgba(0, 204, 0, 0.4)",
          borderWidth: 10,
        },
      },
      areaStyle: {
        normal: {
          color: "rgba(0, 204, 0, 0.2)",
        },
      },
      lineStyle: {
        normal: {
          color: "rgba(0, 204, 0, 1)",
          width: 2,
          type: "dashed",
        },
      },
      data: [[0.05, 0.05, 0.07, 0.6, 0.3]],
    },
  ],
};

onMounted(() => {
  let chart = echarts.init(chartsRef.value)
  chart.setOption(options)
  let {addObserver} = useResizeElement(chart,chartsRef.value)
  addObserver()
})

</script>

<style lang="scss" scoped>
.app-echarts{
  width: 100%;
  height: 100%;
  background: white;
}
</style>
