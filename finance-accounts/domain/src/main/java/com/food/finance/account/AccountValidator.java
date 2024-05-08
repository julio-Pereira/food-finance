package com.food.finance.account;

import com.food.finance.validation.Error;
import com.food.finance.validation.ValidationHandler;
import com.food.finance.validation.Validator;

public class AccountValidator extends Validator {

    private final Account account;
    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 255;
    public static final String NAME_NOT_NULL_ERROR = "'name' should not be null";
    public static final String NAME_NOT_EMPTY_ERROR = "'name' should not be empty";
    public static final String NAME_LENGTH_ERROR = "'name' must be between 3 and 255 characters";

    public AccountValidator(final Account anAccount, final ValidationHandler aHandler) {
        super(aHandler);
        this.account = anAccount;
    }

    @Override
    public void validate() {
        checkNameConstraints();
    }

    private void checkNameConstraints() {
        final var name = this.account.getAccountName();
        if (name == null) {
            this.validationHandler().append(new Error(NAME_NOT_NULL_ERROR));
        }

        if (name.isBlank()) {
            this.validationHandler().append(new Error(NAME_NOT_EMPTY_ERROR));
        }

        final int length = name.trim().length();
        if (length > NAME_MAX_LENGTH || length < NAME_MIN_LENGTH) {
            this.validationHandler().append(new Error(NAME_LENGTH_ERROR));
        }
    }
}
