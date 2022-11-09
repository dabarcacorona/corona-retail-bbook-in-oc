package com.jadm.model;

import java.util.List;

public class JsonCab {
	
	private long id_document;
	private String purchase_order;
	private List<JsonDet> label;
	private long status;
	private String error;
	
	public JsonCab() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JsonCab(long id_document, String purchase_order, List<JsonDet> label, long status, String error) {
		super();
		this.id_document = id_document;
		this.purchase_order = purchase_order;
		this.label = label;
		this.status = status;
		this.error = error;
	}

	@Override
	public String toString() {
		return "JsonCab [id_document=" + id_document + ", purchase_order=" + purchase_order + ", label=" + label
				+ ", status=" + status + ", error=" + error + "]";
	}

	public long getId_document() {
		return id_document;
	}

	public void setId_document(long id_document) {
		this.id_document = id_document;
	}

	public String getPurchase_order() {
		return purchase_order;
	}

	public void setPurchase_order(String purchase_order) {
		this.purchase_order = purchase_order;
	}

	public List<JsonDet> getLabel() {
		return label;
	}

	public void setLabel(List<JsonDet> label) {
		this.label = label;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}


	
}
