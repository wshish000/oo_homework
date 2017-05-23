package com.wshish.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.wshish.dao.StudentDAO;
import com.wshish.dao.StudentDAOImpl;
import com.wshish.po.Student;
import com.wshish.po.Subject;
import com.wshish.util.Page;
import com.wshish.util.PageResult;
import com.wshish.util.PageUtil;

public class StudentServiceImpl implements StudentService{
	private StudentDAO studentDAO = new StudentDAOImpl();
	
	public boolean allowLogin(String studentID, String password) {
		
		Student student = studentDAO.findByStudentID(studentID);
		if(student == null) {//判断是否存在该ID的学生
			return false;
		}else {
			if(password.equals(student.getPassword())) {//判断密码是否相同
				return true;
			}else{
				return false;
			}
			
		}
	}

	public Student getStudentInfo(String studentID) {
		return studentDAO.findByStudentID(studentID);
	}

	public void setStudentResult(String studentID, int result) {
		Student student = studentDAO.findByStudentID(studentID);//根据ID查找到该学生
		student.setResult(result);//设置其成绩
		studentDAO.updateStudent(student);//更新学生信息
	}

	public List<Student> getStudentByName(String studentName) throws UnsupportedEncodingException {
		return studentDAO.findByStudentName(studentName);
	}

	public List<Student> getStudentByClass(String sclass) {
		return studentDAO.findByStudentClass(sclass);
	}
	
	public PageResult queryStudentByPage(Page page) {
		page = PageUtil.createPage(page.getEveryPage(),
				studentDAO.findStudentCount(),page.getCurrentPage());//根据总记录数创建分页信息
		List<Subject> list = studentDAO.findStudentByPage(page);//通过分页信息取得试题
		PageResult result = new PageResult(page,list);//封装分页信息和记录信息，返回给调用处
		return result;
	}

	@Override
	public Student showStudentParticular(int studentID) {
		return studentDAO.findStudentByID(studentID);
	}
	
	@Override
	public boolean saveStudent(Student student){
		String studentID = student.getStudentID();
		if(studentDAO.findByStudentID(studentID) == null){ //如果该试题标题不存在，允许添加
			studentDAO.addStudent(student);
			return true;
		}else {
			return false;
		}
	}

}