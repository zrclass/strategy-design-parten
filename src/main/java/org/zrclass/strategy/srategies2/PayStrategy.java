package org.zrclass.strategy.srategies2;

/**
 * @author zhourui
 * @version 1.0
 * @date 2021/8/1 11:00
 */
public interface PayStrategy {

    /**
     * 获取支付方式
     * @return
     */
    String getPayType();

    /**
     * 支付
     * @return
     */
    String pay();
}
