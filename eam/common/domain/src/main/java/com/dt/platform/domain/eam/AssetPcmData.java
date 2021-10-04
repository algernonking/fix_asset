package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.domain.pcm.CatalogData;

import java.util.List;
import java.util.Map;


public class AssetPcmData extends Entity {

	private static final long serialVersionUID = 1L;

	private Map<String,Object> pcmData;

	private List<CatalogAttribute> attribute;


	public List<CatalogAttribute> getAttribute() {
		return attribute;
	}

	public void setAttribute(List<CatalogAttribute> attribute) {
		this.attribute = attribute;
	}



	public Map<String, Object> getPcmData() {
		return pcmData;
	}

	public void setPcmData(Map<String, Object> pcmData) {
		this.pcmData = pcmData;
	}





}