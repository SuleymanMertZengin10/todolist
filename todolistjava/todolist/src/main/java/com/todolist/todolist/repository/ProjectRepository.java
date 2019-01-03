package com.todolist.todolist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todolist.todolist.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	
      Project findByProjectIdentifer(String projectId);
      

}
