package org.tulsajava.ordbms.ui.editor;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.tulsajava.ordbms.entities.CircularSawEntity;
import org.tulsajava.ordbms.entities.SawEntity;
import org.tulsajava.ordbms.repo.SawRepo;
import org.tulsajava.ordbms.ui.Tool;

@SpringComponent
@UIScope
@Tool(CircularSawEntity.class)
public class CircularSawEditor extends ToolsEntityEditor<SawEntity> {
    protected TextField kerf = new TextField("Kerf");
    protected TextField abrasive = new TextField("Abrasive");
    protected TextField bladeDiameter = new TextField("Blade Diameter");

    @Autowired
    protected CircularSawEditor(SawRepo toolsRepo) {
        super(toolsRepo);

        init(toolsRepo, toolName, toolBrand, kerf, abrasive, bladeDiameter, actions);
    }
}
