package question5;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        /*List interface , yinelenen öğelere de izin verilen sıralı bir koleksiyondur.
          Öğeler sıralı bir şekilde saklanır ve bu nedenle öğelerine indeks değeri kullanılarak erişilebilir.
           ArrayList,LinkedList,Vector olarak 3 çeşidi vardır.

           Set sırasız bir koleksiyondur. Öğeleri depolarken herhangi bir düzen sağlamaz. Yinelenen öğelere izin vermez.
           HashSet ,Linked HashSet,Tree Set olarak üç çeşidi vardır.

           Map anahtarları, her anahtarın benzersiz olması gereken değerlerle eşleyen bir arabirimdir.
           HashMap ,Hashtable, TreeMap olmak üzere üç çeşidi vardır. */


        System.out.println("************************* LİST ***************************");

        //Java ArrayList sınıfı , öğeleri depolamak için dinamik bir dizi kullanır.
        // Bir dizi gibidir, ancak boyut sınırı yoktur .
        // Öğeleri istediğimiz zaman ekleyebilir veya kaldırabiliriz.
        // Bu nedenle, geleneksel diziden çok daha esnektir.
        // Java'daki ArrayList ayrıca yinelenen öğelere sahip olabilir.
        // List arabirimini uygular, böylece List arabiriminin tüm yöntemlerini burada kullanabiliriz.
        // ArrayList, ekleme sırasını dahili olarak tutar ve bunlar senkronize edilmez.



        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        System.out.println("arrayList -> " + cars);

        //Java LinkedList sınıfı, öğeleri depolamak için çift bağlantılı bir liste kullanır.
        // Bağlantılı liste veri yapısı sağlar. AbstractList sınıfını devralır ve List ile Deque interface uygular.
        //Java LinkedList sınıfı, yinelenen öğeler içerebilir ve ekleme sırasını koruyabilir.
        // Senkronize değildir ve ayrıca bir liste, yığın veya sıra olarak kullanılır.


        LinkedList<String> cars2 = new LinkedList<String>();
        cars2.add("Volvo");
        cars2.add("BMW");
        cars2.add("Ford");
        cars2.add("Mazda");
        System.out.println("LinkedList -> " + cars2);

       // Vektör , boyutunu büyütebilen veya küçültebilen dinamik dizi gibidir .
        // Bir diziden farklı olarak, boyut sınırı olmadığı için n sayıda öğeyi içinde saklayabiliriz.

        Vector<String> cars3= new Vector<String>();

        cars3.add("volvo");
        cars3.add("BMW");
        cars3.add("Ford");
        cars3.add("mazda");
        System.out.println("Vector -> " +cars3);



        System.out.println("********************* SET *******************");
       // Java HashSet sınıfı, depolama için bir karma tablo kullanan bir koleksiyon oluşturmak için kullanılır.
        // AbstractSet sınıfını devralır ve Set interface uygular.

        HashSet<String> cars4 = new HashSet<String>();
        cars4.add("Volvo");
        cars4.add("BMW");
        cars4.add("Ford");
        cars4.add("Mazda");
        System.out.println("HashSet -> " +cars4);

        //Java LinkedHashSet sınıfı, Set interface Hashtable ve Linked list uygulamasıdır.
        // HashSet sınıfını devralır ve Set interface uygular.
        //LinkedHashSet sınıfı, yalnızca HashSet gibi benzersiz öğeler içerir.
        // Tüm isteğe bağlı küme işlemlerini sağlar ve boş öğelere izin verir, ekleme sırasını korur ve ayrıca senkronize değildir.

        LinkedHashSet<String> cars5=new LinkedHashSet();
        cars5.add("volvo");
        cars5.add("BMW");
        cars5.add("ford");
        cars5.add("mazda");
        System.out.println("LinkedHashSet -> " +cars5);

        //Java TreeSet sınıfı, yalnızca HashSet gibi benzersiz öğeler içerir.
        //Java TreeSet sınıfına erişim ve alma süreleri oldukça hızlıdır.
        //Java TreeSet sınıfı boş öğelere izin vermez.
        //Java TreeSet sınıfı senkronize değildir.
        //Java TreeSet sınıfı artan düzeni korur.

        TreeSet<String> cars6=new TreeSet<String>();
        cars6.add("volvo");
        cars6.add("BMW");
        cars6.add("Ford");
        cars6.add("Mazda");
        System.out.println("TreeSet -> " +cars6);



        System.out.println("*********************QUEUE*******************");

        // PriorityQueue sınıfı, Queue interface uygular.
        // Önceliklerine göre işlenecek öğeleri veya nesneleri tutar.
        // PriorityQueue, boş değerlerin kuyrukta depolanmasına izin vermez.
        PriorityQueue<String> cars7=new PriorityQueue<String>();
        cars7.add("volvo");
        cars7.add("Bmw");
        cars7.add("ford");
        cars7.add("mazda");
        System.out.println("PriorityQueue -> " +cars7);


         // Java HashMap sınıfı , anahtarların benzersiz olması gereken anahtar ve değer çiftlerini saklamamıza izin veren MAP interface uygular .
         // Yinelenen anahtarı eklemeye çalışırsanız, karşılık gelen anahtarın öğesini değiştirecektir.
         // Anahtar dizini kullanarak güncelleme, silme vb. işlemleri gerçekleştirmek kolaydır.
         // Java'daki HashMap, eski Hashtable sınıfı gibidir, ancak senkronize değildir.
         // Boş elemanları da saklamamıza izin verir, ancak yalnızca bir boş anahtar olmalıdır.

        System.out.println("********************* HashMap *******************");


        HashMap<String, String> capitalCities = new HashMap<String, String>();


        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        System.out.println("HashMap -> " +capitalCities);

        //Java LinkedHashMap sınıfı, tahmin edilebilir yineleme sırasına sahip,MAP arabiriminin Hashtable ve Bağlantılı liste uygulamasıdır.
        //HashMap sınıfını devralır ve Map arayüzünü uygular.
        //java LinkedHashMap, anahtara ve benzersiz öğelere dayalı değerler içerir.
        // Bir boş anahtara ve birden çok boş değere sahip olabilir.
        // Senkronize değildir ve kampanya sırasını korur.

        LinkedHashMap<Integer,String> hashMap=new LinkedHashMap<Integer,String>();

        hashMap.put(100,"A");
        hashMap.put(101,"B");
        hashMap.put(102,"C");
        System.out.println("LinkedHashMap -> " +hashMap);












    }
}
