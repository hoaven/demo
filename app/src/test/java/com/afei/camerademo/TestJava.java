package com.afei.camerademo;
import com.afei.camerademo.test.Person;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

/**
 * author : wangyya
 * date   : 2019/6/25
 */
public class TestJava {

    @Test
    public void testEquals() {
//        String s1 = "ab";
//        String s2 = "ab";
//        String s3 = s1+"c";
//        System.out.println("String " + (s1 == s2));
//
//        Integer i1 = 10;
//        Integer i2 = 10;
//        System.out.println(i1.toString()+","+i1.hashCode()+","+i2.toString()+","+i2.hashCode());
//        System.out.println("Integer " + (i1 == i2));
//
//        boolean b1 = false;
//        boolean b2 = false;
//        System.out.println("boolean " + (b1 == b2));
//
//        Double d1 = 1d;
//        Double d2 = 1d;
//        System.out.println(d1.toString()+","+d1.hashCode()+","+d2.toString()+","+d2.hashCode());
//        System.out.println("Double " + (d1 == d2));

//        Integer i1 = 40,i2 = 40,i3 = 0;
//        System.out.println(i1 == (i2+i3));

//        String date1 = "2019-06-11 13:00:00";
//        System.out.println(compareDate(date1));
//
//        String date2 = "2019-06-26 11:17:00";
//        System.out.println(compareDate(date2));
//
//        String date3 = "2019-06-27 13:00:00";
//        System.out.println(compareDate(date3));

//        Vector v = new Vector(6);
//        v.add("a");
//        v.add(1);
//        v.add(false);
//        v.add(1.2f);
//        v.add(new Person());




    }

    private boolean compareDate(String date){
        Date today;
        Date compareDate;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            today = new Date();
            compareDate = format.parse(date);
            if(compareDate.before(today)){
                return true;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
