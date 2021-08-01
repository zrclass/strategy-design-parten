### 策略模式支付场景中的应用

#### 一.策略模式概述

##### 1.概念

 在策略模式（Strategy Pattern）中，一个类的行为或其算法可以在运行时更改。这种类型的设计模式属于行为型模式。 

##### 2.使用场景

1、系统有很多类，而他们的区别仅仅在于他们的行为不同

2、一个系统需要动态地在几种算法中选择一种 

##### 3.优缺点

**优点：** 1、算法可以自由切换。 2、避免使用多重条件判断。 3、扩展性良好。

**缺点：** 1、策略类会增多。 2、所有策略类都需要对外暴露。



#### 二.策略模式模拟支付场景

场景：需要根据用户选择不同的支付类型进行支付（微信，支付宝，银联等）

##### 1.策略接口

```java
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
```

##### 2.具体的策略实现类

###### （1）支付宝支付策略

```java
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
```

###### （2）微信支付策略

```java
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
```

##### 3.策略切换上下文类（根据用户选择的支付方式支付）

```java
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

```

##### 4.暴露给用户选择支付方式的接口

```java
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
```

# strategy-design-parten
