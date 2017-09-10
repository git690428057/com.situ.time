package DAO;

import java.util.Date;
import java.util.List;

import POJO.Manager;
import POJO.Student;
import vo.PageBean;
import vo.selectCondition;

public interface IStudentDao {
	// ���ѧ�������ݿ�
	public int add(Student student);

	// ����ѧ����Ϣ
	public int update(Student student);

	// ��������ѧ����Ϣ
	public List<Student> selectAll();

	// ɾ��ָ��idѧ��
	public int deleteById(int id);

	// ����ָ��idѧ����Ϣ
	public List<Student> selectById(int id);

	// ����ָ������ѧ����Ϣ
	public List<Student> selectByName(String name);

	// ����ָ���������������ѧ����Ϣ
	public List<Student> selectByBirthday(Date startbirthday, Date endbirthday);

	// �ж���ӵ��û������ݿ����Ƿ����(������)
	public boolean checkName(String name);

	// ������Ա���ݿ�ȫ��չ��
	public List<Manager> selectAll_Manager();

	// ��ѯָ����ַѧ����Ϣ
	public List<Student> selectByAddress(String address);

	// ����������
	public List<Student> searchByCondition(selectCondition searchCondition);

	// ��ҳ��ʾ
	public List<Student> findPageBeanList(int index, int pageSize);

	// ��ҳ---������ݿ�����Ϣ����
	public int getTotalCount();

}
