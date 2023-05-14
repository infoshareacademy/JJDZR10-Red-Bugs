package com.isa.pl.redbugs.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class User {
    private String name;
    private String surname;
    private String login;
    private String password;
    private int id;

    private UserRoute userRoute;

}
