package focusnetworks.pessoa;

import java.util.List;

public class PessoaDTO {
    private Integer totalRegister;
    private List<Pessoa> people;

    public PessoaDTO(Integer totalRegister, List<Pessoa> people) {
        this.totalRegister = totalRegister;
        this.people = people;
    }

    public int getTotalRegister() {
        return totalRegister;
    }

    public void setTotalRegister(final int totalRegister) {
        this.totalRegister = totalRegister;
    }

    public List<Pessoa> getPeople() {
        return people;
    }

    public void setPeople(final List<Pessoa> people) {
        this.people = people;
    }
}
