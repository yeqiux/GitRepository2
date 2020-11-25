package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import com.atguigu.springcloud.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private PaymentFeignService paymentFeignService;
    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create (@RequestBody Payment payment){
        log.info("消费者远程调用插入payment数据");

        return paymentFeignService.create(payment);
    }

    @GetMapping("/consumer/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        log.info("消费者远程调用通过id获取对应的payment数据");
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/feign/timeout")
    public  String paymentFeignTimeout() {
    return paymentFeignService.paymentFeignTimeout();
    }


}
