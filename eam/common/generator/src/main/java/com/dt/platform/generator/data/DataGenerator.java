package com.dt.platform.generator.data;

import java.io.File;
import java.util.HashSet;

import com.dt.platform.generator.config.PlatformConfigs;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.project.maven.MavenProject;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.parameter.BatchParamBuilder;

/**
 * 为以usr_开头的表生成代码
 */
public class DataGenerator  {

	 
	
	public static void main(String[] args) throws Exception {
		DataGenerator g = new DataGenerator();
		// 按调用顺序呈现
		//
//		g.generateOrderMeasure(1,18);
//		g.generateOrderMeasure(2,9);
//		g.generateOrderMeasure(3,6);
//		g.generateOrderMeasure(4,8);
//		g.generateOrderMeasure(5,12);
		
		g.batchAlter();

		//
	}
	
	private PlatformConfigs configs;
	private DAO dao;
	
	public DataGenerator() {
		this.configs=new PlatformConfigs("service-system");
		this.dao=this.configs.getDAO();
	}

	
	/**
	 * 模拟生成量体数据
	 * */
	private void generateOrderMeasure(int orderId,int limit) {

		MavenProject mp=new MavenProject(this.getClass());
		File deptFile=FileUtil.resolveByPath(mp.getMainSourceDir(),"com/tailoring/generator/data/dept.txt");
		String deptText=FileUtil.readText(deptFile);
		String[] depts=deptText.split("\n");
		
		File empFile=FileUtil.resolveByPath(mp.getMainSourceDir(),"com/tailoring/generator/data/emp.txt");
		String empText=FileUtil.readText(empFile);
		String[] empLines=empText.split("\n");
 
		HashSet<String> names=new HashSet<>();
		BatchParamBuilder pb=new BatchParamBuilder();
		for (int i = 0; i < limit*4; i++) {
			int z=(int)Math.floor(Math.random()*empLines.length);
			String empln=  empLines[z].trim();
			String[] parts=empln.split("\t");
			if(names.contains(parts[0])) continue;
			z=(int)Math.floor(Math.random()*depts.length);
			pb.add(orderId,parts[0],depts[z].trim(),parts[1],"todo");
			names.add(parts[0]);
			if(names.size()>limit) break;
		}
		
		dao.batchExecute("insert into odr_measure (order_id,body_name,body_dept,body_sex,status) values(?,?,?,?,?)", pb.getBatchList());
 
		
	}
	
	/**
	 * 批量修改表
	 * */
	private void batchAlter() {
		String[] tables=dao.getTableNames();
		for (String table : tables) {
//			dao.execute("ALTER TABLE `"+table+"` MODIFY COLUMN `deleted` tinyint(1) NOT NULL DEFAULT b'0' COMMENT '是否已删除' AFTER `update_time`");
			if(dao.getTableColumnMeta(table, "version")!=null) {
				dao.execute("update "+table+" set version=1 where version is null");
				dao.execute("ALTER TABLE "+table+" MODIFY COLUMN version int DEFAULT 1 NOT NULL COMMENT '数据版本号'");
			}

		}
		System.out.println();

	}

}
