package main.java.com.sinodal.SteamGameVicente.controller;

import com.sinodal.SteamgameVicente.model.Conquista;
import com.sinodal.SteamgameVicente.model.Jogo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/jogos")
@RequiredArgsConstructor
public class JogoController {
    private final List<Jogo> jogos = new ArrayList<>();

    @PostMapping
    public Jogo criarJogo(@RequestParam String titulo) {
        Jogo jogo = new Jogo(titulo, new ArrayList<>(), 0.0, 0.0);
        jogos.add(jogo);
        return jogo;
    }

    @GetMapping
    public List<Jogo> listarJogos() {
        return jogos;
    }

    @PostMapping("/{id}/conquistas")
    public void adicionarConquista(@PathVariable int id, @RequestBody Conquista conquista) {
        Jogo jogo = jogos.get(id);
        jogo.adicionarConquista(conquista);
    }

    @PutMapping("/{id}/tempo")
    public void atualizarTempoDeJogo(@PathVariable int id, @RequestParam double horas) {
        Jogo jogo = jogos.get(id);
        jogo.atualizarTempoDeJogo(horas);
    }
}
