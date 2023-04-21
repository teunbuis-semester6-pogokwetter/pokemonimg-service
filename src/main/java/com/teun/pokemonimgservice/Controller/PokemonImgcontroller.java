package com.teun.pokemonimgservice.Controller;

import com.teun.pokemonimgservice.Model.PokemonImg;
import com.teun.pokemonimgservice.Service.PokemonImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/pokemonimg")
public class PokemonImgcontroller {

    @Autowired
    PokemonImgService service;

    @GetMapping
    public ResponseEntity<List<PokemonImg>> getAllPkmnImg(){
        try{
            List<PokemonImg> pokemonImgs = service.findAllPokemonImgs();
            if(pokemonImgs != null){
                return ResponseEntity.ok().body(pokemonImgs);
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<byte[]> getPkmnImgById(@PathVariable(value = "id") int id){
        try{
            PokemonImg pokemonImg = service.findPokemonImgById(id);
            if(pokemonImg != null){
                byte[] image = pokemonImg.getPokemonpicture();
                return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(image);
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Integer> uploadPkmnImg(@RequestParam MultipartFile multipartImage){

        try{
            PokemonImg pokemonImg =new PokemonImg();
            pokemonImg.setPokemonid(1);
            pokemonImg.setPokemonpicture(multipartImage.getBytes());
            int id = service.savePokemonImg(pokemonImg);
            return ResponseEntity.ok().body(id);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }

}
