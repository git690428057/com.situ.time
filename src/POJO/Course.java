package POJO;

import java.io.Serializable;

public class Course implements Serializable {
	private Integer id;
	private Integer classId;
	private String className;
	private Integer coureId;
	private String coureName;
	private double credit;

	public Course() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getCoureId() {
		return coureId;
	}

	public void setCoureId(Integer coureId) {
		this.coureId = coureId;
	}

	public String getCoureName() {
		return coureName;
	}

	public void setCoureName(String coureName) {
		this.coureName = coureName;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public Course(Integer id, Integer classId, String className, Integer coureId, String coureName, double credit) {
		super();
		this.id = id;
		this.classId = classId;
		this.className = className;
		this.coureId = coureId;
		this.coureName = coureName;
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", classId=" + classId + ", className=" + className + ", coureId=" + coureId
				+ ", coureName=" + coureName + ", credit=" + credit + "]";
	}

}
