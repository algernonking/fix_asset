package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_RESIDUAL_STRATEGY;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 折旧策略
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-26 15:28:04
 * @sign 3231DB31621286F61F5BADC2BDCFC662
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_residual_strategy")
public class ResidualStrategy extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_RESIDUAL_STRATEGY.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 策略描述：策略描述
	*/
	@ApiModelProperty(required = false,value="策略描述" , notes = "策略描述")
	private String strategyDescribe;
	
	/**
	 * 残值率：残值率
	*/
	@ApiModelProperty(required = false,value="残值率" , notes = "残值率")
	private BigDecimal residualvalueRate;
	
	/**
	 * 折旧率：折旧率
	*/
	@ApiModelProperty(required = false,value="折旧率" , notes = "折旧率")
	private BigDecimal depreciationRate;
	
	/**
	 * 设置值：设置值
	*/
	@ApiModelProperty(required = false,value="设置值" , notes = "设置值")
	private String value;
	
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
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
	public ResidualStrategy setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public ResidualStrategy setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public ResidualStrategy setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 策略描述<br>
	 * 策略描述
	 * @return 策略描述
	*/
	public String getStrategyDescribe() {
		return strategyDescribe;
	}
	
	/**
	 * 设置 策略描述
	 * @param strategyDescribe 策略描述
	 * @return 当前对象
	*/
	public ResidualStrategy setStrategyDescribe(String strategyDescribe) {
		this.strategyDescribe=strategyDescribe;
		return this;
	}
	
	/**
	 * 获得 残值率<br>
	 * 残值率
	 * @return 残值率
	*/
	public BigDecimal getResidualvalueRate() {
		return residualvalueRate;
	}
	
	/**
	 * 设置 残值率
	 * @param residualvalueRate 残值率
	 * @return 当前对象
	*/
	public ResidualStrategy setResidualvalueRate(BigDecimal residualvalueRate) {
		this.residualvalueRate=residualvalueRate;
		return this;
	}
	
	/**
	 * 获得 折旧率<br>
	 * 折旧率
	 * @return 折旧率
	*/
	public BigDecimal getDepreciationRate() {
		return depreciationRate;
	}
	
	/**
	 * 设置 折旧率
	 * @param depreciationRate 折旧率
	 * @return 当前对象
	*/
	public ResidualStrategy setDepreciationRate(BigDecimal depreciationRate) {
		this.depreciationRate=depreciationRate;
		return this;
	}
	
	/**
	 * 获得 设置值<br>
	 * 设置值
	 * @return 设置值
	*/
	public String getValue() {
		return value;
	}
	
	/**
	 * 设置 设置值
	 * @param value 设置值
	 * @return 当前对象
	*/
	public ResidualStrategy setValue(String value) {
		this.value=value;
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
	public ResidualStrategy setNotes(String notes) {
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
	public ResidualStrategy setCreateBy(String createBy) {
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
	public ResidualStrategy setCreateTime(Date createTime) {
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
	public ResidualStrategy setUpdateBy(String updateBy) {
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
	public ResidualStrategy setUpdateTime(Date updateTime) {
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
	public ResidualStrategy setDeleted(Integer deleted) {
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
	public ResidualStrategy setDeleteBy(String deleteBy) {
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
	public ResidualStrategy setDeleteTime(Date deleteTime) {
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
	public ResidualStrategy setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 租户<br>
	 * 租户
	 * @return 租户
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户
	 * @param tenantId 租户
	 * @return 当前对象
	*/
	public ResidualStrategy setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ResidualStrategy , 转换好的 ResidualStrategy 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ResidualStrategy , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ResidualStrategy
	 * @param residualStrategyMap 包含实体信息的 Map 对象
	 * @return ResidualStrategy , 转换好的的 ResidualStrategy 对象
	*/
	@Transient
	public static ResidualStrategy createFrom(Map<String,Object> residualStrategyMap) {
		if(residualStrategyMap==null) return null;
		ResidualStrategy po = EntityContext.create(ResidualStrategy.class, residualStrategyMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ResidualStrategy
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ResidualStrategy , 转换好的的 ResidualStrategy 对象
	*/
	@Transient
	public static ResidualStrategy createFrom(Object pojo) {
		if(pojo==null) return null;
		ResidualStrategy po = EntityContext.create(ResidualStrategy.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ResidualStrategy，等同于 new
	 * @return ResidualStrategy 对象
	*/
	@Transient
	public static ResidualStrategy create() {
		return EntityContext.create(ResidualStrategy.class);
	}
}