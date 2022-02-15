package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.OPS_MONITOR_TPL_GRAPH;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 模版图形
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-13 20:48:53
 * @sign D5993649EDC9F5215357BE6DE2929D76
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_monitor_tpl_graph")
public class MonitorTplGraph extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_MONITOR_TPL_GRAPH.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 模版：模版
	*/
	@ApiModelProperty(required = false,value="模版" , notes = "模版")
	private String tplCode;
	
	/**
	 * 宽度：宽度
	*/
	@ApiModelProperty(required = false,value="宽度" , notes = "宽度")
	private Integer graphWidth;
	
	/**
	 * 高度：高度
	*/
	@ApiModelProperty(required = false,value="高度" , notes = "高度")
	private Integer graphHeight;
	
	/**
	 * 图形类别：图形类别
	*/
	@ApiModelProperty(required = false,value="图形类别" , notes = "图形类别")
	private String graphType;
	
	/**
	 * 图形设置：图形设置
	*/
	@ApiModelProperty(required = false,value="图形设置" , notes = "图形设置")
	private String content;
	
	/**
	 * 数据来源：数据来源
	*/
	@ApiModelProperty(required = false,value="数据来源" , notes = "数据来源")
	private String ds;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签")
	private String label;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序")
	private Integer sort;
	
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
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本")
	private Integer version;
	
	/**
	 * 节点模版：节点模版
	*/
	@ApiModelProperty(required = false,value="节点模版" , notes = "节点模版")
	private MonitorTpl tpl;
	
	/**
	 * 指标：指标
	*/
	@ApiModelProperty(required = false,value="指标" , notes = "指标")
	private List<MonitorTplGraphItem> graphItem;
	
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
	public MonitorTplGraph setId(String id) {
		this.id=id;
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
	public MonitorTplGraph setStatus(String status) {
		this.status=status;
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
	public MonitorTplGraph setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 模版<br>
	 * 模版
	 * @return 模版
	*/
	public String getTplCode() {
		return tplCode;
	}
	
	/**
	 * 设置 模版
	 * @param tplCode 模版
	 * @return 当前对象
	*/
	public MonitorTplGraph setTplCode(String tplCode) {
		this.tplCode=tplCode;
		return this;
	}
	
	/**
	 * 获得 宽度<br>
	 * 宽度
	 * @return 宽度
	*/
	public Integer getGraphWidth() {
		return graphWidth;
	}
	
	/**
	 * 设置 宽度
	 * @param graphWidth 宽度
	 * @return 当前对象
	*/
	public MonitorTplGraph setGraphWidth(Integer graphWidth) {
		this.graphWidth=graphWidth;
		return this;
	}
	
	/**
	 * 获得 高度<br>
	 * 高度
	 * @return 高度
	*/
	public Integer getGraphHeight() {
		return graphHeight;
	}
	
	/**
	 * 设置 高度
	 * @param graphHeight 高度
	 * @return 当前对象
	*/
	public MonitorTplGraph setGraphHeight(Integer graphHeight) {
		this.graphHeight=graphHeight;
		return this;
	}
	
	/**
	 * 获得 图形类别<br>
	 * 图形类别
	 * @return 图形类别
	*/
	public String getGraphType() {
		return graphType;
	}
	
	/**
	 * 设置 图形类别
	 * @param graphType 图形类别
	 * @return 当前对象
	*/
	public MonitorTplGraph setGraphType(String graphType) {
		this.graphType=graphType;
		return this;
	}
	
	/**
	 * 获得 图形设置<br>
	 * 图形设置
	 * @return 图形设置
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 图形设置
	 * @param content 图形设置
	 * @return 当前对象
	*/
	public MonitorTplGraph setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 数据来源<br>
	 * 数据来源
	 * @return 数据来源
	*/
	public String getDs() {
		return ds;
	}
	
	/**
	 * 设置 数据来源
	 * @param ds 数据来源
	 * @return 当前对象
	*/
	public MonitorTplGraph setDs(String ds) {
		this.ds=ds;
		return this;
	}
	
	/**
	 * 获得 标签<br>
	 * 标签
	 * @return 标签
	*/
	public String getLabel() {
		return label;
	}
	
	/**
	 * 设置 标签
	 * @param label 标签
	 * @return 当前对象
	*/
	public MonitorTplGraph setLabel(String label) {
		this.label=label;
		return this;
	}
	
	/**
	 * 获得 排序<br>
	 * 排序
	 * @return 排序
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 排序
	 * @param sort 排序
	 * @return 当前对象
	*/
	public MonitorTplGraph setSort(Integer sort) {
		this.sort=sort;
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
	public MonitorTplGraph setNotes(String notes) {
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
	public MonitorTplGraph setCreateBy(String createBy) {
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
	public MonitorTplGraph setCreateTime(Date createTime) {
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
	public MonitorTplGraph setUpdateBy(String updateBy) {
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
	public MonitorTplGraph setUpdateTime(Date updateTime) {
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
	public MonitorTplGraph setDeleted(Integer deleted) {
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
	public MonitorTplGraph setDeleteBy(String deleteBy) {
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
	public MonitorTplGraph setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 版本
	 * @param version 版本
	 * @return 当前对象
	*/
	public MonitorTplGraph setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 节点模版<br>
	 * 节点模版
	 * @return 节点模版
	*/
	public MonitorTpl getTpl() {
		return tpl;
	}
	
	/**
	 * 设置 节点模版
	 * @param tpl 节点模版
	 * @return 当前对象
	*/
	public MonitorTplGraph setTpl(MonitorTpl tpl) {
		this.tpl=tpl;
		return this;
	}
	
	/**
	 * 获得 指标<br>
	 * 指标
	 * @return 指标
	*/
	public List<MonitorTplGraphItem> getGraphItem() {
		return graphItem;
	}
	
	/**
	 * 设置 指标
	 * @param graphItem 指标
	 * @return 当前对象
	*/
	public MonitorTplGraph setGraphItem(List<MonitorTplGraphItem> graphItem) {
		this.graphItem=graphItem;
		return this;
	}
	
	/**
	 * 添加 指标
	 * @param entity 指标
	 * @return 当前对象
	*/
	public MonitorTplGraph addGraphItem(MonitorTplGraphItem entity) {
		if(this.graphItem==null) graphItem=new ArrayList<>();
		this.graphItem.add(entity);
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MonitorTplGraph , 转换好的 MonitorTplGraph 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorTplGraph , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 MonitorTplGraph
	 * @param monitorTplGraphMap 包含实体信息的 Map 对象
	 * @return MonitorTplGraph , 转换好的的 MonitorTplGraph 对象
	*/
	@Transient
	public static MonitorTplGraph createFrom(Map<String,Object> monitorTplGraphMap) {
		if(monitorTplGraphMap==null) return null;
		MonitorTplGraph po = EntityContext.create(MonitorTplGraph.class, monitorTplGraphMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 MonitorTplGraph
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorTplGraph , 转换好的的 MonitorTplGraph 对象
	*/
	@Transient
	public static MonitorTplGraph createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorTplGraph po = EntityContext.create(MonitorTplGraph.class,pojo);
		return po;
	}

	/**
	 * 创建一个 MonitorTplGraph，等同于 new
	 * @return MonitorTplGraph 对象
	*/
	@Transient
	public static MonitorTplGraph create() {
		return EntityContext.create(MonitorTplGraph.class);
	}
}