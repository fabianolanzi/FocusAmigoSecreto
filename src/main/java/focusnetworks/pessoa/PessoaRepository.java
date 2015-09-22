package focusnetworks.pessoa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Page<Pessoa> findByName(String name, String email, Pageable pageable);
    long countByName(String name, String email);
}
	