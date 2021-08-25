package br.com.tec4me.musicaws.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tec4me.musicaws.model.Musica;

public interface MusicaRepository extends MongoRepository<Musica, String> {
    
}
