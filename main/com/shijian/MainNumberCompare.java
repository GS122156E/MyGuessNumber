package com.shijian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: STU
 * Date: 12-10-28
 * Time: 下午2:50
 * To change this template use File | Settings | File Templates.
 */
public class MainNumberCompare {
    public void setFourNumber(String fourNumber) {
        this.fourNumber = fourNumber;
    }

    private String fourNumber = null;
    private boolean isFailed = false;

    public String compareNumber(String srcnumber)
    {
        if(!isNumber(srcnumber))
            return "输入数不合法！";

        int anum = 0;
        int bnum = 0;
        int[] status = new int[]{0,0,0,0};
        for(int i=0;i<4;i++)
        {
           if(fourNumber.charAt(i) == srcnumber.charAt(i))
            {
                anum++;
                status[i]=1;
            }
            else
            {
               bnum += compareB(fourNumber,srcnumber.charAt(i),status);
            }
        }
        return new StringBuilder()
                .append(anum)
                .append("A")
                .append(bnum)
                .append("B")
                .toString();
    }


    private int compareB(String src,char c,int[] index)
    {
         for(int i=0;i<index.length;i++ )
             if(index[i] == 0)
              if(c == src.charAt(i))
                 return 1;

        return 0;
    }

    /*
      * 判断4位数是否合法
      */
    public boolean isNumber(String src)
    {
        if( !isPattern(src))
            return false;

        int[] temps = new int[]{0,0,0,0,0,0,0,0,0,0};
        char[] cs = src.toCharArray();
        for(char c : cs)
        {
            if(temps[Integer.parseInt(String.valueOf(c))]==1)
                return false;
            else
                temps[Integer.parseInt(String.valueOf(c))]=1;
        }

        return true;
    }

    /*
      * 获取随机4位数
      */
    public String randomFourNumber()
    {
        Random r=new Random();

        int[] temps = new int[]{0,0,0,0,0,0,0,0,0,0};
        StringBuilder sb = new StringBuilder();
        int i = 0,temp=-1;
        while(i < 4)
        {
            temp = r.nextInt(10);

            if(i==0 && temp==0)
                continue;

            if(temps[temp] == 1)
                continue;

            temps[temp]=1;

            sb.append(temp);
            i++;
        }
        //System.out.println("====randmo:"+sb.toString()+"=====");

        fourNumber = sb.toString();
        return fourNumber;
    }

    private boolean isPattern(String src)
    {
        Pattern p = Pattern.compile("\\d{4}");
        return p.matcher(src).matches();
    }

    public void runGame()
    {
        randomFourNumber();

        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new InputStreamReader(System.in));
            int num = 0;

            while(num<7)
            {
                String src = br.readLine();
                if(src.startsWith("q"))
                    break;


                if(isPattern(src))
                {
                    String result = compareNumber(src);
                    System.out.println(num+":"+result);
                    if(result.equals("4A0B"))
                        break;
                }
                else
                {
                    System.out.println(num+":输入有误！");
                }
                num++;
            }
            System.out.println("randomNumber:"+fourNumber);

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        MainNumberCompare mnc = new MainNumberCompare();
        mnc.runGame();
//		mnc.randomFourNumber();
//		String result = mnc.compareNumber("9023");
//		System.out.println("======"+result);
    }

}
