package be.christophe.order.user.api;

import be.christophe.order.domain.exceptions.ObjectNotFound;
import be.christophe.order.domain.exceptions.UserNotFound;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ObjectNotFound.class, UserNotFound.class})
    protected void entityDoesNotExistInDb(RuntimeException exception,
                                          HttpServletResponse response) throws IOException {
        String message = exception.getLocalizedMessage();
        response.sendError(NOT_FOUND.value(), message);
    }
}