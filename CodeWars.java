package uk.co.simonaust.startrekspellinggame;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class CodeWars {

    public static void main(String[] args) {

        TrainingTests training = new TrainingTests();
        training.run();
    }
}


class DayOfWeek {
    public static String getDay(int n) {


        switch (n) {
            case 1 -> {
                return "Sunday";
            }
            case 2 -> {
                return "Monday";
            }
            case 3 -> {
                return "Tuesday";
            }
            case 4 -> {
                return "Wednesday";
            }
            case 5 -> {
                return "Thursday";
            }
            case 6 -> {
                return "Friday";
            }
            default -> {
                return "Saturday";
            }
        }
    }

}


class TrainingTests {

    @Test
    public void run() {


//            assertEquals("135024", encrypt("012345", 1));
//            assertEquals("304152", encrypt("012345", 2));
//            assertEquals("012345", encrypt("012345", 3));


//        System.out.println(diff("abcd", "mnop"));
//        System.out.println(diff("efgh", "ijkl"));
//        System.out.println(diff("abcd", "mnop"));


//        assertArrayEquals(
//                new int[] { 20, 37, 21 },
//                deleteNth( new int[] { 20, 37, 20, 21 }, 1 )
//        );

//        assertArrayEquals(
//                new int[] { 1, 1, 3, 3, 7, 2, 2, 2 },
//                deleteNth( new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3 )
//
//        );

    }

    public static double guessBlue(int blueStart, int redStart, int bluePulled, int redPulled) {
        
        return 0.9;
    }
    public static String encrypt(final String text, final int n) {
        String temp = text;
        for (int i = 0; i < n; i++) {
            temp = concatenateOddIndexedCharacters(temp);
        }
        System.out.println(temp);
        return temp;
    }

    private static String concatenateOddIndexedCharacters(String text) {
        StringBuilder sb = new StringBuilder();
        // odd indices
        for (int i = 1; i < text.length(); i += 2) {
            sb.append(text.charAt(i));
        }
        // even
        for (int i = 0; i < text.length(); i += 2) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    public static String decrypt(final String encryptedText, final int n) {
        // Your code here
        return null;
    }
    public static Integer calculateTip(double amount, String rating) {
        double onePercent = amount / 100;
        double result = switch (rating.toLowerCase()) {
            case "terrible" -> 0;
            case "poor" -> onePercent * 5;
            case "good" -> onePercent * 10;
            case "great" -> onePercent * 15;
            case "excellent" -> onePercent * 20;
            default -> -1;
        };
        return result != -1 ? (int) Math.ceil(result) : null;
    }

    public int adjacentElementsProduct(int[] array) {
        return IntStream.range(0, array.length - 1)
                .map(i -> array[i] * array[i + 1])
                .max()
                .orElse(0);
    }

    public static String dashatize(int num) {
        String numFormatted = String.valueOf(num).replaceAll("-", "");
        int[] numArray = Arrays.stream(numFormatted.split("")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(numArray));
        StringBuilder sb = new StringBuilder();
        Set<Integer> oddIndices = IntStream
                .range(0, numFormatted.length())
                .filter(i -> ((numArray[i]) % 10) % 2 == 1)
                .boxed()
                .collect(Collectors.toSet());

        for (int i = 0; i < numArray.length; i++) {
            if (oddIndices.contains(i) ) {
                if (!oddIndices.contains(i - 1) && i != 0) {
                    sb.append("-");
                }
                sb.append(numArray[i]);
                if (i != numArray.length - 1) {
                    sb.append("-");
                }
            } else {
                sb.append(numArray[i]);
            }
        }
        System.out.println(sb);
        return sb.toString();
    }

    public static String duckDuckGoose(String[] players, int goose) {
        System.out.println("goose:" + goose);
        System.out.printf("goose (%d) %% players.length (%d) = %d", goose, players.length, goose % players.length);

        return players[goose % players.length];
    }

    public static String isSortedAndHow(int[] array) {
        int result = -1;
        if (array[0] < array[1]) {
            boolean isAsc = true;
            for (int i = 1; i < array.length - 1; i++) {
                if (!(array[i] < array[i + 1])) {
                    isAsc = false;
                    System.out.printf("i=%d : array[%d]=%d : array[%d]=%d", i, i, array[i], i + 1, array[i + 1]);
                    break;
                }
            }
            if (isAsc) result = 1;
        } else if (array[0] > array[1]) {
            boolean isDec = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (!(array[i] > array[i + 1])) {
                    isDec = false;
                    break;
                }
            }
            if (isDec) result = 2;
        }
        return switch (result) {
            case 1 -> "yes, ascending";
            case 2 -> "yes, descending";
            default -> "no";
        };

    }

