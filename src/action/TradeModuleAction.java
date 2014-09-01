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
import dao.TradeModuleDao;
import vo.TradeModule;



@Controller
@RequestMapping("/trademodule")
public class TradeModuleAction {
	
	private Logger log = LoggerFactory.getLogger(TradeModuleAction.class);
	
	@Autowired
	TradeModuleDao tradeModuleDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer moduleID=ParamUtil.getIntegerParameter(request,"moduleID");
		String moduleName=ParamUtil.getStringParameter(request,"moduleName");
		String moduleLinkUrl=ParamUtil.getStringParameter(request,"moduleLinkUrl");
		String moduleIcon=ParamUtil.getStringParameter(request,"moduleIcon");
		Integer parentNo=ParamUtil.getIntegerParameter(request,"parentNo");
		Integer sort=ParamUtil.getIntegerParameter(request,"sort");
		Integer isVisible=ParamUtil.getIntegerParameter(request,"isVisible");
		Integer isLeaf=ParamUtil.getIntegerParameter(request,"isLeaf");
		Integer isMenu=ParamUtil.getIntegerParameter(request,"isMenu");
		Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted");
		String moduleController=ParamUtil.getStringParameter(request,"moduleController");
		
		Map params = new HashMap();
		params.put("moduleID", moduleID);
		params.put("moduleName", moduleName);
		params.put("moduleLinkUrl", moduleLinkUrl);
		params.put("moduleIcon", moduleIcon);
		params.put("parentNo", parentNo);
		params.put("sort", sort);
		params.put("isVisible", isVisible);
		params.put("isLeaf", isLeaf);
		params.put("isMenu", isMenu);
		params.put("isDeleted", isDeleted);
		params.put("moduleController", moduleController);
			
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", tradeModuleDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(tradeModuleDao.findCount(params), pageSize, request, model);		
		return "trademodule/list";
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
		TradeModule vo=tradeModuleDao.findByPK(id);
		model.addAttribute("vo", vo);
		return "trademodule/update";
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
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "moduleID_set"))){
			paramsMap.put("moduleID_set", ParamUtil.getIntegerParameter(request, "moduleID_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "moduleName_set"))){
			paramsMap.put("moduleName_set", ParamUtil.getStringParameter(request, "moduleName_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "moduleLinkUrl_set"))){
			paramsMap.put("moduleLinkUrl_set", ParamUtil.getStringParameter(request, "moduleLinkUrl_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "moduleIcon_set"))){
			paramsMap.put("moduleIcon_set", ParamUtil.getStringParameter(request, "moduleIcon_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "parentNo_set"))){
			paramsMap.put("parentNo_set", ParamUtil.getIntegerParameter(request, "parentNo_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "sort_set"))){
			paramsMap.put("sort_set", ParamUtil.getIntegerParameter(request, "sort_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "isVisible_set"))){
			paramsMap.put("isVisible_set", ParamUtil.getIntegerParameter(request, "isVisible_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "isLeaf_set"))){
			paramsMap.put("isLeaf_set", ParamUtil.getIntegerParameter(request, "isLeaf_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "isMenu_set"))){
			paramsMap.put("isMenu_set", ParamUtil.getIntegerParameter(request, "isMenu_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "isDeleted_set"))){
			paramsMap.put("isDeleted_set", ParamUtil.getIntegerParameter(request, "isDeleted_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "moduleController_set"))){
			paramsMap.put("moduleController_set", ParamUtil.getStringParameter(request, "moduleController_set"));
		}
		
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "moduleID"))){
			paramsMap.put("moduleID", ParamUtil.getIntegerParameter(request, "moduleID"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "moduleName"))){
			paramsMap.put("moduleName", ParamUtil.getStringParameter(request, "moduleName"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "moduleLinkUrl"))){
			paramsMap.put("moduleLinkUrl", ParamUtil.getStringParameter(request, "moduleLinkUrl"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "moduleIcon"))){
			paramsMap.put("moduleIcon", ParamUtil.getStringParameter(request, "moduleIcon"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "parentNo"))){
			paramsMap.put("parentNo", ParamUtil.getIntegerParameter(request, "parentNo"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "sort"))){
			paramsMap.put("sort", ParamUtil.getIntegerParameter(request, "sort"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "isVisible"))){
			paramsMap.put("isVisible", ParamUtil.getIntegerParameter(request, "isVisible"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "isLeaf"))){
			paramsMap.put("isLeaf", ParamUtil.getIntegerParameter(request, "isLeaf"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "isMenu"))){
			paramsMap.put("isMenu", ParamUtil.getIntegerParameter(request, "isMenu"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "isDeleted"))){
			paramsMap.put("isDeleted", ParamUtil.getIntegerParameter(request, "isDeleted"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "moduleController"))){
			paramsMap.put("moduleController", ParamUtil.getStringParameter(request, "moduleController"));
		}
		int effect=tradeModuleDao.update(paramsMap);
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
		Integer moduleID=ParamUtil.getIntegerParameter(request,"moduleID");
		String moduleName=ParamUtil.getStringParameter(request,"moduleName");
		String moduleLinkUrl=ParamUtil.getStringParameter(request,"moduleLinkUrl");
		String moduleIcon=ParamUtil.getStringParameter(request,"moduleIcon");
		Integer parentNo=ParamUtil.getIntegerParameter(request,"parentNo");
		Integer sort=ParamUtil.getIntegerParameter(request,"sort");
		Integer isVisible=ParamUtil.getIntegerParameter(request,"isVisible");
		Integer isLeaf=ParamUtil.getIntegerParameter(request,"isLeaf");
		Integer isMenu=ParamUtil.getIntegerParameter(request,"isMenu");
		Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted");
		String moduleController=ParamUtil.getStringParameter(request,"moduleController");
			
		TradeModule vo=new TradeModule();
		vo.setModuleID(moduleID);
		vo.setModuleName(moduleName);
		vo.setModuleLinkUrl(moduleLinkUrl);
		vo.setModuleIcon(moduleIcon);
		vo.setParentNo(parentNo);
		vo.setSort(sort);
		vo.setIsVisible(isVisible);
		vo.setIsLeaf(isLeaf);
		vo.setIsMenu(isMenu);
		vo.setIsDeleted(isDeleted);
		vo.setModuleController(moduleController);
				
		int effect=tradeModuleDao.update(vo);
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
		return "trademodule/add";
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
		Integer moduleID=ParamUtil.getIntegerParameter(request,"moduleID");
		String moduleName=ParamUtil.getStringParameter(request,"moduleName");
		String moduleLinkUrl=ParamUtil.getStringParameter(request,"moduleLinkUrl");
		String moduleIcon=ParamUtil.getStringParameter(request,"moduleIcon");
		Integer parentNo=ParamUtil.getIntegerParameter(request,"parentNo");
		Integer sort=ParamUtil.getIntegerParameter(request,"sort");
		Integer isVisible=ParamUtil.getIntegerParameter(request,"isVisible");
		Integer isLeaf=ParamUtil.getIntegerParameter(request,"isLeaf");
		Integer isMenu=ParamUtil.getIntegerParameter(request,"isMenu");
		Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted");
		String moduleController=ParamUtil.getStringParameter(request,"moduleController");
			
		TradeModule vo=new TradeModule();
		vo.setModuleID(moduleID);
		vo.setModuleName(moduleName);
		vo.setModuleLinkUrl(moduleLinkUrl);
		vo.setModuleIcon(moduleIcon);
		vo.setParentNo(parentNo);
		vo.setSort(sort);
		vo.setIsVisible(isVisible);
		vo.setIsLeaf(isLeaf);
		vo.setIsMenu(isMenu);
		vo.setIsDeleted(isDeleted);
		vo.setModuleController(moduleController);
				
		int effect=tradeModuleDao.insert(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
	 
	@RequestMapping(value = "/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");		
		int effect=tradeModuleDao.delete(id);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
}
