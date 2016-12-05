/**
 * Copyright (c) 2016 European Organisation for Nuclear Research (CERN), All Rights Reserved.
 */

package org.tensorics.expression.exception;

public class ExpressionEvaluationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExpressionEvaluationException() {
        super();
    }

    public ExpressionEvaluationException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ExpressionEvaluationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExpressionEvaluationException(String message) {
        super(message);
    }

    public ExpressionEvaluationException(Throwable cause) {
        super(cause);
    }

}
