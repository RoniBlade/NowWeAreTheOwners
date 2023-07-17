package com.nowweareowner.nowweareowner.models;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class User {

    public User(long userId, String name, String lastName, String secondName) {
        this.name = name;
        this.lastName = lastName;
        this.secondName = secondName;
    }

        private Long id;
        private String name;
        private String lastName;
        private String secondName;

        public int compareTo(User user) {
            return this.getId().compareTo(user.getId());
        }

    public Long getUserId() {

        return id;
    }
}
