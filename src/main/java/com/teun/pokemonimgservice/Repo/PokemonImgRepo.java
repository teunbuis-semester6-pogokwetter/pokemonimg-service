package com.teun.pokemonimgservice.Repo;

import com.teun.pokemonimg.Model.PokemonImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PokemonImgRepo extends JpaRepository<PokemonImg, Integer> {
    Optional<PokemonImg> findById(int id);
}
