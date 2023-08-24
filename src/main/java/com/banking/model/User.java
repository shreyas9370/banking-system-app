package com.banking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="users")
@Entity
public class User {
    @Id
    private long id;
//    @Column
//    private String userName;
    @Column
    private String email;
    @Column
    private String name;
//    @Column
//    private long mobileNo;
    @Column
    private String password;

//    @Column(name = "date_of_birth")
//    private Date dateOfBirth;

    private String address;

    public boolean isPasswordValid(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, this.password);
    }
}
