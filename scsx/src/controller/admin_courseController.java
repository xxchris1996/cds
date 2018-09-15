package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bean.Course;
import bean.cxs;
import bean.students;
import dq.base.dto.ResultDto;
import my.dao.MyDao;

@RestController
public class admin_courseController {

	@RequestMapping("/cxsgradeList")
	public Object getstugrade(students students){
		
		//��ѯ��������
		return MyDao.queryMapList("select * from cxs where stu_xuehao = ?",students.getStu_xuehao());
	}

	@RequestMapping("/cxscusList")
	public Object getcourse(Course course){
		
		//��ѯ��������
		return MyDao.queryMapList("select * from cxs where cus_id = ?",course.getCus_id());
	}
	
	@RequestMapping("/gradeUpdDo")
	//�ύ�����޸�
	public Object updatestu(String cus_id, @RequestParam("stu_xhs[]") String[] stu_xhs,  @RequestParam("grades[]") String[] grades){
				for(int i=0;i<stu_xhs.length;i++) {
		  MyDao.update("update cxs set cus_grade = ? where stu_xuehao = ? and cus_id= ? " , grades[i],stu_xhs[i],cus_id);
				}
		  MyDao.update("update course set tag = ? where cus_id= ? " ,1, cus_id);
		  return ResultDto.successResult("�ɼ�¼��ɹ���");
	
	}
}
