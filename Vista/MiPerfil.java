
package Vista;

import java.awt.Color;
import java.util.HashSet;
import javax.swing.table.DefaultTableModel;
import LogicaUsuario.UsuarioLogic;
import Usuario.Usuario;


public class MiPerfil extends javax.swing.JFrame {
 
    int xMouse , yMouse;
    private MenuPrincipal aThis;
    
    private DefaultTableModel modelo;
    int contador = 0;
     Usuario UsuarioGLob ;
    /**
     * Creates new form MiPerfil
     * @param aThis
     */
    public MiPerfil(Usuario usu, MenuPrincipal aThis, boolean par) {
        initComponents();
       // Interfaz();
        //CargaDatos();
             UsuarioGLob=usu;

        this.setLocationRelativeTo(null);
        this.aThis = aThis;
        jOptionPane1.setVisible(false);
        
   
       
    }
    /*
    public void Interfaz(){
        String datos [][] = {};
        String columna [] = {"NOMBRE", "APELLIDO", "CORREO", "USUARIO", "CONTRASEÑA"};
        modelo = new DefaultTableModel(datos, columna);
        jTbRegistros.setModel(modelo);
        
    }

    public void CargaDatos(){
        Usuario a;
        for (int i = 0; i < FRMRegistrarUsuarios.contenedor.size(); i++)
        {
            a = (Usuario)FRMRegistrarUsuarios.contenedor.get(i);
            modelo.insertRow(contador, new Object[]{});
            modelo.setValueAt(a.getNombres(), contador, 0);
            modelo.setValueAt(a.getApellidos(), contador, 1);
            modelo.setValueAt(a.getcorreos(), contador, 2);
            modelo.setValueAt(a.getUsuario(), contador, 3);
            modelo.setValueAt(a.getContraseña(), contador, 4);
            
            
        }
        
    }
    */
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnRegresar1 = new javax.swing.JButton();
        btnEliminarCuenta = new javax.swing.JButton();
        btnCambiarContraseña = new javax.swing.JButton();
        btnVerMisDatos = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        PerfilUser = new javax.swing.JTextField();
        PerfilPass = new javax.swing.JTextField();
        PerfilNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jOptionPane1 = new javax.swing.JOptionPane();

        jLabel11.setFont(new java.awt.Font("Retro", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 255));
        jLabel11.setText("Usuario");

