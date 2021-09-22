package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.VoucherOwner;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import java.util.List;
import com.dt.platform.domain.ops.Voucher;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-18 12:22:14
 * @sign D3F1D53C055204833009FEC0E22450D8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class VoucherOwnerMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.VoucherOwner,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.VoucherOwner.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 类别 , 类型: java.lang.String
	*/
	public static final String CATEGORY_CODE="categoryCode";
	
	/**
	 * 类别 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.VoucherOwner,java.lang.String> CATEGORY_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.VoucherOwner.class ,CATEGORY_CODE, java.lang.String.class, "类别", "类别", java.lang.String.class, null);
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final String LABEL="label";
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.VoucherOwner,java.lang.String> LABEL_PROP = new BeanProperty(com.dt.platform.domain.ops.VoucherOwner.class ,LABEL, java.lang.String.class, "标签", "标签", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.VoucherOwner,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.VoucherOwner.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 位置 , 类型: java.lang.String
	*/
	public static final String POSITION="position";
	
	/**
	 * 位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.VoucherOwner,java.lang.String> POSITION_PROP = new BeanProperty(com.dt.platform.domain.ops.VoucherOwner.class ,POSITION, java.lang.String.class, "位置", "位置", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.VoucherOwner,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.VoucherOwner.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.VoucherOwner,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.VoucherOwner.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.VoucherOwner,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.VoucherOwner.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.VoucherOwner,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.VoucherOwner.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.VoucherOwner,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.VoucherOwner.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.VoucherOwner,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.VoucherOwner.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.VoucherOwner,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.VoucherOwner.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.VoucherOwner,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.VoucherOwner.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.VoucherOwner,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.VoucherOwner.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.VoucherOwner,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.VoucherOwner.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 凭证类型 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String VOUCHER_CATEGORY="voucherCategory";
	
	/**
	 * 凭证类型 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.VoucherOwner,org.github.foxnic.web.domain.system.DictItem> VOUCHER_CATEGORY_PROP = new BeanProperty(com.dt.platform.domain.ops.VoucherOwner.class ,VOUCHER_CATEGORY, java.util.List.class, "凭证类型", "凭证类型", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 凭证 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.Voucher
	*/
	public static final String VOUCHER_LIST="voucherList";
	
	/**
	 * 凭证 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.Voucher
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.VoucherOwner,com.dt.platform.domain.ops.Voucher> VOUCHER_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.VoucherOwner.class ,VOUCHER_LIST, java.util.List.class, "凭证", "凭证", com.dt.platform.domain.ops.Voucher.class, null);
	
	/**
	 * 凭证 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String VOUCHER_IDS="voucherIds";
	
	/**
	 * 凭证 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.VoucherOwner,java.lang.String> VOUCHER_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.VoucherOwner.class ,VOUCHER_IDS, java.util.List.class, "凭证", "凭证", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CATEGORY_CODE , LABEL , NAME , POSITION , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , VOUCHER_CATEGORY , VOUCHER_LIST , VOUCHER_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.VoucherOwner {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public VoucherOwner setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 类别
		 * @param categoryCode 类别
		 * @return 当前对象
		*/
		public VoucherOwner setCategoryCode(String categoryCode) {
			super.change(CATEGORY_CODE,super.getCategoryCode(),categoryCode);
			super.setCategoryCode(categoryCode);
			return this;
		}
		
		/**
		 * 设置 标签
		 * @param label 标签
		 * @return 当前对象
		*/
		public VoucherOwner setLabel(String label) {
			super.change(LABEL,super.getLabel(),label);
			super.setLabel(label);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public VoucherOwner setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 位置
		 * @param position 位置
		 * @return 当前对象
		*/
		public VoucherOwner setPosition(String position) {
			super.change(POSITION,super.getPosition(),position);
			super.setPosition(position);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public VoucherOwner setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public VoucherOwner setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public VoucherOwner setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public VoucherOwner setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public VoucherOwner setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public VoucherOwner setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public VoucherOwner setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public VoucherOwner setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public VoucherOwner setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public VoucherOwner setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 凭证类型
		 * @param voucherCategory 凭证类型
		 * @return 当前对象
		*/
		public VoucherOwner setVoucherCategory(List<DictItem> voucherCategory) {
			super.change(VOUCHER_CATEGORY,super.getVoucherCategory(),voucherCategory);
			super.setVoucherCategory(voucherCategory);
			return this;
		}
		
		/**
		 * 设置 凭证
		 * @param voucherList 凭证
		 * @return 当前对象
		*/
		public VoucherOwner setVoucherList(List<Voucher> voucherList) {
			super.change(VOUCHER_LIST,super.getVoucherList(),voucherList);
			super.setVoucherList(voucherList);
			return this;
		}
		
		/**
		 * 设置 凭证
		 * @param voucherIds 凭证
		 * @return 当前对象
		*/
		public VoucherOwner setVoucherIds(List<String> voucherIds) {
			super.change(VOUCHER_IDS,super.getVoucherIds(),voucherIds);
			super.setVoucherIds(voucherIds);
			return this;
		}
	}
}