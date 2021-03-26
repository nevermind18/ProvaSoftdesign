package prova.softdesign.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class AssociadoAssembleia {

    @Id
    private String id;
    @DBRef
    private Associado associado;
    @DBRef
    private Assembleia assembleia;
}
