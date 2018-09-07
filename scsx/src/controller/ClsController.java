package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bean.Cls;
import dq.base.dto.ResultDto;
import my.dao.MyDao;

/**
 *这是一个控制器类，其作用是向客户端发送数据（json）
 * @author xchris
 *
 */
@RestController//引入该注解后，该类就可以想客户端发送json数据
public class ClsController {
	
	@RequestMapping("/clsList")
	public Object getAllCls(){
		
		//查询所有数据
		return MyDao.queryMapList("select * from cls");
	}
	
	@RequestMapping("/clsAddDo")
	public Object AddCls(Cls cls){
		  MyDao.update("insert into cls(cls_name,cls_remark) values(?,?)",cls.getCls_name(),cls.getCls_remark());
		  
		  return ResultDto.successResult("新增分类成功！");
	
	}
	
	@RequestMapping("/clsUpdDo")
	public Object updCls(Cls cls){
		  MyDao.update("update cls set cls_name = ?,cls_remark = ? where cls_id = ?" ,
				  cls.getCls_name(),cls.getCls_remark(),cls.getCls_id());
		  
		  
		  return ResultDto.successResult("修改分类成功！");
	
	}
	
	@RequestMapping("/clsDelDo")
	public Object delCls(Integer cls_id){
		  MyDao.update("delete from cls where cls_id = ?" ,cls_id);
		  
		  
		  return ResultDto.successResult("删除分类成功！");
	
	}
	
	@RequestMapping("/clsDelMultiDo")
	public Object delClsMulti(@RequestParam(value="cls_ids[]",required=false) Integer[] cls_ids) {
		
		
		if(cls_ids==null || cls_ids.length==0) {
			return ResultDto.failResult("您没选择任何数据！");
		}
		
		int i;
		for(i=0;i<cls_ids.length;i++) {
			MyDao.update(
					"delete from cls where cls_id = ?", 
					cls_ids[i]);
		}
		
		
		
		return ResultDto.successResult("删除商品分类成功！");
		
	}
	

}
