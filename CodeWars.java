package uk.co.simonaust.startrekspellinggame;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.Map.entry;
import static junit.framework.TestCase.*;
import static org.junit.Assert.assertArrayEquals;


public class CodeWars {

    public static void main(String[] args) {

        TrainingTests training = new TrainingTests();
        training.run();
    }
}

class TrainingTests {

    @Test
    public void run() {
        assertEquals(0.6, guessBlue(5, 5, 2, 3));

        assertTrue(isLockNessMonster("Hello there friend, do you have tree fiddy I could borrow?"));

        assertEquals("Wleclgltihuebredrf ofsheesenasnegrof",
                sortMyString("Wolfeschlegelsteinhausenbergerdorff"));

        assertTrue(feast("great blue heron", "garlic naan"));
        assertTrue(feast("chickadee", "chocolate cake"));

        assertEquals("Oi! Sheep number 1! You are about to be eaten by a wolf!",
                warnTheSheep(new String[]{"sheep", "wolf", "sheep"}));
        assertEquals("Pls go away and stop eating my sheep",
                warnTheSheep(new String[]{"sheep", "sheep", "wolf"}));

        assertEquals("Nope!", "Martin does not play banjo", areYouPlayingBanjo("Martin"));

        assertEquals("i18n", abbreviate("internationalization"));
        assertEquals("e6t-r3s are r4y fun!", abbreviate("elephant-rides are really fun!"));
        assertEquals("You n2d, n2d not w2t, to c6e t2s c2e-w2s m5n",
                abbreviate("You need, need not want, to complete this code-wars mission"));
        assertEquals("sat sat5cat. mat. a: s2s mat5s2s; cat sat",
                abbreviate("sat sat5cat. mat. a: sits mat5sits; cat sat"));

        int[] sunday = {6737, 7244, 5776, 9826, 7057, 9247, 5842, 5484, 6543, 5153, 6832, 8274,
                7148, 6152, 5940, 8040, 9174, 7555, 7682, 5252, 8793, 8837, 7320, 8478, 6063,
                5751, 9716, 5085, 7315, 7859, 6628, 5425, 6331, 7097, 6249, 8381, 5936, 8496,
                6934, 8347, 7036, 6421, 6510, 5821, 8602, 5312, 7836, 8032, 9871, 5990, 6309, 7825};

        int[] monday = {9175, 7883, 7596, 8635, 9274, 9675, 5603, 6863, 6442, 9500, 7468, 9719,
                6648, 8180, 7944, 5190, 6209, 7175, 5984, 9737, 5548, 6803, 9254, 5932, 7360, 9221,
                5702, 5252, 7041, 7287, 5185, 9139, 7187, 8855, 9310, 9105, 9769, 9679, 7842,
                7466, 7321, 6785, 8770, 8108, 7985, 5186, 9021, 9098, 6099, 5828, 7217, 9387};

        int[] tuesday = {8646, 6945, 6364, 9563, 5627, 5068, 9157, 9439, 5681, 8674, 6379, 8292,
                7552, 5370, 7579, 9851, 8520, 5881, 7138, 7890, 6016, 5630, 5985, 9758, 8415, 7313,
                7761, 9853, 7937, 9268, 7888, 6589, 9366, 9867, 5093, 6684, 8793, 8116, 8493,
                5265, 5815, 7191, 9515, 7825, 9508, 6878, 7180, 8756, 5717, 7555, 9447, 7703};

        int[] wednesday = {6353, 9605, 5464, 9752, 9915, 7446, 9419, 6520, 7438, 6512, 7102,
                5047, 6601, 8303, 9118, 5093, 8463, 7116, 7378, 9738, 9998, 7125, 6445, 6031, 8710,
                5182, 9142, 9415, 9710, 7342, 9425, 7927, 9030, 7742, 8394, 9652, 5783, 7698,
                9492, 6973, 6531, 7698, 8994, 8058, 6406, 5738, 7500, 8357, 7378, 9598, 5405, 9493};

        int[] thursday = {6149, 6439, 9899, 5897, 8589, 7627, 6348, 9625, 9490, 5502, 5723, 8197,
                9866, 6609, 6308, 7163, 9726, 7222, 7549, 6203, 5876, 8836, 6442, 6752, 8695, 8402,
                9638, 9925, 5508, 8636, 5226, 9941, 8936, 5047, 6445, 8063, 6083, 7383, 7548, 5066,
                7107, 6911, 9302, 5202, 7487, 5593, 8620, 8858, 5360, 6638, 8012, 8701};

        int[] friday = {5000, 5642, 9143, 7731, 8477, 8000, 7411, 8813, 8288, 5637, 6244, 6589, 6362,
                6200, 6781, 8371, 7082, 5348, 8842, 9513, 5896, 6628, 8164, 8473, 5663, 9501,
                9177, 8384, 8229, 8781, 9160, 6955, 9407, 7443, 8934, 8072, 8942, 6859, 5617,
                5078, 8910, 6732, 9848, 8951, 9407, 6699, 9842, 7455, 8720, 5725, 6960, 5127};

        int[] saturday = {5448, 8041, 6573, 8104, 6208, 5912, 7927, 8909, 7000, 5059, 6412, 6354, 8943,
                5460, 9979, 5379, 8501, 6831, 7022, 7575, 5828, 5354, 5115, 9625, 7795, 7003,
                5524, 9870, 6591, 8616, 5163, 6656, 8150, 8826, 6875, 5242, 9585, 9649, 9838,
                7150, 6567, 8524, 7613, 7809, 5562, 7799, 7179, 5184, 7960, 9455, 5633, 9085};
        int[][] stairs = {sunday, monday, tuesday, wednesday, thursday, friday, saturday};
        long expectedResult = 54636040;
        assertEquals(expectedResult, stairsIn20(stairs));

        IntUnaryOperator addOne = add(1);
        assertEquals(4, addOne.applyAsInt(3));

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, flattenAndSort(new int[][]{{3, 2, 1}, {7, 9, 8}, {6, 4, 5}}));

