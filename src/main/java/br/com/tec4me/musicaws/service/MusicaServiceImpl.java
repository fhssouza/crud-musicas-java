package br.com.tec4me.musicaws.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tec4me.musicaws.model.Musica;
import br.com.tec4me.musicaws.repository.MusicaRepository;
import br.com.tec4me.musicaws.shared.MusicaDto;

@Service
public class MusicaServiceImpl implements MusicaService {
    @Autowired
    MusicaRepository repositorio;

    @Override
    public List<MusicaDto> listarMusicas() {
        List<Musica> musica = repositorio.findAll();

        return musica.stream()
            .map(m -> new ModelMapper().map(m, MusicaDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public MusicaDto cadastrarMusica(MusicaDto musica) {
        ModelMapper mapper = new ModelMapper();
        Musica salvarMusica = mapper.map(musica, Musica.class);
        salvarMusica = repositorio.save(salvarMusica);
        return mapper.map(salvarMusica, MusicaDto.class);
    }

    @Override
    public void excluirMusica(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public Optional<MusicaDto> atualizarMusicaPorId(String id, MusicaDto musica) {
        ModelMapper mapper = new ModelMapper();
        Optional<Musica> music = repositorio.findById(id);
        Musica salvarMusica = mapper.map(musica, Musica.class);

        if (music.isPresent()){
            salvarMusica.setId(id);
            salvarMusica = repositorio.save(salvarMusica);
            return Optional.of(mapper.map(salvarMusica, MusicaDto.class));
        }
        return Optional.empty();
    }
 
}


