package com.example.xxc.pooldemo.config;

import com.example.xxc.pooldemo.spi.Connection;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述:
 *
 * @author 薛行晨(RoyalXC)
 * @date 2020/8/24 19:53
 */
public class ConnectionFactory extends BasePooledObjectFactory<Connection> {

    private final AtomicInteger idCount = new AtomicInteger(1);

    @Override
    public Connection create() throws Exception {
        return new Connection(idCount.getAndAdd(1));
    }

    @Override
    public PooledObject<Connection> wrap(Connection obj) {
        return new DefaultPooledObject<>(obj);
    }
}
