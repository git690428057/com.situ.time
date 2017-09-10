package POJO;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {

	private int id;
	private String name;
	private int age;
	private String gender;
	private String address;
	private Date birthday;
	private String className;

	public Student() {
	}

	public Student(String name, int age, String gender, String address, Date birthday, String className, int id) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.className = className;
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Student(String name, int age, String gender, String address,
			Date birthday) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;

	}



	public Student(String name, int age, String gender, String address,
			Date birthday, int id) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.id = id;
	}

	public Student(int id) {
		super();
		this.id = id;
	}

	public Student(int id, String name, int age, String gender, String address,
			Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
	}

	

	public Student(int id, String name, int age, String gender, String address, Date birthday, String className) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.className = className;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ ", birthday=" + birthday + ", className=" + className + "]";
	}

	public Student(String name, int age, String gender, String address) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	public Student(int id2, String name2, int age2, String address2, Date birthday2) {
		// TODO Auto-generated constructor stub
	}
	

}
