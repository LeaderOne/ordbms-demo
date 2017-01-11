package org.tulsajava.ordbms.ui.view;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.tulsajava.ordbms.entities.DrillEntity;
import org.tulsajava.ordbms.entities.PowerDrillEntity;
import org.tulsajava.ordbms.repo.DrillRepo;
import org.tulsajava.ordbms.repo.PowerDrillRepo;
import org.tulsajava.ordbms.ui.Tool;
import org.tulsajava.ordbms.ui.editor.DrillEditor;
import org.tulsajava.ordbms.ui.editor.PowerDrillEditor;

@SpringComponent
@UIScope
@Tool(PowerDrillEntity.class)
public class PowerDrillUI extends VaadinUI<PowerDrillEntity> {
    @Autowired
    public PowerDrillUI(PowerDrillRepo repo, PowerDrillEditor toolsEntityEditor) {
        super(repo, toolsEntityEditor);
    }

    @Override
    public PowerDrillEntity getToolEntity() {
        return new PowerDrillEntity();
    }

    @Override
    public String[] getColumns() {
        return new String[]{"toolId", "toolName", "capacity", "rentalPrice", "bitSizeMin", "bitSizeMax", "toolBrand"};
    }

    @Override
    protected Class<?> getConcreteClass() {
        return PowerDrillEntity.class;
    }
}
