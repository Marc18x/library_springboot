# SpringBoot 图书管理系统

## 1.测试QAdmin框架
### 1.1 修改src目录 使用thymeleaf模板引擎

修改引用文件路径，使用th:href和th:src标签代替原有路径，注意修改为绝对路径，确保能读取到文件

### 1.2 测试导航目录的使用方法 配置js文件和对应路径
问题说明：如果springboot设置文件根目录地址非/，而指定了具体的，比如/library
则需要在layui中使用页面跳转时，注意菜单的目录设置，其中两个地方：
* 修改config.js中menuUrl，将地址改为绝对路径，修改为格式：/library/data/menu.json
* 修改script.js中的首页url，也改为绝对地址

### 1.3 使用layui的数据表格，学习数据表格中添加按钮并绑定事件
详细参考layui开发文档

## 2.Thymeleaf使用
### 2.1 使用thymeleaf获取根目录地址

```javascript
var ctxPath  = [[@{/}]];
```

###2.2 layui和thymeleaf冲突
在使用表格模板时产生冲突，将[[]]拆成四行即可

## 问题说明
### location.href地址跳转问题需要再次测试