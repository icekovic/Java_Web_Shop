package model;

import java.sql.Timestamp;

public class Kupnja
{
    private int idKupnja;
    private String imeKupca;
    private String prezimeKupca;
    private Timestamp vrijemeKupnje;
    private String nazivProizvoda;
    private double cijenaProizvoda;
    private String detaljiProizvoda;
    private String nacinPlacanja;

    public Kupnja()
    {
        
    }

    public Kupnja(int idKupnja, String imeKupca, String prezimeKupca, Timestamp vrijemeKupnje, 
            String nazivProizvoda, double cijenaProizvoda, String detaljiProizvoda, String nacinPlacanja)
    {
        this.idKupnja = idKupnja;
        this.imeKupca = imeKupca;
        this.prezimeKupca = prezimeKupca;
        this.vrijemeKupnje = vrijemeKupnje;
        this.nazivProizvoda = nazivProizvoda;
        this.cijenaProizvoda = cijenaProizvoda;
        this.detaljiProizvoda = detaljiProizvoda;
        this.nacinPlacanja = nacinPlacanja;
    }

    public int getIdKupnja()
    {
        return idKupnja;
    }

    public void setIdKupnja(int idKupnja)
    {
        this.idKupnja = idKupnja;
    }

    public String getImeKupca()
    {
        return imeKupca;
    }

    public void setImeKupca(String imeKupca)
    {
        this.imeKupca = imeKupca;
    }

    public String getPrezimeKupca()
    {
        return prezimeKupca;
    }

    public void setPrezimeKupca(String prezimeKupca)
    {
        this.prezimeKupca = prezimeKupca;
    }

    public Timestamp getVrijemeKupnje()   
    {
        return vrijemeKupnje;
    }

    public void setVrijemeKupnje(Timestamp vrijemeKupnje)   
    {
        this.vrijemeKupnje = vrijemeKupnje;
    }

    public String getNazivProizvoda()
    {
        return nazivProizvoda;
    }

    public void setNazivProizvoda(String nazivProizvoda)
    {
        this.nazivProizvoda = nazivProizvoda;
    }

    public double getCijenaProizvoda()
    {
        return cijenaProizvoda;
    }

    public void setCijenaProizvoda(double cijenaProizvoda)   
    {
        this.cijenaProizvoda = cijenaProizvoda;
    }

    public String getDetaljiProizvoda()  
    {
        return detaljiProizvoda;
    }

    public void setDetaljiProizvoda(String detaljiProizvoda)
    {
        this.detaljiProizvoda = detaljiProizvoda;
    }

    public String getNacinPlacanja()
    {
        return nacinPlacanja;
    }

    public void setNacinPlacanja(String nacinPlacanja)
    {
        this.nacinPlacanja = nacinPlacanja;
    }
    
    
}
