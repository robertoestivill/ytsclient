package yts.request.interceptor;

import retrofit.RequestInterceptor;

public class UserAgentInterceptor implements RequestInterceptor {

    private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.82 Safari/537.36";

    @Override
    public void intercept(RequestFacade request) {
        request.addHeader("User-Agent", USER_AGENT);
    }
}
