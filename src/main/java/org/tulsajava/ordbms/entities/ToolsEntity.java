package org.tulsajava.ordbms.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by markelba on 1/10/17.
 */
@Entity
@Table(name = "tools", schema = "public", catalog = "tool_share")
public class ToolsEntity {
    private Long toolId;
    private String toolName = "";
    private String toolBrand = "";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tool_id", nullable = false)
    public Long getToolId() {
        return toolId;
    }

    public void setToolId(Long toolId) {
        this.toolId = toolId;
    }

    @Basic
    @Column(name = "tool_name", nullable = true, length = -1)
    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    @Basic
    @Column(name = "tool_brand", nullable = true, length = -1)
    public String getToolBrand() {
        return toolBrand;
    }

    public void setToolBrand(String toolBrand) {
        this.toolBrand = toolBrand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToolsEntity that = (ToolsEntity) o;

        if (!Objects.equals(toolId, that.toolId)) return false;
        if (toolName != null ? !toolName.equals(that.toolName) : that.toolName != null) return false;
        if (toolBrand != null ? !toolBrand.equals(that.toolBrand) : that.toolBrand != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (toolId == null ? 0 : (toolId ^ (toolId >>> 32)));
        result = 31 * result + (toolName != null ? toolName.hashCode() : 0);
        result = 31 * result + (toolBrand != null ? toolBrand.hashCode() : 0);
        return result;
    }
}
