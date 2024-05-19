package org.example.harjoitustyo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
import java.util.Scanner;

/**
 * toteuttaa laskettelukeskuksen välinevuokraamon varausjärjestelmän, joka sisältää
 * asiakkaan tiedot sekä välineet, jotka on mahdollista vuokrata
 */
public class VuokraamoSovellus extends Application implements Tiedot {

    /**
     * tekstikenttä, joka sisältää nimen
     */
    private TextField nimiTf = new TextField();

    /**
     * tekstikenttä, joka sisältää sähköpostiosoitteen
     */
    private TextField sahkopostiTf = new TextField();

    /**
     * tekstikenttä, joka sisältää puhelinnumeron
     */
    private TextField puhTf = new TextField();

    /**
     * tekstikenttä, joka sisältää osoitteen
     */
    private TextField osoiteTf = new TextField();

    /**
     * tekstikenttä, joka sisältää pituuden
     */
    private TextField pituusTf = new TextField();

    /**
     * tekstikenttä, joka sisältää painon
     */
    private TextField painoTf = new TextField();

    /**
     * tekstialue, jossa on asiakkaan tiedot tiedostosta luettuna
     */
    private TextArea alue1 = new TextArea();

    /**
     * tekstialue, jossa on asiakkaan valitsemat välineet
     */
    private TextArea alue2 = new TextArea();

    /**
     * taitotason valinta aloittelija
     */
    private RadioButton taso1 = new RadioButton("Aloittelija");

    /**
     * taitotason valinta kokenut
     */
    private RadioButton taso2 = new RadioButton("Kokenut");

    /**
     * taitotason valinta taitava
     */
    private RadioButton taso3 = new RadioButton("Taitava");

    /**
     * suksien valinta
     */
    private CheckBox sukset = new CheckBox("Laskettelusukset");

    /**
     * monojen valinta
     */
    private CheckBox monot = new CheckBox("Laskettelumonot");

    /**
     * sauvojen valinta
     */
    private CheckBox sauvat = new CheckBox("Sauvat");

    /**
     * lumilaudan valinta
     */
    private CheckBox lumilauta = new CheckBox("Lumilauta");

    /**
     * lautailukenkien valinta
     */
    private CheckBox kengat = new CheckBox("Lautailukengät");

    /**
     * kypärän valinta
     */
    private CheckBox kypara = new CheckBox("Kypärä");

    /**
     * lasien valinta
     */
    private CheckBox lasit = new CheckBox("Lasit");

    /**
     * mikäli taitotaso aloittelija on valittu, tämä lause tulee näkyviin vahvistussivulla
     */
    private Text lause1 = new Text("Harjoitus tekee mestarin!");

    /**
     * mikäli taitotaso kokenut on valittu, tämä lause tulee näkyviin vahvistussivulla
     */
    private Text lause2 = new Text("Kokemus on avain, joka avaa oven uusiin haasteisiin!");

    /**
     * mikäli taitotaso taitava on valittu, tämä lause tulee näkyviin vahvistussivulla
     */
    private Text lause3 = new Text("Taituruutesi laskettelussa toimii inspiraationa muille!");

    /**
     * vuokraamo- olio joka saa parametreiksi asiakkaan tietoja, nämä toimivat oletustietoina
     */
    private Vuokraamo asiakasTiedot = new Vuokraamo("Maija Meikäläinen", "0000000000", "maija@gmail.com",
            "Rantatie 1 00010 Helsinki", 170, 70);

