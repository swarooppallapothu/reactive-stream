package com.reactive.stream.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author Swaroop Pallapothu
 */
@Configuration
public class FooRouter {

    @Bean
    public RouterFunction<ServerResponse> routeFoo(FooHandler fooHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/foo")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), fooHandler::get)
                .andRoute(RequestPredicates.GET("/stream-foo")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), fooHandler::streamFoo);
    }

}
