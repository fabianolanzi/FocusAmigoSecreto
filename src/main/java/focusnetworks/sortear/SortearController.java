package focusnetworks.sortear;

import org.springframework.web.bind.annotation.*;

import focusnetworks.pessoa.Pessoa;
import focusnetworks.pessoa.PessoaService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

@RestController
@RequestMapping("/sortition")
public class SortearController {

	/* Sortear amigo secreto */
	@RequestMapping()
	public @ResponseBody List<Sortear> get() throws Exception {
		return (List<Sortear>) execute();
	}

	private PessoaService pessoaService;

	public Map<Pessoa, Pessoa> execute() throws Exception {
		try {
			final List<Pessoa> allPessoas = pessoaService.findAll();

			if (allPessoas.size() < 2) {
				throw new Exception("Adicione mais pessoas!");
			}

			Map<Pessoa, Pessoa> result = new HashMap<Pessoa, Pessoa>();
			List<Pessoa> sortitionPessoa = new ArrayList<Pessoa>(allPessoas);

			for (Pessoa Pessoa : allPessoas) {
				Pessoa friendSelected = findRandomPeople(Pessoa.getId(), sortitionPessoa);
				result.put(Pessoa, friendSelected);
				sortitionPessoa.remove(friendSelected);
			}

			return result;
		} catch (Exception e) {
			throw new Exception("Erro");
		}
	}

	protected Pessoa findRandomPeople(final Long id, final List<Pessoa> Pessoas) {
		List<Pessoa> manipulatePessoas = new ArrayList<Pessoa>();
		manipulatePessoas.addAll(Pessoas);

		Long randomPeopleId = id;
		Integer randomValue = null;

		Random random = new Random();
		while (Objects.equals(randomPeopleId, id)) {
			randomValue = random.nextInt(manipulatePessoas.size());
			randomPeopleId = manipulatePessoas.get(randomValue).getId();
		}

		Pessoa selectPessoa = manipulatePessoas.get(randomValue);
		manipulatePessoas.remove(selectPessoa);

		return selectPessoa;
	}

}