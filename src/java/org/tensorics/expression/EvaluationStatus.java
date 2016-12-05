/**
 * Copyright (c) 2016 European Organisation for Nuclear Research (CERN), All Rights Reserved.
 */

package org.tensorics.expression;

public enum EvaluationStatus {
    EVALUATED,
    NOT_EVALUATED;

    public static EvaluationStatus fromBoolean(boolean isExecuted) {
        return isExecuted ? EVALUATED : NOT_EVALUATED;
    }
}
