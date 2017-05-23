package com.wshish.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wshish.po.Student;
import com.wshish.service.StudentService;
import com.wshish.service.StudentServiceImpl;

public class QueryStudentByClass extends ActionSupport{
	private String sclass;
	private StudentService studentService = new StudentServiceImpl();
	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Student> students = studentService.getStudentByClass(sclass);
		request.setAttribute("students", students);
		return this.SUCCESS;
	}
	
}