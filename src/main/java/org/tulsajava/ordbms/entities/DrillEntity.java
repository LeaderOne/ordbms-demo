package org.tulsajava.ordbms.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by markelba on 1/10/17.
 */
@Entity
@Table(name = "drill", schema = "public", catalog = "tool_share")
public class DrillEntity extends AbstractToolEntity {
    private BigDecimal capacity;

    @Basic
    @Column(name = "capacity", nullable = true, precision = 4)
    public BigDecimal getCapacity() {
        return capacity;
    }

    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DrillEntity that = (DrillEntity) o;

        if (!Objects.equals(toolId, that.toolId)) return false;
        if (toolName != null ? !toolName.equals(that.toolName) : that.toolName != null) return false;
        if (toolBrand != null ? !toolBrand.equals(that.toolBrand) : that.toolBrand != null) return false;
        if (capacity != null ? !capacity.equals(that.capacity) : that.capacity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (toolId == null ? 0 : (toolId ^ (toolId >>> 32)));
        result = 31 * result + (toolName != null ? toolName.hashCode() : 0);
        result = 31 * result + (toolBrand != null ? toolBrand.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        return result;
    }
}
