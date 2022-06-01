package com.zayden.coffeeshopordersystem.ehcache.config;

import lombok.extern.slf4j.Slf4j;
import org.ehcache.event.CacheEvent;

@Slf4j
public class CacheEventLogger {
    public void onEvent(CacheEvent<? extends Object, ? extends Object> cacheEvent) {
        log.info("cache event logger message. getKey: {} / getOldValue: {} / getNewValue:{}", cacheEvent.getKey(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
    }
}
