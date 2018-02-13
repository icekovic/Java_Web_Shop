package model;

public class Kategorija
{
    private int idKategorija;
    private String naziv;

    public Kategorija()
    {
        
    }
    
    public Kategorija(int idKategorija, String naziv)
    {
        this.idKategorija = idKategorija;
        this.naziv = naziv;
    }

    public int getIdKategorija()
    {
        return idKategorija;
    }

    public void setIdKategorija(int idKategorija)
    {
        this.idKategorija = idKategorija;
    }

    public String getNaziv()
    {
        return naziv;
    }

    public void setNaziv(String naziv)
    {
        this.naziv = naziv;
    }
}
