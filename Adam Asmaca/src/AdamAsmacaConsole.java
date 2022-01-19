import java.util.Scanner;

// bu class'ı adam asmaca class'ından türüyor ve oyunun grafiklerini göstermek için kullanılıyor
public class AdamAsmacaConsole extends AdamAsmaca {

    // constructor super'i çağırarak oyuu başlatıyor
    public AdamAsmacaConsole(String kelime) {
        super(kelime);
    }

    // girilen yanlış tahmin sayısına göre uygun şekli ekrana yazdırıyor
    public void status(int asama)
    {
        switch (asama)
        {
            case 0:
                System.out.print(" +-----\n");
                System.out.print(" |     \n");
                System.out.print(" |     \n");
                System.out.print(" |     \n");
                System.out.print(" |     \n");
                System.out.print(" ----- \n");
                break;

            case 1:
                System.out.print(" +-----\n");
                System.out.print(" |  O  \n");
                System.out.print(" |     \n");
                System.out.print(" |     \n");
                System.out.print(" |     \n");
                System.out.print(" ----- \n");
                break;

            case 2:
                System.out.print(" +-----\n");
                System.out.print(" |  O  \n");
                System.out.print(" |  |  \n");
                System.out.print(" |     \n");
                System.out.print(" |     \n");
                System.out.print(" ----- \n");
                break;

            case 3:
                System.out.print(" +----- \n");
                System.out.print(" |  O   \n");
                System.out.print(" | /|\\ \n");
                System.out.print(" |      \n");
                System.out.print(" |      \n");
                System.out.print(" -----  \n");
                break;

            case 4:
                System.out.print(" +----- \n");
                System.out.print(" |  O   \n");
                System.out.print(" | /|\\ \n");
                System.out.print(" |  |   \n");
                System.out.print(" |      \n");
                System.out.print(" -----  \n");
                break;

            case 5:
                System.out.print(" +-----\n");
                System.out.print(" |  O  \n");
                System.out.print(" | /|\\ \n");
                System.out.print(" |  |   \n");
                System.out.print(" | /    \n");
                System.out.print(" ----- \n");
                break;

            case 6:
                System.out.print(" +-----\n");
                System.out.print(" | /|\\ \n");
                System.out.print(" |  |   \n");
                System.out.print(" | / \\ \n");
                System.out.print(".............O |\n");
                System.out.print(" ----- \n");
                break;
        }
    }

    // oyun bilgilerini gösteriyor.. kalan hak, yanlış tahminler vs
    public void info()
    {

        for (int i = 0; i < kelime_uzunluk; i++) {
            System.out.print(get_degisim()[i]);
        }
        System.out.println();

        status(yanlis_tahminler);

        System.out.println(son_tahmin +  " harfi "+ kac_defa+ " defa bulundu ");
        System.out.println("Yanlış girilen tahmin sayısı: " + yanlis_tahminler);
        System.out.println("Kalan hak: " + kalan_hak);
        System.out.println("Tahmin edilen harfler: " + tahminler);
    }

    public void print() {
        Scanner input = new Scanner(System.in);

        char ch;
        ch = input.next().charAt(0);
        kontrol(ch);
    }
}
