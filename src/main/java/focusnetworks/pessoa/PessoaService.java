package focusnetworks.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaService {
		
	@Autowired
	private PessoaRepository repository;

	@Transactional
	public Pessoa save(final Pessoa Pessoa) throws Exception {
		if (Pessoa.getId() != null) {
			throw new Exception("Erro");
		}
		return saveOrUpdate(Pessoa);
	}

	@Transactional
	public void update(final Pessoa Pessoa) throws Exception {
		if (Pessoa.getId() == null) {
			throw new Exception("Id Nulo!");
		}
		saveOrUpdate(Pessoa);
	}

	@Transactional
	protected Pessoa saveOrUpdate(final Pessoa Pessoa) throws Exception {
		try {
			return repository.save(Pessoa);
		} catch (DataIntegrityViolationException e) { // e-mail unique key
			throw new Exception("Email Existente");
		}
	}

	public  List<Pessoa> findAll() throws Exception {
		try {
			return repository.findAll();
		} catch (Exception e) {
			throw new Exception("Erro");
		}
	}

	public PessoaDTO findAll(Integer page, Integer perPage) throws Exception {
		try {
			List<Pessoa> people = repository.findAll(new PageRequest(page, perPage)).getContent();
			return new PessoaDTO((int) repository.count(), people);
		} catch (Exception e) {
			throw new Exception("Erro");
		}
	}

	public void delete(final Long id) throws Exception {
		try {
			repository.delete(id);
		} catch (Exception e) {
			throw new Exception("Erro");
		}
	}

	public PessoaDTO findByNameOrEmail(final String search, Integer page, Integer perPage) throws Exception {
		try {
			List<Pessoa> people = repository.findByName(search, search, new PageRequest(page, perPage)).getContent();
			return new PessoaDTO((int) repository.countByName(search, search), people);
		} catch (Exception e) {
			throw new Exception("Erro");
		}
	}
}