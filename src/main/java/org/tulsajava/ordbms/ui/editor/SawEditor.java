package org.tulsajava.ordbms.ui.editor;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.tulsajava.ordbms.entities.SawEntity;
import org.tulsajava.ordbms.entities.ToolsEntity;
import org.tulsajava.ordbms.repo.SawRepo;
import org.tulsajava.ordbms.repo.ToolsRepo;
import org.tulsajava.ordbms.ui.Tool;

@SpringComponent
@UIScope
@Tool(SawEntity.class)
public class SawEditor extends ToolsEntityEditor<SawEntity> {
    protected TextField kerf = new TextField("Kerf");
    protected TextField abrasive = new TextField("Abrasive");

    @Autowired
    protected SawEditor(SawRepo toolsRepo) {
        super(toolsRepo);

        init(toolsRepo, toolName, toolBrand, kerf, abrasive, actions);
    }
}
