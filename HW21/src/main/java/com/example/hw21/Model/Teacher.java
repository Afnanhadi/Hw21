package com.example.hw21.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(columnDefinition = "varchar(20) not nul")
     private  String name;
     @NotNull
    @Column(columnDefinition = "varchar(20) not nul")
     private Integer age;
     @Email
     @Column(columnDefinition = "varchar(30) not nul")
     @NotEmpty
     private  String email;
     private Double salary;
    @OneToOne(cascade=CascadeType.ALL,mappedBy  ="teacher")
    @PrimaryKeyJoinColumn
     private Address address;
}
