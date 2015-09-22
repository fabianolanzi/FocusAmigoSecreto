package focusnetworks.sortear;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import focusnetworks.pessoa.Pessoa;

/*Adapter*/
public class SortearAdapter {
    public List<Sortear> from(Map<Pessoa, Pessoa> people) {
        ArrayList<Sortear> dtos = new ArrayList<Sortear>();
        for (Map.Entry<Pessoa, Pessoa> entry : people.entrySet()) {
            Sortear sortitionDTO = new Sortear(entry.getKey(), entry.getValue());
            dtos.add(sortitionDTO);
        }
        return dtos;
    }
}
