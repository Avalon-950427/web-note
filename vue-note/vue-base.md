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

## 条件渲染

v-if 当值为真值时渲染内容,v-else-if 必须紧跟在 v-if 后面,v-else 必须紧跟在 v-if 或 v-else-if 后面  
v-if 可用在 template 上来分组切换  
key 值可以确保元素是独立的,不需要复用  
v-show 只是切换 display 属性

## 列表渲染

v-for 需要用`item in items`语法,item 是当前值的别名,items 是源数据

#### 在 v-for 中使用对象

```
v-for="(value,key,index) in object"
```

###### 变更方法

变更方法会变更调用了这些方法的原始数组,会触发视图更新:push,pop,shift,unshift,splice,reverse,sort

非变更方法想要修改原数组就要重新对其赋值

## 事件处理

在 vue 中调用内联 js 方法是可以传\$event 来获取事件对象

```
<button @click="say('hi',$event)></button>
say(msg,event){
  ...
}
```

#### 事件修饰符

- stop
- prevent
- capture
- self
- once
- passive: 在滚动结束后才会触发事件,相当于 lazy

#### 按键修饰符

在监听键盘事件时指定特定的按键

- .enter
- .tab
- .delete
- .esc
- .space
- .up
- .down
- .left
- .right

自定义按键修饰符别名`Vue.config.keyCodes.f1 = 112`

#### 系统修饰键

- .ctrl
- .alt
- .shift
- .meta

.exact 能精确控制系统修饰符组合触发的事件

```html
<!-- 有且只有ctrl被按下才能触发 -->
<button v-on:click.ctrl="onclick"></button>
<!-- 没有任何系统修饰符被按下才能触发 -->
<button v-on:click.exact="onclick"></button>
```

鼠标按键修饰符:

- .left
- .right
- .middle

## 表单输入绑定

v-model: 在 input,textarea,select 元素上创建双向数据绑定,会忽略表单元素的 value,checked,selected 属性初始值

```
//当只有一个复选框的时候,v-model会把绑定值转换为true或false
<input type="checkbox" v-model="a" />
data:{
  a: 0
}
//当有多个复选框时,需要增加value属性,且绑定值的数据类型为数组
<input type="checkbox" value="zcw" v-model="names" />
<input type="checkbox" value="ll" v-model="names" />
data: {
  names: []
}
```

```
<input type="radio" value="one" v-model="picked" />
<input type="radio" value="two" v-model="picked" />
data: {
  picked: ''
}
```
