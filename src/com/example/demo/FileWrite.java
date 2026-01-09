package com.example.demo;

public class FileWrite {
    private float [][] array = new float [800][5];
    private int many;
    public void setArray(int i, int j, float d){
        array[i][j] = d;
    }
    public float getArray(int i, int j){
        return array[i][j];
    }
    public void addMany(){
        this.many += 1;
    }
    public int getMany(){
        return many;
    }
}
