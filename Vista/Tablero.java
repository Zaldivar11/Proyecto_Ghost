package Vista;

import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import Usuario.Usuario;
import UsuarioDAO.UsuarioDAO;
import static Vista.MenuPrincipal.UsuarioGLob;

public class Tablero extends javax.swing.JFrame implements ActionListener {

    private char turnoJugador = 'L';
    private String Castillo[][];
    private String PosicionAntigua = null, PosicionNueva = null, PosicionActual, Player2 = MenuPrincipal.Player2, Movimiento = "", Dificultad = Configuracion.Dificultad, MododeJuego = Configuracion.MododeJuego, enemy;
    public int GhostsGp1 = 0, GhostsGp2 = 0, GhostsBp1 = 0, GhostsBp2 = 0, contador = 0;
    private boolean victoria = false, colocadas = false;
    Usuario UsuarioGlob = MenuPrincipal.UsuarioGLob;
    int xMouse, yMouse;

    public Tablero() {

        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void TableroAleatorio() {
        if (MododeJuego.equals("aleatorio"))
        {

            Random random = new Random();
            int Control = random.nextInt(1);
            Castillo = new String[6][6];
            for (int L = 0; L < 6; L++)
            {
                for (int F = 0; F < 6; F++)
                {
                    Castillo[L][F] = "";
                }
            }

            if (Dificultad.equals("normal"))
            {
                for (int i = 4; i < 6; i++)
                {
                    for (int j = 1; j < 5; j++)
                    {
                        if (Control == 0)
                        {
                            Castillo[i][j] = "B1";
                        } else if (Control == 1)
                        {
                            Castillo[i][j] = "M1";
                        }
                        boton(i + "" + j).setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/amigo-ghost.png")));
                    }
                }
                for (int i = 0; i < 2; i++)
                {
                    for (int j = 1; j < 5; j++)
                    {
                        if (Control == 0)
                        {
                            Castillo[i][j] = "B2";
                        } else if (Control == 1)
                        {
                            Castillo[i][j] = "M2";
                        }
                        boton(i + "" + j).setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/enemy-ghost.png")));
                    }
                }
                GhostsGp1 = 4;
                GhostsBp1 = 4;
                GhostsGp2 = 4;
                GhostsBp2 = 4;
            } else if (Dificultad.equals("expert"))
            {
                for (int i = 4; i < 6; i++)
                {
                    for (int j = 2; j < 4; j++)
                    {
                        if (Control == 0)
                        {
                            Castillo[i][j] = "B1";
                        } else if (Control == 1)
                        {
                            Castillo[i][j] = "M1";
                        }
                        boton(i + "" + j).setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/amigo-ghost.png")));
                    }
                }
                for (int i = 0; i < 2; i++)
                {
                    for (int j = 2; j < 4; j++)
                    {
                        if (Control == 0)
                        {
                            Castillo[i][j] = "B2";
                        } else if (Control == 1)
                        {
                            Castillo[i][j] = "M2";
                        }
                        boton(i + "" + j).setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/enemy-ghost.png")));
                    }
                }
                GhostsGp1 = 2;
                GhostsBp1 = 2;
                GhostsGp2 = 2;
                GhostsBp2 = 2;
            } else if (Dificultad.equals("genius"))
            {
                Castillo[5][2] = "B1";
                Castillo[5][3] = "M1";
                Castillo[0][2] = "M2";
                Castillo[0][3] = "B1";
                GhostsGp1 = 1;
                GhostsBp1 = 1;
                GhostsGp2 = 1;
                GhostsBp2 = 1;
                boton(5 + "" + 2).setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/amigo-ghost.png")));
                boton(5 + "" + 3).setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/amigo-ghost.png")));
                boton(0 + "" + 2).setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/enemy-ghost.png")));
                boton(0 + "" + 3).setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/enemy-ghost.png")));
            }
            jLabel13.setText("Fantasmas Buenos: " + GhostsGp1);
            jLabel15.setText("Fantasmas Malos: " + GhostsBp1);
            jLabel10.setText("Fantasmas Buenos: " + GhostsGp2);
            jLabel12.setText("Fantasmas Malos: " + GhostsBp2);
        } else
        {
            Castillo = new String[6][6];
            for (int L = 0; L < 6; L++)
            {
                for (int F = 0; F < 6; F++)
                {
                    Castillo[L][F] = "";
                }
            }
        }
    }

    private boolean movimientosPosible(String old, String nuevo, char turno) {
        int oldx = Integer.parseInt(Character.toString(old.charAt(0)));
        int oldy = Integer.parseInt(Character.toString(old.charAt(1)));
        int newx = Integer.parseInt(Character.toString(nuevo.charAt(0)));
        int newy = Integer.parseInt(Character.toString(nuevo.charAt(1)));
        if ((oldx + 1) == newx && oldy == newy)
        {
            return true;
        } else if (oldx == newx && (oldy + 1) == newy)
        {
            return true;
        } else if ((oldx - 1) == newx && oldy == newy)
        {
            return true;
        } else if (oldx == newx && (oldy - 1) == newy)
        {
            return true;
        }
        return false;
    }

    public void vaciarTablero() {
        String posicionVacia = "";
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                posicionVacia = i + "" + j;
                if (boton(posicionVacia).getIcon() != null)
                {
                    boton(posicionVacia).setIcon(null);
                }
            }
        }
    }

    public void actionPerformed(java.awt.event.ActionEvent ae) {
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                System.out.println(Castillo[i][j]);
                if (Castillo[i][j].equals(""))
                {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        int x = -1, y = -1;
        if (MododeJuego.equals("aleatorio"))
        {
            colocadas = true;
        }
        if (colocadas == false)
        {
            Movimiento = getBotonStr(ae.getSource());
            y = Integer.parseInt(Character.toString(Movimiento.charAt(0)));
            x = Integer.parseInt(Character.toString(Movimiento.charAt(1)));
            if (turnoJugador == 'L')
            {
                if ((contador == 7 && Dificultad.equals("normal")) || (contador == 3 && Dificultad.equals("expert"))
                        || (contador == 1 && Dificultad.equals("genius")))
                {
                    turnoJugador = 'R';
                }
                if ((x >= 1 && x <= 4) && (y == 0 || y == 1))
                {
                    if (Dificultad.equals("normal") && (GhostsGp1) < 4)
                    {
                        GhostsGp1++;
                        contador++;
                        Castillo[y][x] = "B1";
                    } else if (Dificultad.equals("normal") && (GhostsBp1) < 4)
                    {
                        GhostsBp1++;
                        contador++;
                        Castillo[y][x] = "M1";
                    } else if (Dificultad.equals("expert") && (GhostsGp1) < 2)
                    {
                        GhostsGp1++;
                        contador++;
                        Castillo[y][x] = "B1";
                    } else if (Dificultad.equals("expert") && (GhostsBp1) < 2)
                    {
                        GhostsBp1++;
                        contador++;
                        Castillo[y][x] = "M1";
                    } else if (Dificultad.equals("genius") && (GhostsGp1) < 1)
                    {
                        GhostsGp1++;
                        contador++;
                        Castillo[y][x] = "B1";
                    } else if (Dificultad.equals("genius") && (GhostsBp1) < 1)
                    {
                        GhostsBp1++;
                        contador++;
                        Castillo[y][x] = "M1";
                    }
                    boton(Movimiento).setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/amigo-ghost.png")));
                }
            } else
            {
                if ((contador == 15 && Dificultad.equals("normal")) || (contador == 7 && Dificultad.equals("expert"))
                        || (contador == 3 && Dificultad.equals("genius")))
                {
                    turnoJugador = 'L';
                    colocadas = true;
                }
                if (x >= 1 && x <= 4 && y == 4 || y == 5)
                {
                    if (Dificultad.equals("normal") && (GhostsGp2) < 4)
                    {
                        GhostsGp2++;
                        contador++;
                        Castillo[y][x] = "B2";
                    } else if (Dificultad.equals("normal") && (GhostsBp2) < 4)
                    {
                        GhostsBp2++;
                        contador++;
                        Castillo[y][x] = "M2";
                    } else if (Dificultad.equals("expert") && (GhostsGp2) < 2)
                    {
                        GhostsGp2++;
                        contador++;
                        Castillo[y][x] = "B2";
                    } else if (Dificultad.equals("expert") && (GhostsBp2) < 2)
                    {
                        GhostsBp2++;
                        contador++;
                        Castillo[y][x] = "M2";
                    } else if (Dificultad.equals("genius") && (GhostsGp2) < 1)
                    {
                        GhostsGp2++;
                        contador++;
                        Castillo[y][x] = "B2";
                    } else if (Dificultad.equals("genius") && (GhostsBp2) < 1)
                    {
                        GhostsBp2++;
                        contador++;
                        Castillo[y][x] = "M2";
                    }
                    boton(Movimiento).setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/enemy-ghost.png")));
                }
            }
        }
        if (victoria == false && colocadas == true)
        {
            if (turnoJugador == 'L')
            {
                PosicionActual = getBotonStr(ae.getSource());
                x = Integer.parseInt(Character.toString(PosicionActual.charAt(0)));
                y = Integer.parseInt(Character.toString(PosicionActual.charAt(1)));
                if (Castillo[x][y].equals("B1") || Castillo[x][y].equals("M1"))
                {
                    PosicionAntigua = PosicionActual;
                } else if (PosicionAntigua != null)
                {
                    PosicionNueva = PosicionActual;
                    if (movimientosPosible(PosicionAntigua, PosicionNueva, 'L'))
                    {
                        int oldx = Integer.parseInt(Character.toString(PosicionAntigua.charAt(0)));
                        int oldy = Integer.parseInt(Character.toString(PosicionAntigua.charAt(1)));

                        if (Castillo[x][y].equals("B2"))
                        {
                            GhostsGp1--;
                            JOptionPane.showMessageDialog(this, "Jugador 1 se ha comido\nun fantasma bueno del jugador 2");
                        } else if (Castillo[x][y].equals("M2"))
                        {
                            GhostsBp2--;
                            JOptionPane.showMessageDialog(this, "Jugador 1 se ha comido\nun fantasma malo del jugador 2");
                        }
                        if (Castillo[oldx][oldy].equals("B1"))
                        {
                            Castillo[x][y] = "B1";
                        } else if (Castillo[oldx][oldy].equals("M1"))
                        {
                            Castillo[x][y] = "M1";
                        }
                        Castillo[oldx][oldy] = "";
                        boton(PosicionAntigua).setIcon(null);
                        boton(PosicionNueva).setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/amigo-ghost.png")));
                        turnoJugador = 'R';
                        jLabel14.setText("Jugador 2");
                        PosicionAntigua = null;
                    } else
                    {
                        PosicionNueva = null;
                    }
                }
            } else if (turnoJugador == 'R')
            {
                PosicionActual = getBotonStr(ae.getSource());
                x = Integer.parseInt(Character.toString(PosicionActual.charAt(0)));
                y = Integer.parseInt(Character.toString(PosicionActual.charAt(1)));
                System.out.println(PosicionActual);
                if (Castillo[x][y].equals("B2") || Castillo[x][y].equals("M2"))
                {
                    PosicionAntigua = PosicionActual;
                } else if (PosicionAntigua != null)
                {
                    PosicionNueva = PosicionActual;
                    if (movimientosPosible(PosicionAntigua, PosicionNueva, 'R'))
                    {
                        int oldx = Integer.parseInt(Character.toString(PosicionAntigua.charAt(0)));
                        int oldy = Integer.parseInt(Character.toString(PosicionAntigua.charAt(1)));
                        Castillo[oldx][oldy] = "";
                        if (Castillo[x][y].equals("B1"))
                        {
                            GhostsGp1--;
                            JOptionPane.showMessageDialog(this, "Jugador 2 se ha comido\nun fantasma bueno del jugador 1");
                        } else if (Castillo[x][y].equals("M1"))
                        {
                            GhostsBp1--;
                            JOptionPane.showMessageDialog(this, "Jugador 2 se ha comido\nun fantasma malo del jugador 1");
                        }
                        Castillo[x][y] = "B2";
                        boton(PosicionAntigua).setIcon(null);
                        boton(PosicionNueva).setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/enemy-ghost.png")));
                        turnoJugador = 'L';
                        jLabel14.setText("Jugador 1");
                        PosicionAntigua = null;
                    } else
                    {
                        PosicionNueva = null;
                    }
                }
            }
            if (GhostsGp2 == 0)
            {
                JOptionPane.showMessageDialog(this, UsuarioGlob.getUsuario() + " triunfaste  sobre tu oponente porque\ncapturaste todos sus fantasmas buenos");
                UsuarioDAO.agregarPuntos(UsuarioGlob);
            } else if (GhostsBp1 == 0)
            {
                JOptionPane.showMessageDialog(this, UsuarioGlob.getUsuario() + " triunfaste  sobre tu oponente  porque\ncapturó todos sus fantasmas malos");
                UsuarioDAO.agregarPuntos(UsuarioGlob);
            } else if (GhostsGp1 == 0)
            {
                JOptionPane.showMessageDialog(this, UsuarioGlob.getUsuario() + "Fuiste vencido por tu oponenete  porque\ncapturó todos sus fantasmas buenos");
                
            } else if (GhostsBp2 == 0)
            {
                JOptionPane.showMessageDialog(this, UsuarioGlob.getUsuario() + "triunfaste  sobre tu oponente porque\ncapturaste todos sus fantasmas malos");

            } else if (Castillo[x][y].equals("B1") && PosicionNueva != null && (PosicionNueva.equals("00") || PosicionNueva.equals("05")))
            {
                JOptionPane.showMessageDialog(this, "Un fantansma bueno\nde " + UsuarioGlob.getUsuario() + " ha salido\npor el castillo");

            } else if (Castillo[x][y].equals("B2") && PosicionNueva != null && (PosicionNueva.equals("50") || PosicionNueva.equals("55")))
            {
                JOptionPane.showMessageDialog(this, "Un fantansma bueno\ndel Jugador 2 ha salido\npor el castillo");

            }
            jLabel13.setText("Fantasmas Buenos: " + GhostsGp1);
            jLabel10.setText("Fantasmas Buenos: " + GhostsGp2);
            jLabel15.setText("Fantasmas Malos: " + GhostsBp1);
            jLabel12.setText("Fantasmas Malos: " + GhostsBp2);
            victoria = (GhostsGp1 == 0 || GhostsBp1 == 0) ? true : (GhostsGp2 == 0 || GhostsBp2 == 0) ? true : (Castillo[x][y].equals("B1") && PosicionNueva != null && (PosicionNueva.equals("00")
                    || PosicionNueva.equals("05"))) ? true : (Castillo[x][y].equals("B2") && PosicionNueva != null && (PosicionNueva.equals("50") || PosicionNueva.equals("55"))) ? true : false;
            if (victoria == true)
            {
                this.setVisible(false);
                MenuPrincipal frmpaginaPrincipal = new MenuPrincipal(UsuarioGLob);
                frmpaginaPrincipal.setVisible(true);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        coor1 = new javax.swing.JButton();
        coor2 = new javax.swing.JButton();
        coor3 = new javax.swing.JButton();
        coor4 = new javax.swing.JButton();
        coor5 = new javax.swing.JButton();
        coor6 = new javax.swing.JButton();
        coor31 = new javax.swing.JButton();
        coor32 = new javax.swing.JButton();
        coor33 = new javax.swing.JButton();
        coor34 = new javax.swing.JButton();
        coor35 = new javax.swing.JButton();
        coor36 = new javax.swing.JButton();
        coor25 = new javax.swing.JButton();
        coor19 = new javax.swing.JButton();
        coor13 = new javax.swing.JButton();
        coor7 = new javax.swing.JButton();
        coor12 = new javax.swing.JButton();
        coor18 = new javax.swing.JButton();
        coor24 = new javax.swing.JButton();
        coor30 = new javax.swing.JButton();
        coor29 = new javax.swing.JButton();
        coor27 = new javax.swing.JButton();
        coor28 = new javax.swing.JButton();
        coor26 = new javax.swing.JButton();
        coor20 = new javax.swing.JButton();
        btnRendirse = new javax.swing.JButton();
        coor21 = new javax.swing.JButton();
        coor22 = new javax.swing.JButton();
        coor23 = new javax.swing.JButton();
        coor17 = new javax.swing.JButton();
        coor16 = new javax.swing.JButton();
        coor15 = new javax.swing.JButton();
        coor14 = new javax.swing.JButton();
        coor11 = new javax.swing.JButton();
        coor10 = new javax.swing.JButton();
        coor9 = new javax.swing.JButton();
        coor8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(470, 320));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        coor1.setContentAreaFilled(false);
        coor1.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 100, 100));

        coor2.setContentAreaFilled(false);
        coor2.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 90, 100));

        coor3.setContentAreaFilled(false);
        coor3.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 100, 100));

        coor4.setContentAreaFilled(false);
        coor4.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 100, 100));

        coor5.setContentAreaFilled(false);
        coor5.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 100, 100));

        coor6.setContentAreaFilled(false);
        coor6.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 90, 100));

        coor31.setContentAreaFilled(false);
        coor31.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor31, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 680, 100, 90));

        coor32.setContentAreaFilled(false);
        coor32.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor32, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 680, 90, 90));

        coor33.setContentAreaFilled(false);
        coor33.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor33, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 680, 100, 90));

        coor34.setContentAreaFilled(false);
        coor34.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor34, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 680, 100, 90));

        coor35.setContentAreaFilled(false);
        coor35.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor35, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 680, 100, 90));

        coor36.setContentAreaFilled(false);
        coor36.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor36, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 680, 90, 90));

        coor25.setContentAreaFilled(false);
        coor25.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor25, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 580, 100, 100));

        coor19.setContentAreaFilled(false);
        coor19.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 100, 100));

        coor13.setContentAreaFilled(false);
        coor13.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        coor13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coor13ActionPerformed(evt);
            }
        });
        jPanel1.add(coor13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 100, 90));

        coor7.setContentAreaFilled(false);
        coor7.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 100, 100));

        coor12.setContentAreaFilled(false);
        coor12.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor12, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 90, 100));

        coor18.setContentAreaFilled(false);
        coor18.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor18, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, 90, 90));

        coor24.setContentAreaFilled(false);
        coor24.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor24, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, 90, 100));

        coor30.setContentAreaFilled(false);
        coor30.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor30, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 580, 90, 100));

        coor29.setContentAreaFilled(false);
        coor29.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor29, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 580, 100, 100));

        coor27.setContentAreaFilled(false);
        coor27.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor27, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 580, 100, 100));

        coor28.setContentAreaFilled(false);
        coor28.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor28, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 580, 100, 100));

        coor26.setContentAreaFilled(false);
        coor26.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor26, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, 90, 100));

        coor20.setContentAreaFilled(false);
        coor20.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor20, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 90, 100));

        btnRendirse.setBackground(new java.awt.Color(0, 0, 0));
        btnRendirse.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        btnRendirse.setForeground(new java.awt.Color(255, 255, 255));
        btnRendirse.setText("RENDIRSE");
        btnRendirse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRendirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRendirseActionPerformed(evt);
            }
        });
        jPanel1.add(btnRendirse, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 780, 200, 30));

        coor21.setContentAreaFilled(false);
        coor21.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor21, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, 100, 100));

        coor22.setContentAreaFilled(false);
        coor22.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor22, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 480, 100, 100));

        coor23.setContentAreaFilled(false);
        coor23.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor23, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 480, 100, 100));

        coor17.setContentAreaFilled(false);
        coor17.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor17, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 100, 90));

        coor16.setContentAreaFilled(false);
        coor16.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 100, 90));

        coor15.setContentAreaFilled(false);
        coor15.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 100, 90));

        coor14.setContentAreaFilled(false);
        coor14.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 90, 90));

        coor11.setContentAreaFilled(false);
        coor11.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 100, 100));

        coor10.setContentAreaFilled(false);
        coor10.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 100, 100));

        coor9.setContentAreaFilled(false);
        coor9.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 100, 100));

        coor8.setContentAreaFilled(false);
        coor8.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jPanel1.add(coor8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 90, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/recursos/Recursos/TableroOrig_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 588, 580));

        jLabel9.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("FANTASMAS JUGADOR 2");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 500, -1, -1));

        jLabel10.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("FANTASMAS BUENOS");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 550, -1, -1));

        jLabel11.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("FANTASMAS JUGADOR 1");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, -1, -1));

        jLabel12.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("FANTASMAS MALOS");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 600, -1, -1));

        jLabel13.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("FANTASMAS BUENOS");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 290, -1, -1));

        jLabel14.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("JUGADOR");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, -1, -1));

        jLabel15.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("FANTASMAS MALOS");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, -1, -1));

        jLabel16.setFont(new java.awt.Font("Viner Hand ITC", 0, 48)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("GHOST");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 190, 70));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel5MouseDragged(evt);
            }
        });
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 750, 40));

        jLabel17.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("TURNO DEL JUGADOR");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1087, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel5MouseDragged

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel5MousePressed

    private void coor13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coor13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coor13ActionPerformed

    private void btnRendirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRendirseActionPerformed
        victoria = true;
        UsuarioDAO usdao = new UsuarioDAO();
        if (turnoJugador == 'L')
        {
            JOptionPane.showMessageDialog(this, Player2 + " se ha rendido\n" + UsuarioGlob.getUsuario() + " ha ganado!");
            UsuarioDAO.agregarReportes(UsuarioGlob, (Player2 + " se ha rendido\n" + UsuarioGlob.getUsuario() + " ha ganado!"));
            UsuarioDAO.agregarReportes(usdao.obtener(Player2), (Player2 + " se ha rendido\n" + UsuarioGlob.getUsuario() + " ha ganado!"));
            UsuarioDAO.agregarPuntos(UsuarioGlob);
        } else
        {
            JOptionPane.showMessageDialog(this, UsuarioGlob.getUsuario() + " se ha rendido\n" + Player2 + " ha ganado!");
            UsuarioDAO.agregarReportes(UsuarioGlob, (Player2 + " se ha rendido\n" + UsuarioGlob.getUsuario() + " ha ganado!"));
            UsuarioDAO.agregarReportes(usdao.obtener(Player2), (Player2 + " se ha rendido\n" + UsuarioGlob.getUsuario() + " ha ganado!"));
            UsuarioDAO.agregarPuntos(usdao.obtener(Player2));
        }
        this.setVisible(false);
        MenuPrincipal fpp = new MenuPrincipal(UsuarioGlob);
        fpp.show();
    }//GEN-LAST:event_btnRendirseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }

    public void RespuertaTablero() {
        coor1.addActionListener(this);
        coor2.addActionListener(this);
        coor3.addActionListener(this);
        coor4.addActionListener(this);
        coor5.addActionListener(this);
        coor6.addActionListener(this);
        coor7.addActionListener(this);
        coor8.addActionListener(this);
        coor9.addActionListener(this);
        coor10.addActionListener(this);
        coor11.addActionListener(this);
        coor12.addActionListener(this);
        coor13.addActionListener(this);
        coor14.addActionListener(this);
        coor15.addActionListener(this);
        coor16.addActionListener(this);
        coor17.addActionListener(this);
        coor18.addActionListener(this);
        coor19.addActionListener(this);
        coor20.addActionListener(this);
        coor21.addActionListener(this);
        coor22.addActionListener(this);
        coor23.addActionListener(this);
        coor24.addActionListener(this);
        coor25.addActionListener(this);
        coor26.addActionListener(this);
        coor27.addActionListener(this);
        coor28.addActionListener(this);
        coor29.addActionListener(this);
        coor30.addActionListener(this);
        coor31.addActionListener(this);
        coor32.addActionListener(this);
        coor33.addActionListener(this);
        coor34.addActionListener(this);
        coor35.addActionListener(this);
        coor36.addActionListener(this);
    }

    public String getBotonStr(Object boton) {
        if (boton == coor1)
        {
            return "00";
        } else if (boton == coor2)
        {
            return "01";
        } else if (boton == coor3)
        {
            return "02";
        } else if (boton == coor4)
        {
            return "03";
        } else if (boton == coor5)
        {
            return "04";
        } else if (boton == coor6)
        {
            return "05";
        } else if (boton == coor7)
        {
            return "10";
        } else if (boton == coor8)
        {
            return "11";
        } else if (boton == coor9)
        {
            return "12";
        } else if (boton == coor10)
        {
            return "13";
        } else if (boton == coor11)
        {
            return "14";
        } else if (boton == coor12)
        {
            return "15";
        } else if (boton == coor13)
        {
            return "20";
        } else if (boton == coor14)
        {
            return "21";
        } else if (boton == coor15)
        {
            return "22";
        } else if (boton == coor16)
        {
            return "23";
        } else if (boton == coor17)
        {
            return "24";
        } else if (boton == coor18)
        {
            return "25";
        } else if (boton == coor19)
        {
            return "30";
        } else if (boton == coor20)
        {
            return "31";
        } else if (boton == coor21)
        {
            return "32";
        } else if (boton == coor22)
        {
            return "33";
        } else if (boton == coor23)
        {
            return "34";
        } else if (boton == coor24)
        {
            return "35";
        } else if (boton == coor25)
        {
            return "40";
        } else if (boton == coor26)
        {
            return "41";
        } else if (boton == coor27)
        {
            return "42";
        } else if (boton == coor28)
        {
            return "43";
        } else if (boton == coor29)
        {
            return "44";
        } else if (boton == coor30)
        {
            return "45";
        } else if (boton == coor31)
        {
            return "50";
        } else if (boton == coor32)
        {
            return "51";
        } else if (boton == coor33)
        {
            return "52";
        } else if (boton == coor34)
        {
            return "53";
        } else if (boton == coor35)
        {
            return "54";
        } else if (boton == coor36)
        {
            return "55";
        }
        return "";
    }

    public JButton boton(String posicion) {
        switch (posicion)
        {
            case "00":
                return coor1;
            case "01":
                return coor2;
            case "02":
                return coor3;
            case "03":
                return coor4;
            case "04":
                return coor5;
            case "05":
                return coor6;
            case "10":
                return coor7;
            case "11":
                return coor8;
            case "12":
                return coor9;
            case "13":
                return coor10;
            case "14":
                return coor11;
            case "15":
                return coor12;
            case "20":
                return coor13;
            case "21":
                return coor14;
            case "22":
                return coor15;
            case "23":
                return coor16;
            case "24":
                return coor17;
            case "25":
                return coor18;
            case "30":
                return coor19;
            case "31":
                return coor20;
            case "32":
                return coor21;
            case "33":
                return coor22;
            case "34":
                return coor23;
            case "35":
                return coor24;
            case "40":
                return coor25;
            case "41":
                return coor26;
            case "42":
                return coor27;
            case "43":
                return coor28;
            case "44":
                return coor29;
            case "45":
                return coor30;
            case "50":
                return coor31;
            case "51":
                return coor32;
            case "52":
                return coor33;
            case "53":
                return coor34;
            case "54":
                return coor35;
            case "55":
                return coor36;
            default:
                break;
        }
        return null;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRendirse;
    private javax.swing.JButton coor1;
    private javax.swing.JButton coor10;
    private javax.swing.JButton coor11;
    private javax.swing.JButton coor12;
    private javax.swing.JButton coor13;
    private javax.swing.JButton coor14;
    private javax.swing.JButton coor15;
    private javax.swing.JButton coor16;
    private javax.swing.JButton coor17;
    private javax.swing.JButton coor18;
    private javax.swing.JButton coor19;
    private javax.swing.JButton coor2;
    private javax.swing.JButton coor20;
    private javax.swing.JButton coor21;
    private javax.swing.JButton coor22;
    private javax.swing.JButton coor23;
    private javax.swing.JButton coor24;
    private javax.swing.JButton coor25;
    private javax.swing.JButton coor26;
    private javax.swing.JButton coor27;
    private javax.swing.JButton coor28;
    private javax.swing.JButton coor29;
    private javax.swing.JButton coor3;
    private javax.swing.JButton coor30;
    private javax.swing.JButton coor31;
    private javax.swing.JButton coor32;
    private javax.swing.JButton coor33;
    private javax.swing.JButton coor34;
    private javax.swing.JButton coor35;
    private javax.swing.JButton coor36;
    private javax.swing.JButton coor4;
    private javax.swing.JButton coor5;
    private javax.swing.JButton coor6;
    private javax.swing.JButton coor7;
    private javax.swing.JButton coor8;
    private javax.swing.JButton coor9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables

}
