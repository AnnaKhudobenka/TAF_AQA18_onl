package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaseAdapter {
    public Gson gson;


    public void setupApi() {
        gson = new Gson();
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }
}
