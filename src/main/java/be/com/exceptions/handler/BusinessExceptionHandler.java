package be.com.exceptions.handler;

import be.com.exceptions.BusinessException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.springframework.http.HttpStatus;

@Provider
public class BusinessExceptionHandler implements ExceptionMapper<BusinessException> {
    @Override
    public Response toResponse(BusinessException exception) {
        return Response.status(HttpStatus.UNPROCESSABLE_ENTITY.value()).entity(exception.getMessage()).build();
    }
}