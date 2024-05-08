package com.food.finance;

import com.food.finance.validation.ValidationHandler;

public abstract class AggregateRoot<ID extends Identifier> extends Entity<ID> {

    protected AggregateRoot(final ID id) {
        super(id);
    }

}

