package com.wordpress.ericchen231.spring_boot_demo1;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class MySpringBootRouter extends RouteBuilder {

    @Override
    public void configure() {
        restConfiguration()
        .component("servlet")
        .host("localhost")
        .bindingMode(RestBindingMode.auto);
        
        rest("/say/hello")
        .get().route().transform().constant("Hello World");
    }

}
