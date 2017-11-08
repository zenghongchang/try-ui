package edu.hnust.core.map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestMap {

	@Autowired
	private HttpServletRequest request;

	public Object get(String paramString) {
		return this.request.getAttribute(paramString);
	}

	public void put(String paramString, Object paramObject) {
		this.request.setAttribute(paramString, paramObject);
	}
}