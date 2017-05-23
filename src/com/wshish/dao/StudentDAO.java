package com.wshish.dao;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.wshish.po.Student;
import com.wshish.po.Subject;
import com.wshish.util.Page;

public interface StudentDAO {
	public Student findByStudentID(String studentID);//查询方法，根据学生ID查询
	public void updateStudent(Student student);//更新学生信息
	public List<Student> findByStudentName(String studentName) throws UnsupportedEncodingException;//根据学生姓名查找学生
	public List<Student> findByStudentClass(String sclass);//根据班级查找学生
	public List<Subject> findStudentByPage(Page page);//分页查询学生
	public int findStudentCount();//查询学生总数
	public Student findStudentByID(int studentID);
	public void addStudent(Student student);
}