    /**
     * ohjelman käynnistäminen
     */
    @Override
    public void start(Stage primaryStage) {

        // ohjelman tekstit
        Text teksti = new Text(170,30,"Kutjulan Rinteiden Vuokraamo");
        Text onkoTiedotOk = new Text("Ovatko tiedot oikein?");
        Text kiitos = new Text("Kiitos tilauksestasi!");
        teksti.setFont(new Font("Calibri",20));

        // ohjelman napit
        Button nappi = new Button("Valmis");
        Button nappi2 = new Button("OK");
        Button nappi3 = new Button("Takaisin");

        // etusivun viivat
        Line viiva1 = new Line(0,45,570,45);
        Line viiva2 = new Line(0,240,570,240);
        Line viiva3 = new Line(0,410,570,410);

        // viimeisen sivun kuva
        ImageView kuva = new ImageView(new Image("File:src/main/resources/kuvat/laskettelu.png"));

        // vasemman puoleiset kentät tietojen syöttämistä varten
        GridPane henkilotiedot1 = new GridPane(10,15);
        henkilotiedot1.add(new Label("Nimi: "), 0, 0);
        henkilotiedot1.add(nimiTf, 1,0);
        henkilotiedot1.add(new Label("Sähköposti: "),0,1);
        henkilotiedot1.add(sahkopostiTf, 1,1);
        henkilotiedot1.add(new Label("Puhelinnumero: "),0,2);
        henkilotiedot1.add(puhTf, 1,2);
        henkilotiedot1.add(new Label("Osoite: "),0,3);
        henkilotiedot1.add(osoiteTf, 1,3);
        henkilotiedot1.setAlignment(Pos.CENTER_LEFT);
        henkilotiedot1.setTranslateY(10);

        // oikean puoleiset kentät tietojen syöttämistä varten
        GridPane henkilotiedot2 = new GridPane(10,15);
        henkilotiedot2.add(new Label("Pituus: "), 0,0);
        henkilotiedot2.add(pituusTf, 1,0);
        henkilotiedot2.add(new Label("Paino: "),0,1);
        henkilotiedot2.add(painoTf,1,1);
        henkilotiedot2.add(new Label("Taitotaso: "),0,2);
        henkilotiedot2.add(taso1,1,2);
        henkilotiedot2.add(taso2,1,3);
        henkilotiedot2.add(taso3,1,4);
        henkilotiedot2.setAlignment(Pos.CENTER_RIGHT);
        henkilotiedot2.setTranslateY(10);

        // radiobuttonien asettelu ryhma- togglegrouppiin, ettei valintoja voi tehdä montaa samanaikaisesti
        ToggleGroup ryhma = new ToggleGroup();
        taso1.setToggleGroup(ryhma);
        taso2.setToggleGroup(ryhma);
        taso3.setToggleGroup(ryhma);

        // gridpanet lisätään hboxiin
        HBox tiedot = new HBox(35);
        tiedot.getChildren().addAll(henkilotiedot1, henkilotiedot2);

        // vbox laskettelu välineille
        VBox sukset_valineet = new VBox(20);
        Text tekstiSukset = new Text("Laskettelu");
        sukset_valineet.getChildren().addAll(tekstiSukset, sukset, monot, sauvat);

        // vbox lautailu välineille
        VBox lautailu_valineet = new VBox(20);
        Text tekstiLauta = new Text("Lautailu");
        lautailu_valineet.getChildren().addAll(tekstiLauta, lumilauta, kengat);

        // vbox muille välineille
        VBox muut_valineet = new VBox(20);
        Text tekstiMuut = new Text("Muut varusteet");
        muut_valineet.getChildren().addAll(tekstiMuut, kypara, lasit);

        // lopuksi lisätään kaikki välineet yhteen hboxiin, jotta asettelu on helpompaa
        HBox valineet = new HBox(100);
        valineet.setPadding(new Insets(45,10,10,20));
        valineet.getChildren().addAll(sukset_valineet,lautailu_valineet, muut_valineet);

        // ensimmäisen sivun hboxit, vboxit, gridppanet sekä muut elementit sijoitetaan yhteen borderpaneen
        BorderPane paneeli = new BorderPane();
        paneeli.setPadding(new Insets(50,10,10,10));
        paneeli.setCenter(valineet);
        paneeli.setTop(tiedot);
        paneeli.setBottom(nappi);
        paneeli.getChildren().addAll(teksti, viiva1, viiva2, viiva3);

        // nappi nimeltä valmis, napilla siirrytään sivulle kaksi varaussivustolla
        nappi.setFont(new Font(15));
        nappi.setPrefWidth(70);
        nappi.setTranslateX(480);
        nappi.setTranslateY(25);

        // tällä napilla päästään vahvistamaan vuokraus ja siirtymään viimeiselle sivulle eli 3
        nappi2.setFont(new Font(15));
        nappi2.setPrefWidth(70);
        nappi2.setTranslateX(260);

        // tällä napilla päästään tarvittaessa takaisinpäin muuttamaan varaustietoja
        nappi3.setFont(new Font(15));
        nappi3.setPrefWidth(80);

        // teksti ovatko tiedot oikein
        onkoTiedotOk.setTranslateX(240);
        onkoTiedotOk.setFont(Font.font(16));

        // hbox joka sisältää toisen sivun napit ja tekstin
        HBox napitJaTeksti = new HBox();
        napitJaTeksti.setTranslateX(10);
        napitJaTeksti.setTranslateY(420);
        napitJaTeksti.getChildren().addAll(nappi3, onkoTiedotOk, nappi2);

        // uusi paneeli johon laitetaan varaussivun toisen sivun tekstialueet sekä hbox
        Pane paneeli2 = new Pane();
        alue1.setPrefHeight(190);
        alue1.setPrefWidth(550);
        alue1.setTranslateX(10);
        alue1.setTranslateY(10);
        alue1.setEditable(false);

        alue2.setPrefHeight(190);
        alue2.setPrefWidth(550);
        alue2.setTranslateX(10);
        alue2.setTranslateY(210);
        alue2.setEditable(false);

        paneeli2.getChildren().addAll(alue1, alue2, napitJaTeksti);
        paneeli2.setVisible(false);

        // paneeli kolmannen sivun teksteille sekä kuvalle
        Pane paneeli3 = new Pane();
        kuva.setTranslateX(20);
        kuva.setTranslateY(250);
        kuva.setFitHeight(200);
        kuva.setFitWidth(200);

        kiitos.setTranslateX(190);
        kiitos.setTranslateY(160);
        kiitos.setFont(Font.font(25));

        lause1.setTranslateX(190);
        lause1.setTranslateY(180);
        lause1.setVisible(false);

        lause2.setTranslateX(190);
        lause2.setTranslateY(180);
        lause2.setVisible(false);

        lause3.setTranslateX(190);
        lause3.setTranslateY(180);
        lause3.setVisible(false);

        paneeli3.getChildren().addAll(kuva, kiitos, lause1, lause2, lause3);
        paneeli3.setVisible(false);

        // lopuksi vielä yksi paneeli, johon lisätään kaikki paneelit
        Pane paneeli4 = new Pane();
        paneeli4.getChildren().addAll(paneeli,paneeli2, paneeli3);

        /**
         * asettaa ensimmäisen sivun tiedot piiloon sekä käyttää metodeja
         */
        nappi.setOnAction(e -> {
            paneeli.setVisible(false);
            paneeli2.setVisible(true);
            tallennaTiedot();
            valineValinta();
            lueTiedot();
            System.out.println("Yhteenveto \n" + asiakasTiedot);

        });

        /**
         * asettaa toisen sivun tiedot piiloon ja kiittää varauksesta
         */
        nappi2.setOnAction(e -> {
            paneeli2.setVisible(false);
            paneeli3.setVisible(true);
            taitoTasoLause();

        });

        /**
         * nappi piilottaa toisen sivun elementit sekä palauttaa ensimmäisen sivun paneelin näkyviin
         */
        nappi3.setOnAction(e -> {
            paneeli.setVisible(true);
            paneeli2.setVisible(false);
            alue1.clear();
            alue2.clear();

        });

        /**
         * toteuttaa oletustiedot metodin, eli asettaa olion mukaiset tiedot tekstikenttiin
         */
        primaryStage.setOnShowing(e -> oletusTiedot());

        Scene kehys = new Scene(paneeli4, 570,460);
        primaryStage.setScene(kehys);
        primaryStage.setTitle("Harjoitustyö");
        primaryStage.show();

    }

