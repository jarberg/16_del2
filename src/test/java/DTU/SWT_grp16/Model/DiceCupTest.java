package DTU.SWT_grp16.Model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceCupTest {

    @Test
    void shouldWorkWithFakeDice(){
        DiceCup testCup = new DiceCupWithFakeDice();
        testCup.roll();
        assertEquals(2, testCup.getSum());
    }

    @Test
    void shouldReturnSumFromTwoToTwelve() {
        DiceCup testCup = new DiceCup();
        int sum = testCup.getSum();
        assertTrue(sum < 13 && sum > 1);
    }

    @Test
    void shouldReturnSumFromTwoToTwelveOnRoll() {
        DiceCup testCup = new DiceCup();
        testCup.roll();
        int sum = testCup.getSum();
        assertTrue(sum < 13 && sum > 1);
    }

    @Test
    void onThirtySixThousandRolls_ShouldBeRandomWithinTwoHundred() {
        DiceCup testCup = new DiceCup();
        int[] resultCounters = new int[13];
        for (int i = 0; i <36_000 ; i++) {
            testCup.roll();
            int sum = testCup.getSum();
            resultCounters[sum]++;
        }
        //Using 2 dice probability. fx 2/36 chance of 3.
        assertTrue(resultCounters[2]>1000 - 200);
        assertTrue(resultCounters[2]<1000 + 200);
        assertTrue(resultCounters[3]>2000 - 200);
        assertTrue(resultCounters[3]<2000 + 200);
        assertTrue(resultCounters[4]>3000 - 200);
        assertTrue(resultCounters[4]<3000 + 200);
        assertTrue(resultCounters[5]>4000 - 200);
        assertTrue(resultCounters[5]<4000 + 200);
        assertTrue(resultCounters[6]>5000 - 200);
        assertTrue(resultCounters[6]<5000 + 200);
        assertTrue(resultCounters[7]>6000 - 200);
        assertTrue(resultCounters[7]<6000 + 200);
        assertTrue(resultCounters[8]>5000 - 200);
        assertTrue(resultCounters[8]<5000 + 200);
        assertTrue(resultCounters[9]>4000 - 200);
        assertTrue(resultCounters[9]<4000 + 200);
        assertTrue(resultCounters[10]>3000 - 200);
        assertTrue(resultCounters[10]<3000 + 200);
        assertTrue(resultCounters[11]>2000 - 200);
        assertTrue(resultCounters[11]<2000 + 200);
        assertTrue(resultCounters[12]>1000 - 200);
        assertTrue(resultCounters[12]<1000 + 200);
    }
}