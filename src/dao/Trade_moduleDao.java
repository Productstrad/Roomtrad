package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.RowSet;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import vo.Trade_module;
import common.DBFactory;
import common.SqlBuilder;
import common.VOKit;

@Component
public class Trade_moduleDao {

	private Logger logger = Logger.getLogger(Trade_moduleDao.class);
	private String proxool_M="proxool.defaultDB";
	private String proxool_S="proxool.defaultDB_s0";	
	
	public int insert(Trade_module vo){
		int result = 0;		
		if( null == vo ){
			return -1;
		}		
		try {
			SqlBuilder sql=new SqlBuilder("insert into trade_module");			
			sql.appendInsertParams(vo);							
			result = DBFactory.getDBObject(proxool_M).insert(sql);	
		} catch (Exception e) {
			logger.error("",e);
			e.printStackTrace();
			result = -1;
		}
		return result;
	}
	/**
	 * 通用查询
	 * @param params
	 * @param pageNo 页码，从1开始
	 * @param pageSize 每页大小
	 * @return	 
	 */
	public List<Trade_module> find(Map<String, Object> paramsMap,int pageNo,int pageSize){
		List<Trade_module> list = null;
		try{
			SqlBuilder sql=new SqlBuilder("SELECT * FROM trade_module",paramsMap);					
			sql.appendWhereParam("id", "id=?");					
			sql.appendWhereParam("moduleName", "moduleName=?");					
			sql.appendWhereParam("moduleLinkUrl", "moduleLinkUrl=?");					
			sql.appendWhereParam("moduleIcon", "moduleIcon=?");					
			sql.appendWhereParam("sort", "sort=?");					
			sql.appendWhereParam("moduleController", "moduleController=?");					
			sql.appendWhereParam("isLeaf", "isLeaf=?");					
			sql.appendWhereParam("isMenu", "isMenu=?");					
			sql.appendWhereParam("parentID", "parentID=?");					
			sql.appendWhereParam("createDate", "createDate=?");					
			sql.appendWhereParam("status", "status=?");						
			sql.appendLimit(pageNo, pageSize);
			RowSet rs = DBFactory.getDBObject(proxool_S).query(sql);			
			list=VOKit.rs2BeanList(rs, Trade_module.class);
		}catch (Exception e) {
			logger.error("", e);
		} 
		return list;
	}
	/**
	 * 根据id查找对象
	 * @param id 对象id
	 * @return	
	 */
	public Trade_module findByPK(Object id) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", id);
		return find(params, 1, 1).get(0);
	}
	/**
	 * update vo
	 * 更新vo，属性值为空的字段不更新,要求vo属性不能为元数据类型，以免存在属性默认值更新问题
	 * @param vo
	 * @return	 
	 */
	public int update(Trade_module vo) {
		int result = 0;		
		if( vo.getId()==null){
			return -1;
		}		
		try {
			SqlBuilder sql=new SqlBuilder("update trade_module");				
			sql.appendUpdateParams(vo);							
			result = DBFactory.getDBObject(proxool_M).update(sql);
		}catch (Exception e) {
			logger.error("",e);
			e.printStackTrace();
			result = -1;
		}		
		return result;
	}
	/**
	 * 通用update
	 * @param params
	 * @return	 
	 */
	public int update(Map<String, Object> paramsMap) {
		int result = 0;					
		try {
			SqlBuilder sql=new SqlBuilder("update trade_module",paramsMap);			
			sql.appendSetParam("id_set", "id=?");			
			sql.appendSetParam("moduleName_set", "moduleName=?");			
			sql.appendSetParam("moduleLinkUrl_set", "moduleLinkUrl=?");			
			sql.appendSetParam("moduleIcon_set", "moduleIcon=?");			
			sql.appendSetParam("sort_set", "sort=?");			
			sql.appendSetParam("moduleController_set", "moduleController=?");			
			sql.appendSetParam("isLeaf_set", "isLeaf=?");			
			sql.appendSetParam("isMenu_set", "isMenu=?");			
			sql.appendSetParam("parentID_set", "parentID=?");			
			sql.appendSetParam("createDate_set", "createDate=?");			
			sql.appendSetParam("status_set", "status=?");			
			sql.appendWhereParam("id", "id=?");			
			sql.appendWhereParam("moduleName", "moduleName=?");			
			sql.appendWhereParam("moduleLinkUrl", "moduleLinkUrl=?");			
			sql.appendWhereParam("moduleIcon", "moduleIcon=?");			
			sql.appendWhereParam("sort", "sort=?");			
			sql.appendWhereParam("moduleController", "moduleController=?");			
			sql.appendWhereParam("isLeaf", "isLeaf=?");			
			sql.appendWhereParam("isMenu", "isMenu=?");			
			sql.appendWhereParam("parentID", "parentID=?");			
			sql.appendWhereParam("createDate", "createDate=?");			
			sql.appendWhereParam("status", "status=?");				
			result = DBFactory.getDBObject(proxool_M).update(sql);				
		}catch (Exception e) {
			logger.error("更新失败",e);
			e.printStackTrace();
			result = -1;
		}		
		return result;
	}
	
	public int delete(int id) {
		int result = 0;		
		if( id <=0){
			return -1;
		}
		try {
			SqlBuilder sql=new SqlBuilder("update trade_module set state=-1 WHERE id=?");
			//按顺序添加sql参数
			sql.params.add(id);			
			result = DBFactory.getDBObject(proxool_M).update(sql);					
		}catch (Exception e) {
			logger.error("删除失败",e);
			e.printStackTrace();
			result = -1;
		}	
		return result;
	}
	
}
