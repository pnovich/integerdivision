package org.vasianovych.division;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivisionMakerTest {
   @Test
    public void partialIntDevisionShouldWorkCorrectForValidInput(){
        DivisionMaker divisionMaker = new DivisionMaker();
        int divided = 78945;
        int divisor = 4;
        int expectedResult = 19736;
        int actualResult = divisionMaker.partialIntDevision(78945, 4);
        assertEquals(expectedResult, actualResult);
    }
}

