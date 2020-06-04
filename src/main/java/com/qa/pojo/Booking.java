package com.qa.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Booking {
	
private Dates dates;
private String destination;
private List<Room> room = null;
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Booking [dates=");
	builder.append(dates);
	builder.append(", destination=");
	builder.append(destination);
	builder.append(", room=");
	builder.append(room);
	builder.append(", placeId=");
	builder.append(placeId);
	builder.append("]");
	return builder.toString();
}
	
private String placeId;

public Dates getDates() {
	return dates;
}
public void setDates(Dates dates) {
	this.dates = dates;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public List<Room> getRoom() {
	return room;
}
public void setRoom(List<Room> room) {
	this.room = room;
}
public String getPlaceId() {
	return placeId;
}
public void setPlaceId(String placeId) {
	this.placeId = placeId;
}



}