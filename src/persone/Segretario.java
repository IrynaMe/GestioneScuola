package persone;

import java.time.LocalDate;
import java.time.LocalTime;

public class Segretario extends Persona{
    private static int id;

    //orario di lavoro, ufficio
    private LocalTime inizioLavoro;
    private LocalTime fineLavoro;
    private String ufficio;

    public Segretario(String cognome, String nome, LocalDate dataNascita, String sesso, String mail,
                      LocalTime inizioLavoro, LocalTime fineLavoro, String ufficio) {
        super(nome, cognome, dataNascita, sesso, mail);
        this.id=++id;
        this.inizioLavoro = inizioLavoro;
        this.fineLavoro = fineLavoro;
        this.ufficio = ufficio;
    }
}
