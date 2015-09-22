package focusnetworks.pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


@RestController
@RequestMapping("/Pessoa")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    Long post(final @RequestBody @Valid Pessoa Pessoa) throws Exception {
        return service.save(Pessoa).getId();
    }


    @RequestMapping(method = RequestMethod.PUT)
    public void put(final @RequestBody @Valid Pessoa Pessoa) throws Exception {
        service.update(Pessoa);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody PessoaDTO findAll(@RequestParam Integer page, @RequestParam Integer perPage) throws Exception {
        return service.findAll(page, perPage);
    }

    
    @RequestMapping(value = "/advanced_search", method = RequestMethod.GET)
    public @ResponseBody PessoaDTO findByNameAndEmail(@RequestParam String search, @RequestParam Integer page, @RequestParam Integer perPage) throws Exception {
        return service.findByNameOrEmail(search, page, perPage);
    }
    

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) throws Exception {
        service.delete(id);
    }
}
