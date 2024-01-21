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
    void listToHtmlTableTest() {

        List<String> headers = List.of("Name", "Age", "City");
        List<List<String>> data = List.of(
                List.of("John", "25", "New York"),
                List.of("Alice", "30", "San Francisco")
        );

        String htmlTable = HtmlTable.toHtml(headers, data,"boobies boobies-red");

        Assertions.assertEquals("""
                <table class="boobies boobies-red"><thead><tr><th>Name</th><th>Age</th><th>City</th></tr></thead><tbody><tr><td>John</td><td>25</td><td>New York</td></tr><tr><td>Alice</td><td>30</td><td>San Francisco</td></tr></tbody></table>
                """.trim(), htmlTable.trim());
    }

}
