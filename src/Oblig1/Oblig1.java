package Oblig1;

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
    public static int maks(int[] a) {
        if (a.length < 1) {
            throw new NoSuchElementException("Tabellen er tom");
        }
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
        System.out.println(a[a.length - 1]);
        return a[a.length - 1];
    }

    public static int ombyttinger(int[] a) {
        if (a.length < 1) {
            throw new NoSuchElementException("Tabellen er tom");
        }
        int antallOmbyttinger = 0;
        for (int j = 0; j < a.length - 1; j++) {
            if (a[j] > a[j + 1]) {
                int temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
                antallOmbyttinger++;
            }

        }
        System.out.println(antallOmbyttinger);
        return antallOmbyttinger;

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
    public static int antallUlikeUsortert3(int[] a){
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
    public static int[] delsortering(int[] a) {

        //Gjør først oppdeling av par og oddetall
        int start = 0, slutt = a.length - 1;
        int oddetallTeller = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 1) {
                oddetallTeller++;
            }
        }
        while (start < slutt) {
            while (a[start] % 2 == 1) {
                start++;
            }
            while (a[slutt] % 2 == 0) {
                slutt--;
            }
            if (start < slutt) {
                int temp = a[start];
                a[start] = a[slutt];
                a[slutt] = temp;
                start++;
                slutt--;
            }
        }
        System.out.println(Arrays.toString(a));

        for (int i = 0; i < oddetallTeller - 1; i++) {
            for (int j = 0; j < oddetallTeller - i -1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        for(int x=oddetallTeller; x<a.length;x++){
            for(int y=oddetallTeller; y<a.length-1;y++){
                if (a[y] > a[y + 1]) {
                    int temp = a[y];
                    a[y] = a[y + 1];
                    a[y + 1] = temp;
                }
            }
        }
        System.out.println(oddetallTeller);
        System.out.println(Arrays.toString(a));
        return a;
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
        System.out.println(Arrays.toString(b));
        System.arraycopy(b, 0, a, 0, 1);
    }

    //Oppgave 6
    public static void rotasjon2 (char [] a, int k) {   // denne versonen har 2(n+d) tabelakkssseser men er mer effektiv hvis k er liten i forhold til n
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
        return slutt.toString();
    }
    //Oppgave 7B
    public static String flettEnString(String[] s) { // Ingen eller flere elementer
        String ut = "";
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (arr[j] < s[j].length()) {
                    ut += s[j].toCharArray()[arr[j]];
                    arr[j]++;
                }
            }
        }
        System.out.println(ut);
        return ut;
    }
    //Oppgave 8
    public static int[] indekssortering(int[] a) {
        int[] indexer = new int[a.length];
        for (int i = 1; i < a.length; i++) {
            int j = i;
            for (; j >= 1 && a[j] < a[j - 1]; j--) {
                int temp = a[j];
                a[j] = a[j - 1];
                indexer[j] = indexer[j - 1];
                a[j - 1] = temp;
            }
            indexer[j] = i;
        }
        return indexer;
    }

    //Oppgave9
    public static int[] tredjeMin(int[] a) // ny versjon
    {
        int maksverdi=0;
        int nestMaksverdi=0;
        int tredjeMaksverdi=0;
        int[] returTabell = new int[3];
        if (a.length < 3) {
            throw new IndexOutOfBoundsException("For liten array");
        }
        if(a[2]>a[1] && a[2]>a[0]&&a[1]>a[0]){ //a2 a1 a0
            maksverdi=a[2];
            nestMaksverdi=a[1];
            tredjeMaksverdi=a[0];
        }
        else if(a[2]>a[1]&&a[2]>a[0]&&a[1]<a[0]){ //a2 a0 a1
            maksverdi=a[2];
            nestMaksverdi=a[0];
            tredjeMaksverdi=a[1];
        }
        else if(a[2]<a[1] && a[1]>a[0] && a[2]>a[0]){ // a1 a2 a0
            maksverdi=a[1];
            nestMaksverdi=a[2];
            tredjeMaksverdi=a[0];

        }
        else if(a[2]<a[1] && a[1]>a[0] && a[0]>a[2]){ //a1 a0 a2
            maksverdi=a[1];
            nestMaksverdi=a[0];
            tredjeMaksverdi=a[2];
        }
        else if(a[2]<a[1] && a[1]<a[0] && a[0]>a[2]){ //a0 a1 a2
            maksverdi=a[0];
            nestMaksverdi=a[1];
            tredjeMaksverdi=a[2];
        }
        else if(a[2]>a[1] && a[1]<a[0] && a[0]>a[2]){ //a0 a2 a1
            maksverdi=a[0];
            nestMaksverdi=a[2];
            tredjeMaksverdi=a[1];
        }
        for(int i=3; i<a.length;i++){
            if(a[i]>tredjeMaksverdi){
                if(a[i]>nestMaksverdi){
                    if(a[i]>maksverdi){
                        tredjeMaksverdi=nestMaksverdi;
                        nestMaksverdi=maksverdi;
                        maksverdi=a[i];
                    }
                }
            }
        }
        System.out.println("Største tall "+maksverdi+" Nest største "+nestMaksverdi+" TredjeStørst "+tredjeMaksverdi);
        return a;
    }


//Oppgave 10
    public static boolean inneholdt(String s1,String s2){
        char [] karakterer1=s1.toCharArray();
        for(int i=0; i<s1.length(); i++){
            char k= s1.charAt(i);
            if(s2.indexOf(k)==-1){//Retunerer indeksen til tallet, hvis tallet ikke eksisterer returner -1
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        System.out.println(flett("ABCD","EFGH"));




    }
}
