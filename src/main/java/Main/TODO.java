package Main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.util.Scanner;

public class TODO {
    private String username;
    private static final JSONObject todolist = new JSONObject();
    TODO(String username){
        this.username = username;
    }

    public boolean doesUserHaveList(){
        return todolist.containsKey(username);
    }

    public void writeToFile() {
        try {
            FileWriter file = new FileWriter("TODO.json");
            file.write(todolist.toJSONString());
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createList(Scanner scnr){
        JSONArray array = new JSONArray();
        System.out.println("How many tasks would you like to add?");
        int i = scnr.nextInt();
        for(int j = 0; j < i; j++){
            System.out.println("Please enter the task you would like to add");
            String task = scnr.nextLine();
            array.add(task);
        }
        todolist.put(username, array);
        writeToFile();
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter your username below :");
        String username = scnr.nextLine();
        TODO user = new TODO(username);
        if(!user.doesUserHaveList()){
            user.createList(scnr);
        }
    }
}
