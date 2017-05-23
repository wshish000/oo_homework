package com.wshish.dao;

import java.util.Iterator;
import java.util.List;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wshish.hibernate.HibernateSessionFactory;
import com.wshish.po.Student;
import com.wshish.po.Subject;
import com.wshish.util.Page;

public class StudentDAOImpl implements StudentDAO{
	public Student findByStudentID(String studentID) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Student student = (Student) session.get(Student.class, studentID);
		HibernateSessionFactory.closeSession();//关闭Session对象
		return student;
	}

	public void updateStudent(Student student) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Transaction  transaction = null;//声明一个事务对象
		try{
			transaction = session.beginTransaction();//开启事务
			session.update(student);//更新学生信息
			transaction.commit();//提交事务
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//事务回滚
		}
		HibernateSessionFactory.closeSession();//关闭Session对象
	}

	public List<Student> findByStudentName(String studentName) {
		System.out.println(studentName);
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Query query = session.createQuery("from Student as stu where stu.studentName = ?");
		query.setString(0, studentName);
		List list = query.list();					//查询结果保存到list中
		HibernateSessionFactory.closeSession();		//关闭Session对象
		return list;
	}

	public List<Student> findByStudentClass(String sclass) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Query query = session.createQuery("from Student as stu where stu.sclass = ?");
		query.setString(0, sclass);
		List list = query.list();					//查询结果保存到list中
		HibernateSessionFactory.closeSession();		//关闭Session对象
		return list;
	}

	@Override
	public int findStudentCount() {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Query query = session.createQuery("from Student");
		List list = query.list();					//查询结果保存到list中
		int count = list.size();
		HibernateSessionFactory.closeSession();//关闭Session对象
		return count;
	}

	@Override
	public List<Subject> findStudentByPage(Page page) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Query query = session.createQuery("from Student");
		query.setMaxResults(page.getEveryPage());//设置查询记录数
		query.setFirstResult(page.getBeginIndex());//设置查询记录起始位置
		List list = query.list();					//查询结果保存到list中
		HibernateSessionFactory.closeSession();//关闭Session对象
		return list;
	}

	@Override
	public Student findStudentByID(int studentID) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Student student = (Student) session.get(Student.class, studentID);
		HibernateSessionFactory.closeSession();		//关闭Session对象
		return student;
	}
	public void addStudent(Student student){
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Transaction  transaction = null;//声明一个事务对象
		try{
			transaction = session.beginTransaction();//开启事务
			session.save(student);//保存试题信息
			transaction.commit();//提交事务
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//事务回滚
		}
		HibernateSessionFactory.closeSession();//关闭Session对象
	}
}