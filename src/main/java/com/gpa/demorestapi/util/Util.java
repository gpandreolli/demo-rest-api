package com.gpa.demorestapi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {

   public static SimpleDateFormat  formater = new SimpleDateFormat("yyyy-MM-dd");

    public static String encontrarUltimoDiaMes(String mes) throws ParseException {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.MONTH, Integer.parseInt(mes)-1);
        return String.valueOf(instance.getActualMaximum(Calendar.DAY_OF_MONTH));
    }

    public static Date encontraDataInicial(String mes,String ano) throws ParseException {
        return formater.parse(ano+"-"+mes+"-01");
    }

    public static Date encontraDataFinal(String mes,String ano) throws ParseException {
        String dia = encontrarUltimoDiaMes(mes);
        return formater.parse(ano+"-"+mes+"-"+dia);
    }
}
