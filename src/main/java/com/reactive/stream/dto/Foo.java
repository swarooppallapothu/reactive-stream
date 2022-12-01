package com.reactive.stream.dto;

import java.time.LocalDateTime;

/**
 * @author Swaroop Pallapothu
 */
public class Foo {

    private final long id;
    private final String name;
    private final LocalDateTime dateTime;

    public Foo(long id, String name) {
        this.id = id;
        this.name = name;
        this.dateTime = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

}