    public static boolean all(int[] list, IntPredicate predicate) {
        // REMINDER: a Predicate "p" is tested for argument "arg" using p.test(arg)
        return IntStream.of(list).allMatch(predicate);
    }

    public static int calculateYears(double principal, double interest, double tax, double desired) {
        int years = 0;
        while (principal < desired) {
            principal += (interest * principal) - (principal * interest * tax);
            years++;
        }
        return years;
    }

    // expected:<-1687300190> but was:<-829887639>
    public static int findLongest(int[] numbers) {
        int largestIndex = 0;
        String mostDigitsVal = String.valueOf(numbers[0]);
        for (int i = 0; i < numbers.length - 1; i++) {
            String nextVal = String.valueOf(Math.abs(numbers[i + 1]));
            if (mostDigitsVal.length() < nextVal.length()) {
                mostDigitsVal = nextVal;
                largestIndex = i + 1;
            }
        }
        return numbers[largestIndex];
    }

    public static long sumMul(int n, int m) {
        return Stream.iterate(n, i -> i < m, i -> i + n).mapToInt(Integer::intValue).sum();
    }

    public static int billboard(String name, int price) {
        // Your code
        return IntStream.rangeClosed(1, name.length()).map(i -> price).sum();
    }

    public double[] xbonacci(double[] signature, int n) {
        int sigLength = signature.length;
        double[] result = Arrays.copyOf(signature, n);
        System.out.println(Arrays.toString(result));
        for (int i = sigLength; i < n; i++) { // i = 4, 4 < 10
            int jBoundary = Math.max(i - sigLength, 0); // 4 - 4, 0
            for (int j = i; j >= jBoundary; j--) { //
                result[i] += result[j];
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static int points(String[] games) {
        return Arrays.stream(games)
                .mapToInt(s -> {
                    int[] scoreParts = Arrays.stream(s.split(":")).mapToInt(Integer::valueOf).toArray();
                    if (scoreParts[0] > scoreParts[1]) {
                        return 3;
                    } else if (scoreParts[0] < scoreParts[1]) {
                        return 0;
                    } else {
                        return 1;
                    }
                })
                .sum();
    }

    public static String greet2(String language) {
        Map<String, String> languageWelcome = new HashMap<>();
        languageWelcome.put("english", "Welcome");
        languageWelcome.put("czech", "Vitejte");
        languageWelcome.put("danish", "Velkomst");
        languageWelcome.put("dutch", "Welkom");
        languageWelcome.put("estonian", "Tere tulemast");
        languageWelcome.put("finnish", "Tervetuloa");
        languageWelcome.put("flemish", "Welgekomen");
        languageWelcome.put("french", "Bienvenue");
        languageWelcome.put("german", "Willkommen");
        languageWelcome.put("irish", "Failte");
        languageWelcome.put("italian", "Benvenuto");
        languageWelcome.put("latvian", "Gaidits");
        languageWelcome.put("lithuanian", "Laukiamas");
        languageWelcome.put("polish", "Witamy");
        languageWelcome.put("spanish", "Bienvenido");
        languageWelcome.put("swedish", "Valkommen");
        languageWelcome.put("welsh", "Croeso");

        String defaultValue = switch (language) {
            case "IP_ADDRESS_INVALID", "IP_ADDRESS_NOT_FOUND", "IP_ADDRESS_REQUIRED" -> languageWelcome.get("english");
            default -> "";
        };

        return languageWelcome.getOrDefault(language, defaultValue);
    }

    public static String twoSort(String[] s) {
        Arrays.sort(s);
        return String.join("***", s[0].split(""));
    }

    public static int[] pipeFix(int[] numbers) {
        Arrays.sort(numbers);
        System.out.printf("min:%d max:%d", numbers[0], numbers[numbers.length - 1]);
        return IntStream.rangeClosed(numbers[0], numbers[numbers.length - 1]).toArray();
    }

    public static boolean isPowerOfTwo(long n) {
        System.out.printf("n: %s n -1: %s%n", Long.toBinaryString(n), Long.toBinaryString(n - 1));
        return (n & n - 1) == 0;
    }

    public static String vertMirror(String strng) {
        String[] lines = strng.split("\n");
        System.out.println(Arrays.toString(lines));
        String[] resultArray = new String[lines.length];
        for (int i = 0; i < lines.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = lines[i].length() - 1; j >= 0; j--) {
                sb.append(lines[i].charAt(j));
            }
            resultArray[i] = sb.toString();
        }
        System.out.println(Arrays.toString(resultArray));
        return String.join("\n", resultArray);

    }

    public static String horMirror(String strng) {
        String[] lines = strng.split("\n");
        System.out.println(lines.length);
        System.out.println(Arrays.toString(lines));
        String[] resultArray = new String[lines.length];
        for (int i = 0; i < lines.length; i++) {
            resultArray[i] = lines[lines.length - 1 - i];
        }
        System.out.println(Arrays.toString(resultArray));
        return String.join("\n", resultArray);
    }

    public static String oper(Function<String, String> operator, String s) {
        return operator.apply(s);
    }

    public static boolean isIsogram(String str) {
        String lowerCaseStr = str.toLowerCase();
        Map<String, Long> letterCountMap = Arrays.stream(lowerCaseStr.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(letterCountMap);
        return letterCountMap.values().stream().noneMatch(l -> l > 1);
    }

    public static String[] capitalize(String s) {
        StringBuilder sbEven = new StringBuilder();
        StringBuilder sbOdd = new StringBuilder();

        boolean isEven = true;

        for (int i = 0; i < s.length(); i++) {
            String letter = s.substring(i, i + 1);

            sbEven.append(isEven ? letter.toUpperCase() : letter.toLowerCase());
            sbOdd.append(isEven ? letter.toLowerCase() : letter.toUpperCase());
            isEven = !isEven;
        }

        return new String[]{sbEven.toString(), sbOdd.toString()};
    }

    public static int sumTriangularNumbers(int n) {
        int triangularNum = 0;
        int result = 0;
        for (int row = 1; row <= n; row++) {
            triangularNum = row + triangularNum;
            result += triangularNum;
        }
        return result;
    }

    /**
     * solve("our code") = "edo cruo"
     * -- Normal reversal without spaces is "edocruo".
     * -- However, there is a space at index 3, so the string becomes "edo cruo"
     * solve("your code rocks") = "skco redo cruoy".
     * solve("codewars") = "srawedoc"
     */
    public static String solve2(String s) {
        StringBuilder temp = new StringBuilder(s.replaceAll(" ", "")).reverse();
        System.out.println(temp);
        List<Integer> spaceIndicesList = IntStream.range(0, s.length())
                .filter(i -> s.charAt(i) == ' ')
                .boxed()
                .collect(Collectors.toList());

        System.out.println(spaceIndicesList);
        for (Integer integer : spaceIndicesList) {
            temp.insert(integer, " ");
        }
        System.out.println(temp);

        return temp.toString();
    }

    public static String greet(String name) {
        if (name == null) return "";
        Function<String, String> greetFunc =
                s -> String.format("Hello %s!", s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase());
        return greetFunc.apply(name);
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        Map<Integer, Long> elementsSet = Arrays.stream(elements)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(elementsSet);
        // put elements in hash

        int[] result = Arrays.stream(elements)
                .filter(e -> {
                    Optional<Long> countOptional = Optional.ofNullable(elementsSet.get(e));
                    if (countOptional.isPresent()) {
                        long count = countOptional.get(); // get current repetitions of e

                        System.out.println("count: " + count);
                        System.out.println(elementsSet);

                        elementsSet.put(e, count - 1);
                        return count == 0;
                    }
                    return true;
                })
                .toArray();

        System.out.println(Arrays.toString(elements));
        System.out.println(Arrays.toString(result));
        return result;
    } // TODO

    public static String shark(int pontoonDistance, int sharkDistance,
                               int youSpeed, int sharkSpeed, boolean dolphin) {


        if (dolphin) sharkSpeed /= 2;

        double swimmerTimeToPontoon = (double) pontoonDistance / youSpeed;
        double sharkTimeToPontoon = (double) sharkDistance / sharkSpeed;

        boolean isAlive = swimmerTimeToPontoon < sharkTimeToPontoon;

        return isAlive ? "Alive!" : "Shark Bait!";
    }

    public static String[] kataExampleTwist() {
        String[] websites = IntStream.rangeClosed(0, 999).mapToObj(i -> "codewars").toArray(String[]::new);
        System.out.println(websites.length);
        return websites;
    }

    public static String remove(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '!' && n > 0) {
                sb.replace(i, i + 1, "");
                n--;
                i--;
            }
            if (n == 0) break;
        }
        return sb.toString();

    }

    public static int sum(int[] arr) {
        return Arrays.stream(arr).filter(i -> i > 0).sum();
    }

    public static int mxdiflg(String[] a1, String[] a2) {
        if (a1.length == 0 || a2.length == 0) return -1;
        Arrays.sort(a1, Comparator.comparingInt(String::length));
        Arrays.sort(a2, Comparator.comparingInt(String::length));
        int a1CompareToa2 = a2[a2.length - 1].length() - a1[0].length();
        int a2CompareToa1 = a1[a1.length - 1].length() - a2[0].length();
        return Math.max(a1CompareToa2, a2CompareToa1);
    }


    public static int predictAge(int... ages) {
        return (int) Math.sqrt(Arrays.stream(ages).map(i -> i * i).peek(System.out::println).sum()) / 2;
    }

    public static String expandedForm(int num) {
        StringBuilder result = new StringBuilder();
        int temp = num % 10; // last part
        while (temp > 0) {
            result.append((num -= temp)).append(" + ");
            temp = num % 10;
        }
        result.append(num);
        System.out.println(result);
        return result.toString();
    }

    public static String encryptThis(String text) {
        StringBuilder sentence = new StringBuilder();
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append((int) words[i].charAt(0));
            if (words[i].length() > 2) {
                sb.append(words[i].charAt(words[i].length() - 1));
                sb.append(words[i], 2, words[i].length() - 1); // TODO short words
                sb.append(words[i].charAt(1)).append(i < words.length - 1 ? " " : "");
            }

            System.out.println(sb);
            sentence.append(sb);
        }
        System.out.println(sentence);
        return sentence.toString();
    }

