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
import dao.TradeDepartmentDao;
import vo.TradeDepartment;

import java.util.Date;


@Controller
@RequestMapping("/tradedepartment")
public class TradeDepartmentAction {
	
	private Logger log = LoggerFactory.getLogger(TradeDepartmentAction.class);
	
	@Autowired
	TradeDepartmentDao tradeDepartmentDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer deptID=ParamUtil.getIntegerParameter(request,"deptID");
		String deptName=ParamUtil.getStringParameter(request,"deptName");
		String deptDescription=ParamUtil.getStringParameter(request,"deptDescription");
		Integer parentID=ParamUtil.getIntegerParameter(request,"parentID");
		Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");
		Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");
		String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");
		Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted");
		
		Map params = new HashMap();
		params.put("deptID", deptID);
		params.put("deptName", deptName);
		params.put("deptDescription", deptDescription);
		params.put("parentID", parentID);
		params.put("createUserID", createUserID);
		params.put("createDate", createDate);
		params.put("modifyUserID", modifyUserID);
		params.put("modifyDate", modifyDate);
		params.put("recordStatus", recordStatus);
		params.put("isDeleted", isDeleted);
			
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", tradeDepartmentDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(tradeDepartmentDao.findCount(params), pageSize, request, model);		
		return "tradedepartment/list";
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
		TradeDepartment vo=tradeDepartmentDao.findByPK(id);
		model.addAttribute("vo", vo);
		return "tradedepartment/update";
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
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "deptID_set"))){
			paramsMap.put("deptID_set", ParamUtil.getIntegerParameter(request, "deptID_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "deptName_set"))){
			paramsMap.put("deptName_set", ParamUtil.getStringParameter(request, "deptName_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "deptDescription_set"))){
			paramsMap.put("deptDescription_set", ParamUtil.getStringParameter(request, "deptDescription_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "parentID_set"))){
			paramsMap.put("parentID_set", ParamUtil.getIntegerParameter(request, "parentID_set"));
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
		
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "deptID"))){
			paramsMap.put("deptID", ParamUtil.getIntegerParameter(request, "deptID"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "deptName"))){
			paramsMap.put("deptName", ParamUtil.getStringParameter(request, "deptName"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "deptDescription"))){
			paramsMap.put("deptDescription", ParamUtil.getStringParameter(request, "deptDescription"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "parentID"))){
			paramsMap.put("parentID", ParamUtil.getIntegerParameter(request, "parentID"));
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
		int effect=tradeDepartmentDao.update(paramsMap);
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
		Integer deptID=ParamUtil.getIntegerParameter(request,"deptID");
		String deptName=ParamUtil.getStringParameter(request,"deptName");
		String deptDescription=ParamUtil.getStringParameter(request,"deptDescription");
		Integer parentID=ParamUtil.getIntegerParameter(request,"parentID");
		Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");
		Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");
		String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");
		Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted");
			
		TradeDepartment vo=new TradeDepartment();
		vo.setDeptID(deptID);
		vo.setDeptName(deptName);
		vo.setDeptDescription(deptDescription);
		vo.setParentID(parentID);
		vo.setCreateUserID(createUserID);
		vo.setCreateDate(createDate);
		vo.setModifyUserID(modifyUserID);
		vo.setModifyDate(modifyDate);
		vo.setRecordStatus(recordStatus);
		vo.setIsDeleted(isDeleted);
				
		int effect=tradeDepartmentDao.update(vo);
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
		return "tradedepartment/add";
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
		Integer deptID=ParamUtil.getIntegerParameter(request,"deptID");
		String deptName=ParamUtil.getStringParameter(request,"deptName");
		String deptDescription=ParamUtil.getStringParameter(request,"deptDescription");
		Integer parentID=ParamUtil.getIntegerParameter(request,"parentID");
		Integer createUserID=ParamUtil.getIntegerParameter(request,"createUserID");
		Date createDate=ParamUtil.getDateParameter(request,"createDate");
		Integer modifyUserID=ParamUtil.getIntegerParameter(request,"modifyUserID");
		Date modifyDate=ParamUtil.getDateParameter(request,"modifyDate");
		String recordStatus=ParamUtil.getStringParameter(request,"recordStatus");
		Integer isDeleted=ParamUtil.getIntegerParameter(request,"isDeleted");
			
		TradeDepartment vo=new TradeDepartment();
		vo.setDeptID(deptID);
		vo.setDeptName(deptName);
		vo.setDeptDescription(deptDescription);
		vo.setParentID(parentID);
		vo.setCreateUserID(createUserID);
		vo.setCreateDate(createDate);
		vo.setModifyUserID(modifyUserID);
		vo.setModifyDate(modifyDate);
		vo.setRecordStatus(recordStatus);
		vo.setIsDeleted(isDeleted);
				
		int effect=tradeDepartmentDao.insert(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
	 
	@RequestMapping(value = "/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");		
		int effect=tradeDepartmentDao.delete(id);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
}
