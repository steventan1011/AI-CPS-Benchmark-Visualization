<template>
  <div class="home-container">
    <el-row class="row-bg" :gutter="10">
      <el-col :xs="24" :sm="12" :lg="8">
        <el-card class="box-card" style="height: 100%">
          <!-- <el-image
              class="wechat"
              :src="weLogo"
              :preview-src-list="[weLogo]"
              style="max-width: 200px"
              :data-resid="Date.now()"
          /> -->
          <div class="personal">
            <!-- <div>
              <el-avatar :size="50" :src="AvatarLogo" />
            </div> -->
            <div class="name">AI-CPS Benchmark Visualization</div>
            <div class="description"></div>
            <div class="list">
              <div>This visualization website for AI-CPS Benchmarking aims to improve transparency, accountability, and decision-making by providing stakeholders with interactive dashboards, diagrams, and animations that visualize the behavior of AI-enabled Cyber-Physical Systems (AI-CPS).</div>
            </div>
            <el-divider></el-divider>
            <div style="margin-bottom: 15px"><h5>Benchmarks</h5></div>
            <div>
              <el-tag style="margin-right: 10px">Adaptive Cruise Control (ACC)</el-tag>
              <el-tag style="margin-right: 10px">Lane Keeping Assistant (LKA)</el-tag>
              <p/>
              <el-tag style="margin-right: 10px">Abstract Fuel Control (AFC)</el-tag>
              <el-tag style="margin-right: 10px">Wind Turbine (WT)</el-tag>
            </div>
            <el-divider></el-divider>
            <div style="margin-bottom: 15px"><h5>Opportunity</h5></div>
            <div>The future of AI-enabled Cyber-Physical Systems (AI-CPS) visualization is promising, as the field continues to evolve with advances in computing, sensing, and communication technologies.</div>
            <el-divider></el-divider>
            <div style="margin-bottom: 15px"
            ><h5>This is the capstone project for An Early Attempt of Visualization for AI-enabled Cyber-Physical Systems by Binkai Tan</h5></div
            >
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="12" :lg="16">
        <el-row class="custom" :gutter="10">
          <el-col :xs="24" :sm="12" :lg="8">
            <el-card style="margin-bottom: 10px">
              <div class="grid-content">
                <div class="left"
                ><el-icon style="font-size: 24px; color: white"><user /></el-icon
                ></div>
                <div class="right">
                  <div
                      class="h2"
                      style="color: #2d8cf0"
                  ><count-to
                      :start-val="0"
                      :end-val="31"
                      :duration="2000"
                      :autoplay="true"
                  ></count-to
                  ></div>
                  <div>User Visits </div>
                </div>
              </div>
            </el-card>
          </el-col>
          <el-col :xs="24" :sm="12" :lg="8">
            <el-card style="margin-bottom: 10px">
              <div class="grid-content">
                <div class="left" style="background: #64d572"
                ><el-icon style="font-size: 24px; color: white"><user /></el-icon
                ></div>
                <div class="right">
                  <div
                      class="h2"
                      style="color: #64d572"
                  ><count-to
                      :start-val="0"
                      :end-val="23"
                      :duration="2000"
                      :autoplay="true"
                  ></count-to
                  ></div>
                  <div>System Messages </div>
                </div>
              </div>
            </el-card>
          </el-col>
          <el-col :xs="24" :sm="12" :lg="8">
            <el-card style="margin-bottom: 10px">
              <div class="grid-content">
                <div class="left" style="background: #f25e43"
                ><el-icon style="font-size: 24px; color: white"><user /></el-icon
                ></div>
                <div class="right">
                  <div
                      class="h2"
                      style="color: #f25e43"
                  ><count-to
                      :start-val="0"
                      :end-val="2986"
                      :duration="2000"
                      :autoplay="true"
                  ></count-to
                  ></div>
                  <div>Data Volume </div>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>
        <el-card class="box-card">
          <template #header>
            <div class="card-header">
              <span>Benchmark Examples</span>
            </div>
          </template>
          <div style="display: flex">
            <el-card
                style="flex: 1; margin-right: 20px; cursor: pointer"
                class="card-item"
                @click="goTo('https://sites.google.com/view/ai-cps-benchmark/benchmarks?authuser=0#h.n4flk7jeago8')"
            >
              <div style="color: white; margin-bottom: 10px"><h3>Adaptive Cruise Control (ACC)</h3></div>
              <div style="font-size: 12px; color: white"
              >As an important driving assistance function, ACC has been popularized in the automotive field after decades of development. The ACC system mentioned in this paper is originally from MathWorks, and it aims to maintain the safety distance of an ego car from a lead car by adjusting the acceleration of the ego car. </div
              >
            </el-card>
            <el-card
                style="flex: 1; cursor: pointer"
                class="card-item"
                @click="goTo('https://sites.google.com/view/ai-cps-benchmark/benchmarks?authuser=0#h.ygn51y7y3tfq')"
            >
              <div style="color: white; margin-bottom: 10px"><h3>Abstract Fuel Control (AFC)</h3></div>
              <div style="font-size: 12px; color: white"
              >AFC is a complex air-fuel control system released by Toyota [6]. The whole system takes two input signals from the outside environment, PedalAngle and EngineSpeed, and outputs μ = |AF - AF_ref|/AF_ref, which is the deviation of the air-to-fuel ratio AF from a reference value AF_ref.</div
              >
            </el-card>
          </div>
        </el-card>
        <el-card class="box-card">
          <template #header>
            <div class="card-header">
              <span>Data Volume</span>
            </div>
          </template>
          <div>
            <bar-charts height="300px" width="100%" id="bar1"></bar-charts>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>
<script setup lang="ts">
  import { User } from '@element-plus/icons-vue'
  import { ref } from 'vue'
  import AvatarLogo from '@/assets/image/avatar.png'
  import weLogo from '@/assets/image/we.png'
  import CountTo from '@/components/CountTo/index.vue'
  import BarCharts from '@/views/echarts/simple/components/bar.vue'

  const goTo = (url) => {
    window.open(url, '_blank')
  }
</script>

<style scoped lang="scss">
@import "./index";
</style>
