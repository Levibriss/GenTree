package com.company;

import java.util.ArrayList;

public class Person {
    String Name;
    int BirthDate;
    int DeathDate;     // имеет ли смысл?
    ArrayList<com.company.Person> ancestors;     //предки (родители) может стоит просто сделать массив из двух элементов????
    ArrayList<com.company.Person> descendants;   //потомки
    ArrayList<com.company.Person> spouses;       //супруги. Стоит ли делать список/массив? Может, стоит сделать просто переменную?

    public Person() {
        Name = "NoNome";
        ancestors = new ArrayList<>();
        descendants = new ArrayList<>();
        spouses = new ArrayList<>();
    }

    public Person(String N,  int BDay, int DDay){
        Name = N;
        BirthDate = BDay;
        DeathDate = DDay;
    }
    public Person(String N){
        Name = N;
        ancestors = new ArrayList<>();
        descendants = new ArrayList<>();
        spouses = new ArrayList<>();
    }
    public void SetName(String N){
        Name = N;
    }

    public void setBirthDate(int B){
        BirthDate = B;
    }

    public void setDeathDate(int  D){
        DeathDate = D;
    }

    public void AddAnc(ArrayList PersonL){
        ancestors = PersonL;
    }

    public void AddDec(ArrayList PersonL){
        descendants = PersonL;
    }

    public void AddSp(ArrayList PersonL){
        spouses = PersonL;
    }

    public void AddAnc(Person Anc){
        if (ancestors.isEmpty()){
            ancestors= new ArrayList<>();
        }
        ancestors.add(Anc);
    }
    public void AddDec(Person Dec){
        if (descendants.isEmpty()){
            descendants = new ArrayList<>();
        }
        descendants.add(Dec);
    }
    public void AddSp(com.company.Person Sp){
        if (spouses.isEmpty()){
            spouses = new ArrayList<>();
        }
        spouses.add(Sp);
        Sp.spouses.add(this);
    }
    public void DeleteAnc(com.company.Person Anc){
        ancestors.remove(Anc);
    }
    public void DeleteDec(com.company.Person Dec){
        descendants.remove(Dec);
    }
    public void DeleteSp(com.company.Person Sp){
        spouses.remove(Sp);
    }
}
