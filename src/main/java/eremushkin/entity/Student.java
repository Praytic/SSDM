package eremushkin.entity;


import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;

@Entity
@Table(name = "students")
@NamedQuery(name = "Student.getAll", query = "select s from Student s")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    @Column(name = "firstName", length = 32)
    private String firstName;
    @Column(name = "lastName", length = 32)
    private String lastName;

    public Student() {
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Long getId(){
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "{"
                + " studentId = " + studentId
                + " firstName = " + firstName
                + " lastName = " + lastName
                + " }";
    }
}
