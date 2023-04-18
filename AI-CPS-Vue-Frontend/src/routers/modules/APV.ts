import Layout from "@/layout/index.vue";


const APVRouter = [{
    path: '/APV',
    component: Layout,
    redirect: '/APV/intro',
    name: 'APV',
    meta: {
        title: 'APV',
        icon: 'School'
    },
  children: [
        {
            path: '/APV/intro',
            component: () => import('@/views/APV/intro/index.vue'),
            name: 'APV-intro',
            meta: { title: 'APV Intro',  icon: 'MenuIcon' }
        },
        {
            path: '/APV/radarTraditionalDRL',
            component: () => import('@/views/APV/radarTD/index.vue'),
            name: 'APV-radarTD',
            meta: { title: 'Radar Chart (DRL)',  icon: 'MenuIcon' }
        },
        {
            path: '/APV/radarHybrid',
            component: () => import('@/views/APV/radarH/index.vue'),
            name: 'APV-radarH',
            meta: { title: 'Radar Chart (Hybrid)',  icon: 'MenuIcon' }
        },
        {
            path: '/APV/detail',
            component: () => import('@/views/APV/ComprehensiveTable/index.vue'),
            name: 'APV-comprehensive',
            meta: { title: 'Details', icon: 'MenuIcon'}
        },
    ]
}]

export default APVRouter;
