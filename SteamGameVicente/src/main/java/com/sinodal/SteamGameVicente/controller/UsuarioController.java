package main.java.com.sinodal.SteamGameVicente.controller;

import com.sinodal.SteamgameVicente.model.Jogo;
import com.sinodal.SteamgameVicente.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final List<Usuario> usuarios = new ArrayList<>();

    @PostMapping
    public Usuario criarUsuario(@RequestParam String nome) {
        Usuario usuario = new Usuario(nome);
        usuarios.add(usuario);
        return usuario;
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    @PostMapping("/{id}/jogos")
    public void adicionarJogoAoUsuario(@PathVariable int id, @RequestBody Jogo jogo) {
        Usuario usuario = usuarios.get(id);
        usuario.adicionarJogo(jogo);
    }
}
