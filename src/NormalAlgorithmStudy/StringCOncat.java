package NormalAlgorithmStudy;

/**
 * @author 唐良爽
 * @version 1.0
 * Created by Intellij IDEA
 */

public class StringCOncat {
    public static void main(String[] args) {
        String[]arrs=new String[]{"I","Love","beautiful","and","cute","girl"};
        String join = String.join(" ", arrs);//String.join把字符串数组拼接成一个字符串
        System.out.println(join);
        System.out.println(join.indexOf("cute"));//indexOf用于查找子串位置，找不到返回-1
        System.out.println(join.indexOf("tesrtr"));//-1
    }
}
