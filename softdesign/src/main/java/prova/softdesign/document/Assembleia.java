package prova.softdesign.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@Document
public class Assembleia {

    @Id
    private String id;
    private String nome;
    private String Assunto;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dataInicio;
    private int duracao;

}
