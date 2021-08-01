package org.zrclass.strategy.enums;

/**
 * @author zhourui
 * @version 1.0
 * @date 2021/8/1 8:51
 */
public enum TravelTypeEnum {
    AIR_TRAVEL_STRATEGY(1, "airTravelStrategy"),
    SHIP_TRAVEL_STRATEGY(2,"shipTravelStrategy"),
    TRAIN_TRAVEL_STRATEGY(3,"trainTravelStrategy");

    private int typeCode;
    private String strategyClass;

    TravelTypeEnum() {
    }

    TravelTypeEnum(int typeCode, String strategyClass) {
        this.typeCode = typeCode;
        this.strategyClass = strategyClass;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public String getStrategyClass() {
        return strategyClass;
    }

    public void setStrategyClass(String strategyClass) {
        this.strategyClass = strategyClass;
    }

    public static Enum getEnumByType(int typeCode){
        TravelTypeEnum[] typeEnums = TravelTypeEnum.values();
        for (int i = 0; i < typeEnums.length; i++) {
            if (typeCode == typeEnums[i].getTypeCode()){
                return typeEnums[i];
            }
        }
        return null;
    }

    public static String getTypeClassByType(int typeCode){
        TravelTypeEnum[] typeEnums = TravelTypeEnum.values();
        for (int i = 0; i < typeEnums.length; i++) {
            if (typeCode == typeEnums[i].typeCode){
                return typeEnums[i].strategyClass;
            }
        }
        return null;
    }
}
