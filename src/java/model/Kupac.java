package model;

public class Kupac
{
    private int idKupac;
    private String ime;
    private String prezime;
    private String email;
    private String adresa;
    private String korisnickoIme;
    private String lozinka;

    public Kupac()
    {
        
    }

    public Kupac(int idKupac, String ime, String prezime, String email, String adresa, String korisnickoIme, String lozinka)
    {
        this.idKupac = idKupac;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.adresa = adresa;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public int getIdKupac()
    {
        return idKupac;
    }

    public void setIdKupac(int idKupac)
    {
        this.idKupac = idKupac;
    }

    public String getIme()
    {
        return ime;
    }

    public void setIme(String ime)    
    {
        this.ime = ime;
    }

    public String getPrezime()
    {
        return prezime;
    }

    public void setPrezime(String prezime)
    
    {
        this.prezime = prezime;
    }

    public String getEmail()
    
    {
        return email;
    }

    public void setEmail(String email)
    
    {
        this.email = email;
    }

    public String getAdresa()
    
    {
        return adresa;
    }

    public void setAdresa(String adresa)
    
    {
        this.adresa = adresa;
    }

    public String getKorisnickoIme()
    {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme)
    {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka()
    {
        return lozinka;
    }

    public void setLozinka(String lozinka)
    {
        this.lozinka = lozinka;
    }
    
    
}
