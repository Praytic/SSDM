package eremushkin.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "subjects")
@NamedQuery(name = "Subject.getAll", query = "select s from Subject s")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_id")
    private long subjectId;
    @Column(name = "subject_name", length = 50)
    private String subjectName;

    @ManyToMany
    @JoinTable(name = "teacher_subject",
                joinColumns = @JoinColumn(name="subject_id", referencedColumnName = "subject_id"),
                inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id"))
    private Set<Teacher> teachers;

    public Subject() {
    }

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
