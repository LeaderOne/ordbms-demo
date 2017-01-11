package org.tulsajava.ordbms.repo;

import org.tulsajava.ordbms.entities.ToolsEntity;

import java.util.List;

/**
 * Created by markelba on 1/10/17.
 */
public interface ToolRepository<T> {
    List<T> findByToolNameStartsWithIgnoringCase(String name);
    T findOne(Long id);
    T save(T entity);
    List<T> findAll();
    void delete(T entity);
}
