package DAO;

import java.util.Date;
import java.util.List;

import POJO.Manager;
import POJO.Student;
import vo.PageBean;
import vo.selectCondition;

public interface IStudentDao {
	// 添加学生到数据库
	public int add(Student student);

	// 更新学生信息
	public int update(Student student);

	// 查找所有学生信息
	public List<Student> selectAll();

	// 删除指定id学生
	public int deleteById(int id);

	// 查找指定id学生信息
	public List<Student> selectById(int id);

	// 查找指定名字学生信息
	public List<Student> selectByName(String name);

	// 查找指定出生日期区间的学生信息
	public List<Student> selectByBirthday(Date startbirthday, Date endbirthday);

	// 判断添加的用户在数据库中是否存在(按名字)
	public boolean checkName(String name);

	// 管理人员数据库全部展开
	public List<Manager> selectAll_Manager();

	// 查询指定地址学生信息
	public List<Student> selectByAddress(String address);

	// 多条件搜索
	public List<Student> searchByCondition(selectCondition searchCondition);

	// 分页显示
	public List<Student> findPageBeanList(int index, int pageSize);

	// 分页---获得数据库中信息总数
	public int getTotalCount();

}
