package org.zrclass.strategy.strategies;

import org.springframework.stereotype.Component;

/**
 * @author zhourui
 * @version 1.0
 * @date 2021/8/1 8:49
 */
@Component
public class ShipTravelStrategy implements TravelStrategy {
    @Override
    public String travel() {
        return "ship travel";
    }
}
