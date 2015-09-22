package focusnetworks.pessoa;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Entity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    @NotBlank
    @NotEmpty
    private String name;

    @NotBlank
    @NotEmpty
    @Column(unique = true)
    private String email;
    public Pessoa(final Long id, final String name, final String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}