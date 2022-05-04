package com.gmail.deamon999.filter;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class HeaderAdditionContainerResponseFilter implements ContainerResponseFilter {

    //Notice that in the case of the reactive-route endpoint, only the V-Header header is
    //added, and not the X-Header header. Meanwhile, in the JAX-RS endpoint, the request
    //is modified by both filters by adding both HTTP headers.
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().add("X-Header", "Header added by JAXRS Filter");
    }
}
