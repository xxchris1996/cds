package controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bean.students;
import dq.base.dto.ResultDto;
import my.dao.MyDao;

@RestController


public class admin_stuController {
	
	@RequestMapping(value="/studentList")
	
	public Object getAllinfo(students students){
		
		//查询所有数据
		return MyDao.queryMapList("select * from students");
	}
	
	@RequestMapping("/studentUpdDo")
	//提交所有修改
	public Object updstu(students students){
				
		  MyDao.update("update students set stu_telephone = ?,stu_state = ? ,stu_address = ? where stu_xuehao = ?" ,
				 students.getStu_telephone(),students.getStu_state(),students.getStu_address(),students.getStu_xuehao());
		  
		  
		  return ResultDto.successResult("修改分类成功！");
	
	}
	
	
	}
	


