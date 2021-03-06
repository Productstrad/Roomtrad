package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.RowSet;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import vo.TradeModulepermission;
import common.DBFactory;
import common.SqlBuilder;
import common.VOKit;

@Component
public class TradeModulepermissionDao {

	private Logger logger = Logger.getLogger(TradeModulepermissionDao.class);
	private String proxool_M="proxool.defaultDB";
	private String proxool_S="proxool.defaultDB_s0";	
	
	public int insert(TradeModulepermission vo){
		int result = 0;		
		if( null == vo ){
			return -1;
		}		
		try {
			SqlBuilder sql=new SqlBuilder("insert into trade_modulepermission");			
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
	public List<TradeModulepermission> find(Map<String, Object> paramsMap,int pageNo,int pageSize){
		List<TradeModulepermission> list = null;
		try{
			SqlBuilder sql=new SqlBuilder("SELECT * FROM trade_modulepermission",paramsMap);					
			sql.appendWhereParam("modulePermissionID", "modulePermissionID=?");
			sql.appendWhereParam("moduleID", "moduleID=?");
			sql.appendWhereParam("permissionID", "permissionID=?");
			sql.appendWhereParam("createUserID", "createUserID=?");
			sql.appendWhereParam("createDate", "createDate=?");
			sql.appendWhereParam("modifyUserID", "modifyUserID=?");
			sql.appendWhereParam("modifyDate", "modifyDate=?");
			sql.appendWhereParam("recordStatus", "recordStatus=?");
			sql.appendWhereParam("isDeleted", "isDeleted=?");
									
			sql.appendLimit(pageNo, pageSize);
			RowSet rs = DBFactory.getDBObject(proxool_S).query(sql);			
			list=VOKit.rs2BeanList(rs, TradeModulepermission.class);
		}catch (Exception e) {
			logger.error("", e);
		} 
		return list;
	}
	/**
	 * 查找总数
	 * @param paramsMap
	 * @return	 
	 */
	public Integer findCount(Map<String, Object> paramsMap){
		int count=0;
		try{
			SqlBuilder sql=new SqlBuilder("SELECT count(id) FROM trade_modulepermission",paramsMap);					
			sql.appendWhereParam("modulePermissionID", "modulePermissionID=?");
			sql.appendWhereParam("moduleID", "moduleID=?");
			sql.appendWhereParam("permissionID", "permissionID=?");
			sql.appendWhereParam("createUserID", "createUserID=?");
			sql.appendWhereParam("createDate", "createDate=?");
			sql.appendWhereParam("modifyUserID", "modifyUserID=?");
			sql.appendWhereParam("modifyDate", "modifyDate=?");
			sql.appendWhereParam("recordStatus", "recordStatus=?");
			sql.appendWhereParam("isDeleted", "isDeleted=?");
			
			count = DBFactory.getDBObject(proxool_S).getCount(sql);
		}catch (Exception e) {
			logger.error("", e);
		} 
		return count;
	}
	/**
	 * 根据id查找对象
	 * @param id 对象id
	 * @return	
	 */
	public TradeModulepermission findByPK(Object id) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", id);
		return find(params, 1, 1).get(0);
	}
	/**
	 * 查询单条记录
	 * @param params
	 * @return
	 * @author mengdz	 
	 */
	public TradeModulepermission findSingle(Map<String, Object> params) {
		List<TradeModulepermission> list=find(params, 1, 1);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	/**
	 * update vo
	 * 更新vo，属性值为空的字段不更新,要求vo属性不能为元数据类型，以免存在属性默认值更新问题
	 * @param vo
	 * @return	 
	 */
	public int update(TradeModulepermission vo) {
		int result = 0;		
		if( vo.getId()==null){
			return -1;
		}		
		try {
			SqlBuilder sql=new SqlBuilder("update trade_modulepermission");				
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
			SqlBuilder sql=new SqlBuilder("update trade_modulepermission",paramsMap);						
			sql.appendSetParam("modulePermissionID_set", "modulePermissionID=?");
			sql.appendSetParam("moduleID_set", "moduleID=?");
			sql.appendSetParam("permissionID_set", "permissionID=?");
			sql.appendSetParam("createUserID_set", "createUserID=?");
			sql.appendSetParam("createDate_set", "createDate=?");
			sql.appendSetParam("modifyUserID_set", "modifyUserID=?");
			sql.appendSetParam("modifyDate_set", "modifyDate=?");
			sql.appendSetParam("recordStatus_set", "recordStatus=?");
			sql.appendSetParam("isDeleted_set", "isDeleted=?");
						
			
			sql.appendWhereParam("modulePermissionID", "modulePermissionID=?");
			sql.appendWhereParam("moduleID", "moduleID=?");
			sql.appendWhereParam("permissionID", "permissionID=?");
			sql.appendWhereParam("createUserID", "createUserID=?");
			sql.appendWhereParam("createDate", "createDate=?");
			sql.appendWhereParam("modifyUserID", "modifyUserID=?");
			sql.appendWhereParam("modifyDate", "modifyDate=?");
			sql.appendWhereParam("recordStatus", "recordStatus=?");
			sql.appendWhereParam("isDeleted", "isDeleted=?");
							
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
			SqlBuilder sql=new SqlBuilder("update trade_modulepermission set state=-1 WHERE id=?");
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
