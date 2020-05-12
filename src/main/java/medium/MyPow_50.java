package medium;

/**
 * @Author:queena
 * @Date:2020/5/111035
 * @Description:
 */
public class MyPow_50 {
    public double myPow(double x, int n) {
        long N=n;
        if (n==1){
            return x;
        }
        return n>0?pow(x,N):1/pow(x,-N);//如果这里用int型，则-(-2147483648)还是为负数
    }
/*
    public double pow(double x,int n){
        if (n==0){
            return 1.0;
        }
        double y=pow(x,n/2);
        return n%2==0?y*y:y*y*x;
    }
*/
    public double myPow1(double x,long n){
        if (n==0){
            return 1;
        }
        if (n<0){
            return 1.0/myPow1(x,-n);
        }
        if (n%2==1){
            return myPow1(x,n-1)*x;
        }
        double y=myPow1(x,n/2);
        return y*y;
    }//我觉得我更能理解的写法

    public double pow(double x,long n){
        double res=1.0;
        double xx=x;
        while (n>0){
            if (n%2==0){
                res*=xx;
            }
            xx*=xx;
            n/=2;//n>>=1(右移一位等于除以2)
        }
        return res;
    }

    public static void main(String[] args) {
        MyPow_50 m=new MyPow_50();
        System.out.println(m.myPow(2.0,-2147483648));
    }

}

/*
两种方法（递归、迭代）
1.递归：
2.迭代：x^77为例(77=1001101),从低到高每一位代表x^1,x^2,x^4,x^8,x^16,x^32,
则x^77=x^1 * x^4 * x^8 * x^32(即所有是1的位)
 */