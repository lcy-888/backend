package com.its.demo.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 杨金刚
 * @date 2019/7/5 8:57
 */
public class DateTimeUtil {

    public static String getLocalDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();

        return today.format(dtf);
    }

    public static String getLocalDateDiff(int days){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();
        LocalDate diffDate = null;
        if(days > 0){
            diffDate = today.plusDays(days);
        }
        else{
            diffDate = today.minusDays(-days);
        }

        return diffDate.format(dtf);
    }

    public static String getLocalDate(String formatter){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatter);
        LocalDate today = LocalDate.now();

        return today.format(dtf);
    }

    public static String getLocalTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime now = LocalTime.now();

        return now.format(dtf);
    }

    public static String getLocalTime(String formatter) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatter);
        LocalTime now = LocalTime.now();

        return now.format(dtf);
    }

    public static String getLocalDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        return now.format(dtf);
    }

    public static String getLocalDateTime(String formatter) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatter);
        LocalDateTime now = LocalDateTime.now();

        return now.format(dtf);
    }


}
