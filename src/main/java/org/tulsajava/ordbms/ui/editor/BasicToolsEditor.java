package org.tulsajava.ordbms.ui.editor;

import com.vaadin.event.ShortcutAction;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.tulsajava.ordbms.entities.ToolsEntity;
import org.tulsajava.ordbms.repo.ToolRepository;
import org.tulsajava.ordbms.repo.ToolsRepo;
import org.tulsajava.ordbms.ui.Tool;

@SpringComponent
@UIScope
@Tool(ToolsEntity.class)
public class BasicToolsEditor extends ToolsEntityEditor<ToolsEntity> {

    @Autowired
    protected BasicToolsEditor(ToolsRepo toolsRepo) {
        super(toolsRepo);

        init(toolsRepo, toolName, toolBrand, actions);
    }
}
