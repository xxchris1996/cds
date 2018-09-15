package controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bean.Cls;
import bean.students;
import dq.base.dto.ResultDto;
import my.dao.MyDao;

/**
 *����һ���������࣬����������ͻ��˷������ݣ�json��
 * @author xchris
 *
 */
@RestController //�����ע��󣬸���Ϳ�������ͻ��˷���json��ʽ����
public class ClsController {
	
	
	@RequestMapping("/clsList")
	public Object getAllCls() {
		
		//��ѯ��������
		return MyDao.queryMapList("select * from course");
	}
	
	@RequestMapping("/cxsList")
	public Object getAllCxs(students students,HttpSession session ) {

		//��ѯ��������
		return MyDao.queryMapList("select * from cxs where stu_xuehao = ?",session.getAttribute("LoginUserID"));
	}

	@RequestMapping("/clsAddDo")
	public Object addCls(Cls course) {
		System.out.println("cus_id="+course.getCus_id());
		MyDao.update(
				"insert into course(cus_id,cus_name,cus_xingzhi,cus_score) values(?,?,?,?)", 
				course.getCus_id(),course.getCus_name(),course.getCus_xingzhi(),course.getCus_score());
		
		
		return ResultDto.successResult("������Ʒ����ɹ���");
		
	}
	
	@RequestMapping("/clsUpdDo")
	public Object updCls(Cls course) {
		
		MyDao.update(
				"update course set cus_name = ?,cus_xingzhi = ?,cus_score = ? where cus_id = ?", 
				course.getCus_name(),course.getCus_xingzhi(), course.getCus_score(),course.getCus_id());
		
		
		return ResultDto.successResult("�޸���Ʒ����ɹ���");
		
	}
	
	@RequestMapping("/clsDelDo")
	public Object delCls(Integer cus_id) {
		
		MyDao.update(
				"delete from cxs where cus_id = ?", 
				cus_id);
		
		
		return ResultDto.successResult("ɾ���γ̳ɹ���");
		
	}
	
	@RequestMapping("/cusDelDo")
	public Object delCus(Integer cus_id) {
		
		MyDao.update(
				"delete from course where cus_id = ?", 
				cus_id);
		
		
		return ResultDto.successResult("ɾ���γ̳ɹ���");
		
	}
	@RequestMapping("/clsAddMultiDo")
	public Object delClsMulti(@RequestParam(value="cls_ids[]",required=false) Integer[] cls_ids,HttpSession session) {
		
		
		if(cls_ids==null || cls_ids.length==0) {
			return ResultDto.failResult("��ûѡ���κ����ݣ�");
		}
		
		Object xuehao = session.getAttribute("LoginUserID");
		
		
		for (int i = 0; i < cls_ids.length; i++) {
			String sql = "select * from course where cus_id= ? ";
			//
			if( MyDao.queryOne("select * from cxs where stu_xuehao = ? and cus_id=?", xuehao,cls_ids[i]) != null) 
			{
				return ResultDto.failResult("�γ���ѡ��");
			}
			//
			Cls cls=MyDao.queryBean(Cls.class, sql, cls_ids[i]);
			MyDao.update(
					"insert into cxs(stu_xuehao,cus_id,cus_name,cus_xingzhi,cus_score) values(?,?,?,?,?)", 
					xuehao,cls.getCus_id(),cls.getCus_name(),cls.getCus_xingzhi(),cls.getCus_score());
		}
		
		return ResultDto.successResult("ѡ�γɹ���");
		
	}


		
		
		
		
		
	
	

}