package question2;

public class main {
    public static void main(String[] args) {

        int uzunluk = 5;
        for (int i = 0; i <= uzunluk; i++) { //i satır
            for (int j = 0; j < i; j++) { //j sütun
                System.out.print("*");

            }
            System.out.println(" ");

        }
        System.out.println("-----------------------------------------");

        for (int i = 1; i <= uzunluk; i++) {

            for (int k =1; k <= (uzunluk-1); k++) {
                System.out.print(" ");



                } for (int j=1;j<=i;j++)
                        System.out.print("*");

            }System.out.println();

        }
    }
