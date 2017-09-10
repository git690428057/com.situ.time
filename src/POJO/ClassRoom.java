package POJO;

import java.io.Serializable;

public class ClassRoom implements Serializable {
	private Integer id;
	private String className;
	private String teacher;
	private Integer studentCount;

	public ClassRoom() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public Integer getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(Integer studentCount) {
		this.studentCount = studentCount;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", className=" + className + ", teacher=" + teacher + ", studentCount="
				+ studentCount + "]";
	}

	public ClassRoom(Integer id, String className, String teacher, Integer studentCount) {
		super();
		this.id = id;
		this.className = className;
		this.teacher = teacher;
		this.studentCount = studentCount;
	}

}
