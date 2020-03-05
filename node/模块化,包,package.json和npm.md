## 模块化

Node 中,模块分为 2 类:

1.  核心模块:内置模块,在 node 进程启动时,就内加载进内存中.
2.  文件模块:即自定义模块;在运行时动态加载,需要完成路径分析,文件定位和编译执行过程.
    <!--###### CommonJs中自定义模块的规定-->
    <!--<font color="red">1. 抽离公共部分为独立的一个js文件作为一个模块,默认情况下这个模块里的方法和属性是能被外部访问的,要想让外部文件访问模块中的方法和属性,需用exports或module.exports暴露属性或方法</font>  -->
    <!--<font color="red">2. 在需要这些模块的文件中,通过require方法引入这个模块,这时候就可以使用模块里暴露的方法和属性</font>-->

在 CommonJS 中,module 变量代表当前模块,它的 exports 属性是对外的接口
require 方法用记载模块

###### CommonJS 的特点

- 所有代码都运行模块作用域中,不会污染全局作用域
- 模块可多次加载,但只在第一次加载时运行一次,后面都是从缓存中读取;想让模块重新运行,必须清除缓存
- 模块的加载顺序是按照在代码中的出现顺序来加载

###### module 对象

Node 内部提供一个 Module 构建函数,所有模块都是 Module 的实例

```javascript
function Module(id,parent){
    this.id = id;
    this.exports = {};
    this.parent = parent;
    ...
}
```

module.id:模块的识别符(带绝对路径的模块文件名)  
module.filename:模块的文件名,带绝对路径  
module.loaded:返回表示模块是否加载完的布尔值  
module.parent:返回调用该模块的模块对象

```javascript
if(!module.parent){
    //检测该模块是否为入口文件
    ...
}
```

module.children:返回该模块用到的模块数组  
module.exports:表示模块对外的输出接口,其他文件加载该模块,其实是读取 module.exports 变量

exports 和 module.exports 的区别:

- module.exports 初始值为空对象
- exports 指向 module.exports 的引用
- require()返回的是 module.exports 而不是 exports

###### node_modules

如果自定义模块放在 node_modules 文件夹下,且入口文件为 index.js,那么可以直接通过文件名`require('文件名')`来引入模块,但若果入口文件不是 index.js,则会报错,此时如有 package.json,则会去找 main 字段对应的入口文件

## 包

node 中的第三方模块由包组成  
![image](<images/1583238101(1).png>)

包目录的组成:

- package.json:包的配置文件
- bin:存放可执行的二进制文件的目录
- lib:用于存放 js 代码的目录
- doc:用于存放文档的目录

## npm

npm 是 node 的包管理工具

```node
npm init --yes // 初始化项目目录,为项目生成package.json文件
```

```node
npm i 包名 --save
//--save的意思是降依赖写入到package.json中得的dependencies
//dependencies中的版本号如"^2.3.1":^表示第一位不变,后面2位取最新的;~表示前2位不变,最后一位取最新的;*表示全部取最新的;没有符号表示就指定这个版本
npm i 包名 --save-dev
// 将依赖写入到devDependencies中
```

```node
npm uninstall 模块名 // 卸载模块
```

```node
npm list // 列出项目中所有的包
```

```node
npm info 模块名 // 查看模块的版本
```

```node
npm install 包名@版本号 // 指定安装包的版本
```
