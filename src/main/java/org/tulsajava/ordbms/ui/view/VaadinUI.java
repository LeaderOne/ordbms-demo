package org.tulsajava.ordbms.ui.view;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.tulsajava.ordbms.entities.AbstractToolEntity;
import org.tulsajava.ordbms.entities.ToolsEntity;
import org.tulsajava.ordbms.repo.ToolRepository;
import org.tulsajava.ordbms.repo.ToolsRepo;
import org.tulsajava.ordbms.ui.editor.ToolsEntityEditor;


public abstract class VaadinUI<T extends AbstractToolEntity> extends VerticalLayout {
    private final ToolRepository<T> toolsRepo;
    private final ToolsEntityEditor toolsEntityEditor;


    private final Grid grid;
    private final TextField filter;
    private final Button addNewBtn;

    public VaadinUI(ToolRepository<T> repo, ToolsEntityEditor toolsEntityEditor) {
        this.toolsRepo = repo;
        this.toolsEntityEditor = toolsEntityEditor;

        this.grid = new Grid();
        this.filter = new TextField();
        this.addNewBtn = new Button("New tool", FontAwesome.PLUS);
    }

    protected void init(VaadinRequest vaadinRequest) {
        //build layout
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        VerticalLayout mainLayout = new VerticalLayout(actions, grid, toolsEntityEditor);
        addComponent(mainLayout);

        //Configure layouts and components
        actions.setSpacing(true);
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);

        grid.setHeight(300, Unit.PIXELS);
        grid.setColumns(getColumns());

        filter.setInputPrompt("Filter by tool name");

        //Hook logic to components

        //Replace listing with filtered content when user changes filter
        filter.addTextChangeListener(e -> listTools(e.getText()));

        //Connect selected tool to editor or hide if none is selected
        grid.addSelectionListener(e -> {
            if (e.getSelected().isEmpty()) {
                toolsEntityEditor.setVisible(false);
            } else {
                toolsEntityEditor.editTool((AbstractToolEntity) grid.getSelectedRow());
            }
        });

        //Instantiate and edit new ToolsEntity the new button is clicked
        addNewBtn.addClickListener(e -> toolsEntityEditor.editTool(getToolEntity()));

        // Listen to changes made by the editor, refresh data from backend
        toolsEntityEditor.setChangeHandler(() -> {
            toolsEntityEditor.setVisible(false);
            listTools(filter.getValue());
        });

        listTools(null);
    }

    public abstract String[] getColumns();

    public void listTools(String toolName) {
        if (StringUtils.isEmpty(toolName)) {
            grid.setContainerDataSource(new BeanItemContainer(getConcreteClass(), toolsRepo.findAll()));
        } else {
            grid.setContainerDataSource(new BeanItemContainer(getConcreteClass(), toolsRepo.findByToolNameStartsWithIgnoringCase(toolName)));
        }
    }

    protected abstract Class<?> getConcreteClass();

    public abstract T getToolEntity();
}
