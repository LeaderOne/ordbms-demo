package org.tulsajava.ordbms.ui.view;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.tulsajava.ordbms.entities.CircularSawEntity;
import org.tulsajava.ordbms.entities.SawEntity;
import org.tulsajava.ordbms.repo.CircularSawRepo;
import org.tulsajava.ordbms.repo.SawRepo;
import org.tulsajava.ordbms.ui.Tool;
import org.tulsajava.ordbms.ui.editor.SawEditor;

@SpringComponent
@UIScope
@Tool(CircularSawEntity.class)
public class CircularSawUI extends VaadinUI<CircularSawEntity> {
    @Autowired
    public CircularSawUI(CircularSawRepo repo, SawEditor toolsEntityEditor) {
        super(repo, toolsEntityEditor);
    }

    @Override
    public CircularSawEntity getToolEntity() {
        return new CircularSawEntity();
    }

    public String[] getColumns() {
        return new String[]{"toolId", "toolName", "toolBrand", "kerf", "abrasive", "rentalPrice", "bladeDiameter"};
    }

    @Override
    protected Class<?> getConcreteClass() {
        return CircularSawEntity.class;
    }
}
