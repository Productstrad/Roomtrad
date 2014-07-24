package action;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import util.ParamUtil;
import util.MessageKit;
import util.Page;
import dao.Trade_favoriteDao;
import vo.Trade_favorite;

import java.sql.Timestamp;


@Controller
@RequestMapping("/trade_favorite")
public class Trade_favoriteAction {
	
	private Logger log = LoggerFactory.getLogger(Trade_favoriteAction.class);
	
	@Autowired
	Trade_favoriteDao trade_favoriteDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", ParamUtil.getIntegerParameter(request,"id"));
		params.put("favoriteTitle", ParamUtil.getStringParameter(request,"favoriteTitle"));
		params.put("favoriteContent", ParamUtil.getStringParameter(request,"favoriteContent"));
		params.put("favoriteAddTime", ParamUtil.getTimestampParameter(request,"favoriteAddTime"));
		params.put("userID", ParamUtil.getIntegerParameter(request,"userID"));
		params.put("url", ParamUtil.getStringParameter(request,"url"));
		params.put("icon", ParamUtil.getStringParameter(request,"icon"));
		params.put("status", ParamUtil.getIntegerParameter(request,"status"));
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", trade_favoriteDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(trade_favoriteDao.findCount(params), pageSize, request, model);		
		return "trade_favorite/list";
	 }	
	
	/**
	 * update vo详细信息显示页
	 * @param request
	 * @param response
	 * @param model
	 * @return	 
	 */
	@RequestMapping(value = "/update.do")
	public String update(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");
		Trade_favorite vo=trade_favoriteDao.findByPK(id);
		model.addAttribute("vo", vo);
		return "trade_favorite/update";
	 }
	 
	 /**
	 * update 提交
	 * @param request
	 * @param response
	 * @param model	 
	 */
	@RequestMapping(value = "/updatepost.do")
	public void updatepost(HttpServletRequest request,HttpServletResponse response			
			,Model model) {		
		Integer id=ParamUtil.getIntegerParameter(request,"id");		
		String favoriteTitle=ParamUtil.getStringParameter(request,"favoriteTitle");		
		String favoriteContent=ParamUtil.getStringParameter(request,"favoriteContent");		
		Timestamp favoriteAddTime=ParamUtil.getTimestampParameter(request,"favoriteAddTime");		
		Integer userID=ParamUtil.getIntegerParameter(request,"userID");		
		String url=ParamUtil.getStringParameter(request,"url");		
		String icon=ParamUtil.getStringParameter(request,"icon");		
		Integer status=ParamUtil.getIntegerParameter(request,"status");	
		Trade_favorite vo=new Trade_favorite();
		vo.setId(id);
		vo.setFavoriteTitle(favoriteTitle);
		vo.setFavoriteContent(favoriteContent);
		vo.setFavoriteAddTime(favoriteAddTime);
		vo.setUserID(userID);
		vo.setUrl(url);
		vo.setIcon(icon);
		vo.setStatus(status);		
		int effect=trade_favoriteDao.update(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }	
	
	/**
	 * add vo详细信息显示页
	 * @param request
	 * @param response
	 * @param model
	 * @return	
	 */
	@RequestMapping(value = "/add.do")
	public String add(HttpServletRequest request,HttpServletResponse response			
			,Model model) {			
		return "trade_favorite/add";
	 }
	 
	 /**
	 * add 提交
	 * @param request
	 * @param response
	 * @param model	 
	 */
	@RequestMapping(value = "/addpost.do")
	public void addpost(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request,"id");	
		String favoriteTitle=ParamUtil.getStringParameter(request,"favoriteTitle");	
		String favoriteContent=ParamUtil.getStringParameter(request,"favoriteContent");	
		Timestamp favoriteAddTime=ParamUtil.getTimestampParameter(request,"favoriteAddTime");	
		Integer userID=ParamUtil.getIntegerParameter(request,"userID");	
		String url=ParamUtil.getStringParameter(request,"url");	
		String icon=ParamUtil.getStringParameter(request,"icon");	
		Integer status=ParamUtil.getIntegerParameter(request,"status");	
		Trade_favorite vo=new Trade_favorite();
		vo.setId(id);
		vo.setFavoriteTitle(favoriteTitle);
		vo.setFavoriteContent(favoriteContent);
		vo.setFavoriteAddTime(favoriteAddTime);
		vo.setUserID(userID);
		vo.setUrl(url);
		vo.setIcon(icon);
		vo.setStatus(status);		
		int effect=trade_favoriteDao.insert(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
	 
	@RequestMapping(value = "/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");		
		int effect=trade_favoriteDao.delete(id);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
}
