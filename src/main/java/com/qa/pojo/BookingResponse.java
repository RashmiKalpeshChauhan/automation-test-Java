package com.qa.pojo;

public class BookingResponse {
	
	
	private String type;
	private String query;
	private String queryParameters;
	private QueryParametersObj queryParametersObj;
	private boolean isCountry;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getQueryParameters() {
		return queryParameters;
	}
	public void setQueryParameters(String queryParameters) {
		this.queryParameters = queryParameters;
	}
	public QueryParametersObj getQueryParametersObj() {
		return queryParametersObj;
	}
	public void setQueryParametersObj(QueryParametersObj queryParametersObj) {
		this.queryParametersObj = queryParametersObj;
	}
	public boolean isCountry() {
		return isCountry;
	}
	public void setCountry(boolean isCountry) {
		this.isCountry = isCountry;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookingResponse [type=");
		builder.append(type);
		builder.append(", query=");
		builder.append(query);
		builder.append(", queryParameters=");
		builder.append(queryParameters);
		builder.append(", queryParametersObj=");
		builder.append(queryParametersObj);
		builder.append(", isCountry=");
		builder.append(isCountry);
		builder.append("]");
		return builder.toString();
	}
	
}
