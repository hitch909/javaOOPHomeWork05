package org.example;

import java.io.IOException;
import java.util.HashMap;

public interface Formats {
    void saveContactTXT(HashMap<String, String> contacts )throws IOException ;
    void loadContactTXT(HashMap<String, String> contacts) throws IOException;
    void saveContaktCSV(HashMap<String, String> contacts) throws IOException;
    void loadContaktCSV(HashMap<String, String> contacts) throws IOException;
}
