import Layout from "@/layout/index.vue";


const WTRouter = [{
    path: '/WT',
    component: Layout,
    redirect: '/WT/intro',
    name: 'WT',
    meta: {
        title: 'WT',
        icon: 'management'
    },
  children: [
        {
            path: '/WT/intro',
            component: () => import('@/views/WT/intro/index.vue'),
            name: 'WT-intro',
            meta: { title: 'WT Intro',  icon: 'MenuIcon' }
        },
        {
            path: '/WT/radarTraditionalDRL',
            component: () => import('@/views/WT/radarTD/index.vue'),
            name: 'WT-radarTD',
            meta: { title: 'Radar Chart (DRL)',  icon: 'MenuIcon' }
        },
        {
            path: '/WT/radarHybrid',
            component: () => import('@/views/WT/radarH/index.vue'),
            name: 'WT-radarH',
            meta: { title: 'Radar Chart (Hybrid)',  icon: 'MenuIcon' }
        },
        {
            path: '/WT/detail',
            component: () => import('@/views/WT/ComprehensiveTable/index.vue'),
            name: 'WT-comprehensive',
            meta: { title: 'Details', icon: 'MenuIcon'}
        },
    ]
}]

export default WTRouter;
