package org.tulsajava.ordbms.entities;

import javax.persistence.*;

/**
 * Created by markelba on 1/10/17.
 */
@Entity
@Table(name = "tool_owner", schema = "public", catalog = "tool_share")
public class ToolOwnerEntity {
    private String ownerId;
    private String ownerFirstName;
    private String ownerLastName;

    @Id
    @Column(name = "owner_id", nullable = false, length = -1)
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Basic
    @Column(name = "owner_first_name", nullable = true, length = -1)
    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    @Basic
    @Column(name = "owner_last_name", nullable = true, length = -1)
    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToolOwnerEntity that = (ToolOwnerEntity) o;

        if (ownerId != null ? !ownerId.equals(that.ownerId) : that.ownerId != null) return false;
        if (ownerFirstName != null ? !ownerFirstName.equals(that.ownerFirstName) : that.ownerFirstName != null)
            return false;
        if (ownerLastName != null ? !ownerLastName.equals(that.ownerLastName) : that.ownerLastName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ownerId != null ? ownerId.hashCode() : 0;
        result = 31 * result + (ownerFirstName != null ? ownerFirstName.hashCode() : 0);
        result = 31 * result + (ownerLastName != null ? ownerLastName.hashCode() : 0);
        return result;
    }
}
