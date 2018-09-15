package controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bean.students;
import dq.base.dto.ResultDto;
import my.dao.MyDao;

@RestController


public class StuController {
	
	@RequestMapping(value="/stuList",produces = "text/html;charset=UTF-8")
	
	public Object getAllinfo(students students,HttpSession session){
		
		//��ѯ��������
		return MyDao.queryOneJson("select * from students where stu_xuehao = ?",session.getAttribute("LoginUserID"));
	}
	
	@RequestMapping("/stuUpdDo")
	//�ύ�����޸�
	public Object updatestu(students students){
				
		  MyDao.update("update students set stu_telephone = ?,stu_state = ? ,stu_address = ?, tag = ? where stu_xuehao = ?" ,
				 students.getStu_telephone(),students.getStu_state(),students.getStu_address(),1,students.getStu_xuehao());
		  
		  
		  return ResultDto.successResult("�޸ķ���ɹ���");
	
	}
	
	
	
	
	}
	


