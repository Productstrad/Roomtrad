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
import dao.Trade_moduleDao;
import vo.Trade_module;

import java.lang.Boolean;
import java.sql.Timestamp;


@Controller
@RequestMapping("/trade_module")
public class Trade_moduleAction {
	
	private Logger log = LoggerFactory.getLogger(Trade_moduleAction.class);
	
	@Autowired
	Trade_moduleDao trade_moduleDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", ParamUtil.getIntegerParameter(request,"id"));
		params.put("moduleName", ParamUtil.getStringParameter(request,"moduleName"));
		params.put("moduleLinkUrl", ParamUtil.getStringParameter(request,"moduleLinkUrl"));
		params.put("moduleIcon", ParamUtil.getStringParameter(request,"moduleIcon"));
		params.put("sort", ParamUtil.getIntegerParameter(request,"sort"));
		params.put("moduleController", ParamUtil.getStringParameter(request,"moduleController"));
		params.put("isLeaf", ParamUtil.getBooleanParameter(request,"isLeaf"));
		params.put("isMenu", ParamUtil.getBooleanParameter(request,"isMenu"));
		params.put("parentID", ParamUtil.getIntegerParameter(request,"parentID"));
		params.put("createDate", ParamUtil.getTimestampParameter(request,"createDate"));
		params.put("status", ParamUtil.getIntegerParameter(request,"status"));
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", trade_moduleDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(trade_moduleDao.findCount(params), pageSize, request, model);		
		return "trade_module/list";
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
		Trade_module vo=trade_moduleDao.findByPK(id);
		model.addAttribute("vo", vo);
		return "trade_module/update";
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
		String moduleName=ParamUtil.getStringParameter(request,"moduleName");		
		String moduleLinkUrl=ParamUtil.getStringParameter(request,"moduleLinkUrl");		
		String moduleIcon=ParamUtil.getStringParameter(request,"moduleIcon");		
		Integer sort=ParamUtil.getIntegerParameter(request,"sort");		
		String moduleController=ParamUtil.getStringParameter(request,"moduleController");		
		Boolean isLeaf=ParamUtil.getBooleanParameter(request,"isLeaf");		
		Boolean isMenu=ParamUtil.getBooleanParameter(request,"isMenu");		
		Integer parentID=ParamUtil.getIntegerParameter(request,"parentID");		
		Timestamp createDate=ParamUtil.getTimestampParameter(request,"createDate");		
		Integer status=ParamUtil.getIntegerParameter(request,"status");	
		Trade_module vo=new Trade_module();
		vo.setId(id);
		vo.setModuleName(moduleName);
		vo.setModuleLinkUrl(moduleLinkUrl);
		vo.setModuleIcon(moduleIcon);
		vo.setSort(sort);
		vo.setModuleController(moduleController);
		vo.setIsLeaf(isLeaf);
		vo.setIsMenu(isMenu);
		vo.setParentID(parentID);
		vo.setCreateDate(createDate);
		vo.setStatus(status);		
		int effect=trade_moduleDao.update(vo);
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
		return "trade_module/add";
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
		String moduleName=ParamUtil.getStringParameter(request,"moduleName");	
		String moduleLinkUrl=ParamUtil.getStringParameter(request,"moduleLinkUrl");	
		String moduleIcon=ParamUtil.getStringParameter(request,"moduleIcon");	
		Integer sort=ParamUtil.getIntegerParameter(request,"sort");	
		String moduleController=ParamUtil.getStringParameter(request,"moduleController");	
		Boolean isLeaf=ParamUtil.getBooleanParameter(request,"isLeaf");	
		Boolean isMenu=ParamUtil.getBooleanParameter(request,"isMenu");	
		Integer parentID=ParamUtil.getIntegerParameter(request,"parentID");	
		Timestamp createDate=ParamUtil.getTimestampParameter(request,"createDate");	
		Integer status=ParamUtil.getIntegerParameter(request,"status");	
		Trade_module vo=new Trade_module();
		vo.setId(id);
		vo.setModuleName(moduleName);
		vo.setModuleLinkUrl(moduleLinkUrl);
		vo.setModuleIcon(moduleIcon);
		vo.setSort(sort);
		vo.setModuleController(moduleController);
		vo.setIsLeaf(isLeaf);
		vo.setIsMenu(isMenu);
		vo.setParentID(parentID);
		vo.setCreateDate(createDate);
		vo.setStatus(status);		
		int effect=trade_moduleDao.insert(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
	 
	@RequestMapping(value = "/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");		
		int effect=trade_moduleDao.delete(id);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
}