    public static String MakeUpperCase(String str) {
        return str.chars()
                .peek(System.out::println)
                .map(TrainingTests::charToUpperCaseFunc) // 97 <= c => 122
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    private static int charToUpperCaseFunc(int c) {
        return c >= 97 && c <= 122 ? c - 32 : c;
    }

    public static int arithmetic(int a, int b, String operator) {
        return switch (operator) {
            case "add" -> a + b;
            case "subtract" -> a - b;
            case "multiply" -> a * b;
            default -> a / b;
        };
    }


    public static long factorial(int n) {
        // your code here
        return LongStream.rangeClosed(1, n).reduce(1, (total, next) -> total * next);
    }

    public static int rowSumOddNumbers(int n) {
        int rowNZerothIndexVal = n * (n - 1) + 1;
        int rowNLastIndexVal = rowNZerothIndexVal + ((n - 1) * 2);
        System.out.printf("rowNZerothIndexVal: %d rowNLastIndexVal: %d%n", rowNZerothIndexVal, rowNLastIndexVal);

        return IntStream.rangeClosed(rowNZerothIndexVal, rowNLastIndexVal).filter(i -> i % 2 == 1).sum();
    }

    public static char getGrade(int s1, int s2, int s3) {
        int average = s1 + s2 + s3 / 3;
        if (average >= 90 && average < 100) {
            return 'A';
        } else if (average >= 80 && average < 90) {
            return 'B';
        } else if (average >= 70 && average < 80) {
            return 'C';
        } else if (average >= 60 && average < 70) {
            return 'D';
        } else {
            return 'F';
        }
    }


    public static int minValue(int[] values) {
        Map<Integer, Long> groupedInts = Arrays.stream(values)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        String result = (Arrays.stream(values).boxed().collect(Collectors.toSet())
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining()));

//        System.out.println(result);

        return Integer.parseInt(result);
    }

