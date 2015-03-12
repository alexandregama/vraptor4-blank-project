package com.procurandoape.interceptor;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.interceptor.InvocationContext;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.vraptor.util.test.MockResult;

import com.procurandoape.login.UserSession;

public class AuthenticatorInterceptorTest {

	private UserSession userSession;

	private MockResult result;

	private InvocationContext invocationContext;

	@Before
	public void setUp() {
		userSession = Mockito.mock(UserSession.class);
		invocationContext = Mockito.mock(InvocationContext.class);
	}

	@Test
	public void shouldNotInterceptUserWhenTryingToAccessDeniedPage() throws Exception {
		AuthenticatorInterceptor interceptor = new AuthenticatorInterceptor(userSession, result);

		when(userSession.isUserLogged()).thenReturn(true);

		interceptor.intercept(invocationContext);

		verify(invocationContext).proceed();
	}

}
