import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    private static boolean[] used;

    public static void test() {
        used = new boolean[12];
    }

    public static void main(String[] args) {
        test();
        System.out.println(Arrays.toString(used));

    }

}
