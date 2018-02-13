package model;

public class Stavka
{
    Proizvod proizvod;
    int kolicina;

    public Stavka(Proizvod proizvod)
    {
        this.proizvod = proizvod;
        kolicina = 1;
    }

    public Proizvod getProizvod()
    {
        return proizvod;
    }

    public int getKolicina()
    {
        return kolicina;
    }

    public void setKolicina(int kolicina)   
    {
        this.kolicina = kolicina;
    }
    
    public void povecajKolicinu() {
        kolicina++;
    }

    public void smanjiKolicinu() {
        kolicina--;
    }

    public double getUkupnaCijena() {
        double ukupnaCijena = 0;
        ukupnaCijena = (this.getKolicina()* proizvod.getCijena());
        return ukupnaCijena;
    }
}