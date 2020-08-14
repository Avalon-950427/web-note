## 计算属性和侦听器  

计算属性有缓存性,如果值没有发生变化,页面不会重新渲染  

计算属性和侦听器的不同:
+ 计算属性可以return,侦听器不能return,需要声明一个变量
+ watch的属性名是需要侦听的数据名,计算属性的名字是任意合法名
+ watch是监听一个值得变化并影响多个值的情形,计算属性是一个值由多个值计算得来
+ watch适合执行异步操作或开销比较大的操作

## 生命周期  

生命周期|描述
---|---
beforeCreate|实例创建之前被调用,通常用于执行初始化任务
created|实例初始化完毕,各种数据可以使用,常用语异步获取数据
beforeMounte|未执行渲染、更新,dom未创建
mounted|初始化结束,dom已创建,可用于获取访问数据和dom元素
beforeUpdate|更新前,可用于获取更新前各种状态
updated|更新后,所有状态已是最新
beforeDestory|销毁前,可用于一些定时器或订阅的取消
destoryed|实例已销毁,作用同上

## 组件
```javascript
// 父传子
<course-list :courses="courses"></course-list>

Vue.component('course-list',{
    data(){
      return {
         selectedCourse: '',
      }
    },
    // props: ['courses'] 数组形式中的每一项就表示要接受的属性名
    props:{
      courses: {
        type: Array,
        default: []
      }
    },
    template:`
      <div>
        <p v-if="courses.length === 0" v-cloak>没有任何课程信息</p>
        <ul v-else>
          <li v-for="course in courses" :key="course" @click="selectCourse(course)"
            :class="{active: selectedCourse === course}">{{course}}</li>
        </ul>  
      </div>
    `
  })
```
```javascript
// 自定义事件
<course-add @add-course="addCourse"></course-add>

Vue.component('course-add',{
    data() {
      return {
        course: ''
      }
    },
    template:`
      <div>
        <input type="text" v-model="course" @keydown.enter="addCourse">
        <button @click="addCourse">新增</button>  
      </div>
    `,
    methods: {
      addCourse() {
        this.$emit('add-course', this.course)
        this.course = '';
      }
    }
  })

  addCourse(course) {
    this.courses.push(course);
  },
```
```javascript
// 自定义组件实现双向数据绑定  
// v-model默认情况下回转换成@input="course=$event"
<course-add v-model="course" @add-course="addCourse"></course-add>

Vue.component('course-add',{
    props: ['value'],
    template:`
      <div>
        <input :value="value" @input="onInput" @keydown.enter="addCourse">
        <button @click="addCourse">新增</button>  
      </div>
    `,
    methods: {
      addCourse() {
        this.$emit('add-course')
      },
      onInpue(e){
        this.$emit('input',e.target.value)
      }
    }
  })
```

### 通过插槽分发内容

子组件修改父组件的变量可用sync代替自定义事件
```javascript
<message :show.sync="isShow">
  新增课程成功!
</message>

@click="$emit('update:show',false)"
```

多个插槽需要使用v-slot来指定对应插槽  
```html
<message :show.sync="isShow">
  <template v-slot:title></template>
  <!-- 不写名字就是默认插槽,默认的具名插槽名就是v-slot:default -->
  <template v-slot:default>新增课程成功</template>
</message>

<!-- 组件 -->
<slot name="title"></slot>
<slot></slot>
```

当子组件的插槽数据不是来自父组件,而是来自组件内部,就需要使用到作用于插槽了
```html
<message :show.sync="isShow">
  <template v-slot:title="slotProps">{{slotProps.title}}</template>
  <!-- 不写名字就是默认插槽,默认的具名插槽名就是v-slot:default -->
  <template v-slot:default>新增课程成功</template>
</message>

<!-- 组件 -->
<slot name="title" title="来自message的标题"></slot>
<slot></slot>
```
 
## Vue常见API

