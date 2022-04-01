package pl.polsl.dectohexconversion_nowacki.model;

import pl.polsl.dectohexconversion_nowacki.exception.CustomException;
import java.util.*;

/**
 * Class model responsible for managing data of the application.
 *
 * @author kuban
 * @version 1.2
 *
 */
public class Model {

    /**
     * Integer which contains decimal number, written by a user.
     */
    private int decFromInput;
    /**
     * String which contains converted number.
     */
    private String hex;

    /**
     * Returns value of input decimal.
     *
     * @return value of input decimal.
     */
    public int getDecFromInput() {
        return decFromInput;
    }

    /**
     * Sets new value for input decimal.
     *
     * @param newDec new value for input decimal.
     */
    public void setDecFromInput(int newDec) {
        this.decFromInput = newDec;
    }

    /**
     * Returns hexadecimal stored in string, converted from decimal.
     *
     * @return returns hexadecimal stored in string, converted from decimal.
     */
    public String getHex() {
        return hex;
    }

    /**
     * Sets new value of hexadecimal stored in string, converted from decimal.
     *
     * @param newHex value of hexadecimal, converted from decimal.
     */
    public void setHex(String newHex) {
        this.hex = newHex;
    }

    /**
     * Converts number in decimal system, to hexadecimal.
     *
     * @throws
     * pl.polsl.dectohexconversion_nowacki.exception.CustomException
     * exception if input is smaller than 0.
     */
    public void convertToHex() throws CustomException {
        int dec = this.getDecFromInput();
        if (dec < 0) {
            throw new CustomException("Input has to be greater than 0");
        }

        int rem;
        String convertedHexadecimal = "";
        Character hexChars[]
                = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        List<Character> list = new ArrayList<>();

        for (Character hexCharsArrElement : hexChars) {
            list.add(hexCharsArrElement);
        }

        while (dec > 0) {
            rem = dec % 16;
            convertedHexadecimal = list.get(rem) + convertedHexadecimal;
            dec = dec / 16;
        }
        if (convertedHexadecimal == "") {
            convertedHexadecimal = "0";
        }
        this.setHex(convertedHexadecimal);
    }
}
