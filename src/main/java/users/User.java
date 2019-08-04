package users;

import javax.persistence.*;
import java.io.Serializable;

@NamedQueries({
    @NamedQuery(
        name = "find_by_name",
        query = "select u from User u where name = :name and password = :password"
    )
})

@Entity
@Table(name = "Users")

public class User implements Serializable {

    private static final String DESCRIERE_SEQUENCE = "descriere_id_seq";

    @Id
    @SequenceGenerator(name = "descriere_generator ", sequenceName = DESCRIERE_SEQUENCE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "descriere_generator")
    private int id;
@Column(unique = true)
    private String name;
@Column
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }
}
