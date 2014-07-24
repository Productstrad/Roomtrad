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
import dao.Trade_permissionDao;
import vo.Trade_permission;

import java.lang.Boolean;
import java.sql.Timestamp;


@Controller
@RequestMapping("/trade_permission")
public class Trade_permissionAction {
	
	private Logger log = LoggerFactory.getLogger(Trade_permissionAction.class);
	
	@Autowired
	Trade_permissionDao trade_permissionDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", ParamUtil.getIntegerParameter(request,"id"));
		params.put("permissionAction", ParamUtil.getStringParameter(request,"permissionAction"));
		params.put("permissionName", ParamUtil.getStringParameter(request,"permissionName"));
		params.put("sort", ParamUtil.getIntegerParameter(request,"sort"));
		params.put("script", ParamUtil.getStringParameter(request,"script"));
		params.put("icon", ParamUtil.getStringParameter(request,"icon"));
		params.put("permissionController", ParamUtil.getStringParameter(request,"permissionController"));
		params.put("description", ParamUtil.getStringParameter(request,"description"));
		params.put("isButton", ParamUtil.getBooleanParameter(request,"isButton"));
		params.put("parentID", ParamUtil.getIntegerParameter(request,"parentID"));
		params.put("createDate", ParamUtil.getStringParameter(request,"createDate"));
		params.put("trad_Permissioncol", ParamUtil.getTimestampParameter(request,"trad_Permissioncol"));
		params.put("status", ParamUtil.getIntegerParameter(request,"status"));
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", trade_permissionDao.find(params,pageNo,pageSize));		
		return "trade_permission/list";
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
		Trade_permission vo=trade_permissionDao.findByPK(id);
		model.addAttribute("vo", vo);
		return "trade_permission/update";
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
		Integer id=ParamUtil.getIntegerParameter(request,"id");		
		String permissionAction=ParamUtil.getStringParameter(request,"permissionAction");		
		String permissionName=ParamUtil.getStringParameter(request,"permissionName");		
		Integer sort=ParamUtil.getIntegerParameter(request,"sort");		
		String script=ParamUtil.getStringParameter(request,"script");		
		String icon=ParamUtil.getStringParameter(request,"icon");		
		String permissionController=ParamUtil.getStringParameter(request,"permissionController");		
		String description=ParamUtil.getStringParameter(request,"description");		
		Boolean isButton=ParamUtil.getBooleanParameter(request,"isButton");		
		Integer parentID=ParamUtil.getIntegerParameter(request,"parentID");		
		String createDate=ParamUtil.getStringParameter(request,"createDate");		
		Timestamp trad_Permissioncol=ParamUtil.getTimestampParameter(request,"trad_Permissioncol");		
		Integer status=ParamUtil.getIntegerParameter(request,"status");	
		Trade_permission vo=new Trade_permission();
		vo.setId(id);
		vo.setPermissionAction(permissionAction);
		vo.setPermissionName(permissionName);
		vo.setSort(sort);
		vo.setScript(script);
		vo.setIcon(icon);
		vo.setPermissionController(permissionController);
		vo.setDescription(description);
		vo.setIsButton(isButton);
		vo.setParentID(parentID);
		vo.setCreateDate(createDate);
		vo.setTrad_Permissioncol(trad_Permissioncol);
		vo.setStatus(status);		
		int effect=trade_permissionDao.update(vo);
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
		return "trade_permission/add";
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
		Integer id=ParamUtil.getIntegerParameter(request,"id");	
		String permissionAction=ParamUtil.getStringParameter(request,"permissionAction");	
		String permissionName=ParamUtil.getStringParameter(request,"permissionName");	
		Integer sort=ParamUtil.getIntegerParameter(request,"sort");	
		String script=ParamUtil.getStringParameter(request,"script");	
		String icon=ParamUtil.getStringParameter(request,"icon");	
		String permissionController=ParamUtil.getStringParameter(request,"permissionController");	
		String description=ParamUtil.getStringParameter(request,"description");	
		Boolean isButton=ParamUtil.getBooleanParameter(request,"isButton");	
		Integer parentID=ParamUtil.getIntegerParameter(request,"parentID");	
		String createDate=ParamUtil.getStringParameter(request,"createDate");	
		Timestamp trad_Permissioncol=ParamUtil.getTimestampParameter(request,"trad_Permissioncol");	
		Integer status=ParamUtil.getIntegerParameter(request,"status");	
		Trade_permission vo=new Trade_permission();
		vo.setId(id);
		vo.setPermissionAction(permissionAction);
		vo.setPermissionName(permissionName);
		vo.setSort(sort);
		vo.setScript(script);
		vo.setIcon(icon);
		vo.setPermissionController(permissionController);
		vo.setDescription(description);
		vo.setIsButton(isButton);
		vo.setParentID(parentID);
		vo.setCreateDate(createDate);
		vo.setTrad_Permissioncol(trad_Permissioncol);
		vo.setStatus(status);		
		int effect=trade_permissionDao.insert(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
	 
	@RequestMapping(value = "/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");		
		int effect=trade_permissionDao.delete(id);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
}
