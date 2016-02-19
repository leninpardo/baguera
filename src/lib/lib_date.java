/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author lenin
 */
public class lib_date {

    private Calendar fecha_date;

    public lib_date(Calendar datos) {
        this.fecha_date = datos;
    }

    public int year() {
        return this.fecha_date.get(Calendar.YEAR);
    }

    public int mes() {
        return this.fecha_date.get(Calendar.MONTH)+1;
    }

    public int dia() {
        return this.fecha_date.get(Calendar.DAY_OF_MONTH);
    }
//    public Date fecha_convert(String date){
//   Date dt= new Date();
//
//    }

    public String fecha() {
        return String.valueOf(year()) + "-" + String.valueOf(mes()) + "-" + String.valueOf(dia());
    }
public Date getFecha_date(){
return this.fecha_date.getTime();

}
    public Date sum_fecha(Date fecha, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }

    public String getFecha_actual(Date fecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        this.fecha_date=calendar;
        return fecha();
        //return String.valueOf(Calendar.YEAR)+"-"+String.valueOf(Calendar.MONTH)+"-"+String.valueOf(Calendar.DAY_OF_MONTH);
    }
    public java.sql.Date convert_date(String fecha){
     //Calendar calendar = Calendar.getInstance();
      return java.sql.Date.valueOf(fecha);
    }
    

}
