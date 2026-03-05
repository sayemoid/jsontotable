package dev.sayem.jsontotable;

import java.util.LinkedHashMap;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		var headers = new LinkedHashMap<String, String>();
		headers.put("UserName", "User");
		headers.put("Country", "Country");
		headers.put("Email", "Email");

		System.out.println(HtmlTable.fromJson(headers, getJsonString(), List.of("c1", "c2")));
	}

	private static String getJsonString() {
		return "[\n" +
				"  {\n" +
				"    \"UserID\": 1,\n" +
				"    \"UserName\": \"rooter\",\n" +
				"    \"Password\": \"12345\",\n" +
				"    \"Country\": \"UK\",\n" +
				"    \"Email\": \"sac@gmail.com\"\n" +
				"  },\n" +
				"  {\n" +
				"    \"UserID\": 2,\n" +
				"    \"UserName\": \"binu\",\n" +
				"    \"Password\": \"123\",\n" +
				"    \"Country\": \"uk\",\n" +
				"    \"Email\": \"Binu@gmail.com\"\n" +
				"  },\n" +
				"  {\n" +
				"    \"UserID\": 3,\n" +
				"    \"UserName\": \"cal\",\n" +
				"    \"Password\": \"123\",\n" +
				"    \"Country\": \"uk\",\n" +
				"    \"Email\": \"cal@gmail.com\"\n" +
				"  },\n" +
				"  {\n" +
				"    \"UserID\": 4,\n" +
				"    \"UserName\": \"nera\",\n" +
				"    \"Password\": \"1234\",\n" +
				"    \"Country\": \"uk\",\n" +
				"    \"Email\": \"nera@gmail.com\"\n" +
				"  }\n" +
				"]";
	}
}
