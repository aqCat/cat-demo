package com.example.catdemo.entity;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String username;
    private Integer age;
    private Integer sex;
    private String description;

    public User() {
    }

    public User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.username = userBuilder.username;
        this.age = userBuilder.age;
        this.sex = userBuilder.sex;
        this.description = userBuilder.description;
    }

    public static class UserBuilder{
        private Integer id;
        private String username;
        private Integer age;
        private Integer sex;
        private String description;

        public UserBuilder builderId(Integer id) {
            this.id = id;
            return this;
        }
        public UserBuilder builderName(String username) {
            this.username = username;
            return this;
        }
        public UserBuilder builderAge(Integer age) {
            this.age = age;
            return this;
        }
        public UserBuilder builderSex(Integer sex) {
            this.sex = sex;
            return this;
        }
        public UserBuilder builderDescription(String description) {
            this.description = description;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }

}
