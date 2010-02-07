/*
 * Copyright 2009 Joachim Ansorg, mail@ansorg-it.com
 * File: PreIncrementExpressionsImpl.java, Class: PreIncrementExpressionsImpl
 * Last modified: 2010-02-07
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ansorgit.plugins.bash.lang.psi.impl.arithmetic;

import com.ansorgit.plugins.bash.lang.lexer.BashTokenTypes;
import com.ansorgit.plugins.bash.lang.psi.api.arithmetic.ProductExpression;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;

/**
 * User: jansorg
 * Date: Feb 6, 2010
 * Time: 12:13:49 PM
 */
public class PreIncrementExpressionsImpl extends AbstractExpression implements ProductExpression {
    public PreIncrementExpressionsImpl(final ASTNode astNode) {
        super(astNode, "ArithPreIncrement", Type.PrefixOperand);
    }

    @Override
    protected Long compute(long currentValue, IElementType operator, Long nextExpressionValue) {
        if (operator == BashTokenTypes.ARITH_MINUS_MINUS) {
            return currentValue - 1;
        } else if (operator == BashTokenTypes.ARITH_PLUS_PLUS) {
            return currentValue + 1;
        }

        return null;
    }
}