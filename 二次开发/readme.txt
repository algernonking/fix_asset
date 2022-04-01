

二次开发说明
- 1、正常情况下使用IDE maven3.6版本可以正常下载,如果未下载，可以在private_lib.tar.gz压缩包内找到所有私有库,进行手动安装即可
- 2、SQL文件:(每日更新):http://121.43.103.102/upload/sql.tar.gz
- 3、运行环境要求:mysql版:5.7.X,Java版本:1.8
- 4、部署请参考Git目录文档目录下的《EAM安装部署维护手册.docx》
- 5、数据库jdbc信息默认为密文模式,当需要明文信息，则把配置文件中的druid.primary.encrypt.enable:false.

问题清单:
- 1、如果系统启动都正常，在新增数据时报错，可能生成序列的存储过程未成功执行



