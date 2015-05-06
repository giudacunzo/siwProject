import java.util.Date;

public class Cliente{
    private String nome;
    private String cognome;
    private Date dataNascita;
    private Date dataRegistraziode;
    private String posta;

    public Cliente(String nome, String cognome, Date dataNascita, String posta) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.posta = posta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public Date getDataRegistraziode() {
        return dataRegistraziode;
    }

    public void setDataRegistraziode(Date dataRegistraziode) {
        this.dataRegistraziode = dataRegistraziode;
    }

    public String getPosta() {
        return posta;
    }

    public void setPosta(String posta) {
        this.posta = posta;
    }
}