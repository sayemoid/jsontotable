package dev.sayem.jsontotable;

public class Main {
    public static void main(String[] args) {
        String json = " {\n" +
                "    \"UserID\": 1,\n" +
                "    \"UserName\": \"rooter\",\n" +
                "    \"Password\": \"12345\",\n" +
                "    \"Country\": \"UK\",\n" +
                "    \"Email\": \"sac@gmail.com\"\n" +
                "  }";
        System.out.println(HtmlTable.fromJson(json));
    }
}
