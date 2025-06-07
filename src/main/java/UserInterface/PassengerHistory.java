package UserInterface;

import controlOperations.FlightOperations;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Flight;
import models.MyEntityController;
import models.Person;
import models.Reservation;

/**
 *
 * @author Zahera
 */
public class PassengerHistory extends javax.swing.JPanel {
// i have to update tables info every time i navigate between pages
    DefaultTableModel dtm;
    Person p;
    MainFrameForm mainFrame;
    ReservationPanel rep;
    public PassengerHistory(MainFrameForm mainFrame, ReservationPanel rep,Person p) {

        initComponents();
        jLabel2.setText("id: " + p.getIdperson() + " , email: " + p.getEmail() + " password: " + p.getPassword());
        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new Object[]{"id", "origin", "destination",
            "departure", "seat Id","price", "reservation date"});
        jTable1.setModel(dtm);

        this.mainFrame = mainFrame;
        this.p = p;
        this.rep=rep;
        List<Reservation> personReseravtions = FlightOperations.getReservationsForPerson(p);
        showReservaionsOnTable(personReseravtions);

    }
    SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy HH:mm");
    private void showReservaionsOnTable(List<Reservation> reservations) {
        EntityManager em = MyEntityController.getEntityManager();
        for (Reservation r : reservations) {
            Flight f = em.find(Flight.class, r.getFlightId().getIdflight());
            //Exception in thread "AWT-EventQueue-0" java.lang.IllegalArgumentException:
            //You have provided an instance of an incorrect PK class for this find operation.
            //Class expected : class java.lang.Integer, Class received : class models.Flight.
            //this: r.getFlightId() returns a flight, not a flight id 
            dtm.addRow(new Object[]{r.getIdreservation(),
                f.getOriginAirport().getAirportName(),
                f.getDestinationAirport().getAirportName(),
                sdf.format(f.getDepartureDateTime()),
                r.getSeatId().getIdseat(),r.getFlightId().getSeatPrice(),
                sdf.format(r.getReservationDate())});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lbl_fee = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 255));

        jLabel1.setFont(new java.awt.Font("Georgia", 2, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 51));
        jLabel1.setText("My Reservation History_______________");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setText("jLabel2");

        jTable1.setBackground(new java.awt.Color(255, 204, 255));
        jTable1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(102, 0, 102));
        jButton1.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("cancel selected reservation");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 0, 102));
        jButton3.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("go back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Georgia", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 51));
        jLabel3.setText("<<<<<<<<<<<<<<<<<<<<<<<<<<Reservations>>>>>>>>>>>>>>>>>>>>>>>>>");

        jButton2.setBackground(new java.awt.Color(102, 0, 102));
        jButton2.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("calculate total fee");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lbl_fee.setForeground(new java.awt.Color(51, 0, 51));
        lbl_fee.setText("..................................................");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(419, 419, 419)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbl_fee))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(lbl_fee))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(82, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void refreshReservationTable(){
        dtm.setRowCount(0);
        
        List<Reservation> personReseravtions = FlightOperations.getReservationsForPerson(p);
        showReservaionsOnTable(personReseravtions);

    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        /*i faced a problem that sometimes a reservation is deleted in my gui but not in mysql, 
        //the solution eas by adding r to personReservationCollection and FlightReservationCollection and remove it in remove method
        //I understand that when i removed a reservation by em.remove(r) , foreign key relations may still
        //so it not removed in mysql
        //the question is why dont i get any type of exception from mysql when i use em.remove(r) and is my understanding correct? 
        person.getReservationCollection().remove(r);
        flight.getReservationCollection().remove(r);
        You make sure both sides of the bidirectional relationship are updated in memory.
        Now, JPA recognizes that r is orphaned and can be removed properly.
        */
        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(mainFrame, "please select a flight to continue");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(mainFrame, "Are sure you want to cancel the selected reservation permenanatly?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.NO_OPTION) {
            return;
        }
        int reservationId = Integer.parseInt(dtm.getValueAt(jTable1.getSelectedRow(), 0).toString());
        EntityManager em = MyEntityController.getEntityManager();
        try {

            Reservation r = em.find(Reservation.class, reservationId);
            if (r == null) {
                throw new EntityNotFoundException();

            }
            FlightOperations.removeReservation(em, r);
        } catch (EntityNotFoundException e) {
            JOptionPane.showMessageDialog(mainFrame, "NoSuchFieldException");
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return;
        }catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(mainFrame, "IllegalArgumentException");
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return;
        } finally {
            em.close();
        }
        refreshReservationTable();
        rep.refreshFlightsTable();
        JOptionPane.showMessageDialog(mainFrame, "the Reservation is CANCELED ");
/*when i added a new reservation a add it to personResrvationCollection and FligTResevarionCollection , but somewhere (personcollection)
        i didnt , so in remove process these reservations will  not found and will throw an exception, 
        
        another question
        when i run the program will flightReservationCollection be filled automatically by jpa since it oneToMany
        relation or will be empty if i not fill it in java manually
        
        then do i need to add and remove from them in reservation operations
        
        if these collection are not filled by jpa , then when the user want to remoce a reservation will not
        be found flightReseravtionCollection even if i had added it in a previon session.

        */

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         mainFrame.navigateToPanel("ReservationPanel");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        float total=0;
        for (int i = 0; i < dtm.getRowCount(); i++) {
            total+=Float.parseFloat(dtm.getValueAt(i, 5).toString());
        }
        
        lbl_fee.setText(String.valueOf(total));
    }//GEN-LAST:event_jButton2ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_fee;
    // End of variables declaration//GEN-END:variables
}
