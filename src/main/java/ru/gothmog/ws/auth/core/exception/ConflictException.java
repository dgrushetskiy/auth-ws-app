package ru.gothmog.ws.auth.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException{
    private final String conflictName;
    private final String fieldName;
    private final Object fieldValue;

    public ConflictException(String conflictName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", conflictName, fieldName, fieldValue));
        this.conflictName = conflictName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getConflictName() {
        return conflictName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
