package Estudos.LinguagensDev.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LinguagensController {

     // Dados linguagens , atualizado para puxar do MongoDb
    //private List<Linguagem> linguagens = 
        //List.of(
          // new Linguagem("Java", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png", 1),
          //  new Linguagem("PHP", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/php/php_256x256.png", 2)
       // );
    


       // CRUD Abaixo 

    // Lista melhor linguagem teste  JAVA
    @GetMapping(value = "/linguagem-favorita")
    public String processaLinguagemFavorita(){
        return "Hello, Java!";
    }

    @Autowired
    private LinguagemRepository repositorio;

    // Lista linguagens  API 
    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens(){
        List<Linguagem> linguagens = repositorio.findByOrderByRanking();
        return linguagens;
    }
    
    // Gera nova linguagem via Postman 
    @PostMapping("/linguagens")
    public ResponseEntity <Linguagem> NovaLinguagem (@RequestBody Linguagem linguagem){
        Linguagem linguagemSalva = repositorio.save(linguagem);
        return new ResponseEntity<Linguagem>(linguagemSalva, HttpStatus.CREATED) ;
    }

    // Busca por Id Postman
    @GetMapping("/linguagens/{id}")
    public Linguagem obterLinguagemPorId(@PathVariable String id){
        return repositorio.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    
    // Atualizar linguagem
    @PutMapping("/linguagens/{id}")
    public Linguagem atualizarLinguagem(@PathVariable String id,  @RequestBody Linguagem linguagem){
        if(!repositorio.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Linguagem linguagemSalva = repositorio.save(linguagem);
        return linguagemSalva;
    }
    
    // Delete Linguagem

    @DeleteMapping("/linguagens/{id}")
    public void deletalinguagem(@PathVariable String id,  @RequestBody Linguagem linguagem){
        repositorio.deleteById(id);
    }

    
    
}