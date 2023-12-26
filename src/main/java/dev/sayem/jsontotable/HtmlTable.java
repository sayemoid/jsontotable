package dev.sayem.jsontotable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Set;

public class HtmlTable {
    private HtmlTable() {
    }

    public static String fromJson(String json) {
        if (json == null || json.isEmpty()) throw new RuntimeException("Json can't be null or empty!");
        if (json.trim().startsWith("{")) {
            JSONObject jsonObject = new JSONObject(json);
            return convertToHtmlTable(jsonObject);
        } else if (json.trim().startsWith("[")) {
            JSONArray jsonArray = new JSONArray(json);
            return convertToHtmlTable(jsonArray);
        }
        throw new RuntimeException("Provided value doesn't seem to be a json formatted string!");
    }

    private static JSONArray fromObject(JSONObject object) {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(object);
        return jsonArray;
    }

    private static String convertToHtmlTable(JSONArray jsonArray) {
        if (jsonArray.isEmpty()) return "";
        Object item = jsonArray.get(0);
        if (!(item instanceof JSONObject) && !(item instanceof JSONArray))
            return item.toString();
        if (item instanceof JSONArray)
            return convertToHtmlTable((JSONArray) item);

        Set<String> keys = jsonArray.getJSONObject(0).keySet();
        StringBuilder html = new StringBuilder();
        html.append("<table style=\"border: 1px solid #ddd; padding: 8px;\">");

        // HEAD
        html.append("<tr style=\"background-color: #4CAF50; color: white;padding-top: 5px; padding-bottom: 5px;\">");
        keys.forEach(key -> {
            html.append("<th style=\"text-align: left;\">").append(key).append("</th>");
        });
        html.append("</tr>");

        // BODY
        html.append("<tbody>");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            html.append("<tr>");
            keys.forEach(key -> {
                Object value = obj.get(key);
                String toAppend;
                if (value instanceof JSONArray) {
                    toAppend = convertToHtmlTable((JSONArray) value);
                } else if (value instanceof JSONObject) {
                    toAppend = convertToHtmlTable(fromObject((JSONObject) value));
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

    private static String convertToHtmlTable(JSONObject jsonObject) {

        // Extract CSS styles for the table
        String tableStyle = jsonObject.optString("tableStyle", "");
        String tHeadStyle = jsonObject.optString("tHeadStyle", "");
        String tBodyStyle = jsonObject.optString("tBodyStyle", "");
        String thStyle = jsonObject.optString("thStyle", "");
        String trStyle = jsonObject.optString("trStyle", "");
        String tdStyle = jsonObject.optString("tdStyle", "");

        // Extract data for the table
        JSONArray rows = jsonObject.getJSONArray("rows");

        Set<String> keys = rows.getJSONObject(0).keySet();
        StringBuilder html = new StringBuilder();
        html.append("<table").append(validateCssStyle(tableStyle));

        // Prepare HEAD
        html.append("<thead").append(validateCssStyle(tHeadStyle)).append("<tr").append(validateCssStyle(trStyle));
        keys.forEach(key -> {
            html.append("<th").append(validateCssStyle(thStyle)).append(key).append("</th>");
        });
        html.append("</tr>").append("</thead>");

        // Prepare BODY
        html.append("<tbody").append(validateCssStyle(tBodyStyle));
        for (int i = 0; i < rows.length(); i++) {
            JSONObject obj = rows.getJSONObject(i);
            html.append("<tr").append(validateCssStyle(trStyle));
            keys.forEach(key -> {
                Object value = obj.get(key);
                String toAppend;
                if (value instanceof JSONArray) {
                    toAppend = convertToHtmlTable((JSONArray) value);
                } else if (value instanceof JSONObject) {
                    toAppend = convertToHtmlTable(fromObject((JSONObject) value));
                } else
                    toAppend = value.toString();
                html.append("<td").append(validateCssStyle(tdStyle)).append(toAppend).append("</td>");
            });
            html.append("</tr>");
        }
        html.append("</tbody>");

        html.append("</table>");
        return html.toString();
    }

    private static String validateCssStyle(String cssValue) {
        if (cssValue.length() > 1) return " style=\"" + cssValue + "\">";
        return ">";
    }
}
