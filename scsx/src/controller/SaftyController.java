package controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bean.students;
import bean.users;
import dq.base.dto.ResultDto;
import my.dao.MyDao;

@RestController
public class SaftyController {

	@RequestMapping("/loginDo")
public Object loginDo(users users,HttpSession session) {
		
		
		Object rec = MyDao.queryOne("select * from users where u_id = ? and u_pwd = ?",users.getU_id(),users.getU_pwd() );
		boolean flag = MyDao.queryBoolean("select identity from users where u_id = ?",users.getU_id());
		if(rec!=null) {//验证通过
			//将用户信息存入Session
			session.setAttribute("LoginUserID", users.getU_id());
			if(flag == true) {
			return ResultDto.successResult("admin");}
			else {
				return ResultDto.successResult("登录成功！");}
		}else {
			return ResultDto.failResult("登录失败！");
		}
		
	}
	
	//退出系统
	@RequestMapping("/logoutDo")
	public Object logoutDo(HttpSession session) {
		
		
		session.removeAttribute("LoginUserID");
		return ResultDto.successResult("您已成功退出系统！");
	}
		
		@RequestMapping("/pwdmodDo")
		//修改密码
		public Object pwdmodDo(users users,HttpSession session){
					
			  MyDao.update("update users set u_pwd = ? where u_id = ?" ,
					 users.getU_pwd(),session.getAttribute("LoginUserID"));
			  
			  
			  return ResultDto.successResult("修改分类成功！");	
		
	}
}
		













