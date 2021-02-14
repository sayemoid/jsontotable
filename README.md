# jsontotable
This library converts json object or array to html table

[![](https://jitpack.io/v/sayemkcn/jsontotable.svg)](https://jitpack.io/#sayemkcn/jsontotable)

#### Maven
* Add Jitpack repository if not added already
```aidl
    <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
	
```
* Add Dependency
```aidl
        <dependency>
	    <groupId>com.github.sayemkcn</groupId>
	    <artifactId>jsontotable</artifactId>
	    <version>v0.4</version>
	</dependency>
```

#### Gradle
* Add Jitpack repository if not added already
```aidl
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
* Add Dependency
```aidl
	dependencies {
	        implementation 'com.github.sayemkcn:jsontotable:v0.4'
	}
```

## Example

### Input
```aidl
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
String html = HtmlTable.fromJson(json);

### Output
```aidl
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

![img.png](img.png)



