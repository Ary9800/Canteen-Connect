package com.api.CanteenConnect.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "admin")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password")
public class Admin extends BaseEntity {
    @Column(name = "first_name", length = 20)
    private String FirstName;

    @Column(name = "last_name", length = 20)
    private String LastName;

    @Column(name = "email", length = 20, unique = true, nullable = true)
    private String email;

    @Column(name = "password", length = 20, nullable = true)
    private String Password;

}
