package com.food.finance.account;

import com.food.finance.validation.Error;
import com.food.finance.validation.ValidationHandler;
import com.food.finance.validation.Validator;

public class AccountValidator extends Validator {

    private final Account account;
    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 255;

    public AccountValidator(final Account anAccount, final ValidationHandler aHandler) {
        super(aHandler);
        this.account = anAccount;
    }



//    @Override
//    public void validate() {
//        checkNameConstraints();
//    }

    private void checkNameConstraints() {
        final var name = this.account.getAccountName();
        if (name == null) {
            this.validationHandler().append(new Error("'name' should not be null"));
        }

        if (name.isBlank()) {
            this.validationHandler().append(new Error("'name' should not be empty"));
        }

        final int length = name.trim().length();
        if (length > NAME_MAX_LENGTH || length < NAME_MIN_LENGTH) {
            this.validationHandler().append(new Error("'name' must be between 3 and 255 characters"));
        }
    }

    @Override
    public void validate() {
        checkNameConstraints();
    }
}
