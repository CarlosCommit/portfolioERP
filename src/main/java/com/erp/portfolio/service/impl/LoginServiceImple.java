package com.erp.portfolio.service.impl;

import com.erp.portfolio.entity.ResponseQuery;
import com.erp.portfolio.model.User;
import com.erp.portfolio.repository.LoginDAO;
import com.erp.portfolio.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImple implements LoginService {
    private final LoginDAO loginDAO;

    public LoginServiceImple(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    @Override
    public ResponseQuery verifyUser(User user) {
        return loginDAO.verifyUser(user);
    }
}
