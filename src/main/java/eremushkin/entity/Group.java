package eremushkin.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Daniil on 24.10.2016.
 */
@Entity
@Table(name = "groups")
@NamedQuery(name = "Group.getAll", query = "SELECT g FROM Group g")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_id")
    private long groupId;
    @Column(name = "group_numbe")
    private int groupNumber;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group")
    private Set<Student> students;

    public Group() {
    }
    public Group(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public long getGroupNumber() {
        return groupNumber;
    }
    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Set<Student> getStudents() {
        return students;
    }
}
