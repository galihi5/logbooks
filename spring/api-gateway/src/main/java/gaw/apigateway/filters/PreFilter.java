package gaw.apigateway.filters;

//import java.util.Enumeration;
//import java.util.Set;

//import java.util.List;
//import java.util.Map;

import javax.servlet.http.HttpServletRequest;

//import com.netflix.util.Pair;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreFilter extends ZuulFilter {
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();

		System.out.println(
				"Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());
		// Alter ignored headers as per:
		// https://gitter.im/spring-cloud/spring-cloud?at=56fea31f11ea211749c3ed22
//		Set<String> headers = (Set<String>) context.get("ignoredHeaders");
//		// We need our JWT tokens relayed to resource servers
//		System.out.println(headers);
//		if (headers!=null) {
//			headers.remove("authorization");
//		}
		System.out.println("req.header : " + request.getHeader("Authorization"));

		
		context.addZuulRequestHeader("Authorization", request.getHeader("Authorization"));

		System.out.println("-------------------------------");
		return null;
	}
}
