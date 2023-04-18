import Layout from "@/layout/index.vue";


const WTKRouter = [{
    path: '/WTK',
    component: Layout,
    redirect: '/WTK/intro',
    name: 'WTK',
    meta: {
        title: 'WTK',
        icon: 'Setting'
    },
  children: [
        {
            path: '/WTK/intro',
            component: () => import('@/views/WTK/intro/index.vue'),
            name: 'WTK-intro',
            meta: { title: 'WTK Intro',  icon: 'MenuIcon' }
        },
        {
            path: '/WTK/radarTraditionalDRL',
            component: () => import('@/views/WTK/radarTD/index.vue'),
            name: 'WTK-radarTD',
            meta: { title: 'Radar Chart (DRL)',  icon: 'MenuIcon' }
        },
        {
            path: '/WTK/radarHybrid',
            component: () => import('@/views/WTK/radarH/index.vue'),
            name: 'WTK-radarH',
            meta: { title: 'Radar Chart (Hybrid)',  icon: 'MenuIcon' }
        },
        {
            path: '/WTK/detail',
            component: () => import('@/views/WTK/ComprehensiveTable/index.vue'),
            name: 'WTK-comprehensive',
            meta: { title: 'Details', icon: 'MenuIcon'}
        },
    ]
}]

export default WTKRouter;
