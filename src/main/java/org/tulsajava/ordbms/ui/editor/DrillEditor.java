package org.tulsajava.ordbms.ui.editor;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.TextField;
import org.tulsajava.ordbms.entities.DrillEntity;
import org.tulsajava.ordbms.entities.ToolsEntity;
import org.tulsajava.ordbms.repo.DrillRepo;
import org.tulsajava.ordbms.repo.ToolRepository;
import org.tulsajava.ordbms.ui.Tool;

@SpringComponent
@UIScope
@Tool(DrillEntity.class)
public class DrillEditor extends ToolsEntityEditor<DrillEntity> {
    protected TextField capacity = new TextField("Capacity");

    protected DrillEditor(DrillRepo toolsRepo) {
        super(toolsRepo);

        init(toolsRepo, toolName, toolBrand, capacity, actions);
    }
}
