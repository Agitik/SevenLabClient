package StartClasses;

/**
 * Исключение для нереальных значений. (NON RP)
 */
public class UnrealValueException extends Exception {
    public UnrealValueException(String message) {
        super(message);
    }
}
