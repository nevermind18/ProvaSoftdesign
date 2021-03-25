package prova.softdesign.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class Pauta {

    @Id
    private String id;
    private String nome;
    private String assunto;

}
