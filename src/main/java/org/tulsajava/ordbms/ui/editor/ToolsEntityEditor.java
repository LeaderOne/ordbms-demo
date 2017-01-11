package org.tulsajava.ordbms.ui.editor;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.tulsajava.ordbms.entities.AbstractToolEntity;
import org.tulsajava.ordbms.entities.ToolsEntity;
import org.tulsajava.ordbms.repo.ToolRepository;
import org.tulsajava.ordbms.repo.ToolsRepo;


public abstract class ToolsEntityEditor<T extends AbstractToolEntity> extends VerticalLayout {
    private final ToolRepository<T> toolsRepo;

    private T currentToolEntity;

    protected TextField toolName = new TextField("Tool Name");
    protected TextField toolBrand = new TextField("Brand Name");

    private Button save = new Button("save", FontAwesome.SAVE);
    private Button cancel = new Button("Cancel");
    private Button delete = new Button("Delete", FontAwesome.TRASH_O);
    protected CssLayout actions = new CssLayout(save,cancel,delete);

    protected ToolsEntityEditor(ToolRepository<T> toolsRepo) {
        this.toolsRepo = toolsRepo;
    }

    protected void init(ToolRepository<T> toolsRepo, Component... components) {
        addComponents(components);

        //Configure and style components
        setSpacing(true);
        actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        // wire action buttons to save, delete, and reset
        save.addClickListener(e -> toolsRepo.save(currentToolEntity));
        delete.addClickListener(e -> toolsRepo.delete(currentToolEntity));
        cancel.addClickListener(e -> editTool(currentToolEntity));
        setVisible(false);
    }

    public interface ChangeHandler {
        void onChange();
    }

    public void editTool(T tool) {
        final boolean persisted = tool.getToolId() != null;
        if(persisted) {
            //Find fresh entity for editing
            currentToolEntity = toolsRepo.findOne(tool.getToolId());
        } else {
            currentToolEntity = tool;
        }
        cancel.setVisible(persisted);

        //Bind properties to similarly named fields
        //Could also use annotation or "manual binding" or programmatic
        //moving values from fields to entities before saving
        BeanFieldGroup.bindFieldsUnbuffered(currentToolEntity, this);

        setVisible(true);

        //A hack to ensure the whole form is visible
        save.focus();
        //Select all text in toolName field automatically
        toolName.selectAll();
    }

    public void setChangeHandler(ChangeHandler h) {
        //ChangeHandler is notified when either save or delete is clicked
        save.addClickListener(e -> h.onChange());
        delete.addClickListener(e -> h.onChange());
    }
}
