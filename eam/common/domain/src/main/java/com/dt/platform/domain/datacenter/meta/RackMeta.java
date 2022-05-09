package com.dt.platform.domain.datacenter.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.datacenter.Rack;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.datacenter.Area;
import com.dt.platform.domain.datacenter.Layer;
import org.github.foxnic.web.domain.system.DictItem;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-07 21:19:32
 * @sign 5BC9AB8545BB4B4FEB7B4C0F5C7D297B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class RackMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String RACK_CODE="rackCode";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> RACK_CODE_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,RACK_CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String RACK_TYPE="rackType";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> RACK_TYPE_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,RACK_TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String RACK_NAME="rackName";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> RACK_NAME_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,RACK_NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 环境 , 类型: java.lang.String
	*/
	public static final String ENVIRONMENT="environment";
	
	/**
	 * 环境 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> ENVIRONMENT_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,ENVIRONMENT, java.lang.String.class, "环境", "环境", java.lang.String.class, null);
	
	/**
	 * 使用分类 , 类型: java.lang.String
	*/
	public static final String RACK_USED_TYPE="rackUsedType";
	
	/**
	 * 使用分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> RACK_USED_TYPE_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,RACK_USED_TYPE, java.lang.String.class, "使用分类", "使用分类", java.lang.String.class, null);
	
	/**
	 * 区域 , 类型: java.lang.String
	*/
	public static final String AREA_ID="areaId";
	
	/**
	 * 区域 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> AREA_ID_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,AREA_ID, java.lang.String.class, "区域", "区域", java.lang.String.class, null);
	
	/**
	 * 层级 , 类型: java.lang.String
	*/
	public static final String LAYER_ID="layerId";
	
	/**
	 * 层级 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> LAYER_ID_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,LAYER_ID, java.lang.String.class, "层级", "层级", java.lang.String.class, null);
	
	/**
	 * 容量 , 类型: java.math.BigDecimal
	*/
	public static final String RACK_CAPTICAL="rackCaptical";
	
	/**
	 * 容量 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.math.BigDecimal> RACK_CAPTICAL_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,RACK_CAPTICAL, java.math.BigDecimal.class, "容量", "容量", java.math.BigDecimal.class, null);
	
	/**
	 * U位数量 , 类型: java.lang.Integer
	*/
	public static final String U_POSTION_NUMBER="uPostionNumber";
	
	/**
	 * U位数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.Integer> U_POSTION_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,U_POSTION_NUMBER, java.lang.Integer.class, "U位数量", "U位数量", java.lang.Integer.class, null);
	
	/**
	 * PDU数量 , 类型: java.lang.Integer
	*/
	public static final String PDU_NUMBER="pduNumber";
	
	/**
	 * PDU数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.Integer> PDU_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,PDU_NUMBER, java.lang.Integer.class, "PDU数量", "PDU数量", java.lang.Integer.class, null);
	
	/**
	 * 跳线数 , 类型: java.lang.Integer
	*/
	public static final String JUMPER_NUMBER="jumperNumber";
	
	/**
	 * 跳线数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.Integer> JUMPER_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,JUMPER_NUMBER, java.lang.Integer.class, "跳线数", "跳线数", java.lang.Integer.class, null);
	
	/**
	 * 合同电力 , 类型: java.lang.Integer
	*/
	public static final String CONTRACT_POWER="contractPower";
	
	/**
	 * 合同电力 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.Integer> CONTRACT_POWER_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,CONTRACT_POWER, java.lang.Integer.class, "合同电力", "合同电力", java.lang.Integer.class, null);
	
	/**
	 * 设备数量 , 类型: java.lang.Integer
	*/
	public static final String EQUIPMENT_NUMBER="equipmentNumber";
	
	/**
	 * 设备数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.Integer> EQUIPMENT_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,EQUIPMENT_NUMBER, java.lang.Integer.class, "设备数量", "设备数量", java.lang.Integer.class, null);
	
	/**
	 * 到期日期 , 类型: java.util.Date
	*/
	public static final String EXPIRE_DATE="expireDate";
	
	/**
	 * 到期日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.util.Date> EXPIRE_DATE_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,EXPIRE_DATE, java.util.Date.class, "到期日期", "到期日期", java.util.Date.class, null);
	
	/**
	 * 标签1 , 类型: java.lang.String
	*/
	public static final String RACK_LABEL1="rackLabel1";
	
	/**
	 * 标签1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> RACK_LABEL1_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,RACK_LABEL1, java.lang.String.class, "标签1", "标签1", java.lang.String.class, null);
	
	/**
	 * 标签2 , 类型: java.lang.String
	*/
	public static final String RACK_LABEL2="rackLabel2";
	
	/**
	 * 标签2 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> RACK_LABEL2_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,RACK_LABEL2, java.lang.String.class, "标签2", "标签2", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String RACK_NOTES="rackNotes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> RACK_NOTES_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,RACK_NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 区域 , 类型: com.dt.platform.domain.datacenter.Area
	*/
	public static final String AREA="area";
	
	/**
	 * 区域 , 类型: com.dt.platform.domain.datacenter.Area
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,com.dt.platform.domain.datacenter.Area> AREA_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,AREA, com.dt.platform.domain.datacenter.Area.class, "区域", "", com.dt.platform.domain.datacenter.Area.class, null);
	
	/**
	 * 层级 , 类型: com.dt.platform.domain.datacenter.Layer
	*/
	public static final String LAYER="layer";
	
	/**
	 * 层级 , 类型: com.dt.platform.domain.datacenter.Layer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,com.dt.platform.domain.datacenter.Layer> LAYER_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,LAYER, com.dt.platform.domain.datacenter.Layer.class, "层级", "", com.dt.platform.domain.datacenter.Layer.class, null);
	
	/**
	 * 状态 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String STATUS_DICT="statusDict";
	
	/**
	 * 状态 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,org.github.foxnic.web.domain.system.DictItem> STATUS_DICT_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,STATUS_DICT, org.github.foxnic.web.domain.system.DictItem.class, "状态", "", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String TYPE_DICT="typeDict";
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,org.github.foxnic.web.domain.system.DictItem> TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "类型", "", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 使用类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String USED_TYPE_DICT="usedTypeDict";
	
	/**
	 * 使用类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,org.github.foxnic.web.domain.system.DictItem> USED_TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,USED_TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "使用类型", "", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 环境 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String ENVIRONMENT_DICT="environmentDict";
	
	/**
	 * 环境 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,org.github.foxnic.web.domain.system.DictItem> ENVIRONMENT_DICT_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,ENVIRONMENT_DICT, org.github.foxnic.web.domain.system.DictItem.class, "环境", "", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , RACK_CODE , RACK_TYPE , RACK_NAME , STATUS , ENVIRONMENT , RACK_USED_TYPE , AREA_ID , LAYER_ID , RACK_CAPTICAL , U_POSTION_NUMBER , PDU_NUMBER , JUMPER_NUMBER , CONTRACT_POWER , EQUIPMENT_NUMBER , EXPIRE_DATE , RACK_LABEL1 , RACK_LABEL2 , RACK_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , AREA , LAYER , STATUS_DICT , TYPE_DICT , USED_TYPE_DICT , ENVIRONMENT_DICT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.datacenter.Rack {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Rack setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param rackCode 编码
		 * @return 当前对象
		*/
		public Rack setRackCode(String rackCode) {
			super.change(RACK_CODE,super.getRackCode(),rackCode);
			super.setRackCode(rackCode);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param rackType 类型
		 * @return 当前对象
		*/
		public Rack setRackType(String rackType) {
			super.change(RACK_TYPE,super.getRackType(),rackType);
			super.setRackType(rackType);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param rackName 名称
		 * @return 当前对象
		*/
		public Rack setRackName(String rackName) {
			super.change(RACK_NAME,super.getRackName(),rackName);
			super.setRackName(rackName);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public Rack setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 环境
		 * @param environment 环境
		 * @return 当前对象
		*/
		public Rack setEnvironment(String environment) {
			super.change(ENVIRONMENT,super.getEnvironment(),environment);
			super.setEnvironment(environment);
			return this;
		}
		
		/**
		 * 设置 使用分类
		 * @param rackUsedType 使用分类
		 * @return 当前对象
		*/
		public Rack setRackUsedType(String rackUsedType) {
			super.change(RACK_USED_TYPE,super.getRackUsedType(),rackUsedType);
			super.setRackUsedType(rackUsedType);
			return this;
		}
		
		/**
		 * 设置 区域
		 * @param areaId 区域
		 * @return 当前对象
		*/
		public Rack setAreaId(String areaId) {
			super.change(AREA_ID,super.getAreaId(),areaId);
			super.setAreaId(areaId);
			return this;
		}
		
		/**
		 * 设置 层级
		 * @param layerId 层级
		 * @return 当前对象
		*/
		public Rack setLayerId(String layerId) {
			super.change(LAYER_ID,super.getLayerId(),layerId);
			super.setLayerId(layerId);
			return this;
		}
		
		/**
		 * 设置 容量
		 * @param rackCaptical 容量
		 * @return 当前对象
		*/
		public Rack setRackCaptical(BigDecimal rackCaptical) {
			super.change(RACK_CAPTICAL,super.getRackCaptical(),rackCaptical);
			super.setRackCaptical(rackCaptical);
			return this;
		}
		
		/**
		 * 设置 U位数量
		 * @param uPostionNumber U位数量
		 * @return 当前对象
		*/
		public Rack setUPostionNumber(Integer uPostionNumber) {
			super.change(U_POSTION_NUMBER,super.getUPostionNumber(),uPostionNumber);
			super.setUPostionNumber(uPostionNumber);
			return this;
		}
		
		/**
		 * 设置 PDU数量
		 * @param pduNumber PDU数量
		 * @return 当前对象
		*/
		public Rack setPduNumber(Integer pduNumber) {
			super.change(PDU_NUMBER,super.getPduNumber(),pduNumber);
			super.setPduNumber(pduNumber);
			return this;
		}
		
		/**
		 * 设置 跳线数
		 * @param jumperNumber 跳线数
		 * @return 当前对象
		*/
		public Rack setJumperNumber(Integer jumperNumber) {
			super.change(JUMPER_NUMBER,super.getJumperNumber(),jumperNumber);
			super.setJumperNumber(jumperNumber);
			return this;
		}
		
		/**
		 * 设置 合同电力
		 * @param contractPower 合同电力
		 * @return 当前对象
		*/
		public Rack setContractPower(Integer contractPower) {
			super.change(CONTRACT_POWER,super.getContractPower(),contractPower);
			super.setContractPower(contractPower);
			return this;
		}
		
		/**
		 * 设置 设备数量
		 * @param equipmentNumber 设备数量
		 * @return 当前对象
		*/
		public Rack setEquipmentNumber(Integer equipmentNumber) {
			super.change(EQUIPMENT_NUMBER,super.getEquipmentNumber(),equipmentNumber);
			super.setEquipmentNumber(equipmentNumber);
			return this;
		}
		
		/**
		 * 设置 到期日期
		 * @param expireDate 到期日期
		 * @return 当前对象
		*/
		public Rack setExpireDate(Date expireDate) {
			super.change(EXPIRE_DATE,super.getExpireDate(),expireDate);
			super.setExpireDate(expireDate);
			return this;
		}
		
		/**
		 * 设置 标签1
		 * @param rackLabel1 标签1
		 * @return 当前对象
		*/
		public Rack setRackLabel1(String rackLabel1) {
			super.change(RACK_LABEL1,super.getRackLabel1(),rackLabel1);
			super.setRackLabel1(rackLabel1);
			return this;
		}
		
		/**
		 * 设置 标签2
		 * @param rackLabel2 标签2
		 * @return 当前对象
		*/
		public Rack setRackLabel2(String rackLabel2) {
			super.change(RACK_LABEL2,super.getRackLabel2(),rackLabel2);
			super.setRackLabel2(rackLabel2);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param rackNotes 备注
		 * @return 当前对象
		*/
		public Rack setRackNotes(String rackNotes) {
			super.change(RACK_NOTES,super.getRackNotes(),rackNotes);
			super.setRackNotes(rackNotes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Rack setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Rack setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Rack setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Rack setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Rack setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Rack setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Rack setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public Rack setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Rack setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 区域
		 * @param area 区域
		 * @return 当前对象
		*/
		public Rack setArea(Area area) {
			super.change(AREA,super.getArea(),area);
			super.setArea(area);
			return this;
		}
		
		/**
		 * 设置 层级
		 * @param layer 层级
		 * @return 当前对象
		*/
		public Rack setLayer(Layer layer) {
			super.change(LAYER,super.getLayer(),layer);
			super.setLayer(layer);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param statusDict 状态
		 * @return 当前对象
		*/
		public Rack setStatusDict(DictItem statusDict) {
			super.change(STATUS_DICT,super.getStatusDict(),statusDict);
			super.setStatusDict(statusDict);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param typeDict 类型
		 * @return 当前对象
		*/
		public Rack setTypeDict(DictItem typeDict) {
			super.change(TYPE_DICT,super.getTypeDict(),typeDict);
			super.setTypeDict(typeDict);
			return this;
		}
		
		/**
		 * 设置 使用类型
		 * @param usedTypeDict 使用类型
		 * @return 当前对象
		*/
		public Rack setUsedTypeDict(DictItem usedTypeDict) {
			super.change(USED_TYPE_DICT,super.getUsedTypeDict(),usedTypeDict);
			super.setUsedTypeDict(usedTypeDict);
			return this;
		}
		
		/**
		 * 设置 环境
		 * @param environmentDict 环境
		 * @return 当前对象
		*/
		public Rack setEnvironmentDict(DictItem environmentDict) {
			super.change(ENVIRONMENT_DICT,super.getEnvironmentDict(),environmentDict);
			super.setEnvironmentDict(environmentDict);
			return this;
		}
	}
}