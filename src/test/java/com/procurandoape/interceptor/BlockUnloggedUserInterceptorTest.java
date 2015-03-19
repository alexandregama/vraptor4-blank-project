package com.procurandoape.interceptor;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.vraptor.util.test.MockResult;

import com.procurandoape.login.UserSession;

public class BlockUnloggedUserInterceptorTest {

	private UserSession userSession;

	private MockResult result;

	private InvocationContext invocationContext;

	private HttpServletRequest request;

	@Before
	public void setUp() {
		userSession = Mockito.mock(UserSession.class);
		invocationContext = Mockito.mock(InvocationContext.class);
		request = Mockito.mock(HttpServletRequest.class);
	}

	@Test
	public void shouldNotInterceptUserWhenTryingToAccessDeniedPage() throws Exception {
		BlockUnloggedUserInterceptor interceptor = new BlockUnloggedUserInterceptor(userSession, result, request);

		when(userSession.isUserLogged()).thenReturn(true);

		interceptor.intercept(invocationContext);

		verify(invocationContext).proceed();
	}

}
