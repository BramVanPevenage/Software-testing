package com.openclassroom.testing.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AgeValidationTests {
    public class AgeValidatorTest {

        @Test()
        public void validate_shouldThrowAnException_forSomeoneOver200YearsOld() throws InsaneAgeException {
            AgeValidator ageValidator = new AgeValidator();
            Assertions.assertThrows(InsaneAgeException.class, () ->{
                ageValidator.validate(200);
            });
        }

        @Test
        public void validate_shouldNotThrow_forSomeoneUnder200YearsOld() throws InsaneAgeException {
            AgeValidator ageValidator = new AgeValidator();
            ageValidator.validate(199);
            // This passes by virtual of the fact that we do not fail with an exception
        }
    }
}
