package eremushkin.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Daniil on 05.10.2016.
 */
@Entity
@Table(name = "Teachers")
@NamedQuery(name = "Teacher.getAll", query = "select p from Teacher p")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Column(name = "first_name", length = 32)
    private String firstName;
    @Column(name = "last_name", length = 32)
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "teachers")
    private List<Subject> subjects;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getTeacherId() {
        return teacherId;
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

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
