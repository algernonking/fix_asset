package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_BORROW_RETURN;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-22 13:16:02
 * @sign 6A8A10243BB7E5E2D5D57680CBA079B6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_borrow_return")
public class AssetBorrowReturn extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_BORROW_RETURN.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 借用单：借用单
	*/
	@ApiModelProperty(required = false,value="借用单" , notes = "借用单")
	private String borrowId;
	
	/**
	 * 归还时间：归还时间
	*/
	@ApiModelProperty(required = false,value="归还时间" , notes = "归还时间")
	private Date returnDate;
	
	/**
	 * 归还说明：归还说明
	*/
	@ApiModelProperty(required = false,value="归还说明" , notes = "归还说明")
	private String content;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
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
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private List<Asset> assetList;
	
	/**
	 * 资产列表：资产列表
	*/
	@ApiModelProperty(required = false,value="资产列表" , notes = "资产列表")
	private List<String> assetIds;
	
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
	public AssetBorrowReturn setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 借用单<br>
	 * 借用单
	 * @return 借用单
	*/
	public String getBorrowId() {
		return borrowId;
	}
	
	/**
	 * 设置 借用单
	 * @param borrowId 借用单
	 * @return 当前对象
	*/
	public AssetBorrowReturn setBorrowId(String borrowId) {
		this.borrowId=borrowId;
		return this;
	}
	
	/**
	 * 获得 归还时间<br>
	 * 归还时间
	 * @return 归还时间
	*/
	public Date getReturnDate() {
		return returnDate;
	}
	
	/**
	 * 设置 归还时间
	 * @param returnDate 归还时间
	 * @return 当前对象
	*/
	public AssetBorrowReturn setReturnDate(Date returnDate) {
		this.returnDate=returnDate;
		return this;
	}
	
	/**
	 * 获得 归还说明<br>
	 * 归还说明
	 * @return 归还说明
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 归还说明
	 * @param content 归还说明
	 * @return 当前对象
	*/
	public AssetBorrowReturn setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public String getOriginatorId() {
		return originatorId;
	}
	
	/**
	 * 设置 制单人
	 * @param originatorId 制单人
	 * @return 当前对象
	*/
	public AssetBorrowReturn setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
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
	public AssetBorrowReturn setCreateBy(String createBy) {
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
	public AssetBorrowReturn setCreateTime(Date createTime) {
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
	public AssetBorrowReturn setUpdateBy(String updateBy) {
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
	public AssetBorrowReturn setUpdateTime(Date updateTime) {
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
	public AssetBorrowReturn setDeleted(Integer deleted) {
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
	public AssetBorrowReturn setDeleteBy(String deleteBy) {
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
	public AssetBorrowReturn setDeleteTime(Date deleteTime) {
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
	public AssetBorrowReturn setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public List<Asset> getAssetList() {
		return assetList;
	}
	
	/**
	 * 设置 资产
	 * @param assetList 资产
	 * @return 当前对象
	*/
	public AssetBorrowReturn setAssetList(List<Asset> assetList) {
		this.assetList=assetList;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param asset 资产
	 * @return 当前对象
	*/
	public AssetBorrowReturn addAsset(Asset asset) {
		if(this.assetList==null) assetList=new ArrayList<>();
		this.assetList.add(asset);
		return this;
	}
	
	/**
	 * 获得 资产列表<br>
	 * 资产列表
	 * @return 资产列表
	*/
	public List<String> getAssetIds() {
		return assetIds;
	}
	
	/**
	 * 设置 资产列表
	 * @param assetIds 资产列表
	 * @return 当前对象
	*/
	public AssetBorrowReturn setAssetIds(List<String> assetIds) {
		this.assetIds=assetIds;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param assetId 资产列表
	 * @return 当前对象
	*/
	public AssetBorrowReturn addAssetId(String assetId) {
		if(this.assetIds==null) assetIds=new ArrayList<>();
		this.assetIds.add(assetId);
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetBorrowReturn , 转换好的 AssetBorrowReturn 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetBorrowReturn , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetBorrowReturn
	 * @param assetBorrowReturnMap 包含实体信息的 Map 对象
	 * @return AssetBorrowReturn , 转换好的的 AssetBorrowReturn 对象
	*/
	@Transient
	public static AssetBorrowReturn createFrom(Map<String,Object> assetBorrowReturnMap) {
		if(assetBorrowReturnMap==null) return null;
		AssetBorrowReturn po = EntityContext.create(AssetBorrowReturn.class, assetBorrowReturnMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetBorrowReturn
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetBorrowReturn , 转换好的的 AssetBorrowReturn 对象
	*/
	@Transient
	public static AssetBorrowReturn createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetBorrowReturn po = EntityContext.create(AssetBorrowReturn.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetBorrowReturn，等同于 new
	 * @return AssetBorrowReturn 对象
	*/
	@Transient
	public static AssetBorrowReturn create() {
		return EntityContext.create(AssetBorrowReturn.class);
	}
}