package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.RowSet;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import vo.TradeFavorite;
import common.DBFactory;
import common.SqlBuilder;
import common.VOKit;

@Component
public class TradeFavoriteDao {

	private Logger logger = Logger.getLogger(TradeFavoriteDao.class);
	private String proxool_M="proxool.defaultDB";
	private String proxool_S="proxool.defaultDB_s0";	
	
	public int insert(TradeFavorite vo){
		int result = 0;		
		if( null == vo ){
			return -1;
		}		
		try {
			SqlBuilder sql=new SqlBuilder("insert into trade_favorite");			
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
	public List<TradeFavorite> find(Map<String, Object> paramsMap,int pageNo,int pageSize){
		List<TradeFavorite> list = null;
		try{
			SqlBuilder sql=new SqlBuilder("SELECT * FROM trade_favorite",paramsMap);					
			sql.appendWhereParam("favoriteID", "favoriteID=?");
			sql.appendWhereParam("favoriteTitle", "favoriteTitle=?");
			sql.appendWhereParam("favoriteAddTime", "favoriteAddTime=?");
			sql.appendWhereParam("favoriteContent", "favoriteContent=?");
			sql.appendWhereParam("userID", "userID=?");
			sql.appendWhereParam("url", "url=?");
			sql.appendWhereParam("icon", "icon=?");
									
			sql.appendLimit(pageNo, pageSize);
			RowSet rs = DBFactory.getDBObject(proxool_S).query(sql);			
			list=VOKit.rs2BeanList(rs, TradeFavorite.class);
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
			SqlBuilder sql=new SqlBuilder("SELECT count(id) FROM trade_favorite",paramsMap);					
			sql.appendWhereParam("favoriteID", "favoriteID=?");
			sql.appendWhereParam("favoriteTitle", "favoriteTitle=?");
			sql.appendWhereParam("favoriteAddTime", "favoriteAddTime=?");
			sql.appendWhereParam("favoriteContent", "favoriteContent=?");
			sql.appendWhereParam("userID", "userID=?");
			sql.appendWhereParam("url", "url=?");
			sql.appendWhereParam("icon", "icon=?");
			
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
	public TradeFavorite findByPK(Object id) {
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
	public TradeFavorite findSingle(Map<String, Object> params) {
		List<TradeFavorite> list=find(params, 1, 1);
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
	public int update(TradeFavorite vo) {
		int result = 0;		
		if( vo.getId()==null){
			return -1;
		}		
		try {
			SqlBuilder sql=new SqlBuilder("update trade_favorite");				
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
			SqlBuilder sql=new SqlBuilder("update trade_favorite",paramsMap);						
			sql.appendSetParam("favoriteID_set", "favoriteID=?");
			sql.appendSetParam("favoriteTitle_set", "favoriteTitle=?");
			sql.appendSetParam("favoriteAddTime_set", "favoriteAddTime=?");
			sql.appendSetParam("favoriteContent_set", "favoriteContent=?");
			sql.appendSetParam("userID_set", "userID=?");
			sql.appendSetParam("url_set", "url=?");
			sql.appendSetParam("icon_set", "icon=?");
						
			
			sql.appendWhereParam("favoriteID", "favoriteID=?");
			sql.appendWhereParam("favoriteTitle", "favoriteTitle=?");
			sql.appendWhereParam("favoriteAddTime", "favoriteAddTime=?");
			sql.appendWhereParam("favoriteContent", "favoriteContent=?");
			sql.appendWhereParam("userID", "userID=?");
			sql.appendWhereParam("url", "url=?");
			sql.appendWhereParam("icon", "icon=?");
							
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
			SqlBuilder sql=new SqlBuilder("update trade_favorite set state=-1 WHERE id=?");
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
