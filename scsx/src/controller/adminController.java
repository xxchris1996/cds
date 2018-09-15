package controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bean.Cls;
import bean.students;
import bean.users;
import dq.base.dto.ResultDto;
import my.dao.MyDao;

@RestController 
public class adminController {

@RequestMapping("/UserList")	
public Object getuserinfo(users users,HttpSession session){
		
		//��ѯ��������
		return MyDao.queryOneJson("select * from users where users.u_id = ?",session.getAttribute("LoginUserID"));
	}
//����ѧ����Ϣ
@RequestMapping("/stuAddDo")
public Object Addstu(students students){
	  MyDao.update("insert into students(stu_xuehao,stu_name,stu_xueyuan,stu_zhuanye,stu_address,stu_telephone,stu_birth,stu_state,stu_xingbie,stu_nation) values(?,?,?,?,?,?,?,?,?,?)",students.getStu_xuehao(),students.getStu_name(),students.getStu_xueyuan(),students.getStu_zhuanye(),students.getStu_address(),students.getStu_telephone(),students.getStu_birth(),students.getStu_state(),students.getStu_xingbie(),students.getStu_nation());
	  MyDao.update("insert into users(u_id,u_pwd,identity) values(?,?,?)", students.getStu_xuehao(),"000000",0);
	  return ResultDto.successResult("����ѧ����Ϣ�ɹ���");

}

//�޸�ѧ����Ϣ
@RequestMapping("/allinfo_stuUpdDo")
public Object admin_updstu(students students){
	  MyDao.update("update students set stu_xuehao = ?,stu_name = ?,stu_xueyuan = ?,stu_zhuanye = ?,stu_address = ?,stu_telephone = ?,stu_birth = ?,stu_state = ?,stu_xingbie = ?,stu_nation = ? where stu_xuehao = ?",students.getStu_xuehao(),students.getStu_name(),students.getStu_xueyuan(),students.getStu_zhuanye(),students.getStu_address(),students.getStu_telephone(),students.getStu_birth(),students.getStu_state(),students.getStu_xingbie(),students.getStu_nation(),students.getStu_xuehao());
	  return ResultDto.successResult("�޸�ѧ����Ϣ�ɹ���");

}	
@RequestMapping("/stu_pwdreset")	
//�ύ�����޸�
public Object pwdreset(students students){
			
	  MyDao.update("update users set u_pwd = ? where u_id = ?","000000",students.getStu_xuehao());
	  
	  
	  return ResultDto.successResult("�޸ķ���ɹ���");

}

@RequestMapping("/stuDelMultiDo")
public Object delStuMulti(@RequestParam(value="stu_xuehao[]",required=false) Integer[] stu_xuehao) {
	
	
	if(stu_xuehao==null || stu_xuehao.length==0) {
		return ResultDto.failResult("��ûѡ���κ����ݣ�");
	}
	
	int i;
	for(i=0;i<stu_xuehao.length;i++) {
	
		MyDao.update("delete from cxs where stu_xuehao = ?", stu_xuehao[i]);
		MyDao.update("delete from users where u_id = ?", stu_xuehao[i]);
		MyDao.update("delete from students where stu_xuehao = ?", stu_xuehao[i]);
	}
	
	
	
	return ResultDto.successResult("ɾ���ɹ���");
	
}

		
}
