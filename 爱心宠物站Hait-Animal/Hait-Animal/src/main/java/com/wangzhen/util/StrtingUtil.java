package com.wangzhen.util;

/**
 * @author wangzhen
 * @creat 18:23
 */
public class StrtingUtil {
    public static String myTrim(String str){
        char[] s = str.toCharArray();
        int sumOfNull = 0;  // 空格数

        for (int i = 0; i < s.length; i++) {
            if(s[i] == ' ')   sumOfNull++;

        }

        //  将不是空格元素赋给新数组
        char[] s2 = new char[s.length - sumOfNull];
        for (int i = 0, j = 0; i < s.length; i++) {
            if(s[i] != ' ') {
                s2[j] = s[i];
                j++;
            }
        }

        String str1 = String.valueOf(s2);
        return str1;
    }
    public static String reversal(String str, int firstIndex, int lastIndex){
        char[] s = str.toCharArray();
        //  左闭又开
        for (int i = firstIndex - 1, j = lastIndex - 2, k = 0; k < (lastIndex - firstIndex) / 2; i++, j--, k++) {
            char tmp;
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
        String str1 = String.valueOf(s);
        return str1;
    }
    public static int myContains(String str, String targetString){
        int total = 0;
        for (; ; ) {
            if(str.contains(targetString)){
                total++;                                //  index为指定字符第一次出现位置，要删除
                int index = str.indexOf(targetString);   //  index之前以及targetString字符
                str = str.substring(index + targetString.length());
            }else if( !str.contains(targetString) ){        //  所以要加上length
                break;
            }
        }
        return total;
    }
    // 只有一个最大相同子串 第一次 abcdef 第二次 abcde bcdef 第三次 abcd bcde cdef。。。每次错一位
    public static String maxSameString(String str1, String str2) {
        String maxString = (str1.length() >= str2.length()) ? str1 : str2;
        String minString = (str1.length() < str2.length()) ? str1 : str2;
        int length = minString.length();     //  abcdef  每次错一位  所以 x++，y++  y到length结束
        for (int i = 0; i < length; i++) {    // 一共进行几大轮比较
            for (int x = 0, y = length - i; y <= length;x++, y++) {  //  每轮的 错一位比较
              //  minString = minString.substring(x,y);  错误 minString  每次都被改变了
                String subString = minString.substring(x,y);
                if(maxString.contains(subString)){
                    return subString;
                }
            }
        }
        return null;
    }
    public static String myStringSort(String str){
        char[] s = str.toCharArray();
        for (int i = 0; i < s.length - 1; i++) {
            for (int j = 0; j < s.length - 1 - i; j++) {
                char tmp;
                if(s[j] > s[j+1]){   //  如果前一个比后一个大 就把他往后面排  冒泡法每次排好一个最大的数
                    tmp = s[j + 1];
                    s[j + 1] = s[j];
                    s[j] = tmp;
                }
            }
        }
        str = String.valueOf(s);
        return str;
    }

    public static void main(String[] args) {
        StrtingUtil strtingUtil = new StrtingUtil();
        String s1 = "  123  ";
        String s = strtingUtil.myTrim(s1);
        System.out.println(s);
    }
}
