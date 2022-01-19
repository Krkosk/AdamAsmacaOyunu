import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        int ayarlar, n1, n2, min, max;
        String kelime;

        System.out.print(
                "\n  1. Bilgisayara karşı \n" +
                        "  2. İki kişilik(1.Oyuncu kelimeye seçer 2.oyuncu tahmin eder\n" +
                        "  3. Çıkış\n" +
                        "\n" +
                        "Seçiminiz: ");
        ayarlar = input.nextInt();

        // menüden girilen değere göre seçeneklerden birini çalıştırıyor.
        if (ayarlar == 1) {

            // rastgele sayılar üretip min ve max'ı belirle
            n1 = 2;
            n2 = 20;

            if (n1 > n2) {
                max = n1;
                min = n2;
            }
            else {
                min = n1;
                max = n2;
            }

            // min ve max ile rastgele bir kelime al
            kelimeler kelimeler = new kelimeler(min, max);
            kelime = kelimeler.kelimeler_sec();
        }
        else if (ayarlar == 2) {
            System.out.print("Birinci oyuncunun kelimesi   ");
            kelime = input.next();
            System.out.println();
        }
        else if (ayarlar == 3) {
            return;
        }
        else {
            System.out.println("Hatalı giriş yaptınız!!");
            return;
        }


        // kelimeyle oyunu başlat
        AdamAsmacaConsole oyun = new AdamAsmacaConsole(kelime);

        System.out.println("\nOyun başladı");
        for (int i = 0; i < oyun.kelime_uzunluk; i++) {
            System.out.print(oyun.get_degisim()[i]);
        }

        System.out.println("\n");

        // kelime tamamen açılana veya kalan hak 0 dan büyük olduğu sürece devam eden döngü
        while (!oyun.kelime_tamamlandi_mi() && oyun.get_kalan_hak() > 0)
        {
            System.out.print("\nTahmininizi giriniz: ");
            char tahmin = input.next().charAt(0);
            oyun.kontrol(tahmin);

            oyun.info();

            System.out.println("------------------------------------------------");
        }

        System.out.print("Kelime : ");
        for (int i = 0; i <oyun.kelime_uzunluk ; i++) {
            System.out.print(oyun.get_kelime()[i]);

        }

        System.out.println("\nOyun bitti...");
    }
}
