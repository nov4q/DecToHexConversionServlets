package pl.polsl.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pl.polsl.dectohexconversion_nowacki.exception.CustomException;

import pl.polsl.dectohexconversion_nowacki.model.Model;

/**
 * Class responsible for unit testing methods from class Model.
 *
 * @author kuban
 * @version 1.2
 */
public class ModelTest {

    /**
     * Unit test defined for checking if method acts correctly for correct input
     * data
     *
     * @throws CustomException
     */
    @Test
    public void convertToHexTestCorrectInput() throws CustomException {

        //given
        Model modelTest = new Model();

        modelTest.setDecFromInput(10);

        //when
        modelTest.convertToHex();
        //then
        Assertions.assertEquals("A", modelTest.getHex(), "Incorrect calculation for possible input");
    }

    /**
     * Unit test defined for checking if method acts correctly for lowest
     * correct input data
     *
     * @throws CustomException
     */
    @Test
    public void convertToHexTestLowestCorrectInput() throws CustomException {

        //given
        Model modelTest = new Model();

        modelTest.setDecFromInput(0);

        //when
        modelTest.convertToHex();
        //then
        Assertions.assertEquals("0", modelTest.getHex(), "Incorrect calculation for lowest possible input");
    }

    /**
     * Unit test defined for checking if method acts correctly for highest
     * correct input data
     *
     * @throws CustomException
     */
    @Test
    public void convertToHexTestHighestCorrectInput() throws CustomException {

        //given
        Model modelTest = new Model();

        modelTest.setDecFromInput(2147483646);

        //when
        modelTest.convertToHex();
        //then
        Assertions.assertEquals("7FFFFFFE", modelTest.getHex(), "Incorrect calculation for highest possible input");
    }

    /**
     * Unit test defined for checking whether there is thrown an exception
     *
     * @throws CustomException
     */
    @Test
    public void convertToHexTestThrowException() throws CustomException {

        //given
        Model modelTest = new Model();

        modelTest.setDecFromInput(-10);
        //when

        //then
        Assertions.assertThrows(CustomException.class, () -> modelTest.convertToHex(), "Expected Exception, when trying to compute negative decimal");

    }
}