        jLabel13.setFont(new java.awt.Font("Retro", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 255));
        jLabel13.setText("Password");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 40));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar1.setBackground(new java.awt.Color(51, 51, 51));
        btnRegresar1.setFont(new java.awt.Font("Viner Hand ITC", 0, 36)); // NOI18N
        btnRegresar1.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar1.setText("Regresar");
        btnRegresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 280, 70));

        btnEliminarCuenta.setBackground(new java.awt.Color(51, 51, 51));
        btnEliminarCuenta.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        btnEliminarCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarCuenta.setText("ELIMINAR CUENTA");
        btnEliminarCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCuentaActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 280, 70));

        btnCambiarContraseña.setBackground(new java.awt.Color(51, 51, 51));
        btnCambiarContraseña.setFont(new java.awt.Font("Viner Hand ITC", 0, 20)); // NOI18N
        btnCambiarContraseña.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiarContraseña.setText("CHANGE PASSWORD");
        btnCambiarContraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCambiarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarContraseñaActionPerformed(evt);
            }
        });
        jPanel3.add(btnCambiarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 280, 70));

        btnVerMisDatos.setBackground(new java.awt.Color(51, 51, 51));
        btnVerMisDatos.setFont(new java.awt.Font("Viner Hand ITC", 0, 20)); // NOI18N
        btnVerMisDatos.setForeground(new java.awt.Color(255, 255, 255));
        btnVerMisDatos.setText("VER MIS DATOS");
        btnVerMisDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerMisDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMisDatosActionPerformed(evt);
            }
        });
        jPanel3.add(btnVerMisDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 280, 70));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 280, 470));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Viner Hand ITC", 2, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mi Perfil");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 220, 80));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 480, 80));

        jTabbedPane1.setBackground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 393, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel9);

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PerfilUser.setBackground(new java.awt.Color(0, 0, 0));
        PerfilUser.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        PerfilUser.setForeground(new java.awt.Color(255, 0, 255));
        PerfilUser.setEnabled(false);
        PerfilUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerfilUserActionPerformed(evt);
            }
        });
        jPanel10.add(PerfilUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 218, -1));

        PerfilPass.setBackground(new java.awt.Color(0, 0, 0));
        PerfilPass.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        PerfilPass.setForeground(new java.awt.Color(255, 0, 255));
        PerfilPass.setEnabled(false);
        jPanel10.add(PerfilPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 220, -1));

        PerfilNombre.setBackground(new java.awt.Color(0, 0, 0));
        PerfilNombre.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        PerfilNombre.setForeground(new java.awt.Color(255, 0, 255));
        PerfilNombre.setEnabled(false);
        jPanel10.add(PerfilNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 218, -1));

        jLabel3.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Nombre");
        jPanel10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel10.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Usuario");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel12.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Password");
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jTabbedPane1.addTab("tab3", jPanel10);

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPasswordField1.setBackground(new java.awt.Color(204, 204, 204));
        jPasswordField1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel5.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 183, -1));

        jLabel6.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Password");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel7.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Confirm Password");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        jPasswordField2.setBackground(new java.awt.Color(204, 204, 204));
        jPasswordField2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel5.add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 183, -1));

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CHANGE PASSWORD");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 169, -1, -1));
        jPanel5.add(jOptionPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 261, -1, -1));

        jTabbedPane1.addTab("tab3", jPanel5);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 400, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerMisDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMisDatosActionPerformed
        jTabbedPane1.setSelectedIndex(1);
            PerfilUser.setText(MenuPrincipal.UsuarioGLob.getUsuario());
             PerfilPass.setText(MenuPrincipal.UsuarioGLob.getContraseña());
             PerfilNombre.setText(MenuPrincipal.UsuarioGLob.getNombres());
    }//GEN-LAST:event_btnVerMisDatosActionPerformed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void PerfilUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PerfilUserActionPerformed

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
         this.setVisible(false);
        MenuPrincipal frmpaginaPrincipal = new  MenuPrincipal (UsuarioGLob);
        frmpaginaPrincipal.setVisible(true);
    }//GEN-LAST:event_btnRegresar1ActionPerformed

    private void btnEliminarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCuentaActionPerformed
        // TODO add your handling code here:
        jOptionPane1.showMessageDialog(this,"Su cuenta se ha eliminado de manera exitosa");
         UsuarioLogic.eliminar(MenuPrincipal.UsuarioGLob.getUsuario());
         this.dispose();
         Loging L=new Loging();
         L.setVisible(true);        
    }//GEN-LAST:event_btnEliminarCuentaActionPerformed

    private void btnCambiarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarContraseñaActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnCambiarContraseñaActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String Nueva;
          if(jPasswordField1.getText().equals(jPasswordField2.getText()) && jPasswordField1!=null && jPasswordField2!=null){
            Nueva=jPasswordField1.getText();
          MenuPrincipal.UsuarioGLob.setContraseña(Nueva);
          jOptionPane1.showMessageDialog(this,"Se ha cambiado la contraseña de manera exitosa.");
          jPasswordField1.setText(null);
          jPasswordField2.setText(null);
          
       }else{
             jOptionPane1.showMessageDialog(this,"Porfavor llene todos los espacios de manera Correcta.");
        }  
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(MiPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MiPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MiPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MiPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiPerfil(null,null, true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PerfilNombre;
    private javax.swing.JTextField PerfilPass;
    private javax.swing.JTextField PerfilUser;
    private javax.swing.JButton btnCambiarContraseña;
    private javax.swing.JButton btnEliminarCuenta;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JButton btnVerMisDatos;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
