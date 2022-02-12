# EAM固定资产设备管理系统
- 实现企业对资产的基本管理,包含对资产的登记、维修、调拨、转移等基本功能的支持，并提供对资产的耗材、库存进行管理，有完善的组织架构，非常适合中小企业的需求
- EAM系统整体覆盖了基本的资产管理、合同管理、运维服务、运维服务、数据中心设备管理等多个模块。

# 技术栈
- 后端基于SpringBoot
- 前端基于LayUi

### 联系方式
- QQ群:634770774


### 系统DEMO
- [demo] http://eam-demo.rainbooow.com:26788/index.html
- [demo] admin 密码:123456

### 其他资源
- SQL文件下载地址(每日更新):http://121.43.103.102/upload/sql.tar.gz
- EAM安装手册:在EAM项目的文档目录
- EAM使用手册:登录系统后,选择公共服务下的公共资源菜单->EAM使用手册
  或者访问如下地址: http://eam-demo.rainbooow.com:26788/business/eam/user_book/user_book.html?v=20211125010911443c1
- [Foxnc-Web 文档 ](https://gitee.com/LeeFJ/foxnic-web/wikis/pages) https://gitee.com/LeeFJ/foxnic-web/wikis/pages

## 安装部署(Docker)
- 系统兼容说明
- 注意点:建议第一次docker部署完后，在重启一次，可能第一次启动数据库初始化还没完成，会导致报错
 | 应用镜像   |   移动端 |
 | ---------- | ----------- |  
 | 1.0.2      | 暂不支持    |
 | 1.0.5      | 暂不支持    |
- 部署步骤
```
  其中镜像中1.0.5为版本号,替换相对于版本即可。
  $docker run --name eamapp -t \
    -e MYSQL_USER="eam" \
    -e MYSQL_PASSWORD="eam_pwd" \
    -e MYSQL_ROOT_PASSWORD="root_pwd" \
    -v /d/mysql:/var/lib/mysql  \
    -p 3307:3306 \
    -p 8089:8089 \
    -d docker.io/algernonking/eamapp:1.0.5 \
    --character-set-server=utf8
```

## 项目结构说明
 ![输入图片说明](https://images.gitee.com/uploads/images/2021/0610/145855_29614033_1470521.png "屏幕截图.png")
#### 安装教程
 Maven项目，支持 Eclipse 和 IDEA 开发。
#### 使用说明
 1. 新建表或表结构调整后(包括注释)，执行 generator 项目下的 EamDbMetaGenerator 类的 main 函数，将表结构映射到 java 代码。执行后，domain 项目的 EAMTables 类代码将被刷新。
 2. 必要时执行 generator 项目下的 EamEnumGenerator 类的 main 函数，该类用于生成字典枚举等，请按项目按需调整。执行后，在 domain 项目下 com.dt.eam.constants.enums 包下生成枚举类型的代码。
 3. 这里是列表文本执行 generator 项目下的 EamCodeGenerator 生成模块代码。执行后，
- domain 项目下的实体代码将被按照数据库结构重新生成；
- proxy 项目下生成对应的 Proxy 类；
- 在 service 项目生成对应的控制器，接口以及接口实现类；
- 在前端项目生成页面控制器(前端模版引擎 thymeleaf)，列表页面和表单页面
  **如重复执行，请在 EamCodeGenerator 类的代码生成逻辑中加入文件覆盖策略。** 
　4. 调整 MenuGenerator 的代码，生成对应的菜单，并将菜单授权给 admin 角色，建议一次生成一组菜单，菜单生成后，会输出batchId，如果撤销可以调用 removeByBatchId 方法即可。
 以上步骤因为调用main函数生成代码，开发工具并不能立即刷入，如果是Eclipse，请刷新项目。IDEA正常情况下会自动刷入，建议也刷新一下 relaod from disk 。
 :point_right: **注意：代码生成的逻辑，需要按照上面提到的类中给出的示例按需调整。** 

## 项目预览
![输入图片说明](https://images.gitee.com/uploads/images/2021/1213/212929_46438369_448530.jpeg "1.jpg")
![输入图片说明](https://images.gitee.com/uploads/images/2021/1213/213230_1ba469f5_448530.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/1213/213258_8d970535_448530.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/1213/213315_83659719_448530.png "屏幕截图.png")

## 捐赠
- 开源不易，坚持更难！如果您觉得本项目不错，可以捐赠请作者喝杯咖啡~，在此表示感谢^_^
- 同时欢迎EAM系统的商业化定制,也欢迎其他相关业务的开发合作。
- 捐赠(支付宝)
<img width="200" height="200" src="https://images.gitee.com/uploads/images/2020/1105/135552_037eeb5c_448530.png" />

 
 