package streamStudy;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;
public class BigDecimalStudy {

    public static void main(String[] args) {
        //两个BigDecimal比较大小使用compareTo方法，不仅比较大小，还比较精度
        //返回值解释： 0：相等
        //1：大于
        //-1：小于
        int precision = 100;
        MathContext mc = new MathContext(precision, RoundingMode.HALF_UP);
        BigDecimal flag_min=new BigDecimal(Double.toString(Double.MAX_VALUE));
        BigDecimal flag_max=new BigDecimal(Double.toString(Double.MIN_VALUE));
        BigDecimal pp=null;
        BigDecimal qq=null;
        BigDecimal rr=null;
        BigDecimal cc=null;
        List<Tuple>ans=new ArrayList<>();
            for(double p=0.1d;p<=8d;p+=1e-1){
            for(double q=0.1d;q<=8d;q+=1e-1){
                for(double r=0.1d;r<=8d;r+=1e-1) {
                    for (double c = 1d; c <= 2d; c += 1e-2) {
                        pp = new BigDecimal(Double.toString(p));
                        qq = new BigDecimal(Double.toString(q));
                        rr = new BigDecimal(Double.toString(r));
                        cc = new BigDecimal(Double.toString(r));
                        BigDecimal x0 = (pp.multiply(cc).add(qq)).divide(cc.add(rr), 51, BigDecimal.ROUND_HALF_UP);
                        BigDecimal x1 = new BigDecimal(Double.toString(0.5)).multiply(x0.add(cc.divide(x0, 51, BigDecimal.ROUND_HALF_UP)));
//                        BigDecimal tmp = x1.subtract(cc.sqrt(mc)).divide(x1.add(cc.sqrt(mc)), 51, BigDecimal.ROUND_HALF_UP);
                        BigDecimal tmp=x1.subtract(cc.sqrt(mc)).divide(new BigDecimal("2").multiply(cc.sqrt(mc)),51,BigDecimal.ROUND_HALF_UP);
                        if (tmp.compareTo(flag_max) > 0) {
                            flag_max = tmp;
                        }

                    }
                    if (flag_max.compareTo(flag_min) < 0) {
                        flag_min = flag_max;
                        ans.clear();
                        ans.add(new Tuple(pp, qq, rr, cc));
                    }
                }

            }
        }
        System.out.println(ans.get(0).p+" "+ans.get(0).q+" "+ans.get(0).r+" "+ans.get(0).c);
        System.out.println(flag_min);
    }
}
class Tuple{
    BigDecimal p;
    BigDecimal q;
    BigDecimal r;
    BigDecimal c;

    public Tuple(BigDecimal p, BigDecimal q, BigDecimal r, BigDecimal c) {
        this.p = p;
        this.q = q;
        this.r = r;
        this.c = c;
    }
}