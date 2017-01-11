package org.tulsajava.ordbms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tulsajava.ordbms.entities.PowerDrillEntity;

/**
 * Created by markelba on 1/11/17.
 */
public interface PowerDrillRepo extends ToolRepository<PowerDrillEntity>, JpaRepository<PowerDrillEntity,Long> {
}
