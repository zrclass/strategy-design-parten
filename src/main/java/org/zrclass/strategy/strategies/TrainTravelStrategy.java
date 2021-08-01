package org.zrclass.strategy.strategies;

import org.springframework.stereotype.Component;

/**
 * @author zhourui
 * @version 1.0
 * @date 2021/8/1 8:46
 */
@Component
public class TrainTravelStrategy implements TravelStrategy {
    @Override
    public String travel() {
        return "train travel";
    }
}
