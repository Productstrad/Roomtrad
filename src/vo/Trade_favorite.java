package vo;
import java.sql.Timestamp;


public class Trade_favorite {
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private String favoriteTitle;
	public String getFavoriteTitle() {
		return favoriteTitle;
	}
	public void setFavoriteTitle(String favoriteTitle) {
		this.favoriteTitle = favoriteTitle;
	}
	private String favoriteContent;
	public String getFavoriteContent() {
		return favoriteContent;
	}
	public void setFavoriteContent(String favoriteContent) {
		this.favoriteContent = favoriteContent;
	}
	private Timestamp favoriteAddTime;
	public Timestamp getFavoriteAddTime() {
		return favoriteAddTime;
	}
	public void setFavoriteAddTime(Timestamp favoriteAddTime) {
		this.favoriteAddTime = favoriteAddTime;
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
	private Integer status;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}