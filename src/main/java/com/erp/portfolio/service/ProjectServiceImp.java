package com.erp.portfolio.service;

import com.erp.portfolio.entity.ResponseQuery;
import com.erp.portfolio.repository.ProjectDAO;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImp implements ProjectService{
    private final ProjectDAO projectDAO;

    public ProjectServiceImp(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Override
    public ResponseQuery getProjectsAll() {
       return projectDAO.getProjects();
    }
}
