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
	    <version>v0.4</version>
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
	        implementation 'com.github.sayemkcn:jsontotable:v0.4'
	}
```

## Example

### Input
```json
[
  {
    "UserID": 1,
    "UserName": "rooter",
    "Password": "12345",
    "Country": "UK",
    "Email": "sac@gmail.com"
  },
  {
    "UserID": 2,
    "UserName": "binu",
    "Password": "123",
    "Country": "uk",
    "Email": "Binu@gmail.com"
  },
  {
    "UserID": 3,
    "UserName": "cal",
    "Password": "123",
    "Country": "uk",
    "Email": "cal@gmail.com"
  },
  {
    "UserID": 4,
    "UserName": "nera",
    "Password": "1234",
    "Country": "uk",
    "Email": "nera@gmail.com"
  }
]
```

### Convert
`String html = HtmlTable.fromJson(json);`

### Output
```html
<table class="table table-striped">
	<tr>
		<th>UserName</th>
		<th>Email</th>
		<th>UserID</th>
		<th>Country</th>
		<th>Password</th>
	</tr>
	<tbody>
		<tr>
			<td>rooter</td>
			<td>sac@gmail.com</td>
			<td>1</td>
			<td>UK</td>
			<td>12345</td>
		</tr>
		<tr>
			<td>binu</td>
			<td>Binu@gmail.com</td>
			<td>2</td>
			<td>uk</td>
			<td>123</td>
		</tr>
		<tr>
			<td>cal</td>
			<td>cal@gmail.com</td>
			<td>3</td>
			<td>uk</td>
			<td>123</td>
		</tr>
		<tr>
			<td>nera</td>
			<td>nera@gmail.com</td>
			<td>4</td>
			<td>uk</td>
			<td>1234</td>
		</tr>
	</tbody>
</table>

```

## Example With CSS Design

### Input
```json
{
  "tableStyle": "border: 1px solid #ddd; padding: 8px;",
  "tHeadStyle": "border: 1px solid #ddd; padding: 8px;",
  "tBodyStyle": "border: 1px solid #ddd; padding: 8px;",
  "thStyle": "border: 1px solid #ddd; padding: 8px;",
  "trStyle": "border: 1px solid #ddd; padding: 8px;",
  "tdStyle": "border: 1px solid #ddd; padding: 8px;",
  "rows": [
    {
      "UserID": 1,
      "UserName": "rooter",
      "Password": "12345",
      "Country": "UK",
      "Email": "sac@gmail.com"
    },
    {
      "UserID": 2,
      "UserName": "binu",
      "Password": "123",
      "Country": "uk",
      "Email": "Binu@gmail.com"
    },
    {
      "UserID": 3,
      "UserName": "cal",
      "Password": "123",
      "Country": "uk",
      "Email": "cal@gmail.com"
    },
    {
      "UserID": 4,
      "UserName": "nera",
      "Password": "1234",
      "Country": "uk",
      "Email": "nera@gmail.com"
    }
  ]
}
```

### Output

```html
<table style="border: 1px solid #ddd; padding: 8px;">
  <thead style="border: 1px solid #ddd; padding: 8px;">
    <tr style="border: 1px solid #ddd; padding: 8px;">
      <th style="border: 1px solid #ddd; padding: 8px;">UserName</th>
      <th style="border: 1px solid #ddd; padding: 8px;">Email</th>
      <th style="border: 1px solid #ddd; padding: 8px;">UserID</th>
      <th style="border: 1px solid #ddd; padding: 8px;">Country</th>
      <th style="border: 1px solid #ddd; padding: 8px;">Password</th>
    </tr>
  </thead>
  <tbody style="border: 1px solid #ddd; padding: 8px;">
    <tr style="border: 1px solid #ddd; padding: 8px;">
      <td style="border: 1px solid #ddd; padding: 8px;">rooter</td>
      <td style="border: 1px solid #ddd; padding: 8px;">sac@gmail.com</td>
      <td style="border: 1px solid #ddd; padding: 8px;">1</td>
      <td style="border: 1px solid #ddd; padding: 8px;">UK</td>
      <td style="border: 1px solid #ddd; padding: 8px;">12345</td>
    </tr>
    <tr style="border: 1px solid #ddd; padding: 8px;">
      <td style="border: 1px solid #ddd; padding: 8px;">binu</td>
      <td style="border: 1px solid #ddd; padding: 8px;">Binu@gmail.com</td>
      <td style="border: 1px solid #ddd; padding: 8px;">2</td>
      <td style="border: 1px solid #ddd; padding: 8px;">uk</td>
      <td style="border: 1px solid #ddd; padding: 8px;">123</td>
    </tr>
    <tr style="border: 1px solid #ddd; padding: 8px;">
      <td style="border: 1px solid #ddd; padding: 8px;">cal</td>
      <td style="border: 1px solid #ddd; padding: 8px;">cal@gmail.com</td>
      <td style="border: 1px solid #ddd; padding: 8px;">3</td>
      <td style="border: 1px solid #ddd; padding: 8px;">uk</td>
      <td style="border: 1px solid #ddd; padding: 8px;">123</td>
    </tr>
    <tr style="border: 1px solid #ddd; padding: 8px;">
      <td style="border: 1px solid #ddd; padding: 8px;">nera</td>
      <td style="border: 1px solid #ddd; padding: 8px;">nera@gmail.com</td>
      <td style="border: 1px solid #ddd; padding: 8px;">4</td>
      <td style="border: 1px solid #ddd; padding: 8px;">uk</td>
      <td style="border: 1px solid #ddd; padding: 8px;">1234</td>
    </tr>
  </tbody>
</table>
```

![img.png](img.png)