### 数据相关  

1. Vue.set即vm.$set:向响应式对象中添加一个属性,并确保这个新属性同样是响应式的,且触发视图更新`Vue.set(target,propertyName/index,value)`

2. Vue.delete即vm.$delete:删除对象的属性,如果对象是响应式的,确保删除能触发更新视图`Vue.delete(target,propertyName/index)`

### 事件相关  

1. vm.\$on:监听当前实例上的自定义事件,事件可以有vm.$emit触发

2. vm.$emit:触发当前实例上的事件

3. vm.$once:监听一次自定义事件,但只触发一次。一旦触发,监听器就会被移除

4. vm.$off:移除自定义事件,没提供参数移除所有事件,只提供事件,则移除该事件的所有监听器,如果提供了事件和回调,则只移除这个回调的监听器

### 节点引用  

1. ref属性:ref被用来给元素或子组件注册引用信息。引用信息将会注册到父组件的$refs对象上。如果在普通的DOM元素上使用,引用指向的就是DOM元素;如果用在子组件上,引用就指向组件实例
```js
<input ref="inp"></input>
mounted(){
  this.$refs.inp.focus();
}
```
- ref是作为渲染结果被创建的,在初始渲染时不能访问他们.
- $refs不是响应式的,不要试图用它在模板中做数据绑定
- 当v-for用于元素或组件时,引用信息将是包含DOM节点或组件实例的数组

## 过滤器 

过滤器可以用在两个地方:双花括号插值和v-bind表达式中
```js
<div v-bind:id="rawId|formatId"></div>
{{c.price | currency('RMB)}}
// 局部过滤器
filters:{
  currency(value,symbol =  "¥"){
    return symbol+value
  }
}
// 全局过滤器
Vue.filter('currency', function(value,symbol="¥"){
  return symbol + value;
})
```

## 自定义指令  
当需要进行底层DOM操作的时候可以用自定义指令  
```js
<input v-focus/>
// 全局注册
Vue.directive('focus',{
  inserted:function(el){
    el.focus();
  }
})
//局部注册
directives:{
  focus:{
    inserted:function(el){
      el.focus()
    }
  }
}
```
自定义指令的钩子函数:
- bind:只调用一次,指令第一次绑定到元素时调用。在这里可以进行一次性的初始化设置
- inserted: 被绑定元素插入父节点时调用(仅保证父节点存在,不保证插入到文档中)
- update: 所在组件的VNode更新时调用,发生在其子VNode更新之前
- componentUpdated: 指令所在组件的VNode及其子VNode全部更新后调用
- unbind: 只调用一次,指令与元素解绑时调用

钩子函数的参数:
- el: 指令所绑定的元素,可以用来直接操作DOM
- binding: 一个对象,包含一下属性
  - name: 指令名,不包括v-前缀
  - value: 指令的绑定值
  - oldValue: 指令绑定的前一个值,,仅在update和componentUpdated钩子中可用
  - expression: 字符串形式的指令表达式,如v-expression="1+1",表达式为"1+1"
  - arg:传给指令的参数,如v-expression:foo,参数为foo
  - modifiers:一个包含修饰符的对象,如v-directive.foo.bar中,修饰符对象为{foo:true,bar:true}
  - vnode:Vue编译生成的虚拟节点
  - oldVnode:上一个虚拟节点,仅在update和componentUpdated中可用

## 渲染函数
```js
render: function (createElement) {  
  // createElement函数返回结果是VNode    
  return createElement(       
    tag,   // 标签名称        
    data,  // 传递数据        
    children // 子节点数组    
  ) 
}
```

