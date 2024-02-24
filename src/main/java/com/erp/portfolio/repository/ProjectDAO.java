package com.erp.portfolio.repository;

import com.erp.portfolio.entity.Project;
import com.erp.portfolio.entity.ResponseQuery;
import com.erp.portfolio.handle.HandleQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class ProjectDAO {

    private final DataSource dataSource;

    private static final String INSERT_PROJECT = "INSERT INTO PORTFOLIO.PROJECTS (title,description,repo) VALUES (?,?,?)";

    private static final String DELETE_PROJECT = "DELETE FROM PORTFOLIO.PROJECTS WHERE id = ?";
    private static final String UPDATE_PROJECT = "UPDATE PORTFOLIO.PROJECTS SET title = ?, description = ? , repo = ? WHERE ID = ? ";


    private final HandleQuery handleQuery;
    private static final Logger log = LoggerFactory.getLogger(ProjectDAO.class);

    public ProjectDAO(DataSource dataSource, HandleQuery handleQuery) {
        this.dataSource = dataSource;
        this.handleQuery = handleQuery;
    }

    public ResponseQuery insertProject(Project project) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(INSERT_PROJECT);
        ) {

            preparedStatement.setString(1, project.getTitle());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setString(3, project.getUrlRepo());

            int rowsAffected = preparedStatement.executeUpdate();
            return handleQuery.handleSuccessUpdate("insert query success", rowsAffected);
        } catch (SQLException e) {
            log.error("Error sql insert project: {}", e.getMessage(),e);
            return handleQuery.handleFailUpdate(e.getMessage(),0);
        }

    }

    public ResponseQuery deleteProject(Project project) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(DELETE_PROJECT);
        ) {

            preparedStatement.setInt(1, project.getId());


            int rowsAffected = preparedStatement.executeUpdate();
            return handleQuery.handleSuccessUpdate("delete query success", rowsAffected);
        } catch (SQLException e) {
            log.error("Error sql delete project: {}", e.getMessage(),e);
            return handleQuery.handleFailUpdate(e.getMessage(),0);
        }
    }

    public ResponseQuery updateProject(Project project) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_PROJECT);
        ) {

            preparedStatement.setString(1, project.getTitle());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setString(3, project.getUrlRepo());
            preparedStatement.setInt(4,project.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            return handleQuery.handleSuccessUpdate("update query success", rowsAffected);
        } catch (SQLException e) {
            log.error("Error sql update project: {}", e.getMessage(),e);
            return handleQuery.handleFailUpdate(e.getMessage(),0);
        }
    }

    public ResponseQuery getProjects() {
        return null;
    }

}
