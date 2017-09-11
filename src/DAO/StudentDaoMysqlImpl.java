package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import POJO.ClassRoom;
import POJO.Course;
import POJO.Manager;
import POJO.Student;
import vo.selectCondition;

public class StudentDaoMysqlImpl implements IStudentDao {
	static Connection connection = null;
	static PreparedStatement preparedStatement = null;
	static ResultSet resultSet = null;

	@Override
	// **********************添加学生方法**********************
	public int add(Student student) {
		int result = 0;
		try {
			connection = DBUtil.getConnection();
			String sql = "insert into Student(name,age,gender,address,birthday,classid) values(?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.setString(4, student.getAddress());
			preparedStatement.setDate(5, new java.sql.Date(student.getBirthday().getTime()));
			preparedStatement.setInt(6, student.getClassId());
			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
			System.out.println();
		}
		return result;
	}

	@Override
	// **********************删除指定id的学生方法**********************
	public int deleteById(int id) {
		int result = 0;
		try {
			connection = DBUtil.getConnection();
			String sql = "delete from Student where id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		return result;
	}

	@Override
	// **********************修改指定ID的学生信息方法**********************
	public int update(Student student) {
		int result = 0;
		try {
			connection = DBUtil.getConnection();
			String sql = "update student INNER JOIN class on student.classid=class.id set student.name = ?,student.age = ?, student.gender =?,student.address = ?,student.birthday = ?,class.name=? where student.id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.setString(4, student.getAddress());
			preparedStatement.setDate(5, new java.sql.Date(student.getBirthday().getTime()));
			preparedStatement.setString(6, student.getClassName());
			preparedStatement.setInt(7, student.getId());
			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		return result;
	}

	@Override
	// **********************查看指定id的学生信息**********************
	public List<Student> selectById(int id) {
		List<Student> studentsList = new ArrayList<Student>();
		try {
			Student student = new Student();
			connection = DBUtil.getConnection();
			String sql = "SELECT student.id,student.name,student.age,student.gender,student.address,student.birthday,class.name FROM student INNER JOIN class on student.classid=class.id  AND student.id=?";
			// String sql = "select * from Student where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					int id1 = resultSet.getInt("student.id");
					String name = resultSet.getString("student.name");
					int age = resultSet.getInt("student.age");
					String gender = resultSet.getString("student.gender");
					String address = resultSet.getString("student.address");
					Date birthday = resultSet.getDate("student.birthday");
					String className = resultSet.getString("class.name");
					student = new Student(id1, name, age, gender, address, birthday, className);
					studentsList.add(student);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
			System.out.println();
		}
		return studentsList;
	}

	@Override
	// **********************查看指定名字的学生信息**********************
	public List<Student> selectByName(String name) {
		List<Student> studentsList = new ArrayList<Student>();
		try {
			Student student = new Student();
			connection = DBUtil.getConnection();
			String sql = "select * from Student where name = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String name1 = resultSet.getString("name");
					int age = resultSet.getInt("age");
					String gender = resultSet.getString("gender");
					String address = resultSet.getString("address");
					Date birthday = resultSet.getDate("birthday");
					student = new Student(id, name1, age, gender, address, birthday);
					studentsList.add(student);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
			System.out.println();
		}
		return studentsList;
	}

	// 检查数据库是否有与被添加学生名字相同的存在
	public boolean checkName(String name) {
		boolean isBe = false;
		try {
			connection = DBUtil.getConnection();
			String sql = "select id from Student where name = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				isBe = true;
			} else {
				isBe = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
			System.out.println();
		}
		return isBe;
	}

	// 查找指定出生日期区间的学生信息
	public List<Student> selectByBirthday(Date startbirthday, Date endbirthday) {
		List<Student> studentsList = new ArrayList<Student>();
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from Student where birthday   between ? AND ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDate(1, new java.sql.Date(startbirthday.getTime()));
			preparedStatement.setDate(2, new java.sql.Date(endbirthday.getTime()));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Date birthday = resultSet.getDate("birthday");
				Student student = new Student(id, name, age, gender, address, birthday);
				studentsList.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
			System.out.println();
		}
		return studentsList;
	}

	// 管理人员数据库全部展开
	@Override
	public List<Manager> selectAll_Manager() {
		List<Manager> list = new ArrayList<Manager>();
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from managers;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				String account = resultSet.getString("account");
				String password = resultSet.getString("password");
				Manager manager = new Manager(id, name, age, gender, address, account, password);
				list.add(manager);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 查询指定地址学生信息
	public List<Student> selectByAddress(String address) {
		List<Student> studentsList = new ArrayList<Student>();
		try {
			Student student = new Student();
			connection = DBUtil.getConnection();
			String sql = "select * from Student where address = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, address);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					int age = resultSet.getInt("age");
					String gender = resultSet.getString("gender");
					String address1 = resultSet.getString("address");
					Date birthday = resultSet.getDate("birthday");
					student = new Student(id, name, age, gender, address1, birthday);
					studentsList.add(student);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
			System.out.println();
		}
		return studentsList;
	}

	// 多条件搜索
	public List<Student> searchByCondition(selectCondition searchCondition) {
		List<Student> studentsList = new ArrayList<Student>();
		try {
			connection = DBUtil.getConnection();
			String sql = "SELECT student.*,class.name FROM student INNER JOIN class on student.classid=class.id where 1=1";
			List<String> list = new ArrayList<String>();
			if (!searchCondition.getId().isEmpty()) {
				sql += " and student.id = ? ";
				list.add(searchCondition.getId());
			}
			if (!searchCondition.getName().isEmpty()) {
				sql += " and student.name like ? ";
				list.add("%" + searchCondition.getName() + "%");
			}
			if (!searchCondition.getAge().isEmpty()) {
				sql += " and student.age = ? ";
				list.add(searchCondition.getAge());
			}
			if (!searchCondition.getGender().isEmpty()) {
				sql += " and student.gender = ? ";
				list.add(searchCondition.getGender());
			}
			if (!searchCondition.getAddress().isEmpty()) {
				sql += " and student.address = ? ";
				list.add(searchCondition.getAddress());
			}
			if (!searchCondition.getStartBirthday().isEmpty()&&!searchCondition.getEndBirthday().isEmpty()) {
				sql += " and student.birthday between ? and ? ";
				list.add(searchCondition.getStartBirthday());
				list.add(searchCondition.getEndBirthday());
			}
			if (!searchCondition.getClassName().isEmpty()) {
				sql += " and student.classid = ? ";
				list.add(searchCondition.getClassName());
			}
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < list.size(); i++) {
				preparedStatement.setObject(i + 1, list.get(i));
			}
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("student.id");
				String name = resultSet.getString("student.name");
				int age = resultSet.getInt("student.age");
				String gender = resultSet.getString("student.gender");
				String address = resultSet.getString("student.address");
				Date birthday = resultSet.getDate("student.birthday");
				String className = resultSet.getString("class.name");
				Student student = new Student(id, name, age, gender, address, birthday,className);
				studentsList.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentsList;
	}

	// 分页显示
	public List<Student> findPageBeanList(int index, int pageSize) {
		List<Student> list = new ArrayList<Student>();
		try {
			connection = DBUtil.getConnection();
			String sql = "SELECT student.*,class.name FROM student INNER JOIN class on student.classid=class.id limit ?,?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, index);
			preparedStatement.setInt(2, pageSize);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("student.id");
				String name = resultSet.getString("student.name");
				int age = resultSet.getInt("student.age");
				String gender = resultSet.getString("student.gender");
				String address = resultSet.getString("student.address");
				Date birthday = resultSet.getDate("student.birthday");
				String className = resultSet.getString("class.name");
				Student student = new Student(id, name, age, gender, address, birthday, className);
				list.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 分页---获得数据库中信息总数
	public int getTotalCount() {
		int count = 0;
		try {
			connection = DBUtil.getConnection();
			String sql = "select count(*) from student";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		return count;
	}

	/**
	 * 多表查询区域
	 */

	/*
	 * 班级表展开(id,class.name,class.teacher++++总人数)
	 */
	@Override
	public List<ClassRoom> getClassInformation() {
		List<ClassRoom> list = new ArrayList<ClassRoom>();
		try {
			connection=DBUtil.getConnection();
			String sql = 
					"SELECT class.id, class.`name`, class.teacher,COUNT(*) '总人数'"
					+ " FROM class INNER JOIN student ON class.id = student.classid"
					+ " GROUP BY class.`name` ORDER BY class.id";
			preparedStatement=connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("class.id");
				String className = resultSet.getString("class.name");
				String teacher = resultSet.getString("class.teacher");
				int studentCount = resultSet.getInt("总人数");
				ClassRoom class1 = new ClassRoom(id, className, teacher, studentCount);
				list.add(class1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/*
	 * 班级_课程表展开(id,classid,class.name,courseid,coursename)
	 */
	@Override
	public List<Course> getClass_CourseInformation() {
		List<Course> list = new ArrayList<Course>();
		try {
			connection=DBUtil.getConnection();
			String sql = "SELECT class_course.id, class_course.classid,class.`name` ,class_course.courseid,course.`name`,course.credit"
					+ " FROM class_course "
					+ "LEFT JOIN class ON class_course.classid = class.id "
					+ "RIGHT JOIN course ON course.id = class_course.courseid "
					+ "ORDER BY class_course.id";
			preparedStatement=connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("class_course.id");
				int classId = resultSet.getInt("class_course.classid");
				String className = resultSet.getString("class.name");
				int coureId = resultSet.getInt("class_course.courseid");
				String coureName = resultSet.getString("course.name");
				double credit = resultSet.getDouble("course.credit");
				Course course = new Course(id, classId, className, coureId, coureName,credit);
				list.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
