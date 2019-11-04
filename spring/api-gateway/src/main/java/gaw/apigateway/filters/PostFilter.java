package gaw.apigateway.filters;

import java.util.ArrayList;
import java.util.List;

import com.netflix.util.Pair;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PostFilter extends ZuulFilter {
	@Override
	public String filterType() {
		return "post";
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
		System.out.println("Inside Response Filter");
		RequestContext context = RequestContext.getCurrentContext();
	    List<Pair<String, String>> filteredResponseHeaders = new ArrayList<>();

	    List<Pair<String, String>> oriResponseHeaders = context.getOriginResponseHeaders();
		if (oriResponseHeaders != null) {
			for (Pair<String, String> it : oriResponseHeaders) {
//				System.out.println(it.first()+" : "+it.second());
				if (!it.first().contains("X-")) {
					Pair<String, String> pair = new Pair<>(it.first(), it.second());
					filteredResponseHeaders.add(pair);
				}
			}
		}
	    context.put("zuulResponseHeaders", filteredResponseHeaders);
		System.out.println("-------------------------------");
		return null;
	}
}
