package com.erp.portfolio.service;

import com.erp.portfolio.entity.ResponseQuery;
import com.erp.portfolio.model.User;

public interface LoginService {
    ResponseQuery verifyUser(User user);
}
