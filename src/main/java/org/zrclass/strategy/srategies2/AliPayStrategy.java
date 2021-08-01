package org.zrclass.strategy.srategies2;

import org.springframework.stereotype.Component;

/**
 * @author zhourui
 * @version 1.0
 * @date 2021/8/1 11:02
 */
@Component
public class AliPayStrategy implements PayStrategy {
    @Override
    public String getPayType() {
        return "支付宝";
    }

    @Override
    public String pay() {
        return "50元";
    }
}
