import Layout from "@/layout/index.vue";


const LKARouter = [{
    path: '/LKA',
    component: Layout,
    redirect: '/LKA/intro',
    name: 'LKA',
    meta: {
        title: 'LKA',
        icon: 'Grape'
    },
  children: [
        {
            path: '/LKA/intro',
            component: () => import('@/views/LKA/intro/index.vue'),
            name: 'LKA-intro',
            meta: { title: 'LKA Intro',  icon: 'MenuIcon' }
        },
        {
            path: '/LKA/radarTraditionalDRL',
            component: () => import('@/views/LKA/radarTD/index.vue'),
            name: 'LKA-radarTD',
            meta: { title: 'Radar Chart (DRL)',  icon: 'MenuIcon' }
        },
        {
            path: '/LKA/radarHybrid',
            component: () => import('@/views/LKA/radarH/index.vue'),
            name: 'LKA-radarH',
            meta: { title: 'Radar Chart (Hybrid)',  icon: 'MenuIcon' }
        },
        {
            path: '/LKA/detail',
            component: () => import('@/views/LKA/ComprehensiveTable/index.vue'),
            name: 'LKA-comprehensive',
            meta: { title: 'Details', icon: 'MenuIcon'}
        },
    ]
}]

export default LKARouter;
