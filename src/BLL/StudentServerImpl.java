package BLL;

import java.util.Date;
import java.util.List;

import DAO.IStudentDao;
import DAO.StudentDaoMysqlImpl;
import DIYexception.NameRepeatE;
import POJO.ClassRoom;
import POJO.Course;
import POJO.Manager;
import POJO.Student;
import vo.PageBean;
import vo.selectCondition;

public class StudentServerImpl implements IStudentServers {
	private IStudentDao studentDao = new StudentDaoMysqlImpl();

	// 删除指定id学生
	public int deleteById(int id) {
		return studentDao.deleteById(id);
	}

	// 添加学生到数据库
	public boolean add(Student student) throws NameRepeatE {
		if (studentDao.checkName(student.getName())) {
			throw new NameRepeatE("已经存在");
		} else {
			return studentDao.add(student) > 0 ? true : false;
		}
	}

	// 查找指定id学生信息
	public List<Student> selectById(int id) {
		return studentDao.selectById(id);
	}

	// 查找指定名字学生信息
	public List<Student> selectByName(String name) {
		return studentDao.selectByName(name);
	}

	// 更新学生信息
	public int update(Student student) {
		return studentDao.update(student);
	}

	// 查找指定出生日期区间的学生信息
	public List<Student> selectByBirthday(Date startbirthday, Date endbirthday) {
		return studentDao.selectByBirthday(startbirthday, endbirthday);
	}

	// 管理人员数据库全部展开
	public List<Manager> selectAll_Manager() {
		return studentDao.selectAll_Manager();
	}

	// 查询指定地址学生信息
	public List<Student> selectByAddress(String address) {
		return studentDao.selectByAddress(address);
	}

	// 多条件搜索
	public List<Student> searchByCondition(selectCondition searchCondition) {
		return studentDao.searchByCondition(searchCondition);
	}

	// 分页
	@Override
	public PageBean getPageBean(int pageIndex, int pageSize) {
		PageBean pageBean = new PageBean();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalCount = studentDao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		List<Student> list = studentDao.findPageBeanList(index, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	// 批量删除
	@Override
	public void deleteAll(String[] ids) {
		for (String string : ids) {
			studentDao.deleteById(Integer.parseInt(string));
		}
	}

	// 展示班级列表方法
	@Override
	public List<ClassRoom> getClassInformation() {
		return studentDao.getClassInformation();
	}

	// 展示班级_课程列表方法
	@Override
	public List<Course> getClass_CourseInformation() {
		return studentDao.getClass_CourseInformation();
	}

}
