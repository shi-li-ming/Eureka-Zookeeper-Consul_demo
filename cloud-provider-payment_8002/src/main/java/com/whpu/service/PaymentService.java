package com.whpu.service;


import com.commons.entity.Payment;

import javax.websocket.server.PathParam;

public interface PaymentService {
    public int insert(Payment payment);

    public Payment getPaymentById(@PathParam("id") Long id);
}
