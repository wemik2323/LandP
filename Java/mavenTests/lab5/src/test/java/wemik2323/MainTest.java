package wemik2323;

import static org.junit.Assert.*;

import org.junit.Test;
import java.io.UnsupportedEncodingException;

import wemik2323.Dishwasher;
import wemik2323.Freezer;

/**
 * Unit test for simple App.
 */
public class MainTest 
{
@Test
public void changeMode_withInvalidChoice_shouldReturnMinusOne() throws UnsupportedEncodingException {
    Dishwasher dishwasher = new Dishwasher("modelName", "brandName");

    int result = dishwasher.changeMode(1000);

    assertEquals(-1,result);

}

@Test
public void changeMode_withValidChoice_shouldReturnZero() throws UnsupportedEncodingException {
    Dishwasher dishwasher = new Dishwasher("modelName", "brandName");

    int result = dishwasher.changeMode(3);

    assertEquals(0,result);

}

@Test
public void testChangeModeWithInvalidChoice() throws UnsupportedEncodingException {
    Freezer freezer = new Freezer("model", "brand");
    int result = freezer.changeMode(100);

    assertEquals(-1, result);
}

@Test
public void testChangeModeWithValidChoice() throws UnsupportedEncodingException {
    Freezer freezer = new Freezer("model", "brand");
    int result = freezer.changeMode(1);

    assertEquals(0, result);
}

}
