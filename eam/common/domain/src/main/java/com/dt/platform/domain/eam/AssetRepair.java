package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_REPAIR;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-17 16:25:20
 * @sign B328CF029A7B9398289C2B14B5EB0B78
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_repair")
public class AssetRepair extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_REPAIR.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 流程：流程
	*/
	@ApiModelProperty(required = false,value="流程" , notes = "流程")
	private String procId;
	
	/**
	 * 单据状态：单据状态
	*/
	@ApiModelProperty(required = false,value="单据状态" , notes = "单据状态")
	private String status;
	
	/**
	 * 单据编号：单据编号
	*/
	@ApiModelProperty(required = false,value="单据编号" , notes = "单据编号")
	private String busiCode;
	
	/**
	 * 单据名称：单据名称
	*/
	@ApiModelProperty(required = true,value="单据名称" , notes = "单据名称")
	private String name;
	
	/**
	 * 报修类型：报修类型
	*/
	@ApiModelProperty(required = false,value="报修类型" , notes = "报修类型")
	private String type;
	
	/**
	 * 报修日期：报修日期
	*/
	@ApiModelProperty(required = false,value="报修日期" , notes = "报修日期")
	private Date repairDate;
	
	/**
	 * 计划完成日期：计划完成日期
	*/
	@ApiModelProperty(required = false,value="计划完成日期" , notes = "计划完成日期")
	private Date planFinishDate;
	
	/**
	 * 实际完成发起：实际完成发起
	*/
	@ApiModelProperty(required = false,value="实际完成发起" , notes = "实际完成发起")
	private Date actualFinishDate;
	
	/**
	 * 报修内容：报修内容
	*/
	@ApiModelProperty(required = false,value="报修内容" , notes = "报修内容")
	private String content;
	
	/**
	 * 报修人：报修人
	*/
	@ApiModelProperty(required = false,value="报修人" , notes = "报修人")
	private String operuserId;
	
	/**
	 * 图片：图片
	*/
	@ApiModelProperty(required = false,value="图片" , notes = "图片")
	private String pictureId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public AssetRepair setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 流程<br>
	 * 流程
	 * @return 流程
	*/
	public String getProcId() {
		return procId;
	}
	
	/**
	 * 设置 流程
	 * @param procId 流程
	 * @return 当前对象
	*/
	public AssetRepair setProcId(String procId) {
		this.procId=procId;
		return this;
	}
	
	/**
	 * 获得 单据状态<br>
	 * 单据状态
	 * @return 单据状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 单据状态
	 * @param status 单据状态
	 * @return 当前对象
	*/
	public AssetRepair setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 单据编号<br>
	 * 单据编号
	 * @return 单据编号
	*/
	public String getBusiCode() {
		return busiCode;
	}
	
	/**
	 * 设置 单据编号
	 * @param busiCode 单据编号
	 * @return 当前对象
	*/
	public AssetRepair setBusiCode(String busiCode) {
		this.busiCode=busiCode;
		return this;
	}
	
	/**
	 * 获得 单据名称<br>
	 * 单据名称
	 * @return 单据名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 单据名称
	 * @param name 单据名称
	 * @return 当前对象
	*/
	public AssetRepair setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 报修类型<br>
	 * 报修类型
	 * @return 报修类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 报修类型
	 * @param type 报修类型
	 * @return 当前对象
	*/
	public AssetRepair setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 报修日期<br>
	 * 报修日期
	 * @return 报修日期
	*/
	public Date getRepairDate() {
		return repairDate;
	}
	
	/**
	 * 设置 报修日期
	 * @param repairDate 报修日期
	 * @return 当前对象
	*/
	public AssetRepair setRepairDate(Date repairDate) {
		this.repairDate=repairDate;
		return this;
	}
	
	/**
	 * 获得 计划完成日期<br>
	 * 计划完成日期
	 * @return 计划完成日期
	*/
	public Date getPlanFinishDate() {
		return planFinishDate;
	}
	
	/**
	 * 设置 计划完成日期
	 * @param planFinishDate 计划完成日期
	 * @return 当前对象
	*/
	public AssetRepair setPlanFinishDate(Date planFinishDate) {
		this.planFinishDate=planFinishDate;
		return this;
	}
	
	/**
	 * 获得 实际完成发起<br>
	 * 实际完成发起
	 * @return 实际完成发起
	*/
	public Date getActualFinishDate() {
		return actualFinishDate;
	}
	
	/**
	 * 设置 实际完成发起
	 * @param actualFinishDate 实际完成发起
	 * @return 当前对象
	*/
	public AssetRepair setActualFinishDate(Date actualFinishDate) {
		this.actualFinishDate=actualFinishDate;
		return this;
	}
	
	/**
	 * 获得 报修内容<br>
	 * 报修内容
	 * @return 报修内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 报修内容
	 * @param content 报修内容
	 * @return 当前对象
	*/
	public AssetRepair setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 报修人<br>
	 * 报修人
	 * @return 报修人
	*/
	public String getOperuserId() {
		return operuserId;
	}
	
	/**
	 * 设置 报修人
	 * @param operuserId 报修人
	 * @return 当前对象
	*/
	public AssetRepair setOperuserId(String operuserId) {
		this.operuserId=operuserId;
		return this;
	}
	
	/**
	 * 获得 图片<br>
	 * 图片
	 * @return 图片
	*/
	public String getPictureId() {
		return pictureId;
	}
	
	/**
	 * 设置 图片
	 * @param pictureId 图片
	 * @return 当前对象
	*/
	public AssetRepair setPictureId(String pictureId) {
		this.pictureId=pictureId;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public AssetRepair setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public AssetRepair setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public AssetRepair setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public AssetRepair setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public AssetRepair setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public AssetRepair setDeleted(Integer deleted) {
		this.deleted=deleted;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public AssetRepair setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public AssetRepair setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public AssetRepair setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetRepair , 转换好的 AssetRepair 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetRepair , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将 Map 转换成 AssetRepair
	 * @param assetRepairMap 包含实体信息的 Map 对象
	 * @return AssetRepair , 转换好的的 AssetRepair 对象
	*/
	@Transient
	public static AssetRepair createFrom(Map<String,Object> assetRepairMap) {
		if(assetRepairMap==null) return null;
		AssetRepair po = EntityContext.create(AssetRepair.class, assetRepairMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetRepair
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetRepair , 转换好的的 AssetRepair 对象
	*/
	@Transient
	public static AssetRepair createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetRepair po = EntityContext.create(AssetRepair.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetRepair，等同于 new
	 * @return AssetRepair 对象
	*/
	@Transient
	public static AssetRepair create() {
		return EntityContext.create(AssetRepair.class);
	}
}