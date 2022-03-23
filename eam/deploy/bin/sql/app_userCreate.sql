create user 'eam'@'%' identified by 'P@pXXXXXXXXXX';
grant all privileges  on eam.* to 'eam'@'%' ;
grant all on eam.* to 'eam'@'%' ;

grant all privileges  on eam_c1.* to 'eam'@'%' ;
grant all on eam_c1.* to 'eam'@'%' ;


grant all privileges  on eam_demo.* to 'eam'@'%' ;
grant all on eam_demo.* to 'eam'@'%' ;
flush privileges;