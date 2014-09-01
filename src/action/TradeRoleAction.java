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
import dao.TradeRoleDao;
import vo.TradeRole;

import java.util.Date;


@Controller
@RequestMapping("/traderole")
public class TradeRoleAction {
	
	private Logger log = LoggerFactory.getLogger(TradeRoleAction.class);
	
	@Autowired
	TradeRoleDao tradeRoleDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");
		String roleNo=ParamUtil.getStringParameter(request,"roleNo");
		String roleName=ParamUtil.getStringParameter(request,"roleName");
		String description=ParamUtil.getStringParameter(request,"description");
		Integer sort=ParamUtil.getIntegerParameter(request,"sort");
		Integer isVisible=ParamUtil.getIntegerParameter(request,"isVisible");
		Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");
		Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");
		String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");
		Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted");
		
		Map params = new HashMap();
		params.put("roleID", roleID);
		params.put("roleNo", roleNo);
		params.put("roleName", roleName);
		params.put("description", description);
		params.put("sort", sort);
		params.put("isVisible", isVisible);
		params.put("createUserID", createUserID);
		params.put("createDate", createDate);
		params.put("modifyUserID", modifyUserID);
		params.put("modifyDate", modifyDate);
		params.put("recordStatus", recordStatus);
		params.put("isDeleted", isDeleted);
			
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", tradeRoleDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(tradeRoleDao.findCount(params), pageSize, request, model);		
		return "traderole/list";
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
		TradeRole vo=tradeRoleDao.findByPK(id);
		model.addAttribute("vo", vo);
		return "traderole/update";
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
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "roleID_set"))){
			paramsMap.put("roleID_set", ParamUtil.getIntegerParameter(request, "roleID_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "roleNo_set"))){
			paramsMap.put("roleNo_set", ParamUtil.getStringParameter(request, "roleNo_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "roleName_set"))){
			paramsMap.put("roleName_set", ParamUtil.getStringParameter(request, "roleName_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "description_set"))){
			paramsMap.put("description_set", ParamUtil.getStringParameter(request, "description_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "sort_set"))){
			paramsMap.put("sort_set", ParamUtil.getIntegerParameter(request, "sort_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "isVisible_set"))){
			paramsMap.put("isVisible_set", ParamUtil.getIntegerParameter(request, "isVisible_set"));
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
		
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "roleID"))){
			paramsMap.put("roleID", ParamUtil.getIntegerParameter(request, "roleID"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "roleNo"))){
			paramsMap.put("roleNo", ParamUtil.getStringParameter(request, "roleNo"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "roleName"))){
			paramsMap.put("roleName", ParamUtil.getStringParameter(request, "roleName"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "description"))){
			paramsMap.put("description", ParamUtil.getStringParameter(request, "description"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "sort"))){
			paramsMap.put("sort", ParamUtil.getIntegerParameter(request, "sort"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "isVisible"))){
			paramsMap.put("isVisible", ParamUtil.getIntegerParameter(request, "isVisible"));
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
		int effect=tradeRoleDao.update(paramsMap);
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
		Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");
		String roleNo=ParamUtil.getStringParameter(request,"roleNo");
		String roleName=ParamUtil.getStringParameter(request,"roleName");
		String description=ParamUtil.getStringParameter(request,"description");
		Integer sort=ParamUtil.getIntegerParameter(request,"sort");
		Integer isVisible=ParamUtil.getIntegerParameter(request,"isVisible");
		Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");
		Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");
		String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");
		Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted");
			
		TradeRole vo=new TradeRole();
		vo.setRoleID(roleID);
		vo.setRoleNo(roleNo);
		vo.setRoleName(roleName);
		vo.setDescription(description);
		vo.setSort(sort);
		vo.setIsVisible(isVisible);
		vo.setCreateUserID(createUserID);
		vo.setCreateDate(createDate);
		vo.setModifyUserID(modifyUserID);
		vo.setModifyDate(modifyDate);
		vo.setRecordStatus(recordStatus);
		vo.setIsDeleted(isDeleted);
				
		int effect=tradeRoleDao.update(vo);
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
		return "traderole/add";
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
		Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");
		String roleNo=ParamUtil.getStringParameter(request,"roleNo");
		String roleName=ParamUtil.getStringParameter(request,"roleName");
		String description=ParamUtil.getStringParameter(request,"description");
		Integer sort=ParamUtil.getIntegerParameter(request,"sort");
		Integer isVisible=ParamUtil.getIntegerParameter(request,"isVisible");
		Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");
		Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");
		String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");
		Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted");
			
		TradeRole vo=new TradeRole();
		vo.setRoleID(roleID);
		vo.setRoleNo(roleNo);
		vo.setRoleName(roleName);
		vo.setDescription(description);
		vo.setSort(sort);
		vo.setIsVisible(isVisible);
		vo.setCreateUserID(createUserID);
		vo.setCreateDate(createDate);
		vo.setModifyUserID(modifyUserID);
		vo.setModifyDate(modifyDate);
		vo.setRecordStatus(recordStatus);
		vo.setIsDeleted(isDeleted);
				
		int effect=tradeRoleDao.insert(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
	 
	@RequestMapping(value = "/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");		
		int effect=tradeRoleDao.delete(id);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
}
