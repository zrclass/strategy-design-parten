package org.zrclass.strategy.srategies2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.zrclass.strategy.enums.PayTypeEnum;
import org.zrclass.strategy.utils.SpringContextUtil;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhourui
 * @version 1.0
 * @date 2021/8/1 11:13
 */
@Component
public class PayStrategyContext implements CommandLineRunner {

    private static ConcurrentHashMap<Integer, PayStrategy> map = new ConcurrentHashMap<>(16);

    /**
     * 根据支付方式完成支付
     * @param payType
     * @return
     */
    public String pay(Integer payType) {
        PayStrategy strategy = map.get(payType);
        return strategy.getPayType() + "付款：" + strategy.pay();
    }


    /**
     * 初始化策略
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        PayTypeEnum[] payTypeEnums = PayTypeEnum.values();
        for (PayTypeEnum payTypeEnum : payTypeEnums) {
            PayStrategy strategy = (PayStrategy) SpringContextUtil.getBean(payTypeEnum.getPayTypeClass());
            map.put(payTypeEnum.getPayType(), strategy);
        }
    }
}
