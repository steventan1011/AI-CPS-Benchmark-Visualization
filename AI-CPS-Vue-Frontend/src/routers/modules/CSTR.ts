import Layout from "@/layout/index.vue";


const CSTRRouter = [{
    path: '/CSTR',
    component: Layout,
    redirect: '/CSTR/intro',
    name: 'CSTR',
    meta: {
        title: 'CSTR',
        icon: 'link'
    },
  children: [
        {
            path: '/CSTR/intro',
            component: () => import('@/views/CSTR/intro/index.vue'),
            name: 'CSTR-intro',
            meta: { title: 'CSTR Intro',  icon: 'MenuIcon' }
        },
        {
            path: '/CSTR/radarTraditionalDRL',
            component: () => import('@/views/CSTR/radarTD/index.vue'),
            name: 'CSTR-radarTD',
            meta: { title: 'Radar Chart (DRL)',  icon: 'MenuIcon' }
        },
        {
            path: '/CSTR/radarHybrid',
            component: () => import('@/views/CSTR/radarH/index.vue'),
            name: 'CSTR-radarH',
            meta: { title: 'Radar Chart (Hybrid)',  icon: 'MenuIcon' }
        },
        {
            path: '/CSTR/detail',
            component: () => import('@/views/CSTR/ComprehensiveTable/index.vue'),
            name: 'CSTR-comprehensive',
            meta: { title: 'Details', icon: 'MenuIcon'}
        },
    ]
}]

export default CSTRRouter;
