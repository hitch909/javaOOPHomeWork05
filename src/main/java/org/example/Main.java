package org.example;
//Создать телефонный справочник с возможностью импорта и экспорта данных в нескольких форматах.

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Phonebook phonebook = new Phonebook();
        HashMap<String, String> contacts = new HashMap<>();

        Phonebook contakt1 = new Phonebook("contact1", "345-867");
        Phonebook contakt2 = new Phonebook("contact2", "142-264");
        Phonebook contakt3 = new Phonebook("contact3", "546-666");
        Phonebook contakt4 = new Phonebook("contact4", "485-267");
        Phonebook contakt5 = new Phonebook("contact5", "744-865");
        Phonebook contakt6 = new Phonebook("contact6", "165-461");
        Phonebook contakt7 = new Phonebook("contact7", "847-247");


        phonebook.addContact(contakt5, contacts);
        phonebook.addContact(contakt7, contacts);
        phonebook.addContact(contakt6, contacts);
        phonebook.addContact(contakt4, contacts);
        phonebook.addContact(contakt3, contacts);
        phonebook.addContact(contakt2, contacts);
        phonebook.addContact(contakt1, contacts);



        Scanner scanner = new Scanner(System.in);
        System.out.print("Hello! Ведите фамилию  абонента:   ");
        String name = scanner.nextLine();
        System.out.print("введите номер телефона:   ");
        String number = scanner.nextLine();
        if (name instanceof String && number instanceof String){
            phonebook.addContactMap(number, name, contacts);
            phonebook.saveContactTXT(contacts);
            phonebook.saveContaktCSV(contacts);
        }

        System.out.println("хотите просмотреть список контактов из TXT файла или  CSV файла");
        System.out.println(" TXT или CSV");
        String choice = scanner.nextLine();
        if (choice.equals("TXT")){
            phonebook.loadContactTXT(contacts);
        }
        if (choice.equals("CSV")){
            phonebook.loadContaktCSV(contacts);
        }
        scanner.close();
        // phonebook.showContaktList(contacts);
    }
}