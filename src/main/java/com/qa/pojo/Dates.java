package com.qa.pojo;

public class Dates
{
    private String checkin;

    private String checkout;

    public void setCheckin(String checkin){
        this.checkin = checkin;
    }
    public String getCheckin(){
        return this.checkin;
    }
    public void setCheckout(String checkout){
        this.checkout = checkout;
    }
    public String getCheckout(){
        return this.checkout;
    }
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dates [checkin=");
		builder.append(checkin);
		builder.append(", checkout=");
		builder.append(checkout);
		builder.append("]");
		return builder.toString();
	}
	
}

