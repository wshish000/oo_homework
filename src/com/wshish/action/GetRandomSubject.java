package com.wshish.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wshish.po.Subject;
import com.wshish.service.SubjectService;
import com.wshish.service.SubjectServiceImpl;

/*
 * 获得随机试题
 */
public class GetRandomSubject extends ActionSupport{
	private SubjectService subjectService = new SubjectServiceImpl();
	public String execute() throws Exception {
		List<Subject> subjects = subjectService.randomFindSubject(20);//获得试题记录
		HttpServletRequest request = ServletActionContext.getRequest();//获得当前请求的对象
		request.setAttribute("subjects", subjects);
		return SUCCESS;
	}
}