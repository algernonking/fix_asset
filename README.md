# EAM管理系统介绍
- 实现企业对资产的基本管理,包含对资产的登记、维修、调拨、转移等基本功能的支持，并提供对资产的耗材、库存进行管理，有完善的组织架构，非常适合中小企业的需求
- EAM系统整体覆盖了基本的资产管理、合同管理、运维服务、运维服务、数据中心设备管理等多个模块。

### 系统DEMO
- [Demo] 每天定时由阿里云效自动编译发布部署
- [Demo] http://eam-demo.rainbooow.com:26788/index.html
- [Demo] 账户:admin 密码:123456；其它账户密码 为 fx9090

#### 最新EAM编译后的包下载(为开发同步版本，并非发布版本)
- 1、存储过程:[下载SQL](http://foxnicweb.com/docs/chapters/base/1.1/NextVal.zip)
- 2、SQL文件:(每日更新):http://eam-demo.rainbooow.com/upload/sql.tar.gz
- 3、EAM编译包:(自动更新):http://eam-demo.rainbooow.com/upload/eam.tar.gz

### 联系方式
- 1、QQ群:634770774 
- 2、微信号:myxyjm
- 3、微信群：      
![微信群](eam/view/view-console/src/main/resources/static/assets/images/wx.png)

### 主要技术栈
#### 后端技术栈
- 安全框架:Spring Security 5.3.4
- 开发框架:SpringBoot 2.3.3
- 数据库链接池:Druid 1.2.8
- 模版引擎:Thymeleaf 3
- 应用层框架:[Foxnic-Web](https://gitee.com/LeeFJ/foxnic-web) [开发文档](http://foxnicweb.com/docs/doc.html)
- 持久层框架:[FoxnicSQL&FoxnicDAO](https://gitee.com/LeeFJ/foxnic)
- 日志管理:Logback 1.2.3
- 流程引擎:Camunda
- 任务调度:Quartz 2.3.3
- 项目管理框架: Maven 3.6、3.8
- 运行容器:Undertow

#### 前端技术栈
- 前端组件:LayUI 2.6.8

#### 开发环境
- IDE:IntelliJ IDEA 2020.2以上
- JDK:JDK 1.8.100 (小版本100以上,但仅支持1.8)
- 数据库:Mysql 5.7.X、8.0
- Redis:5.1(可选)

#### 系统架构图
![输入图片说明](https://images.gitee.com/uploads/images/2022/0407/143343_0a8f4947_448530.png "EAM.png")

## EAM系统开源协议补充申明
- 1、EAM系统产品开源免费(协议:GPLv3)，并且将持续提供免费的社区技术支持，个人或企业内部可自由的接入和使用，但禁止任何单位或个人修改软件后再次发行或出售的行为
- 2、EAM系统源代码已开源，软件介质以社区版形式供免费使用,在未授权情况下，禁止修改涉及版权信息的相关代码和名称


## EAM系统使用帮助
### 帮助文档
- EAM安装手册:在EAM项目的相关文档目录
- EAM使用手册:在EAM项目的相关文档目录
- 应用框架[Foxnic-Web](https://gitee.com/LeeFJ/foxnic-web) [开发文档](http://foxnicweb.com/docs/doc.html)
- 问题清单:系统使用常见问题清单.txt
- 二次开发说明:系统二次开发说明文档.txt

## 二次开发说明
### 二次开发相关文档
- 1、本系统二次开发建议至少有1到2年JAVA开发经验
     开发前请确保了解系统二次开发说明、系统使用常见问题清单、系统使用手册等相关文档
- 2、问题清单或说明中已收录的问题，例如无法下载lib、启动报错CP、java版本不对在说明中已明确要求的不在做解答。

### 二次开发EAM系统部署的入门视频介绍(二次开发的环境部署)
- 1、配置EAM项目源码 https://www.bilibili.com/video/BV1844y1377V?spm_id_from=333.999.0.0
- 2、配置数据库 https://www.bilibili.com/video/BV1kR4y1P7Py?spm_id_from=333.999.0.0
- 3、配置与启动应用 https://www.bilibili.com/video/BV1wu411r7xC?spm_id_from=333.999.0.0
- 4、EAM部署 https://www.bilibili.com/video/BV1Q34y1a7LR?spm_id_from=333.999.0.0
- 5、EAM MAVEN设置 https://www.bilibili.com/video/BV1x34y1j7Ff?share_source=copy_web


### 二次开发相关的视频与文档集合
- 1、官网文档集合 http://foxnicweb.com/docs/doc.html
- 2、B站资料集合 https://space.bilibili.com/1796475412
- 3、知乎视频资料集合 https://www.zhihu.com/people/leefj/zvideos
- 4、知乎文档集合 https://www.zhihu.com/people/leefj/posts



## EAM系统安装部署
### 实施方案
- 1、传统方式:传统单体架构方式打包部署
- 2、微服务:拆分成独立微服务方式部署
- 3、集群模式:拆分成独立服务各自独立启动部署

### 软件介质
- 1、Docker部署:直接从docker拉镜像
- 2、应用直接运行部署:应用JAR和SQL包来源:https://gitee.com/lank/eam/releases


### EAM系统部署的视频介绍
- 1、待录制


### 方案一 一键安装Foxnic-EAM
- 自动安装Mysql,Java,EAM应用，Mysql从官方下载，因此整体安装速度会慢些
- 安装环境前先确认：RedHat 7.9 较为干净的系统，yum需能安装本地系统包(unzip,wget,zip,等)，公有云的默认yum配置一般没问题
- 安装:Mysql5.7 端口3306，密码root_pwd
- 安装:EAM web端口8089，访问地址为:http://ip:8089
- 安装目录:/app目录
```
#安装命令
curl -L http://resource.rainbooow.com/appInstallFull.sh>/tmp/i.sh;sh /tmp/i.sh
```

- 清理重新安装
```
#清理命令，会删除java 和mysql 进程。操作前请确保没有其他对应程序的业务在运行而导致误操作
rm -rf /app/java
rm -rf /app/db
rm -rf /app/eam
ps -ef|grep java |grep -v grep |awk '{print $2}'|xargs kill -9
ps -ef|grep mysql |grep -v grep |awk '{print $2}'|xargs kill -9
```



### 方案二 Docker方式-建议作为体验使用
- 注意点:docker 版本可用作体验版本，正式使用不推荐docker部署方式。
- 注意点:建议第一次docker部署完后，在重启一次，可能第一次启动数据库初始化还没完成，会导致报错
- 应用和移动端兼容列表

 | 应用镜像     |   移动端     |
 | ---------- | -----------  |
 | 1.0.9      | 1.0.1       |

- 部署步骤
```
  其中镜像中1.0.9为版本号,替换相对于版本即可。
  确保本地操作系统下/data/mysql目录的正确性,检查未冲突。
  $docker run --name eamapp -it \
    -e MYSQL_ROOT_PASSWORD="root_pwd" \
    -v /data/mysql:/var/lib/mysql  \
    -p 3306:3306 \
    -p 8089:8089 \
    -d docker.io/algernonking/eamapp:1.0.9 \
    --character-set-server=utf8
```

### 方案三 应用直接部署
- 详细部署方式查询git目录下的文档说明
- https://gitee.com/lank/eam/tree/master/%E7%9B%B8%E5%85%B3%E6%96%87%E6%A1%A3




## 项目结构说明
 ![输入图片说明](https://images.gitee.com/uploads/images/2021/0610/145855_29614033_1470521.png "屏幕截图.png")
### 安装教程
 Maven项目，支持 Eclipse 和 IDEA 开发。

### 使用说明
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
 5. 相关源码与开发文档 [Foxnic-Web](https://gitee.com/LeeFJ/foxnic-web) [开发文档](http://foxnicweb.com/docs/doc.html)

## 系统演示预览
![输入图片说明](https://images.gitee.com/uploads/images/2021/1213/212929_46438369_448530.jpeg "1.jpg")
![输入图片说明](https://images.gitee.com/uploads/images/2022/0513/115529_b00ce19a_448530.png "WechatIMG3.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/1213/213230_1ba469f5_448530.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/1213/213258_8d970535_448530.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/1213/213315_83659719_448530.png "屏幕截图.png")
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0316/122751_e20f543f_448530.jpeg" />
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0316/122759_2c4b10f6_448530.jpeg" />
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0316/122807_a1c6116b_448530.jpeg" />
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0316/122814_24bcd70e_448530.jpeg" />
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0316/122824_f21ca8de_448530.jpeg" />
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0326/212016_f9fa171e_448530.jpeg" />
<img width="200"  src="https://images.gitee.com/uploads/images/2022/0326/212025_135c19b0_448530.jpeg" />

## 社区版本功能列表
| 功能列表           |   社区版本        |    
| ---------------- | --------------   |  
|    权限管理        |   支持           |  
|    组织管理        |   支持           |  
|    人员管理        |   支持           |  
|    菜单管理        |   支持           |  
|    角色管理        |   支持           |   
|    字典管理        |   支持           |   
|    参数管理        |   支持           |   
|    编码管理        |   支持           |   
|    资产管理        |   支持           |   
|    软件管理        |   支持           |   
|    资产台账        |   支持           |  
|    采购管理        |   支持           |  
|    设备报修        |   支持           |  
|    设备报修        |   支持           |   
|    简单流程        |   支持           |   
|    库存管理        |   支持           |  
|    备件管理        |   支持           |   
|    耗材管理        |   支持           |   
|    盘点管理        |   支持           |  
|    报表预警        |   支持           |  
|    物品库存        |   支持           |  
|    财务管理        |   支持           |   
|    流程引擎        |   不支持         |
|    巡检管理        |   不支持         |
|    二次开发        |   根据相关开源协议 |   
|    版权信息修改     |   禁止           | 
|    当前价格        |   免费           |  
 
## 捐赠
- 开源不易，坚持更难，如果您觉得本项目不错，可以捐赠请作者喝杯咖啡~，在此表示感谢^_^
- 同时欢迎EAM系统的商业化定制,也欢迎其他业务的开发合作。
- 捐赠(支付宝)
<img width="200" height="200" src="https://images.gitee.com/uploads/images/2020/1105/135552_037eeb5c_448530.png" />

 
 