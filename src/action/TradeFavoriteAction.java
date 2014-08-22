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
import dao.TradeFavoriteDao;
import vo.TradeFavorite;

import java.util.Date;


@Controller
@RequestMapping("/tradefavorite")
public class TradeFavoriteAction {
	
	private Logger log = LoggerFactory.getLogger(TradeFavoriteAction.class);
	
	@Autowired
	TradeFavoriteDao tradeFavoriteDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer favoriteID=ParamUtil.getIntegerParameter(request,"favoriteID");
		String favoriteTitle=ParamUtil.getStringParameter(request,"favoriteTitle");
		Date favoriteAddTime=ParamUtil.getDateParameter(request,"favoriteAddTime");
		String favoriteContent=ParamUtil.getStringParameter(request,"favoriteContent");
		Integer userID=ParamUtil.getIntegerParameter(request,"userID");
		String url=ParamUtil.getStringParameter(request,"url");
		String icon=ParamUtil.getStringParameter(request,"icon");
		
		Map params = new HashMap();
		params.put("favoriteID", favoriteID);
		params.put("favoriteTitle", favoriteTitle);
		params.put("favoriteAddTime", favoriteAddTime);
		params.put("favoriteContent", favoriteContent);
		params.put("userID", userID);
		params.put("url", url);
		params.put("icon", icon);
			
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", tradeFavoriteDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(tradeFavoriteDao.findCount(params), pageSize, request, model);		
		return "tradefavorite/list";
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
		TradeFavorite vo=tradeFavoriteDao.findByPK(id);
		model.addAttribute("vo", vo);
		return "tradefavorite/update";
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
		Integer favoriteID=ParamUtil.getIntegerParameter(request,"favoriteID");
		String favoriteTitle=ParamUtil.getStringParameter(request,"favoriteTitle");
		Date favoriteAddTime=ParamUtil.getDateParameter(request,"favoriteAddTime");
		String favoriteContent=ParamUtil.getStringParameter(request,"favoriteContent");
		Integer userID=ParamUtil.getIntegerParameter(request,"userID");
		String url=ParamUtil.getStringParameter(request,"url");
		String icon=ParamUtil.getStringParameter(request,"icon");
			
		TradeFavorite vo=new TradeFavorite();
		vo.setFavoriteID(favoriteID);
		vo.setFavoriteTitle(favoriteTitle);
		vo.setFavoriteAddTime(favoriteAddTime);
		vo.setFavoriteContent(favoriteContent);
		vo.setUserID(userID);
		vo.setUrl(url);
		vo.setIcon(icon);
				
		int effect=tradeFavoriteDao.update(vo);
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
		return "tradefavorite/add";
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
		Integer favoriteID=ParamUtil.getIntegerParameter(request,"favoriteID");
		String favoriteTitle=ParamUtil.getStringParameter(request,"favoriteTitle");
		Date favoriteAddTime=ParamUtil.getDateParameter(request,"favoriteAddTime");
		String favoriteContent=ParamUtil.getStringParameter(request,"favoriteContent");
		Integer userID=ParamUtil.getIntegerParameter(request,"userID");
		String url=ParamUtil.getStringParameter(request,"url");
		String icon=ParamUtil.getStringParameter(request,"icon");
			
		TradeFavorite vo=new TradeFavorite();
		vo.setFavoriteID(favoriteID);
		vo.setFavoriteTitle(favoriteTitle);
		vo.setFavoriteAddTime(favoriteAddTime);
		vo.setFavoriteContent(favoriteContent);
		vo.setUserID(userID);
		vo.setUrl(url);
		vo.setIcon(icon);
				
		int effect=tradeFavoriteDao.insert(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
	 
	@RequestMapping(value = "/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");		
		int effect=tradeFavoriteDao.delete(id);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
}
