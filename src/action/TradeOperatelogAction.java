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
import dao.TradeOperatelogDao;
import vo.TradeOperatelog;

import java.util.Date;


@Controller
@RequestMapping("/tradeoperatelog")
public class TradeOperatelogAction {
	
	private Logger log = LoggerFactory.getLogger(TradeOperatelogAction.class);
	
	@Autowired
	TradeOperatelogDao tradeOperatelogDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Long iD=ParamUtil.getLongParameter(request,"iD");
		String processName=ParamUtil.getStringParameter(request,"processName");
		String processDesc=ParamUtil.getStringParameter(request,"processDesc");
		String methodName=ParamUtil.getStringParameter(request,"methodName");
		Integer userID=ParamUtil.getIntegerParameter(request,"userID");
		String userName=ParamUtil.getStringParameter(request,"userName");
		String iPAddress=ParamUtil.getStringParameter(request,"iPAddress");
		String description=ParamUtil.getStringParameter(request,"description");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		String methodDesc=ParamUtil.getStringParameter(request,"methodDesc");
		
		Map params = new HashMap();
		params.put("iD", iD);
		params.put("processName", processName);
		params.put("processDesc", processDesc);
		params.put("methodName", methodName);
		params.put("userID", userID);
		params.put("userName", userName);
		params.put("iPAddress", iPAddress);
		params.put("description", description);
		params.put("createDate", createDate);
		params.put("methodDesc", methodDesc);
			
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", tradeOperatelogDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(tradeOperatelogDao.findCount(params), pageSize, request, model);		
		return "tradeoperatelog/list";
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
		return "tradeoperatelog/update";
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
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "iD_set"))){
			paramsMap.put("iD_set", ParamUtil.getLongParameter(request, "iD_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "processName_set"))){
			paramsMap.put("processName_set", ParamUtil.getStringParameter(request, "processName_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "processDesc_set"))){
			paramsMap.put("processDesc_set", ParamUtil.getStringParameter(request, "processDesc_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "methodName_set"))){
			paramsMap.put("methodName_set", ParamUtil.getStringParameter(request, "methodName_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "userID_set"))){
			paramsMap.put("userID_set", ParamUtil.getIntegerParameter(request, "userID_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "userName_set"))){
			paramsMap.put("userName_set", ParamUtil.getStringParameter(request, "userName_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "iPAddress_set"))){
			paramsMap.put("iPAddress_set", ParamUtil.getStringParameter(request, "iPAddress_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "description_set"))){
			paramsMap.put("description_set", ParamUtil.getStringParameter(request, "description_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "createDate_set"))){
			paramsMap.put("createDate_set", ParamUtil.getDateParameter(request, "createDate_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "methodDesc_set"))){
			paramsMap.put("methodDesc_set", ParamUtil.getStringParameter(request, "methodDesc_set"));
		}
		
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "iD"))){
			paramsMap.put("iD", ParamUtil.getLongParameter(request, "iD"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "processName"))){
			paramsMap.put("processName", ParamUtil.getStringParameter(request, "processName"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "processDesc"))){
			paramsMap.put("processDesc", ParamUtil.getStringParameter(request, "processDesc"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "methodName"))){
			paramsMap.put("methodName", ParamUtil.getStringParameter(request, "methodName"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "userID"))){
			paramsMap.put("userID", ParamUtil.getIntegerParameter(request, "userID"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "userName"))){
			paramsMap.put("userName", ParamUtil.getStringParameter(request, "userName"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "iPAddress"))){
			paramsMap.put("iPAddress", ParamUtil.getStringParameter(request, "iPAddress"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "description"))){
			paramsMap.put("description", ParamUtil.getStringParameter(request, "description"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "createDate"))){
			paramsMap.put("createDate", ParamUtil.getDateParameter(request, "createDate"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "methodDesc"))){
			paramsMap.put("methodDesc", ParamUtil.getStringParameter(request, "methodDesc"));
		}
		int effect=tradeOperatelogDao.update(paramsMap);
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
		Long iD=ParamUtil.getLongParameter(request,"iD");
		String processName=ParamUtil.getStringParameter(request,"processName");
		String processDesc=ParamUtil.getStringParameter(request,"processDesc");
		String methodName=ParamUtil.getStringParameter(request,"methodName");
		Integer userID=ParamUtil.getIntegerParameter(request,"userID");
		String userName=ParamUtil.getStringParameter(request,"userName");
		String iPAddress=ParamUtil.getStringParameter(request,"iPAddress");
		String description=ParamUtil.getStringParameter(request,"description");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		String methodDesc=ParamUtil.getStringParameter(request,"methodDesc");
			
		TradeOperatelog vo=new TradeOperatelog();
		vo.setID(iD);
		vo.setProcessName(processName);
		vo.setProcessDesc(processDesc);
		vo.setMethodName(methodName);
		vo.setUserID(userID);
		vo.setUserName(userName);
		vo.setIPAddress(iPAddress);
		vo.setDescription(description);
		vo.setCreateDate(createDate);
		vo.setMethodDesc(methodDesc);
				
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
		return "tradeoperatelog/add";
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
		Long iD=ParamUtil.getLongParameter(request,"iD");
		String processName=ParamUtil.getStringParameter(request,"processName");
		String processDesc=ParamUtil.getStringParameter(request,"processDesc");
		String methodName=ParamUtil.getStringParameter(request,"methodName");
		Integer userID=ParamUtil.getIntegerParameter(request,"userID");
		String userName=ParamUtil.getStringParameter(request,"userName");
		String iPAddress=ParamUtil.getStringParameter(request,"iPAddress");
		String description=ParamUtil.getStringParameter(request,"description");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		String methodDesc=ParamUtil.getStringParameter(request,"methodDesc");
			
		TradeOperatelog vo=new TradeOperatelog();
		vo.setID(iD);
		vo.setProcessName(processName);
		vo.setProcessDesc(processDesc);
		vo.setMethodName(methodName);
		vo.setUserID(userID);
		vo.setUserName(userName);
		vo.setIPAddress(iPAddress);
		vo.setDescription(description);
		vo.setCreateDate(createDate);
		vo.setMethodDesc(methodDesc);
				
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
