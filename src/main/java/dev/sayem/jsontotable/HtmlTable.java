package dev.sayem.jsontotable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HtmlTable {
    private HtmlTable() {
    }

    public static String fromJson(String json, List<String> cssClasses) {
        if (json == null || json.isEmpty()) throw new RuntimeException("Json can't be null or empty!");
        if (json.trim().startsWith("{")) {
            JSONObject jsonObject = new JSONObject(json);
            return convertToHtmlTable(fromObject(jsonObject), cssClasses);
        } else if (json.trim().startsWith("[")) {
            JSONArray jsonArray = new JSONArray(json);
            return convertToHtmlTable(jsonArray, cssClasses);
        }
        throw new RuntimeException("Provided value doesn't seem to be a json formatted string!");
    }

    private static JSONArray fromObject(JSONObject object) {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(object);
        return jsonArray;
    }

    private static String convertToHtmlTable(JSONArray jsonArray, List<String> cssClasses) {
        if (jsonArray.isEmpty()) return "";
        Object item = jsonArray.get(0);
        if (!(item instanceof JSONObject) && !(item instanceof JSONArray))
            return item.toString();
        if (item instanceof JSONArray)
            return convertToHtmlTable((JSONArray) item, cssClasses);

        Set<String> keys = jsonArray.getJSONObject(0).keySet();
        StringBuilder html = new StringBuilder();
        html.append("<table class=\"").append(String.join(" ", cssClasses)).append("\">");

        // HEAD
        html.append("<thead>").append("<tr>");
        keys.forEach(key -> {
            html.append("<th>").append(key).append("</th>");
        });
        html.append("</tr>").append("</thead>");

        // BODY
        html.append("<tbody>");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            html.append("<tr>");
            keys.forEach(key -> {
                Object value = obj.get(key);
                String toAppend;
                if (value instanceof JSONArray) {
                    toAppend = convertToHtmlTable((JSONArray) value, cssClasses);
                } else if (value instanceof JSONObject) {
                    toAppend = convertToHtmlTable(fromObject((JSONObject) value), cssClasses);
                } else
                    toAppend = value.toString();
                html.append("<td>").append(toAppend).append("</td>");
            });
            html.append("</tr>");
        }
        html.append("</tbody>");

        html.append("</table>");
        return html.toString();
    }
}