        assertArrayEquals(new int[]{4, 3, 1}, solve(new String[]{"abode", "ABc", "xyzD"}));
        assertArrayEquals(new int[]{1, 3, 1, 3}, solve(new String[]{"encode", "abc", "xyzD", "ABmD"}));
        assertArrayEquals(new int[]{2}, solve(new String[]{"Averylongwordthatisbiggert"}));

        assertEquals(2, nthSmallest(new int[]{2, 169, 13, -5, 0, -1}, 4));

        assertEquals("sort fedcba", "abcdef", sortGiftCode("fedcba"));

        assertFalse("negative numbers aren't square numbers", isSquare(-1));
        assertTrue("0 is a square number (0 * 0)", isSquare(0));
        assertFalse("3 isn't a square number", isSquare(3));
        assertTrue("4 is a square number (2 * 2)", isSquare(4));
        assertTrue("25 is a square number (5 * 5)", isSquare(25));
        assertFalse("26 isn't a square number", isSquare(26));

        assertEquals(-1, closeCompare(4, 5));
        assertEquals(0, closeCompare(5, 5));
        assertEquals(1, closeCompare(6, 5));
        assertEquals(-1, closeCompare(-6, -5));

        int[] p1 = {3, 4, 5};
        int[] p2 = {3, 5, 7};
        assertEquals(1, pythagoreanTriple(p1));

        assertEquals(0, pythagoreanTriple(p2));

        assertEquals(true, smallEnough(new int[]{66, 101}, 200));
        assertEquals(false, smallEnough(new int[]{78, 117, 110, 99, 104, 117, 107, 115}, 100));
        assertEquals(true, smallEnough(new int[]{101, 45, 75, 105, 99, 107}, 107));
        assertEquals(true, smallEnough(new int[]{80, 117, 115, 104, 45, 85, 112, 115}, 120));

        assertArrayEquals(new int[]{4,6,3}, solve(new int[]{3,4,4,3,6,3}));
        assertArrayEquals(new int[]{1,2,3}, solve(new int[]{1,2,1,2,1,2,3}));
        assertArrayEquals(new int[]{1,2,3,4}, solve(new int[]{1,2,3,4}));
        assertArrayEquals(new int[]{4,5,2,1}, solve(new int[]{1,1,4,5,1,2,1}));

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

    /**
     * @link <a href="https://www.codewars.com/kata/5ba38ba180824a86850000f7/train/java">Link</a>
     * Kata Level: 7kyu
     */
    public static int[] solve(int[] arr) {
        int[] reversed = reverseIntArray(arr);
        for (int i = arr.length -1, j = 0; i >= 0; i--, j++) {
            reversed[j] = arr[i];
        }
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < reversed.length; i++) {
            set.add(reversed[i]);
        }

