package com.bitbakery.clojet.actions;

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

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.util.text.StringUtil;

/**
 * Event handler for the "Run Selection" action within an Arc code editor - runs the currently selected text within the current REPL.
 */
public class RunSelectedTextAction extends ClojureAction {

    public void actionPerformed(final AnActionEvent e) {
        final Editor ed = e.getData(DataKeys.EDITOR);
        if (ed == null) {
            return;
        }
        String text = ed.getSelectionModel().getSelectedText();

        if (StringUtil.isEmptyOrSpaces(text)) {
            return;
        }
        getReplToolWindow(e).writeToCurrentRepl(text);
    }
}

