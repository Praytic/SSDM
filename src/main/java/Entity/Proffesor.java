package Entity;

import javax.persistence.*;

/**
 * Created by Daniil on 05.10.2016.
 */
@Entity
@Table(name = "Proffesors")
@NamedQuery(name = "Proffesor.getAll", query = "select p from Proffesor p")
public class Proffesor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer proffesorId;
    @Column(name = "firstName", length = 32)
    private String firstName;
    @Column(name = "lastName", length = 32)
    private String lastName;
    //private Integer subjectId;

}
