package org.zrclass.strategy.strategies;

import org.springframework.stereotype.Component;

/**
 * @author zhourui
 * @version 1.0
 * @date 2021/8/1 8:47
 */
@Component
public class AirTravelStrategy implements TravelStrategy {
    @Override
    public String travel() {
        return "air travel";
    }
}
