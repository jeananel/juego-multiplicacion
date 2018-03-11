/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinaljuego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author JDevp
 */

public class Multiplicacion {
    
    public int multiplicando;
    public int multiplicador;
    public int respuesta;
    
    List<Multiplicacion> iteratingList = new ArrayList<>();
    //List<Multiplicacion> iteratingList = new ArrayList<Multiplicacion>();
    
    public List<Multiplicacion> getIteratingList() {
        return iteratingList;
    }

    public void setIteratingList(List<Multiplicacion> iteratingList) {
        this.iteratingList = iteratingList;
    }

    public Multiplicacion(int multiplicando, int multiplicador, int respuesta) {
        this.multiplicando = multiplicando;
        this.multiplicador = multiplicador;
        this.respuesta = respuesta;
    }
    
    public Multiplicacion() {
    }

    
    public int getMultiplicando() {
        return multiplicando;
    }

    public void setMultiplicando(int multiplicando) {
        this.multiplicando = multiplicando;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }
    
    public void fill_tabla(int limite){
        for(int i = 1; i<=limite; i++)
        {
            for(int j = 1; j <= limite; j++)
            {
                Multiplicacion multiplicacion = new Multiplicacion();
                multiplicacion.setMultiplicando(i);
                multiplicacion.setMultiplicador(j);
                multiplicacion.setRespuesta(i*j);
                iteratingList.add(multiplicacion);
            }
        }
        Collections.shuffle(iteratingList); // Sort aleatorio 
    }    
    

}
