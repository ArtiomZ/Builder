package org.example;

import java.util.OptionalInt;

public class PersonBuilder {

    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("incorrect age");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        Person person = new Person(this.name, this.surname);
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException("no required 'name' or 'surname' data");
        }
        person.setAge(OptionalInt.of(this.age));
        person.setAddress(this.address);
        return person;
    }
}
