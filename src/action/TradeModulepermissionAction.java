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
import dao.TradeModulepermissionDao;
import vo.TradeModulepermission;

import java.util.Date;


@Controller
@RequestMapping("/trademodulepermission")
public class TradeModulepermissionAction {
	
	private Logger log = LoggerFactory.getLogger(TradeModulepermissionAction.class);
	
	@Autowired
	TradeModulepermissionDao tradeModulepermissionDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Long modulePermissionID=ParamUtil.getLongParameter(request,"modulePermissionID");
		Integer moduleID=ParamUtil.getIntegerParameter(request,"moduleID");
		Integer permissionID=ParamUtil.getIntegerParameter(request,"permissionID");
		Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");
		Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");
		String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");
		Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted");
		
		Map params = new HashMap();
		params.put("modulePermissionID", modulePermissionID);
		params.put("moduleID", moduleID);
		params.put("permissionID", permissionID);
		params.put("createUserID", createUserID);
		params.put("createDate", createDate);
		params.put("modifyUserID", modifyUserID);
		params.put("modifyDate", modifyDate);
		params.put("recordStatus", recordStatus);
		params.put("isDeleted", isDeleted);
			
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", tradeModulepermissionDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(tradeModulepermissionDao.findCount(params), pageSize, request, model);		
		return "trademodulepermission/list";
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
		TradeModulepermission vo=tradeModulepermissionDao.findByPK(id);
		model.addAttribute("vo", vo);
		return "trademodulepermission/update";
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
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "modulePermissionID_set"))){
			paramsMap.put("modulePermissionID_set", ParamUtil.getLongParameter(request, "modulePermissionID_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "moduleID_set"))){
			paramsMap.put("moduleID_set", ParamUtil.getIntegerParameter(request, "moduleID_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "permissionID_set"))){
			paramsMap.put("permissionID_set", ParamUtil.getIntegerParameter(request, "permissionID_set"));
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
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "isDeleted_set"))){
			paramsMap.put("isDeleted_set", ParamUtil.getIntegerParameter(request, "isDeleted_set"));
		}
		
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "modulePermissionID"))){
			paramsMap.put("modulePermissionID", ParamUtil.getLongParameter(request, "modulePermissionID"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "moduleID"))){
			paramsMap.put("moduleID", ParamUtil.getIntegerParameter(request, "moduleID"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "permissionID"))){
			paramsMap.put("permissionID", ParamUtil.getIntegerParameter(request, "permissionID"));
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
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "isDeleted"))){
			paramsMap.put("isDeleted", ParamUtil.getIntegerParameter(request, "isDeleted"));
		}
		int effect=tradeModulepermissionDao.update(paramsMap);
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
		Long modulePermissionID=ParamUtil.getLongParameter(request,"modulePermissionID");
		Integer moduleID=ParamUtil.getIntegerParameter(request,"moduleID");
		Integer permissionID=ParamUtil.getIntegerParameter(request,"permissionID");
		Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");
		Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");
		String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");
		Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted");
			
		TradeModulepermission vo=new TradeModulepermission();
		vo.setModulePermissionID(modulePermissionID);
		vo.setModuleID(moduleID);
		vo.setPermissionID(permissionID);
		vo.setCreateUserID(createUserID);
		vo.setCreateDate(createDate);
		vo.setModifyUserID(modifyUserID);
		vo.setModifyDate(modifyDate);
		vo.setRecordStatus(recordStatus);
		vo.setIsDeleted(isDeleted);
				
		int effect=tradeModulepermissionDao.update(vo);
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
		return "trademodulepermission/add";
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
		Long modulePermissionID=ParamUtil.getLongParameter(request,"modulePermissionID");
		Integer moduleID=ParamUtil.getIntegerParameter(request,"moduleID");
		Integer permissionID=ParamUtil.getIntegerParameter(request,"permissionID");
		Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");
		Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");
		String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");
		Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted");
			
		TradeModulepermission vo=new TradeModulepermission();
		vo.setModulePermissionID(modulePermissionID);
		vo.setModuleID(moduleID);
		vo.setPermissionID(permissionID);
		vo.setCreateUserID(createUserID);
		vo.setCreateDate(createDate);
		vo.setModifyUserID(modifyUserID);
		vo.setModifyDate(modifyDate);
		vo.setRecordStatus(recordStatus);
		vo.setIsDeleted(isDeleted);
				
		int effect=tradeModulepermissionDao.insert(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
	 
	@RequestMapping(value = "/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");		
		int effect=tradeModulepermissionDao.delete(id);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
}
