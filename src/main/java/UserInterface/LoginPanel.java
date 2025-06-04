
package UserInterface;

import MyExceptions.EmptyFieldException;
import MyExceptions.InvalidEmailFormatException;
import MyExceptions.PasswordDoesntMatchEmailException;
import MyExceptions.PersonNotFoundException;
import controlOperations.EmailValidator;
import controlOperations.PersonOperations;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import models.Person;
import models.Role;

/**
 *
 * @author Zahera
 */
public class LoginPanel extends javax.swing.JPanel {


    MainFrameForm mainFrame;

    public LoginPanel(MainFrameForm mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        btn_login = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Georgia", 2, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setText("Login Page______________________");

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 51));
        jLabel2.setText(">>>Email");

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 51));
        jLabel3.setText(">Password");

        txt_email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txt_password.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btn_login.setBackground(new java.awt.Color(51, 102, 0));
        btn_login.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("LOGIN");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Help: already registered users\n\npassenger1\t= ahmet@example.com  pass= 12345\n\npassenger2\t= mehmet@example.com  pass= 12345\n\nadmin1             = rasha@example.com       pass= 12345");
        jScrollPane1.setViewportView(jTextArea1);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 51));
        jLabel5.setText("Haven't you registered yet? ");

        jButton1.setBackground(new java.awt.Color(0, 102, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("go to register page");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addGap(53, 53, 53)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                                .addComponent(txt_password, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btn_login, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(btn_login)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jButton1))
                .addContainerGap(110, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
        String email = txt_email.getText().trim();
        String password = txt_password.getText().trim();
        ArrayList<JTextField> textFieldsList = new ArrayList<>();
        textFieldsList.add(txt_email);
        textFieldsList.add(txt_password);
        try {
            for (JTextField jTextField : textFieldsList) {
                if (jTextField.getText().trim().isEmpty()) {
                    throw new EmptyFieldException(jTextField.getName());
                }
            }
        } catch (EmptyFieldException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }
        try {
            if (!EmailValidator.isValid(email)) {
                throw new InvalidEmailFormatException(email);
            }

        } catch (InvalidEmailFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }
        Person p;
        try {
            p = PersonOperations.getPersonByEmail(email);
        } catch (PersonNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "\n register before login");
            return;
        }
        try {
            boolean boolPass = PersonOperations.doesPasswordMatchEmail(p, password);
            if (!boolPass) {
                throw new PasswordDoesntMatchEmailException(email, password);
            }
            String panelname;
            if (p.getRole() == Role.ADMIN) {
                panelname = "AdminPanel";

                AdminPanel ap = new AdminPanel(mainFrame, p);
                mainFrame.mainPanel.add(ap, "AdminPanel");

            } else {
                panelname = "ReservationPanel";
                ReservationPanel rep = new ReservationPanel(mainFrame, p);
                mainFrame.mainPanel.add(rep, "ReservationPanel");
            }
            JOptionPane.showMessageDialog(null, "you login successfully, you will be directed to " + panelname);
            mainFrame.navigateToPanel(panelname);

        } catch (PersonNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "\n register before login");
            return;
        } catch (PasswordDoesntMatchEmailException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }


    }//GEN-LAST:event_btn_loginActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        mainFrame.navigateToPanel("RegisterPanel");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_password;
    // End of variables declaration//GEN-END:variables
}
