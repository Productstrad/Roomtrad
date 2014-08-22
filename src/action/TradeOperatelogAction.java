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
import dao.TradeOperatelogDao;
import vo.TradeOperatelog;

import java.util.Date;


@Controller
@RequestMapping("/trade_operatelog")
public class TradeOperatelogAction {
	
	private Logger log = LoggerFactory.getLogger(TradeOperatelogAction.class);
	
	@Autowired
	TradeOperatelogDao tradeOperatelogDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Long iD=ParamUtil.getLongParameter(request,"iD"));String processName=ParamUtil.getStringParameter(request,"processName"));String processDesc=ParamUtil.getStringParameter(request,"processDesc"));String methodName=ParamUtil.getStringParameter(request,"methodName"));Integer userID=ParamUtil.getIntegerParameter(request,"userID"));String userName=ParamUtil.getStringParameter(request,"userName"));String iPAddress=ParamUtil.getStringParameter(request,"iPAddress"));String description=ParamUtil.getStringParameter(request,"description"));Date createDate=ParamUtil.getDateParameter(request,"createDate"));String methodDesc=ParamUtil.getStringParameter(request,"methodDesc"));
		Map params = new HashMap();
		params.put("iD", iD);params.put("processName", processName);params.put("processDesc", processDesc);params.put("methodName", methodName);params.put("userID", userID);params.put("userName", userName);params.put("iPAddress", iPAddress);params.put("description", description);params.put("createDate", createDate);params.put("methodDesc", methodDesc);	
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", tradeOperatelogDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(tradeOperatelogDao.findCount(params), pageSize, request, model);		
		return "trade_operatelog/list";
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
		TradeOperatelog vo=tradeOperatelogDao.findByPK(id);
		model.addAttribute("vo", vo);
		return "trade_operatelog/update";
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
		Long iD=ParamUtil.getLongParameter(request,"iD");String processName=ParamUtil.getStringParameter(request,"processName");String processDesc=ParamUtil.getStringParameter(request,"processDesc");String methodName=ParamUtil.getStringParameter(request,"methodName");Integer userID=ParamUtil.getIntegerParameter(request,"userID");String userName=ParamUtil.getStringParameter(request,"userName");String iPAddress=ParamUtil.getStringParameter(request,"iPAddress");String description=ParamUtil.getStringParameter(request,"description");Date createDate=ParamUtil.getDateParameter(request,"createDate");String methodDesc=ParamUtil.getStringParameter(request,"methodDesc");	
		TradeOperatelog vo=new TradeOperatelog();
		vo.setID(iD);vo.setProcessName(processName);vo.setProcessDesc(processDesc);vo.setMethodName(methodName);vo.setUserID(userID);vo.setUserName(userName);vo.setIPAddress(iPAddress);vo.setDescription(description);vo.setCreateDate(createDate);vo.setMethodDesc(methodDesc);		
		int effect=tradeOperatelogDao.update(vo);
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
		return "trade_operatelog/add";
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
		Long iD=ParamUtil.getLongParameter(request,"iD");String processName=ParamUtil.getStringParameter(request,"processName");String processDesc=ParamUtil.getStringParameter(request,"processDesc");String methodName=ParamUtil.getStringParameter(request,"methodName");Integer userID=ParamUtil.getIntegerParameter(request,"userID");String userName=ParamUtil.getStringParameter(request,"userName");String iPAddress=ParamUtil.getStringParameter(request,"iPAddress");String description=ParamUtil.getStringParameter(request,"description");Date createDate=ParamUtil.getDateParameter(request,"createDate");String methodDesc=ParamUtil.getStringParameter(request,"methodDesc");	
		TradeOperatelog vo=new TradeOperatelog();
		vo.setID(iD);vo.setProcessName(processName);vo.setProcessDesc(processDesc);vo.setMethodName(methodName);vo.setUserID(userID);vo.setUserName(userName);vo.setIPAddress(iPAddress);vo.setDescription(description);vo.setCreateDate(createDate);vo.setMethodDesc(methodDesc);		
		int effect=tradeOperatelogDao.insert(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
	 
	@RequestMapping(value = "/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");		
		int effect=tradeOperatelogDao.delete(id);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
}
