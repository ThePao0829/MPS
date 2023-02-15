package org.example;

import java.util.List;

/**
 * Class representing a person with a name, age and gender.
 *
 * @author Fan Yang
 */

public class Person {
    private final String name;
    private final int age;
    private final String gender; //Male, Female

    /**
     * Constructs a person with a name, age and gender.
     *
     * @param name   the name of the person
     * @param age    the age of the person
     * @param gender the gender of the person
     */

    public Person(){
        this.name = null;
        this.age = 0;
        this.gender = null;
    }

    public Person(String name, int age, String gender) {
        if((name == null) || (gender == null)){
            throw new RuntimeException("Missing value");
        }
        if(age <= 0){
            throw new RuntimeException("Invalid value of age");
        }
        if (!(gender.equals("Male")) && !(gender.equals("Female"))) {
            throw new IllegalArgumentException("Error value of gender");
        }
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String name() {
        return this.name;
    }

    public int age() {
        return this.age;
    }

    public String gender() {
        return this.gender;
    }

    /**
     * Computes the average age of male and female persons in a list and returns the result in
     * on array of two elements (the first element is the male mean age and teh second one is the
     * female mean age)
     *
     * @param persons a list of persons
     * @return an array of double
     */
    public double[] averageAgePerGender(List<Person> persons) {
        double[] res = {0,0};
        int maleNumber = 0;
        int femaleNumber = 0;

        if(persons.isEmpty()){
            return res;

        }else{
            for(Person person : persons){
                if(person.gender().equals("Male")){
                    maleNumber++;
                    res[0] += person.age();
                }else{
                    femaleNumber++;
                    res[1] += person.age();
                }
            }
            res[0] = res[0] / maleNumber;
            res[1] = res[1] / femaleNumber;
            return res;
        }
    }
}
