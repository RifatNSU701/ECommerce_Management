
package login;

import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class DataHandler {
    
    public static void writeUserData(String userType, String username, String email, String Name, String phone, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("userdata.txt", true))) {
            //This will append user data to the file and won't delete previous data
            writer.write(userType+ "," +username + "," + email + "," + Name + "," + phone + "," + password);
            writer.newLine(); // This will create next line for other data
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing user data to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public static List<String[]> readUserData() {
        List<String[]> userDataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("userdata.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                // Here, you can process the userData array, which contains the fields of each line
                // For example, you can store it in a list or map
                // For simplicity, let's just add it to a list
                userDataList.add(userData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userDataList;
    }
    
    
}
