package org.tulsajava.ordbms.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by markelba on 1/10/17.
 */
@Entity
@Table(name = "power_drill", schema = "public", catalog = "tool_share")
public class PowerDrillEntity extends AbstractToolEntity {
    private Long toolId;
    private String toolName;
    private String toolBrand;
    private BigDecimal capacity;
    private BigDecimal rentalPrice;
    private BigDecimal bitSizeMin;
    private BigDecimal bitSizeMax;

    @Id
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

    @Basic
    @Column(name = "rental_price", nullable = true, precision = 2)
    public BigDecimal getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(BigDecimal rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    @Basic
    @Column(name = "capacity", nullable = true, precision = 4)
    public BigDecimal getCapacity() {
        return capacity;
    }

    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
    }


    @Basic
    @Column(name = "bit_size_min", nullable = true, precision = 4)
    public BigDecimal getBitSizeMin() {
        return bitSizeMin;
    }

    public void setBitSizeMin(BigDecimal bitSizeMin) {
        this.bitSizeMin = bitSizeMin;
    }

    @Basic
    @Column(name = "bit_size_max", nullable = true, precision = 4)
    public BigDecimal getBitSizeMax() {
        return bitSizeMax;
    }

    public void setBitSizeMax(BigDecimal bitSizeMax) {
        this.bitSizeMax = bitSizeMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PowerDrillEntity that = (PowerDrillEntity) o;

        if (!Objects.equals(toolId, that.toolId)) return false;
        if (toolName != null ? !toolName.equals(that.toolName) : that.toolName != null) return false;
        if (toolBrand != null ? !toolBrand.equals(that.toolBrand) : that.toolBrand != null) return false;
        if (rentalPrice != null ? !rentalPrice.equals(that.rentalPrice) : that.rentalPrice != null) return false;
        if (bitSizeMin != null ? !bitSizeMin.equals(that.bitSizeMin) : that.bitSizeMin != null) return false;
        if (bitSizeMax != null ? !bitSizeMax.equals(that.bitSizeMax) : that.bitSizeMax != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (toolId == null ? 0 : (toolId ^ (toolId >>> 32)));
        result = 31 * result + (toolName != null ? toolName.hashCode() : 0);
        result = 31 * result + (toolBrand != null ? toolBrand.hashCode() : 0);
        result = 31 * result + (rentalPrice != null ? rentalPrice.hashCode() : 0);
        result = 31 * result + (bitSizeMin != null ? bitSizeMin.hashCode() : 0);
        result = 31 * result + (bitSizeMax != null ? bitSizeMax.hashCode() : 0);
        return result;
    }
}
