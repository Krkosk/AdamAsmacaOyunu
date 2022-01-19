import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


// dosyadan şartlara uyan bir kelimeyi rastgele olarak seçer ve döndürür
public class kelimeler {

    private int min_uzunluk;
    private int max_uzunluk;
    private int sayac;
    private String[] secim;

    // constructor min ve max alarak nesneyi hayata getirir.
    public kelimeler(int min, int max) {
        min_uzunluk = min;
        max_uzunluk = max;
        sayac = 0;

        sayac_1();
        kelimeler_1();
    }  

    // bu fonk File içerisinde min ve max arasında uzunluğa sahip kaç adet kelime olduğunu bulur.
    private int sayac_1() 
    {

        // try catch kullanmamızın sebebi dosyayı açarken bir problem olması ihtimali.
        // try'ın içerisinde yazılan File açma ve okuma kodunda bir problem olması durumunda
        // program aniden kapanmasın, düzgün bir hata vererek kapansın diye kullandık.
        try {

            // dosyayı scanner ile açıyoruz
            Scanner scan = new Scanner(new File("kelimeler.txt"));

            // dosyanın sonuna gelenee kadar while dönecek
            while (scan.hasNextLine()) {

                // dosyadan bir satırı getir
                Scanner scanKelime = new Scanner(scan.nextLine());

                // satırdaki kelimelere tek tek bak ve şarta uyan kelimeler için sayac'u 1 arttır.
                while (scanKelime.hasNext()) {
                    String kelime = scanKelime.next();

                    if (kelime.length() >= min_uzunluk && kelime.length() <= max_uzunluk)
                        sayac++;
                }
            }

            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("Hata! File bulunamadı ");
        }

        return sayac;
    }

    // bu fonk File içerisinde min ve max arasında uzunluğa sahip kelimeri diziye atar.
    private void   kelimeler_1() 
    {
        secim = new String[sayac];

        int index = 0;

        try {
            Scanner scan = new Scanner(new File("kelimeler.txt"));

            while (scan.hasNextLine()) {
                Scanner scanKelime = new Scanner(scan.nextLine());

                while (scanKelime.hasNext()) {
                    String kelime = scanKelime.next();

                    // şarta uyan kelimeleri secim adlı kelimeleri tutacak array'a ekle
                    if (kelime.length() >= min_uzunluk && kelime.length() <= max_uzunluk) {
                        secim[index] = kelime;
                        index++;

                    }
                }
            }

            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("Hata! File bulunamadı ");
        }
    }

    // bu fonk dizi içerisinde rastgele bir kelimeyi seçer ve döndürür.
    public String kelimeler_sec()
    {
        if (sayac == 0)
            return "";

        Random rand = new Random();
        int randomNum = rand.nextInt(sayac);
        String randkelime = secim[randomNum];
        return randkelime;
    }

    // bu fonk min ve max tekrar belirlemek için kullanılır.
    public void reset(int min, int max)
    {
        min_uzunluk = min;
        max_uzunluk = max;
        sayac_1();
        kelimeler_1();
    }
}

