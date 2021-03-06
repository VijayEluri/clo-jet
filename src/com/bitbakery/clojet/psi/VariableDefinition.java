package com.bitbakery.clojet.psi;

/*
 * Copyright (c) Kurt Christensen, 2009
 *
 * Licensed under the Artistic License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at:
 *
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.NonNls;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;

/**
 * Created by IntelliJ IDEA.
 * User: kurtc
 * Date: Feb 9, 2009
 * Time: 2:45:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class VariableDefinition extends ClojureElement implements PsiNamedElement {
    public VariableDefinition(@NotNull final ASTNode node) {
        super(node);
    }


    public String getName() {
        return getText();
    }
    
    public PsiElement setName(@NonNls String name) throws IncorrectOperationException {
        return null;  // TODO - Make me real!
    }
}