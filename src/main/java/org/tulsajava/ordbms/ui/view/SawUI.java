package org.tulsajava.ordbms.ui.view;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.tulsajava.ordbms.entities.SawEntity;
import org.tulsajava.ordbms.entities.ToolsEntity;
import org.tulsajava.ordbms.repo.SawRepo;
import org.tulsajava.ordbms.repo.ToolsRepo;
import org.tulsajava.ordbms.ui.Tool;
import org.tulsajava.ordbms.ui.editor.BasicToolsEditor;
import org.tulsajava.ordbms.ui.editor.SawEditor;

@SpringComponent
@UIScope
@Tool(SawEntity.class)
public class SawUI extends VaadinUI<SawEntity> {
    @Autowired
    public SawUI(SawRepo repo, SawEditor toolsEntityEditor) {
        super(repo, toolsEntityEditor);
    }

    @Override
    public SawEntity getToolEntity() {
        return new SawEntity();
    }

    public String[] getColumns() {
        return new String[]{"toolId", "toolName", "toolBrand", "kerf", "abrasive"};
    }

    @Override
    protected Class<?> getConcreteClass() {
        return SawEntity.class;
    }
}
