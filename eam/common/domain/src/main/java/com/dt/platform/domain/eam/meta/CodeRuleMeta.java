package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.CodeRule;
import java.util.Date;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-24 21:08:17
 * @sign 1028E3DFC847A052FE6788BFCCF6176B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CodeRuleMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CodeRule,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CodeRule.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CodeRule,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.CodeRule.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String VALUE="value";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CodeRule,java.lang.String> VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.CodeRule.class ,VALUE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String SYS_VALUE="sysValue";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CodeRule,java.lang.String> SYS_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.CodeRule.class ,SYS_VALUE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 组成 , 类型: java.lang.String
	*/
	public static final String PART_IDS="partIds";
	
	/**
	 * 组成 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CodeRule,java.lang.String> PART_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.CodeRule.class ,PART_IDS, java.lang.String.class, "组成", "组成", java.lang.String.class, null);
	
	/**
	 * 分割符 , 类型: java.lang.String
	*/
	public static final String CODE_SEPARATOR="codeSeparator";
	
	/**
	 * 分割符 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CodeRule,java.lang.String> CODE_SEPARATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.CodeRule.class ,CODE_SEPARATOR, java.lang.String.class, "分割符", "分割符", java.lang.String.class, null);
	
	/**
	 * 随机数位数 , 类型: java.lang.Integer
	*/
	public static final String NUMBER_SEQ="numberSeq";
	
	/**
	 * 随机数位数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CodeRule,java.lang.Integer> NUMBER_SEQ_PROP = new BeanProperty(com.dt.platform.domain.eam.CodeRule.class ,NUMBER_SEQ, java.lang.Integer.class, "随机数位数", "随机数位数", java.lang.Integer.class, null);
	
	/**
	 * 固定字符串 , 类型: java.lang.String
	*/
	public static final String FS1="fs1";
	
	/**
	 * 固定字符串 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CodeRule,java.lang.String> FS1_PROP = new BeanProperty(com.dt.platform.domain.eam.CodeRule.class ,FS1, java.lang.String.class, "固定字符串", "固定字符串", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CodeRule,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CodeRule.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CodeRule,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CodeRule.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CodeRule,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CodeRule.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CodeRule,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CodeRule.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CodeRule,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.CodeRule.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CodeRule,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CodeRule.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CodeRule,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CodeRule.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CodeRule,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.CodeRule.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CodeRule,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CodeRule.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , VALUE , SYS_VALUE , PART_IDS , CODE_SEPARATOR , NUMBER_SEQ , FS1 , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.CodeRule {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CodeRule setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public CodeRule setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param value 编码
		 * @return 当前对象
		*/
		public CodeRule setValue(String value) {
			super.change(VALUE,super.getValue(),value);
			super.setValue(value);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param sysValue 编码
		 * @return 当前对象
		*/
		public CodeRule setSysValue(String sysValue) {
			super.change(SYS_VALUE,super.getSysValue(),sysValue);
			super.setSysValue(sysValue);
			return this;
		}
		
		/**
		 * 设置 组成
		 * @param partIds 组成
		 * @return 当前对象
		*/
		public CodeRule setPartIds(String partIds) {
			super.change(PART_IDS,super.getPartIds(),partIds);
			super.setPartIds(partIds);
			return this;
		}
		
		/**
		 * 设置 分割符
		 * @param codeSeparator 分割符
		 * @return 当前对象
		*/
		public CodeRule setCodeSeparator(String codeSeparator) {
			super.change(CODE_SEPARATOR,super.getCodeSeparator(),codeSeparator);
			super.setCodeSeparator(codeSeparator);
			return this;
		}
		
		/**
		 * 设置 随机数位数
		 * @param numberSeq 随机数位数
		 * @return 当前对象
		*/
		public CodeRule setNumberSeq(Integer numberSeq) {
			super.change(NUMBER_SEQ,super.getNumberSeq(),numberSeq);
			super.setNumberSeq(numberSeq);
			return this;
		}
		
		/**
		 * 设置 固定字符串
		 * @param fs1 固定字符串
		 * @return 当前对象
		*/
		public CodeRule setFs1(String fs1) {
			super.change(FS1,super.getFs1(),fs1);
			super.setFs1(fs1);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CodeRule setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CodeRule setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CodeRule setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CodeRule setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CodeRule setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CodeRule setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CodeRule setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public CodeRule setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public CodeRule setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
	}
}