/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lib;

import java.io.IOException;

/**
 *
 * @author leninpardo
 */
public class execute_bk {
    public static void exec(){
    try {
	 //Comando de apagado en linux
        String cmd = "mysqldump --opt -h localhost copera_doncel2 -u root -p123456 -r '/home/leninpardo/kll.sql' 2>&1"; 
	Runtime.getRuntime().exec(cmd); 
} catch (IOException ioe) {
	System.out.println (ioe);
}
    }
    public static void main(String args[]){
    exec();
    }
}
