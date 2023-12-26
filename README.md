# jsontotable
This library converts json object or array to html table

[![](https://jitpack.io/v/sayemkcn/jsontotable.svg)](https://jitpack.io/#sayemkcn/jsontotable)

#### Maven
* Add Jitpack repository if not added already
```xml
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>

```
* Add Dependency
```xml
    <dependency>
        <groupId>com.github.sayemkcn</groupId>
        <artifactId>jsontotable</artifactId>
        <version>v0.5</version>
    </dependency>
```

#### Gradle
* Add Jitpack repository if not added already
```groovy
	allprojects {
 	    repositories {
		...
		maven { url 'https://jitpack.io' }
	   }
	}
```
* Add Dependency
```groovy
	dependencies {
	        implementation 'com.github.sayemkcn:jsontotable:v0.5'
	}
```

## Example

### Input
```json
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
```

### Convert
```java
var htmlTable = HtmlTable.fromJson(json, List.of("boobies"));
String html = HtmlTable.fromJson(json);
```

### Output
```html
<table class="boobies">
    <thead>
    <tr>
        <th>quantity</th>
        <th>color</th>
        <th>name</th>
        <th>isFresh</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>10</td>
        <td>Red</td>
        <td>Apple</td>
        <td>true</td>
    </tr>
    <tr>
        <td>15</td>
        <td>Yellow</td>
        <td>Banana</td>
        <td>true</td>
    </tr>
    <tr>
        <td>8</td>
        <td>Orange</td>
        <td>Orange</td>
        <td>false</td>
    </tr>
    <tr>
        <td>20</td>
        <td>Purple</td>
        <td>Grapes</td>
        <td>true</td>
    </tr>
    </tbody>
</table>

```

![img.png](img.png)



