public class Oblig1 {

    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

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
            else {
                max = a[i+1];
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


    public static void main(String[] args) {
        int a [] = {-1,5,3,9,7,0,10,6};
        maks(a);
        System.out.println(Arrays.toString(a));

    }
}