        return reverseIntArray(set.stream().mapToInt(Integer::intValue).toArray());
    }

    private static int[] reverseIntArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = arr.length -1, j = 0; i >= 0; i--, j++) {
            reversed[j] = arr[i];
        }
        return reversed;
    }

    /**
     * @link <a href="https://www.codewars.com/kata/57cc981a58da9e302a000214/train/java">Link</a>
     * Kata Level: 7kyu
     */
    public static boolean smallEnough(int[] a, int limit) {
        return Arrays.stream(a).filter(i -> i > limit).toArray().length < 1;
    }

    /**
     * @link <a href="https://www.codewars.com/kata/5951d30ce99cf2467e000013/train/java">Link</a>
     * Kata Level: 8kyu
     */
    public int pythagoreanTriple(int[] triple) {
        double[] tripleSquared = Arrays.stream(triple).mapToDouble(i -> Math.pow(i, 2)).toArray();
        if (tripleSquared[0] + tripleSquared[1] == tripleSquared[2]
                || tripleSquared[1] + tripleSquared[2] == tripleSquared[0]
                || tripleSquared[0] + tripleSquared[2] == tripleSquared[1]) {
            return 1;
        }
        return 0;
    }

    /**
     * @link <a href="https://www.codewars.com/kata/56453a12fcee9a6c4700009c/train/java">Link</a>
     * Kata Level: 8kyu
     */
    public static int closeCompare(double a, double b) {
        return closeCompare(a, b, 0);
    }

    public static int closeCompare(double a, double b, double margin) {
        double distance = a - b;
        return Math.abs(distance) <= margin ? 0 : distance < 0 ? -1 : 1;
    }

    /**
     * @link <a href="https://www.codewars.com/kata/54c27a33fb7da0db0100040e/train/java">Link</a>
     * Kata Level: 7kyu
     */
    public static boolean isSquare(int n) {
        if (n < 0) return false;
        double nRootFloor = Math.floor(Math.sqrt(n));
        double nRoot = Math.sqrt(n);
        return nRoot == nRootFloor;
    }

    /**
     * @link <a href="https://www.codewars.com/kata/52aeb2f3ad0e952f560005d3/train/java">Link</a>
     * Kata Level: 7kyu
     */
    public String sortGiftCode(String code) {

        char[] letters = code.toCharArray();
        int limit = code.length() - 1;
        char temp;
        for (int i = 0; i < code.length() - 1; i++) {
            for (int j = 0; j < limit; j++) {
                if (letters[j] > letters[j + 1]) {
                    temp = letters[j];
                    letters[j] = letters[j + 1];
                    letters[j + 1] = temp;
                }
            }
            limit--;
        }
        return String.valueOf(letters);
    }

    /**
     * @link <a href="https://www.codewars.com/kata/5a512f6a80eba857280000fc/train/java">Link</a>
     * Kata Level: 7kyu
     */
    public static int nthSmallest(final int[] arr, final int n) {
        Arrays.sort(arr);
        return arr[n - 1];
    }

    /**
     * @link <a href="https://www.codewars.com/kata/59d9ff9f7905dfeed50000b0/train/java">Link</a>
     * Kata Level: 7kyu
     */
    public static int[] solve(String[] arr) {
        Map<Integer, Character> alphabet = Map.ofEntries(
                entry(1, 'a'), entry(2, 'b'), entry(3, 'c'),
                entry(4, 'd'), entry(5, 'e'), entry(6, 'f'),
                entry(7, 'g'), entry(8, 'h'), entry(9, 'i'),
                entry(10, 'j'), entry(11, 'k'), entry(12, 'l'),
                entry(13, 'm'), entry(14, 'n'), entry(15, 'o'),
                entry(16, 'p'), entry(17, 'q'), entry(18, 'r'),
                entry(19, 's'), entry(20, 't'), entry(21, 'u'),
                entry(22, 'v'), entry(23, 'w'), entry(24, 'x'),
                entry(25, 'y'), entry(26, 'z'));

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int counter = 0;
            for (int j = 0; j < arr[i].length(); j++) {
                try {
                    if (arr[i].toLowerCase().charAt(j) == alphabet.get((j % 26) + 1)) {
                        counter++;
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e + " alphabet.get(" + j + " " + i + ")");
                }
            }
            result[i] = counter;
        }
        return result;
    }

    /**
     * @link <a href="https://www.codewars.com/kata/57ee99a16c8df7b02d00045f/train/java">Link</a>
     * Kata Level: 7kyu
     */
    public static int[] flattenAndSort(int[][] array) {
        return Arrays.stream(array)
                .flatMapToInt(IntStream::of)
                .sorted()
                .toArray();
    }

    /**
     * @link <a href="https://www.codewars.com/kata/538835ae443aae6e03000547/train/java">Link</a>
     * Kata Level: 7kyu
     */
    public static IntUnaryOperator add(int n) {
        return i -> i + n;
    }

    /**
     * @link <a href="https://www.codewars.com/kata/56fc55cd1f5a93d68a001d4e/train/java">Link</a>
     * Kata Level: 8kyu
     */
    public static long stairsIn20(int[][] stairs) {
        return (long) Arrays.stream(stairs)
                .map(arr -> IntStream.of(arr).sum())
                .mapToInt(Integer::valueOf)
                .sum() * 20;
    }

    /**
     * @link <a href="https://www.codewars.com/kata/5375f921003bf62192000746/train/java">Link</a>
     */
    public String abbreviate(String string) {
        StringBuilder sb = new StringBuilder();
        String[] words = string.split(" ");

        for (int i = 0; i < words.length; i++) {

            Pattern pattern = Pattern
                    .compile("((?<longword>[a-zA-Z](?<part>[a-zA-Z]{2,})[a-zA-Z])" +
                            "|(?<shortword>[a-zA-Z]{1,3}))(?<nonword>[\\W!?.,:;_\\d]{0,2})");
            Matcher matcher = pattern.matcher(words[i]);

            while (matcher.find()) {

                if (matcher.group("longword") != null) {
                    String longword = matcher.group("longword");
                    sb.append(longword.charAt(0));
                    sb.append(matcher.group("part").length());
                    sb.append(longword.charAt(longword.length() - 1));
                }
                if (matcher.group("shortword") != null) {
                    sb.append(matcher.group("shortword"));
                }
                if (matcher.group("nonword").length() != 0) {
                    String nonWord = matcher.group("nonword");
                    sb.append(nonWord.matches("[.,:;]") && i < words.length - 1 ? nonWord + " " : nonWord);
                } else if (i != words.length - 1) {
                    sb.append(" ");
                }
            }
        }

        return sb.toString();
    }

    /**
     * @link <a href="https://www.codewars.com/kata/53af2b8861023f1d88000832/train/java">Link</a>
     */
    public static String areYouPlayingBanjo(String name) {
        return name + (name.toLowerCase().startsWith("r") ? " plays banjo" : " does not play banjo");
    }

    /**
     * @link <a href="https://www.codewars.com/kata/5c8bfa44b9d1192e1ebd3d15/train/java">Link</a>
     */
    public static String warnTheSheep(String[] array) {
        int arrLen = array.length;
        String result = "";
        for (int i = 0; i < arrLen; i++) {
            if ("wolf".equals(array[i])) {
                if (i < arrLen - 1) {
                    result = String.format("Oi! Sheep number %d! You are about to be eaten by a wolf!", arrLen - (i + 1));
                } else {
                    result = "Pls go away and stop eating my sheep";
                }
            }
        }
        return result;
    }

    /**
     * @link <<a href="https://www.codewars.com/kata/5aa736a455f906981800360d/train/java">Link</a>">Link</a>
     */
    public static boolean feast(String beast, String dish) {

        Pattern pattern = Pattern.compile("(^.).*(.$)");
        List<Matcher> matchers = List.of(pattern.matcher(beast),
                pattern.matcher(dish));
        List<String> string = new ArrayList<>();
        for (Matcher matcher : matchers) {
            while (matcher.find()) {
                String word = IntStream.rangeClosed(1, matcher.groupCount())
                        .mapToObj(matcher::group).collect(Collectors.joining());
                string.add(word);
            }
        }

        return string.stream().allMatch(string.get(0)::equals);
    }

    /**
     * @link <a href="https://www.codewars.com/kata/580755730b5a77650500010c/train/java">Link</a>
     */
    public static String sortMyString(String s) {
        StringBuilder evenSB = new StringBuilder();
        StringBuilder oddSB = new StringBuilder();
        IntStream.range(0, s.length()).forEach(i -> {
            if (i % 2 == 1) {
                oddSB.append(s.charAt(i));
            } else {
                evenSB.append(s.charAt(i));
            }
        });

        return evenSB + " " + oddSB;
    }

    /**
     * @link <a href="https://www.codewars.com/kata/55ccdf1512938ce3ac000056/java">Link</a>
     */
    public static boolean isLockNessMonster(String s) {
        Pattern pattern = Pattern.compile("tree fiddy|3.50|three fifty");
        Matcher matcher = pattern.matcher(s);

        return matcher.find();
    }

    /**
     * @link <a href="https://www.codewars.com/kata/5862f663b4e9d6f12b00003b/java">Link</a>
     */
    public static double guessBlue(int blueStart, int redStart, int bluePulled, int redPulled) {
        int remainingBlue = blueStart - bluePulled;
        int remainingRed = redStart - redPulled;

        return (double) remainingBlue / (remainingBlue + remainingRed);
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
            if (oddIndices.contains(i)) {
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

@FunctionalInterface
interface Squarer {
    int square(int n);

}