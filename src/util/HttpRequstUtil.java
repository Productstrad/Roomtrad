package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpRequstUtil {
	
	private static Log logger = LogFactory.getLog(HttpRequstUtil.class);
	
	/**
	 * 以get或post方式发送http请求
	 * mengdz
	 * @param eLink
	 * @param eArgs
	 * @param eMethod
	 * @param ReqEncode
	 * @param RespEncode
	 * @param eTimeout
	 * @return
	 * @throws Exception
	 */
	public static String SendHttpMsg(String eLink,String eArgs,String eMethod,String ReqEncode,String RespEncode,int eTimeout) throws Exception{
		return sendHttpMsg(eLink, eArgs, eMethod, null, false, ReqEncode, RespEncode, eTimeout);
	}
	
	/**
	 *  以get或post方式发送http请求,可自定义请求头header
	 * @param eLink
	 * @param eArgs
	 * @param eMethod
	 * @param header 指定访问请求头。
	 * @param isRetHeader 是否将影响头信息加到返回的文本里面,true增加，false不增加。
	 * @param ReqEncode
	 * @param RespEncode
	 * @param eTimeout
	 * @return
	 * @throws Exception
	 * @author wuzongbao
	 * @date 2012-10-24 上午10:29:08
	 */
	public static String sendHttpMsg(String eLink,String eArgs,String eMethod,Map<String,String> headerMap,Boolean isRetHeader, String ReqEncode,String RespEncode,int eTimeout) throws Exception{
		
		eMethod = eMethod.trim().toUpperCase();
		
//		printTxt("eMethod:" + eMethod);
		
		if(eMethod.equals("")){
			eMethod = "GET";
		}
		
		if(eMethod.equals("GET")){
			if(eArgs.length() > 0){
				if(!eLink.endsWith("?")){
					eLink = eLink + "?";
				}
				eLink = eLink + eArgs;
			}
		}
		
		URLConnection conn = new URL(eLink).openConnection();
		
		if(eTimeout>=0)conn.setConnectTimeout(eTimeout);//1秒超时
		if(headerMap!=null){
			Iterator iter = headerMap.entrySet().iterator();
			while (iter.hasNext()) {
			    Map.Entry entry = (Map.Entry) iter.next();
			    String key = entry.getKey().toString();
			    String val = entry.getValue().toString();
			    conn.setRequestProperty(key, val);
			} 
		}
		
		
		if(eMethod.equals("POST")){
//			Common.writeLog("log","HTTP","POST " + eLink + "?" + eArgs);
			((HttpURLConnection)conn).setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");	
			
			conn.setDoOutput(true);
			PrintStream out = new PrintStream(conn.getOutputStream(),true,ReqEncode);
			out.print(eArgs);
			out.close();
		}else if(eMethod.equals("GET")){
//			Common.writeLog("log","HTTP","GET " + eLink);
		}
		StringBuffer buf = new StringBuffer();
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),RespEncode));
		String inputLine;
		
		while((inputLine = in.readLine()) != null){
			buf.append(inputLine);
		}
		
		in.close();
		//Common.writeTxt("log","HTTP",buf.toString());
		
		//如果指定将header返回
		if(isRetHeader!=null && isRetHeader){
			buf.append(getXmlHeader(conn));
		}
		return buf.toString();		
	}
	
	/**
	 * 默认的get方式
	 * @param url
	 * @return
	 */
	public static String defaultGet(String url){
		return defaultGet(url, null, false);
	}
	
	/**
	 * get方式请求，同时根据isRetHeader参数返回请求的响应头信息。
	 * @param url 请求URL
	 * @param headerMap 参数
	 * @param isRetHeader 是否返回响应头
	 * @return String 响应内容
	 * @author wuzongbao
	 * @date 2012-11-7 下午04:38:04
	 */
	public static String defaultGet(String url,Map<String,String> headerMap, boolean isRetHeader){
		if(!StringUtil.isNotNullorEmpty(url)){
			return "";
		}
		String [] temp=url.split("\\?");
		String eLink="";
		String eArgs="";
		String result="";
		if(temp!=null && temp.length>0){
			eLink=temp[0];
		}
		if(temp!=null && temp.length>1){
			eArgs=temp[1];
		}
		try {
			result=sendHttpMsg(eLink, eArgs, "GET",headerMap, isRetHeader, "utf-8", "utf-8", 300);
		} catch (Exception e) {
			logger.error("",e);
			result="";
		}
		return result;
	}
	
	/**
	 * post方式发送http请求
	 * @param eLink
	 * @param eArgs
	 * @param enCode
	 * @return
	 */
	public static String defaultPost(String eLink,String eArgs,String enCode){
		String result="";
		try {
			result=SendHttpMsg(eLink, eArgs, "POST", enCode, enCode, 3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Exception",e);
			result="";
		}
		return result;
	}
	
	/**
	 * 检测HttpServletRequest参数，如果为null或空字符串抛出异常。
	 * @param req
	 * @param paramName
	 * @return String
	 *
	 * @author wuzongbao
	 * @throws Exception 
	 * @date 2012-2-15 上午09:54:01
	 */
	public static String checkReqParamsValueEmptyOrNull(HttpServletRequest req,String paramName) throws Exception{
		if(req==null || paramName==null){
			logger.error("参数错误，状态:-1,req=="+req+"，paramName="+paramName);
			throw new Exception("参数错误，状态:-1");
		}
		String value = req.getParameter(paramName);
		if(value==null || "".equals(value.trim())){
			logger.error("参数错误，状态:-2,req=="+req+"，paramName="+paramName);
			throw new Exception("参数错误，状态：-2");
		}
		return value;
	}
	
	/**
	 * 请http请求响应头以xml形式返回。
	 * @param conn URLConnection对象
	 * @return xml格式响应头
	 * @author wuzongbao
	 * @date 2012-10-24 下午02:49:29
	 */
	public static String getXmlHeader(URLConnection conn){
		if(conn==null){
			return null;
		}
		Map responseMap = conn.getHeaderFields();
		if(responseMap==null){
			return null;
		}
		StringBuffer sbf = new StringBuffer("<header>");
		Iterator iter = responseMap.entrySet().iterator();
//		while (iter.hasNext()) {
//		    Map.Entry entry = (Map.Entry) iter.next();
//		    if(entry!=null && entry.getKey()!=null){
//		    	String key = entry.getKey().toString();
//			    String val = entry.getValue()==null?"":entry.getValue().toString();
//			    sbf.append("<"+key+">"+val+"</"+key+">");
//		    }
//		    
//		}
		
	    for (Iterator iterator = responseMap.keySet().iterator(); iterator.hasNext();) {
	      String key = (String) iterator.next();
//	      System.out.println((key==null || "null".equals(key))?"Status":key + " = ");
//	      if(key==null || "null".equals(key)){
//	    	  
//	      }
	      sbf.append("<"+((key==null||"null".equals(key))==true?"Response-Status>":key+">"));//+val+"</"+key+">");
	      List values = (List) responseMap.get(key);
	      for (int i = 0; i < values.size(); i++) {
	        Object o = values.get(i);
//	        System.out.println(o + ", ");
	        if(values.size()-1!=i){
	        	sbf.append(o+",");
	        } else {
	        	sbf.append(o);
	        }
	      }
	      sbf.append("</"+((key==null||"null".equals(key))==true?"Response-Status>":key+">"));
	    }
	    
		sbf.append("</header>");
		
		return sbf.toString();
	}
}
