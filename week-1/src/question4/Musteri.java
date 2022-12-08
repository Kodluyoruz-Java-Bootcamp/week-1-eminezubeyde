package question4;

import java.util.ArrayList;
import java.util.List;

public class Musteri {

    private String kullaniciAdi;
    private String isim;
    private int yas;

    private List<Siparis> siparisList=new ArrayList<>();

    public Musteri( String isim, int yas,String kullaniciAdi) {
        this.isim = isim;
        this.yas = yas;
        this.kullaniciAdi=kullaniciAdi;
    }

    public Musteri() {
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }


    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public List<Siparis> getSiparisList() {
        return siparisList;
    }

    public void setSiparisList(List<Siparis> siparisList) {
        this.siparisList = siparisList;
    }

    @Override
    public String toString() {
        return "Musteri{" +
                "isim='" + isim + '\'' +
                ", yas=" + yas +
                '}';
    }
}

