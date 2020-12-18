package com.vivo.crm.app.rest.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class IdGenerator {

    private final AtomicLong nextId = new AtomicLong();

    public Long getId() {
        return nextId.incrementAndGet();
    }


}
