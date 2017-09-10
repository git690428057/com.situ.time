package BLL;

import java.util.Date;
import java.util.List;

import DIYexception.NameRepeatE;
import POJO.Manager;
import POJO.Student;
import vo.PageBean;
import vo.selectCondition;

public interface IStudentServers {
	// 查找所有学生信息
	List<Student> selectAll();

	// 删除指定id学生
	int deleteById(int id);

	// 添加学生到数据库
	boolean add(Student student) throws NameRepeatE;

	// 查找指定id学生信息
	List<Student> selectById(int id);

	// 查找指定名字学生信息
	List<Student> selectByName(String name);

	// 更新学生信息
	int update(Student student);

	// 查找指定出生日期区间的学生信息
	List<Student> selectByBirthday(Date startbirthday, Date endbirthday);

	// 管理人员数据库全部展开
	List<Manager> selectAll_Manager();

	// 查询指定地址学生信息
	List<Student> selectByAddress(String address);

	// 多条件搜索
	List<Student> searchByCondition(selectCondition searchCondition);

	// 分页
	PageBean getPageBean(int pageIndex, int pageSize);

	// 批量删除
	void deleteAll(String[] ids);

}
