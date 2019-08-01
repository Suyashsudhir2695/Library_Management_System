/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system;
import java.sql.*;
import javax.swing.*;



/**
 *
 * @author Change
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
    }
    
    public void showMessage(String params)
    {
        JOptionPane.showMessageDialog(this, params);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mUsernameF = new javax.swing.JTextField();
        mPasswordF = new javax.swing.JPasswordField();
        mBtnSignIn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log In");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(595, 450));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Sign In");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setText("Password");

        mUsernameF.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N

        mPasswordF.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N

        mBtnSignIn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        mBtnSignIn.setText("Sign In");
        mBtnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mBtnSignInActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel4.setText("Trouble Signing In?");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(mUsernameF, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                .addComponent(mPasswordF))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(mBtnSignIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(mUsernameF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(mPasswordF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(mBtnSignIn)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mBtnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mBtnSignInActionPerformed
String mUsername,mPassword;
//int found = 0;


mUsername = mUsernameF.getText();
mPassword = mPasswordF.getText();
if(mUsername.isEmpty())
{
    showMessage("Enter a Username");
}

else if(mPassword.isEmpty())
{
    showMessage("Enter Your Password");
}

else
{

try{
    Class.forName("java.sql.DriverManager");
    Connection mConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project",
"root", "mysql");
    Statement mStatement = (Statement) mConn.createStatement();
    AdminAccountForm mAccountForm = new AdminAccountForm();
    
    String mQuery = "Select * from admin where username = '"+mUsername+"' and password = '"+mPassword+"' ;";
    ResultSet mRes = mStatement.executeQuery(mQuery);
    
    if(mRes.next()){
        String user = mRes.getString("username");
         String pass = mRes.getString("password");
         String type = mRes.getString("type");
        
        //found++;
         
            
    if(mUsername.equalsIgnoreCase(user) && mPassword.equals(pass)){
        //JOptionPane.showMessageDialog(this, "Check");
    
    
            JOptionPane.showMessageDialog(this, "Welcome "+user);
            if(type.equalsIgnoreCase("administrator")){
           
            
            mAccountForm.setVisible(true);
            
            this.setVisible(false);
            }

            else if(type.equalsIgnoreCase("standard")){
           
               
              StudentForm mStudentForm = new StudentForm();
              mStudentForm.setVisible(true);
              this.dispose();
              
           }
           
        
          
    }
    else{
                JOptionPane.showMessageDialog(LoginForm.this, "Check Your Credentials");
                mUsernameF.setText("");
                mPasswordF.setText("");
        
    }
   
    
    
    
    }
    else{
                JOptionPane.showMessageDialog(LoginForm.this, "Check Your Credentials");
                mUsernameF.setText("");
                mPasswordF.setText("");
        
    }
         
        
         
        
           
      
            
        
     
    

}
catch(Exception e){
    String msg = e.getMessage();
    JOptionPane.showMessageDialog(this, msg);
}
} 
    
    

// TODO add your handling code here:
    }//GEN-LAST:event_mBtnSignInActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
ForgotPassword mForgotPassword = new ForgotPassword();
mForgotPassword.setVisible(true);
this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton mBtnSignIn;
    private javax.swing.JPasswordField mPasswordF;
    private javax.swing.JTextField mUsernameF;
    // End of variables declaration//GEN-END:variables
}
