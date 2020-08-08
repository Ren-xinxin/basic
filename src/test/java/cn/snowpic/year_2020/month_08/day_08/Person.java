/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_08.day_08;

/**
 * person
 *
 * @className Person
 * @author Little Flower
 * @date 2020-08-08 16:08:30
 */
public class Person {
    private String name;
    private String id;
    private String gender;
    private String[] bobbies;


    public static final class PersonBuilder {
        private String name;
        private String id;
        private String gender;
        private String[] bobbies;

        private PersonBuilder() {
        }

        public static PersonBuilder aPerson() {
            return new PersonBuilder();
        }

        public PersonBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder id(String id) {
            this.id = id;
            return this;
        }

        public PersonBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public PersonBuilder bobbies(String[] bobbies) {
            this.bobbies = bobbies;
            return this;
        }

        public PersonBuilder but() {
            return aPerson().name(name).id(id).gender(gender).bobbies(bobbies);
        }

        public Person build() {
            Person person = new Person();
            person.gender = this.gender;
            person.id = this.id;
            person.bobbies = this.bobbies;
            person.name = this.name;
            return person;
        }
    }
}