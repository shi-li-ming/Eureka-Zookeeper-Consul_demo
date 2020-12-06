package com.whpu.service.impl;

import com.commons.entity.Payment;
import com.whpu.dao.PaymentDao;
import com.whpu.service.PaymentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Service
public class PaymentServiceImpl implements PaymentService {

    //注入
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int insert(Payment payment) {
        return paymentDao.insert(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
