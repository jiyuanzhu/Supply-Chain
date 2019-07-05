import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home from '@/views/Home'
import TopNav from '@/views/nav/TopNav'
import BankLogin from '@/views/login/BankLogin'
import EnterpriseLogin from '@/views/login/EnterpriseLogin'
import TransLogin from '@/views/login/TransLogin'
import InsuranceLogin from '@/views/login/InsuranceLogin'
import Register from '@/views/login/Register'
import LeftNav from '@/views/nav/LeftNav'
import Bank from '@/views/Bank'
import Enterprise from '@/views/Enterprise'
import Trans from '@/views/Trans'
import Insurance from '@/views/Insurance'
import MainLayout from '@/views/MainLayout' //定义主要内容布局
import Content from '@/views/Content.vue' //父路由显示子路由组件的载体
import Table from '@/views/table/table'
import NotFound from '@/views/404.vue'

import ContractList from '@/views/table/EnterpriseMgn/ContractList'
import ContractSign from '@/views/table/EnterpriseMgn/ContractSign'
import LogisticsList from '@/views/table/EnterpriseMgn/LogisticsList'
import LogisticsOrderSign from '@/views/table/EnterpriseMgn/LogisticsOrderSign'
import LogisticsCertain from '@/views/table/EnterpriseMgn/LogisticsCertain'
import TokenPay from '@/views/table/EnterpriseMgn/TokenPay'
import TokenExchange from '@/views/table/EnterpriseMgn/TokenExchange'
import TokenValue from '@/views/table/EnterpriseMgn/TokenValue'
import InsuranceBuy from '@/views/table/EnterpriseMgn/InsuranceBuy'
import InsuranceList from '@/views/table/EnterpriseMgn/InsuranceList'



import Pending from '@/views/Pending'
Vue.use(Router)

