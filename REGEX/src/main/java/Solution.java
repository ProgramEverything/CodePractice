public class Solution {
    public static void main(String[] args) {
        String[] strings = new String[] {
                "14df",
                "1234  765434+ -",
                "1234 a 765434+ -",
                "1234  765434+ -*"
        };
        for (int i = 0; i < strings.length; ++i) {
            boolean match = strings[i].matches("[\\d\\s+-]+");
            System.out.println("\"" + strings[i] + "\" " + (match ? "match" : "not match"));
        }
    }
}
