## fs 模块

#### fs.stat()检测文件还是目录

```javascript
fs.stat('../fs_demo', (err, data) => {
  if (err) {
    console.log(err);
    return;
  }
  console.log(`是文件:${data.isFile()}`);
  console.log(`是目录:${data.isDirectory()}`);
});
```

stat()接受 2 个参数:

- 要检测的文件名或目录名
- callback,第一个参数是错误时的错误对象,第二个参数是检测的返回值,可调用 isFile()和 isDirectory()来检测是文件还是目录

#### fs.mkdir()创建目录

```javascript
fs.mkdir('./css', err => {
  if (err) {
    console.log(err);
    return;
  }
  console.log('创建成功');
});
```

mkdir()接受 3 个参数:

- 将创建的目录的路径及名字
- 目录权限(读写权限),默认是 777
- callback,传递异常参数 err

#### writeFile()写入文件

```javascript
fs.writeFile('index.html', '你好nodejs', err => {
  if (err) {
    console.log(err);
    return;
  }
  console.log('创建写入成功');
});
```

writeFile()接受 4 个参数:

- 创建并写入的文件名,若文件名存在,则直接替换
- 写入文件的字符串
- options 可省略
  - encoding,默认为'utf8'
  - mode 文件读写权限
  - flag 默认值'w'
- callback,传递异常参数 err

#### appendFile()追加文件

```javascript
fs.appendFile('./css.base.css', 'body{color: red}', err => {
  if (err) {
    console.log(err);
    return;
  }
  console.log('appendFile 成功');
});
```

appendFile()接受 4 个参数: - 要追加的路径及文件名,若文件名不存在,则创建文件 - 要追加的字符串 - options - callback,传递异常参数 err

#### readFile()读取文件

```javascript
fs.readFile('./index.html', (err, data) => {
  if (err) {
    console.log(err);
    return;
  }
  console.log(data);
  console.log(data.toString()); //将Buffer数据转换为字符串
});
```

readFile()接受 2 个参数:

- 要读取的文件名
- callback,传递错误对象 err 和 Buffer 数据流

#### readdir()读取文件夹

```javascript
fs.readdir('./css', (err, data) => {
  if (err) {
    console.log(err);
    return;
  }
  console.log(data);
});
```

readdir()接受 3 个参数

- 要读取的文件夹的路径
- options
- callback,传递错误参数 err 和读取的数据 data

#### rename()重命名且移动路径

```javascript
fs.rename('index.html', './css/app.html', err => {
  if (err) {
    console.log(err);
    return;
  }
  console.log('重命名成功');
});
```

rename()接受 3 个参数:

- 要重命名的文件路径
- 命名后的路径
- callback,传递错误参数 err

#### unlink 删除文件

```javascript
fs.unlink('./css/app.html', err => {
  if (err) {
    console.log(err);
    return;
  }
  console.log('删除文件成功');
});
```

unlink()接受 2 个参数:

- 要删除的文件的路径
- callback,传递错误参数 err

#### rmdir 删除文件夹(必须先删除里面的文件)

```javascript
fs.rmdir('./css', err => {
  if (err) {
    console.log(err);
    return;
  }
  console.log('删除目录成功');
});
```

rmdir()接受 2 个参数:

- 要删除的目录路径
- callback,传递错误参数 err

#### demo

```javascript
// 判断服务器上有没有upload目录,没有创建,有不做操作
const path = 'upload';
fs.stat(path, (err, data) => {
  if (err) {
    mkdir(path);
  }
  if (data.isDirectory()) {
    console.log('存在');
  } else {
    // 如果upload是文件则首先删除upload文件再创建upload文件夹
    fs.unlink(path, err => {
      if (err) {
        console.log(err);
      } else {
        mkdir(path);
      }
    });
  }
});

function mkdir(dir) {
  fs.mkdir(dir, err => {
    if (err) {
      console.log(err);
      return;
    }
    console.log('创建成功');
  });
}
```

```javascript
// wwwroot文件夹下面有images css is以及index.html,找出wwwroot目录下面所有的目录,并放在一个数组中
const path = './wwwroot';
var arr = [];
fs.readdir(path, (err, data) => {
  if (err) {
    console.log(err);
    return;
  }
  (function getDir(i) {
    if (i == data.length) {
      console.log(arr);
      return;
    }
    fs.stat(`${path}/${data[i]}`, (err, status) => {
      if (err) {
        console.log(err);
      } else {
        if (status.isDirectory()) {
          arr.push(data[i]);
        }
      }
      getDir(i + 1);
    });
  })(0);
});
```
