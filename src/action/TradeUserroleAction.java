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
import util.StringUtil;
import dao.TradeUserroleDao;
import vo.TradeUserrole;

import java.util.Date;


@Controller
@RequestMapping("/tradeuserrole")
public class TradeUserroleAction {
	
	private Logger log = LoggerFactory.getLogger(TradeUserroleAction.class);
	
	@Autowired
	TradeUserroleDao tradeUserroleDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer userRoleID=ParamUtil.getIntegerParameter(request,"userRoleID");
		Integer userID=ParamUtil.getIntegerParameter(request,"userID");
		Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");
		Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");
		Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");
		String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");
		
		Map params = new HashMap();
		params.put("userRoleID", userRoleID);
		params.put("userID", userID);
		params.put("roleID", roleID);
		params.put("createUserID", createUserID);
		params.put("createDate", createDate);
		params.put("modifyUserID", modifyUserID);
		params.put("modifyDate", modifyDate);
		params.put("recordStatus", recordStatus);
			
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", tradeUserroleDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(tradeUserroleDao.findCount(params), pageSize, request, model);		
		return "tradeuserrole/list";
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
		return "tradeuserrole/update";
	 }
	 
	 /**
	 * 提交更新，根据参数更新对象
	 * @param request
	 * @param response
	 * @param id
	 * @param model
	 * @author mengdz
	 */
	@RequestMapping(value = "/updatepost.do")	
	public void updatepost(HttpServletRequest request,HttpServletResponse response
			,Model model) {		
		Map<String, Object> paramsMap=new HashMap<String, Object>();
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "userRoleID_set"))){
			paramsMap.put("userRoleID_set", ParamUtil.getIntegerParameter(request, "userRoleID_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "userID_set"))){
			paramsMap.put("userID_set", ParamUtil.getIntegerParameter(request, "userID_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "roleID_set"))){
			paramsMap.put("roleID_set", ParamUtil.getIntegerParameter(request, "roleID_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "createUserID_set"))){
			paramsMap.put("createUserID_set", ParamUtil.getIntegerParameter(request, "createUserID_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "createDate_set"))){
			paramsMap.put("createDate_set", ParamUtil.getDateParameter(request, "createDate_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "modifyUserID_set"))){
			paramsMap.put("modifyUserID_set", ParamUtil.getIntegerParameter(request, "modifyUserID_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "modifyDate_set"))){
			paramsMap.put("modifyDate_set", ParamUtil.getDateParameter(request, "modifyDate_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "recordStatus_set"))){
			paramsMap.put("recordStatus_set", ParamUtil.getStringParameter(request, "recordStatus_set"));
		}
		
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "userRoleID"))){
			paramsMap.put("userRoleID", ParamUtil.getIntegerParameter(request, "userRoleID"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "userID"))){
			paramsMap.put("userID", ParamUtil.getIntegerParameter(request, "userID"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "roleID"))){
			paramsMap.put("roleID", ParamUtil.getIntegerParameter(request, "roleID"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "createUserID"))){
			paramsMap.put("createUserID", ParamUtil.getIntegerParameter(request, "createUserID"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "createDate"))){
			paramsMap.put("createDate", ParamUtil.getDateParameter(request, "createDate"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "modifyUserID"))){
			paramsMap.put("modifyUserID", ParamUtil.getIntegerParameter(request, "modifyUserID"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "modifyDate"))){
			paramsMap.put("modifyDate", ParamUtil.getDateParameter(request, "modifyDate"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "recordStatus"))){
			paramsMap.put("recordStatus", ParamUtil.getStringParameter(request, "recordStatus"));
		}
		int effect=tradeUserroleDao.update(paramsMap);
		MessageKit.displayJsonResult(response, effect, null, null, null);		
	}
	 
	 /**
	 * update 提交
	 * @param request
	 * @param response
	 * @param model	 
	 */
	@RequestMapping(value = "/updatevopost.do")
	public void updatevopost(HttpServletRequest request,HttpServletResponse response			
			,Model model) {		
		Integer userRoleID=ParamUtil.getIntegerParameter(request,"userRoleID");
		Integer userID=ParamUtil.getIntegerParameter(request,"userID");
		Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");
		Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");
		Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");
		String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");
			
		TradeUserrole vo=new TradeUserrole();
		vo.setUserRoleID(userRoleID);
		vo.setUserID(userID);
		vo.setRoleID(roleID);
		vo.setCreateUserID(createUserID);
		vo.setCreateDate(createDate);
		vo.setModifyUserID(modifyUserID);
		vo.setModifyDate(modifyDate);
		vo.setRecordStatus(recordStatus);
				
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
		return "tradeuserrole/add";
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
		Integer userRoleID=ParamUtil.getIntegerParameter(request,"userRoleID");
		Integer userID=ParamUtil.getIntegerParameter(request,"userID");
		Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");
		Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");
		Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");
		String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");
			
		TradeUserrole vo=new TradeUserrole();
		vo.setUserRoleID(userRoleID);
		vo.setUserID(userID);
		vo.setRoleID(roleID);
		vo.setCreateUserID(createUserID);
		vo.setCreateDate(createDate);
		vo.setModifyUserID(modifyUserID);
		vo.setModifyDate(modifyDate);
		vo.setRecordStatus(recordStatus);
				
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
