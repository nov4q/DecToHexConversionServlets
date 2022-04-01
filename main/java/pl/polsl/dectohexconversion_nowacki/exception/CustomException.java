package pl.polsl.dectohexconversion_nowacki.exception;

/**
 * Class responsible for handling exceptions.
 *
 * @author kuban
 * @version 3.0, December 2021
 *
 */
public class CustomException extends Exception {

    /**
     * Handling Exception.
     *
     * @param message string information about exception.
     */
    public CustomException(String message) {
        super(message);
    }

}
