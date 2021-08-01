package org.zrclass.strategy.srategies2;

import org.springframework.stereotype.Component;

/**
 * @author zhourui
 * @version 1.0
 * @date 2021/8/1 11:03
 */
@Component
public class WeChatPayStrategy implements PayStrategy {
    @Override
    public String getPayType() {
        return "微信";
    }

    @Override
    public String pay() {
        return "100元";
    }
}
