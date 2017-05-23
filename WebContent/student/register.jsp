<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生注册</title>
</head>
<body>
 <table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="middle"><span class="left_txt">
			<div id="addStudentForm" align="center"><!--录入学生信息-->
				<form action="register.action" method="post">
				<table border="0" cellspacing="10" cellpadding="0">
				  <tr>
					<td colspan="2"><FONT color="red"><s:actionerror/></FONT></td>
				  </tr>
				  <tr>
					<td>学号:</td>
					<td><input type="text" name="studentID" size="20" ></td>
				  </tr>
				  <tr>
					<td>姓名:</td>
					<td><input type="text" name="studentName" size="20" ></td>
				  </tr>
				   <tr>
					<td>班级:</td>
					<td><input type="text" name="sclass" size="20" ></td>
				  </tr>
				   <tr>
					<td>密码:</td>
					<td><input type="text" name="password" size="20" ></td>
				  </tr>
				  <tr>
				  	<td colspan="2"><div >
				  	  <input type="submit" value="注册">				  	  
				  	  <input type="reset" value="重置">
			  	  </div>
				</td>
				  </tr>
			</table>
			</form>	
			</div>
		</td>
        </tr>
</table>
</body>
</html>