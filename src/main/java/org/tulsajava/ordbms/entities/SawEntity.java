package org.tulsajava.ordbms.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by markelba on 1/10/17.
 */
@Entity
@Table(name = "saw", schema = "public", catalog = "tool_share")
public class SawEntity extends AbstractToolEntity {
    private BigDecimal kerf;
    private Boolean abrasive;

    @Basic
    @Column(name = "kerf", nullable = true, precision = 2)
    public BigDecimal getKerf() {
        return kerf;
    }

    public void setKerf(BigDecimal kerf) {
        this.kerf = kerf;
    }

    @Basic
    @Column(name = "abrasive", nullable = true)
    public Boolean getAbrasive() {
        return abrasive;
    }

    public void setAbrasive(Boolean abrasive) {
        this.abrasive = abrasive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SawEntity sawEntity = (SawEntity) o;

        if (!Objects.equals(toolId,sawEntity.toolId)) return false;
        if (toolName != null ? !toolName.equals(sawEntity.toolName) : sawEntity.toolName != null) return false;
        if (toolBrand != null ? !toolBrand.equals(sawEntity.toolBrand) : sawEntity.toolBrand != null) return false;
        if (kerf != null ? !kerf.equals(sawEntity.kerf) : sawEntity.kerf != null) return false;
        if (abrasive != null ? !abrasive.equals(sawEntity.abrasive) : sawEntity.abrasive != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (toolId == null ? 0 : (toolId ^ (toolId >>> 32)));
        result = 31 * result + (toolName != null ? toolName.hashCode() : 0);
        result = 31 * result + (toolBrand != null ? toolBrand.hashCode() : 0);
        result = 31 * result + (kerf != null ? kerf.hashCode() : 0);
        result = 31 * result + (abrasive != null ? abrasive.hashCode() : 0);
        return result;
    }
}
