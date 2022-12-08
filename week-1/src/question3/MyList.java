package question3;

public class MyList {
    private String[] list = new String[5];
    private final int kapasiteArtisOrani=7;

    public void add(String value) {
        if (value.charAt(0) == 'c' || value.charAt(0) == 'C') {
            for (int i = 0; i < value.length(); i++) {
                if (list[i] == null) {
                    list[i] = value;
                    break;
                }
                if (i == value.length() - 1) {
                    kapasiteArttir();
                }
            }
        } else {
            System.out.println("***sadece ismi c/C ile başlayanlar listeye eklenebilir***");
        }
    }
        public void print() {
            for (String str : list) {
                if (str != null) {
                    System.out.print(str + "-");
                }

            }
        }

    public void kapasiteArttir(){
        int yeniKapasite=list.length+kapasiteArtisOrani;
        String[] yeniListe=new String[yeniKapasite];
        for(int i=0;i<list.length;i++){
            yeniListe[i]=list[i];
        }
        list=yeniListe;

    }


}

