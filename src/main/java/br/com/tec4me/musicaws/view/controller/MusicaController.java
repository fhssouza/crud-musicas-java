package br.com.tec4me.musicaws.view.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tec4me.musicaws.model.Musica;
import br.com.tec4me.musicaws.service.MusicaService;
import br.com.tec4me.musicaws.shared.MusicaDto;

@RestController
@RequestMapping("api/musicas")
public class MusicaController {
    @Autowired
    MusicaService servico;

    @GetMapping
    public ResponseEntity<List<MusicaDto>> listarMusicas() {
        return new ResponseEntity<>(servico.listarMusicas(), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<MusicaDto> cadastrarMusica(@RequestBody MusicaDto musica) {
        return new ResponseEntity<>(servico.cadastrarMusica(musica), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirMusica(@PathVariable String id) {
        servico.excluirMusica(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MusicaDto> atualizarMusica(@PathVariable String id, @RequestBody Musica musica) {
        MusicaDto dto = new ModelMapper().map(musica, MusicaDto.class);
        Optional<MusicaDto> music = servico.atualizarMusicaPorId(id, dto);

        if (music.isPresent()) {
            return new ResponseEntity<>(music.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

    }
}
