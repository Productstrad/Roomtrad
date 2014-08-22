package vo;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;


public class TradeFavorite {
	private Integer favoriteID;
	public Integer getFavoriteID() {
		return favoriteID;
	}
	public void setFavoriteID(Integer favoriteID) {
		this.favoriteID = favoriteID;
	}
	private String favoriteTitle;
	public String getFavoriteTitle() {
		return favoriteTitle;
	}
	public void setFavoriteTitle(String favoriteTitle) {
		this.favoriteTitle = favoriteTitle;
	}
	private Date favoriteAddTime;
	public Date getFavoriteAddTime() {
		return favoriteAddTime;
	}
	public void setFavoriteAddTime(Date favoriteAddTime) {
		this.favoriteAddTime = favoriteAddTime;
	}
	private String favoriteContent;
	public String getFavoriteContent() {
		return favoriteContent;
	}
	public void setFavoriteContent(String favoriteContent) {
		this.favoriteContent = favoriteContent;
	}
	private Integer userID;
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	private String url;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	private String icon;
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Override
	public String toString() {
		Map<String, Object> values=new HashMap<String, Object>();
		Field[] fields=this.getClass().getDeclaredFields();
		try{
			for (Field f : fields) {
			values.put(f.getName(), f.get(this));
			}
			return values.toString();
		}catch(Exception e){
			return e.toString();
		}
	}
}