import Layout from "@/layout/index.vue";


const AFCRouter = [{
    path: '/AFC',
    component: Layout,
    redirect: '/AFC/intro',
    name: 'AFC',
    meta: {
        title: 'AFC',
        icon: 'Histogram'
    },
  children: [
        {
            path: '/AFC/intro',
            component: () => import('@/views/AFC/intro/index.vue'),
            name: 'AFC-intro',
            meta: { title: 'AFC Intro',  icon: 'MenuIcon' }
        },
        {
            path: '/AFC/radarTraditionalDRL',
            component: () => import('@/views/AFC/radarTD/index.vue'),
            name: 'AFC-radarTD',
            meta: { title: 'Radar Chart (DRL)',  icon: 'MenuIcon' }
        },
        {
            path: '/AFC/radarHybrid',
            component: () => import('@/views/AFC/radarH/index.vue'),
            name: 'AFC-radarH',
            meta: { title: 'Radar Chart (Hybrid)',  icon: 'MenuIcon' }
        },
        {
            path: '/AFC/detail',
            component: () => import('@/views/AFC/ComprehensiveTable/index.vue'),
            name: 'AFC-comprehensive',
            meta: { title: 'Details', icon: 'MenuIcon'}
        },
    ]
}]

export default AFCRouter;
