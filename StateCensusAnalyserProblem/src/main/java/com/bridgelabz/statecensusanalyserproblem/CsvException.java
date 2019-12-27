package com.bridgelabz.statecensusanalyserproblem;

public class CsvException extends Exception{


    enum ExceptionType {ENTERED_NULL,ENTERED_EMPTY,NO_SUCH_CLASS,NO_SUCH_METHOD, METHOD_INVOCATION_ISSUE,
        NO_SUCH_FIELD,FIELD_SETTING_ISSUE,OBJECT_CREATION,NO_ACCESS}
    ExceptionType type;

    public CsvException(String message) {
        super(message);
    }

    public CsvException(ExceptionType type,String message) {
        super(message);
        this.type=type;
    }
}
