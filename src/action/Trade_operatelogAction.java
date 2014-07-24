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
import dao.Trade_operatelogDao;
import vo.Trade_operatelog;

import java.sql.Timestamp;


@Controller
@RequestMapping("/trade_operatelog")
public class Trade_operatelogAction {
	
	private Logger log = LoggerFactory.getLogger(Trade_operatelogAction.class);
	
	@Autowired
	Trade_operatelogDao trade_operatelogDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", ParamUtil.getLongParameter(request,"id"));
		params.put("processName", ParamUtil.getStringParameter(request,"processName"));
		params.put("processDesc", ParamUtil.getStringParameter(request,"processDesc"));
		params.put("methodName", ParamUtil.getStringParameter(request,"methodName"));
		params.put("userID", ParamUtil.getIntegerParameter(request,"userID"));
		params.put("userName", ParamUtil.getStringParameter(request,"userName"));
		params.put("iPAddress", ParamUtil.getStringParameter(request,"iPAddress"));
		params.put("description", ParamUtil.getStringParameter(request,"description"));
		params.put("createDate", ParamUtil.getTimestampParameter(request,"createDate"));
		params.put("status", ParamUtil.getIntegerParameter(request,"status"));
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", trade_operatelogDao.find(params,pageNo,pageSize));		
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
		Trade_operatelog vo=trade_operatelogDao.findByPK(id);
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
		Long id=ParamUtil.getLongParameter(request,"id");		
		String processName=ParamUtil.getStringParameter(request,"processName");		
		String processDesc=ParamUtil.getStringParameter(request,"processDesc");		
		String methodName=ParamUtil.getStringParameter(request,"methodName");		
		Integer userID=ParamUtil.getIntegerParameter(request,"userID");		
		String userName=ParamUtil.getStringParameter(request,"userName");		
		String iPAddress=ParamUtil.getStringParameter(request,"iPAddress");		
		String description=ParamUtil.getStringParameter(request,"description");		
		Timestamp createDate=ParamUtil.getTimestampParameter(request,"createDate");		
		Integer status=ParamUtil.getIntegerParameter(request,"status");	
		Trade_operatelog vo=new Trade_operatelog();
		vo.setId(id);
		vo.setProcessName(processName);
		vo.setProcessDesc(processDesc);
		vo.setMethodName(methodName);
		vo.setUserID(userID);
		vo.setUserName(userName);
		vo.setIPAddress(iPAddress);
		vo.setDescription(description);
		vo.setCreateDate(createDate);
		vo.setStatus(status);		
		int effect=trade_operatelogDao.update(vo);
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
		Long id=ParamUtil.getLongParameter(request,"id");	
		String processName=ParamUtil.getStringParameter(request,"processName");	
		String processDesc=ParamUtil.getStringParameter(request,"processDesc");	
		String methodName=ParamUtil.getStringParameter(request,"methodName");	
		Integer userID=ParamUtil.getIntegerParameter(request,"userID");	
		String userName=ParamUtil.getStringParameter(request,"userName");	
		String iPAddress=ParamUtil.getStringParameter(request,"iPAddress");	
		String description=ParamUtil.getStringParameter(request,"description");	
		Timestamp createDate=ParamUtil.getTimestampParameter(request,"createDate");	
		Integer status=ParamUtil.getIntegerParameter(request,"status");	
		Trade_operatelog vo=new Trade_operatelog();
		vo.setId(id);
		vo.setProcessName(processName);
		vo.setProcessDesc(processDesc);
		vo.setMethodName(methodName);
		vo.setUserID(userID);
		vo.setUserName(userName);
		vo.setIPAddress(iPAddress);
		vo.setDescription(description);
		vo.setCreateDate(createDate);
		vo.setStatus(status);		
		int effect=trade_operatelogDao.insert(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
	 
	@RequestMapping(value = "/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");		
		int effect=trade_operatelogDao.delete(id);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
}
