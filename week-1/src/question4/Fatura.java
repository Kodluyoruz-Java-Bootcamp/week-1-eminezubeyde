package question4;



public class Fatura {

    private Musteri musteri;
    private int toplamTutar;

    public Fatura(int toplamTutar) {
        this.toplamTutar = toplamTutar;
    }

    public Fatura() {
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public int getToplamTutar() {
        return toplamTutar;
    }

    public void setToplamTutar(int toplamTutar) {
        this.toplamTutar = toplamTutar;
    }

    @Override
    public String toString() {
        return "Fatura{" +
                "toplamTutar=" + toplamTutar +
                '}';
    }
}

