package Estudos.LinguagensDev.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Nome do BD gerado no MongoDb
@Document(collection = "principaisLinguagens")


// Atributos
public class Linguagem {

    @Id
    private String id;
    private String title;
    private String image;
    private int ranking;


    public Linguagem(){
        
    }

    
    // Coleta dados MongoBD 
    public Linguagem(String title, String image, int ranking) {
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }

    public String getTitle() {
        return title;
    }
    public String getImage() {
        return image;
    }
    public int getRanking() {
        return ranking;
    }

    public void setId(String id){
        this.id = id;
    }

    
    
}
