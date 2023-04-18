import Layout from "@/layout/index.vue";


const SCRouter = [{
    path: '/SC',
    component: Layout,
    redirect: '/SC/intro',
    name: 'SC',
    meta: {
        title: 'SC',
        icon: 'HelpFilled'
    },
  children: [
        {
            path: '/SC/intro',
            component: () => import('@/views/SC/intro/index.vue'),
            name: 'SC-intro',
            meta: { title: 'SC Intro',  icon: 'MenuIcon' }
        },
        {
            path: '/SC/radarTraditionalDRL',
            component: () => import('@/views/SC/radarTD/index.vue'),
            name: 'SC-radarTD',
            meta: { title: 'Radar Chart (DRL)',  icon: 'MenuIcon' }
        },
        {
            path: '/SC/radarHybrid',
            component: () => import('@/views/SC/radarH/index.vue'),
            name: 'SC-radarH',
            meta: { title: 'Radar Chart (Hybrid)',  icon: 'MenuIcon' }
        },
        {
            path: '/SC/detail',
            component: () => import('@/views/SC/ComprehensiveTable/index.vue'),
            name: 'SC-comprehensive',
            meta: { title: 'Details', icon: 'MenuIcon'}
        },
    ]
}]

export default SCRouter;
