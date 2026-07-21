package br.com.studyHub.exception;

public class BadRequestExeception extends RuntimeException {
    public BadRequestExeception(String message){
        super(message);
    }
}
