package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 1. Null name
 * 2. Null gender
 * 3. Negative age
 * 4. Invalid value of gender
 * 5. All valid value
 * 6. Empty list
 * 7. Average of:
 *      Male's age = [1,2,3,4,5]
 *      Female's age = [6,7,8,9,10]
 *    is [3,8]
 */

class PersonTest {

    Person person;

    @BeforeEach
    void setup(){
        person = new Person();
    }

    @AfterEach
    void shutdown(){
        person = null;
    }

    @Test
    public void ifNullName(){
        assertThrows(RuntimeException.class, () -> person = new Person(null, 1, "Male"));
    }
    @Test
    public void ifNullGender(){
        assertThrows(RuntimeException.class, () -> person = new Person("Name", 1, null));
    }
    @Test
    public void ifAgeMinusZero(){
        assertThrows(RuntimeException.class, () -> person = new Person("Name", -5, "Male"));
    }
    @Test
    public void ifErrorValueOfGender(){
        assertThrows(RuntimeException.class, () -> person = new Person("Name", 19, "FMale"));
    }
    @Test
    public void allValidValue(){
        String expectedName = "Antonio";
        String expectedGender = "Male";
        int expectedAge = 21;
        Person obtainedPerson = new Person(expectedName, expectedAge, expectedGender);

        assertEquals(expectedName, obtainedPerson.name());
        assertEquals(expectedAge, obtainedPerson.age());
        assertEquals(expectedGender, obtainedPerson.gender());
    }
    @Test
    public void emptyList(){
        double[] expectedValue = {0,0};
        List<Person> list = new ArrayList<>();
        double[] obtainedValue = person.averageAgePerGender(list);
        assertArrayEquals(expectedValue, obtainedValue);
    }
    @Test
    public void averageOfList(){
        double[] expectedValue = {3,8};
        List<Person> list = new ArrayList<>();
        list.add(new Person("1", 1, "Male"));
        list.add(new Person("2", 2, "Male"));
        list.add(new Person("3", 3, "Male"));
        list.add(new Person("4", 4, "Male"));
        list.add(new Person("5", 5, "Male"));
        list.add(new Person("6", 6, "Female"));
        list.add(new Person("7", 7, "Female"));
        list.add(new Person("8", 8, "Female"));
        list.add(new Person("9", 9, "Female"));
        list.add(new Person("10", 10, "Female"));

        double[] obtainedValue = person.averageAgePerGender(list);
        assertArrayEquals(expectedValue, obtainedValue);
    }
}