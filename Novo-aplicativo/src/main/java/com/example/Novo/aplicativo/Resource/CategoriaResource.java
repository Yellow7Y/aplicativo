package com.example.Novo.aplicativo.Resource;

import com.example.Novo.aplicativo.model.Categoria;
import com.example.Novo.aplicativo.repository.CategoriaRepository;

import java.net.URI;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria, HttpServletResponse response) {
        Categoria categoriaSalva = categoriaRepository.save(categoria);

        URI uri = ServletUriComponentesBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(categoriaSalva.getCodigo()).toUti();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(categoriaSalva);
    }

    @GetMapping("/codigo")
    public Categoria buscarPeloCodigo(@PathVariable Long codigo) {
        return categoriaRepository.findById(codigo).orElse(null);
    }
}
