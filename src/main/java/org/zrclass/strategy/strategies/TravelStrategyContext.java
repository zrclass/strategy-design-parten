package org.zrclass.strategy.strategies;

import org.zrclass.strategy.enums.TravelTypeEnum;
import org.zrclass.strategy.utils.SpringContextUtil;

/**
 * @author zhourui
 * @version 1.0
 * @date 2021/8/1 9:02
 */
public class TravelStrategyContext {

    private static TravelStrategy getStrategyByType(int type) {
        String typeClass = TravelTypeEnum.getTypeClassByType(type);
        TravelStrategy strategy = (TravelStrategy) SpringContextUtil.getBean(typeClass);
        return strategy;
    }

    public static String travel(int type){
        return TravelStrategyContext.getStrategyByType(type).travel();
    }
}
