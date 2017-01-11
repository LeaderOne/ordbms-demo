package org.tulsajava.ordbms.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by markelba on 1/10/17.
 */
@Entity
@Table(name = "owner_tools", schema = "public", catalog = "tool_share")
@IdClass(OwnerToolsEntityPK.class)
public class OwnerToolsEntity {
    private String ownerId;
    private Long toolId;

    @Id
    @Column(name = "owner_id", nullable = false, length = -1)
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Id
    @Column(name = "tool_id", nullable = false)
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

        OwnerToolsEntity that = (OwnerToolsEntity) o;

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
