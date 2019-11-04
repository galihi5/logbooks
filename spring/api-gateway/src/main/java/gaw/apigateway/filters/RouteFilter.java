package gaw.apigateway.filters;

//import java.util.Enumeration;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;

//import javax.servlet.http.HttpServletResponse;

//import com.netflix.util.Pair;
import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;

public class RouteFilter extends ZuulFilter {
	@Override
	public String filterType() {
		return "route";
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
		System.out.println("Inside Route Filter");
//		RequestContext context = RequestContext.getCurrentContext();
//	    context.setSendZuulResponse(true);
		System.out.println("-------------------------------");
		return null;
	}
}
