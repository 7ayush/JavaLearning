<img src="https://r2cdn.perplexity.ai/pplx-full-logo-primary-dark%402x.png" style="height:64px;margin-right:32px"/>
# Java Strings: In-Depth Notes

## 1. Internal String Representation

- Before Java 9, Java Strings use a `char` array internally with UTF-16 encoding (2 bytes per character).
- From Java 9 onwards, Java optimizes strings with *compact strings*: if the string contains only ISO-8859-1/Latin-1 characters, it is represented internally by a `byte` array (1 byte per character). This reduces memory usage.
- Strings are immutable — once created, they cannot be changed.


## 2. Creating Strings

- Use the `new` operator: `String s = new String("Hello World");`
- Or directly use string literals (more common): `String s = "Hello World";`
- String literals are stored in a constant pool. The JVM reuses the same literal instance across the program.


## 3. String Literals as Constants / Singletons

- Identical string literals point to the same String object in the constant pool.
- Example:

```java
String s1 = "Hello";
String s2 = "Hello";
// s1 == s2 is true because both reference the same object
```

- To guarantee different objects, explicitly use `new String("Hello")`.


## 4. Escape Characters in Strings

- Common escapes: `\\` (backslash), `\t` (tab), `\r` (carriage return), `\n` (newline).
- Example:

```java
String s = "\tIndented line\nNext line";
```


## 5. Java Text Blocks (since Java 13)

- Multi-line string literals enclosed in triple quotes `"""`.
- Allows including newlines and quotes without escapes.
- Indentation inside text blocks is automatically managed by the compiler based on the position of the closing quotes.

Example:

```java
String textBlock = """
    This is a multi-line
    text block with "quotes"
    and new lines
    """;
```


## 6. String Concatenation

- Strings are immutable; concatenation creates new objects.
- Simple concatenation uses `+` operator, compiled to use `StringBuilder` internally.
- In loops, use a single `StringBuilder` instance to avoid performance overhead.

```java
StringBuilder sb = new StringBuilder();
for (String part : parts) {
    sb.append(part);
}
String result = sb.toString();

String one = "Hello";
String two = "World";

String three = one + " " + two;
String threeAlt = new StringBuilder(one).append(two).toString();

```


## 7. String Length

- Use `length()` method to get the number of characters. It counts characters, not bytes.

```java
int len = "Hello".length(); // returns 5
```


## 8. Substrings

- Use `substring(int beginIndex, int endIndex)` method.
- The `beginIndex` is inclusive; `endIndex` is exclusive.

```java
String s = "Hello World";
String sub = s.substring(0, 5); // "Hello"
```


## 9. Searching Strings

- Use `indexOf(String)` to find the first occurrence of a substring.
- Returns the index or -1 if not found.
- Can specify a starting index for searching.
- Use `lastIndexOf(String)` to find the last occurrence.

Example:

```java
String s = "is this good or is this bad?";
int index = s.indexOf("is");       // 0
int nextIndex = s.indexOf("is", index + 1);  // 5
int lastIndex = s.lastIndexOf("is"); // 21
```


***
## **10. Matching Strings with Regular Expressions – `matches()`**

- Checks if the **entire** string matches the regex.
- Returns `true`/`false`.

```java
String text = "one two three two one";
boolean match = text.matches(".*two.*"); // true
```

- `matches()` always tries to match the **entire string** — so wrap patterns with `.*` for “contains”.

***

## **11. Comparing Strings**

### `equals()`

- Compares strings **character by character**, **case-sensitive**.

```java
"Hello".equals("Hello") // true
"Hello".equals("hello") // false
```


### `equalsIgnoreCase()`

- Case-insensitive version of `equals()`.


### `startsWith()` / `endsWith()`

```java
String str = "This is a good day to code";
str.startsWith("This");         // true
str.startsWith("is", 5);        // false (index 5 = 'i')
str.endsWith("code");           // true
```


