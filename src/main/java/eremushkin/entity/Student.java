package eremushkin.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
@NamedQuery(name = "Student.getAll", query = "select s from Student s")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "first_name", length = 32)
    private String firstName;
    @Column(name = "last_name", length = 32)
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name="group_id", nullable = false)
    private Group group;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
    private Set<Mark> marks;

    public Student() {
    }
    public Student(String firstName, String lastName, Group group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
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

    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
    }

    public Set<Mark> getMarks() {
        return marks;
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
