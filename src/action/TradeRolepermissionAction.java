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
import dao.TradeRolepermissionDao;
import vo.TradeRolepermission;

import java.util.Date;


@Controller
@RequestMapping("/traderolepermission")
public class TradeRolepermissionAction {
	
	private Logger log = LoggerFactory.getLogger(TradeRolepermissionAction.class);
	
	@Autowired
	TradeRolepermissionDao tradeRolepermissionDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Long rolePermissionID=ParamUtil.getLongParameter(request,"rolePermissionID");
		Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");
		Long modulePermissionID=ParamUtil.getLongParameter(request,"modulePermissionID");
		Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");
		Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");
		String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");
		
		Map params = new HashMap();
		params.put("rolePermissionID", rolePermissionID);
		params.put("roleID", roleID);
		params.put("modulePermissionID", modulePermissionID);
		params.put("createUserID", createUserID);
		params.put("createDate", createDate);
		params.put("modifyUserID", modifyUserID);
		params.put("modifyDate", modifyDate);
		params.put("recordStatus", recordStatus);
			
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", tradeRolepermissionDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(tradeRolepermissionDao.findCount(params), pageSize, request, model);		
		return "traderolepermission/list";
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
		TradeRolepermission vo=tradeRolepermissionDao.findByPK(id);
		model.addAttribute("vo", vo);
		return "traderolepermission/update";
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
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "rolePermissionID_set"))){
			paramsMap.put("rolePermissionID_set", ParamUtil.getLongParameter(request, "rolePermissionID_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "roleID_set"))){
			paramsMap.put("roleID_set", ParamUtil.getIntegerParameter(request, "roleID_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "modulePermissionID_set"))){
			paramsMap.put("modulePermissionID_set", ParamUtil.getLongParameter(request, "modulePermissionID_set"));
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
		
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "rolePermissionID"))){
			paramsMap.put("rolePermissionID", ParamUtil.getLongParameter(request, "rolePermissionID"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "roleID"))){
			paramsMap.put("roleID", ParamUtil.getIntegerParameter(request, "roleID"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "modulePermissionID"))){
			paramsMap.put("modulePermissionID", ParamUtil.getLongParameter(request, "modulePermissionID"));
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
		int effect=tradeRolepermissionDao.update(paramsMap);
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
		Long rolePermissionID=ParamUtil.getLongParameter(request,"rolePermissionID");
		Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");
		Long modulePermissionID=ParamUtil.getLongParameter(request,"modulePermissionID");
		Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");
		Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");
		String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");
			
		TradeRolepermission vo=new TradeRolepermission();
		vo.setRolePermissionID(rolePermissionID);
		vo.setRoleID(roleID);
		vo.setModulePermissionID(modulePermissionID);
		vo.setCreateUserID(createUserID);
		vo.setCreateDate(createDate);
		vo.setModifyUserID(modifyUserID);
		vo.setModifyDate(modifyDate);
		vo.setRecordStatus(recordStatus);
				
		int effect=tradeRolepermissionDao.update(vo);
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
		return "traderolepermission/add";
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
		Long rolePermissionID=ParamUtil.getLongParameter(request,"rolePermissionID");
		Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");
		Long modulePermissionID=ParamUtil.getLongParameter(request,"modulePermissionID");
		Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");
		Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");
		String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");
			
		TradeRolepermission vo=new TradeRolepermission();
		vo.setRolePermissionID(rolePermissionID);
		vo.setRoleID(roleID);
		vo.setModulePermissionID(modulePermissionID);
		vo.setCreateUserID(createUserID);
		vo.setCreateDate(createDate);
		vo.setModifyUserID(modifyUserID);
		vo.setModifyDate(modifyDate);
		vo.setRecordStatus(recordStatus);
				
		int effect=tradeRolepermissionDao.insert(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
	 
	@RequestMapping(value = "/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");		
		int effect=tradeRolepermissionDao.delete(id);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
}
