/**
 * Copyright (c) 2016 European Organisation for Nuclear Research (CERN), All Rights Reserved.
 */

package org.tensorics.expression;

import java.util.Arrays;
import java.util.List;

import org.tensorics.core.tree.domain.AbstractDeferredExpression;
import org.tensorics.core.tree.domain.Expression;
import org.tensorics.expression.resolvers.WindowedExpressionResolver;

/**
 * {@link Expression} that represents a {@link AnalysisModule}. It contains all the conditions for the analysis as well
 * as the enabling expression. The analysis conditions are grouped in a {@link AssertionGroupExpression}. The enabling
 * condition is an {@link Expression} of {@link Boolean} that decides if the {@link AssertionGroupExpression} is
 * resolved or not. This expression resolves into an {@link EvaluationStatus}.
 * 
 * @see WindowedExpressionResolver
 * @author acalia, caguiler
 */
public class WindowedExpression<T extends Expression<?>> extends AbstractDeferredExpression<EvaluationStatus> {

    private final T targetExpression;
    private final Expression<Boolean> enablingExpression;

    public WindowedExpression(T targetExpression, Expression<Boolean> enablingExpression) {
        this.targetExpression = targetExpression;
        this.enablingExpression = enablingExpression;
    }

    @Override
    public List<Expression<?>> getChildren() {
        return Arrays.asList(targetExpression, enablingExpression);
    }

    public T targetExpression() {
        return targetExpression;
    }

    public Expression<Boolean> enablingExpression() {
        return enablingExpression;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((enablingExpression == null) ? 0 : enablingExpression.hashCode());
        result = prime * result + ((targetExpression == null) ? 0 : targetExpression.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        WindowedExpression<?> other = (WindowedExpression<?>) obj;
        if (enablingExpression == null) {
            if (other.enablingExpression != null) {
                return false;
            }
        } else if (!enablingExpression.equals(other.enablingExpression)) {
            return false;
        }
        if (targetExpression == null) {
            if (other.targetExpression != null) {
                return false;
            }
        } else if (!targetExpression.equals(other.targetExpression)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [targetExpression=" + targetExpression + ", enablingExpression="
                + enablingExpression + "]";
    }
}
