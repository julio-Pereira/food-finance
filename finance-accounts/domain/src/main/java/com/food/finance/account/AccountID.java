package com.food.finance.account;

import com.food.finance.Identifier;

import java.util.Objects;
import java.util.UUID;

public class AccountID extends Identifier {

    protected final String value;

    private AccountID(final String value) {
        Objects.requireNonNull(value, "Id cannot be null");
        this.value = value;
    }

    public static AccountID unique() {
        return AccountID.from(UUID.randomUUID());
    }

    public static AccountID from(final UUID anId) {
        return new AccountID(anId.toString().toLowerCase());
    }

    public static AccountID from(final String anId) {
        return new AccountID(anId);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountID accountID = (AccountID) o;
        return Objects.equals(getValue(), accountID.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getValue());
    }
}
