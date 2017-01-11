package org.tulsajava.ordbms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tulsajava.ordbms.entities.ToolsEntity;

import java.util.List;

/**
 * Created by markelba on 1/10/17.
 */
public interface ToolsRepo extends JpaRepository<ToolsEntity,Long>, ToolRepository<ToolsEntity> {
}
