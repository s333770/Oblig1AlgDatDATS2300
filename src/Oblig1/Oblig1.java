import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Oblig1 {

    public static int[] randPermBoolean(int n){ //Kopiert fra boken for generering av testverdier
        Random r= new Random();
        int []a =new int[n];
        boolean [] har = new boolean[n];

        for(int i=0; i<n;){
            int k=r.nextInt(n);
            if(har[k]==false){
                har[k]=true;
                a[i++]=k+1;
            }
        }
        System.out.println(Arrays.toString(a));
        return a;
    }

    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    // Oppgave 1
    public static int maks (int [] a){

        if (a.length < 1) {     //sjekker at tabellen ikke er tom
            throw new NoSuchElementException("Tabellen er tom!");
        }

        int max = a[0]; // Initierer variabel med størst verdi

        for (int i = 0; i< a.length-1; i++) {  //Bruker bobblestortering til å sammenlikne to og to tall ved siden av hverandre

            if (a[i] > a[i+1]) {
                bytt(a,a[i],a[i+1]);
                max = a [i+1];
            }
        }
        return max;
    }

    public static int ombyttinger (int [] a){
        if (a.length < 1){     //sjekker at tabellen ikke er tom
            throw new NoSuchElementException("Tabellen er tom!");
        }

        int teller = 0; //instansierer telleren

        int max = a[0]; // Initierer variabel med størst verdi

        for (int i = 0; i< a.length-1; i++) {  //Bruker bobblestortering til å sammenlikne to og to tall ved siden av hverandre

            if (a[i] > a[i+1]) {
                bytt(a,a[i],a[i+1]);
                teller++;
                max = a [i+1];
            }
            else {
                max = a[i+1];
            }
        }
        return teller;
    }

    // Oppgave 2
    public static int antallUlikeSortert(int[] a){
        int m = 0;
        int antall = 0;

        for (int i = 0; i < a.length; i++){
            if ( a[i] >= m){
                if (a[i] != m){
                    antall++;
                }
                m = a[i];
            }
            else{
                throw new IllegalStateException("Arrayet er ikke sortert stigende");
            }
        }
        return antall;
    }

    // Oppgave 3
    public static int antallUlikeUsortert(int[] a){
        if(a.length < 1) {
            return 0;
        }

        int antall = a.length;

        for (int i = 0; i < a.length; i++){
            for(int j = i+1; j < a.length; j++){
                if ( a[j] == a[i]){
                    antall--;
                    break;
                }
            }
        }
        return antall;

    }
    //Oppgave 4

    public static int partisjonering (int a [], int vs, int hs) {

        while (true){
            while (vs<=hs && a[hs] % 2 == 0) {
                hs--;
            }
            while (vs<=hs && a[vs] % 2 == 1){
                vs++;

            }
            if(vs<hs){
                bytt(a,vs++,hs--);
            }
            return vs;
        }
    }

    public static int partition (int [] a, int vs, int hs){

        int pivot = a[vs];
        int i = vs - 1;
        int j = hs + 1;

        while (i<j){
            for (i++; a[i] < pivot; i++);
            for (j--; a[j] > pivot; j--);
            if(i<j){
                bytt(a,i,j);
            }
        }
        return j;
    }

    public static void kvikksort (int [] a, int vs, int hs){
        if (vs < hs){
            int pi = partition(a,vs,hs);
            kvikksort(a,vs,pi-1);
            kvikksort(a,hs,pi+1);
        }

    }

    public static void delSortering (int [] a){
        int par = 0;
        int odd = 0;

        if (a.length == 0) {
            return;
        }

        partisjonering(a,0,a.length-1);

        for (int i = 0; i <a.length; i++){
            if (Math.floorMod(a[i],2)== 0){ //Bruker floorMod da negative tall kan også tastes inn og vil ha "negativ" modulu tilbake
                par = par + 1;
            }
            else {
                odd = odd +1;
            }
        }
        kvikksort(a,0, odd-1);
        kvikksort(a,odd,a.length-1);
    }

    //Oppgave 5
    public static void rotasjon(char[] a){

        int n = a.length;
        if ((n < 2) || (n == 0)) {
            return;
        }

        char[] b = Arrays.copyOfRange(a, n - 1, n);
        for (int i = n - 1; i >= 1; i--) {
            a[i] = a[i - 1];
        }
        System.arraycopy(b, 0, a, 0, 1);
    }

    //Oppgave 6
    public static void rotasjon (char [] a, int k) {   // denne versonen har 2(n+d) tabelakkssseser men er mer effektiv hvis k er liten i forhold til n
        int n = a.length;
        if ((n < 2) || (n == 0)) {
            return;
        }
        if ((k %= n) < 0) k += n;

        char [] b = Arrays.copyOfRange(a,n-k,n);
        for (int i = n-1; i >= k; i--){
            a[i] = a[i-k];
        }
        System.arraycopy(b,0,a,0,k);
    }   //////sjekk effektiviteten her

    public static int gcd (int a, int b){
        return b == 0 ? a: gcd(b,a%b);
    }

    public static void rotasjon1 (char [] a, int k){   /// denne versjonen har 2n tabelakksseser, færre en den første men mer arbeid knyttet til hver akssess
        int n = a.length;
        if ((n < 2) || (n == 0)) {
            return;
        }
        if ((k %= n) < 0) k += n;

        int s = gcd(n,k);

        for (int syk = 0; syk < s; syk++){
            char verdi = a[syk];

            for (int i = syk -k, j=syk; i != syk; i-=k){
                if ( i<0) {
                    i += n;
                }
                a[j] = a[i];
                j = i;
            }

            a[syk+k] = verdi;
        }
    }

    //Oppgave 7a

    public static String sorter (String inputString ){
        //konverter input string fra flett metoden alfabetisk
        char tempArray [] = inputString.toCharArray();

        //sorterer tempArray
        Arrays.sort(tempArray);

        //returnerer den sorterte stringen
        return new String (tempArray);
    }

    public static String flett (String s, String t){
        StringBuilder slutt = new StringBuilder();

        for (int i = 0; (i >= s.length() || i >= t.length()); i++){
            if (i<s.length()) {
                slutt.append(s.charAt(i));
            }
            if (i<t.length()) {
                slutt.append(t.charAt(i));
            }
        }
        return sorter(slutt.toString());
    }


    public static void main(String[] args) {
       int [] a=  randPermBoolean(10);
       maks(a);



    }
}
