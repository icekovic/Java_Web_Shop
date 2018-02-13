package model;

public class Admin
{
    private int idAdmin;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;

    public Admin()
    {
        
    }

    public Admin(int idAdmin, String ime, String prezime, String korisnickoIme, String lozinka)
    {
        this.idAdmin = idAdmin;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }
    
    public int getIdAdmin()
    {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin)
    {
        this.idAdmin = idAdmin;
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
    
    
    
}
