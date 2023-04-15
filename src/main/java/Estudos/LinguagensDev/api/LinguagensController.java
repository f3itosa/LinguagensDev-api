package Estudos.LinguagensDev.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagensController {
     // Teste GIT 01
    //private List<Linguagem> linguagens = 
        //List.of(
          // new Linguagem("Java", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png", 1),
          //  new Linguagem("PHP", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/php/php_256x256.png", 2)
       // );
    


    @GetMapping(value = "/linguagem-favorita")
    public String processaLinguagemFavorita(){
        return "Hello, Java!";
    }

    @Autowired
    private LinguagemRepository repositorio;

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens(){
        List<Linguagem> linguagens = repositorio.findAll();
        return linguagens;
    }
    
    // Conectar Postman para teste desktop 
    @PostMapping("/linguagens")
    public Linguagem NovaLinguagem (@RequestBody Linguagem linguagem){
        Linguagem linguagemSave = repositorio.save(linguagem);
        return linguagemSave;
    }
    
}