package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PersonInfo {
    String message = new String();
    public PersonInfo (Person A){
        message += "Name:" + A.Name + "\n";
        message += "BirthDate:" + A.BirthDate + "\n";
        message += "DeathDate:" + A.DeathDate + "\n";
        if(!A.ancestors.isEmpty()) {
            message += "ancestors:";
            for (Person B : A.ancestors) {
                message += " " + B.Name + ",";
            }
            message += "\n";
        }
        if(!A.descendants.isEmpty()) {
            message += "descendants:";
            for (Person B : A.descendants) {
                message += " " + B.Name + ",";
            }
            message += "\n";
        }
        if(!A.spouses.isEmpty()) {
            message += "spouses:";
            for (Person B : A.spouses) {
                message += " " + B.Name + ",";
            }
            message += "\n";
        }
    }
}
