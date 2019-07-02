import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home from '@/views/Home'
import TopNav from '@/views/nav/TopNav'
import BankLogin from '@/views/login/BankLogin'
import EnterpriseLogin from '@/views/login/EnterpriseLogin'
import TransLogin from '@/views/login/TransLogin'
import InsuranceLogin from '@/views/login/InsuranceLogin'
import BankLeftNav from '@/views/nav/leftnav/BankLeftNav'
import EnterpriseLeftNav from '@/views/nav/leftnav/EnterpriseLeftNav'
import TransLeftNav from '@/views/nav/leftnav/TransLeftNav'
import InsuranceLeftNav from '@/views/nav/leftnav/InsuranceLeftNav'
import Bank from '@/views/Bank'
import Enterprise from '@/views/Enterprise'
import Trans from '@/views/Trans'
import Insurance from '@/views/Insurance'

Vue.use(Router)

export default new Router({
    routes: [
        // {
        //   path: '/',
        //   name: 'HelloWorld',
        //   component: HelloWorld
        // },
        {
            path: '/',
            name: 'Home',
            component: Home

        },
        {
            path: '/banklogin',
            name: 'BankLogin',
            component: BankLogin,

        },
        {
            path: '/enterpriselogin',
            name: 'EnterpriseLogin',
            component: EnterpriseLogin,
        },
        {
            path: '/translogin',
            name: 'TransLogin',
            component: TransLogin,
        },
        {
            path: '/insurancelogin',
            name: 'InsuranceLogin',
            component: InsuranceLogin,
        },
        {
            path: '/bank',
            name: 'Bank',
            component: Bank,
        },
        {
            path: '/enterprise',
            name: 'Enterprise',
            component: Enterprise,
        },
        {
            path: '/trans',
            name: 'Trans',
            component: Trans,
        },
        {
            path: '/insurance',
            name: 'Insurance',
            component: Insurance,
        },
    ]
})