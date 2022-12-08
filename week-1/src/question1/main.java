package question1;

public class main {
        public static void main(String[] args) {


            int zincir = 1;
            int maxZincir = 0;
            int sayi = 0;
            long temp;
            for (int i = 10; i < 100; i++) {
                temp = i;
                temp += findReverseNum(temp);
                zincir = 1;
                while (!isPalindrome(temp)) {
                    zincir++;
                    temp += findReverseNum(temp);
                }
                if (zincir > maxZincir) {
                    maxZincir = zincir;
                    sayi=i;
                }
            }
            System.out.println(maxZincir);
            System.out.println(sayi);

            System.out.println("-------------------------Zincir------------------------");
            temp =sayi;
            int sayac=1;
            while (!isPalindrome(temp)) {
                System.out.print(temp+" + "+findReverseNum(temp));
                temp += findReverseNum(temp);
                System.out.print(" = "+temp+" => "+ sayac+". Adım. \n");
                sayac++;
            }
        }

        public static long findReverseNum(long num) {
            long gecici, tersSayi = 0, kalan;

            gecici = num;

            while (gecici != 0) {
                kalan = gecici % 10;
                tersSayi = tersSayi * 10 + kalan;
                gecici /= 10;
            }
            return tersSayi;

        }

        static boolean isPalindrome(long input) {
            long tersSayi = findReverseNum(input);
            if (input == tersSayi) {
                return true;
            }
            return false;
        }
    }




