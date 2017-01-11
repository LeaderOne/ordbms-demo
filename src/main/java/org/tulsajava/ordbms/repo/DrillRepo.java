package org.tulsajava.ordbms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tulsajava.ordbms.entities.DrillEntity;
import org.tulsajava.ordbms.entities.ToolsEntity;

public interface DrillRepo extends JpaRepository<DrillEntity,Long>, ToolRepository<DrillEntity> {
}
