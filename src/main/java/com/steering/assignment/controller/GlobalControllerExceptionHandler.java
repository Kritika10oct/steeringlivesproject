package com.steering.assignment.controller;


import com.steering.assignment.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is custom Exception Handler class which will handle all exceptions occurring in code
 * and return an Error Response to the FE's
 * @author stanratech
 */
@ControllerAdvice
@RestController
public class GlobalControllerExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);
    /**
     * Global handler for all Exceptions
     * @return ResponseEntity
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<Response> globalHandler(
            final Exception exception) {
        LOGGER.error(exception.getMessage());

        Response response = new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());

        ResponseEntity<Response> responseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }


}