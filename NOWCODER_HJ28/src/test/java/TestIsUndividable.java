public class TestIsUndividable {
    public static void main(String[] args) {
        int[] undividables = new int[] {6,8,12,32,2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
        for (int i : undividables) {
            System.out.println(i + (Solution.isUndividable(i) ? "是质数" : "不是质数"));
        }
    }
}
