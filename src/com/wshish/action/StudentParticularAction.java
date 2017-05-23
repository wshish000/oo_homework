package com.wshish.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wshish.po.Student;
import com.wshish.po.Subject;
import com.wshish.service.StudentService;
import com.wshish.service.StudentServiceImpl;

public class StudentParticularAction extends ActionSupport{
	private int studentID;
	private StudentService studentService = new StudentServiceImpl();
	public int getSubjectID() {
		return studentID;
	}
	public void setSubjectID(int studentID) {
		this.studentID = studentID;
	}
	public String execute() throws Exception {
		Student student = studentService.showStudentParticular(studentID);
		ServletActionContext.getRequest().setAttribute("student", student);
		return SUCCESS;
	}
}
