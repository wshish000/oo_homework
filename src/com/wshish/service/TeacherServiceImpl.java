package com.wshish.service;

import com.wshish.dao.TeacherDAO;
import com.wshish.dao.TeacherDAOImpl;
import com.wshish.po.Teacher;

public class TeacherServiceImpl implements TeacherService{
	private TeacherDAO teacherDAO = new TeacherDAOImpl();
	
	public boolean allowLogin(String teacherID, String password) {
		Teacher teacher = teacherDAO.findByTeacherID(teacherID);
		if(teacher == null) {//判断是否存在该ID的教师
			return false;
		}else {
			if(password.equals(teacher.getPassword())) {//判断密码是否相同
				return true;
			}else{
				return false;
			}
		}
	}
}