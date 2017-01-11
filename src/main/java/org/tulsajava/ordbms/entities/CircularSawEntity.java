package org.tulsajava.ordbms.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by markelba on 1/10/17.
 */
@Entity
@Table(name = "circular_saw", schema = "public", catalog = "tool_share")
public class CircularSawEntity extends AbstractToolEntity {
    private BigDecimal kerf;
    private Boolean abrasive;
    private BigDecimal rentalPrice;
    private BigDecimal bladeDiameter;

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

    @Basic
    @Column(name = "rental_price", nullable = true, precision = 2)
    public BigDecimal getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(BigDecimal rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    @Basic
    @Column(name = "blade_diameter", nullable = true, precision = 4)
    public BigDecimal getBladeDiameter() {
        return bladeDiameter;
    }

    public void setBladeDiameter(BigDecimal bladeDiameter) {
        this.bladeDiameter = bladeDiameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CircularSawEntity that = (CircularSawEntity) o;

        if (!Objects.equals(toolId, that.toolId)) return false;
        if (toolName != null ? !toolName.equals(that.toolName) : that.toolName != null) return false;
        if (toolBrand != null ? !toolBrand.equals(that.toolBrand) : that.toolBrand != null) return false;
        if (kerf != null ? !kerf.equals(that.kerf) : that.kerf != null) return false;
        if (abrasive != null ? !abrasive.equals(that.abrasive) : that.abrasive != null) return false;
        if (rentalPrice != null ? !rentalPrice.equals(that.rentalPrice) : that.rentalPrice != null) return false;
        if (bladeDiameter != null ? !bladeDiameter.equals(that.bladeDiameter) : that.bladeDiameter != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (toolId == null ? 0 : (toolId ^ (toolId >>> 32)));
        result = 31 * result + (toolName != null ? toolName.hashCode() : 0);
        result = 31 * result + (toolBrand != null ? toolBrand.hashCode() : 0);
        result = 31 * result + (kerf != null ? kerf.hashCode() : 0);
        result = 31 * result + (abrasive != null ? abrasive.hashCode() : 0);
        result = 31 * result + (rentalPrice != null ? rentalPrice.hashCode() : 0);
        result = 31 * result + (bladeDiameter != null ? bladeDiameter.hashCode() : 0);
        return result;
    }
}
