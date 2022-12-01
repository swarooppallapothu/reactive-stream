package com.reactive.stream.component;

import com.reactive.stream.dto.Foo;
import com.reactive.stream.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author Swaroop Pallapothu
 */
@Component
public class FooHandler {

    @Autowired
    private FooService fooService;

    public Mono<ServerResponse> get(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Foo(1, "Foo 1")));
    }


    public Mono<ServerResponse> streamFoo(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(fooService.streamFoo(), Foo.class);
    }

}
