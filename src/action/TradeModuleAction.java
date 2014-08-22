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
import dao.TradeModuleDao;
import vo.TradeModule;



@Controller
@RequestMapping("/trade_module")
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
		params.put("moduleID", moduleID);params.put("moduleName", moduleName);params.put("moduleLinkUrl", moduleLinkUrl);params.put("moduleIcon", moduleIcon);params.put("parentNo", parentNo);params.put("sort", sort);params.put("isVisible", isVisible);params.put("isLeaf", isLeaf);params.put("isMenu", isMenu);params.put("isDeleted", isDeleted);params.put("moduleController", moduleController);	
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", tradeModuleDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(tradeModuleDao.findCount(params), pageSize, request, model);		
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
		TradeModule vo=tradeModuleDao.findByPK(id);
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
		vo.setModuleID(moduleID);vo.setModuleName(moduleName);vo.setModuleLinkUrl(moduleLinkUrl);vo.setModuleIcon(moduleIcon);vo.setParentNo(parentNo);vo.setSort(sort);vo.setIsVisible(isVisible);vo.setIsLeaf(isLeaf);vo.setIsMenu(isMenu);vo.setIsDeleted(isDeleted);vo.setModuleController(moduleController);		
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
		vo.setModuleID(moduleID);vo.setModuleName(moduleName);vo.setModuleLinkUrl(moduleLinkUrl);vo.setModuleIcon(moduleIcon);vo.setParentNo(parentNo);vo.setSort(sort);vo.setIsVisible(isVisible);vo.setIsLeaf(isLeaf);vo.setIsMenu(isMenu);vo.setIsDeleted(isDeleted);vo.setModuleController(moduleController);		
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
