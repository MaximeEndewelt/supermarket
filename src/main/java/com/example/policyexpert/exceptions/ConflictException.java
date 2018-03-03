package com.example.policyexpert.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException
{
    String message;

    public ConflictException(String message)
    {
        this.message= message;
    }
}
