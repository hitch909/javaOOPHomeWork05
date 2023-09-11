package org.example;

import lombok.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Getter
@ToString
public class Phonebook implements Formats {
   private String name;
    private  String number;

    public Phonebook(String name, String number) {
        this.name = name;
        this.number = number;
    }

    private  HashMap<String, String> contacts = new HashMap<>();
    public void addContactMap(String name, String number, HashMap<String, String>contacts){
        contacts.put(number, name);
    }

    public  void addContact(Phonebook phonebook, HashMap<String, String> contacts  ){
        contacts.put(phonebook.getNumber(), phonebook.getName());
   }
   public  void showContaktList(HashMap<String, String> contacts){
       System.out.println("Телефонный справочник: ");
       for(Map.Entry<String,String> k: contacts.entrySet()){
           System.out.println(k.getValue()+": "+ k.getKey());
       }
   }

    public   void saveContactTXT(HashMap<String, String> contacts )throws IOException  {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("phone.txt")));
        for(Map.Entry<String,String> k: contacts.entrySet()){
            writer.write(k.getKey() + " " + k.getValue()+System.lineSeparator());
        }
        writer.close();
    }


    public  void loadContactTXT(HashMap<String, String> contacts) throws IOException {
        System.out.println("сохраненные контакты");
        File file = new File("phone.txt");
        if (file.exists()){
            BufferedReader reader = new BufferedReader(new FileReader(new File("phone.txt")));
            String act;
            while ((act=reader.readLine())!=null) {
                String[] dat = act.split(" ");
                contacts.put(dat[0], dat[1]);

            }
            for(Map.Entry<String, String> pair : contacts.entrySet())
            {
                String name = pair.getValue();
                String number = pair.getKey();
                System.out.println( number+" = " +name);
            }
            reader.close();
        }
    }

    @Override
    public void saveContaktCSV(HashMap<String, String> contacts) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("phone.csv")));
        for(Map.Entry<String,String> k: contacts.entrySet()){
            writer.write(k.getKey() + " " + k.getValue()+System.lineSeparator());
        }
        writer.close();
    }

    @Override
    public void loadContaktCSV(HashMap<String, String> contacts) throws IOException {
        System.out.println("сохраненные контакты");
        File file = new File("phone.csv");
        if (file.exists()){
            BufferedReader reader = new BufferedReader(new FileReader(new File("phone.csv")));
            String act;
            while ((act=reader.readLine())!=null) {
                String[] dat = act.split(" ");
                contacts.put(dat[0], dat[1]);

            }
            for(Map.Entry<String, String> pair : contacts.entrySet())
            {
                String name = pair.getValue();
                String number = pair.getKey();
                System.out.println( number+" ----- " +name);
            }
            reader.close();
        }
    }
}
