package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FamilyReader  {
    HashMap<Integer, Person> Persons = new HashMap<>();

    public FamilyReader (File file) {
        int i = 0;
        try (var reader = new FileReader(file)) {
            int c;
            StringBuilder Check = new StringBuilder();
            String a = "";
            while ((c = reader.read()) != -1) {
                if (Character.isLetter((char) c) | c == 32) {
                    Check.append((char) c);
                    a = Check.toString();
                }
                if (c == 58) {

                    switch (a) {
                        case "Name": {
                            i++;
                            Check.delete(0, Check.length());
                            a = Check.toString();
                            while ((c = reader.read()) != -1) {
                                if (Character.isLetter((char) c)) {
                                    Check.append((char) c);
                                } else {
                                    if (c == 10)
                                        break;
                                    if (c == 46) {
                                        var Name = Check.toString();
                                        Persons.put(i, new Person(Name));
                                        Check.delete(0, Check.length());
                                        break;
                                    } else if (Check.length() != 0 & c == 32)
                                        Check.append(" ");
                                }
                            }
                            break;
                        }
                        case "BirthDate": {
                            Check.delete(0, Check.length());
                            a = Check.toString();
                            while ((c = reader.read()) != -1) {
                                if (Character.isDigit((char) c)) {
                                    Check.append((char) c);
                                }
                                if (c == 46)
                                    break;
                                if (c == 10)
                                    break;
                            }
                            var Name = Check.toString();
                            var BDate = Integer.parseInt(Name);
                            Persons.get(i).setBirthDate(BDate);
                            Check.delete(0, Check.length());
                            break;
                        }
                        case "DeathDate": {
                            Check.delete(0, Check.length());
                            a = Check.toString();
                            while ((c = reader.read()) != -1) {
                                if (Character.isDigit((char) c)) {
                                    Check.append((char) c);
                                }
                                if (c == 46)
                                    break;
                                if (c == 10)
                                    break;
                            }
                            var Name = Check.toString();
                            var DDate = Integer.parseInt(Name);
                            Persons.get(i).setDeathDate(DDate);
                            Check.delete(0, Check.length());
                            break;
                        }
                        case "ancestors": {
                            Check.delete(0, Check.length());
                            a = Check.toString();
                            while ((c = reader.read()) != -1) {
                                if (Character.isLetter((char) c)) {
                                    Check.append((char) c);
                                } else {
                                    if (c == 10)
                                        break;
                                    if (c == 44) {
                                        var Name = Check.toString();
                                        Persons.get(i).AddAnc(new Person(Name));
                                        Check.delete(0, Check.length());
                                    }
                                    if (c == 46) {
                                        var Name = Check.toString();
                                        Persons.get(i).AddAnc(new Person(Name));
                                        Check.delete(0, Check.length());
                                        break;
                                    } else if (Check.length() != 0 & c == 32)
                                        Check.append(" ");
                                }
                            }
                            break;
                        }
                        case "descendants": {
                            Check.delete(0, Check.length());
                            a = Check.toString();
                            while ((c = reader.read()) != -1) {
                                if (Character.isLetter((char) c)) {
                                    Check.append((char) c);
                                } else {
                                    if (c == 10)
                                        break;
                                    if (c == 44) {
                                        var Name = Check.toString();
                                        Persons.get(i).AddAnc(new Person(Name));
                                        Check.delete(0, Check.length());
                                    }
                                    if (c == 46) {
                                        var Name = Check.toString();
                                        Persons.get(i).AddDec(new Person(Name));
                                        Check.delete(0, Check.length());
                                        break;
                                    } else if (Check.length() != 0 & c == 32)
                                        Check.append(" ");
                                }
                            }
                            break;
                        }
                        case "spouses": {
                            Check.delete(0, Check.length());
                            a = Check.toString();
                            while ((c = reader.read()) != -1) {
                                if (Character.isLetter((char) c)) {
                                    Check.append((char) c);
                                } else {
                                    if (c == 44) {
                                        var Name = Check.toString();
                                        Persons.get(i).AddAnc(new Person(Name));
                                        Check.delete(0, Check.length());
                                    }
                                    if (c == 46) {
                                        var Name = Check.toString();
                                        Persons.get(i).AddSp(new Person(Name));
                                        Check.delete(0, Check.length());
                                        break;
                                    } else if (Check.length() != 0 & c == 32)
                                        Check.append(" ");
                                }
                            }
                            break;
                        }
                        default:
                            throw new IOException();
                    }
                }
            }
        } catch ( FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {

        }
    }
}
