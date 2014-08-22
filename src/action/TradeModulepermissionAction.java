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
import dao.TradeModulepermissionDao;
import vo.TradeModulepermission;

import java.util.Date;


@Controller
@RequestMapping("/trade_modulepermission")
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
		params.put("modulePermissionID", modulePermissionID);params.put("moduleID", moduleID);params.put("permissionID", permissionID);params.put("createUserID", createUserID);params.put("createDate", createDate);params.put("modifyUserID", modifyUserID);params.put("modifyDate", modifyDate);params.put("recordStatus", recordStatus);params.put("isDeleted", isDeleted);	
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", tradeModulepermissionDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(tradeModulepermissionDao.findCount(params), pageSize, request, model);		
		return "trade_modulepermission/list";
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
		return "trade_modulepermission/update";
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
		vo.setModulePermissionID(modulePermissionID);vo.setModuleID(moduleID);vo.setPermissionID(permissionID);vo.setCreateUserID(createUserID);vo.setCreateDate(createDate);vo.setModifyUserID(modifyUserID);vo.setModifyDate(modifyDate);vo.setRecordStatus(recordStatus);vo.setIsDeleted(isDeleted);		
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
		return "trade_modulepermission/add";
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
		vo.setModulePermissionID(modulePermissionID);vo.setModuleID(moduleID);vo.setPermissionID(permissionID);vo.setCreateUserID(createUserID);vo.setCreateDate(createDate);vo.setModifyUserID(modifyUserID);vo.setModifyDate(modifyDate);vo.setRecordStatus(recordStatus);vo.setIsDeleted(isDeleted);		
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
