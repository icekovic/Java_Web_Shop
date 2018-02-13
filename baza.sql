create database WebShop
go

use WebShop
go

create table Kategorija
(
	IDKategorija int primary key identity not null,
	Naziv nvarchar(20)
)

create table Proizvod
(
	IDProizvod int primary key identity not null,
	Naziv nvarchar(40),
	Sifra nvarchar(20),
	Cijena money,
	Detalji nvarchar(300),
    KategorijaID int foreign key references Kategorija(IDKategorija)
)

create table Kupac
(
	IDKupac int primary key identity not null,
	Ime nvarchar(20),
	Prezime nvarchar(20),
	Email nvarchar(30),
	Adresa nvarchar(50),
	KorisnickoIme nvarchar(30),
	Lozinka nvarchar(30)
)

create table Kupnja
(
	IDKupnja int primary key identity not null,
	KupacID int foreign key references Kupac(IDKupac),
	NacinPlacanja nvarchar(20),
	VrijemeKupnje datetime
)

create table Stavka
(
	IDStavka int primary key identity not null,
	KupnjaID int foreign key references Kupnja(IDKupnja),
	ProizvodD int foreign key references Proizvod(IDProizvod)
)

create table Administrator
(
	IDAdministrator int primary key identity not null,
	Ime nvarchar(30),
	Prezime nvarchar(20),
	KorisnickoIme nvarchar(30),
	Lozinka nvarchar(30)
)

insert into Kategorija values ('Raèunala')
insert into Kategorija values ('Laptopi')
insert into Kategorija values ('Mobiteli')
insert into Kategorija values ('Tableti')
insert into Kategorija values ('Dodaci')
insert into Kategorija values ('Televizori')

insert into Proizvod values ('Raèunalo INSTAR Master X2 6300', 'IN5300X-XVC-YRX-01', 1893.68, 'AMD 3.40GHz, 4GB, 1000GB, AMD Radeon HD 7480D, DVD-RW', 1)
insert into Proizvod values ('Raèunalo INSTAR Starter J9000', 'J9000-START-XY41', 1630.53, 'Intel Quad-Core up to 2.42GHz, Intel HD Graphics, 4GB, 120GB SSD', 1)
insert into Proizvod values ('Raèunalo INSTAR Play A4 7300 GT', 'P1991-XS01-CCC1', 2630.53, 'AMD A4 3.8GHz, 8GB, 1TB HDD, AMD R7 Radeon 240 2GB, DVD-RW', 1)
insert into Proizvod values ('Raèunalo INSTAR Office SFF XS', 'TUX-TTU1-VCQ', 3209.47, 'Intel Pentium G4500 3.5GHz, 8GB, 240GB SSD, Intel HD Graphics 530, DVD-RW', 1)
insert into Proizvod values ('Raèunalo Dell OptiPlex 3046 MT', 'N009O3046MT+-AF8-WIN-09', 4497.41, 'Intel Core i3-6100 3.7GHz, 4GB DDR4, 500GB HDD, Intel HD Graphics 530, DVD, Win 10 Pro', 1)

insert into Proizvod values ('Notebook HP 250 G5', 'W4M66EA', 1993.75, '15.6+-ACI- HD, Intel Celeron N3060 up to 2.48GHz, 4GB DDR3, 500GB HDD, Intel HD Graphics 400, DVD, DOS', 2)
insert into Proizvod values ('Notebook Asus X540SA-XX381D', 'X540SA-XX381D', 2104.21, '15.6+-ACI- HD, Intel Celeron Quad Core N3160 up to 2.24GHz, 4GB DDR3, 1TB HDD, Intel HD Graphics 400, DVD, DOS', 2)
insert into Proizvod values ('Notebook Lenovo Ideapad 110', '80UD00JKSC', 2893.68, '15.6+-ACI- HD, Intel Core i3-6100U 2.30GHz, 4GB DDR4, 1TB HDD, Intel HD Graphics 520, DVD, DOS', 2)
insert into Proizvod values ('Notebook Acer Aspire ES1-533-P7K6', 'NX.GFTEX.068', 3242.71, '15.6+-ACI- HD, Intel Pentium N4200 Quad Core up to 2.5GHz, 4GB DDR3, 1TB HDD, Intel HD Graphics 505, DVD, Win 10', 2)
insert into Proizvod values ('Notebook Dell Inspiron 3567', '272790614-N0404', 4060.25, '15.6+-ACI- HD, Intel Core i5-7200U up to 3.1GHz, 4GB HDD, 500GB HDD, AMD Radeon R5 M430 2GB, DVD, Linux', 2)

