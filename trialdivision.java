public class trialdivision{

    public static boolean algoritma(int input) { 

      double kuadrat = Math.sqrt(input);
        
        if (input <= 1) {
            return false;
        }

        if (input == 2 || input == 3) {
            return true;
        }

      
        if (input % 2 == 0 ) {
            return false;
        }
        for (int i = 3; i <= kuadrat; i += 2) { 
            if (input % i == 0) {
                return false; 
            }
        }
        
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