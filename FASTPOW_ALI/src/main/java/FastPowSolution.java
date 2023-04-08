public class FastPowSolution {
    public int cnt;
    public int FastPow(int x, int n) {
        if (n == 0) {
            cnt++;
            return 1;
        }
        return FastPow(x, n / 2) * FastPow(x, n / 2);
    }
}
