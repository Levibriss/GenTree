package com.company;

import java.io.FileNotFoundException;
import java.io.*;
import java.io.IOException;
import java.util.HashMap;

public class Tree {
    private Person root;
    public HashMap<Integer, Person> Persons;

    public  Tree(){
        Persons = new HashMap<>();
    }
    public Tree(File file){

        Persons = new FamilyReader(file).Persons;
        root = Persons.get(1);
        for(int i = 1; i<Persons.size()+1; i++ ){
            AddPerson(Persons.get(i));
        }
    }

    private void AddPerson(Person Per) {
        Person Cur = Per;
        if (!Cur.ancestors.isEmpty()) {
            for (int i = 0; i < Cur.ancestors.size(); i++) {
                Person a = Cur.ancestors.get(i);
                for (int j = 1; j < Persons.size()+1; j++) {
                    Person b = Persons.get(j);
                    if (a.Name.equals(b.Name) & !a.equals(b)) {
                        for (int l = 0; l < b.descendants.size(); l++) {
                            Person Check = b.descendants.get(l);
                            if (Cur.Name.equals(Check.Name)) {
                                Cur.ancestors.set(i, b);
                            }
                        }
                    }
                }
            }
        }
        if (!Cur.spouses.isEmpty()) {
            for (int i = 0; i < Cur.spouses.size(); i++) {
                Person a = Cur.spouses.get(i);
                for (int j = 1; j < Persons.size()+1; j++) {
                    Person b = Persons.get(j);
                    if (a.Name.equals(b.Name)) {
                        for (int l = 0; l < b.spouses.size(); l++) {
                            Person Check = b.spouses.get(l);
                            if (Check.Name.equals(Cur.Name)) {
                                Cur.spouses.set(i, b);
                            }
                        }
                    }
                }
            }
        }
        if (!Cur.descendants.isEmpty()) {
            for (int i = 0; i < Cur.descendants.size(); i++) {
                Person a = Cur.descendants.get(i);
                for (int j = 1; j < Persons.size()+1; j++) {
                    Person b = Persons.get(j);
                    if (a.Name.equals(b.Name)) {
                        for (int l = 0; l < b.ancestors.size(); l++) {
                            Person Check = b.ancestors.get(l);
                            if (Check.Name.equals(Cur.Name)) {
                                Cur.descendants.set(i, b);
                            }
                        }
                    }
                }
            }
        }
    }

    public Person FindPerson (int i){
        return Persons.get(i);
    }
}
