package com.michael.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
 
@RepositoryRestResource
public interface MetaDataRepository extends CrudRepository<MetaData, String> {

}