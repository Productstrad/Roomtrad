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
import dao.Trade_modulepermissionDao;
import vo.Trade_modulepermission;

import java.sql.Timestamp;


@Controller
@RequestMapping("/trade_modulepermission")
public class Trade_modulepermissionAction {
	
	private Logger log = LoggerFactory.getLogger(Trade_modulepermissionAction.class);
	
	@Autowired
	Trade_modulepermissionDao trade_modulepermissionDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", ParamUtil.getLongParameter(request,"id"));
		params.put("moduleID", ParamUtil.getIntegerParameter(request,"moduleID"));
		params.put("permissionID", ParamUtil.getIntegerParameter(request,"permissionID"));
		params.put("createDate", ParamUtil.getTimestampParameter(request,"createDate"));
		params.put("status", ParamUtil.getIntegerParameter(request,"status"));
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", trade_modulepermissionDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(trade_modulepermissionDao.findCount(params), pageSize, request, model);		
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
		Trade_modulepermission vo=trade_modulepermissionDao.findByPK(id);
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
		Long id=ParamUtil.getLongParameter(request,"id");		
		Integer moduleID=ParamUtil.getIntegerParameter(request,"moduleID");		
		Integer permissionID=ParamUtil.getIntegerParameter(request,"permissionID");		
		Timestamp createDate=ParamUtil.getTimestampParameter(request,"createDate");		
		Integer status=ParamUtil.getIntegerParameter(request,"status");	
		Trade_modulepermission vo=new Trade_modulepermission();
		vo.setId(id);
		vo.setModuleID(moduleID);
		vo.setPermissionID(permissionID);
		vo.setCreateDate(createDate);
		vo.setStatus(status);		
		int effect=trade_modulepermissionDao.update(vo);
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
		Long id=ParamUtil.getLongParameter(request,"id");	
		Integer moduleID=ParamUtil.getIntegerParameter(request,"moduleID");	
		Integer permissionID=ParamUtil.getIntegerParameter(request,"permissionID");	
		Timestamp createDate=ParamUtil.getTimestampParameter(request,"createDate");	
		Integer status=ParamUtil.getIntegerParameter(request,"status");	
		Trade_modulepermission vo=new Trade_modulepermission();
		vo.setId(id);
		vo.setModuleID(moduleID);
		vo.setPermissionID(permissionID);
		vo.setCreateDate(createDate);
		vo.setStatus(status);		
		int effect=trade_modulepermissionDao.insert(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
	 
	@RequestMapping(value = "/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");		
		int effect=trade_modulepermissionDao.delete(id);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
}
