package org.example;

import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private OptionalInt age = OptionalInt.empty();
    private String address;

    protected Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public boolean hasAge() {
        return this.age.isPresent();
    }

    public boolean hasAddress() {
        return this.address != null;
    }

    public void happyBirthday() {
        this.age.ifPresent((value) -> {
            value = value + 1;
            this.age = OptionalInt.of(value);

        });
    }

    public void setAge(OptionalInt age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder()
                .setSurname(this.getSurname())
                .setAddress(this.getAddress());
        return personBuilder;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

}
