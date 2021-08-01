package org.zrclass.strategy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zrclass.strategy.srategies2.PayStrategyContext;

/**
 * @author zhourui
 * @version 1.0
 * @date 2021/8/1 11:23
 */
@RestController
@RequestMapping
public class PayController {

    @Autowired
    private PayStrategyContext payStrategyContext;

    @GetMapping("/pay/{payType}")
    public String pay(@PathVariable("payType") String payType) {
        return payStrategyContext.pay(Integer.parseInt(payType));
    }
}
