package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.RowSet;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import vo.TradeOperatelog;
import common.DBFactory;
import common.SqlBuilder;
import common.VOKit;

@Component
public class TradeOperatelogDao {

	private Logger logger = Logger.getLogger(TradeOperatelogDao.class);
	private String proxool_M="proxool.defaultDB";
	private String proxool_S="proxool.defaultDB_s0";	
	
	public int insert(TradeOperatelog vo){
		int result = 0;		
		if( null == vo ){
			return -1;
		}		
		try {
			SqlBuilder sql=new SqlBuilder("insert into trade_operatelog");			
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
	public List<TradeOperatelog> find(Map<String, Object> paramsMap,int pageNo,int pageSize){
		List<TradeOperatelog> list = null;
		try{
			SqlBuilder sql=new SqlBuilder("SELECT * FROM trade_operatelog",paramsMap);					
			sql.appendWhereParam("iD", "iD=?");
			sql.appendWhereParam("processName", "processName=?");
			sql.appendWhereParam("processDesc", "processDesc=?");
			sql.appendWhereParam("methodName", "methodName=?");
			sql.appendWhereParam("userID", "userID=?");
			sql.appendWhereParam("userName", "userName=?");
			sql.appendWhereParam("iPAddress", "iPAddress=?");
			sql.appendWhereParam("description", "description=?");
			sql.appendWhereParam("createDate", "createDate=?");
			sql.appendWhereParam("methodDesc", "methodDesc=?");
									
			sql.appendLimit(pageNo, pageSize);
			RowSet rs = DBFactory.getDBObject(proxool_S).query(sql);			
			list=VOKit.rs2BeanList(rs, TradeOperatelog.class);
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
			SqlBuilder sql=new SqlBuilder("SELECT count(id) FROM trade_operatelog",paramsMap);					
			sql.appendWhereParam("iD", "iD=?");
			sql.appendWhereParam("processName", "processName=?");
			sql.appendWhereParam("processDesc", "processDesc=?");
			sql.appendWhereParam("methodName", "methodName=?");
			sql.appendWhereParam("userID", "userID=?");
			sql.appendWhereParam("userName", "userName=?");
			sql.appendWhereParam("iPAddress", "iPAddress=?");
			sql.appendWhereParam("description", "description=?");
			sql.appendWhereParam("createDate", "createDate=?");
			sql.appendWhereParam("methodDesc", "methodDesc=?");
			
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
	public TradeOperatelog findByPK(Object id) {
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
	public TradeOperatelog findSingle(Map<String, Object> params) {
		List<TradeOperatelog> list=find(params, 1, 1);
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
	public int update(TradeOperatelog vo) {
		int result = 0;		
		if( vo.getId()==null){
			return -1;
		}		
		try {
			SqlBuilder sql=new SqlBuilder("update trade_operatelog");				
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
			SqlBuilder sql=new SqlBuilder("update trade_operatelog",paramsMap);						
			sql.appendSetParam("iD_set", "iD=?");
			sql.appendSetParam("processName_set", "processName=?");
			sql.appendSetParam("processDesc_set", "processDesc=?");
			sql.appendSetParam("methodName_set", "methodName=?");
			sql.appendSetParam("userID_set", "userID=?");
			sql.appendSetParam("userName_set", "userName=?");
			sql.appendSetParam("iPAddress_set", "iPAddress=?");
			sql.appendSetParam("description_set", "description=?");
			sql.appendSetParam("createDate_set", "createDate=?");
			sql.appendSetParam("methodDesc_set", "methodDesc=?");
						
			
			sql.appendWhereParam("iD", "iD=?");
			sql.appendWhereParam("processName", "processName=?");
			sql.appendWhereParam("processDesc", "processDesc=?");
			sql.appendWhereParam("methodName", "methodName=?");
			sql.appendWhereParam("userID", "userID=?");
			sql.appendWhereParam("userName", "userName=?");
			sql.appendWhereParam("iPAddress", "iPAddress=?");
			sql.appendWhereParam("description", "description=?");
			sql.appendWhereParam("createDate", "createDate=?");
			sql.appendWhereParam("methodDesc", "methodDesc=?");
							
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
			SqlBuilder sql=new SqlBuilder("update trade_operatelog set state=-1 WHERE id=?");
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
