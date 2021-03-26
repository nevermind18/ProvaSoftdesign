package prova.softdesign.document;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class Votacao {

    @Id
    private String id;
    private boolean resultado;
    private Double tempoDuracao;
    @DBRef
    private Pauta pauta;

}
