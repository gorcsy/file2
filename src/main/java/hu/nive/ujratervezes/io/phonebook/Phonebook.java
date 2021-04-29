package hu.nive.ujratervezes.io.phonebook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output) {
        if (contacts == null || output == null) {
            throw new IllegalArgumentException();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                String name = entry.getKey();
                String phoneNumber = entry.getValue();
                writer.write(name + ": " + phoneNumber + "\n");
            }
        } catch (IOException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
}