package org.tulsajava.ordbms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tulsajava.ordbms.entities.CircularSawEntity;
import org.tulsajava.ordbms.entities.SawEntity;

/**
 * Created by markelba on 1/11/17.
 */
public interface CircularSawRepo extends ToolRepository<CircularSawEntity>, JpaRepository<CircularSawEntity,Long> {
}
