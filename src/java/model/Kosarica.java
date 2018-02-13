package model;

import java.util.ArrayList;
import java.util.List;

public class Kosarica
{
    List<Stavka> stavke;
    int kolicina;
    double ukupnaCijena;

    public Kosarica()
    {
        stavke = new ArrayList<Stavka>();
        kolicina = 0;
        ukupnaCijena = 0;
    }
    
    
    public void dodajStavku(Proizvod proizvod)
    {
        boolean novaStavka = true;

        for (Stavka st : stavke)
        {

            if (st.getProizvod().getIdProizvod()== proizvod.getIdProizvod())
            {
                novaStavka = false;
                st.povecajKolicinu();
            }
        }

        if (novaStavka)       
        {
            Stavka stavka = new Stavka(proizvod);
            stavke.add(stavka);
        }
    }
    
    public void azuriraj(Proizvod proizvod, String kolicina)
    {
        int kol = -1;
        kol = Integer.parseInt(kolicina);
        if (kol >= 0) {

            Stavka stavka = null;

            for (Stavka st : stavke)
            {
                if (st.getProizvod().getIdProizvod()== proizvod.getIdProizvod())               
                {
                    if (kol != 0)
                    {
                        st.setKolicina(kol);
                    }                  
                    else
                    {
                        stavka = st;
                        break;
                    }
                }
            }

            if (stavka != null)
            {
                // remove from cart
                stavke.remove(stavka);
            }
        }
    }
    
    public List<Stavka> getStavke()
    {
        return stavke;
    }
    
    public int getKolicina()
    {
        int n = 0;

        for (Stavka st : stavke)
        {

            kolicina += st.getKolicina();
        }
        return kolicina;
    }
    
    public double getUkupnaCijena()
    {
        for(Stavka st : stavke)
        {
            ukupnaCijena = ukupnaCijena + st.getUkupnaCijena();
        }
        
        return ukupnaCijena;
    }
    
    public void isprazniKosaricu()
    {
        stavke.clear();
        kolicina = 0;
        ukupnaCijena = 0;
    }
}
