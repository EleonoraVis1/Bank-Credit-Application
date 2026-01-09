package com.example.demo;

public class Credit {
    private float paskolosSuma;
    private int terminasY;
    private int terminasM;
    private boolean grafType;
    private float procent;
    private float aProcent = 2;
    private int atidejimoLaikas;
    private int atidejimoMenuo = 1;
    private int filtrMenuo = 1;
    private int menuo = 1;
    private float mokejimoSuma;
    private float kreditoDalis;
    private float procentuDalis;
    private float likusiDalis;
    private float koef;
    private int until;
    private float visoP;
    public float getVisoP(){
        return visoP;
    }
    public void addVisoP(float visoP){
        this.visoP += visoP;
    }
    public int getUntil(){
        return until;
    }
    public void setUntil(int until){
        this.until = until;
    }

    public float getPaskolosSuma(){
        return paskolosSuma;
    }
    public void setPaskolosSuma(float paskolosSuma){
        this.paskolosSuma = paskolosSuma;
    }
    public int getTerminasY(){
        return terminasY;
    }
    public void setTerminasY(int terminasY){
        this.terminasY = terminasY;
    }
    public int getTerminasM(){
        return terminasM;
    }
    public void setTerminasM(int terminasM){
        this.terminasM = terminasM;
    }
    public boolean getGrafType(){
        return grafType;
    }
    public void setGrafType(boolean grafType){
        this.grafType = grafType;
    }
    public float getProcent(){
        return procent;
    }
    public void setProcent(float procent){
        this.procent = procent;
    }
    public float getAProcent(){
        return aProcent;
    }
    public int getAtidejimoLaikas(){
        return atidejimoLaikas;
    }
    public void setAtidejimoLaikas(int atidejimoLaikas){
        this.atidejimoLaikas = atidejimoLaikas;
    }
    public int getAtidejimoMenuo(){
        return atidejimoMenuo;
    }
    public void setAtidejimoMenuo(int atidejimoMenuo){
        this.atidejimoMenuo = atidejimoMenuo;
    }
    public int getFiltrMenuo(){
        return filtrMenuo;
    }
    public void setFiltrMenuo(int filtrMenuo){
        this.filtrMenuo = filtrMenuo;
    }
    public int getMenuo(){
        return menuo;
    }
    public void addMenuo(){
        this.menuo += 1;
    }
    public float getMokejimoSuma(){
        return mokejimoSuma;
    }
    public void setMokejimoSuma(float mokejimoSuma){
        this.mokejimoSuma = mokejimoSuma;
    }
    public float getKreditoDalis(){
        return kreditoDalis;
    }
    public void setKreditoDalis(float kreditoDalis){
        this.kreditoDalis = kreditoDalis;
    }
    public float getProcentuDalis(){
        return procentuDalis;
    }
    public void setProcentuDalis(float procentuDalis){
        this.procentuDalis = procentuDalis;
    }
    public float getLikusiDalis(){
        return likusiDalis;
    }
    public void setLikusiDalis(float likusiDalis){
        this.likusiDalis = likusiDalis;
    }
    public float getKoef(){
        return koef;
    }
    public void setKoef(float koef){
        this.koef = koef;
    }
}
