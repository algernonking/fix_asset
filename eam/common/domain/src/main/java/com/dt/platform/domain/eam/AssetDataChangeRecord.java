package com.dt.platform.domain.eam;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Table;
import java.util.*;

public class AssetDataChangeRecord extends Asset {
	private static final long serialVersionUID = 1L;

	/**
	 * 变更类型：变更类型
	 */
	@ApiModelProperty(required = false,value="变更类型" , notes = "变更类型")
	private String changeType;

	/**
	 * 资产变更：资产变更
	 */
	@ApiModelProperty(required = false,value="资产变更" , notes = "资产变更")
	private String assetChangeId;

	/**
	 * 变更日期：变更日期
	 */
	@ApiModelProperty(required = false,value="变更日期" , notes = "变更日期")
	private Date changeDate;

	/**
	 * 备注：备注
	 */
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String changeNotes;


	/**
	 * 选择数据：选择数据
	 */
	@ApiModelProperty(required = false,value="选择数据" , notes = "选择数据")
	private String selectedCode;

	/**
	 * 变更实体：变更实体
	 */
	@ApiModelProperty(required = false,value="变更实体" , notes = "变更实体")
	private AssetDataChange assetDataChange;

	/**
	 * 业务名称：业务名称
	 */
	@ApiModelProperty(required = false,value="业务名称" , notes = "业务名称")
	private String businessName;



	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}


	public AssetDataChange getAssetDataChange() {
		return assetDataChange;
	}

	public void setAssetDataChange(AssetDataChange assetDataChange) {
		this.assetDataChange = assetDataChange;
	}


	public String getChangeType() {
		return changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

	public String getAssetChangeId() {
		return assetChangeId;
	}

	public void setAssetChangeId(String assetChangeId) {
		this.assetChangeId = assetChangeId;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public String getChangeNotes() {
		return changeNotes;
	}

	public void setChangeNotes(String changeNotes) {
		this.changeNotes = changeNotes;
	}

	public String getSelectedCode() {
		return selectedCode;
	}

	public void setSelectedCode(String selectedCode) {
		this.selectedCode = selectedCode;
	}

}