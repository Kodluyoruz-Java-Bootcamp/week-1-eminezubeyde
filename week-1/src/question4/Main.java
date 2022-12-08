package question4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static Scanner scanner=new Scanner(System.in);
    static List<Urun>  urunler=new ArrayList<>();
    static List<Musteri>  musteriListesi=new ArrayList<>();

    static List<Fatura> faturalar=new ArrayList<>();
    static List<Siparis> siparisler=new ArrayList<>();

    public static void main(String[] args) {


        urunler.add(new Urun("ELEKTRONIK",10000,"Iphone12",10));
        urunler.add(new Urun("ELEKTRONIK",12000,"Iphone13",3));
        urunler.add(new Urun("ELEKTRONIK",13000,"Iphone13PRO",0));
        urunler.add(new Urun("ELEKTRONIK",7500,"Televizyon",2));
        urunler.add(new Urun("EV-ESYASI",16000,"ÇamaşırMakinesi",5));
        urunler.add(new Urun("EV-ESYASI",19300,"KoltukTakımı",1));


        bilgileriGoster();
        int secim=scanner.nextInt();
        while (secim!=0){
            switch (secim){
                case 1:
                    musteriListesi.add(musteriOlustur());
                    break;
                case 2:
                    musteriyeSiparisEkle();
                    break;
                case 3:
                    tumMusterileriGoster();
                    break;
                case 4:
                    musterininSiparisleriniGoster();
                    break;
                case 5:
                    ismeGoreToplamAlisverisTutari("Engin");
                    break;
                case 6:
                    System.out.println("Sistemdeki Müşteri sayisi : "+ musteriListesi.size());
                    break;
                case 7:
                    System.out.println("Hangi isme göre urun sayisini bulmak istiyorsunuz");
                    String kullaniciAdi=scanner.next();
                    ismeGoreAldiklariUrunSayisi(kullaniciAdi);
                    break;

                case 8:
                    int tutar=15000;
                    toplamTutariDanFazlaOlanFaturalar(tutar);
                    break;

                case 9:
                    fatulariGoruntule();
                    break;
            }
            bilgileriGoster();
            secim= scanner.nextInt();
        }


    }

    private static void toplamTutariDanFazlaOlanFaturalar(int tutar) {
        for (int i=0;i<faturalar.size();i++){
            if(faturalar.get(i).getToplamTutar() > tutar){
                System.out.println(faturalar.get(i).getMusteri().getIsim() + " Kişisinin " + faturalar.get(i).getToplamTutar() +" eklendi.... .....");
            }
        }
    }

    private static void ismeGoreAldiklariUrunSayisi( String kullaniciAdi) {
        Optional<Musteri> optionalMusteri = musteriListesi.stream().filter(musteri -> musteri.getKullaniciAdi().equals(kullaniciAdi)).findFirst();
        if(optionalMusteri.isPresent()){
            int toplamUrunSayisi=0;

            for (int i=0;i<optionalMusteri.get().getSiparisList().size();i++){
                toplamUrunSayisi+=optionalMusteri.get().getSiparisList().get(i).getUrunListesi().size();
            }

            System.out.println(kullaniciAdi+" Kişisinin aldığı ürün sayisi : " + toplamUrunSayisi);

        }else{
            System.out.println("Sistemde "+kullaniciAdi+" Adında biri bulunamadı.");
        }
    }


    private static void ismeGoreToplamAlisverisTutari(String isim){
        List<Musteri> ayniIsimdekiMusteriler = musteriListesi.stream().filter(musteri -> musteri.getIsim().equals(isim)).collect(Collectors.toList());
        int toplamAlisverisTutari=0;
        if(!ayniIsimdekiMusteriler.isEmpty()){
            for (Musteri musteri:ayniIsimdekiMusteriler){
                if(musteri.getYas()>=25 && musteri.getYas()<=30){
                    for (Siparis siparis:musteri.getSiparisList()){
                        toplamAlisverisTutari+=siparis.getFatura().getToplamTutar();
                    }
                }
            }
            System.out.println(isim + "Toplam Alışveriş tutarı : "+toplamAlisverisTutari);
        }else{
            System.out.println(isim+ " adında birileri bulunamadı.");
        }


    }

    private static void musterininSiparisleriniGoster() {
        System.out.println("Hangi müsterinin siparislerini gormek istiyorsunuz.?");
        String kullaniciAdi=scanner.next();

        Optional<Musteri> siparisMusteri = musteriListesi.stream().filter(musteri -> musteri.getKullaniciAdi().equals(kullaniciAdi)).findFirst();
        if(siparisMusteri.isPresent()){
            System.out.println(siparisMusteri.get().getSiparisList());
        }else {
            System.out.println("Muşterinin herhangi bir siparişi yoktur.");
        }

    }

    private static void musteriyeSiparisEkle() {
        System.out.println("Sipariş oluşturmak istediğiniz Müşterinin Kullanıcı adını girin");
        String kullaniciAdi=scanner.next();
        Optional<Musteri> musteri = musteriListesi.stream().filter(musteri1 -> musteri1.getKullaniciAdi().equals(kullaniciAdi)).findFirst();
        if(musteri.isPresent()){
            urunleriGoster();

            System.out.println("Sipariş Etmek istediğiniz urunun ismini yazınız .(birden fazla ise , ile ayırınız.)");
            String siparistekiUrunler=scanner.next();
            if(siparistekiUrunler.contains(",")){ // birden fazla ürün eklemek istediği durumlar.
                String[] urunIsimleri=siparistekiUrunler.split(",");
                List<Urun> siparisEdilecekUrunler=new ArrayList<>();
                for (String geciciUrun:urunIsimleri){// iphone12,iphone13
                    Optional<Urun> urun = urunler.stream().filter(urun1 -> urun1.getIsim().equals(geciciUrun)).findFirst();
                    if(urun.isPresent() && urun.get().getStok()>0){
                        siparisEdilecekUrunler.add(urun.get());
                    }
                }
                if(!siparisEdilecekUrunler.isEmpty()){
                    Siparis siparis=new Siparis();
                    siparis.setUrunListesi(siparisEdilecekUrunler);
                    Fatura fatura=new Fatura();
                    int toplamTutar=0;
                    for(Urun siparisUrun:siparisEdilecekUrunler){
                        toplamTutar+=siparisUrun.getFiyat();
                    }
                    fatura.setToplamTutar(toplamTutar);
                    siparis.setFatura(fatura);
                    fatura.setMusteri(musteri.get());
                    musteri.get().getSiparisList().add(siparis);
                    siparisler.add(siparis);
                    faturalar.add(fatura);

                }

            }else{
                Optional<Urun> urun = urunler.stream().filter(urun1 -> urun1.getIsim().equals(siparistekiUrunler)).findFirst();
                if(urun.isPresent()){
                    Siparis siparis=new Siparis();
                    siparis.getUrunListesi().add(urun.get());
                    Fatura fatura=new Fatura();
                    fatura.setToplamTutar(urun.get().getFiyat());
                    siparis.setFatura(fatura);
                    musteri.get().getSiparisList().add(siparis);
                    System.out.println("Sipariş oluşturulmuştur.");
                }else{
                    System.out.println(siparistekiUrunler+ " urunu bulunamadı.");
                }
            }
        }else{
            System.out.println(kullaniciAdi+" adında herhanngi bir müşteri buluamadı.");
        }
    }

    public static Musteri musteriOlustur(){
        System.out.println("Musterinin ismini girin:");
        String isim=scanner.next();
        System.out.println(isim+"'in Yaşını girin:");
        int yas=scanner.nextInt();
        System.out.println(isim+"'in Kullanıcı adını girin:");
        String kullaniciAdi=scanner.next();
        if(musteriListesi.stream().anyMatch(musteri -> musteri.getKullaniciAdi().equals(kullaniciAdi))){
            System.out.println(kullaniciAdi+" Kullanıcı adi ile daha once kayıt yapılmıştır . tekrar deneyiniz.");
            musteriOlustur();
        }
        return new Musteri(isim,yas,kullaniciAdi);
    }

    public static void bilgileriGoster(){
        System.out.println("********** GENEL BİLGİLER ***********************");
        System.out.println("Musteri eklemek için 1 e basınız");
        System.out.println("Musteriye sipariş oluşturmak için 2 e basınız");
        System.out.println("Tum Müsterileri gormek için 3 e basınız");
        System.out.println("Tum Müsterinin siparişlerini gormek için 4 e basınız");
        System.out.println("Çıkmak için 0 a basınız.");
        System.out.println("**************************************************");
    }
    public static void fatulariGoruntule(){
        System.out.println("********** FATURA BİLGİLER ***********************");
        faturalar.forEach(System.out::println);
        System.out.println("**************************************************");
    }
    public static void urunleriGoster(){
        System.out.println("********** ÜRÜN BİLGİLERİ ***********************");
        for (Urun urun:urunler){
            System.out.println(urun);
        }
        System.out.println("**************************************************");

    }
    public static void tumMusterileriGoster(){
        System.out.println("********** MÜŞTERİ BİLGİLERİ ***********************");
        for (Musteri musteri:musteriListesi){
            System.out.println(musteri);
        }
        System.out.println("**************************************************");

    }
}