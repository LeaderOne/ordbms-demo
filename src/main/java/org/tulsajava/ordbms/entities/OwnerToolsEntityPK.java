package org.tulsajava.ordbms.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by markelba on 1/10/17.
 */
public class OwnerToolsEntityPK implements Serializable {
    private String ownerId;
    private Long toolId;

    @Column(name = "owner_id", nullable = false, length = -1)
    @Id
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Column(name = "tool_id", nullable = false)
    @Id
    public Long getToolId() {
        return toolId;
    }

    public void setToolId(Long toolId) {
        this.toolId = toolId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OwnerToolsEntityPK that = (OwnerToolsEntityPK) o;

        if (!Objects.equals(toolId, that.toolId)) return false;
        if (ownerId != null ? !ownerId.equals(that.ownerId) : that.ownerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ownerId != null ? ownerId.hashCode() : 0;
        result = 31 * result + (int) (toolId == null ? 0 : (toolId ^ (toolId >>> 32)));
        return result;
    }
}