### `compareTo()`

- Lexicographical (dictionary) comparison.
- Returns:
    - Negative if this < other
    - 0 if equal
    - Positive if this > other

```java
"abc".compareTo("def"); // -3
"abc".compareTo("abd"); // -1
```

- Uses **Unicode values** → may not be language-natural sort. For locale-aware, use `Collator`.

***

## **12. Trimming Strings – `trim()`**

- Removes leading/trailing **whitespace** (`' '`, `\t`, `\n`, etc.).
- Returns **new String**, original unchanged.

```java
"  Hello World  ".trim(); // "Hello World"
```


***

## **13. Replacing Characters \& Substrings**

### `replace(char old, char new)`

Replaces **all** char matches.

```java
"abcabc".replace('a','@'); // "@bc@bc"
```


### `replaceFirst(regex, replacement)`

- Replaces **first** regex match.

```java
"one two two".replaceFirst("two","five"); // "one five two"
```


### `replaceAll(regex, replacement)`

- Replaces **all** regex matches.

```java
"one two two".replaceAll("two","five"); // "one five five"
```


***

## **14. Splitting Strings – `split()`**

### Basic

```java
"A man drove with a car.".split("a");
// ["A m", "n drove with ", " c", "r."]
```

- Parameter is a **regex**.
- Matching portion is discarded.


### With Limit

```java
"A man drove with a car.".split("a", 2);
// ["A m", "n drove with a car."]
```

- **limit** = max array length.
- Last element = remaining string.

***

## **15. Converting Numbers \& Objects to Strings**

### `String.valueOf(x)`

```java
String.valueOf(10);     // "10"
String.valueOf(9.99);   // "9.99"
```


### `toString()`

```java
Integer num = 123;
num.toString(); // "123"
```

- Override `toString()` in custom classes for meaningful output.

***

## **16. Getting Characters \& Bytes**

### `charAt(index)`

```java
"This".charAt(0); // 'T'
```


### `getBytes()`

```java
byte[] b1 = "Hello".getBytes(); // default charset
byte[] b2 = "Hello".getBytes(StandardCharsets.UTF_8);
```


***

## **17. Uppercase \& Lowercase**

```java
"Java".toUpperCase(); // "JAVA"
"Java".toLowerCase(); // "java"
```


***

## **18. String Formatting – `formatted()` (Java 13 preview)**

```java
String template = "Hello %s";
template.formatted("World"); // "Hello World"
```

- Similar to `String.format()` but shorter.

***

## **19. Strip Indentation – `stripIndent()` (Java 13 preview)**

```java
String input = "   Hey\n   This\n   is\n   indented.";
System.out.println(input.stripIndent());
/*
Hey
This
is
indented.
*/
```

- Removes minimum indentation common to all lines.

***

## **20. Translate Escape Codes – `translateEscapes()` (Java 13 preview)**

```java
String s = "Hey, \\n New line";
System.out.println(s);
// Hey, \n New line

System.out.println(s.translateEscapes());
// Hey,
//  New line
```

- Converts escape sequences like `\n`, `\t` from literal text to their effect.

***

## **21. Best Practices \& Tips**

- For **concatenation in loops**, use `StringBuilder` to avoid creating many String objects.
- Always specify charset in `getBytes()` to avoid platform dependency.
- Remember immutability — any operation returns a **new string** without changing the original.
- For pattern match/replacement, use regex carefully; escape special characters if you want literal matches.

***

✅ This now **includes** everything from:

- `matches()`
- All comparison methods
- Trimming (`trim()`)
- Replace (`replace`, `replaceFirst`, `replaceAll`)
- Splitting (with and without limit)
- Conversion (`valueOf()`, `toString()`)
- Character \& byte extraction
- Uppercase \& lowercase
- `formatted()`
- `stripIndent()`
- `translateEscapes()`

***
[^1]: https://jenkov.com/tutorials/java/strings.html

