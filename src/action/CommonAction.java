/**
 * 
 */
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mendz
 *	2014年8月28日
 */
@Controller
@RequestMapping("/")
public class CommonAction {

	private Logger log = LoggerFactory.getLogger(CommonAction.class);
	
	@RequestMapping(value = "/index.do")
	public String index(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		return "index";
	}
}
