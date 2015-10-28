package com.yy.entity;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
	private String id;
	private String name;
	private String pId;
	private String open;
	private String isshow;

	public String getIsshow() {
		return isshow;
	}

	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}

	private String url;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getFile() {
		return url;
	}

	// public FunTree(String id, String name, String pId, String open, String
	// url) {
	// super();
	// this.id = id;
	// this.name = name;
	// this.pId = pId;
	// this.open = open;
	// this.url = url;
	// }

	public void setUrl(String url) {
		this.url = url;
	}

	public FamilyTree() {
	}

}
