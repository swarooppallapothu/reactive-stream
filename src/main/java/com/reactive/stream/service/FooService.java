package com.reactive.stream.service;

import com.reactive.stream.dto.Foo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

/**
 * @author Swaroop Pallapothu
 */
@Service
public class FooService {

    private final AtomicLong al = new AtomicLong(0);

    public Flux<Foo> streamFoo() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
        Flux<Foo> events =
                Flux
                        .fromStream(Stream.generate(
                                () -> new Foo(al.incrementAndGet(), "Foo " + al.get())));
        return Flux.zip(events, interval, (key, value) -> key);
    }

}
