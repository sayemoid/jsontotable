package dev.sayem.jsontable;

import dev.sayem.jsontotable.HtmlTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JsonToHtmlTableTest {

    @Test
    void jsonToHtmlTableTest() {
        String json = """
                [
                    {
                      "name": "Apple",
                      "color": "Red",
                      "quantity": 10,
                      "isFresh": true
                    },
                    {
                      "name": "Banana",
                      "color": "Yellow",
                      "quantity": 15,
                      "isFresh": true
                    },
                    {
                      "name": "Orange",
                      "color": "Orange",
                      "quantity": 8,
                      "isFresh": false
                    },
                    {
                      "name": "Grapes",
                      "color": "Purple",
                      "quantity": 20,
                      "isFresh": true
                    }
                  ]
                """;

        var htmlTable = HtmlTable.fromJson(json, List.of("boobies"));
        Assertions.assertEquals("""
                <table class="boobies"><thead><tr><th>quantity</th><th>color</th><th>name</th><th>isFresh</th></tr></thead><tbody><tr><td>10</td><td>Red</td><td>Apple</td><td>true</td></tr><tr><td>15</td><td>Yellow</td><td>Banana</td><td>true</td></tr><tr><td>8</td><td>Orange</td><td>Orange</td><td>false</td></tr><tr><td>20</td><td>Purple</td><td>Grapes</td><td>true</td></tr></tbody></table>
                """.trim(), htmlTable.trim());
    }


    @Test
    void mapToHtmlTableTest() {

        LinkedHashMap<String, Object> data = new LinkedHashMap<>();
        data.put("Name", "Fruits");
        data.put("Type", "Citrus");

        LinkedHashMap<String,String> fruits = new LinkedHashMap<>();
        fruits.put("Name", "Apple");
        fruits.put("Color", "Red");
        fruits.put("Taste", "Sweet");

        data.put("Items", fruits);

        var htmlTable = HtmlTable.convertToHtmlTable(data, "boobies boobies-red");
        Assertions.assertEquals("""
                <table class="boobies boobies-red"><thead><tr><th>Name</th><th>Type</th><th>Items</th></tr></thead><tbody><tr><td>Fruits</td><td>Citrus</td><td><table class="boobies boobies-red"><thead><tr><th>Name</th><th>Color</th><th>Taste</th></tr></thead><tbody><tr><td>Apple</td><td>Red</td><td>Sweet</td></tr></tbody></table></td></tr></tbody></table>
                """.trim(), htmlTable.trim());
    }

}
