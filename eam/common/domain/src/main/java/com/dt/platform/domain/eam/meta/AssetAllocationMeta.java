package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetAllocation;
import java.util.Date;
import com.dt.platform.domain.eam.Asset;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-03 21:35:25
 * @sign C679FFD847EDCB14E7C7ABF9E7ABCCFB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetAllocationMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final String PROC_ID="procId";
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,java.lang.String> PROC_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,PROC_ID, java.lang.String.class, "流程", "流程", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,NAME, java.lang.String.class, "业务名称", "业务名称", java.lang.String.class, null);
	
	/**
	 * 调出所属公司 , 类型: java.lang.String
	*/
	public static final String OUT_OWN_COMPANY_ID="outOwnCompanyId";
	
	/**
	 * 调出所属公司 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,java.lang.String> OUT_OWN_COMPANY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,OUT_OWN_COMPANY_ID, java.lang.String.class, "调出所属公司", "调出所属公司", java.lang.String.class, null);
	
	/**
	 * 调入所属公司 , 类型: java.lang.String
	*/
	public static final String IN_OWN_COMPANY_ID="inOwnCompanyId";
	
	/**
	 * 调入所属公司 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,java.lang.String> IN_OWN_COMPANY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,IN_OWN_COMPANY_ID, java.lang.String.class, "调入所属公司", "调入所属公司", java.lang.String.class, null);
	
	/**
	 * 调入管理员 , 类型: java.lang.String
	*/
	public static final String IN_MANAGER_ID="inManagerId";
	
	/**
	 * 调入管理员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,java.lang.String> IN_MANAGER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,IN_MANAGER_ID, java.lang.String.class, "调入管理员", "调入管理员", java.lang.String.class, null);
	
	/**
	 * 调拨说明 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 调拨说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,CONTENT, java.lang.String.class, "调拨说明", "调拨说明", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final String BUSINESS_DATE="businessDate";
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,java.util.Date> BUSINESS_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,BUSINESS_DATE, java.util.Date.class, "业务日期", "业务日期", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 资产 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET_LIST="assetList";
	
	/**
	 * 资产 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,com.dt.platform.domain.eam.Asset> ASSET_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,ASSET_LIST, java.util.List.class, "资产", "资产", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * 资产列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ASSET_IDS="assetIds";
	
	/**
	 * 资产列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,java.lang.String> ASSET_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,ASSET_IDS, java.util.List.class, "资产列表", "资产列表", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAllocation,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAllocation.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BUSINESS_CODE , PROC_ID , STATUS , NAME , OUT_OWN_COMPANY_ID , IN_OWN_COMPANY_ID , IN_MANAGER_ID , CONTENT , ORIGINATOR_ID , BUSINESS_DATE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , ASSET_LIST , ASSET_IDS , ORIGINATOR };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetAllocation {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetAllocation setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public AssetAllocation setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 流程
		 * @param procId 流程
		 * @return 当前对象
		*/
		public AssetAllocation setProcId(String procId) {
			super.change(PROC_ID,super.getProcId(),procId);
			super.setProcId(procId);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public AssetAllocation setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 业务名称
		 * @param name 业务名称
		 * @return 当前对象
		*/
		public AssetAllocation setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 调出所属公司
		 * @param outOwnCompanyId 调出所属公司
		 * @return 当前对象
		*/
		public AssetAllocation setOutOwnCompanyId(String outOwnCompanyId) {
			super.change(OUT_OWN_COMPANY_ID,super.getOutOwnCompanyId(),outOwnCompanyId);
			super.setOutOwnCompanyId(outOwnCompanyId);
			return this;
		}
		
		/**
		 * 设置 调入所属公司
		 * @param inOwnCompanyId 调入所属公司
		 * @return 当前对象
		*/
		public AssetAllocation setInOwnCompanyId(String inOwnCompanyId) {
			super.change(IN_OWN_COMPANY_ID,super.getInOwnCompanyId(),inOwnCompanyId);
			super.setInOwnCompanyId(inOwnCompanyId);
			return this;
		}
		
		/**
		 * 设置 调入管理员
		 * @param inManagerId 调入管理员
		 * @return 当前对象
		*/
		public AssetAllocation setInManagerId(String inManagerId) {
			super.change(IN_MANAGER_ID,super.getInManagerId(),inManagerId);
			super.setInManagerId(inManagerId);
			return this;
		}
		
		/**
		 * 设置 调拨说明
		 * @param content 调拨说明
		 * @return 当前对象
		*/
		public AssetAllocation setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public AssetAllocation setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 业务日期
		 * @param businessDate 业务日期
		 * @return 当前对象
		*/
		public AssetAllocation setBusinessDate(Date businessDate) {
			super.change(BUSINESS_DATE,super.getBusinessDate(),businessDate);
			super.setBusinessDate(businessDate);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetAllocation setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetAllocation setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetAllocation setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetAllocation setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetAllocation setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetAllocation setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetAllocation setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetAllocation setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param assetList 资产
		 * @return 当前对象
		*/
		public AssetAllocation setAssetList(List<Asset> assetList) {
			super.change(ASSET_LIST,super.getAssetList(),assetList);
			super.setAssetList(assetList);
			return this;
		}
		
		/**
		 * 设置 资产列表
		 * @param assetIds 资产列表
		 * @return 当前对象
		*/
		public AssetAllocation setAssetIds(List<String> assetIds) {
			super.change(ASSET_IDS,super.getAssetIds(),assetIds);
			super.setAssetIds(assetIds);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public AssetAllocation setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
	}
}