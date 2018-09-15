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
		if(rec!=null) {//��֤ͨ��
			//���û���Ϣ����Session
			session.setAttribute("LoginUserID", users.getU_id());
			if(flag == true) {
			return ResultDto.successResult("admin");}
			else {
				return ResultDto.successResult("��¼�ɹ���");}
		}else {
			return ResultDto.failResult("��¼ʧ�ܣ�");
		}
		
	}
	
	//�˳�ϵͳ
	@RequestMapping("/logoutDo")
	public Object logoutDo(HttpSession session) {
		
		
		session.removeAttribute("LoginUserID");
		return ResultDto.successResult("���ѳɹ��˳�ϵͳ��");
	}
		
		@RequestMapping("/pwdmodDo")
		//�޸�����
		public Object pwdmodDo(users users,HttpSession session){
					
			  MyDao.update("update users set u_pwd = ? where u_id = ?" ,
					 users.getU_pwd(),session.getAttribute("LoginUserID"));
			  
			  
			  return ResultDto.successResult("�޸ķ���ɹ���");	
		
	}
}
		













