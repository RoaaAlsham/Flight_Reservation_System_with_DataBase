
package UserInterface;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPanel;
import models.MyEntityController;

/**
 *
 * @author Zahera
 */
public class MainFrameForm extends javax.swing.JFrame {
    
    CardLayout cardLayout;
    JPanel mainPanel;
    /**
     * Creates new form Register
     */
    public MainFrameForm() {
        initComponents();
         
        cardLayout= new CardLayout();
        mainPanel= new JPanel(cardLayout);
        RegisterPanel rp= new RegisterPanel(this);mainPanel.add(rp,"RegisterPanel");
        LoginPanel lp= new LoginPanel(this);mainPanel.add(lp,"LoginPanel");

        setContentPane(mainPanel);
       
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setVisible(true);
        closeEMFonProgramExit();
        
    }
    ///capacity 0
    ///date in the future
    private void closeEMFonProgramExit(){
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MyEntityController.endEntityFactoryUsage();
                System.out.println("Entity MANAGER Factory is closed :)");
            }
            
        });
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrameForm().setVisible(true);
            }
        });
    }
    public void navigateToPanel(String panelName){
        cardLayout.show(mainPanel,panelName);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
