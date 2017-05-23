package com.wshish.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wshish.po.Student;
import com.wshish.service.StudentService;
import com.wshish.service.StudentServiceImpl;

//该Action用来接收试题参数，并调用业务逻辑组件SubjectService来完成试题添加
public class RegisterAction extends ActionSupport{
	private String studentID;
	private String studentName;
	private String sclass;
	private String password;
	
	private StudentService studentService = new StudentServiceImpl();
	
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		Student student = new Student();
		student.setStudentID(studentID);
		student.setStudentName(studentName);
		student.setSclass(sclass);
		student.setPassword(password);
		if(studentService.saveStudent(student)) {
			return SUCCESS;
		}else {
			this.addActionError("该学号已被注册，请不要重复注册!");
			return INPUT;
		}
	}
}