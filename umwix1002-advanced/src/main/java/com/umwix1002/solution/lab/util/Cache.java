package com.umwix1002.solution.lab.util;

import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class Cache {
    private final com.google.common.cache.Cache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(100)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build();

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.getIfPresent(key);
    }
}
