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
import dao.Trade_userroleDao;
import vo.Trade_userrole;

import java.sql.Timestamp;


@Controller
@RequestMapping("/trade_userrole")
public class Trade_userroleAction {
	
	private Logger log = LoggerFactory.getLogger(Trade_userroleAction.class);
	
	@Autowired
	Trade_userroleDao trade_userroleDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", ParamUtil.getIntegerParameter(request,"id"));
		params.put("userID", ParamUtil.getIntegerParameter(request,"userID"));
		params.put("roleID", ParamUtil.getIntegerParameter(request,"roleID"));
		params.put("createDate", ParamUtil.getTimestampParameter(request,"createDate"));
		params.put("status", ParamUtil.getIntegerParameter(request,"status"));
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", trade_userroleDao.find(params,pageNo,pageSize));		
		return "trade_userrole/list";
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
		Trade_userrole vo=trade_userroleDao.findByPK(id);
		model.addAttribute("vo", vo);
		return "trade_userrole/update";
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
		Integer userID=ParamUtil.getIntegerParameter(request,"userID");		
		Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");		
		Timestamp createDate=ParamUtil.getTimestampParameter(request,"createDate");		
		Integer status=ParamUtil.getIntegerParameter(request,"status");	
		Trade_userrole vo=new Trade_userrole();
		vo.setId(id);
		vo.setUserID(userID);
		vo.setRoleID(roleID);
		vo.setCreateDate(createDate);
		vo.setStatus(status);		
		int effect=trade_userroleDao.update(vo);
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
		return "trade_userrole/add";
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
		Integer userID=ParamUtil.getIntegerParameter(request,"userID");	
		Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");	
		Timestamp createDate=ParamUtil.getTimestampParameter(request,"createDate");	
		Integer status=ParamUtil.getIntegerParameter(request,"status");	
		Trade_userrole vo=new Trade_userrole();
		vo.setId(id);
		vo.setUserID(userID);
		vo.setRoleID(roleID);
		vo.setCreateDate(createDate);
		vo.setStatus(status);		
		int effect=trade_userroleDao.insert(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
	 
	@RequestMapping(value = "/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");		
		int effect=trade_userroleDao.delete(id);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
}
