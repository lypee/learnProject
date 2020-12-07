package collections.Test;


import java.util.*;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        int MoneyNum=0;;
        System.out.println("输入");
        MoneyNum=in.nextInt();
        T_money(MoneyNum);
    }
    public static void T_money(int money) {
        int num=0;
        //汉字
        String[] MoneyChinese= {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
        //单位
        String[] ChineseNum= {"","拾","佰","仟","万","亿"};
        System.out.println(ChineseNum[0]);
        Integer Money=new Integer(money);
        char[] Moneynum=Money.toString().toCharArray();
        String[] MoneyChineseNum =new String[Moneynum.length];
        for(int i=0;i<Moneynum.length;i++) {
            num=Moneynum[i]-48;
            MoneyChineseNum[i]=MoneyChinese[num];
        }
        StringBuffer MoneyTime=new StringBuffer();
        int nums=0;
        int Numss=0;
        for(int i=MoneyChineseNum.length-1;i>=0;i--) {

            if(!MoneyChineseNum[i].equals("零"))
            {
                if(!ChineseNum[nums].equals("万"))
                    MoneyTime.append(ChineseNum[nums]);
            }

            if(nums==4&&Numss==0)
            {
                MoneyTime.append(ChineseNum[nums]);
                nums=0;
                Numss=1;
                if(!MoneyChineseNum[i].equals("零"))
                {MoneyTime.append(MoneyChineseNum[i]);}
            }
            else if(nums==4&&Numss==1)
            {
                MoneyTime.append(ChineseNum[nums+1]);
                nums=0;
                Numss=0;
                if(!MoneyChineseNum[i].equals("零"))
                {MoneyTime.append(MoneyChineseNum[i]);}
            }
            else {
                MoneyTime.append(MoneyChineseNum[i]);
            }
            ++nums;
        }
        System.out.println("输出：");
        System.out.println(MoneyTime.reverse().toString());
    }

}
