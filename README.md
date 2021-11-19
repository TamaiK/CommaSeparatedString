## 数字をカンマ区切り文字列に変換する
金額やスコアなどを、カンマ区切り表示したい。
※既存のカンマを付ける関数は使わない

### Javaコード
``` java
System.out.println(commaSeparatedString(123));
System.out.println(commaSeparatedString(-123));
System.out.println(commaSeparatedString(12345));
System.out.println(commaSeparatedString(1234567));
System.out.println(commaSeparatedString(-1234567));
System.out.println(commaSeparatedString(123456789));
System.out.println(commaSeparatedString(-123456789));
```

### 想定の出力
``` console
123
-123
12,345
1,234,567
-1,234,567
123,456,789
-123,456,789
```