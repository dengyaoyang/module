package com.test;


import java.math.BigInteger;
import java.util.Random;

/**
 * @auther Administrator dyy
 * @create
 */
public class PWDTest {
    static long x = 1008;
    public int createP(){
        int bigNum = oddNum();
        int x = 0;
        for (int i = 2;i<bigNum;i++){
            x = bigNum%i;
           if (x==0){
               return createP();
            }
        }
        return bigNum;
    }



    public static int oddNum(){
        Random random = new Random();
        int k = (int)(1000*random.nextDouble());
        while (k%2==0){
            k = (int)(1000*random.nextDouble());
        }
        return k;
    }

    /**
     * 求E --为M的任一互素数
     * @param
     */
    public static int creatE(int m){
        int e = 2;
        boolean flag = true;
        for (int i=2;i<m-1;i++){
                if (m%i==0){
                   continue;
                }else {
                    for (int k=2;k<i;k++){
                        if (i%k==0){
                            flag = false;
                            break;
                        }
                    }
                    if (flag){
                        e=i;
                        break;
                    }
                }
        }
        return  e;
    }



    public static void main(String[] args) {
        PWDTest pwdTest = new PWDTest();
        int p =pwdTest.createP();
        int q = pwdTest.createP();
        int n =p*q;
        int m = (p-1)*(q-1);
        int e = creatE(m);
        int d = 0;
        for (int i=1;i<m;i++){
            double j = (double) (m*i+1)/e;
            int k = (int)j;
            if (j%k==0){
                d = k;
                break;
            }
        }
        BigInteger bigN = new BigInteger(String.valueOf(n));
        BigInteger ePwd = new BigInteger(String.valueOf(x)).pow(e).mod(bigN);
        BigInteger re = new BigInteger(ePwd.toString()).pow(d).mod(bigN);
        System.out.println("原文:"+x);
        System.out.println("公钥"+e);
        System.out.println("密文"+ePwd);
        System.out.println("私钥"+d);
        System.out.println("通过私钥还原密文"+re);
    }

}
