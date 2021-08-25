package br.com.tec4me.musicaws.service;

import java.util.List;
import java.util.Optional;

import br.com.tec4me.musicaws.shared.MusicaDto;

public interface MusicaService {
    
    List<MusicaDto> listarMusicas();
    MusicaDto cadastrarMusica(MusicaDto musica);
    void excluirMusica(String id);
    Optional<MusicaDto> atualizarMusicaPorId(String id, MusicaDto musica);
    
}