insert into Proizvod values ('Mobitel Huawei Y3 II', '142901', 841.05, '4.5+-ACI- 480 x 854 px, Quad-core 1.0 GHz, 1 GB RAM, 8 GB Memorija, 4G/LTE, microSD, Dual SIM, Android 5.1, Crni', 3)
insert into Proizvod values ('Mobitel LG K4 K120E', 'MOB-0214', 856.33, '4.5+-ACI- IPS 480 x 854 px, Quad-core 1.0 GHz, 1 GB RAM, 8GB Memorija, 4G/LTE, microSD, Android 5.1, Bijeli', 3)
insert into Proizvod values ('Mobitel Lenovo C2 Power', '42255', 1072.63, '5.0+-ACI- IPS 720x1280 px, Quad-core 1.0 GHz, 2 GB RAM, 16 GB Memorija, 4G/LTE, microSD, Dual SIM, Android 6.0, Crni', 3)
insert into Proizvod values ('Mobitel Sony Xperia E5', '02450841', 1436.46, '5.0+-ACI- IPS 720 x 1280 px, Quad-core 1.3 GHz, 1.5 GB RAM, 16 GB Memorija, 4G/LTE, microSD, Android 6.0, Crni', 3)
insert into Proizvod values ('Mobitel Asus Zenfone 3 Max ZC520TL', '101471', 1577.90, '5.2+-ACI- IPS 720 x 1280 px, Quad-core 1.25 GHz, 2 GB RAM, 32 GB Memorija, 4G/LTE, microSD, Dual SIM, Android 6.0, Srebrni', 3)

insert into Proizvod values ('Tablet Acer B1-850-K2FD', '0851645', 977.90, '8.0+-ACI- IPS 1280 x 800, Quad Core 1,3 GHz MT8163 Cortex A53, 1 GB RAM, 16 GB Memorija, Android 5.1, Bijeli', 4)
insert into Proizvod values ('Tablet Acer Iconia One 10', 'ACR-1479', 1193.56, '10.1+-ACI- IPS multitouch, QuadCore MTK MT8163 Cortex A53 1.3GHz, 1GB, 16GB eMMC, WiFi, BT, NFC, GPS, Crni', 4)
insert into Proizvod values ('Tablet Samsung Galaxy Tab E T560', '0410910', 1346.32, '9,6 +-ACI-, LCD, 1280x800, Spreadtrum SC8830A Quad Core, 1,3 GHz, Android OS, 1,5 GB, 8 GB, Crni', 4)
insert into Proizvod values ('Tablet ra+-AQ0-unalo Asus ZenPad Z380M-6B019A', 'Z380M-6B019A', 1188.42, '8+-ACI- IPS multitouch, QuadCore 1.3GHz, 2GB RAM, 16GB EMMC, 2x kamera, GPS, WiFi, Android 5.0, Bijeli', 4)
insert into Proizvod values ('Tablet Lenovo A7600', '59407938', 1577.90, '10.0+-ACI- HD 800 x 1280 px, Quad-core 1.3 GHz, 1 GB RAM, 16 GB Memorija, WiFi, Crni', 4)

insert into Proizvod values ('Slu¹alice Vivanco - SR3 za u+-AWE-i', '2020180', 16.50, 'Naran+-AQ0-aste', 5)
insert into Proizvod values ('Slu¹alice MS SHAKE in-ear s mikrofonom', '0160859', 35.34, 'Crne', 5)
insert into Proizvod values ('Slu¹alice MS BEAT s mikrofonom', '0160577',  52.56, 'Crne', 5)
insert into Proizvod values ('Gamepad PC Speedlink THUNDERSTRIKE', '3010049', 62.10, 'Mat crne', 5)
insert into Proizvod values ('Volan Speedlink Darkfire Racing Wheel', '180.906.003', 298.50, 'PC, PS3, Crni', 5)

insert into Proizvod values('Televizor PHILIPS LED', '02470879', 1968.40, '32" HD LED TV, HDMI x3, USB, T2-HD/S2, A', 6)
insert into Proizvod values('Televizor LG LED', '02370962', 2148.54, '32", HD Ready, HDMI 2x, USB, T2, A', 6)
insert into Proizvod values('Televizor SAMSUNG LED', '02411246', 2620.75, '32" , 1920x1080, HDMI 2, USB 1, DVB-T2/C', 6)
insert into Proizvod values('Televizor PHILIPS LED', '02470862', 3857.00, '43" LED, FHD, Smart TV, WiFi, HDMI 2x, USB 2x, T2-HD/C/S2, A++', 6)
insert into Proizvod values('Televizor Sony LED' , 'sony-kdl49we665bae', 4814.88, 'A 3xhdmi, komponent, 2xusb scart, CI-slot, lan, Wi-Fi', 6)