    public static int solveSuperMarketQueue(int[] customers, int n) {
        // split customers into similar n groups based by similar time


        return 0;
    }

    public class Sid {
        public static String howMuchILoveYou(int nb_petals) {
            String[] phrases = new String[]{"I love you", "a little",
                    "a lot", "passionately", "madly", "not at all"};
            System.out.printf("nb_petals %% phrases.length: %d  %n", nb_petals % phrases.length);
            int choice;
            return phrases[nb_petals <= 6
                    ? nb_petals - 1 : (choice = nb_petals % phrases.length) == 0 ? 0 : choice - 1];
        }

    }

    public static Map<Character, Integer> count(String str) {
        // Happy coding!
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(Function.identity(), e -> 1, Math::addExact));
    }

    public static String[] towerBuilder(int nFloors) {
        if (nFloors == 0) return new String[]{};
        StringBuilder[] sbFloors = new StringBuilder[nFloors];
        int width = nFloors * 2 - 1;
        int middle = (width % 2 == 1 ? (int) Math.ceil(width / 2.0) : width / 2) - 1;

        StringBuilder floor = new StringBuilder();
        IntStream.range(0, width).forEach(i -> floor.append(" "));
        floor.setCharAt(middle, '*');

        sbFloors[0] = floor;

        for (int i = 1; i < nFloors; i++) {
            StringBuilder newFloor = new StringBuilder(sbFloors[i - 1]);

            newFloor.setCharAt(middle + i, '*');
            newFloor.setCharAt(middle - i, '*');

            sbFloors[i] = newFloor;
        }
        return Stream.of(sbFloors).map(StringBuilder::toString).toArray(String[]::new);
    }

    public static int binToDecimal(String inp) {
        String inputReversed = new StringBuilder(inp).reverse().toString();
//        System.out.printf("(int) Math.pow(Integer.parseInt(inp.substring(0, 1)) == 1 ? 2 : 0, 0) = %d\n",
//                (int) Math.pow(Integer.parseInt(inp.substring(0, 1)) == 1 ? 2 : 0, 0));
        int number;
        return IntStream.range(0, inp.length())
//               .peek(System.out::println)
//                .map(i -> stringBinaryFunction(inputReversed.substring(i, i + 1), i))
                .map(i -> (int) Math.pow(Integer.parseInt(inputReversed.substring(i, i + 1)) == 1 ? 2 : 0, i))
//               .peek(System.out::println)
                .sum();

    }

    private static int stringBinaryFunction(String s, int i) {
        //        i -> (int) Math.pow(Integer.parseInt(inp.substring(i, i+1)) == 1 ? 2 : 0, i);
        int base = Integer.parseInt(s) == 1 ? 2 : 0;
        if (base == 0 && i == 0) {
            return 0;
        }
        int binaryVal = (int) Math.pow(base, i);
        System.out.printf("substring: %s - index: %d - %d^%d: %d\n",
                s,
                i,
                base,
                i,
                binaryVal);

        return binaryVal;
    }

    public static String binaryAddition(int a, int b) {
        int sum = a + b;
        StringBuilder sb = new StringBuilder();
        int firstLargerThanSumBinaryUnit = 0;
        for (int i = 0; i < 32; i++) {
            if (sum % Math.pow(2, i) == sum) {
                firstLargerThanSumBinaryUnit = i;
                break;
            }
        }
        System.out.printf("firstLargerThanSumBinaryUnit: %d\n", firstLargerThanSumBinaryUnit);
        System.out.printf("15 %% 2^4 = %d\n", 15 % (int) Math.pow(2, 4));
        return Integer.toBinaryString(sum);
    }

    public static String solve(final String str) {
        int upperCaseCount = (int) str.chars()
                .filter(i -> i >= 65 && i <= 90)
                .peek(i -> System.out.print((char) i + " "))
                .count();
//        System.out.println(upperCaseCount);
//        System.out.println("str.length(): " + str.length());
        if (upperCaseCount > str.length() / 2) {
            return str.toUpperCase();
        }
        return str.toLowerCase();
        /*int len = str.length();
        if (str.matches(String.format("[A-Z]{%d,}", len / 2 + 1))) {
            System.out.println("mostly uppercase, converting string to lowercase");
            return str.toUpperCase();
        }
//        } else if (str.matches(String.format("[A-Z]{%d}", len / 2))) {
//            System.out.println("equal upper and lower case, converting to lowercase");
//        }
            else {
                return str.toLowerCase();
            }
*/
    }

    public static int[] take(int[] arr, int n) {
        return Arrays.stream(arr).limit(n).toArray();
    }

    public static boolean isTriangle(int a, int b, int c) {
        System.out.printf("a:%s b:%s c:%s%n", a, b, c);
        int[] sortedSides = Stream.of(a, b, c).sorted().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(sortedSides));
        if (a == 0 || b == 0 || c == 0) return false;
        return sortedSides[2] < sortedSides[0] + sortedSides[1] &&
                sortedSides[1] * sortedSides[2] / 2 > 0;
    }

    public static int nbDig(int n, int d) {
        return IntStream.rangeClosed(0, n)
                .map(i -> (int) Math.pow(i, 2))
//                .peek(System.out::println)
                .mapToObj(String::valueOf)
                .map(s -> Stream.of(s.split(""))
                        .filter(letter -> letter.equals(String.valueOf(d)))
                        .collect(Collectors.joining()))
                .mapToInt(String::length).sum();
    }

    public static int[][] multiplicationTable(int n) {
        int[][] nTable = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nTable[i][j] = (i + 1) * (j + 1);
            }
        }
        System.out.println(Arrays.deepToString(nTable));
        return nTable;
    }

    public static int duplicateCount(String text) {
        return (int) Stream.of(text.toLowerCase().split(""))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .count();
    }

    public static String CalculateAge(int birth, int yearTo) {
        /* String patterns */
        String areNYears = "You are %d year%s old.";
        String bornNYears = "You will be born in %d year%s.";
        String bornThisYear = "You were born this very year!";

        int result = yearTo - birth;
        if (result > 0) {
            return String.format(areNYears, result, result == 1 ? "" : "s");
        } else if (result < 0) {
            return String.format(bornNYears, Math.abs(result), result == -1 ? "" : "s");
        } else {
            return bornThisYear;
        }


    }
}

@FunctionalInterface
interface Squarer {
    int square(int n);

}