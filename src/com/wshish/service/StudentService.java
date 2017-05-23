package com.wshish.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.wshish.po.Student;
import com.wshish.po.Subject;
import com.wshish.util.Page;
import com.wshish.util.PageResult;

public interface StudentService {
	//判断是否为合法学生，从而决定是否允许登录
	public boolean allowLogin(String studentID,String password);
	//获得学生信息
	public Student getStudentInfo(String studentID);
	//设置学生成绩
	public void setStudentResult(String studentID,int result);
	//根据学生姓名查找学生
	public List<Student> getStudentByName(String studentName) throws UnsupportedEncodingException;
	//根据班级查找学生
	public List<Student> getStudentByClass(String sclass);
	//分页显示学生
	public PageResult queryStudentByPage(Page page);
	// 查看学生详细信息
	public Student showStudentParticular(int studentID);
	//保存注册学生的信息
	public boolean saveStudent(Student student);
}