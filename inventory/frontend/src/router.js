import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);

import InventoryManager from "./components/ui/InventoryGrid"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        { 
            path: '/inventory/inventories',
            name: 'InventoryManager',
            component: InventoryManager,
        },
    ]
})
