package Oblig1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class Oblig1Test {

    @org.junit.jupiter.api.Test
    void maks() {
        int[] values = {1, 2, 3, 4, 5};
        assertEquals(Oblig1.maks(values),5);

    }

    @org.junit.jupiter.api.Test
    void ombyttinger() {
        int[] testArray = {4, 51, 1, 3, 7, 10, 17, 2};
        assertEquals(Oblig1.ombyttinger(testArray),6);
    }

    @org.junit.jupiter.api.Test
    void antallUlikeSortert() {
        int []testArray22={1,2,2,3,4,5,6};
        assertEquals(Oblig1.antallUlikeSortert(testArray22),6);
    }

    @org.junit.jupiter.api.Test
    void antallUlikeUsortert3() {
        int [] testArray3={3,1,5,7,4,2,6,6};
        assertEquals(Oblig1.antallUlikeUsortert3(testArray3),7);
    }

    /*@org.junit.jupiter.api.Test
    void delSortering() {

        int testArray4[]={4,1,2,3,5};
        Oblig1.delsortering(testArray4);
        assertEquals(1,testArray4[0]);

        int testArray4[]={4,1,2,3,5,10,11,12,13,17,12,15,17};
        Oblig1.delsortering(testArray4);
        assertEquals(testArray4[0],1);

    }*/

    @org.junit.jupiter.api.Test
    void rotasjon() {
        char a []={'A','B','C','D','E','F','G','H','I','J'};
        Oblig1.rotasjon(a);
        assertEquals(a[0],'J');
    }

    @org.junit.jupiter.api.Test
    void rotasjon2() {
        char a []={'A','B','C','D','E','F','G','H','I','J'};
        Oblig1.rotasjon2(a,3);
        assertEquals(a[0],'H');
    }

    @org.junit.jupiter.api.Test
    void rotasjon1() {
        char a []={'A','B','C','D','E','F','G','H','I','J'};
        Oblig1.rotasjon1(a,7);
        assertEquals(a[0],'D');
    }

    @org.junit.jupiter.api.Test
    void flett() {
        String a="ABC";
        String b="DEF";
        assertEquals("ADBECF",Oblig1.flett(a,b));
    }
    @org.junit.jupiter.api.Test
    void flettEnString() {
        String algdat[] = {"AM ", "L", "GEDS", "ORATKRR", "", "R TRTE", "IO", "TGAUU"};
        assertEquals("ALGORITMER OG DATASTRUKTURER",Oblig1.flettEnString(algdat));
    }

    @org.junit.jupiter.api.Test
    void indekssortering() {
         int[] oppgave8 = {6, 10, 16, 11, 7, 12, 3, 9, 8, 5};
         Oblig1.indekssortering(oppgave8);
         assertEquals(oppgave8[0],3);
    }

    @org.junit.jupiter.api.Test
    void tredjeMin() {
        int[] oppgave9={3,1,5,5,7,6,9,10};
        int []ut=Oblig1.tredjeMin(oppgave9);
        assertEquals(1,ut[0]);
        assertEquals(3,ut[1]);
        assertEquals(5,ut[2]);

    }

    @org.junit.jupiter.api.Test
    void inneholdt() {
     String s1 = "ABBA";
     String s2 = "RABBARBRA";
     Oblig1.inneholdt(s1,s2);
     assertEquals(true, Oblig1.inneholdt(s1,s2));
    }


}