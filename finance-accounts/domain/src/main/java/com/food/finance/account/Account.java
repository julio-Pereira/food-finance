package com.food.finance.account;

import com.food.finance.AggregateRoot;

import java.time.Instant;

public class Account extends AggregateRoot<AccountID> {

    private AccountType accountType;
    private String accountName;
    private boolean isActive;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

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