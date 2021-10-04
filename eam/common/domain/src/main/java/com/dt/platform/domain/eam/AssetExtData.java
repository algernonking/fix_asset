package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.domain.pcm.CatalogData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AssetExtData extends Entity {

	private static final long serialVersionUID = 1L;


	private String id;
	private String tenantId;
	private String ownerId;
	private HashMap<String,Object> data;
	private List<CatalogAttribute> attribute;



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}

	public List<CatalogAttribute> getAttribute() {
		return attribute;
	}
	public void setAttribute(List<CatalogAttribute> attribute) {
		this.attribute = attribute;
	}





}