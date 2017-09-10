package vo;

import java.io.Serializable;

public class selectCondition implements Serializable{
	private String id;
	private String name;
	private String age;
	private String gender;
	private String address;
	private String startBirthday;
	private String endBirthday;
	private String className;
	
	public String getStartBirthday() {
		return startBirthday;
	}
	public void setStartBirthday(String startBirthday) {
		this.startBirthday = startBirthday;
	}
	public String getEndBirthday() {
		return endBirthday;
	}
	public void setEndBirthday(String endBirthday) {
		this.endBirthday = endBirthday;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public selectCondition() {
	}
	
	public selectCondition(String id, String name, String age, String gender, String address, String startBirthday,
			String endBirthday, String className) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.startBirthday = startBirthday;
		this.endBirthday = endBirthday;
		this.className = className;
	}
	@Override
	public String toString() {
		return "selectCondition [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address="
				+ address + ", startBirthday=" + startBirthday + ", endBirthday=" + endBirthday + ", className="
				+ className + "]";
	}
	
	
}
