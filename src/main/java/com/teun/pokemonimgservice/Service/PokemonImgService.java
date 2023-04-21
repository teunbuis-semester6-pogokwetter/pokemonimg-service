package com.teun.pokemonimgservice.Service;

import com.teun.pokemonimg.Model.PokemonImg;
import com.teun.pokemonimg.Repo.PokemonImgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonImgService {

    @Autowired
    PokemonImgRepo repo;

    public List<PokemonImg> findAllPokemonImgs(){
        return repo.findAll();
    }
    public PokemonImg findPokemonImgById(int id){

        return repo.findById(id).orElse(null);
    }
    public int savePokemonImg(PokemonImg pokemonImg){

        return repo.save(pokemonImg).getId();
    }
}
