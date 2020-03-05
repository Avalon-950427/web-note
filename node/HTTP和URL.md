## HTTP 模块

```javascript
var http = require('http'); //表示引入http模块
//http.createServer表示创建服务
//request表示获取客户端传过来的信息
//response表示给浏览器响应信息
http
  .createServer(function(request, response) {
    //设置响应头
    response.writeHead(200, { 'Content-Type': 'text/plain' });
    //表示给页面输出一句话并且结束响应
    response.end('Hello World');
  })
  .listen(8081);

console.log('Server running at http://127.0.0.1:8081/');
```

响应头里的字符编码需要和 html 的字符编码一致才不会出现乱码的现象

## URL 模块

```javascript
const url = require('url'); //获取url模块
let api = 'http://www.baidu.com?name=Avalon&age=26';
console.log(url.parse(api), true); //解析url中的参数
```

url.parse()的第二个参数如果传 true,那么 query 参数将返回为一个对象

## supervisor 自启动工具

supervisor 会不停的监听应用下面的所有文件,一旦文件被修改,就会重新载入程序文件以实现重新部署

```node
npm install -g supervisor
```

```node
supervisor 文件名//用supervisor启动服务
```

电脑有时不信任 supervisor 脚本,用 supervisor 命令会报错,此时以管理员身份打开 powershell 并输入`set-ExecutionPolicy RemoteSigned`选择 yes 即可
