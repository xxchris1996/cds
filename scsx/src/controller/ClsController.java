package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bean.Cls;
import dq.base.dto.ResultDto;
import my.dao.MyDao;

/**
 *����һ���������࣬����������ͻ��˷������ݣ�json��
 * @author xchris
 *
 */
@RestController//�����ע��󣬸���Ϳ�����ͻ��˷���json����
public class ClsController {
	
	@RequestMapping("/clsList")
	public Object getAllCls(){
		
		//��ѯ��������
		return MyDao.queryMapList("select * from cls");
	}
	
	@RequestMapping("/clsAddDo")
	public Object AddCls(Cls cls){
		  MyDao.update("insert into cls(cls_name,cls_remark) values(?,?)",cls.getCls_name(),cls.getCls_remark());
		  
		  return ResultDto.successResult("��������ɹ���");
	
	}
	
	@RequestMapping("/clsUpdDo")
	public Object updCls(Cls cls){
		  MyDao.update("update cls set cls_name = ?,cls_remark = ? where cls_id = ?" ,
				  cls.getCls_name(),cls.getCls_remark(),cls.getCls_id());
		  
		  
		  return ResultDto.successResult("�޸ķ���ɹ���");
	
	}
	
	@RequestMapping("/clsDelDo")
	public Object delCls(Integer cls_id){
		  MyDao.update("delete from cls where cls_id = ?" ,cls_id);
		  
		  
		  return ResultDto.successResult("ɾ������ɹ���");
	
	}
	
	@RequestMapping("/clsDelMultiDo")
	public Object delClsMulti(@RequestParam(value="cls_ids[]",required=false) Integer[] cls_ids) {
		
		
		if(cls_ids==null || cls_ids.length==0) {
			return ResultDto.failResult("��ûѡ���κ����ݣ�");
		}
		
		int i;
		for(i=0;i<cls_ids.length;i++) {
			MyDao.update(
					"delete from cls where cls_id = ?", 
					cls_ids[i]);
		}
		
		
		
		return ResultDto.successResult("ɾ����Ʒ����ɹ���");
		
	}
	

}
