## Vue 实例

#### 创建 vue 实例

```js
var vm = new Vue({});
```

#### 数据与方法

vue 实例会将 data 对象全部添加到响应式系统中,且只有在实例被创建时就在 data 中的属性才是响应式的

```js
var data = {a:1}
var vm = new Vue({
  data: data
})
vm.a == data.a // true
vm.b='hi', // 不会触发视图更新
```

Object.freeze()会冻结对象,使其不能再响应式变化

Vue 暴露了实例属性与方法,以\$开头,如\$data,\$el,\$watch 等

#### 生命周期

生命周期函数的 this 指向 Vue 实例,生命周期函数不能用箭头函数,否则 this 会错乱

## 模板语法

#### 插值

###### 文本插值

Mustache 语法会将属性插入到结构中,并且会响应式的更改  
想要不响应式更改,可用 v-once 指令

```html
<span>Message:{{msg}}</span>

<span v-once>这个将不会改变:{{msg}}</span>
```

###### HTML 插值

v-html 可将数据解释为 html 代码

```js
<p v-html="rawHtml"></p>
```

###### HTML 属性插值

对 html 属性插值应用 v-bind 指令,并且值为布尔类型的属性在 false 下不渲染

###### 用 js 插值

在模板中可用 js 表达式进行插值  
模板表达式中只能访问白名单中的全局变量,不能访问用户定义的全局变量

```html
{ { ok ? 'yes' : 'no' } }

<div v-bind:id="'list'+id"></div>
;
```

#### 指令

指令是在表达式值发生改变时,响应式的作用到 DOM 上

```html
<p v-if="seen"></p>
```

###### 指令参数

指令后面可加一个参数

```html
<a v-bind:href="url"></a>

<a v-on:click="doSomething"></a>
```

指令参数可用[]包裹作为动态参数,[]中的内容作为 js 表达式解析,且动态参数不能有引号和空格

```html
<a v-on:[eventName]="doSomething"></a>
```

###### 修饰符

修饰符是在事件名后加.修饰符的方式添加

## 计算属性和侦听器

#### 计算属性

```js
computed:{
  reverseMessage(){
    return this.message.split('').reverse().join('')
  }
}
```

###### 计算属性 vs 方法

计算属性依赖于响应式注入,只要响应式注入不发生改变,计算属性不会再次执行,而是获取缓存  
方法则会每次渲染都去执行

###### 计算属性的 setter

默认情况下只有 getter 函数,没有 setter 函数,修改依赖也只会触发 getter,当指定了 setter 函数后,修改依赖按顺序触发 setter,getter 和 updated

#### 侦听器

通常情况下用计算属性足够,但是当数据变化时执行异步或者开销大的操作可用侦听器

## Class 与 Style 绑定

#### Class 绑定

###### 对象语法

- class 绑定的对象语法是否绑定取决于对象属性的真值
- v-bind:class 可与普通 class 属性共存

```html
<div class="static" v-bind:class="classObject"></div>
data:{ classObject:{active:isActive,'text-danger':hasError} }
```

###### 数组语法

- 数组语法是将数组中的属性值作为 class 属性的值

```html
data:{ activeClass: 'active' errorClass: 'text-danger' }
<div :class="[activeClass,errorClass]"></div>

<div :class="[isActive?activeClass:'',errorClass]"></div>

<div :class="[{activeClass:isActive},errorClass]"></div>
```

#### Style 绑定

style 动态绑定会根据浏览器自动添加前缀

###### 对象语法

- Style 的对象语法是将 data 中的属性的值绑定上去的

```html
data:{ activeColor: 'red', fontSize: 30 }
<div :style="{color:activeColor,fontSize:fontSize}"></div>
```

```html
data: { styleObject: { color: 'red', fontSize: '13px' } }
<div v-bind:style="styleObject"></div>
```

###### 数组语法

- 数组语法可将多个样式对象绑定到同一个元素上

```html
<div v-bind:style="[baseStyles,overridingStyles]"></div>
```

###### 多重值

- 可为 style 绑定中的属性提供一个或多个值的数组

```html
<div :style="{ display: ['-webkit-box', '-ms-flexbox', 'flex'] }"></div>
```
