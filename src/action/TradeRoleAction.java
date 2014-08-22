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
import dao.TradeRoleDao;
import vo.TradeRole;

import java.util.Date;


@Controller
@RequestMapping("/trade_role")
public class TradeRoleAction {
	
	private Logger log = LoggerFactory.getLogger(TradeRoleAction.class);
	
	@Autowired
	TradeRoleDao tradeRoleDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer roleID=ParamUtil.getIntegerParameter(request,"roleID"));String roleNo=ParamUtil.getStringParameter(request,"roleNo"));String roleName=ParamUtil.getStringParameter(request,"roleName"));String description=ParamUtil.getStringParameter(request,"description"));Integer sort=ParamUtil.getIntegerParameter(request,"sort"));Integer isVisible=ParamUtil.getIntegerParameter(request,"isVisible"));Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID"));Date createDate=ParamUtil.getDateParameter(request,"createDate"));Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID"));Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate"));String recordStatus=ParamUtil.getStringParameter(request,"recordStatus"));Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted"));
		Map params = new HashMap();
		params.put("roleID", roleID);params.put("roleNo", roleNo);params.put("roleName", roleName);params.put("description", description);params.put("sort", sort);params.put("isVisible", isVisible);params.put("createUserID", createUserID);params.put("createDate", createDate);params.put("modifyUserID", modifyUserID);params.put("modifyDate", modifyDate);params.put("recordStatus", recordStatus);params.put("isDeleted", isDeleted);	
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", tradeRoleDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(tradeRoleDao.findCount(params), pageSize, request, model);		
		return "trade_role/list";
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
		return "trade_role/update";
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
		Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");String roleNo=ParamUtil.getStringParameter(request,"roleNo");String roleName=ParamUtil.getStringParameter(request,"roleName");String description=ParamUtil.getStringParameter(request,"description");Integer sort=ParamUtil.getIntegerParameter(request,"sort");Integer isVisible=ParamUtil.getIntegerParameter(request,"isVisible");Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");Date createDate=ParamUtil.getDateParameter(request,"createDate");Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted");	
		TradeRole vo=new TradeRole();
		vo.setRoleID(roleID);vo.setRoleNo(roleNo);vo.setRoleName(roleName);vo.setDescription(description);vo.setSort(sort);vo.setIsVisible(isVisible);vo.setCreateUserID(createUserID);vo.setCreateDate(createDate);vo.setModifyUserID(modifyUserID);vo.setModifyDate(modifyDate);vo.setRecordStatus(recordStatus);vo.setIsDeleted(isDeleted);		
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
		return "trade_role/add";
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
		Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");String roleNo=ParamUtil.getStringParameter(request,"roleNo");String roleName=ParamUtil.getStringParameter(request,"roleName");String description=ParamUtil.getStringParameter(request,"description");Integer sort=ParamUtil.getIntegerParameter(request,"sort");Integer isVisible=ParamUtil.getIntegerParameter(request,"isVisible");Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");Date createDate=ParamUtil.getDateParameter(request,"createDate");Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted");	
		TradeRole vo=new TradeRole();
		vo.setRoleID(roleID);vo.setRoleNo(roleNo);vo.setRoleName(roleName);vo.setDescription(description);vo.setSort(sort);vo.setIsVisible(isVisible);vo.setCreateUserID(createUserID);vo.setCreateDate(createDate);vo.setModifyUserID(modifyUserID);vo.setModifyDate(modifyDate);vo.setRecordStatus(recordStatus);vo.setIsDeleted(isDeleted);		
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
