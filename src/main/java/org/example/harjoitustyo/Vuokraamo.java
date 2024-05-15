package org.example.harjoitustyo;

import java.io.Serializable;


/**
 * olioluokka jota VuokraamoSovellus hyödyntää
 */
public class Vuokraamo implements Serializable {

    /**
     * nimi
     */
    private String nimi;

    /**
     * puhelinnumero
     */
    private String puh;

    /**
     * sähköposti
     */
    private String sapo;

    /**
     * osoite
     */
    private String osoite;

    /**
     * pituus
     */
    private double pituus;

    /**
     * paino
     */
    private double paino;

    /**
     * parametriton alustaja luo olion, jolla ei ole annettuja tietoja
     */
    public Vuokraamo() {}

    /**
     * vuokraamo- olio, joka saa parametreiksi asiakkaan tietoja
     * @param nimi nimi
     * @param puh puhelinnumero
     * @param sapo sähköposti
     * @param osoite osoite
     * @param pituus pituus
     * @param paino paino
     */
    public Vuokraamo(String nimi, String puh, String sapo, String osoite, double pituus, double paino) {
        this.nimi = nimi;
        this.puh = puh;
        this.sapo = sapo;
        this.osoite = osoite;
        this.pituus = pituus;
        this.paino = paino;
    }

    /**
     * palauttaa nimen
     * @return nimi
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * asettaa nimen
     * @param nimi nimi
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    /**
     * palauttaa puhelinnumeron
     * @return puh
     */
    public String getPuh() {
        return puh;
    }

    /**
     * asettaa puhelinnumeron
     * @param puh puhelinnumero
     */
    public void setPuh(String puh) {
        this.puh = puh;
    }

    /**
     * palauttaa sähköpostiosoitteen
     * @return sapo
     */
    public String getSapo() {
        return sapo;
    }

    /**
     * asettaa sähköpostin
     * @param sapo sähköposti
     */
    public void setSapo(String sapo) {
        this.sapo = sapo;
    }

    /**
     * palauttaa osoitteen
     * @return osoite
     */
    public String getOsoite() {
        return osoite;
    }

    /**
     * asettaa osoitteen
     * @param osoite osoite
     */
    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    /**
     * palauttaa pituuden
     * @return pituus
     */
    public double getPituus() {
        return pituus;
    }

    /**
     * asettaa pituuden
     * @param pituus pituus
     */
    public void setPituus(double pituus) {
        this.pituus = pituus;
    }

    /**
     * palauttaa painon
     * @return paino
     */
    public double getPaino() {
        return paino;
    }

    /**
     * asettaa painon
     * @param paino paino
     */
    public void setPaino(double paino) {
        this.paino = paino;

    }

    /**
     * palauttaa tiedot ja korvaa olemassa olevan toSting metodin
     * @return toString
     */
    public String toString() {
        return "Omat tiedot\n\nNimi: " + nimi + "\nSähkoposti: " + sapo +
                "\nPuhelinnumero: " + puh + "\nOsoite: " + osoite + "\nPituus: " + pituus +
                "\nPaino: " + paino;
    }
}


