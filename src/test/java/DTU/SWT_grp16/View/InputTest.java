package DTU.SWT_grp16.View;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {
Input input = new Input();

    private String filePath1 = "src\\main\\textfiles\\Dansk\\Fields.txt";
    private String filePath2 = "src\\main\\textfiles\\English\\Fields.txt";
    @Test
    void mReader() {
        // positiv danish test
        assertEquals("Taarnet:250:false",input.mReader(filePath1).get(0));
        assertEquals("Krateret:-100:false",input.mReader(filePath1).get(1));
        assertEquals("Palads Porten:100:false",input.mReader(filePath1).get(2));
        assertEquals("Den Kolde Oerken:-20:false",input.mReader(filePath1).get(3));
        assertEquals("Den Bevaeggede By:180:false",input.mReader(filePath1).get(4));
        assertEquals("Klosteret:0:false",input.mReader(filePath1).get(5));
        assertEquals("Den Sorte Hule:-70:false",input.mReader(filePath1).get(6));
        assertEquals("Hytter i Bjergene:60:false",input.mReader(filePath1).get(7));
        assertEquals("VarVaeggen:-80:true",input.mReader(filePath1).get(8));
        assertEquals("Hullet:-50:false",input.mReader(filePath1).get(9));
        assertEquals("Guldminen:650:false",input.mReader(filePath1).get(10));

        //positiv english test
        assertEquals("Tower:250:false",input.mReader(filePath2).get(0));
        assertEquals("Crater:-100:false",input.mReader(filePath2).get(1));
        assertEquals("Palace Gates:100:false",input.mReader(filePath2).get(2));
        assertEquals("Cold Desert:-20:false",input.mReader(filePath2).get(3));
        assertEquals("Walled City:180:false",input.mReader(filePath2).get(4));
        assertEquals("Monestary:0:false",input.mReader(filePath2).get(5));
        assertEquals("Black Cave:-70:false",input.mReader(filePath2).get(6));
        assertEquals("Huts In The Mountain:60:false",input.mReader(filePath2).get(7));
        assertEquals("The Werewall:-80:true",input.mReader(filePath2).get(8));
        assertEquals("The Pit:-50:false",input.mReader(filePath2).get(9));
        assertEquals("Goldmine:650:false",input.mReader(filePath2).get(10));

    }

    @Test
    void askPlayerName1() {
    }

    @Test
    void waitForInput() {
    }

    @Test
    void waitForEnter() {
    }

    @Test
    void closeScanner() {
    }

    @Test
    void getLanguageChoices() {

        String[] testArray = {"Dansk","English"};
        assertArrayEquals(testArray, input.getLanguageChoices());
    }

    @Test
    void setLanguage() {
        String[] fakeUserInput = {"Dansk","English"};
        FakeInput fakeInput = new FakeInput();

        // positiv test with fake input
        assertEquals(fakeUserInput[1], fakeInput.setLanguage(input.getLanguageChoices(),fakeUserInput[1]));
        assertEquals(fakeUserInput[1], fakeInput.setLanguage(input.getLanguageChoices(),fakeUserInput[1]));

        // negativ test with fake input
        assertNotEquals(fakeUserInput[0], fakeInput.setLanguage(input.getLanguageChoices(),fakeUserInput[1]));
        assertNotEquals("Korean", fakeInput.setLanguage(input.getLanguageChoices(),fakeUserInput[1]));
    }

}