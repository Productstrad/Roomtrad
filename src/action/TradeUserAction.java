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
import dao.TradeUserDao;
import vo.TradeUser;

import java.util.Date;


@Controller
@RequestMapping("/tradeuser")
public class TradeUserAction {
	
	private Logger log = LoggerFactory.getLogger(TradeUserAction.class);
	
	@Autowired
	TradeUserDao tradeUserDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer userID=ParamUtil.getIntegerParameter(request,"userID");
		String userName=ParamUtil.getStringParameter(request,"userName");
		String userPassword=ParamUtil.getStringParameter(request,"userPassword");
		Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");
		Integer deptID=ParamUtil.getIntegerParameter(request,"deptID");
		String phone=ParamUtil.getStringParameter(request,"phone");
		String fax=ParamUtil.getStringParameter(request,"fax");
		String email=ParamUtil.getStringParameter(request,"email");
		String qq=ParamUtil.getStringParameter(request,"qq");
		String nickName=ParamUtil.getStringParameter(request,"nickName");
		String address=ParamUtil.getStringParameter(request,"address");
		String realName=ParamUtil.getStringParameter(request,"realName");
		Integer sex=ParamUtil.getIntegerParameter(request,"sex");
		Integer enabled=ParamUtil.getIntegerParameter(request,"enabled");
		Date lastLoginTime=ParamUtil.getDateParameter(request,"lastLoginTime");
		Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");
		Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");
		String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");
		Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted");
		
