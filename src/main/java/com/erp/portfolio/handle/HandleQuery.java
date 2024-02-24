package com.erp.portfolio.handle;

import com.erp.portfolio.entity.ResponseQuery;
import org.springframework.stereotype.Component;

@Component
public class HandleQuery {


    public ResponseQuery handleSuccessSelect(String message)
    {
        return ResponseQuery.builder().status(0).message(message).rowsAffected(0).build();
    }
    public ResponseQuery handleFailSelect(String message)
    {
        return ResponseQuery.builder().status(-20).message(message).rowsAffected(0).build();
    }
    public ResponseQuery handleZeroSelect(String message)
    {
        return ResponseQuery.builder().status(-10).message(message).rowsAffected(0).build();
    }
}
