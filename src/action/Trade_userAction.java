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
import dao.Trade_userDao;
import vo.Trade_user;

import java.lang.Boolean;
import java.sql.Timestamp;


@Controller
@RequestMapping("/trade_user")
public class Trade_userAction {
	
	private Logger log = LoggerFactory.getLogger(Trade_userAction.class);
	
	@Autowired
	Trade_userDao trade_userDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", ParamUtil.getIntegerParameter(request,"id"));
		params.put("userName", ParamUtil.getStringParameter(request,"userName"));
		params.put("passWord", ParamUtil.getStringParameter(request,"passWord"));
		params.put("trueName", ParamUtil.getStringParameter(request,"trueName"));
		params.put("telePhone", ParamUtil.getStringParameter(request,"telePhone"));
		params.put("mobileTel", ParamUtil.getStringParameter(request,"mobileTel"));
		params.put("email", ParamUtil.getStringParameter(request,"email"));
		params.put("levelType", ParamUtil.getIntegerParameter(request,"levelType"));
		params.put("sex", ParamUtil.getBooleanParameter(request,"sex"));
		params.put("idcard", ParamUtil.getStringParameter(request,"idcard"));
		params.put("playType", ParamUtil.getIntegerParameter(request,"playType"));
		params.put("createdDate", ParamUtil.getTimestampParameter(request,"createdDate"));
		params.put("departid", ParamUtil.getIntegerParameter(request,"departid"));
		params.put("status", ParamUtil.getIntegerParameter(request,"status"));
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", trade_userDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(trade_userDao.findCount(params), pageSize, request, model);		
		return "trade_user/list";
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
		Trade_user vo=trade_userDao.findByPK(id);
		model.addAttribute("vo", vo);
		return "trade_user/update";
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
		String userName=ParamUtil.getStringParameter(request,"userName");		
		String passWord=ParamUtil.getStringParameter(request,"passWord");		
		String trueName=ParamUtil.getStringParameter(request,"trueName");		
		String telePhone=ParamUtil.getStringParameter(request,"telePhone");		
		String mobileTel=ParamUtil.getStringParameter(request,"mobileTel");		
		String email=ParamUtil.getStringParameter(request,"email");		
		Integer levelType=ParamUtil.getIntegerParameter(request,"levelType");		
		Boolean sex=ParamUtil.getBooleanParameter(request,"sex");		
		String idcard=ParamUtil.getStringParameter(request,"idcard");		
		Integer playType=ParamUtil.getIntegerParameter(request,"playType");		
		Timestamp createdDate=ParamUtil.getTimestampParameter(request,"createdDate");		
		Integer departid=ParamUtil.getIntegerParameter(request,"departid");		
		Integer status=ParamUtil.getIntegerParameter(request,"status");	
		Trade_user vo=new Trade_user();
		vo.setId(id);
		vo.setUserName(userName);
		vo.setPassWord(passWord);
		vo.setTrueName(trueName);
		vo.setTelePhone(telePhone);
		vo.setMobileTel(mobileTel);
		vo.setEmail(email);
		vo.setLevelType(levelType);
		vo.setSex(sex);
		vo.setIdcard(idcard);
		vo.setPlayType(playType);
		vo.setCreatedDate(createdDate);
		vo.setDepartid(departid);
		vo.setStatus(status);		
		int effect=trade_userDao.update(vo);
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
		return "trade_user/add";
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
		String userName=ParamUtil.getStringParameter(request,"userName");	
		String passWord=ParamUtil.getStringParameter(request,"passWord");	
		String trueName=ParamUtil.getStringParameter(request,"trueName");	
		String telePhone=ParamUtil.getStringParameter(request,"telePhone");	
		String mobileTel=ParamUtil.getStringParameter(request,"mobileTel");	
		String email=ParamUtil.getStringParameter(request,"email");	
		Integer levelType=ParamUtil.getIntegerParameter(request,"levelType");	
		Boolean sex=ParamUtil.getBooleanParameter(request,"sex");	
		String idcard=ParamUtil.getStringParameter(request,"idcard");	
		Integer playType=ParamUtil.getIntegerParameter(request,"playType");	
		Timestamp createdDate=ParamUtil.getTimestampParameter(request,"createdDate");	
		Integer departid=ParamUtil.getIntegerParameter(request,"departid");	
		Integer status=ParamUtil.getIntegerParameter(request,"status");	
		Trade_user vo=new Trade_user();
		vo.setId(id);
		vo.setUserName(userName);
		vo.setPassWord(passWord);
		vo.setTrueName(trueName);
		vo.setTelePhone(telePhone);
		vo.setMobileTel(mobileTel);
		vo.setEmail(email);
		vo.setLevelType(levelType);
		vo.setSex(sex);
		vo.setIdcard(idcard);
		vo.setPlayType(playType);
		vo.setCreatedDate(createdDate);
		vo.setDepartid(departid);
		vo.setStatus(status);		
		int effect=trade_userDao.insert(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
	 
	@RequestMapping(value = "/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");		
		int effect=trade_userDao.delete(id);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
}