    /**
     * metodi hakee luodusta vuokraamo- oliosta sen tiedot ja lisää ne tekstikenttiin
     */
    public void oletusTiedot() {
        nimiTf.setText(asiakasTiedot.getNimi());
        puhTf.setText(asiakasTiedot.getPuh());
        sahkopostiTf.setText(asiakasTiedot.getSapo());
        osoiteTf.setText(asiakasTiedot.getOsoite());
        pituusTf.setText(String.valueOf(asiakasTiedot.getPituus()));
        painoTf.setText(String.valueOf(asiakasTiedot.getPaino()));
    }

    /**
     * asettaa asiakasTiedot- oliolle uudet arvot hakemalla tiedot käyttäjän muuttamista tekstikentistä
     * lisäksi tiedot lisätään asiakastiedot.txt tiedostoon, josta ne haetaan käyttämällä metodia lueTiedot().
     */
    public void tallennaTiedot() {
        asiakasTiedot.setNimi(nimiTf.getText());
        asiakasTiedot.setPuh(puhTf.getText());
        asiakasTiedot.setSapo(sahkopostiTf.getText());
        asiakasTiedot.setOsoite(osoiteTf.getText());
        asiakasTiedot.setPituus(Double.parseDouble(pituusTf.getText()));
        asiakasTiedot.setPaino(Double.parseDouble(painoTf.getText()));

        try (PrintWriter tiedosto1 = new PrintWriter(new FileWriter("asiakastiedot.txt"))) {
            tiedosto1.println(asiakasTiedot);

        } catch (IOException e) {
            System.err.println("Tiedostoon tallentaminen epäonnistui");
        }
    }

