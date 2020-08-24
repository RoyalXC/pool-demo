package com.example.xxc.pooldemo.test;

import com.example.xxc.pooldemo.config.ConnectionFactory;
import com.example.xxc.pooldemo.config.ConnectionPool;
import com.example.xxc.pooldemo.spi.Connection;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * 功能描述:
 *
 * @author 薛行晨(RoyalXC)
 * @date 2020/8/24 20:03
 */
public class TestPool {
    public static void main(String[] args) {
        ConnectionFactory orderFactory = new ConnectionFactory();
        GenericObjectPoolConfig<Connection> config = new GenericObjectPoolConfig<>();
        config.setMaxTotal(2);
        //设置获取连接超时时间
        config.setMaxWaitMillis(1000);
        ConnectionPool connectionPool = new ConnectionPool(orderFactory, config);

        new Thread(() -> {
            while (true) {
                try {
                    Connection o = connectionPool.borrowObject();
                    System.out.println("1 borrowObject:" + o.toString() + ",getNumActive:" + connectionPool.getNumActive());
                    Thread.sleep(1000);
                    connectionPool.returnObject(o);
                    System.out.println("1 returnObject:" + o.toString() + ",getNumActive:" + connectionPool.getNumActive());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(() -> {
            while (true) {
                try {
                    Connection o = connectionPool.borrowObject();
                    System.out.println("2 borrowObject:" + o.toString() + ",getNumActive:" + connectionPool.getNumActive());
                    Thread.sleep(1500);
                    connectionPool.returnObject(o);
                    System.out.println("2 returnObject:" + o.toString() + ",getNumActive:" + connectionPool.getNumActive());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
