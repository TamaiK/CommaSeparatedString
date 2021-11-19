public class App {

    // 定数

    private static final int INSERT_COMMA_INTERVAL = 3;
    private static final int FIRST_CHAR = 0;
    private static final char COMMA = ',';
    private static final char MIN_NUMBER_CHAR = '0';
    private static final char MAX_NUMBER_CHAR = '9';

    public static void main(String[] args) throws Exception {
        println(commaSeparatedString(123));
        println(commaSeparatedString(-123));
        println(commaSeparatedString(12345));
        println(commaSeparatedString(1234567));
        println(commaSeparatedString(-1234567));
        println(commaSeparatedString(123456789));
        println(commaSeparatedString(-123456789));
    }

    private static String commaSeparatedString(int number) {

        String numberString = String.valueOf(number);

        if(canInsertLength(number, numberString.length())){
            numberString = insertComma(numberString);
        }

        return numberString;
    }

    private static boolean canInsertLength(int number, int length) {

        int noneCommaLength = getUnusedCommaLength(number);

        return length > noneCommaLength;
    }

    private static int getUnusedCommaLength(int number) {
        return number < 0 ? INSERT_COMMA_INTERVAL + 1 : INSERT_COMMA_INTERVAL;
    }

    private static String insertComma(String numberString) {

        char[] charArray = numberString.toCharArray();
        String newNumberString = "";
        int firstNumberChar = FIRST_CHAR;
        int leftCharLength = charArray.length;

        if(!isNumberChar(charArray[firstNumberChar])){
            newNumberString += charArray[firstNumberChar];
            leftCharLength--;
            firstNumberChar++;
        }
        
        newNumberString += charArray[firstNumberChar];
        leftCharLength--;

        for (int index = newNumberString.length(); index < charArray.length; index++) {
            
            if(canInserting(leftCharLength)){
                newNumberString += COMMA;
            }

            newNumberString += charArray[index];
            leftCharLength--;
        }

        return newNumberString;
    }

    private static boolean isNumberChar(char chr) {
        return chr >= MIN_NUMBER_CHAR && chr <= MAX_NUMBER_CHAR;
    }

    private static boolean canInserting(int leftCharLength) {
        return leftCharLength % INSERT_COMMA_INTERVAL == 0;
    }

    // 汎用関数

    private static void println(String str, Object... args) {
        System.out.println(String.format(str, args));
    }
}
