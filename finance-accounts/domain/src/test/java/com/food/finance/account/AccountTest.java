package com.food.finance.account;

import com.food.finance.exceptions.DomainException;
import com.food.finance.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.food.finance.account.AccountValidator.NAME_LENGTH_ERROR;
import static com.food.finance.account.AccountValidator.NAME_NOT_EMPTY_ERROR;

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
        final var expectedAccountType = AccountType.FINANCE_ANALYST;
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
        final var expectedAccountType = AccountType.HR_ANALYST;
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

    @Test
    public void givenInvalidParams_whenCallNewAccountAndValidate_thenShouldReturnError() {
        final var expectedAccountType = AccountType.MASTER;
        final var expectedErrorCount = 1;
        final var expectedAccountName = "Ma";
        final var expectedIsActive = true;
        final var actualAccount = Account.newAccount(expectedAccountType, expectedAccountName, expectedIsActive);

        final var actualException = Assertions.assertThrows(DomainException.class, () -> actualAccount.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(NAME_LENGTH_ERROR, actualException.getErrors().get(0).message());
    }

    @Test
    public void givenAnInvalidNameLengthMoreThan255_whenCallNewAccountAndValidate_thenShouldReturnError() {
        final var expectedAccountType = AccountType.MASTER;
        final var expectedErrorCount = 1;
        final var expectedAccountName = """
                This is a very long name that should not be accepted by the system.
                The max length has to be 255 characters.
                Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                Nullam nec nunc nec nulla ultricies ultricies. that's should not be accepted by the system.
                """;
        final var expectedIsActive = true;

        final var actualAccount = Account.newAccount(expectedAccountType, expectedAccountName, expectedIsActive);

        final var actualException =
                Assertions.assertThrows(DomainException.class, () -> actualAccount.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(NAME_LENGTH_ERROR, actualException.getErrors().get(0).message());
    }

    @Test
    public void givenAEmptyName_whenCallNewAccountAndValidate_thenShouldReturnError() {
        final var expectedAccountType = AccountType.MASTER;
        final var expectedErrorCount = 1;
        final var expectedAccountName = "";
        final var expectedIsActive = true;

        final var actualAccount = Account.newAccount(expectedAccountType, expectedAccountName, expectedIsActive);

        final var actualException =
                Assertions.assertThrows(DomainException.class, () -> actualAccount.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(NAME_NOT_EMPTY_ERROR, actualException.getErrors().get(0).message());
    }

    @Test
    public void givenAValidAccount_whenCallDeactivate_shouldDeactivateAccount() {
        final var expectedAccountType = AccountType.MASTER;
        final var expectedAccountName = "Master Account Name";
        final var expectedIsActive = false;

        final var anAccount = Account.newAccount(expectedAccountType, expectedAccountName, true);

        Assertions.assertDoesNotThrow(() -> anAccount.validate(new ThrowsValidationHandler()));

        final var createdAt = anAccount.getCreatedAt();
        final var updatedAt = anAccount.getUpdatedAt();

        Assertions.assertTrue(anAccount.isActive());
        Assertions.assertNull(anAccount.getDeletedAt());

        final var actualAccount = anAccount.deactivate();

        Assertions.assertDoesNotThrow(() -> actualAccount.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(anAccount.getId(), actualAccount.getId());
        Assertions.assertEquals(anAccount.getAccountType(), actualAccount.getAccountType());
        Assertions.assertEquals(anAccount.getAccountName(), actualAccount.getAccountName());
        Assertions.assertEquals(expectedIsActive, actualAccount.isActive());
        Assertions.assertNotNull(createdAt);
        Assertions.assertTrue(actualAccount.getUpdatedAt().isAfter(updatedAt));
        Assertions.assertNotNull(actualAccount.getDeletedAt());
    }

    @Test
    public void givenAValidInactivatedAccount_whenCallActivate_shouldReActivateAccount() {
        final var expectedAccountType = AccountType.MASTER;
        final var expectedAccountName = "Master Account Name";
        final var expectedIsActive = true;

        final var anAccount = Account.newAccount(expectedAccountType, expectedAccountName, false);

        Assertions.assertDoesNotThrow(() -> anAccount.validate(new ThrowsValidationHandler()));

        final var createdAt = anAccount.getCreatedAt();
        final var updatedAt = anAccount.getUpdatedAt();

        Assertions.assertFalse(anAccount.isActive());
        Assertions.assertNotNull(anAccount.getDeletedAt());

        final var actualAccount = anAccount.activate();

        Assertions.assertDoesNotThrow(() -> actualAccount.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(anAccount.getId(), actualAccount.getId());
        Assertions.assertEquals(anAccount.getAccountType(), actualAccount.getAccountType());
        Assertions.assertEquals(anAccount.getAccountName(), actualAccount.getAccountName());
        Assertions.assertEquals(expectedIsActive, actualAccount.isActive());
        Assertions.assertNotNull(createdAt);
        Assertions.assertTrue(actualAccount.getUpdatedAt().isAfter(updatedAt));
        Assertions.assertNull(actualAccount.getDeletedAt());
    }

    @Test
    public void givenAValidAccount_whenCallUpdate_shouldUpdateAccount() {
        final var expectedAccountType = AccountType.MASTER;
        final var expectedAccountName = "Master Account Name";
        final var expectedIsActive = true;

        final var anAccount = Account.newAccount(expectedAccountType, expectedAccountName, expectedIsActive);

        Assertions.assertDoesNotThrow(() -> anAccount.validate(new ThrowsValidationHandler()));

        final var createdAt = anAccount.getCreatedAt();
        final var updatedAt = anAccount.getUpdatedAt();

        final var newAccountName = "New Master Account Name";


        final var actualAccount = anAccount.update(newAccountName, true);

        Assertions.assertDoesNotThrow(() -> actualAccount.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(anAccount.getId(), actualAccount.getId());
        Assertions.assertEquals(anAccount.getAccountType(), actualAccount.getAccountType());
        Assertions.assertEquals(newAccountName, actualAccount.getAccountName());
        Assertions.assertEquals(expectedIsActive, actualAccount.isActive());
        Assertions.assertNotNull(createdAt);
        Assertions.assertTrue(actualAccount.getUpdatedAt().isAfter(updatedAt));
        Assertions.assertNull(actualAccount.getDeletedAt());
    }
}
