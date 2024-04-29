package scuola;

import persone.Allievo;
import persone.Docente;
import persone.Persona;
import persone.Segretario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Scuola {
    private List<Allievo> allievi=new ArrayList<>();
    private List<Docente> docenti=new ArrayList<>();
    private List<Segretario> segretari=new ArrayList<>();

    public Persona inputDatiPersona() {
        Scanner sc = new Scanner(System.in);
        String regexCognomeNome = "^[a-zA-Z]{2,20}$";
        String regexDataNascita = "^\\d{2}-\\d{2}-\\d{4}$";
        String regexSesso = "^[mfMF]$";
        String regexMail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String cognome;
        String nome;
        String dataNascita;
        String sesso;
        String mail;

        //cognome
        do {
            System.out.println("Inserisci cognome: almeno 2 caratteri");
            cognome = sc.nextLine();
            if (!Pattern.matches(regexCognomeNome, cognome)) {
                System.out.println("Formato non valido. Inserisci almeno 2 caratteri");
            }
        } while (!Pattern.matches(regexCognomeNome, cognome));

        //nome
        do {
            System.out.println("Inserisci nome: almeno 2 caratteri");
            nome = sc.nextLine();
            if (!Pattern.matches(regexCognomeNome, nome)) {
                System.out.println("Formato non valido. Inserisci almeno 2 caratteri");
            }
        } while (!Pattern.matches(regexCognomeNome, nome));

        //data di nascita
        do {
            System.out.println("Inserisci data di nascita nel formato DD-MM-YYYY");
            dataNascita = sc.nextLine();
            if (!Pattern.matches(regexDataNascita, dataNascita)) {
                System.out.println("Formato non valido. Inserisci la data nel formato DD-MM-YYYY.");
            }
        } while (!Pattern.matches(regexDataNascita, dataNascita));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dataNascitaFormattata = LocalDate.parse(dataNascita, formatter);

        //sesso
        do {
            System.out.println("Inserisci sesso: m oppure f");
            sesso = sc.nextLine();
            if (!Pattern.matches(regexSesso, sesso)) {
                System.out.println("Formato non valido. Inserisci m oppure f");
            }
        } while (!Pattern.matches(regexSesso, sesso));

        //mail
        do {
            System.out.println("Inserisci l'indirizzo email:");
            mail = sc.nextLine();
            if (!mail.matches(regexMail)) {
                System.out.println("Formato non valido, inserisci la mail correttamente");
            }
        } while (!mail.matches(regexMail));

        return new Persona(cognome, nome, dataNascitaFormattata, sesso, mail);
    }

    public Allievo inputDatiAllievo() {
        Persona persona = inputDatiPersona();
        Scanner sc = new Scanner(System.in);
        String regexClasse = "^[1-9]$";
        String regexSezione = "^[a-zA-Z]$";
        String classe;
        String sezione;

        //classe
        do {
            System.out.println("Inserisci il numero di classe (1-9):");
            classe = sc.nextLine();
            if (!classe.matches(regexClasse)) {
                System.out.println("Formato non valido. Inserisci un numero tra 1 e 9.");
            }
        } while (!classe.matches(regexClasse));
        int iClasse = Integer.valueOf(classe);


        //sezione
        do {
            System.out.println("Inserisci la sezione (lettere da A a Z):");
            sezione = sc.nextLine();
            if (!sezione.matches(regexSezione)) {
                System.out.println("Formato non valido. Inserisci una lettera da A a Z.");
            }
        } while (!sezione.matches(regexSezione));
        return new Allievo(persona.getCognome(), persona.getNome(), persona.getDataNascita(), persona.getSesso(), persona.getMail(), iClasse, sezione);
    }


    public void inserisciAllievo() {
        allievi.add(inputDatiAllievo());
        System.out.println("Hai inserito un nuovo allievo.");
    }

    public Docente inputDatiDocente() {
        Persona persona = inputDatiPersona();
        Scanner sc = new Scanner(System.in);
        Docente docente = new Docente(persona.getCognome(), persona.getNome(), persona.getDataNascita(), persona.getSesso(), persona.getMail());
        return docente;
    }

    public void inserisciDocente() {
        docenti.add(inputDatiDocente());
        System.out.println("Hai inserito un nuovo docente.");
    }

    public Docente cercaDocentePerId(int id) {
        Docente docenteCercato = null;
        for (Docente docente : docenti) {
            if (docente.getId() == id) {
                docenteCercato = docente;
            }
        }
        if (docenteCercato == null) {
            System.out.println("Docente non trovato");
        }
        return docenteCercato;
    }

    public void aggiungiMaterie(int id) {
        Scanner sc = new Scanner(System.in);
        String materia;
        String regexMateria = "^[a-zA-Z]{2,20}$";
        Docente docente = cercaDocentePerId(id);

        int scelta=-1;
        do {
            try {
                System.out.println("1->Inserisci materia, 0->Torna al menu");
                scelta = sc.nextInt();
                sc.nextLine();
                switch (scelta) {
                    case 1:
                        System.out.println("Inserisci materia: almeno 2 caratteri");
                        materia = sc.nextLine();
                        if (!Pattern.matches(regexMateria, materia)) {
                            System.out.println("Formato non valido. Inserisci almeno 2 caratteri");
                        } else {
                            docente.getMaterieInsegnate().add(materia);
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Scelta non valida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Inserimento non valido. Inserisci un numero intero");

            }
        } while (scelta != 0);
    }

    public void stampaClasse(int classe, String sezione) {
        for (Allievo allievo : allievi) {
            if (allievo.getClasse() == classe && allievo.getSezione().equals(sezione)) {
                System.out.println(allievo.toString());
            }
        }
    }
    private void stampaDocenti() {
        for(Docente docente:docenti){
            System.out.println(docente.toString());
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int scelta = 0;
        do {
            System.out.println("1->Inserisci nuovo allievo");
            System.out.println("2->Inserisci nuovo docente");
            System.out.println("3->Aggiungi materie al docente");
            System.out.println("4->Stampa classe");
            System.out.println("5->Stampa docenti");
            System.out.println("6->Esci");

            String input = sc.nextLine();
            try {
                scelta = Integer.parseInt(input);
                switch (scelta) {
                    case 1:
                        inserisciAllievo();
                        break;
                    case 2:
                        inserisciDocente();
                        break;
                    case 3:
                        try {
                            System.out.println("Inserisci ID del docente");
                            int id = Integer.parseInt(sc.nextLine());
                            aggiungiMaterie(id);
                        } catch (NumberFormatException e) {
                            System.out.println("Inserimento non valido");
                        }
                        break;
                    case 4:
                        try {
                            System.out.println("Inserisci classe");
                            int classe = Integer.parseInt(sc.nextLine());
                            System.out.println("Inserisci sezione");
                            String sezione = sc.nextLine();
                            stampaClasse(classe, sezione);
                        } catch (NumberFormatException e) {
                            System.out.println("Inserimento non valido");
                        }
                        break;
                    case 5:
                        stampaDocenti();
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Scelta non valida");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Inserimento non valido");
            }
        } while (scelta != 6);

        sc.close();
    }


}//