export default new Router({
    routes: [
        // {
        //   path: '/',
        //   name: 'HelloWorld',
        //   component: HelloWorld
        // },
        {
            path: '*',
            component: NotFound
        },
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
            path: '/register',
            name: 'Register',
            component: Register,
        },
        //登陆之后的路由
        {
            path: '/enterpise',
            component: MainLayout,
            name: 'Enterpise',
            menuShow: true,
            redirect: '/enterpise/contract/list',
            children: [{
                    path: '/enterpise/contract',
                    name: '合同管理',
                    menuShow: true,
                    components: {
                        top: TopNav,
                        aside: LeftNav,
                        default: Content
                    },
                    iconCls: 'el-icon-menu',
                    children: [
                        { path: '/enterpise/contract/list', name: '合同列表', component: ContractList, menuShow: true },
                        { path: '/enterpise/contract/signed', name: '签署合同', component: ContractSign, menuShow: true },
                    ]
                },
                {
                    path: '/enterpise/logistics',
                    name: '物流管理',
                    menuShow: true,
                    components: {
                        top: TopNav,
                        aside: LeftNav,
                        default: Content
                    },
                    iconCls: 'el-icon-menu',
                    children: [
                        { path: '/enterpise/logistics/list', name: '订单列表', component: LogisticsList, menuShow: true },
                        { path: '/enterpise/logistics/signed', name: '确认订单', component: LogisticsOrderSign, menuShow: true },
                        { path: '/enterpise/logistics/confirm', name: '确认货物', component: LogisticsCertain, menuShow: true },
                    ]
                },
                {
                    path: '/enterpise/token',
                    name: 'Token管理',
                    menuShow: true,
                    components: {
                        top: TopNav,
                        aside: LeftNav,
                        default: Content
                    },
                    iconCls: 'el-icon-menu',
                    children: [
                        { path: '/enterpise/token/pay', name: 'Token支付', component: TokenPay, menuShow: true },
                        { path: '/enterpise/token/exchange', name: 'Token兑换', component: TokenExchange, menuShow: true },
                        { path: '/enterpise/token/lines', name: 'Token额度', component: TokenValue, menuShow: true },
                    ]
                },
                {
                    path: '/enterpise/policy',
                    name: '保单管理',
                    menuShow: true,
                    components: {
                        top: TopNav,
                        aside: LeftNav,
                        default: Content
                    },
                    iconCls: 'el-icon-menu',
                    children: [
                        { path: '/enterpise/policy/buy', name: '保单购买', component: InsuranceBuy, menuShow: true },
                        { path: '/enterpise/policy/list', name: '保单列表', component: InsuranceList, menuShow: true },
                    ]
                },
            ]
        },
        {
            path: '/bank',
            component: MainLayout,
            name: 'Bank',
            menuShow: true,
            redirect: '/bank/creditManage/credit',
            children: [{
                    path: '/bank/creditManage/',
                    name: '授信管理',
                    menuShow: true,
                    components: {
                        top: TopNav,
                        aside: LeftNav,
                        default: Content
                    },
                    iconCls: 'el-icon-menu',
                    children: [
                        { path: '/bank/creditManage/credit', name: '银行授信', component: Pending, menuShow: true }
                    ]
                },
                {
                    path: '/bank/toekn',
                    name: 'Token兑付',
                    menuShow: true,
                    components: {
                        top: TopNav,
                        aside: LeftNav,
                        default: Content
                    },
                    iconCls: 'el-icon-menu',
                    children: [
                        { path: '/bank/token/exchange', name: 'Token支付', component: Pending, menuShow: true }
                    ]
                }
            ]
        },
        {
            path: '/insurance',
            name: 'Insurance',
            component: MainLayout,
            menuShow: true,
            redirect: '/insurance/policy/list',
            children: [{
                    path: '/insurance/policy',
                    name: '保单管理',
                    menuShow: true,
                    components: {
                        top: TopNav,
                        aside: LeftNav,
                        default: Content
                    },
                    iconCls: 'el-icon-menu',
                    children: [
                        { path: '/insurance/policy/list', name: '保单列表', component: Pending, menuShow: true }
                    ]
                },
                {
                    path: '/insurance/token',
                    name: 'Token管理',
                    menuShow: true,
                    components: {
                        top: TopNav,
                        aside: LeftNav,
                        default: Content
                    },
                    iconCls: 'el-icon-menu',
                    children: [
                        { path: '/insurance/token/exchange', name: 'Token兑换', component: Pending, menuShow: true },
                        { path: '/insurance/token/lines', name: 'Token额度', component: Pending, menuShow: true },
                    ]
                }
            ]
        },
        {
            path: '/trans',
            component: MainLayout,
            menuShow: true,
            name: 'Trans',
            redirect: '/trans/transport/manage',
            children: [{
                    path: '/trans/transport',
                    name: '运输管理',
                    menuShow: true,
                    components: {
                        top: TopNav,
                        aside: LeftNav,
                        default: Content
                    },
                    iconCls: 'el-icon-menu',
                    children: [
                        { path: '/trans/transport/manage', name: '管理运输', component: Pending, menuShow: true },
                        { path: '/trans/transport/send', name: '发出货物', component: Pending, menuShow: true },
                        { path: '/trans/transport/done', name: '送达货物', component: Pending, menuShow: true },
                    ]
                },
                {
                    path: '/trans/token',
                    name: 'Token管理',
                    menuShow: true,
                    components: {
                        top: TopNav,
                        aside: LeftNav,
                        default: Content
                    },
                    iconCls: 'el-icon-menu',
                    children: [
                        { path: '/trans/token/exchange', name: 'Token兑换', component: Pending, menuShow: true },
                        { path: '/trans/token/pay', name: 'Token支付', component: Pending, menuShow: true },
                        { path: '/trans/token/lines', name: 'Token额度', component: Pending, menuShow: true },
                    ]
                },
                {
                    path: '/trans/policy',
                    name: '保单管理',
                    menuShow: true,
                    components: {
                        top: TopNav,
                        aside: LeftNav,
                        default: Content
                    },
                    iconCls: 'el-icon-menu',
                    children: [
                        { path: '/trans/policy/buy', name: '保单购买', component: Pending, menuShow: true },
                        { path: '/trans/policy/list', name: '保单列表', component: Pending, menuShow: true },
                    ]
                },

            ]

        },
        {
            path: '/table',
            name: 'Table',
            component: Table,
        },



    ]
})