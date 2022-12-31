package com.sesami.sesamiassignment;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateHelper {
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";
    public Date strToDate(String str) throws ParseException {
       return new SimpleDateFormat(DATE_FORMAT).parse(str);
    }
}
