package UserInterface;

import controlOperations.FlightOperations;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Airport;
import models.Flight;
import models.MyEntityController;
import models.Person;

/**
 *
 * @author Zahera
 */
public class AdminPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminPanel
     */
    MainFrameForm mainFrame;
    DefaultTableModel dtm;
    DefaultComboBoxModel comboModelorigin;
    DefaultComboBoxModel comboModeldestination;
    AdminReports ar;

    public AdminPanel(MainFrameForm mainFrame, Person p) {
        initComponents();
        this.mainFrame = mainFrame;
        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new Object[]{
            "ID",
            "Origin",
            "Destination",
            "Capacity",
            "Departure",//YYYY-MM-DD hh:mm
            "Price",
            "Available Seats"
        });
        jTable1.setModel(dtm);
        jLabel2.setText("id: " + p.getIdperson() + " , email: " + p.getEmail() + " password: " + p.getPassword());
        List<Flight> flights = FlightOperations.getAllFlights();
        ShowFlightsInTable(flights);

        comboModelorigin = new DefaultComboBoxModel();
        comboModeldestination = new DefaultComboBoxModel();
        comboModelorigin.addAll(FlightOperations.get_All_Airtports());
        comboModeldestination.addAll(FlightOperations.get_All_Airtports());
        cb_originAirports.setModel(comboModelorigin);
        cb_destiantionAirport.setModel(comboModeldestination);
        
        ar=new AdminReports(mainFrame,p,this);
        mainFrame.mainPanel.add(ar,"AdminReport");
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private void ShowFlightsInTable(List<Flight> flights) {
        for (Flight flight : flights) {
            dtm.addRow(new Object[]{
                flight.getIdflight(),
                flight.getOriginAirport(),
                flight.getDestinationAirport(),
                flight.getFlightCapacity(),
                sdf.format(flight.getDepartureDateTime()),
                flight.getSeatPrice(),
                flight.calculateAvailableSeats()
            });

        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txt_id = new javax.swing.JTextField();
        txt_capacity = new javax.swing.JTextField();
        txt_departureDate = new javax.swing.JTextField();
        txt_seatPrice = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_airportName = new javax.swing.JTextField();
        txt_city = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_addAirport = new javax.swing.JButton();
        cb_originAirports = new javax.swing.JComboBox<>();
        cb_destiantionAirport = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btn_deleteAirport = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        txt_airportId = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Georgia", 2, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 0));
        jLabel1.setText("Admin Page_____________________");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 0));
        jLabel2.setText("jLabel2");

        jTable1.setBackground(new java.awt.Color(255, 255, 204));
        jTable1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "origin", "destination", "capacity", "departure date", "seat price ", "availble seats"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        txt_id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_capacity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_departureDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_seatPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton1.setBackground(new java.awt.Color(51, 51, 0));
        jButton1.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add a flight");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 0));
        jButton2.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Remove Selected Flight ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 0));
        jButton3.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Reports");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 0));
        jLabel3.setText("<<<airport>>>");

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 0));
        jLabel4.setText("airport name");

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 0));
        jLabel5.setText("city");

        btn_addAirport.setBackground(new java.awt.Color(51, 51, 0));
        btn_addAirport.setForeground(new java.awt.Color(255, 255, 255));
        btn_addAirport.setText("Add ");
        btn_addAirport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addAirportActionPerformed(evt);
            }
        });

        cb_originAirports.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cb_originAirports.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_originAirports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_originAirportsActionPerformed(evt);
            }
        });

        cb_destiantionAirport.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cb_destiantionAirport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setForeground(new java.awt.Color(51, 51, 0));
        jLabel7.setText("Flight id");

        jLabel8.setForeground(new java.awt.Color(51, 51, 0));
        jLabel8.setText("capacity");

        jLabel9.setForeground(new java.awt.Color(51, 51, 0));
        jLabel9.setText("departure date");

        jLabel10.setForeground(new java.awt.Color(51, 51, 0));
        jLabel10.setText("seat price");

        jLabel11.setForeground(new java.awt.Color(51, 51, 0));
        jLabel11.setText("destination");

        jLabel12.setForeground(new java.awt.Color(51, 51, 0));
        jLabel12.setText("origin");

        btn_deleteAirport.setBackground(new java.awt.Color(102, 102, 0));
        btn_deleteAirport.setForeground(new java.awt.Color(255, 255, 255));
        btn_deleteAirport.setText("Delete");
        btn_deleteAirport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteAirportActionPerformed(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(51, 51, 0));
        jLabel13.setText("hint: set existing id to update a flight, if id not found a new flight will be added");

        jButton4.setBackground(new java.awt.Color(51, 51, 0));
        jButton4.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("go to previous page");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 0));
        jLabel14.setText("id");

        jLabel15.setFont(new java.awt.Font("Georgia", 2, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 0));
        jLabel15.setText("<<<<<<<<<<<<<<<<<<<<<<<<<<Flights>>>>>>>>>>>>>>>>>>>>>>>>>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addComponent(cb_originAirports, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_departureDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txt_seatPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(320, 320, 320)
                                                .addComponent(jLabel11)
                                                .addGap(18, 18, 18)
                                                .addComponent(cb_destiantionAirport, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(12, 12, 12)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_capacity, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(btn_deleteAirport, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_addAirport, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addGap(29, 29, 29))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(txt_airportId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                        .addComponent(txt_airportName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_city, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addContainerGap(108, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_airportName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_addAirport)
                    .addComponent(btn_deleteAirport)
                    .addComponent(txt_airportId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_destiantionAirport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_originAirports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_capacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_seatPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txt_departureDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(8, 8, 8)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int Id = Integer.parseInt(dtm.getValueAt(jTable1.getSelectedRow(), 0).toString());
        int capacity = Integer.parseInt(dtm.getValueAt(jTable1.getSelectedRow(), 3).toString());
        String date = dtm.getValueAt(jTable1.getSelectedRow(), 4).toString();
        float seatPrice = Float.parseFloat(dtm.getValueAt(jTable1.getSelectedRow(), 5).toString());

        txt_id.setText(String.valueOf(Id));
        txt_departureDate.setText(date);
        txt_capacity.setText(String.valueOf(capacity));
        txt_seatPrice.setText(String.valueOf(seatPrice));

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //if flight exist, check the capacity that cannot be decreased
        EntityManager em = MyEntityController.getEntityManager();
        EntityTransaction tr = em.getTransaction();
        if (cb_originAirports.getSelectedItem() == null || (cb_destiantionAirport.getSelectedItem() == null)) {
            JOptionPane.showMessageDialog(mainFrame, "an airport has to be selected");
            return;
        }
        try {
            if (cb_originAirports.getSelectedItem().equals(cb_destiantionAirport.getSelectedItem())) {
                throw new IllegalArgumentException();
            }
            int id = Integer.parseInt(txt_id.getText());
            Date date = sdf.parse(txt_departureDate.getText());
            if(date.before(new Date())){
                 JOptionPane.showMessageDialog(mainFrame, "Depaurture date cannot be in the past,\n please assign it to a fututre date");
                 return;
            }
            int capacity = Integer.parseInt(txt_capacity.getText());
            if(capacity<1){
                JOptionPane.showMessageDialog(mainFrame, "Capacity cannot be less than one");
                return;
            }
            float seatPrice = Float.parseFloat(txt_seatPrice.getText());
            Airport origin = (Airport) cb_originAirports.getSelectedItem();
            Airport destination = (Airport) cb_destiantionAirport.getSelectedItem();
            tr.begin();
            Flight f = em.find(Flight.class, id);
            if (f == null) {
                f = FlightOperations.createFlight(em, origin, destination,
                        capacity, date, seatPrice);

                JOptionPane.showMessageDialog(mainFrame, "a new flight has been ADDED");
            } else {
                if (capacity < f.getFlightCapacity()) {
                    JOptionPane.showMessageDialog(mainFrame, "Flight capacity cannot be decreased for safety");
                    return;
                }
              
                f = FlightOperations.updateFlight(em, f, origin, destination, capacity, date, seatPrice);

                //for() delete the unupdated raw
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    if (id == Integer.parseInt(dtm.getValueAt(i, 0).toString())) {
                        dtm.removeRow(i);
                        break;
                    }
                }
                JOptionPane.showMessageDialog(mainFrame, "the flight has been UPDATED");

            }
            tr.commit();
            dtm.addRow(new Object[]{
                f.getIdflight(),
                f.getOriginAirport(),
                f.getDestinationAirport(),
                f.getFlightCapacity(),
                sdf.format(f.getDepartureDateTime()),
                f.getSeatPrice(),
                f.calculateAvailableSeats()});

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
            return;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainFrame, "invalid format for numbers,\n check the number does not include any spaces or special characters");
            return;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(mainFrame, "a flight cannot have the same origin and destination");
            return;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
            if (tr.isActive()) {
                tr.rollback();
            }
            return;
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
            return;
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void cb_originAirportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_originAirportsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_originAirportsActionPerformed

    private void btn_addAirportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addAirportActionPerformed

        String airportName = txt_airportName.getText().trim();
        String city = txt_city.getText().trim();
        EntityManager em = MyEntityController.getEntityManager();
        EntityTransaction tr = em.getTransaction();
        if (airportName.isEmpty() || city.isEmpty()) {
            throw new IllegalArgumentException();
        }

        try {
            tr.begin();
            int id = Integer.parseInt(txt_airportId.getText());
            //check if airport exists
            Airport a = em.find(Airport.class, id);
            if (a == null) {
                a = FlightOperations.addAiport(em, airportName, city);
                JOptionPane.showMessageDialog(mainFrame, "the new airport is ADDED");
            } else {
                comboModeldestination.removeElement(a);
                comboModelorigin.removeElement(a);
                FlightOperations.updateAirport(em, a, airportName, city);
                //update table
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    Airport a1 = (Airport) dtm.getValueAt(i, 1);
                    Airport a2 = (Airport) dtm.getValueAt(i, 2);
                    int previousId = a.getIdAirport();
                    if (previousId == a1.getIdAirport() || previousId == a2.getIdAirport()) {
                        Flight f = em.find(Flight.class, Integer.valueOf(dtm.getValueAt(i, 0).toString()));
                        dtm.setValueAt(f.getOriginAirport(), i, 1);
                        dtm.setValueAt(f.getDestinationAirport(), i, 2);
                    }
                }
                JOptionPane.showMessageDialog(mainFrame, "the airport is UPDATED");

            }
            tr.commit();
            comboModeldestination.addElement(a);
            comboModelorigin.addElement(a);
        } catch (NumberFormatException e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            JOptionPane.showMessageDialog(mainFrame, "invalid format for numbers,\n check the number does not include any spaces or special characters");
            return;
        } catch (IllegalArgumentException e) {
            if (tr.isActive()) {
                tr.rollback();
            }

            JOptionPane.showMessageDialog(mainFrame, "airport name or city fields cannot be empty");
            return;
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }

            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
            return;
        } finally {
            em.close();
        }
        txt_airportName.setText("");
        txt_city.setText("");
        //test this new method
    }//GEN-LAST:event_btn_addAirportActionPerformed

    private void btn_deleteAirportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteAirportActionPerformed

        String airportName = txt_airportName.getText().trim();
        String city = txt_city.getText().trim();
        EntityManager em = MyEntityController.getEntityManager();
        EntityTransaction tr = em.getTransaction();
        if (airportName.isEmpty() || city.isEmpty()) {
            JOptionPane.showMessageDialog(mainFrame, "airport name or city fields cannot be empty");
            return;
        }
        try {
            tr.begin();

            Airport a = FlightOperations.getAirportByAirportName(airportName);
            if (a == null) {
                JOptionPane.showMessageDialog(mainFrame, "no airport was found with that name");
                return;
            }
            comboModeldestination.removeElement(a);
            comboModelorigin.removeElement(a);
            Airport managed = em.merge(a);
            em.remove(managed); 
//because of : //java.lang.IllegalArgumentException: Entity must be managed to call remove: xxx, try merging the detached and try the remove again.

            tr.commit();
        } catch (PersistenceException e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            JOptionPane.showMessageDialog(mainFrame, "\nCannot delete this airport. It is used in one or more flights.");
            return;
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());

            return;
        } finally {
            em.close();
        }
        txt_airportName.setText("");
        txt_city.setText("");
        JOptionPane.showMessageDialog(mainFrame, "airport has been deleted");
    }//GEN-LAST:event_btn_deleteAirportActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(dtm.getValueAt(jTable1.getSelectedRow(), 0).toString());

        EntityManager em = MyEntityController.getEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            Flight f = em.find(Flight.class, id);
            if (f == null) {
                throw new NullPointerException("Flight not found");
            }
            if (f.getFlightCapacity() != f.calculateAvailableSeats()) {
                throw new IllegalArgumentException("Cannot delete this flight. It is used in one or more reservations.");
            }
            em.remove(f);
            tr.commit();

        } catch (IllegalArgumentException | NullPointerException e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
            return;
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
            return;
        } finally {
            em.close();
        }
        dtm.removeRow(jTable1.getSelectedRow());
        JOptionPane.showMessageDialog(mainFrame, "the flight has been deleted", "information", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        mainFrame.navigateToPanel("LoginPanel");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        mainFrame.navigateToPanel("AdminReport");
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addAirport;
    private javax.swing.JButton btn_deleteAirport;
    private javax.swing.JComboBox<String> cb_destiantionAirport;
    private javax.swing.JComboBox<String> cb_originAirports;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_airportId;
    private javax.swing.JTextField txt_airportName;
    private javax.swing.JTextField txt_capacity;
    private javax.swing.JTextField txt_city;
    private javax.swing.JTextField txt_departureDate;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_seatPrice;
    // End of variables declaration//GEN-END:variables
}
////re inter Istanbul Airport
//change delete method to check for related flights before deleting
//change (new flight is deleted)
//work on updating flights and airports
//27.05    17:12 pm

// you have to delete seats when you delete a flight
