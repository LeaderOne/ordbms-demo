package org.tulsajava.ordbms.ui.view;

import com.vaadin.annotations.Theme;
import com.vaadin.spring.annotation.SpringUI;
import org.tulsajava.ordbms.entities.ToolsEntity;
import org.tulsajava.ordbms.repo.ToolRepository;
import org.tulsajava.ordbms.ui.VaadinUI;
import org.tulsajava.ordbms.ui.editor.ToolsEntityEditor;

@SpringUI
@Theme("valo")
public class BasicToolsUI extends VaadinUI<ToolsEntity> {

    public BasicToolsUI(ToolRepository repo, ToolsEntityEditor toolsEntityEditor) {
        super(repo, toolsEntityEditor);
    }
}
