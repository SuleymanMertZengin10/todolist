package com.todolist.todolist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.todolist.domain.Project;
import com.todolist.todolist.exception.ProjectIdException;
import com.todolist.todolist.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	
	public Project saveOrUpdateProject(Project project) {
		
	    try {
	    	project.setProjectIdentifer(project.getProjectIdentifer().toUpperCase()); 
			return projectRepository.save(project);
		} catch (Exception e) {
     
			throw new ProjectIdException("'Project Id '"+project.getProjectIdentifer().toUpperCase()+"'aleready exsist'"); 
		}
		
	}
	
   public Project findProjectByIdentifer(String projectId) {
	   
	   Project project=projectRepository.findByProjectIdentifer(projectId.toUpperCase());
       
	   if(project ==null) {
		   
		   throw new ProjectIdException("'Project Id'"+projectId.toUpperCase()+"'does not exists");
	   }
	   
	   return project;
   }
   
   public Iterable<Project>findAllProjects(){
	   
	   return projectRepository.findAll();
	   
	   
   }
   public void deleteProjectByIdentifer(String projectId) {
	   
	   Project project=projectRepository.findByProjectIdentifer(projectId.toUpperCase());
	   
	   if(project==null) {
		     
		   throw new ProjectIdException("Cannot project with Id"+projectId+".This project doesnt exist");
		     
	    }
	   
	   projectRepository.delete(project);
	   }
	 
    
}