go

create procedure DohvatiKategorije
as
select*
	from Kategorija

go

create procedure DohvatiProizvode
	@KategorijaID int
as
select*
	from Proizvod where KategorijaID = @KategorijaID

go

create procedure DohvatiProizvod
	@ProizvodID int
as
select*
	from Proizvod where IDProizvod = @ProizvodID

go

create procedure DohvatiKategoriju
	@KategorijaID int
as
select*
	from Kategorija where IDKategorija = @KategorijaID

go

create procedure UmetniKupca
	@Ime nvarchar(20),
	@Prezime nvarchar(20),
	@Email nvarchar(20),
	@Adresa nvarchar(20),
	@KorisnickoIme nvarchar(20),
	@Lozinka nvarchar(20)
as
insert into Kupac values(@Ime, @Prezime,@Email, @Adresa, @KorisnickoIme, @Lozinka)

go

create procedure ProvjeriKorisnickePodatke
	@KorisnickoIme nvarchar(30),
	@Lozinka nvarchar(30)
as
select
	KorisnickoIme, Lozinka from Kupac
where KorisnickoIme = @KorisnickoIme and Lozinka = @Lozinka

go

create procedure ProvjeriAdminPodatke
	@KorisnickoIme nvarchar(30),
	@Lozinka nvarchar(30)
as
select
	KorisnickoIme, Lozinka from Administrator
where KorisnickoIme = @KorisnickoIme and Lozinka = @Lozinka
go

create procedure DohvatiKorisnickePodatke
	@KorisnickoIme nvarchar(30),
	@Lozinka nvarchar(30)
as
select*
	from Kupac
where KorisnickoIme = @KorisnickoIme and Lozinka = @Lozinka

go

create procedure DohvatiAdminPodatke
	@KorisnickoIme nvarchar(30),
	@Lozinka nvarchar(30)
as
select*
	from Administrator
where KorisnickoIme = @KorisnickoIme and Lozinka = @Lozinka

go

create procedure UmetniKupnju
	@KupacID int,
	@NacinPlacanja nvarchar(20),
	@VrijemeKupnje datetime
as
declare @KupnjaID int
insert into Kupnja values(@KupacID, @NacinPlacanja, @VrijemeKupnje)
select SCOPE_IDENTITY()

go

create procedure UmetniStavku
	@KupnjaID int,
	@ProizvodID int
as
insert into Stavka values(@KupnjaID, @ProizvodID)

go

create procedure DohvatiKupnjePojedinogKupca
	@KupacID int
as
select
	Kupnja.IDKupnja, Proizvod.Naziv , Kupnja.VrijemeKupnje, Kupnja.NacinPlacanja
from Proizvod
inner join Stavka on Stavka.ProizvodD = Proizvod.IDProizvod
inner join Kupnja on Stavka.KupnjaID = Kupnja.IDKupnja
where Kupnja.KupacID = @KupacID

go

create procedure DohvatiSveKupnje
as
select
	Kupnja.IDKupnja, Kupac.Ime, Kupac.Prezime, Kupnja.VrijemeKupnje, Proizvod.Naziv, Proizvod.Cijena, Proizvod.Detalji, Kupnja.NacinPlacanja
from Kupac
inner join Kupnja on Kupac.IDKupac = Kupnja.KupacID
inner join Stavka on Stavka.KupnjaID = Kupnja.IDKupnja
inner join Proizvod on Stavka.ProizvodD = Proizvod.IDProizvod

go

create procedure PretraziPoKupcu
	@Ime nvarchar(20),
	@Prezime nvarchar(20)
as
select Kupac.Ime, Kupac.Prezime, Kupnja.VrijemeKupnje,Proizvod.Naziv, Proizvod.Cijena, Kupnja.NacinPlacanja
from Kupac
inner join Kupnja on Kupac.IDKupac = Kupnja.KupacID
inner join Stavka on Stavka.KupnjaID = Kupnja.IDKupnja
inner join Proizvod on Stavka.ProizvodD = Proizvod.IDProizvod
where Kupac.Ime = @Ime and Kupac.Prezime = @Prezime

go

insert into Administrator values('Ivan','Cekovic','ivancekovic', 'Pa$$w0rd')