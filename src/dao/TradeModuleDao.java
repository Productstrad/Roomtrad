package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.RowSet;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import vo.TradeModule;
import common.DBFactory;
import common.SqlBuilder;
import common.VOKit;

@Component
public class TradeModuleDao {

	private Logger logger = Logger.getLogger(TradeModuleDao.class);
	private String proxool_M="proxool.defaultDB";
	private String proxool_S="proxool.defaultDB_s0";	
	
	public int insert(TradeModule vo){
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
	public List<TradeModule> find(Map<String, Object> paramsMap,int pageNo,int pageSize){
		List<TradeModule> list = null;
		try{
			SqlBuilder sql=new SqlBuilder("SELECT * FROM trade_module",paramsMap);					
			sql.appendWhereParam("moduleID", "moduleID=?");sql.appendWhereParam("moduleName", "moduleName=?");sql.appendWhereParam("moduleLinkUrl", "moduleLinkUrl=?");sql.appendWhereParam("moduleIcon", "moduleIcon=?");sql.appendWhereParam("parentNo", "parentNo=?");sql.appendWhereParam("sort", "sort=?");sql.appendWhereParam("isVisible", "isVisible=?");sql.appendWhereParam("isLeaf", "isLeaf=?");sql.appendWhereParam("isMenu", "isMenu=?");sql.appendWhereParam("isDeleted", "isDeleted=?");sql.appendWhereParam("moduleController", "moduleController=?");						
			sql.appendLimit(pageNo, pageSize);
			RowSet rs = DBFactory.getDBObject(proxool_S).query(sql);			
			list=VOKit.rs2BeanList(rs, TradeModule.class);
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
			SqlBuilder sql=new SqlBuilder("SELECT count(id) FROM trade_module",paramsMap);					
			sql.appendWhereParam("moduleID", "moduleID=?");sql.appendWhereParam("moduleName", "moduleName=?");sql.appendWhereParam("moduleLinkUrl", "moduleLinkUrl=?");sql.appendWhereParam("moduleIcon", "moduleIcon=?");sql.appendWhereParam("parentNo", "parentNo=?");sql.appendWhereParam("sort", "sort=?");sql.appendWhereParam("isVisible", "isVisible=?");sql.appendWhereParam("isLeaf", "isLeaf=?");sql.appendWhereParam("isMenu", "isMenu=?");sql.appendWhereParam("isDeleted", "isDeleted=?");sql.appendWhereParam("moduleController", "moduleController=?");
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
	public TradeModule findByPK(Object id) {
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
	public TradeModule findSingle(Map<String, Object> params) {
		List<TradeModule> list=find(params, 1, 1);
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
	public int update(TradeModule vo) {
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
			sql.appendSetParam("moduleID_set", "moduleID=?");sql.appendSetParam("moduleName_set", "moduleName=?");sql.appendSetParam("moduleLinkUrl_set", "moduleLinkUrl=?");sql.appendSetParam("moduleIcon_set", "moduleIcon=?");sql.appendSetParam("parentNo_set", "parentNo=?");sql.appendSetParam("sort_set", "sort=?");sql.appendSetParam("isVisible_set", "isVisible=?");sql.appendSetParam("isLeaf_set", "isLeaf=?");sql.appendSetParam("isMenu_set", "isMenu=?");sql.appendSetParam("isDeleted_set", "isDeleted=?");sql.appendSetParam("moduleController_set", "moduleController=?");			
			sql.appendWhereParam("moduleID", "moduleID=?");sql.appendWhereParam("moduleName", "moduleName=?");sql.appendWhereParam("moduleLinkUrl", "moduleLinkUrl=?");sql.appendWhereParam("moduleIcon", "moduleIcon=?");sql.appendWhereParam("parentNo", "parentNo=?");sql.appendWhereParam("sort", "sort=?");sql.appendWhereParam("isVisible", "isVisible=?");sql.appendWhereParam("isLeaf", "isLeaf=?");sql.appendWhereParam("isMenu", "isMenu=?");sql.appendWhereParam("isDeleted", "isDeleted=?");sql.appendWhereParam("moduleController", "moduleController=?");				
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
