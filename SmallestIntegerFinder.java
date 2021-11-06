import java.util.Arrays;

public class SmallestIntegerFinder {
    public static int findSmallestInt(int[] args) {
        Arrays.sort(args);
        return args[0];
    }

    public static void main(String[] args) {

        System.out.println(findSmallestInt(new int[]{78,56,-2,12,8,-33}));
    }
}

