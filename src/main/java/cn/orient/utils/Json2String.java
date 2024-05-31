package cn.orient.utils;

import cn.orient.utils.entity.JsonOutPut;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Json2String {

    private static String getResponseText(String json){
        Gson gson = new Gson();
        JsonOutPut response = gson.fromJson(json, JsonOutPut.class);
        return response.getOutput().getText();
    }

    private static String responseDivider(String text, String startPoint, String endPoint){
        String responseText = getResponseText(text);
        int startIndex = responseText.indexOf(startPoint);
        int endIndex = responseText.indexOf(endPoint);
        if(startIndex != -1 && endIndex != -1){

            responseText = responseText.substring(startIndex, endIndex);
            log.info("Divider Processing startIndex: {} endIndex: {} responseText: {}", startIndex, endIndex, responseText);

            return responseText;
        }
        return null;
    }

    public static String getHtmlTable(String text){
        return responseDivider(text,"<table>","</table>");
    }

    public static String getHtmlArticle(String text){
        return responseDivider(text,"<body>" ,"</body>");
    }

}
