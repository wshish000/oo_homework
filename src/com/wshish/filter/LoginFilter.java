package com.wshish.filter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginFilter extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		return arg0.invoke();
	}
	
	

}