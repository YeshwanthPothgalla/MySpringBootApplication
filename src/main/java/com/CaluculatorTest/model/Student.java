package com.CaluculatorTest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STUDENT")
public class Student {

   @Id
   @Column(name = "ID")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   @Column(name = "STUDENT_NAME")
   private String name;
   @Column(name = "FATHERS_NAME")
   private String fathersName;

   @OneToMany(targetEntity = StudentMarks.class, cascade = CascadeType.ALL)
   @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID")
   private List<StudentMarks> marksList;
}
