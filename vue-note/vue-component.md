## 组件注册

```
Vue.component("组件名",{
  data:function(){
    return {

    }
  },
  template:'',
  ...
})
```

组件的 data 属性值是一个函数

#### 组件名

组件名:

1. 使用短横线分隔命名
2. 使用驼峰命名,打在 DOM 上使用还是得转为短横线命名

#### 全局注册

通过`Vue.component()`创建的组件是全局组件,当全局组件创建后,可以用在任何 Vue 实例中

#### 局部注册

```
var ComponentA = {};
new Vue({
  el: "#app",
  components: {
    'component-a', ComponentA
  }
})
```

components 对象中的属性名才是自定义元素的名字  
局部组件在其子组件中不可用,除非再把局部组件注册到子组件的 components 对象中

#### 通过 prop 向子组件传递数据

prop 是你可以在组件上注册的一些自定义属性,当一个值传递给一个 prop attribute 时,就会变成那个组件实例的一个 property

```
<blog-post title="zzz"></blog-post>
Vue.component('blog-post',{
  props: ['title'],
  template: '<h3>{{title}}</h3>'
})
```

**组件模板的根元素有且只有一个**

#### 监听子组件事件

子组件可以通过`$emit(事件名)`来触发父组件上的同名事件,子组件触发事件时抛出的值保存在\$event 中(在行内写事件)

```
<blog-post title="zzz" v-on:post="console.log($event)"></blog-post>
Vue.component('blog-post',{
  props: ['title'],
  template: '<h3 @click="$emit(post,1)">{{title}}</h3>'
})
```

#### 在组件上使用 v-model

```
<input v-model="searchText">
```

等价于:

```
<input
  v-bind:value="searchText"
  v-on:input="searchText = $event.target.value"
>
```

```
<custom-input
  v-bind:value="searchText"
  v-on:input="searchText = $event"
></custom-input>
等价于
<custom-input v-model="searchText"></custom-input>

Vue.component('custom-input',{
  props:['value'],
  v-on:input="$emit('input',$event.target.value)
})
```
