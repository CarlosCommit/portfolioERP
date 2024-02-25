package com.erp.portfolio.handle;

import com.erp.portfolio.entity.ResponseQuery;
import org.springframework.stereotype.Component;

@Component
public class HandleQuery {


    public ResponseQuery handleSuccessSelect(String message,Object payload)
    {
        return ResponseQuery.builder().status(0).message(message).rowsAffected(0).payload(payload).build();
    }
    public ResponseQuery handleFailSelect(String message)
    {
        return ResponseQuery.builder().status(-20).message(message).rowsAffected(0).build();
    }
    public ResponseQuery handleZeroSelect(String message)
    {
        return ResponseQuery.builder().status(-10).message(message).rowsAffected(0).build();
    }

    public ResponseQuery handleSuccessUpdate(String message,Integer rowsAffected)
    {
        return ResponseQuery.builder().status(0).message(message).rowsAffected(rowsAffected).build();
    }
    public ResponseQuery handleFailUpdate(String message,Integer rowsAffected)
    {
        return ResponseQuery.builder().status(-10).message(message).rowsAffected(rowsAffected).build();
    }

}
