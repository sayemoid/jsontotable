package dev.sayem.jsontotable;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> cssClasses = new ArrayList<>();

        cssClasses.add("c1");
        cssClasses.add("c2");
        System.out.println(HtmlTable.fromJson(getJsonString(), cssClasses));
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
