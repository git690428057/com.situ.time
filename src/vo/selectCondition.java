package vo;

import java.io.Serializable;

public class selectCondition implements Serializable{
	private String id;
	private String name;
	private String age;
	private String gender;
	private String address;
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
		super();
		// TODO Auto-generated constructor stub
	}
	public selectCondition(String id, String name, String age, String gender, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	

	@Override
	public String toString() {
		return "selectByCondition [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address="
				+ address + "]";
	}
	
}
