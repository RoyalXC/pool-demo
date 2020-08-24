package com.example.xxc.pooldemo.spi;

import lombok.Data;

/**
 * 功能描述:
 *
 * @author 薛行晨(RoyalXC)
 * @date 2020/8/24 19:47
 */
@Data
public class Connection {
    private Integer id;

    public Connection(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
