package com.food.finance.account;

public enum AccountType {

    MASTER("MASTER"),
    FINANCE_ANALYST("FINANCE_ANALYST"),
    HR_ANALYST("HR_ANALYST"),
    GUEST("GUEST");

    private final String value;

    AccountType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }


    public static AccountType fromString(String value) {
        for (AccountType type : AccountType.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }


}
