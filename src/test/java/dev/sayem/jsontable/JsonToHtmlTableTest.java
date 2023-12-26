package dev.sayem.jsontable;

import dev.sayem.jsontotable.HtmlTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
        System.out.println(htmlTable);
        Assertions.assertEquals("""
                <table class="boobies"><thead><tr><th>quantity</th><th>color</th><th>name</th><th>isFresh</th></tr></thead><tbody><tr><td>10</td><td>Red</td><td>Apple</td><td>true</td></tr><tr><td>15</td><td>Yellow</td><td>Banana</td><td>true</td></tr><tr><td>8</td><td>Orange</td><td>Orange</td><td>false</td></tr><tr><td>20</td><td>Purple</td><td>Grapes</td><td>true</td></tr></tbody></table>
                """.trim(), htmlTable.trim());
    }
}
