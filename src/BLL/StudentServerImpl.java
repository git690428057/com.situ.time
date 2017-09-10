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

	// ɾ��ָ��idѧ��
	public int deleteById(int id) {
		return studentDao.deleteById(id);
	}

	// ���ѧ�������ݿ�
	public boolean add(Student student) throws NameRepeatE {
		if (studentDao.checkName(student.getName())) {
			throw new NameRepeatE("�Ѿ�����");
		} else {
			return studentDao.add(student) > 0 ? true : false;
		}
	}

	// ����ָ��idѧ����Ϣ
	public List<Student> selectById(int id) {
		return studentDao.selectById(id);
	}

	// ����ָ������ѧ����Ϣ
	public List<Student> selectByName(String name) {
		return studentDao.selectByName(name);
	}

	// ����ѧ����Ϣ
	public int update(Student student) {
		return studentDao.update(student);
	}

	// ����ָ���������������ѧ����Ϣ
	public List<Student> selectByBirthday(Date startbirthday, Date endbirthday) {
		return studentDao.selectByBirthday(startbirthday, endbirthday);
	}

	// ������Ա���ݿ�ȫ��չ��
	public List<Manager> selectAll_Manager() {
		return studentDao.selectAll_Manager();
	}

	// ��ѯָ����ַѧ����Ϣ
	public List<Student> selectByAddress(String address) {
		return studentDao.selectByAddress(address);
	}

	// ����������
	public List<Student> searchByCondition(selectCondition searchCondition) {
		return studentDao.searchByCondition(searchCondition);
	}

	// ��ҳ
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

	// ����ɾ��
	@Override
	public void deleteAll(String[] ids) {
		for (String string : ids) {
			studentDao.deleteById(Integer.parseInt(string));
		}
	}

	// չʾ�༶�б���
	@Override
	public List<ClassRoom> getClassInformation() {
		return studentDao.getClassInformation();
	}

	// չʾ�༶_�γ��б���
	@Override
	public List<Course> getClass_CourseInformation() {
		return studentDao.getClass_CourseInformation();
	}

}
