public class Main {
    public static void main(String[] args) {
        int[] a = new int[1];
        int[] b = a.clone();
        System.out.println(a == b);
        System.out.println(a[0] == b[0]);
        Object[] a2 = new Object[] { new Object() };
        Object[] b2 = a2.clone();
        System.out.println(a2 == b2);
        System.out.println(a2[0] == b2[0]);

        Integer a3 = Integer.valueOf(0);
        Integer b3 = Integer.valueOf(0);
        System.out.println(a3 == b3);
        Integer a4 = Integer.valueOf(100000);
        Integer b4 = Integer.valueOf(100000);
        System.out.println(a4 == b4);
    }
}
