package com.food.finance;

public class AggregateRoot<ID extends Identifier> extends Entity<ID> {

    protected AggregateRoot(ID id) {
        super(id);
    }
}

