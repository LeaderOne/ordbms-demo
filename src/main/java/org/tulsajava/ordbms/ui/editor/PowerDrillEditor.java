package org.tulsajava.ordbms.ui.editor;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.TextField;
import org.tulsajava.ordbms.entities.DrillEntity;
import org.tulsajava.ordbms.entities.PowerDrillEntity;
import org.tulsajava.ordbms.repo.DrillRepo;
import org.tulsajava.ordbms.repo.PowerDrillRepo;
import org.tulsajava.ordbms.ui.Tool;

@SpringComponent
@UIScope
@Tool(PowerDrillEntity.class)
public class PowerDrillEditor extends ToolsEntityEditor<PowerDrillEntity> {
    protected TextField capacity = new TextField("Capacity");
    protected TextField rentalPrice = new TextField("Rental Price");
    protected TextField bitSizeMin = new TextField("Min Bit Size");
    protected TextField bitSizeMax = new TextField("Max Bit Size");

    protected PowerDrillEditor(PowerDrillRepo toolsRepo) {
        super(toolsRepo);

        init(toolsRepo, toolName, toolBrand, capacity, rentalPrice, bitSizeMin, bitSizeMax, actions);
    }
}
