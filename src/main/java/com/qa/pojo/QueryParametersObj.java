package com.qa.pojo;

import java.util.List;

public class QueryParametersObj {

	private String sortBy;
	private int isGeo;
	private String hId;
	private String isCountry;
	private String placeId;
	private List <String> types;
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public int getIsGeo() {
		return isGeo;
	}
	public void setIsGeo(int isGeo) {
		this.isGeo = isGeo;
	}
	public String gethId() {
		return hId;
	}
	public void sethId(String hId) {
		this.hId = hId;
	}
	public String getIsCountry() {
		return isCountry;
	}
	public void setIsCountry(String isCountry) {
		this.isCountry = isCountry;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryParametersObj [sortBy=");
		builder.append(sortBy);
		builder.append(", isGeo=");
		builder.append(isGeo);
		builder.append(", hId=");
		builder.append(hId);
		builder.append(", isCountry=");
		builder.append(isCountry);
		builder.append(", placeId=");
		builder.append(placeId);
		builder.append(", types=");
		builder.append(types);
		builder.append("]");
		return builder.toString();
	}

}
