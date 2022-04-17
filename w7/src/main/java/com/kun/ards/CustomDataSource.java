package com.kun.ards;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author kun
 * @date 2022/4/17
 */
public class CustomDataSource extends AbstractRoutingDataSource {

    static final ThreadLocal<String> DS = new ThreadLocal<>();

    @Override
    protected Object determineCurrentLookupKey() {
        return DS.get();
    }

}
