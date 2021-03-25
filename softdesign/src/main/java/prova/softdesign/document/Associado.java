package prova.softdesign.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import javafx.scene.input.DataFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import sun.util.calendar.BaseCalendar;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Document
public class Associado {

    @Id
    private String id;
    private String nome;
    private int cpf;
    private int rg;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dataNasc;

}
