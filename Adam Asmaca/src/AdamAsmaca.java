public class AdamAsmaca
{
    // kelime kelimenin kendisini temsil eder
    private char[] kelime = new char[40];

    // degisim kelime için temsili görsel ( mesela araba için "-----". | a girilince a-a-a )
    private char[] degisim = new char[40];

    // kelimenin uzunluğu
    public int kelime_uzunluk;

    // girilecek her bir harfin kaç defa bulunduğunu tutacak
    protected int kac_defa;

    // girilen son tahmini tutacak
    protected char son_tahmin;

    // o zaman kadar girilen tahminleri tutacak
    protected String tahminler;

    // yanlış tahmin sayısı
    protected int yanlis_tahminler;

    // kalan hak
    protected int kalan_hak;

    // bu fonk kullanıcıdan tahmin ettiğin harf için kelimeye bakacak. kelimede varsa degisim'deki çizgilerin yerine harfleri yerleştirecek
    // doğru yanlış olması durumuna göre kalan hak vs güncelleyecek
    protected boolean kontrol(char kullanıcı_tahmin) {
        boolean kontrol = false;
        son_tahmin = kullanıcı_tahmin;
        kac_defa = 0;
        tahminler += kullanıcı_tahmin;

        // kelimeyi gez, kullanıcının girdiği harfi bulunca degisim'de çizgileri harf yap
        for (int i = 0; i < kelime_uzunluk; ++i)
            if (kelime[i] == kullanıcı_tahmin) {
                degisim[i] = kullanıcı_tahmin;
                kac_defa++;
                kontrol = true;
            }

        // bulunamazsa yanlış tahmin sayısını ve kalan hakkı güncelle
        if (kontrol == true) {
            return true;
        }
        else {
            yanlis_tahminler += 1;
            kalan_hak--;

            return false;
        }
    }

    // constructor baslangiç fonk aracılığı ile oyunu başlatıyor.
    public AdamAsmaca(String kelime)
    {
        baslangiç(kelime);
    }

    // degisim'in içeriğini çizgilerle dolduruyor
    public void temizle_degisim(int length) {
        int i;
        for (i = 0; i < kelime_uzunluk; ++i) {
            degisim[i] = '-';
        }
    }

    // verilen kelimeyle oyunu başlatan fonk.
    public void baslangiç(String basla) {
        tahminler = "";
        yanlis_tahminler = 0;
        kalan_hak = 6;

        for (int i = 0; i < kelime_uzunluk; i++) {
            degisim[i] = '-';
        }

        for (int i = 0; i < basla.length(); i++) {
            kelime[i] = basla.charAt(i);
        }

        kelime_uzunluk = basla.length();

        temizle_degisim(kelime_uzunluk);
    }

    // getter'lar
    public char[] get_degisim() {
        return degisim;
    }

    public char[] get_kelime() {
        return kelime;
    }

    public int get_kalan_hak() {
        return kalan_hak;
    }

    // kelimenin karakterlerinin tamamen açılıp açılmadığını kontrol ediyor.
    // yani oyunun bitip bitmediğine karar vermek için kullanılıyor.
    public boolean kelime_tamamlandi_mi() {

        for (int i = 0; i < kelime_uzunluk; i++) {
            if (degisim[i] == '-') {
                return false;
            }
        }

        return true;
    }
}