/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinaljuego;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author JDevp
 */
public class Componente extends JLabel implements ActionListener {

    public Componente(int posx, int posy, int ancho, int alto){
        setBounds(posx, posy, ancho, alto); // Set propiedades del JLabel
    }
    
    // Para enviar respuesta
    public void setTexto(int respuesta){
        setText(": "+respuesta);
    }
    
    // Para identificar fila y columna
    public void cambiarNombre(int x, int y){
        setText((x+1)+"-"+(y+1));
    }

    public void setX(String x){
        setText(x);
    }

    
    public void setFilaInicio(int x){
        setText(""+(x+1));
    }
    
    public void setColumnaInicio(int y){
        setText(""+(y+1));
    }
    
    // Testing de action para enviar propiedad a componente.
    @Override
    public void actionPerformed(ActionEvent ae) {
        setBackground(Color.orange);
    }
    
}
