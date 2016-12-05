/**
 * Copyright (c) 2016 European Organisation for Nuclear Research (CERN), All Rights Reserved.
 */

package org.tensorics.expression.resolvers;

import java.util.stream.Collectors;

import org.tensorics.core.resolve.resolvers.AbstractResolver;
import org.tensorics.core.resolve.resolvers.Resolvers;
import org.tensorics.core.tree.domain.ResolvingContext;
import org.tensorics.expression.IterableResolvingExpression;

/**
 * Resolver for a {@link IterableResolvingExpression}.
 * 
 * @see IterableResolvingExpression
 * @author acalia, caguiler, kfuchsberger
 * @param <T>
 */
public class IterableResolvingExpressionResolver<T>
        extends AbstractResolver<Iterable<T>, IterableResolvingExpression<T>> {

    @Override
    public boolean canResolve(IterableResolvingExpression<T> expression, ResolvingContext context) {
        return Resolvers.contextResolvesAll(expression.expressions(), context);
    }

    @Override
    public Iterable<T> resolve(IterableResolvingExpression<T> expression, ResolvingContext context) {
        return expression.expressions().stream().map(context::resolvedValueOf).collect(Collectors.toList());
    }

}