		Map params = new HashMap();
		params.put("userID", userID);
		params.put("userName", userName);
		params.put("userPassword", userPassword);
		params.put("roleID", roleID);
		params.put("deptID", deptID);
		params.put("phone", phone);
		params.put("fax", fax);
		params.put("email", email);
		params.put("qq", qq);
		params.put("nickName", nickName);
		params.put("address", address);
		params.put("realName", realName);
		params.put("sex", sex);
		params.put("enabled", enabled);
		params.put("lastLoginTime", lastLoginTime);
		params.put("createUserID", createUserID);
		params.put("createDate", createDate);
		params.put("modifyUserID", modifyUserID);
		params.put("modifyDate", modifyDate);
		params.put("recordStatus", recordStatus);
		params.put("isDeleted", isDeleted);
			
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", tradeUserDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(tradeUserDao.findCount(params), pageSize, request, model);		
		return "tradeuser/list";
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
		return "tradeuser/update";
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
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "userID_set"))){
			paramsMap.put("userID_set", ParamUtil.getIntegerParameter(request, "userID_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "userName_set"))){
			paramsMap.put("userName_set", ParamUtil.getStringParameter(request, "userName_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "userPassword_set"))){
			paramsMap.put("userPassword_set", ParamUtil.getStringParameter(request, "userPassword_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "roleID_set"))){
			paramsMap.put("roleID_set", ParamUtil.getIntegerParameter(request, "roleID_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "deptID_set"))){
			paramsMap.put("deptID_set", ParamUtil.getIntegerParameter(request, "deptID_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "phone_set"))){
			paramsMap.put("phone_set", ParamUtil.getStringParameter(request, "phone_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "fax_set"))){
			paramsMap.put("fax_set", ParamUtil.getStringParameter(request, "fax_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "email_set"))){
			paramsMap.put("email_set", ParamUtil.getStringParameter(request, "email_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "qq_set"))){
			paramsMap.put("qq_set", ParamUtil.getStringParameter(request, "qq_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "nickName_set"))){
			paramsMap.put("nickName_set", ParamUtil.getStringParameter(request, "nickName_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "address_set"))){
			paramsMap.put("address_set", ParamUtil.getStringParameter(request, "address_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "realName_set"))){
			paramsMap.put("realName_set", ParamUtil.getStringParameter(request, "realName_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "sex_set"))){
			paramsMap.put("sex_set", ParamUtil.getIntegerParameter(request, "sex_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "enabled_set"))){
			paramsMap.put("enabled_set", ParamUtil.getIntegerParameter(request, "enabled_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "lastLoginTime_set"))){
			paramsMap.put("lastLoginTime_set", ParamUtil.getDateParameter(request, "lastLoginTime_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "createUserID_set"))){
			paramsMap.put("createUserID_set", ParamUtil.getIntegerParameter(request, "createUserID_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "createDate_set"))){
			paramsMap.put("createDate_set", ParamUtil.getDateParameter(request, "createDate_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "modifyUserID_set"))){
			paramsMap.put("modifyUserID_set", ParamUtil.getIntegerParameter(request, "modifyUserID_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "modifyDate_set"))){
			paramsMap.put("modifyDate_set", ParamUtil.getDateParameter(request, "modifyDate_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "recordStatus_set"))){
			paramsMap.put("recordStatus_set", ParamUtil.getStringParameter(request, "recordStatus_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "isDeleted_set"))){
			paramsMap.put("isDeleted_set", ParamUtil.getIntegerParameter(request, "isDeleted_set"));
		}
		
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "userID"))){
			paramsMap.put("userID", ParamUtil.getIntegerParameter(request, "userID"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "userName"))){
			paramsMap.put("userName", ParamUtil.getStringParameter(request, "userName"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "userPassword"))){
			paramsMap.put("userPassword", ParamUtil.getStringParameter(request, "userPassword"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "roleID"))){
			paramsMap.put("roleID", ParamUtil.getIntegerParameter(request, "roleID"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "deptID"))){
			paramsMap.put("deptID", ParamUtil.getIntegerParameter(request, "deptID"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "phone"))){
			paramsMap.put("phone", ParamUtil.getStringParameter(request, "phone"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "fax"))){
			paramsMap.put("fax", ParamUtil.getStringParameter(request, "fax"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "email"))){
			paramsMap.put("email", ParamUtil.getStringParameter(request, "email"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "qq"))){
			paramsMap.put("qq", ParamUtil.getStringParameter(request, "qq"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "nickName"))){
			paramsMap.put("nickName", ParamUtil.getStringParameter(request, "nickName"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "address"))){
			paramsMap.put("address", ParamUtil.getStringParameter(request, "address"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "realName"))){
			paramsMap.put("realName", ParamUtil.getStringParameter(request, "realName"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "sex"))){
			paramsMap.put("sex", ParamUtil.getIntegerParameter(request, "sex"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "enabled"))){
			paramsMap.put("enabled", ParamUtil.getIntegerParameter(request, "enabled"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "lastLoginTime"))){
			paramsMap.put("lastLoginTime", ParamUtil.getDateParameter(request, "lastLoginTime"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "createUserID"))){
			paramsMap.put("createUserID", ParamUtil.getIntegerParameter(request, "createUserID"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "createDate"))){
			paramsMap.put("createDate", ParamUtil.getDateParameter(request, "createDate"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "modifyUserID"))){
			paramsMap.put("modifyUserID", ParamUtil.getIntegerParameter(request, "modifyUserID"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "modifyDate"))){
			paramsMap.put("modifyDate", ParamUtil.getDateParameter(request, "modifyDate"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "recordStatus"))){
			paramsMap.put("recordStatus", ParamUtil.getStringParameter(request, "recordStatus"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "isDeleted"))){
			paramsMap.put("isDeleted", ParamUtil.getIntegerParameter(request, "isDeleted"));
		}
		int effect=tradeUserDao.update(paramsMap);
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
		Integer userID=ParamUtil.getIntegerParameter(request,"userID");
		String userName=ParamUtil.getStringParameter(request,"userName");
		String userPassword=ParamUtil.getStringParameter(request,"userPassword");
		Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");
		Integer deptID=ParamUtil.getIntegerParameter(request,"deptID");
		String phone=ParamUtil.getStringParameter(request,"phone");
		String fax=ParamUtil.getStringParameter(request,"fax");
		String email=ParamUtil.getStringParameter(request,"email");
		String qq=ParamUtil.getStringParameter(request,"qq");
		String nickName=ParamUtil.getStringParameter(request,"nickName");
		String address=ParamUtil.getStringParameter(request,"address");
		String realName=ParamUtil.getStringParameter(request,"realName");
		Integer sex=ParamUtil.getIntegerParameter(request,"sex");
		Integer enabled=ParamUtil.getIntegerParameter(request,"enabled");
		Date lastLoginTime=ParamUtil.getDateParameter(request,"lastLoginTime");
		Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");
		Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");
		String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");
		Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted");
			
		TradeUser vo=new TradeUser();
		vo.setUserID(userID);
		vo.setUserName(userName);
		vo.setUserPassword(userPassword);
		vo.setRoleID(roleID);
		vo.setDeptID(deptID);
		vo.setPhone(phone);
		vo.setFax(fax);
		vo.setEmail(email);
		vo.setQq(qq);
		vo.setNickName(nickName);
		vo.setAddress(address);
		vo.setRealName(realName);
		vo.setSex(sex);
		vo.setEnabled(enabled);
		vo.setLastLoginTime(lastLoginTime);
		vo.setCreateUserID(createUserID);
		vo.setCreateDate(createDate);
		vo.setModifyUserID(modifyUserID);
		vo.setModifyDate(modifyDate);
		vo.setRecordStatus(recordStatus);
		vo.setIsDeleted(isDeleted);
				
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
		return "tradeuser/add";
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
		Integer userID=ParamUtil.getIntegerParameter(request,"userID");
		String userName=ParamUtil.getStringParameter(request,"userName");
		String userPassword=ParamUtil.getStringParameter(request,"userPassword");
		Integer roleID=ParamUtil.getIntegerParameter(request,"roleID");
		Integer deptID=ParamUtil.getIntegerParameter(request,"deptID");
		String phone=ParamUtil.getStringParameter(request,"phone");
		String fax=ParamUtil.getStringParameter(request,"fax");
		String email=ParamUtil.getStringParameter(request,"email");
		String qq=ParamUtil.getStringParameter(request,"qq");
		String nickName=ParamUtil.getStringParameter(request,"nickName");
		String address=ParamUtil.getStringParameter(request,"address");
		String realName=ParamUtil.getStringParameter(request,"realName");
		Integer sex=ParamUtil.getIntegerParameter(request,"sex");
		Integer enabled=ParamUtil.getIntegerParameter(request,"enabled");
		Date lastLoginTime=ParamUtil.getDateParameter(request,"lastLoginTime");
		Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");
		Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");
		String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");
		Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted");
			
		TradeUser vo=new TradeUser();
		vo.setUserID(userID);
		vo.setUserName(userName);
		vo.setUserPassword(userPassword);
		vo.setRoleID(roleID);
		vo.setDeptID(deptID);
		vo.setPhone(phone);
		vo.setFax(fax);
		vo.setEmail(email);
		vo.setQq(qq);
		vo.setNickName(nickName);
		vo.setAddress(address);
		vo.setRealName(realName);
		vo.setSex(sex);
		vo.setEnabled(enabled);
		vo.setLastLoginTime(lastLoginTime);
		vo.setCreateUserID(createUserID);
		vo.setCreateDate(createDate);
		vo.setModifyUserID(modifyUserID);
		vo.setModifyDate(modifyDate);
		vo.setRecordStatus(recordStatus);
		vo.setIsDeleted(isDeleted);
				
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
