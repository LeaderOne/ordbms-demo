package org.tulsajava.ordbms.ui.view;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.tulsajava.ordbms.entities.DrillEntity;
import org.tulsajava.ordbms.repo.DrillRepo;
import org.tulsajava.ordbms.repo.ToolRepository;
import org.tulsajava.ordbms.ui.Tool;
import org.tulsajava.ordbms.ui.editor.DrillEditor;
import org.tulsajava.ordbms.ui.editor.ToolsEntityEditor;

@SpringComponent
@UIScope
@Tool(DrillEntity.class)
public class DrillUI extends VaadinUI<DrillEntity> {
    @Autowired
    public DrillUI(DrillRepo repo, DrillEditor toolsEntityEditor) {
        super(repo, toolsEntityEditor);
    }

    @Override
    public DrillEntity getToolEntity() {
        return new DrillEntity();
    }

    @Override
    public String[] getColumns() {
        return new String[]{"toolId", "toolName", "capacity", "toolBrand"};
    }

    @Override
    protected Class<?> getConcreteClass() {
        return DrillEntity.class;
    }
}
