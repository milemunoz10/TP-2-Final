package Exceptions;

public class GetNonexistentValueException extends Throwable {
    public GetNonexistentValueException(String message) {
        super(message);
    }
}
