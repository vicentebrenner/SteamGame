package main.java.com.sinodal.SteamGameVicente.controller;

import com.sinodal.SteamgameVicente.model.ContaSteam;
import com.sinodal.SteamgameVicente.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/contas")
@RequiredArgsConstructor
public class ContaSteamController {
    private final List<ContaSteam> contas = new ArrayList<>();

    @PostMapping
    public ContaSteam criarContaSteam(@RequestParam String nomeConta) {
        ContaSteam conta = new ContaSteam(nomeConta);
        contas.add(conta);
        return conta;
    }

    @GetMapping
    public List<ContaSteam> listarContas() {
        return contas;
    }

    @PostMapping("/{id}/usuarios")
    public void adicionarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        ContaSteam conta = contas.get(id);
        conta.adicionarUsuario(usuario);
    }
}
