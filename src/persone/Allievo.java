package persone;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Allievo extends Persona {

    //classe, sezione, ha una serie di terne(data, materia, voto(1-10))
    //getMediaVoti
    //getMediaVotiPerMateria
    private static int id = 0;
    private int classe;
    private String sezione;
    List<Voto> voti = new ArrayList<>();

    //senza voti
    public Allievo(String cognome, String nome, LocalDate dataNascita, String luogoNascita, String sesso, String mail,
                   int classe, String sezione) {
        super(nome, cognome, dataNascita, luogoNascita, sesso, mail);
        this.id = ++id;
        this.classe = classe;
        this.sezione = sezione;
    }

    //con voti
    public Allievo(String nome, String cognome, LocalDate dataNascita, String luogoNascita, String sesso, String mail, int classe, String sezione,
                   List<Voto> voti) {
        super(nome, cognome, dataNascita, luogoNascita, sesso, mail);
        this.classe = classe;
        this.sezione = sezione;
        this.voti = voti;
    }

    public double getMediaVoti() {
        float somma = 0;
        for (Voto voto : voti) {
            somma += voto.getVoto();
        }
        if (voti.isEmpty()) {
            return -1;
        } else {
            return somma / voti.size();
        }
    }

    public double getMediaVotiMateria(String materia) {
        float somma = 0;
        int count = 0;
        for (Voto voto : voti) {
            if (voto.getMateria().equals(materia)) {
                somma += voto.getVoto();
                count += 1;
            }
        }
        if (count == 0) {
            return -1;
        } else {
            return somma / count;
        }
    }

    public static int getId() {
        return id;
    }

    public int getClasse() {
        return classe;
    }

    public String getSezione() {
        return sezione;
    }

    public List<Voto> getVoti() {
        return voti;
    }

    private class Voto {
        private LocalDate data;
        private String materia;
        private int voto;

        public LocalDate getData() {
            return data;
        }

        public String getMateria() {
            return materia;
        }

        public int getVoto() {
            return voto;
        }
    }


    @Override
    public String toString() {
        return "Allievo " +
                "id= " + id +
                super.toString() +
                ", classe= " + classe +
                ", sezione= '" + sezione + '\'' +
                ", voti= " + voti;
    }
}//
