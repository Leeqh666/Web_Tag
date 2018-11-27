package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Review;


/**
 * create by Lee
 */

public class MyJsonProcess {
    private Gson gson;

    public MyJsonProcess() {
        init();
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public void init(){
        gson = new GsonBuilder().enableComplexMapKeySerialization().serializeNulls().
                setPrettyPrinting().disableHtmlEscaping().create();
    }

    public Review getReview(String json){
        return gson.fromJson(json,Review.class);
    }

    public static void main(String args[]){
        String string = "{\"reviewPics\":[{\"picId\":2382710313,\"url\":\"http://p0.where.net/shaitu/acf955a69487acededb5c298432c4ff060759.jpg\",\"status\":1},{\"picId\":2382783615,\"url\":\"http://p0.where.net/shaitu/bd9ce83863e00da3715ce637f0e2422859948.jpg\",\"status\":1}],\"extInfoList\":null,\"expenseList\":null,\"reviewIndexes\":[1,2],\"scoreList\":null}\n";
        MyJsonProcess myJsonProcess = new MyJsonProcess();
        Review review = myJsonProcess.getReview(string);
    }

}
