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
import dao.Trade_departmentDao;
import vo.Trade_department;

import java.sql.Timestamp;


@Controller
@RequestMapping("/trade_department")
public class Trade_departmentAction {
	
	private Logger log = LoggerFactory.getLogger(Trade_departmentAction.class);
	
	@Autowired
	Trade_departmentDao trade_departmentDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", ParamUtil.getIntegerParameter(request,"id"));
		params.put("deptName", ParamUtil.getStringParameter(request,"deptName"));
		params.put("deptDescription", ParamUtil.getStringParameter(request,"deptDescription"));
		params.put("parentID", ParamUtil.getIntegerParameter(request,"parentID"));
		params.put("createDate", ParamUtil.getTimestampParameter(request,"createDate"));
		params.put("status", ParamUtil.getIntegerParameter(request,"status"));
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", trade_departmentDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(trade_departmentDao.findCount(params), pageSize, request, model);		
		return "trade_department/list";
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
		Trade_department vo=trade_departmentDao.findByPK(id);
		model.addAttribute("vo", vo);
		return "trade_department/update";
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
		String deptName=ParamUtil.getStringParameter(request,"deptName");		
		String deptDescription=ParamUtil.getStringParameter(request,"deptDescription");		
		Integer parentID=ParamUtil.getIntegerParameter(request,"parentID");		
		Timestamp createDate=ParamUtil.getTimestampParameter(request,"createDate");		
		Integer status=ParamUtil.getIntegerParameter(request,"status");	
		Trade_department vo=new Trade_department();
		vo.setId(id);
		vo.setDeptName(deptName);
		vo.setDeptDescription(deptDescription);
		vo.setParentID(parentID);
		vo.setCreateDate(createDate);
		vo.setStatus(status);		
		int effect=trade_departmentDao.update(vo);
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
		return "trade_department/add";
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
		String deptName=ParamUtil.getStringParameter(request,"deptName");	
		String deptDescription=ParamUtil.getStringParameter(request,"deptDescription");	
		Integer parentID=ParamUtil.getIntegerParameter(request,"parentID");	
		Timestamp createDate=ParamUtil.getTimestampParameter(request,"createDate");	
		Integer status=ParamUtil.getIntegerParameter(request,"status");	
		Trade_department vo=new Trade_department();
		vo.setId(id);
		vo.setDeptName(deptName);
		vo.setDeptDescription(deptDescription);
		vo.setParentID(parentID);
		vo.setCreateDate(createDate);
		vo.setStatus(status);		
		int effect=trade_departmentDao.insert(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
	 
	@RequestMapping(value = "/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");		
		int effect=trade_departmentDao.delete(id);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
}
