package com.sspace.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sspace.beans.Topic;
@Repository
public interface TopicRepository extends CrudRepository<Topic,String>{

}
