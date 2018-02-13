package model;

public class Proizvod
{
    private int idProizvod;
    private String naziv;
    private String sifra;
    private double cijena;
    private String detalji;
    private int kategorijaID;
    
    public Proizvod()
    {
        
    }

    public Proizvod(int idProizvod, String naziv, String sifra, double cijena, String detalji, int kategorijaID)
    {
        this.idProizvod = idProizvod;
        this.naziv = naziv;
        this.sifra = sifra;
        this.cijena = cijena;
        this.detalji = detalji;
        this.kategorijaID = kategorijaID;
    }

    public int getIdProizvod()
    {
        return idProizvod;
    }

    public void setIdProizvod(int idProizvod)
    {
        this.idProizvod = idProizvod;
    }

    public String getNaziv()
    {
        return naziv;
    }

    public void setNaziv(String naziv)
    {
        this.naziv = naziv;
    }

    public String getSifra()
    {
        return sifra;
    }

    public void setSifra(String sifra)
    {
        this.sifra = sifra;
    }

    public double getCijena()
    {
        return cijena;
    }

    public void setCijena(double cijena)
    {
        this.cijena = cijena;
    }

    public String getDetalji()
    {
        return detalji;
    }

    public void setDetalji(String detalji)
    {
        this.detalji = detalji;
    }

    public int getKategorijaID()
    {
        return kategorijaID;
    }

    public void setKategorijaID(int kategorijaID)
    {
        this.kategorijaID = kategorijaID;
    }
}
