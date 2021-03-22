package tournament;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;

public class Readfiles {

    public static ReadJson[] getJsonPlayers(String jsonFile) throws IOException {

        Gson gson = new Gson();

        FileReader fileReader = new FileReader(jsonFile);
        JsonReader jsonReader= new JsonReader(fileReader);
        ReadJson[] data = gson.fromJson(jsonReader, ReadJson[].class);

        return data;
    }
}
