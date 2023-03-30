public class CallSolution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(5, new int[]{2,2,1,2}, new int[]{1,3,4,4}));
        System.out.println(s.solution(3, new int[]{1}, new int[]{3}));
        System.out.println(s.solution(4, new int[]{1,3}, new int[]{2,4}));
        System.out.println(s.solution(0, new int[0], new int[0]));
    }
}
