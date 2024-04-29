package persone;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Docente extends Persona{
    //lista materia insegnate, calendario delle lezioni
    //calendario delle lezioni (Per adesso String) -giorno della sett, facia oraria, classe, materia
    private static int id;
    private List<String > materieInsegnate=new ArrayList<>();
    private List<Calendario> calendario=new ArrayList<>();

    //senza calendario
    public Docente( String cognome,String nome, LocalDate dataNascita, String sesso, String mail) {
        super(nome, cognome, dataNascita, sesso, mail);
        this.id=++id;
    }

    public int getId() {
        return id;
    }

    public List<String> getMaterieInsegnate() {
        return materieInsegnate;
    }

    public List<Calendario> getCalendario() {
        return calendario;
    }

    private void inserisciVoto(Allievo allievo){

}
    private class Calendario {
        private String giornoSett;
        private LocalTime oraInizio;
        private int classe;
        private char sezione;
        private  String materia;
    }

    @Override
    public String toString() {
        return "Docente: " +
                "id= "+id+
                super.toString()+
                ", materieInsegnate=" + materieInsegnate +
                ", calendario=" + calendario;
    }
}
