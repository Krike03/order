package be.christophe.order.domain.exceptions;

public class ObjectNotFound extends RuntimeException{
    public ObjectNotFound(String message) {
        super(message);
    }
}
