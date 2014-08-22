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
import dao.TradeUserroleDao;
import vo.TradeUserrole;

import java.util.Date;


@Controller
@RequestMapping("/trade_userrole")
public class TradeUserroleAction {
	
	private Logger log = LoggerFactory.getLogger(TradeUserroleAction.class);
	
	@Autowired
	TradeUserroleDao tradeUserroleDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer userRoleID=ParamUtil.getIntegerParameter(request,"userRoleID"));Integer userID=ParamUtil.getIntegerParameter(request,"userID"));Integer roleID=ParamUtil.getIntegerParameter(request,"roleID"));Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID"));Date createDate=ParamUtil.getDateParameter(request,"createDate"));Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID"));Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate"));String recordStatus=ParamUtil.getStringParameter(request,"recordStatus"));
		Map params = new HashMap();
		params.put("userRoleID", userRoleID);params.put("userID", userID);params.put("roleID", roleID);params.put("createUserID", createUserID);params.put("createDate", createDate);params.put("modifyUserID", modifyUserID);params.put("modifyDate", modifyDate);params.put("recordStatus", recordStatus);	
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", tradeUserroleDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(tradeUserroleDao.findCount(params), pageSize, request, model);		
		return "trade_userrole/list";
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
		TradeUserrole vo=tradeUserroleDao.findByPK(id);
		model.addAttribute("vo", vo);
		return "trade_userrole/update";
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
		Integer userRoleID=ParamUtil.getIntegerParameter(request,"userRoleID");Integer userID=ParamUtil.getIntegerParameter(request,"userID");Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");Date createDate=ParamUtil.getDateParameter(request,"createDate");Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");	
		TradeUserrole vo=new TradeUserrole();
		vo.setUserRoleID(userRoleID);vo.setUserID(userID);vo.setRoleID(roleID);vo.setCreateUserID(createUserID);vo.setCreateDate(createDate);vo.setModifyUserID(modifyUserID);vo.setModifyDate(modifyDate);vo.setRecordStatus(recordStatus);		
		int effect=tradeUserroleDao.update(vo);
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
		return "trade_userrole/add";
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
		Integer userRoleID=ParamUtil.getIntegerParameter(request,"userRoleID");Integer userID=ParamUtil.getIntegerParameter(request,"userID");Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");Date createDate=ParamUtil.getDateParameter(request,"createDate");Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");	
		TradeUserrole vo=new TradeUserrole();
		vo.setUserRoleID(userRoleID);vo.setUserID(userID);vo.setRoleID(roleID);vo.setCreateUserID(createUserID);vo.setCreateDate(createDate);vo.setModifyUserID(modifyUserID);vo.setModifyDate(modifyDate);vo.setRecordStatus(recordStatus);		
		int effect=tradeUserroleDao.insert(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
	 
	@RequestMapping(value = "/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");		
		int effect=tradeUserroleDao.delete(id);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
}
