package org.zrclass.strategy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zrclass.strategy.strategies.TravelStrategyContext;

/**
 * @author zhourui
 * @version 1.0
 * @date 2021/8/1 9:45
 */
@RestController
@RequestMapping
public class TravelController {
    @GetMapping("/travel/{type}")
    public String travel(@PathVariable("type") String type){
        return TravelStrategyContext.travel(Integer.parseInt(type));
    }
}
