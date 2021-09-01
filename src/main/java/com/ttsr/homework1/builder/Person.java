package com.ttsr.homework1.builder;

public class Person {

    String firstName;
    String lastName;
    String middleName;
    String country;
    String address;
    String phone;
    int age;
    String gender;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public static class Builder {
        private Person newPerson;

        public Builder(){
            newPerson = new Person();
        }

        public Builder withFirstName(String firstName){
            newPerson.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName){
            newPerson.lastName = lastName;
            return this;
        }

        public Builder withMiddleName(String middleName){
            newPerson.middleName = middleName;
            return this;
        }

        public Builder withCountry(String country){
            newPerson.country = country;
            return this;
        }

        public Builder withAddress(String address){
            newPerson.address = address;
            return this;
        }

        public Builder withPhone(String phone){
            newPerson.phone = phone;
            return this;
        }

        public Builder withAge(int age){
            newPerson.age = age;
            return this;
        }

        public Builder withGender(String gender){
            newPerson.gender = gender;
            return this;
        }

        public Person build(){
            return newPerson;
        }
    }
}
