/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinaljuego;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author JDevp
 */
public class nivel1 extends javax.swing.JFrame {

    /**
     * Creates new form nivel1
     */
    
    static int counter = 0, iteration = 1, fallas =0;
    
    Multiplicacion mult = new Multiplicacion(); 
    List<Multiplicacion> iteratingList = mult.getIteratingList(); // Almacena las tablas
    
    Componente[][] tablero = new Componente[7][7];
    int filas = 7;
    int columnas = 7;
    int totalscore = 0;

    private final boolean  tiempo;
    private final boolean sonido;
    private  boolean control_score = true;

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        nivel1.counter = counter;
    }

    public nivel1(Boolean time, Boolean sound) {
        initComponents();
        
        this.tiempo = time;
        this.sonido = sound;
        
        lblAnimacion.setVisible(false);   

        dibujarTabla(); // Generar componentes dinamicamente
        
        mult.fill_tabla(6); // 36 respuestas posibles
        
        // Operación inicial: Elemento 0 de la lista.
        lblMultiplicando.setText(String.valueOf(iteratingList.get(0).getMultiplicando()));
        lblMultiplicador.setText(String.valueOf(iteratingList.get(0).getMultiplicador()));
        
         marcar_operacion(iteratingList.get(0).getMultiplicando(),iteratingList.get(0).getMultiplicador());
         
        // Para ir verificando por el terminal las iteraciones
         mostrarLista();
        
        // Mostrar score inicial (0)
        labelScore.setText(String.valueOf(totalscore));
        tiempo();
        check_disabled_boton();
        
    }

    public void tiempo(){
        System.out.println(tiempo);
            if (tiempo){
               Tiempo c=new Tiempo(this.lblTiempo); //Intancio la clase
               c.start(); //Ejecuto el metodo run del Thread
            } else {
                System.out.println("Tiempo deshabilitado");
            }
    }
    
    public void mostrarLista(){         
        Iterator<Multiplicacion> itrPartidos = iteratingList.iterator();
        while (itrPartidos.hasNext()) {
            Multiplicacion partido = itrPartidos.next();
            System.out.println(partido.getMultiplicando() + " x " + partido.getMultiplicador() + " = " + partido.getRespuesta());
        }  
        System.out.println("-------------------");
    }    
    
    public void dibujarTabla(){
        int count = 0;
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                tablero[fila][columna] = new Componente(45 * columna, 32 * fila, 55, 45);
                //botones[fila][columna].cambiarNombre(fila,columna);
                jPanel2.add(tablero[fila][columna]);
                if (fila == 0 && columna == 0) {
                    tablero[fila][columna].setHorizontalAlignment(SwingConstants.CENTER);
                    tablero[fila][columna].setX("X");
                } else {
                    //Border border = BorderFactory.createLineBorder(Color.WHITE, 5);
                    //botones[fila][columna].setOpaque(true);
                    if (fila == 0) {
                        //botones[fila][columna].setBackground(Color.red);
                         tablero[fila][columna].setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                        tablero[fila][columna].setHorizontalAlignment(SwingConstants.CENTER);
                        //botones[fila][columna].setBorder(border);
                        tablero[fila][columna].setForeground(Color.white);
                        tablero[fila][columna].setFilaInicio(count);
                    }
                    if (columna == 0) {
                        //botones[fila][columna].setBackground(Color.red);
                        tablero[fila][columna].setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                        tablero[fila][columna].setHorizontalAlignment(SwingConstants.CENTER);
                        //botones[fila][columna].setBorder(border);
                        tablero[fila][columna].setForeground(Color.white);
                        tablero[fila][columna].setColumnaInicio(fila - 1);
                    }
                    count++;
                }
            }
        }
    }    
    
    public void check_enabled_boton(){
            btnVerificar.setEnabled(true);
    }

    public void check_disabled_boton(){
            btnVerificar.setEnabled(false);
    }    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        btnAtras = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnReiniciar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelScore = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblAnimacion = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblMultiplicando = new javax.swing.JLabel();
        lblsigno = new javax.swing.JLabel();
        lblMultiplicador = new javax.swing.JLabel();
        lblSigno = new javax.swing.JLabel();
        lblResultado = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnborrar = new javax.swing.JButton();
        btnVerificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nivel 1");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/atras.png"))); // NOI18N
        btnAtras.setToolTipText("Atras");
        btnAtras.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 83, 53));

        jPanel1.setBackground(new java.awt.Color(215, 215, 215));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnReiniciar.setBackground(new java.awt.Color(221, 221, 221));
        btnReiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cambiar.png"))); // NOI18N
        btnReiniciar.setToolTipText("Reiniciar");
        btnReiniciar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnReiniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Multiply");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nivel 1");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Score:");

        labelScore.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelScore.setText("0");

        lblTiempo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelScore, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelScore))
                .addGap(49, 49, 49)
                .addComponent(btnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 250, -1));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 85, 330, 240));
        getContentPane().add(lblAnimacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 200, 170));

        jPanel3.setOpaque(false);

        lblMultiplicando.setBackground(new java.awt.Color(204, 204, 204));
        lblMultiplicando.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMultiplicando.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMultiplicando.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblMultiplicando.setOpaque(true);

        lblsigno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblsigno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/multiplicacion.png"))); // NOI18N

        lblMultiplicador.setBackground(new java.awt.Color(204, 204, 204));
        lblMultiplicador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMultiplicador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMultiplicador.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblMultiplicador.setOpaque(true);

        lblSigno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSigno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/igual.png"))); // NOI18N

        lblResultado.setBackground(new java.awt.Color(204, 204, 204));
        lblResultado.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblResultado.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblMultiplicando, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblsigno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMultiplicador, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSigno, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSigno)
                    .addComponent(lblMultiplicador, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblsigno)
                    .addComponent(lblMultiplicando, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, -1));

        jPanel4.setOpaque(false);

        btn7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btn4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn0.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });

        btnborrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/borrar.png"))); // NOI18N
        btnborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnborrarActionPerformed(evt);
            }
        });

        btnVerificar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnVerificar.setText("Check");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnborrar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 40, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(btnVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnborrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, 260, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        counter = 0; 
        iteration = 1;
        this.hide();
        principal prin = new principal();
        prin.show();
        prin.getContentPane().setBackground( new Color(173, 202, 255));
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        // TODO add your handling code here:
        if (counter==35){ // 1 mas para el control
            this.hide();
            resultados fin = new resultados("1", labelScore.getText() , "36", lblTiempo.getText());
            fin.show();
        } else {
        for(int i = counter; i < iteration; i++){
            System.out.println(iteratingList.get(counter).getMultiplicando()+ " x " + iteratingList.get(counter).getMultiplicador() + " = " +iteratingList.get(counter).getRespuesta());
        }
        if (Integer.parseInt(lblResultado.getText()) == iteratingList.get(counter).getRespuesta()) {
            diccionario_respuestas(iteratingList.get(counter).getMultiplicando(),iteratingList.get(counter).getMultiplicador(),iteratingList.get(counter).getRespuesta());
            //System.out.println("correcto");
            limpiar(); // Resultado
            check_disabled_boton();
            animacion_respuesta_correcta();
            counter++; // Avanzar si la respuesta es correcta
            // Marcar fila y columna del multiplicando y multiplicador
            desmarcar_operacion(iteratingList.get(counter-1).getMultiplicando(),iteratingList.get(counter-1).getMultiplicador());
            marcar_operacion(iteratingList.get(counter).getMultiplicando(),iteratingList.get(counter).getMultiplicador());
            if(control_score){
                totalscore++;
            }
            control_score = true;
            lblMultiplicando.setText(String.valueOf(iteratingList.get(counter).getMultiplicando()));
            lblMultiplicador.setText(String.valueOf(iteratingList.get(counter).getMultiplicador()));
        } else {
            System.out.println("incorrecto");
            fallas++;
            control_score = false;
            System.out.println("falla "+fallas);
            animacion_respuesta_incorrecta();
            limpiar(); // Resultado
            check_disabled_boton();
        }
        //System.out.println(iteration);
        iteration ++;
        labelScore.setText(String.valueOf(totalscore));         
        }        
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        // TODO add your handling code here:
        lblResultado.setText(lblResultado.getText()+"7");
        check_enabled_boton();        
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        // TODO add your handling code here:
        lblResultado.setText(lblResultado.getText()+"8");
        check_enabled_boton();        
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        lblResultado.setText(lblResultado.getText()+"9");
        check_enabled_boton();
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        lblResultado.setText(lblResultado.getText()+"4");
        check_enabled_boton();
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        lblResultado.setText(lblResultado.getText()+"5");
        check_enabled_boton();
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        lblResultado.setText(lblResultado.getText()+"6");
        check_enabled_boton();
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        lblResultado.setText(lblResultado.getText()+"1");
        check_enabled_boton();
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        lblResultado.setText(lblResultado.getText()+"2");
        check_enabled_boton();
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        lblResultado.setText(lblResultado.getText()+"3");
        check_enabled_boton();
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        lblResultado.setText(lblResultado.getText()+"0");
        check_enabled_boton();
    }//GEN-LAST:event_btn0ActionPerformed

    private void btnborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnborrarActionPerformed
        // TODO add your handling code here:
        String resultado = lblResultado.getText();
        //System.out.println(resultado);
        int total = resultado.length();
        if (total > 0) {
            //System.out.println(total);
            String nuevo = resultado.substring(0, total - 1);
            //System.out.println(nuevo);
            lblResultado.setText(nuevo);
        } else {
            System.out.println("escriba para poder borrar");
            check_disabled_boton();
        }   
    }//GEN-LAST:event_btnborrarActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        // TODO add your handling code here:
        this.hide();
        
        nivel1 niv1 = new nivel1(this.tiempo, this.sonido);
        niv1.getContentPane().setBackground(new Color(173, 202, 255));
        niv1.show();
    }//GEN-LAST:event_btnReiniciarActionPerformed

    public void animacion_respuesta_correcta(){
        Icon i = new ImageIcon("feliz.png");
        lblAnimacion.setIcon(i);
        Icon signo = new ImageIcon("igual.png");
        lblSigno.setIcon(signo);
        lblAnimacion.setVisible(true);
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblAnimacion.setVisible(false);
            }
        });
        timer.start();  
    }

    public void animacion_respuesta_incorrecta(){
        Icon i = new ImageIcon("triste.png");
        lblAnimacion.setIcon(i);
        lblAnimacion.setVisible(true);
        Icon signo = new ImageIcon("desigual.png");
        lblSigno.setIcon(signo);
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear text or whatever you want
                lblAnimacion.setVisible(false);
                Icon signo = new ImageIcon("igual.png");
                lblSigno.setIcon(signo);
            }
        });
        timer.start();  
    }
    
    public void marcar_operacion(int multiplicando, int multiplicador){
            for(int  fila=0; fila<filas; fila++){
            for(int columna=0; columna<columnas; columna++){
                    tablero[multiplicando][0].setForeground(Color.yellow);
                    tablero[0][multiplicador].setForeground(Color.yellow); 
            }}     
    }

    public void desmarcar_operacion(int multiplicando, int multiplicador){
            for(int  fila=0; fila<filas; fila++){
            for(int columna=0; columna<columnas; columna++){
                    tablero[multiplicando][0].setForeground(Color.white);
                    tablero[0][multiplicador].setForeground(Color.white); 
            }}     
    }
    
    // Envia la respuesta a la matriz de componentes
    public void diccionario_respuestas(int multiplicando, int multiplicador, int respuesta){
            for(int  fila=0; fila<filas; fila++){
            for(int columna=0; columna<columnas; columna++){
                   // botones[0][1].setForeground(Color.yellow); 
                    tablero[multiplicando][multiplicador].setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                    tablero[multiplicando][multiplicador].setHorizontalAlignment(SwingConstants.CENTER);
                        //botones[fila][columna].setBorder(border);
                    tablero[multiplicando][multiplicador].setForeground(Color.blue);                    
                    tablero[multiplicando][multiplicador].setX(String.valueOf(respuesta));        
            }}                  
                        
    }
    
    
    public void limpiar(){
        //lblMultiplicando.setText("");
        //lblMultiplicador.setText("");
        lblResultado.setText("");
    }    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(nivel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nivel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nivel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nivel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                //new nivel1().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JButton btnborrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel labelScore;
    private javax.swing.JLabel lblAnimacion;
    private javax.swing.JLabel lblMultiplicador;
    private javax.swing.JLabel lblMultiplicando;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JLabel lblSigno;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblsigno;
    // End of variables declaration//GEN-END:variables
}
