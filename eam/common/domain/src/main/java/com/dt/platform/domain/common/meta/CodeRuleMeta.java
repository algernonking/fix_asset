package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.CodeRule;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.Menu;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-26 15:26:42
 * @sign 3ACB95CCA363D232BA4D4CFF02D26E7E
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
	public static final BeanProperty<com.dt.platform.domain.common.CodeRule,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.CodeRule.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编码名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 编码名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeRule,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.common.CodeRule.class ,NAME, java.lang.String.class, "编码名称", "编码名称", java.lang.String.class, null);
	
	/**
	 * 业务模块 , 类型: java.lang.String
	*/
	public static final String MODULE_ID="moduleId";
	
	/**
	 * 业务模块 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeRule,java.lang.String> MODULE_ID_PROP = new BeanProperty(com.dt.platform.domain.common.CodeRule.class ,MODULE_ID, java.lang.String.class, "业务模块", "业务模块", java.lang.String.class, null);
	
	/**
	 * 编码规则 , 类型: java.lang.String
	*/
	public static final String RULE="rule";
	
	/**
	 * 编码规则 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeRule,java.lang.String> RULE_PROP = new BeanProperty(com.dt.platform.domain.common.CodeRule.class ,RULE, java.lang.String.class, "编码规则", "编码规则", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeRule,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.common.CodeRule.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeRule,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.CodeRule.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeRule,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.CodeRule.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeRule,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.CodeRule.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeRule,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.CodeRule.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeRule,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.CodeRule.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeRule,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.CodeRule.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeRule,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.CodeRule.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeRule,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.CodeRule.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 关联模块 , 类型: org.github.foxnic.web.domain.oauth.Menu
	*/
	public static final String MODULE="module";
	
	/**
	 * 关联模块 , 类型: org.github.foxnic.web.domain.oauth.Menu
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeRule,org.github.foxnic.web.domain.oauth.Menu> MODULE_PROP = new BeanProperty(com.dt.platform.domain.common.CodeRule.class ,MODULE, org.github.foxnic.web.domain.oauth.Menu.class, "关联模块", "关联模块", org.github.foxnic.web.domain.oauth.Menu.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , MODULE_ID , RULE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , MODULE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.CodeRule {

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
		 * 设置 编码名称
		 * @param name 编码名称
		 * @return 当前对象
		*/
		public CodeRule setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 业务模块
		 * @param moduleId 业务模块
		 * @return 当前对象
		*/
		public CodeRule setModuleId(String moduleId) {
			super.change(MODULE_ID,super.getModuleId(),moduleId);
			super.setModuleId(moduleId);
			return this;
		}
		
		/**
		 * 设置 编码规则
		 * @param rule 编码规则
		 * @return 当前对象
		*/
		public CodeRule setRule(String rule) {
			super.change(RULE,super.getRule(),rule);
			super.setRule(rule);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public CodeRule setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
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
		 * 设置 关联模块
		 * @param module 关联模块
		 * @return 当前对象
		*/
		public CodeRule setModule(Menu module) {
			super.change(MODULE,super.getModule(),module);
			super.setModule(module);
			return this;
		}
	}
}