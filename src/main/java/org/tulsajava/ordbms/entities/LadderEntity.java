package org.tulsajava.ordbms.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by markelba on 1/10/17.
 */
@Entity
@Table(name = "ladder", schema = "public", catalog = "tool_share")
public class LadderEntity {
    private Long toolId;
    private String toolName;
    private String toolBrand;
    private BigDecimal ladderLength;

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
    @Column(name = "ladder_length", nullable = true, precision = 4)
    public BigDecimal getLadderLength() {
        return ladderLength;
    }

    public void setLadderLength(BigDecimal ladderLength) {
        this.ladderLength = ladderLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LadderEntity that = (LadderEntity) o;

        if (!Objects.equals(toolId, that.toolId)) return false;
        if (toolName != null ? !toolName.equals(that.toolName) : that.toolName != null) return false;
        if (toolBrand != null ? !toolBrand.equals(that.toolBrand) : that.toolBrand != null) return false;
        if (ladderLength != null ? !ladderLength.equals(that.ladderLength) : that.ladderLength != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (toolId == null ? 0 : (toolId ^ (toolId >>> 32)));
        result = 31 * result + (toolName != null ? toolName.hashCode() : 0);
        result = 31 * result + (toolBrand != null ? toolBrand.hashCode() : 0);
        result = 31 * result + (ladderLength != null ? ladderLength.hashCode() : 0);
        return result;
    }
}
