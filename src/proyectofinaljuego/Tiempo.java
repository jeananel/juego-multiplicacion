/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinaljuego;

import static java.lang.Thread.sleep;
import javax.swing.JLabel;

/**
 *
 * @author JDevp
 */

public class Tiempo extends Thread {
    
    private final JLabel labelTiempo; // Componente para el cronómetro
    
    public Tiempo(JLabel j) {
        super();
        this.labelTiempo = j;
    }

    public void run() {
        
        int cont_minutos = 0;
        int cont_segundos = 0; 
        int cont_horas = 0;    
        
        try {//si ocurre un error al dormir el proceso(sleep(999))
            for (;;) { //inicio del for infinito           
                if (cont_segundos != 59) {
                    cont_segundos++;                                  
                } else {
                    if (cont_minutos != 59) {
                        cont_segundos = 0; 
                        cont_minutos++;
                    } else {
                        cont_horas++;
                        cont_minutos = 0;
                        cont_segundos = 0;         
                    }
                }
                if (cont_segundos <= 9) {
                    labelTiempo.setText("0" + cont_horas + ":" + "0" + cont_minutos + ":" + "0" + cont_segundos);
                } else {
                    if (cont_minutos <= 9) {
                        labelTiempo.setText("0" + cont_horas + ":" + "0" + cont_minutos + ":" + cont_segundos);
                    } else {
                        labelTiempo.setText("0" + cont_horas + ":" + cont_minutos + ":" + cont_segundos);
                    }
                }
                sleep(999);//Duermo el hilo durante 999 milisegundos(casi un segundo, quintandole el tiempo de proceso)
            }//Fin del for infinito             
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
