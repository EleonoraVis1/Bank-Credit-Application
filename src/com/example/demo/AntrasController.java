package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.FileWriter;
import java.io.IOException;

public class AntrasController {
    @FXML
    private BarChart<?, ?> j;
    @FXML
    private RadioButton anuiB;
    @FXML
    private Button atask;
    @FXML
    private Label atidL;
    @FXML
    private Label atidL2;
    @FXML
    private Label atidL3;
    @FXML
    private TextField atidM;
    @FXML
    private TextField atidN;
    @FXML
    private Button btn1;
    @FXML
    private AnchorPane ff;
    @FXML
    private TextField filtr;
    @FXML
    private Label filtrmen;
    @FXML
    private Button gen;
    @FXML
    private Label justL;
    @FXML
    private TextField kiekProc;
    @FXML
    private Label grafL;
    @FXML
    private Label lbendr;
    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Label lbl3;
    @FXML
    private Label lbl4;
    @FXML
    private TextField lentB;
    @FXML
    private TextField lentM;
    @FXML
    private TextField lentP;
    @FXML
    private TextField lentS;
    @FXML
    private Label lfiltr;
    @FXML
    private RadioButton liniB;
    @FXML
    private Label lkd;
    @FXML
    private TextField lkdtext;
    @FXML
    private Label lkred;
    @FXML
    private Label llent;
    @FXML
    private Label lmenl;
    @FXML
    private Label lproc;
    @FXML
    private TextField men;
    @FXML
    private Label menL;
    @FXML
    private TextField metai;
    @FXML
    private Label metaiL;
    @FXML
    private Label name1;
    @FXML
    private Label o;
    @FXML
    private TextField pask;
    @FXML
    private Label procL;
    @FXML
    private Label procL2;
    @FXML
    private TextField procentai;
    @FXML
    private Button sumok;
    @FXML
    private TextField txt1;
    @FXML
    private TextField txt2;
    @FXML
    private TextField txt3;
    @FXML
    void anChosen(ActionEvent event) {
        kreditas.setGrafType(false);
    }
    @FXML
    void gautAtaskaita(ActionEvent event) {
        if(Integer.parseInt(filtr.getText()) > 0){
            kreditas.setFiltrMenuo(Integer.parseInt(filtr.getText()));
            try {
                FileWriter myWriter = new FileWriter("ataskaita.txt", true);
                for(int i = kreditas.getFiltrMenuo() - 1; i < fw.getMany(); ++i)
                {
                    myWriter.append("Menuo: "+String.valueOf((int)(fw.getArray(i, 0)))+" Mokėjimo suma: "+String.valueOf(fw.getArray(i, 1))+" Kredito dalis: "+String.valueOf(fw.getArray(i, 2))+" Procentų dalis: "+String.valueOf(fw.getArray(i, 3))+" Likusi dalis: "+String.valueOf(fw.getArray(i, 4))+"\n\n");
                }
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    }
    @FXML
    void generate(ActionEvent event) {
        kreditas.setPaskolosSuma((float)(Math.round(Float.parseFloat(pask.getText())*100.0)/100.0));
        kreditas.setLikusiDalis(kreditas.getPaskolosSuma());
        kreditas.setTerminasY(Integer.parseInt(metai.getText()));
        kreditas.setTerminasM(Integer.parseInt(men.getText()));
        kreditas.setUntil(kreditas.getTerminasY() * 12 + kreditas.getTerminasM() + 1);
        kreditas.setProcent((float)(Math.round(Float.parseFloat(procentai.getText())*10.0)/10.0));
        kreditas.setAtidejimoLaikas(Integer.parseInt(atidM.getText()));
        kreditas.setAtidejimoMenuo(Integer.parseInt(atidN.getText()));
        kreditas.setTerminasM(kreditas.getTerminasM() - kreditas.getAtidejimoLaikas());
        kreditas.setProcentuDalis((float)(Math.round((kreditas.getLikusiDalis()*kreditas.getProcent()/100.0)/12*100.0)/100.0));
        if(kreditas.getAtidejimoLaikas() == 0 || (kreditas.getAtidejimoLaikas() > 0 && kreditas.getAtidejimoMenuo() > 1)){
            if(kreditas.getGrafType()){
                kreditas.setKreditoDalis((float)(Math.round(kreditas.getPaskolosSuma()/(kreditas.getTerminasY()*12+kreditas.getTerminasM())*100.0)/100.0));
                kreditas.setMokejimoSuma(kreditas.getProcentuDalis() + kreditas.getKreditoDalis());
            }
            else{
                kreditas.setKoef((float)(kreditas.getProcent()/12/100.0*((float)Math.pow(1 + kreditas.getProcent()/12/100.0, kreditas.getTerminasY()*12 + kreditas.getTerminasM())))/((float)(Math.pow(1 + kreditas.getProcent()/12/100.0, kreditas.getTerminasY()*12 + kreditas.getTerminasM())) - 1));
                kreditas.setMokejimoSuma((float)(Math.round(kreditas.getKoef()*kreditas.getPaskolosSuma()*100.0)/100.0));
                kreditas.setKreditoDalis((float)(Math.round((kreditas.getMokejimoSuma() - kreditas.getProcentuDalis())*100.0)/100.0));
            }
        }
        else{
            if(kreditas.getGrafType()){
                kreditas.setKreditoDalis((float) 0.0);
                kreditas.setMokejimoSuma(kreditas.getProcentuDalis());
            }
            else{
                kreditas.setKoef((float)(kreditas.getProcent()/12/100.0*((float)Math.pow(1 + kreditas.getProcent()/12/100.0, kreditas.getTerminasY()*12 + kreditas.getTerminasM())))/((float)(Math.pow(1 + kreditas.getProcent()/12/100.0, kreditas.getTerminasY()*12 + kreditas.getTerminasM())) - 1));
                kreditas.setMokejimoSuma(kreditas.getProcentuDalis());
                kreditas.setKreditoDalis((float) 0.0);
            }
        }

        lentM.setText(kreditas.getMenuo()+"");
        lentB.setText(kreditas.getMokejimoSuma()+"");
        lentS.setText(kreditas.getKreditoDalis()+"");
        lentP.setText(kreditas.getProcentuDalis()+"");
        lkdtext.setText(kreditas.getLikusiDalis()+"");
        XYChart.Series series1 = new XYChart.Series();
        series1.getData().add(new XYChart.Data("Credit", kreditas.getKreditoDalis()));
        series1.getData().add(new XYChart.Data("Procent", kreditas.getProcentuDalis()));
        j.getData().addAll(series1);
    }
    @FXML
    void linChosen(ActionEvent event) {
        kreditas.setGrafType(true);
    }
    @FXML
    void sumoketi(ActionEvent event) {
        if(taupomoji.getBalance() - kreditas.getMokejimoSuma() >= 0 && kreditas.getMenuo() < kreditas.getUntil()){
            fw.setArray(fw.getMany(), 0, kreditas.getMenuo());
            fw.setArray(fw.getMany(), 1, kreditas.getMokejimoSuma());
            fw.setArray(fw.getMany(), 2, kreditas.getKreditoDalis());
            fw.setArray(fw.getMany(), 3, kreditas.getProcentuDalis());
            kreditas.addMenuo();
            kreditas.addVisoP(kreditas.getProcentuDalis());
            kiekProc.setText((float)Math.round(kreditas.getVisoP()*100.0)/100.0+"");
            kreditas.setLikusiDalis(kreditas.getLikusiDalis() - kreditas.getKreditoDalis());
            if(kreditas.getAtidejimoLaikas() > 0 && kreditas.getAtidejimoMenuo() == 1){
                if(kreditas.getAtidejimoLaikas() < kreditas.getMenuo()){
                    if(kreditas.getGrafType()){
                        kreditas.setKreditoDalis((float)(Math.round(kreditas.getPaskolosSuma()/(kreditas.getTerminasY()*12+kreditas.getTerminasM())*100.0)/100.0));
                    }
                    else{
                        kreditas.setMokejimoSuma((float)(Math.round(kreditas.getKoef()*kreditas.getPaskolosSuma()*100.0)/100.0));
                    }
                }
            }
            else if(kreditas.getAtidejimoLaikas() > 0 && kreditas.getAtidejimoMenuo() > 1){
                if(kreditas.getMenuo() >= kreditas.getAtidejimoMenuo() && kreditas.getMenuo() < (kreditas.getAtidejimoMenuo() + kreditas.getAtidejimoLaikas())){
                    kreditas.setKreditoDalis((float) 0.0);
                    kreditas.setMokejimoSuma(kreditas.getProcentuDalis());
                }
                else{
                    if(kreditas.getGrafType()){
                        kreditas.setKreditoDalis((float)(Math.round(kreditas.getPaskolosSuma()/(kreditas.getTerminasY()*12+kreditas.getTerminasM())*100.0)/100.0));
                    }
                    else{
                        kreditas.setMokejimoSuma((float)(Math.round(kreditas.getKoef()*kreditas.getPaskolosSuma()*100.0)/100.0));
                    }
                }
            }
            if((kreditas.getMenuo()) % 12 == 1) {
                XYChart.Series series1 = new XYChart.Series();
                kreditas.setProcentuDalis((float) (Math.round((kreditas.getLikusiDalis() * kreditas.getProcent() / 100.0) / 12 * 100.0) / 100.0));
                series1.getData().add(new XYChart.Data("Credit", kreditas.getKreditoDalis()));
                series1.getData().add(new XYChart.Data("Procent", kreditas.getProcentuDalis()));
                j.getData().addAll(series1);
            }
            if(kreditas.getGrafType())
                kreditas.setMokejimoSuma(kreditas.getProcentuDalis() + kreditas.getKreditoDalis());
            else{
                if(kreditas.getAtidejimoLaikas() == 0 || (kreditas.getAtidejimoLaikas() > 0 && kreditas.getAtidejimoMenuo() > 1) || (kreditas.getAtidejimoLaikas() > 0 && kreditas.getAtidejimoMenuo() > 1 && !(kreditas.getMenuo() >= kreditas.getAtidejimoMenuo() && kreditas.getMenuo() < (kreditas.getAtidejimoMenuo() + kreditas.getAtidejimoLaikas())))){
                    kreditas.setKreditoDalis((float)(Math.round((kreditas.getMokejimoSuma() - kreditas.getProcentuDalis())*100.0)/100.0));
                }
            }
            taupomoji.deposit(kreditas.getMokejimoSuma()*(-1));
            txt2.setText((float)Math.round(einamoji.getBalance()*100.0)/100.0+"");
            txt3.setText((float)Math.round(taupomoji.getBalance()*100.0)/100.0+"");
            lentM.setText(kreditas.getMenuo()+"");
            lentB.setText((float)Math.round(kreditas.getMokejimoSuma()*100.0)/100.0+"");
            lentS.setText(kreditas.getKreditoDalis()+"");
            lentP.setText((float)Math.round(kreditas.getProcentuDalis()*100.0)/100.0+"");
            lkdtext.setText((float)Math.round(kreditas.getLikusiDalis()*100.0)/100.0+"");
            fw.setArray(fw.getMany(), 4, kreditas.getLikusiDalis());
            fw.addMany();
        }
    }
    CurrentAccount einamoji = new CurrentAccount();
    SavingAccount taupomoji = new SavingAccount();
    FileWrite fw = new FileWrite();
    Credit kreditas = new Credit();

    @FXML
    void mgtClicked(ActionEvent event) {
        float sum = (float) (Math.round(Float.parseFloat(txt1.getText())*100.0)/100.0);

        boolean tikrinam = einamoji.check(sum);
        if(tikrinam){
            einamoji.deposit(sum);
        }
        else {
            float temp = (float) einamoji.getBalance() + sum - 1000;
            einamoji.deposit(sum - temp);
            taupomoji.deposit(temp);
        }
        txt2.setText((float)Math.round(einamoji.getBalance()*100.0)/100.0+"");
        txt3.setText((float)Math.round(taupomoji.getBalance()*100.0)/100.0+"");
    }
    @FXML
    void initialize() {
        einamoji.setBalance(500);
        taupomoji.setBalance(500);


        atidM.setText(kreditas.getAtidejimoLaikas()+"");
        filtr.setText(kreditas.getFiltrMenuo()+"");
        atidN.setText(kreditas.getAtidejimoMenuo()+"");
        metai.setText(kreditas.getTerminasY()+"");
        men.setText(kreditas.getTerminasM()+"");
        pask.setText(kreditas.getPaskolosSuma()+"");
        procentai.setText(kreditas.getProcent()+"");

        txt1.setText("0");
        txt2.setText((float)Math.round(einamoji.getBalance()*100.0)/100.0+"");
        txt3.setText((float)Math.round(taupomoji.getBalance()*100.0)/100.0+"");
    }
}