package com.procurandoape.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import br.com.caelum.vraptor.Result;

import com.procurandoape.login.LoginController;
import com.procurandoape.login.UserSession;

@Interceptor
@Authenticator
public class AuthenticatorInterceptor {

	private UserSession userSession;

	private Result result;

	@Inject
	public AuthenticatorInterceptor(UserSession userSession, Result result) {
		this.userSession = userSession;
		this.result = result;
	}

	@Deprecated //CDI Eyes only
	AuthenticatorInterceptor() {
	}

	@AroundInvoke
	public Object intercept(InvocationContext ic) throws Exception {
		if (userSession.isUserLogged()) {
			return ic.proceed();
		}
		result.redirectTo(LoginController.class).login();
		return ic;
	}

}
