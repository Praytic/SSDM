package Entity;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
@NamedQuery(name = "Subject.getAll", query = "select s from Subject s")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long subjectId;
    @Column(name = "name", length = 50)
    private String name;

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
