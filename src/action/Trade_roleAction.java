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
import dao.Trade_roleDao;
import vo.Trade_role;

import java.sql.Timestamp;


@Controller
@RequestMapping("/trade_role")
public class Trade_roleAction {
	
	private Logger log = LoggerFactory.getLogger(Trade_roleAction.class);
	
	@Autowired
	Trade_roleDao trade_roleDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", ParamUtil.getIntegerParameter(request,"id"));
		params.put("roleno", ParamUtil.getStringParameter(request,"roleno"));
		params.put("roleName", ParamUtil.getStringParameter(request,"roleName"));
		params.put("description", ParamUtil.getStringParameter(request,"description"));
		params.put("sort", ParamUtil.getIntegerParameter(request,"sort"));
		params.put("createDate", ParamUtil.getTimestampParameter(request,"createDate"));
		params.put("status", ParamUtil.getIntegerParameter(request,"status"));
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", trade_roleDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(trade_roleDao.findCount(params), pageSize, request, model);		
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
		Trade_role vo=trade_roleDao.findByPK(id);
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
		Integer id=ParamUtil.getIntegerParameter(request,"id");		
		String roleno=ParamUtil.getStringParameter(request,"roleno");		
		String roleName=ParamUtil.getStringParameter(request,"roleName");		
		String description=ParamUtil.getStringParameter(request,"description");		
		Integer sort=ParamUtil.getIntegerParameter(request,"sort");		
		Timestamp createDate=ParamUtil.getTimestampParameter(request,"createDate");		
		Integer status=ParamUtil.getIntegerParameter(request,"status");	
		Trade_role vo=new Trade_role();
		vo.setId(id);
		vo.setRoleno(roleno);
		vo.setRoleName(roleName);
		vo.setDescription(description);
		vo.setSort(sort);
		vo.setCreateDate(createDate);
		vo.setStatus(status);		
		int effect=trade_roleDao.update(vo);
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
		Integer id=ParamUtil.getIntegerParameter(request,"id");	
		String roleno=ParamUtil.getStringParameter(request,"roleno");	
		String roleName=ParamUtil.getStringParameter(request,"roleName");	
		String description=ParamUtil.getStringParameter(request,"description");	
		Integer sort=ParamUtil.getIntegerParameter(request,"sort");	
		Timestamp createDate=ParamUtil.getTimestampParameter(request,"createDate");	
		Integer status=ParamUtil.getIntegerParameter(request,"status");	
		Trade_role vo=new Trade_role();
		vo.setId(id);
		vo.setRoleno(roleno);
		vo.setRoleName(roleName);
		vo.setDescription(description);
		vo.setSort(sort);
		vo.setCreateDate(createDate);
		vo.setStatus(status);		
		int effect=trade_roleDao.insert(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
	 
	@RequestMapping(value = "/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");		
		int effect=trade_roleDao.delete(id);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
}