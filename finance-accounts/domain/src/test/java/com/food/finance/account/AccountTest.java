package com.food.finance.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {


    @Test
    public void givenValidParams_whenCallNewAccount_shouldInstantiateAMasterAccount() {
        final var expectedAccountType = AccountType.MASTER;
        final var expectedAccountName = "Master Account Name";
        final var expectedIsActive = true;
        final var expectedAccount = Account.newAccount(expectedAccountType, expectedAccountName, expectedIsActive);

        Assertions.assertNotNull(expectedAccount);
        Assertions.assertNotNull(expectedAccount.getId());
        Assertions.assertEquals(expectedAccountType, expectedAccount.getAccountType());
        Assertions.assertEquals(expectedAccountName, expectedAccount.getAccountName());
        Assertions.assertEquals(expectedIsActive, expectedAccount.isActive());
        Assertions.assertNotNull(expectedAccount.getCreatedAt());
        Assertions.assertNotNull(expectedAccount.getUpdatedAt());
        Assertions.assertNull(expectedAccount.getDeletedAt());
    }

    @Test
    public void givenValidParams_whenCallNewAccount_shouldInstantiateAnAnalystAccount() {
        final var expectedAccountType = AccountType.ANALYST;
        final var expectedAccountName = "Analyst Account Name";
        final var expectedIsActive = true;
        final var expectedAccount = Account.newAccount(expectedAccountType, expectedAccountName, expectedIsActive);

        Assertions.assertNotNull(expectedAccount);
        Assertions.assertNotNull(expectedAccount.getId());
        Assertions.assertEquals(expectedAccountType, expectedAccount.getAccountType());
        Assertions.assertEquals(expectedAccountName, expectedAccount.getAccountName());
        Assertions.assertEquals(expectedIsActive, expectedAccount.isActive());
        Assertions.assertNotNull(expectedAccount.getCreatedAt());
        Assertions.assertNotNull(expectedAccount.getUpdatedAt());
        Assertions.assertNull(expectedAccount.getDeletedAt());
    }

    @Test
    public void givenValidParams_whenCallNewAccount_shouldInstantiateAnHumanResourceAccount() {
        final var expectedAccountType = AccountType.HR;
        final var expectedAccountName = "Human Resource Account Name";
        final var expectedIsActive = true;
        final var expectedAccount = Account.newAccount(expectedAccountType, expectedAccountName, expectedIsActive);

        Assertions.assertNotNull(expectedAccount);
        Assertions.assertNotNull(expectedAccount.getId());
        Assertions.assertEquals(expectedAccountType, expectedAccount.getAccountType());
        Assertions.assertEquals(expectedAccountName, expectedAccount.getAccountName());
        Assertions.assertEquals(expectedIsActive, expectedAccount.isActive());
        Assertions.assertNotNull(expectedAccount.getCreatedAt());
        Assertions.assertNotNull(expectedAccount.getUpdatedAt());
        Assertions.assertNull(expectedAccount.getDeletedAt());
    }

    @Test
    public void givenValidParams_whenCallNewAccount_shouldInstantiateAGuestAccount() {
        final var expectedAccountType = AccountType.GUEST;
        final var expectedAccountName = "Guest Account Name";
        final var expectedIsActive = true;
        final var expectedAccount = Account.newAccount(expectedAccountType, expectedAccountName, expectedIsActive);

        Assertions.assertNotNull(expectedAccount);
        Assertions.assertNotNull(expectedAccount.getId());
        Assertions.assertEquals(expectedAccountType, expectedAccount.getAccountType());
        Assertions.assertEquals(expectedAccountName, expectedAccount.getAccountName());
        Assertions.assertEquals(expectedIsActive, expectedAccount.isActive());
        Assertions.assertNotNull(expectedAccount.getCreatedAt());
        Assertions.assertNotNull(expectedAccount.getUpdatedAt());
        Assertions.assertNull(expectedAccount.getDeletedAt());
    }
}
