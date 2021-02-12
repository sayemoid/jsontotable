package dev.sayem.jsontotable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HtmlTable {
    private HtmlTable() {
    }

    public static String fromJson(String json) {
        if (json == null || json.isEmpty()) throw new RuntimeException("Json can't be null or empty!");
        if (json.trim().startsWith("{")) {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray =new JSONArray();
            jsonArray.put(jsonObject);
            return convertToHtmlTable(jsonArray);
        } else if (json.trim().startsWith("[")) {
            JSONArray jsonArray = new JSONArray(json);
            return convertToHtmlTable(jsonArray);
        }
        throw new RuntimeException("Provided value doesn't seem to be a json formatted string!");
    }

    private static String convertToHtmlTable(JSONArray jsonArray) {
        if (jsonArray.isEmpty()) return "";
        Set<String> keys = jsonArray.getJSONObject(0).keySet();
        StringBuilder html = new StringBuilder();
        html.append("<table class=\"table table-striped\">");

        // HEAD
        html.append("<tr>");
        keys.forEach(key -> {
            html.append("<th>").append(key).append("</th>");
        });
        html.append("</tr>");

        // BODY
        html.append("<tbody>");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            html.append("<tr>");
            keys.forEach(key -> {
                html.append("<td>").append(obj.get(key)).append("</td>");
            });
            html.append("</tr>");
        }
        html.append("</tbody>");

        html.append("</table>");
        return html.toString();
    }
}
