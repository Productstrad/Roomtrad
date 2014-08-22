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
import dao.TradeUserDao;
import vo.TradeUser;

import java.util.Date;


@Controller
@RequestMapping("/trade_user")
public class TradeUserAction {
	
	private Logger log = LoggerFactory.getLogger(TradeUserAction.class);
	
	@Autowired
	TradeUserDao tradeUserDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer userID=ParamUtil.getIntegerParameter(request,"userID"));String userName=ParamUtil.getStringParameter(request,"userName"));String userPassword=ParamUtil.getStringParameter(request,"userPassword"));Integer roleID=ParamUtil.getIntegerParameter(request,"roleID"));Integer deptID=ParamUtil.getIntegerParameter(request,"deptID"));String phone=ParamUtil.getStringParameter(request,"phone"));String fax=ParamUtil.getStringParameter(request,"fax"));String email=ParamUtil.getStringParameter(request,"email"));String qQ=ParamUtil.getStringParameter(request,"qQ"));String nickName=ParamUtil.getStringParameter(request,"nickName"));String address=ParamUtil.getStringParameter(request,"address"));String realName=ParamUtil.getStringParameter(request,"realName"));Integer sex=ParamUtil.getIntegerParameter(request,"sex"));Integer enabled=ParamUtil.getIntegerParameter(request,"enabled"));Date lastLoginTime=ParamUtil.getDateParameter(request,"lastLoginTime"));Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID"));Date createDate=ParamUtil.getDateParameter(request,"createDate"));Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID"));Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate"));String recordStatus=ParamUtil.getStringParameter(request,"recordStatus"));Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted"));
		Map params = new HashMap();
		params.put("userID", userID);params.put("userName", userName);params.put("userPassword", userPassword);params.put("roleID", roleID);params.put("deptID", deptID);params.put("phone", phone);params.put("fax", fax);params.put("email", email);params.put("qQ", qQ);params.put("nickName", nickName);params.put("address", address);params.put("realName", realName);params.put("sex", sex);params.put("enabled", enabled);params.put("lastLoginTime", lastLoginTime);params.put("createUserID", createUserID);params.put("createDate", createDate);params.put("modifyUserID", modifyUserID);params.put("modifyDate", modifyDate);params.put("recordStatus", recordStatus);params.put("isDeleted", isDeleted);	
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", tradeUserDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(tradeUserDao.findCount(params), pageSize, request, model);		
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
		TradeUser vo=tradeUserDao.findByPK(id);
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
		Integer userID=ParamUtil.getIntegerParameter(request,"userID");String userName=ParamUtil.getStringParameter(request,"userName");String userPassword=ParamUtil.getStringParameter(request,"userPassword");Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");Integer deptID=ParamUtil.getIntegerParameter(request,"deptID");String phone=ParamUtil.getStringParameter(request,"phone");String fax=ParamUtil.getStringParameter(request,"fax");String email=ParamUtil.getStringParameter(request,"email");String qQ=ParamUtil.getStringParameter(request,"qQ");String nickName=ParamUtil.getStringParameter(request,"nickName");String address=ParamUtil.getStringParameter(request,"address");String realName=ParamUtil.getStringParameter(request,"realName");Integer sex=ParamUtil.getIntegerParameter(request,"sex");Integer enabled=ParamUtil.getIntegerParameter(request,"enabled");Date lastLoginTime=ParamUtil.getDateParameter(request,"lastLoginTime");Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");Date createDate=ParamUtil.getDateParameter(request,"createDate");Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted");	
		TradeUser vo=new TradeUser();
		vo.setUserID(userID);vo.setUserName(userName);vo.setUserPassword(userPassword);vo.setRoleID(roleID);vo.setDeptID(deptID);vo.setPhone(phone);vo.setFax(fax);vo.setEmail(email);vo.setQQ(qQ);vo.setNickName(nickName);vo.setAddress(address);vo.setRealName(realName);vo.setSex(sex);vo.setEnabled(enabled);vo.setLastLoginTime(lastLoginTime);vo.setCreateUserID(createUserID);vo.setCreateDate(createDate);vo.setModifyUserID(modifyUserID);vo.setModifyDate(modifyDate);vo.setRecordStatus(recordStatus);vo.setIsDeleted(isDeleted);		
		int effect=tradeUserDao.update(vo);
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
		Integer userID=ParamUtil.getIntegerParameter(request,"userID");String userName=ParamUtil.getStringParameter(request,"userName");String userPassword=ParamUtil.getStringParameter(request,"userPassword");Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");Integer deptID=ParamUtil.getIntegerParameter(request,"deptID");String phone=ParamUtil.getStringParameter(request,"phone");String fax=ParamUtil.getStringParameter(request,"fax");String email=ParamUtil.getStringParameter(request,"email");String qQ=ParamUtil.getStringParameter(request,"qQ");String nickName=ParamUtil.getStringParameter(request,"nickName");String address=ParamUtil.getStringParameter(request,"address");String realName=ParamUtil.getStringParameter(request,"realName");Integer sex=ParamUtil.getIntegerParameter(request,"sex");Integer enabled=ParamUtil.getIntegerParameter(request,"enabled");Date lastLoginTime=ParamUtil.getDateParameter(request,"lastLoginTime");Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");Date createDate=ParamUtil.getDateParameter(request,"createDate");Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted");	
		TradeUser vo=new TradeUser();
		vo.setUserID(userID);vo.setUserName(userName);vo.setUserPassword(userPassword);vo.setRoleID(roleID);vo.setDeptID(deptID);vo.setPhone(phone);vo.setFax(fax);vo.setEmail(email);vo.setQQ(qQ);vo.setNickName(nickName);vo.setAddress(address);vo.setRealName(realName);vo.setSex(sex);vo.setEnabled(enabled);vo.setLastLoginTime(lastLoginTime);vo.setCreateUserID(createUserID);vo.setCreateDate(createDate);vo.setModifyUserID(modifyUserID);vo.setModifyDate(modifyDate);vo.setRecordStatus(recordStatus);vo.setIsDeleted(isDeleted);		
		int effect=tradeUserDao.insert(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
	 
	@RequestMapping(value = "/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");		
		int effect=tradeUserDao.delete(id);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
}