## 函数式组件
如果组件没有管理状态,也不监听任何传递给它的状态,也没有生命周期方法,就可以把组件声明为functional,这意味着它无状态(没有响应式数据),也没有this上下文
```js
Vue.component('heading', {    
  functional: true, //标记函数式组件    
  props: ['level', 'title', 'icon'],    
  render(h, context) { //上下文传参        
    let children = [];        
    // 属性获取        
    const {icon, title, level} = context.props        
    if (icon) {            
      children.push(h(                
        'svg', 
        { class: 'icon' },                
        [h('use', { attrs: { 'xlink:href': '#icon-' + icon } })]))            
        // 子元素获取            
        children = children.concat(context.children)        
    }        
    vnode = h(            
      'h' + level,           
      { attrs: { title } },            
      children       
    )        
    console.log(vnode);       
    return vnode    
  } 
})
```

## 混入  
混入可以分发组件中可复用的功能,一个混入对象可以包含任何组件选项。当组件使用混入对象时,所有混入对象的选项将被"混合"进入该组件本身的选项
```js
// 定义一个混入对象
var myMixin = {
  created: function(){
    this.hello();
  },
  methods: {
    hello(){
      console.log("say hello from mixin");
    }
  }
}
// 定义一个使用混入对象的组件,当组件调用created时,混入对象的created也会被调用
Vue.component("comp",{
  mixins: [myMixin]
})
```

## 插件
插件通常用来为Vue添加全局功能,插件的功能范围一般为:
1. 添加全局方法或属性
2. 添加全局资源:指令/过滤器/过渡等
3. 通过全局混入来添加一些组件选项
4. 添加Vue实例方法,通过把他们添加到Vue.prototype上实现
5. 一个库,提供自己的API,同时提供上面提到的一个或多个功能

插件应该暴露一个install方法,这个方法的第一个参数是Vue构造器,第二个参数是一个可选对象
```js
MyPlugin.install = function(Vue,options){
  Vue.myGlobalMethod = function(){} //添加全局方法或属性
  Vue.directive('my-directive',{}) // 添加全局资源
  Vue.mixin({
    created: function()}{}
  }) // 注入组件选项
  Vue.prototype.$myMethod = function(methodOptions){} // 添加实例方法
}
```

```js
改造heading组件
const MyPlugin = {
  install(Vue,options){
    Vue.component('heading',{
      ...
    })
  }
}

if(typeof window != 'undefined' && window.Vue){
  window.Vue.usw(myPlugin) // 使用Vue.use引入插件
}
```

## vue-cli插件  
在已经创建好的项目中安装一个插件可用`vue add`命令
```
vue add router
```

## 使用css预处理器
```
npm install -D sass-loader node-sass
```
```js
// 自动化导入样式,这样写在src/styles/imports.scss中的样式就可以自动导入了
npm i -D style-resources-loader 

// vue.config.js
const path = require('path')
function addStyleResource(rule) {    
  rule.use('style-resource')        
      .loader('style-resources-loader')        
      .options({        
        patterns: [            
          path.resolve(__dirname, './src/styles/imports.scss'),        
        ],    
      }) 
}
module.exports = {    
  chainWebpack: config => {        
    const types = ['vue-modules', 'vue', 'normal-modules', 'normal']        
    types.forEach(type => addStyleResource(config.module.rule('scss').oneOf(type)))    
  },
}
```
## Scoped CSS

当style标签有scoped属性时，它的CSS只作用于当前组件中的元素  
```html
<!-- scoped的原理是通过POSTCSS来实现的 -->
<template> 
  <div class="red" data-v-f3f3eg9>hi</div> 
</template>
<style>
.red[data-v-f3f3eg9] {
   color: red; 
}
</style>
```
在父级组件中控制子级组件的scoped样式，那么父组件也要卸载scoped中（仅限根元素）

父组件要穿透控制子组件的scoped样式，可用>>>符号
```html
<style scoped>
  #app >>> a{
    color: red;
  }
</style>
<!-- sass等预处理器可能没法解析>>>符号，可用/deep/或：：v-deep代替 -->
<style lang="sass" scoped>
  #app{
    /deep/ a{
      color: rgb(196,50,140)
    }
    ::v-deep a{
      color: rgb(196,50,140)
    }
  }
</style>
```

