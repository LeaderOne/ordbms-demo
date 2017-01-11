package org.tulsajava.ordbms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tulsajava.ordbms.entities.SawEntity;

/**
 * Created by markelba on 1/11/17.
 */
public interface SawRepo extends ToolRepository<SawEntity>, JpaRepository<SawEntity,Long> {
}
