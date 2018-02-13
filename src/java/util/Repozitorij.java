package util;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import model.Admin;
import model.Kategorija;
import model.Kupac;
import model.Kupnja;
import model.Proizvod;

public class Repozitorij
{
    private static DataSource kreirajDataSource()
    {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("WebShop");
        dataSource.setUser("sa");
        dataSource.setPassword("SQL");
        dataSource.setPortNumber(1433);

        return dataSource;
    }
    
    public static List<Kategorija> dohvatiKategorije()
    {
        DataSource dataSource = kreirajDataSource();
        List<Kategorija> kategorije = new ArrayList<Kategorija>();
        try
        {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("{CALL DohvatiKategorije()}");
            
            while(resultSet.next())
            {
                
                Kategorija kategorija = new Kategorija(resultSet.getInt("IDKategorija"), resultSet.getString("Naziv"));               
                kategorije.add(kategorija);
            }
            resultSet.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return kategorije;
    }
    
    public static List<Proizvod> dohvatiProizvode(int kategorijaID)
    {
        DataSource dataSource = kreirajDataSource();
        List<Proizvod> proizvodi = new ArrayList<Proizvod>();
        
        try
        {
            Connection connection = dataSource.getConnection();
            CallableStatement statement = connection.prepareCall("{CALL DohvatiProizvode(?)}");
            statement.setInt("KategorijaID", kategorijaID);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next())
            {
                Proizvod proizvod = new Proizvod(resultSet.getInt("IDProizvod"), resultSet.getString("Naziv"), 
                        resultSet.getString("Sifra"), resultSet.getDouble("Cijena"), resultSet.getString("Detalji"), 
                        resultSet.getInt("KategorijaID"));
                proizvodi.add(proizvod);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        return proizvodi;
    }
    
    public static Proizvod dohvatiProizvod(int proizvodID)
    {
        DataSource dataSource = kreirajDataSource();
        Proizvod proizvod = null;
        
        try
        {
            Connection connection = dataSource.getConnection();
            CallableStatement statement = connection.prepareCall("{CALL DohvatiProizvod(?)}");
            statement.setInt("ProizvodID", proizvodID);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next())
            {
                proizvod = new Proizvod(resultSet.getInt("IDProizvod"), resultSet.getString("Naziv"), 
                        resultSet.getString("Sifra"), resultSet.getDouble("Cijena"), resultSet.getString("Detalji"), 
                        resultSet.getInt("KategorijaID"));
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return proizvod;
    }
    
    public static Kategorija dohvatiKategoriju(int kategorijaID)
    {
        DataSource dataSource = kreirajDataSource();
        Kategorija kategorija = null;
        
        try
        {
            Connection connection = dataSource.getConnection();
            CallableStatement statement = connection.prepareCall("{CALL DohvatiKategoriju(?)}");
            statement.setInt("KategorijaID", kategorijaID);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next())
            {
                kategorija = new Kategorija(resultSet.getInt("IDKategorija"), resultSet.getString("Naziv"));
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return kategorija;
    }
    
    public static void umetniKupca(Kupac kupac)
    {
        DataSource dataSource = kreirajDataSource();
        
        try
        {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("{CALL UmetniKupca(?, ?, ?, ?, ?, ?)}");
            statement.setString(1, kupac.getIme());
            statement.setString(2, kupac.getPrezime());
            statement.setString(3, kupac.getEmail());
            statement.setString(4, kupac.getAdresa());
            statement.setString(5, kupac.getKorisnickoIme());
            statement.setString(6, kupac.getLozinka());
            statement.executeUpdate();
        }
        
        catch (SQLException ex)      
        {
            ex.printStackTrace();
        }
    }
    
    public static boolean provjeriKorisnickePodatke(String korisnickoIme, String lozinka)
    {
        DataSource dataSource = kreirajDataSource();
        try
        {
            Connection connection = dataSource.getConnection();
            CallableStatement statement = connection.prepareCall("{CALL ProvjeriKorisnickePodatke(?, ?)}");
            statement.setString("KorisnickoIme", korisnickoIme);
            statement.setString("Lozinka", lozinka);
            ResultSet resultSet = statement.executeQuery();
            
            if(resultSet != null && resultSet.next())
            {
                return true;
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public static boolean provjeriAdminPodatke(String korisnickoIme, String lozinka)
    {
        DataSource dataSource = kreirajDataSource();
        try
        {
            Connection connection = dataSource.getConnection();
            CallableStatement statement = connection.prepareCall("{CALL ProvjeriAdminPodatke(?, ?)}");
            statement.setString("KorisnickoIme", korisnickoIme);
            statement.setString("Lozinka", lozinka);
            ResultSet resultSet = statement.executeQuery();
            
            if(resultSet != null && resultSet.next())
            {
                return true;
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public static Kupac dohvatiKupca(String korisnickoIme, String lozinka)
    {
        DataSource dataSource = kreirajDataSource();
        Kupac kupac = null;
        
        try
        {
            Connection connection = dataSource.getConnection();
            CallableStatement statement = connection.prepareCall("{CALL DohvatiKorisnickePodatke(?, ?)}");
            statement.setString("KorisnickoIme", korisnickoIme);
            statement.setString("Lozinka", lozinka);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next())
            {
                kupac = new Kupac(resultSet.getInt("IDKupac"), resultSet.getString("Ime"), resultSet.getString("Prezime"), resultSet.getString("Email"),
                resultSet.getString("Adresa"), resultSet.getString("KorisnickoIme"), resultSet.getString("Lozinka"));
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return kupac;
    }
    
    public static int umetniKupnju(int kupacId, String nacinPlacanja, Timestamp vrijemeKupnje)
    {
        DataSource dataSource = kreirajDataSource();
        ResultSet scopeIdentity = null;
        int idKupnja = 0;
         
        try
        {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("{CALL UmetniKupnju(?, ?, ?)}", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, kupacId);
            statement.setString(2, nacinPlacanja);
            statement.setObject(3, vrijemeKupnje);
            statement.executeUpdate();
            scopeIdentity = statement.getGeneratedKeys();
            if(scopeIdentity.next())
            {
                idKupnja = scopeIdentity.getInt(1);
            }
        }
        
        catch (SQLException ex)      
        {
            ex.printStackTrace();
        }
        
        return idKupnja;
    }
    
    public static void umetniStavku(int kupnjaId, int proizvodId)
    {
        DataSource dataSource = kreirajDataSource();
        
        try
        {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("{CALL UmetniStavku(?, ?)}");
            statement.setInt(1, kupnjaId);
            statement.setInt(2, proizvodId);
            statement.executeUpdate();
        }
        
        catch (SQLException ex)      
        {
            ex.printStackTrace();
        }
    }
    
    public static Admin dohvatiAdminPodatke(String korisnickoIme, String lozinka)
    {
        DataSource dataSource = kreirajDataSource();
        Admin admin = null;
        
        try
        {
            Connection connection = dataSource.getConnection();
            CallableStatement statement = connection.prepareCall("{CALL DohvatiAdminPodatke(?, ?)}");
            statement.setString(1, korisnickoIme);
            statement.setString(2, lozinka);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next())
            {
                admin = new Admin(resultSet.getInt("IDAdministrator"), resultSet.getString("Ime"), resultSet.getString("Prezime"),
                        resultSet.getString("KorisnickoIme"), resultSet.getString("Lozinka"));
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return admin;
    }
    
    public static List<Kupnja> dohvatiKupnjePojedinogKupca(int kupacId)
    {
        DataSource dataSource = kreirajDataSource();
        Kupnja kupnja = null;
        List<Kupnja> kupnje = new ArrayList<>();
        
        try
        {
            Connection connection = dataSource.getConnection();
            CallableStatement statement = connection.prepareCall("{CALL DohvatiKupnjePojedinogKupca(?)}");
            statement.setInt("KupacID", kupacId);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next())
            {
                kupnja = new Kupnja();
                kupnja.setNazivProizvoda(resultSet.getString("Naziv"));
                kupnja.setVrijemeKupnje(resultSet.getTimestamp("VrijemeKupnje"));
                kupnja.setNacinPlacanja(resultSet.getString("NacinPlacanja"));
                kupnje.add(kupnja);
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return kupnje;
    }
    
    public static List<Kupnja> dohvatiSveKupnje()
    {
        DataSource dataSource = kreirajDataSource();
        Kupnja kupnja = null;
        List<Kupnja> kupnje = new ArrayList<>();
        
        try
        {
            Connection connection = dataSource.getConnection();
            CallableStatement statement = connection.prepareCall("{CALL DohvatiSveKupnje()}");
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next())
            {
                kupnja = new Kupnja();
                kupnja.setImeKupca(resultSet.getString("Ime"));
                kupnja.setPrezimeKupca(resultSet.getString("Prezime"));
                kupnja.setNazivProizvoda(resultSet.getString("Naziv"));
                kupnja.setCijenaProizvoda(resultSet.getDouble("Cijena"));
                kupnja.setDetaljiProizvoda(resultSet.getString("Detalji"));
                kupnja.setVrijemeKupnje(resultSet.getTimestamp("VrijemeKupnje"));
                kupnja.setNacinPlacanja(resultSet.getString("NacinPlacanja"));
                kupnje.add(kupnja);
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return kupnje;
    }
    
    public static List<Kupnja> pretraziPoKupcu(String ime, String prezime)
    {
        DataSource dataSource = kreirajDataSource();
        Kupnja kupnja = null;
        List<Kupnja> kupnje = new ArrayList<>();
        
        try
        {
            Connection connection = dataSource.getConnection();
            CallableStatement statement = connection.prepareCall("{CALL PretraziPoKupcu(?, ?)}");
            statement.setString("Ime", ime);
            statement.setString("Prezime", prezime);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next())
            {
                kupnja = new Kupnja();
                kupnja.setImeKupca(resultSet.getString("Ime"));
                kupnja.setPrezimeKupca(resultSet.getString("Prezime"));
                kupnja.setNazivProizvoda(resultSet.getString("Naziv"));
                kupnja.setCijenaProizvoda(resultSet.getDouble("Cijena"));
                kupnja.setVrijemeKupnje(resultSet.getTimestamp("VrijemeKupnje"));
                kupnja.setNacinPlacanja(resultSet.getString("NacinPlacanja"));
                kupnje.add(kupnja);
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return kupnje;
    }
}