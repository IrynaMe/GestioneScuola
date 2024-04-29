package persone;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Persona {
    //(mail, nome, cognome, che permettono calcolare il CF)
  //  private int id;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String sesso;
    private String mail;

    public Persona( String cognome, String nome, LocalDate dataNascita, String sesso, String mail) {
        this.cognome = cognome;
        this.nome = nome;
        this.dataNascita = dataNascita;
        this.sesso = sesso;
        this.mail = mail;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public String getSesso() {
        return sesso;
    }

    public String getMail() {
        return mail;
    }

    public String calcolaCodiceFiscale() {

        String cognomeCodice = (cognome.length() >= 3) ? cognome.substring(0, 3).toUpperCase() : cognome.toUpperCase();

        String nomeCodice = (nome.length() >= 3) ? nome.substring(0, 3).toUpperCase() : nome.toUpperCase();
        int annoNascita = dataNascita.getYear() % 100; // 2 ultimi numeri dell'anno
        int meseNascita = dataNascita.getMonthValue();
        int giornoNascita = dataNascita.getDayOfMonth();
        String sessoCodice = (sesso.toUpperCase().equals("M")) ? "0" : "1";//0 -m, 1-f

        // CF
        String codiceFiscale = cognomeCodice + nomeCodice +
                String.format("%02d", annoNascita) +
                String.format("%02d", meseNascita) +
                String.format("%02d", giornoNascita) +
                sessoCodice;

        return codiceFiscale;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", sesso='" + sesso + '\'' +
                ", mail='" + mail;
    }
}
