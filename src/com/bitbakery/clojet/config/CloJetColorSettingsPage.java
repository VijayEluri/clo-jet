package com.bitbakery.clojet.config;

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

import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.bitbakery.clojet.ClojureSyntaxHighlighter;
import com.bitbakery.clojet.CloJetIcons;
import static com.bitbakery.clojet.ClojureSyntaxHighlighter.keys;
import static com.bitbakery.clojet.CloJetStrings.*;
import static com.bitbakery.clojet.lexer.ClojureTokenTypes.*;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.NonNls;

import javax.swing.*;
import java.util.Map;

/**
 *
 */
public class CloJetColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] ATTRS = new AttributesDescriptor[]{
            new AttributesDescriptor(message("color.settings.keyword"), keys.get(KEYWORD)),
            new AttributesDescriptor(message("color.settings.comment"), keys.get(LINE_COMMENT)),
            new AttributesDescriptor(message("color.settings.number"), keys.get(NUMERIC_LITERAL)),
            new AttributesDescriptor(message("color.settings.string"), keys.get(STRING_LITERAL)),
            new AttributesDescriptor(message("color.settings.bad_character"), keys.get(BAD_CHARACTER)),

            new AttributesDescriptor(message("color.settings.fn"), keys.get(FN)),
            new AttributesDescriptor(message("color.settings.def"), keys.get(DEF)),
            new AttributesDescriptor(message("color.settings.defn"), keys.get(DEFN)),
            new AttributesDescriptor(message("color.settings.defmacro"), keys.get(DEFMACRO)),
            new AttributesDescriptor(message("color.settings.defmulti"), keys.get(DEFMULTI)),
            new AttributesDescriptor(message("color.settings.defmethod"), keys.get(DEFMETHOD)),
            new AttributesDescriptor(message("color.settings.defstruct"), keys.get(DEFSTRUCT)),

            new AttributesDescriptor(message("color.settings.backquote"), keys.get(BACKQUOTE)),
            new AttributesDescriptor(message("color.settings.comma"), keys.get(COMMA)),
            new AttributesDescriptor(message("color.settings.comma_at"), keys.get(UNQUOTE_SPLICE)),
    };


    private static final ColorDescriptor[] COLORS = new ColorDescriptor[0];

    @Nullable
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    public String getDisplayName() {
        return message("color.settings.name");
    }

    @Nullable
    public Icon getIcon() {
        return CloJetIcons.CLOJURE_FILE_ICON;
    }

    @NotNull
    public AttributesDescriptor[] getAttributeDescriptors() {
        return ATTRS;
    }

    @NotNull
    public ColorDescriptor[] getColorDescriptors() {
        return COLORS;
    }

    @NotNull
    public SyntaxHighlighter getHighlighter() {
        return new ClojureSyntaxHighlighter();
    }

    @NonNls
    @NotNull
    public String getDemoText() {
        return ";  Sample comment\n\n" +

                "(def v \"Some global variable\")\n\n" +

                "(def one-var-function [+ 1 %])\n\n" +

                "(defn function-name (param . rest)\n" +
                "   \"Documentation string\"\n" +
                "   (function-body param rest))\n\n\n" +

                "(defn another-function rest\n" +
                "   (function-body rest))\n\n\n" +

                "(defmacro macro-name (param rest)\n" +
                "   `(,param ,@rest))\n";
    }
}
