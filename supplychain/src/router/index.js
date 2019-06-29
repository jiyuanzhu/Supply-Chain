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
            components: {
                default: Home,
                top: TopNav
            }
        },
        {
            path: '/banklogin',
            name: 'BankLogin',
            components: {
                default: BankLogin,
                top: TopNav
            },
            redirect: '/bank',
            children: [{
                path: 'bank',
                name: 'Bank',
                components: {
                    top: TopNav,
                    left: BankLeftNav
                }
            }]
        },
        {
            path: '/enterpriselogin',
            name: 'EnterpriseLogin',
            components: {
                default: EnterpriseLogin,
                top: TopNav
            },
            redirect: '/enterprise',
            children: [{
                path: '/enterprise',
                name: 'Bank',
                components: {
                    top: TopNav,
                    left: EnterpriseLeftNav
                }
            }]
        },
        {
            path: '/',
            name: 'TransLogin',
            components: {
                default: TransLogin,
                top: TopNav
            },
            redirect: '/trans',
            children: [{
                path: '/trans',
                name: 'Trans',
                components: {
                    top: TopNav,
                    left: TransLeftNav
                }
            }]
        },
        {
            path: '/',
            name: 'InsuranceLogin',
            components: {
                default: InsuranceLogin,
                top: TopNav
            },
            redirect: '/insurance',
            children: [{
                path: '/insurance',
                name: 'Insurance',
                components: {
                    top: TopNav,
                    left: InsuranceLeftNav
                }
            }]
        },
    ]
})