## CSS Module
vue-loader提供了与CSS Modules的一流集成  
```html
<style module lang="scss">
  .red{
    color: #f00;
  }
  .bold{
    font-weight: bold;
  }
</style>

<!-- 模板中通过$style.xx访问 -->
<a :class="$style.red">aaa</a>
<a :class="{[$style.red]:isRed}">aaa</a>
<a :class="[$style.red,$style.bold]">aaa</a>
```
```js
// 在注明module的style标签同一个模块下
console.log(this.$style.red)
```
## 数据模拟和代理  
```js
// 数据模拟
devServer:{    
  before(app) {        
    app.get('/api/courses', (req, res) => {           
      res.json([{ name: 'web全栈', price: 8999 }, { name: 'web高级', price: 8999 }])        
    })    
  } 
}

import axios from 'axios'
export function getCourses() {  
  return axios.get('/api/courses').then(res => res.data) 
}
```
```js
// 代理
devServer: {    
  proxy: 'http://localhost:3000' 
}
```

## 路由

### 路由基础
```html
<!-- to属性指定链接，<routerLink>默认会被渲染成a标签 -->
<routerLink to="/"></routerLink>
<routerLink to="/bar"></routerLink>

<!-- 路由匹配到的组件将渲染到这里 -->
<routerView></routerView>
```
```js
// 导入组件
import Home from "@/components/home.vue"
import Admin from "@/components/admin.vue"

// 定义路由配置
const routes = [
  {path: '/home',component: Home},
  {path: '/admin',component: Admin}
];

// 创建路由实例
const router = new VueRouter({
  routes
})

const app = new Vue({
  router
}).mount("#app")
```

### 动态路由参数
当需要把某种模式匹配到的所有路由，全部映射到同个组件，这个时候就可以在路由路径中使用”动态路径参数”
```js
{path:'/user/:id',component:User}
```

### 命名路由
用名称来标识路由，可以在跳转的时候给路由设置配置参数
```js
<router-link :to="{ name: 'user', params: { userId: 123 }}">User</router-link>
router.push({ name: 'user', params: { userId: 123 }})
```

### 通配符路由
通配符路由会匹配所有路径，当前面的路径都没有匹配到的时候，就会启用通配符路由
```js
{
  path: '*',
  component: () => import('../views/404.vue')
}
```

### 嵌套路由

如果组件之间有嵌套关系，那么路由配置中最好也要体现出来
```js
{
  path: '/admin',
  name: 'admin',
  // route level code-splitting
  // this generates a separate chunk (about.[hash].js) for this route
  // which is lazy-loaded when the route is visited.
  component: () => import(/* webpackChunkName: "about" */ '../views/Admin.vue'),
  children: [
    {
      path: '/admin/course/:name',
      name: 'detail',
      component: () => import('../views/Detail.vue')
    }
  ]
},
```

### 编程导航
`router.push(location,onComplete?,onAbort?)`
```js
// 字符串 
router.push('home')
// 对象 
router.push({ path: 'home' })
// 命名的路由 
router.push({ name: 'user', params: { userId: '123' }})
// 带查询参数，变成 /register?plan=private 
router.push({ path: 'register', query: { plan: 'private' }})
```
响应路由参数变化
```js
watch: {
  $route:{
    immediate: true,
    handler: ()=>{
      console.log('路由参数变化')
    }
  }
}
```

### 路由守卫
路由守卫主要是通过跳转或者取消的方式守卫路由，植入路由守卫的方式有
1. 全局守卫
2. 单个路由独享
3. 组件级的

