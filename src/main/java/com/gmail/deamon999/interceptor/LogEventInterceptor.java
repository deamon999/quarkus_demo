package com.gmail.deamon999.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.jboss.logging.Logger;

@LogEvent
@Interceptor
public class LogEventInterceptor {

    private static final Logger logger = Logger.getLogger(LogEventInterceptor.class);

    @AroundInvoke
    public Object logEvent(InvocationContext ctx) throws Exception {
        logger.info(ctx.getMethod().getName());
        return ctx.proceed();
    }
}
