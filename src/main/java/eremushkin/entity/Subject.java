package eremushkin.entity;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
@NamedQuery(name = "Subject.getAll", query = "select s from Subject s")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long subjectId;
    @Column(name = "subjectname", length = 50)
    private String subjectName;

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
