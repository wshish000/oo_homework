package com.wshish.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wshish.po.Student;
import com.wshish.service.StudentService;
import com.wshish.service.StudentServiceImpl;
import com.wshish.util.Page;
import com.wshish.util.PageResult;

public class QueryStudentAction extends ActionSupport{
	private int currentPage;		//当前页
	private StudentService studentService = new StudentServiceImpl();

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String execute() throws Exception {
		Page page = new Page();
		page.setEveryPage(10);//每页显示10条记录
		page.setCurrentPage(currentPage);//设置当前页
		PageResult pageResult = studentService.queryStudentByPage(page);
		List<Student> students = pageResult.getList();//获得学生列表
		page = pageResult.getPage();//获得分页信息
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("students", students);
		request.setAttribute("page", page);
		return SUCCESS;
	}
}