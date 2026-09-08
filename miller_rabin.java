public class miller_rabin {

    // Fungsi bantu untuk Langkah 6
    private static int modular(int base, int eksponen, int modulus) {
        long hasil = 1;
        long b = base % modulus;
        while (eksponen > 0) {
            if (eksponen % 2 == 1) {
                hasil = (hasil * b) % modulus;
            }
            eksponen = eksponen / 2;
            b = (b * b) % modulus;
        }
        return (int)hasil;
    }

    // 1) Masukkan bilangan n yang akan diuji
    public static boolean algoritma(int input) { 
        
        // 2) Pengecekan nilai awal
        if (input <= 1) {
            return false;
        }
        if (input == 2 || input == 3) {
            return true;
        }
        
        // 3) Periksa bilangan genap
        if (input % 2 == 0) {
            return false;
        }

        // 4) Nyatakan n - 1 dalam bentuk d * 2^s
        int d = input - 1;
        int s = 0; 
        
        while (d % 2 == 0) {
            d /= 2;
            s++; 
        }

        int iterasi_tes = 5; 

        // 10) Ulangi pengujian dengan basis berbeda
        for (int i = 0; i < iterasi_tes; i++) {
            
            // 5) Tentukan basis a (acak)
            int a = 2 + (int)(Math.random() * (input - 4 + 1));
            
            // 6) Hitung nilai awal x = a^d mod n
            int x = modular(a, d, input);

            // 7) Periksa nilai x
            if (x == 1 || x == input - 1) {
                continue; 
            }

            boolean lolos = false;

            // 8) Pengkuadratan berulang (s - 1 kali)
            for (int r = 1; r <= s - 1; r++) {
                x = (int) (((long) x * x) % input); 

                // 9) Periksa kuadrat
                if (x == input - 1) {
                    lolos = true; 
                    break;
                }
            }
            // 11 & 12) Evaluasi hasil iterasi
            if (!lolos) {
                return false; 
            }
        }
        // 13) Lolos semua = probably prime
        return true;
    }

    public static void main(String[] args) {

        //masukan angka yang ingin di test disini
        int tes_angka = 519; 

        long start = System.nanoTime();

        if (algoritma(tes_angka)) {
            System.out.println(tes_angka + " adalah bilangan prima");
        } else {
            System.out.println(tes_angka + " bukan bilangan prima");
        }
        
        long waktuSelesai = System.nanoTime();
        System.out.println("Waktu run = " + (waktuSelesai - start) + " nanodetik");

    }
}