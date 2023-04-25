package com.teun.pokemonimgservice.Service;

import com.teun.pokemonimgservice.Model.PokemonImg;
import com.teun.pokemonimgservice.Repo.PokemonImgRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PokemonImgServiceTest {

    @Mock
    private PokemonImgRepo pokemonImgRepoMock;

    @InjectMocks
    private PokemonImgService pokemonImgService;

    @Test
    void findAllPokemonImgs_GetsAListOfPokemonImgs_ShouldReturnTrue() {
        //assign
        List<PokemonImg> pokemonImgList = new ArrayList<>();
        PokemonImg pokemonImg1 = new PokemonImg();
        PokemonImg pokemonImg2 = new PokemonImg();
        pokemonImgList.add(pokemonImg1);
        pokemonImgList.add(pokemonImg2);
        List<PokemonImg> retrievedList;
        //act
        Mockito.when(pokemonImgRepoMock.findAll()).thenReturn(pokemonImgList);
        retrievedList = pokemonImgRepoMock.findAll();
        //assert
        assert(retrievedList.size() >= 2);
    }

    @Test
    void findPokemonImgById() {
    }

    @Test
    void savePokemonImg() {
    }
}