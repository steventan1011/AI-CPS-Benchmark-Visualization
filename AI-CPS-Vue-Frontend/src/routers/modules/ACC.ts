import Layout from "@/layout/index.vue";


const ACCRouter = [{
    path: '/ACC',
    component: Layout,
    redirect: '/ACC/intro',
    name: 'ACC',
    meta: {
        title: 'ACC',
        icon: 'trend-charts'
    },
  children: [
        {
            path: '/ACC/intro',
            component: () => import('@/views/ACC/intro/index.vue'),
            name: 'ACC-intro',
            meta: { title: 'ACC Intro',  icon: 'MenuIcon' }
        },
        {
            path: '/ACC/radarTraditionalDRL',
            component: () => import('@/views/ACC/radarTD/index.vue'),
            name: 'ACC-radarTD',
            meta: { title: 'Radar Chart (DRL)',  icon: 'MenuIcon' }
        },
        {
            path: '/ACC/radarHybrid',
            component: () => import('@/views/ACC/radarH/index.vue'),
            name: 'ACC-radarH',
            meta: { title: 'Radar Chart (Hybrid)',  icon: 'MenuIcon' }
        },
        {
            path: '/ACC/detail',
            component: () => import('@/views/ACC/ComprehensiveTable/index.vue'),
            name: 'ACC-comprehensive',
            meta: { title: 'Details', icon: 'MenuIcon'}
        },
    ]
}]

export default ACCRouter;
