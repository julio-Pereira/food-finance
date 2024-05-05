package com.food.finance.account;

import com.food.finance.AggregateRoot;
import com.food.finance.validation.ValidationHandler;

import java.time.Instant;

public class Account extends AggregateRoot<AccountID> {

    private final AccountType accountType;
    private final String accountName;
    private final boolean isActive;
    private final Instant createdAt;
    private final Instant updatedAt;
    private final Instant deletedAt;

    protected Account(
            final AccountID anAccountID,
            final AccountType anAccountType,
            final String anAccountName,
            final boolean isActive,
            final Instant aCreationDate,
            final Instant aUpdatedDate,
            final Instant aDeletedDate) {
        super(anAccountID);
        this.accountType = anAccountType;
        this.accountName = anAccountName;
        this.isActive = isActive;
        this.createdAt = aCreationDate;
        this.updatedAt = aUpdatedDate;
        this.deletedAt = aDeletedDate;
    }

    public static Account newAccount(
            final AccountType anAccountType,
            final String anAccountName,
            final boolean isActive) {
        final var id = AccountID.unique();
        final var now = Instant.now();
        final var deleteAt = isActive ? null : now;
        return new Account(
                id,
                anAccountType,
                anAccountName,
                isActive,
                now,
                now,
                deleteAt);
    }

    @Override
    public void validate(ValidationHandler handler) {
        new AccountValidator(this, handler).validate();
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public boolean isActive() {
        return isActive;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }
}