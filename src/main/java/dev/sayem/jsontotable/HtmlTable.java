package dev.sayem.jsontotable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public class HtmlTable {
	private HtmlTable() {
	}

	public static String fromJson(Map<String, String> headers, String json, List<String> cssClasses) {
		if (json == null || json.isEmpty()) throw new RuntimeException("Json can't be null or empty!");
		if (json.trim().startsWith("{")) {
			JSONObject jsonObject = new JSONObject(json);
			return convertToHtmlTable(fromObject(jsonObject), headers, cssClasses);
		} else if (json.trim().startsWith("[")) {
			JSONArray jsonArray = new JSONArray(json);
			return convertToHtmlTable(jsonArray, headers, cssClasses);
		}
		throw new RuntimeException("Provided value doesn't seem to be a json formatted string!");
	}

	private static JSONArray fromObject(JSONObject object) {
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(object);
		return jsonArray;
	}

	private static String convertToHtmlTable(JSONArray jsonArray, Map<String, String> headers, List<String> cssClasses) {
		if (jsonArray.isEmpty()) return "";
		Object item = jsonArray.get(0);
		if (!(item instanceof JSONObject) && !(item instanceof JSONArray))
			return item.toString();
		if (item instanceof JSONArray)
			return convertToHtmlTable((JSONArray) item, headers, cssClasses);

		StringBuilder html = new StringBuilder();
		html.append("<table class=\"").append(java.lang.String.join(" ", cssClasses)).append("\">");

		// HEAD
		html.append("<thead>").append("<tr>");
		headers.values().forEach(label -> html.append("<th>").append(label).append("</th>"));
		html.append("</tr>").append("</thead>");

		// BODY
		html.append("<tbody>");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject obj = jsonArray.getJSONObject(i);
			html.append("<tr>");
			headers.keySet().forEach(key -> {
				Object value = obj.opt(key);
				String toAppend;
				if (value instanceof JSONArray) {
					toAppend = convertToHtmlTable((JSONArray) value, headers, cssClasses);
				} else if (value instanceof JSONObject) {
					toAppend = convertToHtmlTable(fromObject((JSONObject) value), headers, cssClasses);
				} else
					toAppend = value != null ? value.toString() : "";
				html.append("<td>").append(toAppend).append("</td>");
			});
			html.append("</tr>");
		}
		html.append("</tbody>");

		html.append("</table>");
		return html.toString();
	}

	public static String fromList(List<String> headers, List<List<String>> data, String cssClasses) {
		StringBuilder html = new StringBuilder();

		html.append("<table class=\"").append(String.join(" ", cssClasses)).append("\">");
		// table headers
		html.append("<thead><tr>");
		for (String header : headers) {
			html.append("<th>").append(header).append("</th>");
		}
		html.append("</tr></thead>");

		// table body
		html.append("<tbody>");
		for (List<String> row : data) {
			html.append("<tr>");
			for (String cell : row) {
				html.append("<td>").append(cell).append("</td>");
			}
			html.append("</tr>");
		}
		html.append("</tbody>");

		html.append("</table>");

		return html.toString();
	}


}
