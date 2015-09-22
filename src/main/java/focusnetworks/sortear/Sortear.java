package focusnetworks.sortear;
import javax.validation.constraints.NotNull;

import focusnetworks.pessoa.Pessoa;

import java.io.Serializable;

public class Sortear implements Serializable {
	
    @NotNull
    private Pessoa pessoa;

    private Pessoa parPessoa;

    public Sortear(final Pessoa pessoa, final Pessoa parPessoa) {
        this.pessoa = pessoa;
        this.parPessoa = parPessoa;
    }

    public Pessoa getpessoa() {
        return pessoa;
    }

    public void setpessoa(final Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getparPessoa() {
        return parPessoa;
    }

    public void setparPessoa(final Pessoa parPessoa) {
        this.parPessoa = parPessoa;
    }
}