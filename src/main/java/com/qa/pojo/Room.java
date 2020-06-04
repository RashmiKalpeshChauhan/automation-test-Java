package com.qa.pojo;
import java.util.List;

public class Room
{
    private List<Guest> guest;

  
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Room [guest=");
		builder.append(guest);
		builder.append("]");
		return builder.toString();
	}
	public void setGuest(List<Guest> guest){
        this.guest = guest;
    }
    public List<Guest> getGuest(){
        return this.guest;
    }
}
