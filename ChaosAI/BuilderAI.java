import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

public class BuilderAI{
    HashMap<String, String> data = new HashMap<String,String>();
    ArrayList<String> words = new ArrayList<>();
    HashMap<String, String> data2 = new HashMap<String,String>();
    Map <String,ArrayList<String>> data3 = new HashMap<String,ArrayList<String>>();

    BuilderAI(){
        words.add("Something");
        words.add("Something2");
        data.put("Test","Something");
        String key = "Another";
        String word2 = "Some Result";
        if (data3.get(key) == null) {
            data3.put(key, new ArrayList<String>());
        }
        data3.get(key).add(word2);

    
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ID", "1");
        jsonObject.put("First_Name", "Shikhar");
        jsonObject.put("Last_Name", "Dhawan");
        jsonObject.put("Date_Of_Birth", "1981-12-05");
        jsonObject.put("Place_Of_Birth", "Delhi");
        jsonObject.put("Country", "India");
        try {
            FileWriter file = new FileWriter("E:/output.json");
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("JSON file created: "+jsonObject);
    }
}