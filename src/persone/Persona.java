package persone;

import java.time.LocalDate;

public class Persona {
    //(mail, nome, cognome, che permettono calcolare il CF)
    //  private int id;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String luogoNascita;
    private String sesso;
    private String mail;
    private char[] cf = new char[16];

    public Persona(String cognome, String nome, LocalDate dataNascita, String luogoNascita, String sesso, String mail) {
        this.cognome = cognome;
        this.nome = nome;
        this.dataNascita = dataNascita;
        this.luogoNascita = luogoNascita;
        this.sesso = sesso;
        this.mail = mail;
        this.cf = calcolaCodiceFiscale();
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

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public char[] getCf() {
        return cf;
    }

    public char[] calcolaCodiceFiscale() {
        return new char[16];
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
