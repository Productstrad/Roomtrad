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
import dao.Trade_rolepermissionDao;
import vo.Trade_rolepermission;

import java.sql.Timestamp;


@Controller
@RequestMapping("/trade_rolepermission")
public class Trade_rolepermissionAction {
	
	private Logger log = LoggerFactory.getLogger(Trade_rolepermissionAction.class);
	
	@Autowired
	Trade_rolepermissionDao trade_rolepermissionDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", ParamUtil.getLongParameter(request,"id"));
		params.put("roleID", ParamUtil.getIntegerParameter(request,"roleID"));
		params.put("modulePermissionID", ParamUtil.getLongParameter(request,"modulePermissionID"));
		params.put("createDate", ParamUtil.getTimestampParameter(request,"createDate"));
		params.put("status", ParamUtil.getIntegerParameter(request,"status"));
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", trade_rolepermissionDao.find(params,pageNo,pageSize));		
		return "trade_rolepermission/list";
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
		Trade_rolepermission vo=trade_rolepermissionDao.findByPK(id);
		model.addAttribute("vo", vo);
		return "trade_rolepermission/update";
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
		Long id=ParamUtil.getLongParameter(request,"id");		
		Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");		
		Long modulePermissionID=ParamUtil.getLongParameter(request,"modulePermissionID");		
		Timestamp createDate=ParamUtil.getTimestampParameter(request,"createDate");		
		Integer status=ParamUtil.getIntegerParameter(request,"status");	
		Trade_rolepermission vo=new Trade_rolepermission();
		vo.setId(id);
		vo.setRoleID(roleID);
		vo.setModulePermissionID(modulePermissionID);
		vo.setCreateDate(createDate);
		vo.setStatus(status);		
		int effect=trade_rolepermissionDao.update(vo);
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
		return "trade_rolepermission/add";
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
		Long id=ParamUtil.getLongParameter(request,"id");	
		Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");	
		Long modulePermissionID=ParamUtil.getLongParameter(request,"modulePermissionID");	
		Timestamp createDate=ParamUtil.getTimestampParameter(request,"createDate");	
		Integer status=ParamUtil.getIntegerParameter(request,"status");	
		Trade_rolepermission vo=new Trade_rolepermission();
		vo.setId(id);
		vo.setRoleID(roleID);
		vo.setModulePermissionID(modulePermissionID);
		vo.setCreateDate(createDate);
		vo.setStatus(status);		
		int effect=trade_rolepermissionDao.insert(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
	 
	@RequestMapping(value = "/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");		
		int effect=trade_rolepermissionDao.delete(id);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
}
