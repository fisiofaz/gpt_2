package br.com.gtp.shared.exception;

@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

}