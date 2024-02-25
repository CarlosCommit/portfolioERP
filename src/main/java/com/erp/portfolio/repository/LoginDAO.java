package com.erp.portfolio.repository;

import com.erp.portfolio.entity.ResponseQuery;
import com.erp.portfolio.handle.HandleQuery;
import com.erp.portfolio.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class LoginDAO {

    private final DataSource dataSource;
    private static final String SELECT_USER_DB = "SELECT * FROM PORTFOLIO.USER WHERE username = ? AND password = ?";
    private final HandleQuery handleQuery;
    private static final Logger log = LoggerFactory.getLogger(LoginDAO.class);

    public LoginDAO(@Qualifier("mysqlProjectsDataSource") DataSource dataSource, HandleQuery handleQuery) {
        this.dataSource = dataSource;
        this.handleQuery = handleQuery;
    }

    public ResponseQuery verifyUser(User user) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement preStmt = conn.prepareStatement(SELECT_USER_DB);) {
            preStmt.setString(1, user.getUsername());
            preStmt.setString(2, user.getPassword());

            ResultSet resultSet = preStmt.executeQuery();

            if (resultSet.next()) {
                return handleQuery.handleSuccessSelect("User verify",null);
            } else {
                return handleQuery.handleZeroSelect("User not found");
            }

        } catch (SQLException e) {
            log.error("Exception select userquery {}", e.getMessage(), e);
            return handleQuery.handleFailSelect(e.getMessage());
        }

    }
}


