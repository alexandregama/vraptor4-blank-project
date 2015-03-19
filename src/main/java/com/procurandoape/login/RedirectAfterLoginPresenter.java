package com.procurandoape.login;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class RedirectAfterLoginPresenter {

	private HttpServletRequest request;

	@Inject
	public RedirectAfterLoginPresenter(HttpServletRequest request) {
		this.request = request;
	}

	@Deprecated //CDI Eyes only
	RedirectAfterLoginPresenter() {
	}

	public String getPreviousUrl() {
		String requestURI = (String) request.getParameter("redirectAfterLogin");
		if (requestURI == null || requestURI.isEmpty()) {
			return "login";
		}
		requestURI = "login?redirectAfterLogin=" + requestURI;
		return requestURI;
	}

	public String getUrlAfterLogin() {
		String requestURI = (String) request.getParameter("redirectAfterLogin");
		if (requestURI == null || requestURI.isEmpty()) {
			return "/";
		}
		return requestURI;
	}

}