```js
// 全局守卫beforeEach
{
  path: '/admin',
  name: 'admin',
  component: () => import(/* webpackChunkName: "about" */ '../views/Admin.vue')，
  meta: {
    auth: true
  }
router.beforeEach((to,from,next) => {
  // 判断路由是否需要守卫 方式：1.meta数据
  if(to.meta.auth){
    // 判断是否登录
    if(window.isLogin){
      next(); // 登录就放行
    }else{
      next('/login?redirect='+to.fullPath); // 没有登陆就跳转到登陆页面
    }
  }else{
    next()
  }
})
// 单个路由独享beforeEnter
{
  path: '/admin',
  name: 'admin',
  component: () => import('../views/Admin.vue'),
  beforeEnter(to,from,next){
    // 判断是否登录
    if (window.isLogin) {
      next(); // 登录就放行
    } else {
      next('/login?redirect=' + to.fullPath); // 没有登陆就跳转到登陆页面
    }
  }
},
// 组件级守卫
// beforeRouteEnter
// beforeRouteUpdate
// beforeRouteLeave
// 在组件内部添加这几个方法 
```
### 数据获取时机

当路由激活时，获取数据的时机有2个
```js
// 路由导航前

// 组件未渲染，通过给next传递回调访问组件实例 
beforeRouteEnter (to, from, next) {    
  getPost(to.params.id, post => {        
    next(vm => vm.setData(post))    
  }) 
},
// 组件已渲染，可以访问this直接赋值 
beforeRouteUpdate (to, from, next) {    
  this.post = null    
  getPost(to.params.id, post => {        
    this.setData(post)        
    next()    
  }) 
},
```
```js
// 路由导航后
created () {    
  this.fetchData() 
}, 
watch: {    
  '$route': 'fetchData' 
}

```

### 动态路由

通过`router.addRoutes(routes)`方式动态添加路由
```js
router.beforeEach((to,from,next)=>{
  if(window.isLogin){
     this.$router.addRoutes([        
      {            
        path: "/about", //...        
      }    
    ])
  }
})
```
### 组件缓存
可用`keep-alive`来让组件缓存  
include属性可指定需要缓存的组件（组件需要设置name属性）  
exclude属性可指定不要缓存的组件（组件需要设置name属性）  
max属性可指定最大缓存组件个数，达到最大缓存个数，最老的组件会队列  
keep-alive会有两个特别的生命周期，activated和deactivated

## Vuex
![images](https://vuex.vuejs.org/vuex.png)
### State
应用的全局状态应定义在state中
```js
state:{
  isLogin: false
}
```
### Mutation
修改state只能通过mutation
```js
mutations: {
  login(state){
    state.isLogin = true;
  },
  logout(store){
    state.isLogin = false;
  }
}
```
### Action
Action类似于mutation,不同在于:
- action提交的是mutation,而不是直接修改状态
- action可以包含任意异步操作
```js
actions: {
  // 参数1是vuex传递的上下文context:{commit,diapatch,state}
  login({commit},username){
    // 模拟了登录api调用,1s后如果用户名是admin则登录成功
    return new Promise((resolve,reject) => {
      setTimeout(()=>{
        if(username === 'admin'){
          commit('login')
          resolve()
        }else{
          reject()
        }
      },1000)
    })
  }
},
// 触发
this.$store.dispatch('login','admin').then(() => {
  if(this.$route.query.redirect){

    this.$router.push(this.$route.query.redirect)
  }else{

    this.$router.push('/')
  }
}).catch(()=>{
  console.log('用户名或密码错误')
})

```
### 模块化
将vuex的内容单独分到一个js中,然后加上namespace属性,最后在index.js中的module中配置该子模块vuex

### 映射
通过映射mapState/mapMutations/mapActions可以避免直接对$store访问,少敲几个字

### 派生状态
可以使用getters从store的state中派生出一些新的状态

### 严格模式
严格模式下，无论何时发生了状态变更且不是由 mutation 函数引起的，将会抛出错误
```js
const store = new Vuex.Store({  
  // ...  
  strict: true 
})
```
