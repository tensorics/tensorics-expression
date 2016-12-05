/**
 * Copyright (c) 2016 European Organisation for Nuclear Research (CERN), All Rights Reserved.
 */

package org.tensorics.expression;

import static java.lang.String.format;

import org.tensorics.core.expressions.BinaryPredicateExpression;
import org.tensorics.core.math.predicates.IsEqualTo;
import org.tensorics.core.tree.domain.Expression;

public class IsEqualToExpression<T> extends BinaryPredicateExpression<T> {

    public IsEqualToExpression(Expression<T> left, Expression<T> right) {
        super(new IsEqualTo<T>(), left, right);
    }

    @Override
    public String toString() {
        return format("%s is equal to %s", getLeft(), getRight());
    }
}
