package com.bitbakery.clojet.psi;

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.bitbakery.clojet.CloJetIcons;

import javax.swing.*;

/**
 * PSI elemenet representing a named function definition ("defn") in Clojure.
 */
public class Def extends VariableAssignment {
    public Def(@NotNull final ASTNode node) {
        super(node);
    }

    public Icon getIcon(int flags) {
        return CloJetIcons.CLOJURE_DEFN_ICON;
    }

/*
    public String getDocstring() {
        ASTNode[] children = getNode().getChildren(TokenSet.create(ArcElementTypes.DOCSTRING));
        if (children != null && children.length > 0) {
            return stripQuotes(children[0].getText());
        }
        return null;
    }
*/
}