package com.qa.pojo;

public class Guest
{
    private String type;
    private int  age;
    


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Guest [type=");
		builder.append(type);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
}
