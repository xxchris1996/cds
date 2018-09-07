package controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bean.students;
import dq.base.dto.ResultDto;
import my.dao.MyDao;

@RestController
public class SaftyController {

	@RequestMapping("/loginDo")
public Object loginDo(students students,HttpSession session) {
		
		
		Object rec = MyDao.queryOne("select * from students where stu_xuehao = ? and stu_pwd = ?", students.getStu_xuehao(),students.getStu_pwd() );
		
		
		if(rec!=null) {//��֤ͨ��
			//���û���Ϣ����Session
			session.setAttribute("LoginUserID", students.getStu_xuehao());
			
			return ResultDto.successResult("��¼�ɹ���");
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
}












