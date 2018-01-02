package spring.exception;

import org.springframework.stereotype.Service;
import spring.exception.model.PersonNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Service
public class CustomExceptionMapper implements ExceptionMapper<PersonNotFoundException> {

    @Override
    public Response toResponse(PersonNotFoundException exception)
    {
        return Response.status(Response.Status.BAD_GATEWAY).entity(exception.getMessage()).build();
    }
}