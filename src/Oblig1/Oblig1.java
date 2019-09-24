/*
Andreas Tønseth Myhr s333770 Laila Doudouh s331351 Martin Phan s333747


 */

package Oblig1;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Oblig1 {


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

    // 1) Det blir flest ombyttinger når det største tallet er foran.
    // 2) Det blir færrest ombyttinger når arrayet er sortert stigende.
    // 3) Algoritmen vår er av orden O(n), noe som er det samme som de maks metodene i kompendiet.

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
    public static void delsortering(int[] a) {
        //Gjør først oppdeling av par og oddetall
        int start = 0, slutt = a.length - 1;
        int oddetallTeller = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0) {
                oddetallTeller++;
            }
        }
        int bareOddetall = 0;
        int barePartall = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0) {
                bareOddetall++;
            } else if ((a[i] % 2 == 0)) {
                barePartall++;
            }
        }
        if (bareOddetall != 0 && barePartall==0) {
            kvikksortering0(a,0,a.length-1);
        } else if (barePartall != 0 && bareOddetall==0) {
            kvikksortering0(a,0,a.length-1);
            System.out.println(Arrays.toString(a));
        } else {
            while (start < slutt) {
                while (a[start] % 2 != 0) {
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
            kvikksortering0(a,0,oddetallTeller-1);
            kvikksortering0(a,oddetallTeller,a.length-1);

        }


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
    public static void rotasjon1 (char [] a, int k) {   // denne versonen har 2(n+d) tabelakkssseser men er mer effektiv hvis k er liten i forhold til n
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
    }

    public static int gcd (int a, int b){
        return b == 0 ? a: gcd(b,a%b);
    }

    public static void rotasjon (char [] a, int k){   /// denne versjonen har 2n tabelakksseser, færre en den første men mer arbeid knyttet til hver akssess
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


    //Oppgave 7
    public static String flett(String s, String t)
    {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length() || i < t.length(); i++) {

            if (i < s.length())
                result.append(s.charAt(i));

            if (i < t.length())
                result.append(t.charAt(i));
        }

        return result.toString();
    }

    //Oppgave 7B
    public static String flett(String... s) {

        StringBuilder result = new StringBuilder();

        int lengst = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() > lengst) lengst = s[i].length();
        }
        for (int i = 0; i < lengst; i++) {
            for (int j = 0; j < s.length; j++) {
                if (s[j].length() <= i) {
                }
                else {
                    result.append(s[j].charAt(i));
                }
            }
        }
        return result.toString();
    }



    //Oppgave 8
    public static int[] indekssortering(int[] a) {
            int[] arr=a.clone();
            int[]index;
            if(a.length==0){
                index = new int[0];
                return index;
            }
            else{
                index = new int[arr.length];
            }
            index[0] = 0;
            for(int i=1;i<arr.length;i++){
                int j=i;
                //Insertion sort sort brukes i denne oppgaven, vi tar altså
                // og finner laveste verdi før vi setter inn denne
                for(;j>=1 && arr[j]<arr[j-1];j--){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    index[j]=index[j-1];
                    arr[j-1] = temp;
                }
                index[j]=i;
            }
            return index;
        }


    //Oppgave9
    public static int[] tredjeMin(int[] a) // ny versjon  {3,1,5,5,3,7,6,9,10};
    {
        int minverdi=Integer.MAX_VALUE;
        int nestMinverdi=Integer.MAX_VALUE-1;
        int tredjeMinverdi=Integer.MAX_VALUE-2;
        int minIndex=0;
        int nmIndex=1;
        int tmIndex=2;
        int[] tabell = new int[3];
        if (a.length < 3) {
            throw new NoSuchElementException("For liten array");
        }

        if(a[2]<a[1] && a[2]<a[0]&&a[1]<a[0]){ //a2 a1 a0
            minIndex=2;
            nmIndex=1;
            tmIndex=0;
        }
        else if(a[2]<a[1]&&a[2]<a[0]&&a[1]>a[0]){ //a2 a0 a1
            minIndex=2;
            nmIndex=0;
            tmIndex=1;
        }
        else if(a[2]>a[1] && a[1]<a[0] && a[2]<a[0]){ // a1 a2 a0
            minIndex=1;
            nmIndex=2;
            tmIndex=0;

        }
        else if(a[2]>a[1] && a[1]<a[0] && a[0]<a[2]){ //a1 a0 a2
            minIndex=1;
            nmIndex=0;
            tmIndex=2;
        }
        else if(a[2]>a[1] && a[1]>a[0] && a[0]<a[2]){ //a0 a1 a2
            minIndex=0;
            nmIndex=1;
            tmIndex=2;
        }
        else if(a[2]<a[1] && a[1]>a[0] && a[0]<a[2]){ //a0 a2 a1
            minIndex=0;
            nmIndex=2;
            tmIndex=1;
        }
        minverdi=a[minIndex];
        nestMinverdi=a[nmIndex];
        tredjeMinverdi=a[tmIndex];


        for(int i=3; i<a.length;i++){
            if(a[i]<minverdi){
                tredjeMinverdi=nestMinverdi;
                nestMinverdi=minverdi;
                minverdi=a[i];
                tmIndex=nmIndex;
                nmIndex=minIndex;
                minIndex=i;
            }
            if(a[i]<nestMinverdi&&a[i]>minverdi){
                tredjeMinverdi=nestMinverdi;
                nestMinverdi=a[i];
                tmIndex=nmIndex;
                nmIndex=i;
            }
            if(a[i]<tredjeMinverdi && a[i]>nestMinverdi){
                tredjeMinverdi=a[i];
                tmIndex=i;
            }
        }
        tabell[0]=minIndex;
        tabell[1]=nmIndex;
        tabell[2]=tmIndex;


        return tabell;
    }


//Oppgave 10
    public static boolean inneholdt(String a,String b) {
        int []delStreng =new int[1000]; // Lager store tabeller for og holde verdier
        int []hovedStreng=new int [1000]; // Lager store tabeller for å holde verdier

        for(char c: a.toCharArray()){
            delStreng[c]++; }
        for(char c:b.toCharArray()){
            hovedStreng[c]++;
    }
    for(int i=0;i<delStreng.length;i++) {
            if (hovedStreng[i] < delStreng[i]) {
                return false;
            }
        }
    return true;
    }



    //Hjelpemetoder fra boken
    private static void kvikksortering0(int[] a, int v, int h)  // en privat metode
    {
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = sParter0(a, v, h, (v + h)/2);  // bruker midtverdien
        kvikksortering0(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        kvikksortering0(a, k + 1, h);     // sorterer intervallet a[k+1:h]
    }

    private static int sParter0(int[] a, int v, int h, int indeks)
    {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h - 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }
    private static int parter0(int[] a, int v, int h, int skilleverdi)
    {
        while (true)                                  // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h) bytt(a,v++,h--);                 // bytter om a[v] og a[h]
            else  return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }
    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
    public static int[] concatenate(int[] a, int[] b)
    {
        int[] arr = new int[a.length + b.length];

        System.arraycopy(a, 0, arr, 0, a.length);
        System.arraycopy(b, 0, arr, b.length, b.length);

        return arr;
    }
    public static int[] randPermBoolean(int n){ //Kopiert fra boken for generering av testverdier
        Random r= new Random();
        int []a =new int[n];
        boolean [] har = new boolean[n];

        for(int i=0; i<n;){
            int k=r.nextInt(n);
            if(!har[k]){
                har[k]=true;
                a[i++]=k+1;
            }
        }
        System.out.println(Arrays.toString(a));
        return a;
    }
}
