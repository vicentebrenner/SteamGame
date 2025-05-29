package com.sinodal.SteamgameVicente.controller;

import com.sinodal.SteamgameVicente.model.Conquista;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/conquistas")
@RequiredArgsConstructor
public class ConquistaController {
    private final List<Conquista> conquistas = new ArrayList<>();

    @PostMapping
    public Conquista criarConquista(@RequestParam String nome) {
        Conquista conquista = new Conquista(nome);
        conquistas.add(conquista);
        return conquista;
    }

    @GetMapping
    public List<Conquista> listarConquistas() {
        return conquistas;
    }

    @PutMapping("/{id}/obter")
    public void obterConquista(@PathVariable int id) {
        Conquista conquista = conquistas.get(id);
        conquista.obterConquista();
    }
}
