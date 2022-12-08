package question4;
public class Urun {

    private String kategori;
    private int fiyat;
    private String isim;
    private int stok;

    public Urun(String kategori, int fiyat, String isim, int stok) {
        this.kategori = kategori;
        this.fiyat = fiyat;
        this.isim = isim;
        this.stok = stok;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public String toString() {
        return "Urun{" +
                "kategori='" + kategori + '\'' +
                ", fiyat=" + fiyat +
                ", isim='" + isim + '\'' +
                ", stok=" + stok +
                '}';
    }
}
