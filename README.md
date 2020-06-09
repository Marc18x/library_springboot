# SpringBoot 图书管理系统-学习笔记
框架：SpringBoot + Mybatis + layui

## 1.测试QAdmin框架
### 1.1 修改src目录 使用thymeleaf模板引擎

修改引用文件路径，使用th:href和th:src标签代替原有标签，注意修改为绝对路径，确保能读取到文件

### 1.2 测试导航目录的使用方法 配置js文件和对应路径
问题说明：如果springboot设置文件根目录地址非/，而指定了具体的，比如/library
则需要在layui中使用页面跳转时，注意菜单的目录设置，其中两个地方：
* 修改config.js中menuUrl，将地址改为绝对路径，修改为格式：/library/data/menu.json
* 修改script.js中的首页url，也改为绝对地址

### 1.3 使用layui的数据表格，学习数据表格中添加按钮并绑定事件
详细参考layui开发文档
使用field和json数据解析值并填写到表格
用HTML模板生成操作按钮
监听工具条 layEvent 按钮绑定事件

### 1.4 layui 分页page实现
分页查询数据时，向后台提交page和limit两个参数
controller对page和limit做对应查询响应，修改原有查询函数即可

### 1.5 数据表格全局查询及表格重载reload
当界面数据发生改变的时候，通过reload函数可以刷新数据表格页面，并对其中的参数进行修改，reload第一个参数指定id，第二个传入修正参数

### 1.6 form提交时 alert和reload冲突问题
将submit和cancel的按钮移出form标签,自定义两个按钮的onclick事件
提交完成后，先弹出msg然后再reset表单即可
重置按钮，直接reset表单

```javascript
   layer.msg("添加成功")
   document.getElementById("addBook").reset();  //表单重置   
```
如果是页面跳转的情景，可以设置延迟
```javascript
layer.msg('提交成功！');
setTimeout(function () {
    window.location.href="index";
   }, 3000); //延迟三秒后再刷新
```
或者绑定按钮事件，弹出窗口，当用户点击确认后再跳转

## 2.Thymeleaf使用
### 2.1 使用thymeleaf获取根目录地址

```javascript
var ctxPath  = [[@{/}]];
```

### 2.2 layui和thymeleaf冲突
在使用表格模板时产生冲突，将[[]]拆成四行即可

## 3.JS
### 3.1 使用ajax提交表单数据
直接用ajax的serializeArray()将表单数据序列化，然后传递给controller，确保name和value对应
controller可以自动把提交的json格式的数据转化为对象（但是记得先对model类预先Serialize)

## 4. MyBatis
### 4.1 Mapper传参设置param别称，则在mybatis的xml文件中无需再声明paramType
如果你使用了@Param这个传参的话，就不用再写paramType的类型了
类的话，用了param就直接用别称就可以，否则直接按属性来算

### 4.2 ResultMap和ResultType区别
map可以自定义查询输出封装内容，而type必须是指定的类，将查询结果完整封装
map多使用在连接查询的时候，或者只需要一个表的部分变量


## 5.权限鉴定 拦截器设置


## 问题说明
### location.href地址跳转问题需要再次测试

### 打印ajax JSON解析form表单出现[object Objecy]的错误
修改方法：使用JSON.stringify(data)进行转化即可显示，但是传值的时候还是用serializeArray()即可

### ajax传参 data中key需要加引号表示string

### th标签传入数据，input类型的一般对应是th:value,而textarea对应的是th:text标签

### JS：var name = '${name}';这样子便可以 直接获取到在ModelAndView中绑定的name属性