package org.zrclass.strategy.enums;

/**
 * @author zhourui
 * @version 1.0
 * @date 2021/8/1 11:04
 */
public enum PayTypeEnum {
    ALI_PAY(1, "aliPayStrategy"),
    WECHAT_PAY(2,"weChatPayStrategy")
    ;

    private int payType;
    private String payTypeClass;

    PayTypeEnum() {
    }

    PayTypeEnum(int payType, String payTypeClass) {
        this.payType = payType;
        this.payTypeClass = payTypeClass;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public String getPayTypeClass() {
        return payTypeClass;
    }

    public void setPayTypeClass(String payTypeClass) {
        this.payTypeClass = payTypeClass;
    }
}
