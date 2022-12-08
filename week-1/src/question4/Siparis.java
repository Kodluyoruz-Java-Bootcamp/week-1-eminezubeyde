package question4;


import java.util.ArrayList;
import java.util.List;

public class Siparis {


    private List<Urun> urunListesi=new ArrayList<>();

    private Fatura fatura;

    public List<Urun> getUrunListesi() {
        return urunListesi;
    }

    public void setUrunListesi(List<Urun> urunListesi) {
        this.urunListesi = urunListesi;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

    @Override
    public String toString() {
        return "Siparis{" +
                "urunListesi=" + urunListesi +
                ", fatura=" + fatura +
                '}';
    }
}

