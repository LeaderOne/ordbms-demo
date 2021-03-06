package org.tulsajava.ordbms.ui.view;

import com.vaadin.annotations.Theme;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.tulsajava.ordbms.entities.AbstractToolEntity;
import org.tulsajava.ordbms.entities.ToolsEntity;
import org.tulsajava.ordbms.repo.ToolRepository;
import org.tulsajava.ordbms.repo.ToolsRepo;
import org.tulsajava.ordbms.ui.Tool;
import org.tulsajava.ordbms.ui.editor.BasicToolsEditor;
import org.tulsajava.ordbms.ui.editor.ToolsEntityEditor;

@SpringComponent
@UIScope
@Tool(ToolsEntity.class)
public class BasicToolsUI extends VaadinUI<ToolsEntity> {
    @Autowired
    public BasicToolsUI(ToolsRepo repo, BasicToolsEditor toolsEntityEditor) {
        super(repo, toolsEntityEditor);
    }

    @Override
    public ToolsEntity getToolEntity() {
        return new ToolsEntity();
    }

    public String[] getColumns() {
        return new String[]{"toolId", "toolName", "toolBrand"};
    }

    @Override
    protected Class<?> getConcreteClass() {
        return ToolsEntity.class;
    }
}
