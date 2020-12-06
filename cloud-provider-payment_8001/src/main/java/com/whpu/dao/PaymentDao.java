package com.whpu.dao;


import com.commons.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

import javax.websocket.server.PathParam;

@Mapper
public interface PaymentDao {
    public int insert(Payment payment);

    public Payment getPaymentById(@PathParam("id") Long id);
}
