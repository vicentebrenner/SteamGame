package main.java.com.sinodal.SteamGameVicente.controller;

import com.sinodal.SteamgameVicente.model.Genero;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/genero")
@RequiredArgsConstructor
public class GeneroController {
    private final List<Genero> generos = new ArrayList<>();

    @PostMapping("/criar")
    public Genero criarGenero(@RequestBody Genero genero) {
        generos.add(genero);
        return genero;
    }

    @GetMapping("/listar")
    public List<Genero> listarGeneros() {
        return generos;
    }

    @DeleteMapping("/remover/{nome}")
    public String removerGenero(@PathVariable String nome) {
        generos.removeIf(g -> g.getNome().equalsIgnoreCase(nome));
        return "Genero removido: " + nome;
    }
}
