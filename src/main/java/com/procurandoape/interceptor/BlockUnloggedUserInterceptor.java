package com.procurandoape.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.Result;

import com.procurandoape.login.UserSession;

@Interceptor
@BlockUnloggedUser
public class BlockUnloggedUserInterceptor {

	private UserSession userSession;

	private Result result;

	private HttpServletRequest request;

	@Inject
	public BlockUnloggedUserInterceptor(UserSession userSession, Result result, HttpServletRequest request) {
		this.userSession = userSession;
		this.result = result;
		this.request = request;
	}

	@Deprecated //CDI Eyes only
	BlockUnloggedUserInterceptor() {
	}

	@AroundInvoke
	public Object intercept(InvocationContext ic) throws Exception {
		if (userSession.isUserLogged()) {
			return ic.proceed();
		}
		String uri = request.getRequestURI();
		String previousUri = uri.replace("/room/", "");
		result.redirectTo("login?redirectAfterLogin=" + previousUri);

		return ic;
	}

}