    /**
     * metodi hakee tallennetut tiedot tekstitiedostosta asiakastiedot.txt ja lukee sitä kunnes siellä ei ole enää
     * luettavia rivejä. metodi luo myös stringbuilderin- tiedot, jonne kaikki luettava tallennetaan rivivaihdoilla.
     * lopuksi stringbuilderin sisältö lisätään alue1 tekstikenttään käyttäen vuokraamo- luokan toString metodia.
     */
    public void lueTiedot() {
        try (Scanner tiedosto2 = new Scanner(new File("asiakastiedot.txt"))) {
            StringBuilder tiedot = new StringBuilder();
            while (tiedosto2.hasNextLine()) {
                tiedot.append(tiedosto2.nextLine()).append("\n");
            } alue1.setText(tiedot.toString());

        } catch (FileNotFoundException e) {
            System.err.println("Tiedostoa ei löytynyt");
        }
    }

    /**
     * metodi lisää käyttäjän tekemät valinnat rivienvaihdoilla alue2- tekstialueeseen
     */
    public void valineValinta() {
        StringBuilder valinnat = new StringBuilder();
        if (sukset.isSelected()) valinnat.append(sukset.getText()).append("\n");
        if (monot.isSelected()) valinnat.append(monot.getText()).append("\n");
        if (sauvat.isSelected()) valinnat.append(sauvat.getText()).append("\n");
        if (lumilauta.isSelected()) valinnat.append(lumilauta.getText()).append("\n");
        if (kengat.isSelected()) valinnat.append(kengat.getText()).append("\n");
        if (kypara.isSelected()) valinnat.append(kypara.getText()).append("\n");
        if (lasit.isSelected()) valinnat.append(lasit.getText()).append("\n");
        alue2.setText("Valitut välineet\n\n" + valinnat);
    }

    /**
     * metodi tarkistaa minkä taitotason asiakas on valinnut ja sen perusteella näyttää jonkin inspiroivan lauseen
     * varauksen viimeisellä sivulla
     */
    public void taitoTasoLause() {
        if (taso1.isSelected()) lause1.setVisible(true);
        if (taso2.isSelected()) lause2.setVisible(true);
        if (taso3.isSelected()) lause3.setVisible(true);
    }

    /**
     * ajaa ohjelman
     * @param args ajaa ohjelman
     */
    public static void main(String[] args) {
        launch(args);
    }
}




