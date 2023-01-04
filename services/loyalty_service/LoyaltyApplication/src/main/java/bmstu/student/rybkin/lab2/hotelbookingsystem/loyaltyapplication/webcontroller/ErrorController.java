package bmstu.student.rybkin.lab2.hotelbookingsystem.loyaltyapplication.webcontroller;

import bmstu.student.rybkin.lab2.hotelbookingsystem.loyaltyapplication.models.ErrorResponse;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@Hidden
@RestControllerAdvice
public class ErrorController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorResponse entityNotFound(EntityNotFoundException exception) {

        return new ErrorResponse(exception.getMessage());

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalStateException.class)
    public ErrorResponse illegalState(IllegalStateException exception) {

        return new ErrorResponse(exception.getMessage());

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponse runtimeError(RuntimeException exception) {

        return new ErrorResponse(exception.getMessage());

    }

}
