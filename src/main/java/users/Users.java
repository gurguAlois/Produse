package users;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Users")

public class Users implements Serializable {

    private static final String DESCRIERE_SEQUENCE = "descriere_id_seq";

    @Id
    @SequenceGenerator(name = "descriere_generator ", sequenceName = DESCRIERE_SEQUENCE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "descriere_generator")
    private int id;
@Column
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
}
