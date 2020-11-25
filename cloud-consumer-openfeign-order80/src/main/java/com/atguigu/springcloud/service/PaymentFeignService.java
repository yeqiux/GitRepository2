package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient("cloud-payment-service")
public interface PaymentFeignService {
    @PostMapping("/payment/create")

    public CommonResult create(@RequestBody Payment payment);
    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
    @GetMapping("/payment/feign/timeout")
    public  String paymentFeignTimeout();

}