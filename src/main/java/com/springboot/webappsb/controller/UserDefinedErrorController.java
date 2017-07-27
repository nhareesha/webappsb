/**
 * 
 */
package com.springboot.webappsb.controller;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author Hareesha
 * Jul 10, 2017 2017
 */
@Controller
public class UserDefinedErrorController implements ErrorController{
	
	public static final String ERROR_PATH="/error";
	public static final String ERROR_TEMPLATE="CustomGlobalErrorPage";
	
	private final ErrorAttributes errorAttributes;

	@Autowired
	public UserDefinedErrorController(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;
	}

	/* (non-Javadoc)
	 * @see org.springframework.boot.autoconfigure.web.ErrorController#getErrorPath()
	 */
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
	
	/**
	 * this mapping handles the /error which is configured in servletContainer as
	 * GlobalErrorHandler path, here we are customising the content
	 * @param model
	 * @param req
	 * @param locale
	 * @return
	 */
	@RequestMapping(ERROR_PATH)
	public String displayError(Model model , HttpServletRequest req ,Locale locale){
		
		Map<String,Object> errorMap = getErrorAttributes(req, true);
		
		// {error={timestamp=Mon Nov 02 12:40:50 EST 2015, status=404, error=Not Found, message=No message available, path=/foo}}
	
		model.addAttribute("timestamp",errorMap.get("timestamp"));
		model.addAttribute("status",errorMap.get("status"));
		model.addAttribute("error",errorMap.get("error"));
		model.addAttribute("message",errorMap.get("message"));
		model.addAttribute("path", errorMap.get("path"));
		return ERROR_TEMPLATE;
	}
	
	/**
	 * when 404 error occurs we have to display the given template
	 * @return
	 */
	@RequestMapping("/404Error")
	public String display204ErrorPage(Model model, HttpServletRequest req){
		Map<String,Object> errors = getErrorAttributes(req, true);
		model.addAttribute("errors",errors);
		return "PageNotFound_custom_404";
	}
	
	private Map<String,Object>  getErrorAttributes(HttpServletRequest req , boolean includeStackTrace){
		
		RequestAttributes reqAttributes = new ServletRequestAttributes(req);
		return this.errorAttributes.getErrorAttributes(reqAttributes,includeStackTrace);
	}
}
