package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.RowSet;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import vo.Trade_userrole;
import common.DBFactory;
import common.SqlBuilder;
import common.VOKit;

@Component
public class Trade_userroleDao {

	private Logger logger = Logger.getLogger(Trade_userroleDao.class);
	private String proxool_M="proxool.defaultDB";
	private String proxool_S="proxool.defaultDB_s0";	
	
	public int insert(Trade_userrole vo){
		int result = 0;		
		if( null == vo ){
			return -1;
		}		
		try {
			SqlBuilder sql=new SqlBuilder("insert into trade_userrole");			
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
	public List<Trade_userrole> find(Map<String, Object> paramsMap,int pageNo,int pageSize){
		List<Trade_userrole> list = null;
		try{
			SqlBuilder sql=new SqlBuilder("SELECT * FROM trade_userrole",paramsMap);					
			sql.appendWhereParam("id", "id=?");					
			sql.appendWhereParam("userID", "userID=?");					
			sql.appendWhereParam("roleID", "roleID=?");					
			sql.appendWhereParam("createDate", "createDate=?");					
			sql.appendWhereParam("status", "status=?");						
			sql.appendLimit(pageNo, pageSize);
			RowSet rs = DBFactory.getDBObject(proxool_S).query(sql);			
			list=VOKit.rs2BeanList(rs, Trade_userrole.class);
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
	public Trade_userrole findByPK(Object id) {
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
	public int update(Trade_userrole vo) {
		int result = 0;		
		if( vo.getId()==null){
			return -1;
		}		
		try {
			SqlBuilder sql=new SqlBuilder("update trade_userrole");				
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
			SqlBuilder sql=new SqlBuilder("update trade_userrole",paramsMap);			
			sql.appendSetParam("id_set", "id=?");			
			sql.appendSetParam("userID_set", "userID=?");			
			sql.appendSetParam("roleID_set", "roleID=?");			
			sql.appendSetParam("createDate_set", "createDate=?");			
			sql.appendSetParam("status_set", "status=?");			
			sql.appendWhereParam("id", "id=?");			
			sql.appendWhereParam("userID", "userID=?");			
			sql.appendWhereParam("roleID", "roleID=?");			
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
			SqlBuilder sql=new SqlBuilder("update trade_userrole set state=-1 WHERE id=?");
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
