package com.example.xxc.pooldemo.config;

import com.example.xxc.pooldemo.spi.Connection;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * 功能描述:
 *
 * @author 薛行晨(RoyalXC)
 * @date 2020/8/24 19:54
 */
public class ConnectionPool extends GenericObjectPool<Connection> {
    public ConnectionPool(PooledObjectFactory<Connection> factory) {
        super(factory);
    }

    public ConnectionPool(PooledObjectFactory<Connection> factory, GenericObjectPoolConfig<Connection> config) {
        super(factory, config);
    }

    public ConnectionPool(PooledObjectFactory<Connection> factory, GenericObjectPoolConfig<Connection> config, AbandonedConfig abandonedConfig) {
        super(factory, config, abandonedConfig);
    }
}
