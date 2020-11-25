package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String port;
    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result= paymentService.create(payment);
        log.info("*******插入结果:"+payment);
       if(result>0){
           return new CommonResult(200,"插入数据成功"+port,payment);
       }
       else {
           return new CommonResult(444,"插入数据失败"+port,null);
       }
    }

    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("*******插入 结果"+result);
        if(result!=null){
            return new CommonResult<>(200,"获取数据成功"+port,result);
        }
        else {
            return new CommonResult<>(444,"获取数据失败"+port,null);
        }
    }

    @GetMapping("/payment/feign/timeout")
    public  String paymentFeignTimeout(){
       /* try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return  port;
    }

}
