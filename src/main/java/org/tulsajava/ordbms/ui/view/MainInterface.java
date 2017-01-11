package org.tulsajava.ordbms.ui.view;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.tulsajava.ordbms.entities.*;
import org.tulsajava.ordbms.ui.Tool;
import org.tulsajava.ordbms.ui.view.BasicToolsUI;

import javax.annotation.Resource;

@SpringUI
@Theme("valo")
public class MainInterface extends UI {
    @Resource
    @Tool(ToolsEntity.class)
    private BasicToolsUI basicToolsUI;

    @Resource
    @Tool(DrillEntity.class)
    private DrillUI drillUI;

    @Resource
    @Tool(PowerDrillEntity.class)
    private PowerDrillUI powerDrillUI;

    @Resource
    @Tool(SawEntity.class)
    private SawUI sawUI;

    @Resource
    @Tool(CircularSawEntity.class)
    private CircularSawUI circularSawUI;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        basicToolsUI.init(vaadinRequest);
        drillUI.init(vaadinRequest);
        sawUI.init(vaadinRequest);
        circularSawUI.init(vaadinRequest);

        TabSheet tabSheet = new TabSheet();

        basicToolsUI.setCaption("Basic Tools");
        drillUI.setCaption("Drills");
        powerDrillUI.setCaption("Power Drills");
        sawUI.setCaption("Saws");
        circularSawUI.setCaption("Circular Saws");

        tabSheet.addTab(basicToolsUI);
        tabSheet.addTab(drillUI);
        tabSheet.addTab(powerDrillUI);
        tabSheet.addTab(sawUI);
        tabSheet.addTab(circularSawUI);

        tabSheet.addSelectedTabChangeListener((selectedTabChangeEvent) -> {
            switch (selectedTabChangeEvent.getTabSheet().getSelectedTab().getCaption()) {
                case "Basic Tools":
                    basicToolsUI.init(null);
                    break;
                case "Drills":
                    drillUI.init(null);
                    break;
                case "Power Drills":
                    powerDrillUI.init(null);
                    break;
                case "Saws":
                    sawUI.init(null);
                    break;
                case "Circular Saws":
                    circularSawUI.init(null);
                    break;
            }
        });

        VerticalLayout mainLayout = new VerticalLayout(tabSheet);

        mainLayout.addComponent(tabSheet);

        setContent(mainLayout);
    }
}
