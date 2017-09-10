package BLL;

import java.util.Date;
import java.util.List;

import DIYexception.NameRepeatE;
import POJO.ClassRoom;
import POJO.Course;
import POJO.Manager;
import POJO.Student;
import vo.PageBean;
import vo.selectCondition;

public interface IStudentServers {

	// ɾ��ָ��idѧ��
	int deleteById(int id);

	// ���ѧ�������ݿ�
	boolean add(Student student) throws NameRepeatE;

	// ����ָ��idѧ����Ϣ
	List<Student> selectById(int id);

	// ����ָ������ѧ����Ϣ
	List<Student> selectByName(String name);

	// ����ѧ����Ϣ
	int update(Student student);

	// ����ָ���������������ѧ����Ϣ
	List<Student> selectByBirthday(Date startbirthday, Date endbirthday);

	// ������Ա���ݿ�ȫ��չ��
	List<Manager> selectAll_Manager();

	// ��ѯָ����ַѧ����Ϣ
	List<Student> selectByAddress(String address);

	// ����������
	List<Student> searchByCondition(selectCondition searchCondition);

	// ��ҳ
	PageBean getPageBean(int pageIndex, int pageSize);

	// ����ɾ��
	void deleteAll(String[] ids);

	// չʾ�༶�б���
	List<ClassRoom> getClassInformation();

	// չʾ�༶_�γ��б���
	List<Course> getClass_CourseInformation();

}
