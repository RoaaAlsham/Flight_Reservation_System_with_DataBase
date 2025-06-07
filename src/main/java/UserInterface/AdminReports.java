package UserInterface;

import controlOperations.FlightOperations;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import models.Person;
import models.Reservation;

/**
 *
 * @author Zahera
 */
public class AdminReports extends javax.swing.JPanel {

    Person p;
    MainFrameForm mainFrame;
    AdminPanel ap;
    DefaultTableModel reservationTableModel;
    DefaultTableModel passengersTableModel;
    private String url = "jdbc:mysql://localhost:3306/FLIGHT_RESERVATION_DB?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private String user = "root";
    private String password = "MySQL571610";

    public AdminReports(MainFrameForm mainFrame, Person p, AdminPanel ap) {
        initComponents();
        this.ap = ap;
        this.mainFrame = mainFrame;
        this.p = p;
        reservationTableModel = new DefaultTableModel();
        passengersTableModel = new DefaultTableModel();
        //idreservation, flightId, passengerId, seatId, reservationDate
        reservationTableModel.setColumnIdentifiers(new Object[]{"id", "flight Id", "passenger Id", "seat Id", "reservation Date","seat Price"});
        //idperson, firstName, lastName, email, password, birthdate, gender, role
        passengersTableModel.setColumnIdentifiers(new Object[]{"id", "first Name", "last Name", "email", "password", "birth date", "gender"});
        jTable1.setModel(reservationTableModel);
        jTable2.setModel(passengersTableModel);
        showReservationsOnTable();
        showPassengersOnTable();
    }

    private void showReservationsOnTable() {     
          String str_query = "SELECT * FROM Reservation";         
           try(
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(str_query);){
                while (rs.next()) {
                    float price=FlightOperations.JDBCgetSeatPriceByReservationId( rs.getInt("idreservation"), url, user, password);

                reservationTableModel.addRow(new Object[]{
                    rs.getInt("idreservation"),
                    rs.getInt("flightId"),
                    rs.getInt("passengerId"),
                    rs.getInt("seatId"),
                    rs.getDate("reservationDate"),
                    price
                });
            }                       
//            for (Reservation r : rs) {
//             reservationTableModel.addRow(new Object[] {r.getIdreservation(),
//             r.getFlightId(),r.getPassengerId(),r.getSeatId(),r.getReservationDate()});      
//            }
               
           } catch (SQLException e) {
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
            return;
        }
         
    }
    private void showPassengersOnTable() {
        String str_query = "SELECT * FROM person where person.role=2";
        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(str_query);) {

            while (rs.next()) {
                //new Object[]{"id","firstName","lastName","email","password","birthdate","gender"

                passengersTableModel.addRow(new Object[]{
                    rs.getInt("idperson"), rs.getString("firstName"), rs.getString("lastName"),
                    rs.getString("email"), rs.getString("password"), rs.getDate("birthdate"), rs.getString("gender")});

//                passengersTableModel.addRow(new Object[]{r.getIdperson(), r.getFirstName(),
//                    r.getLastName(), r.getEmail(), r.getPassword(), r.getBirthdate(), r.getGender()});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
            return;
        }

    }
    //8.25   4/6/2025   
    //work on import and export buttons
    //calculate total fees in PassengerHistory
    //upload to github
    //prepare documentation and include data diagram

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        exportReservationReport = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        exportPassengerReport = new javax.swing.JButton();
        ReadReservationRecords = new javax.swing.JButton();
        readPassengerRecords = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btn_calculateRevenue = new javax.swing.JButton();
        lbl_totalRevenue = new javax.swing.JLabel();
        btn_resertReservations = new javax.swing.JButton();
        btn_resertPassengers = new javax.swing.JButton();
        ExportBinaryRecords = new javax.swing.JButton();
        ReadBinaryRecords = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Georgia", 2, 36)); // NOI18N
        jLabel1.setText("Admin Report Page___________________");

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

        jLabel2.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        jLabel2.setText("<<<<<<<<<<<<<<<<<<<<<<<Reservations>>>>>>>>>>>>>>>>>>>>>>");

        exportReservationReport.setText("Export Reservation Records");
        exportReservationReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportReservationReportActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        jLabel3.setText("<<<<<<<<<<<<<<<<<<<<<<<Passengers>>>>>>>>>>>>>>>>>>>>>>");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        exportPassengerReport.setText("Export Passenger Records");
        exportPassengerReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportPassengerReportActionPerformed(evt);
            }
        });

        ReadReservationRecords.setText("Read Reservation Records");
        ReadReservationRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReadReservationRecordsActionPerformed(evt);
            }
        });

        readPassengerRecords.setText("Read Passenger Records");
        readPassengerRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readPassengerRecordsActionPerformed(evt);
            }
        });

        jButton2.setText("Go back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_calculateRevenue.setText("calculate total revenue: ");
        btn_calculateRevenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculateRevenueActionPerformed(evt);
            }
        });

        lbl_totalRevenue.setText("...........................................");

        btn_resertReservations.setText("show All");
        btn_resertReservations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resertReservationsActionPerformed(evt);
            }
        });

        btn_resertPassengers.setText("show All");
        btn_resertPassengers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resertPassengersActionPerformed(evt);
            }
        });

        ExportBinaryRecords.setText("Export Binary Records");
        ExportBinaryRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportBinaryRecordsActionPerformed(evt);
            }
        });

        ReadBinaryRecords.setText("Read Binary Records");
        ReadBinaryRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReadBinaryRecordsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(exportReservationReport, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ReadReservationRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(40, 40, 40)
                                        .addComponent(btn_resertPassengers))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(exportPassengerReport, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                            .addComponent(ExportBinaryRecords, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(108, 108, 108)
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(readPassengerRecords, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                            .addComponent(ReadBinaryRecords, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(29, 29, 29)
                                .addComponent(btn_resertReservations))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(btn_calculateRevenue)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_totalRevenue)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btn_resertReservations))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportReservationReport)
                    .addComponent(ReadReservationRecords))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_calculateRevenue)
                            .addComponent(lbl_totalRevenue))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_resertPassengers)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(exportPassengerReport)
                            .addComponent(readPassengerRecords))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ExportBinaryRecords)
                            .addComponent(ReadBinaryRecords))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(40, 40, 40))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        mainFrame.navigateToPanel("AdminPanel");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void exportReservationReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportReservationReportActionPerformed

        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter1 = new FileNameExtensionFilter("text file", "txt");
        fc.addChoosableFileFilter(filter1);
        fc.setAcceptAllFileFilterUsed(true);

        int answer = fc.showSaveDialog(ap);
        if (answer == JFileChooser.CANCEL_OPTION) {
            return;
        }
        String str_query = "SELECT * FROM Reservation";
        File f = fc.getSelectedFile();//
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(str_query);) {
            bw.write("idreservation,flightId,passengerId,seatId,reservationDate\n");
            while (rs.next()) {
                String formatted = String.format("%013d,%08d,%011d,%06d,%s\n", rs.getInt("idreservation"),
                        rs.getInt("flightId"), rs.getInt("passengerId"), rs.getInt("seatId"), rs.getDate("reservationDate"));
                bw.write(formatted);
            }//can i get dateTime instead of just date-> using Timestamp
            JOptionPane.showMessageDialog(mainFrame, "the export is completed successfully");
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
            return;
        }


// jdbc RESULTSET DOESNT RETURN AN OBJECT, SO I CANT USE OBJECT OUTPUT STREAM
//        try(ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
//                Connection conn = DriverManager.getConnection(url, user, password);
//                Statement st = conn.createStatement();
//                ResultSet rs = st.executeQuery(str_query);){
//            Reservation reservation;
//            
//            while (rs.next()) {
//               int id= rs.getInt("idreservation");
//               int flightId=rs.getInt("flightId");
//               int passId=rs.getInt("passengerId");
//               int seatId=rs.getInt("seatId");
//               Date dateTime=rs.getDate("reservationDate");
//               reservation= new Reservation(id);
//               
//               
//            } 
//      JOptionPane.showMessageDialog(mainFrame, "the export is completed successfully");
//
//        
//        } catch (SQLException | IOException e) {
//           JOptionPane.showMessageDialog(mainFrame, e.getMessage());
//            return;
//       }
    }//GEN-LAST:event_exportReservationReportActionPerformed

    private void exportPassengerReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportPassengerReportActionPerformed
// 19.48   6.6.2025   // contiune with export passenger, use scanner for reading input 
         JFileChooser fc = new JFileChooser();
          fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter1 = new FileNameExtensionFilter("text file", "txt");
        fc.addChoosableFileFilter(filter1);
        fc.setAcceptAllFileFilterUsed(true);
         int answer = fc.showSaveDialog(ap);
        if (answer == JFileChooser.CANCEL_OPTION) {
           return;
        }
       File f = fc.getSelectedFile();
        String str_query = "SELECT * FROM person where person.role=2";
       try(PrintWriter pw= new PrintWriter(new FileWriter(f));
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(str_query);){
//idperson, firstName, lastName, email, password, birthdate, gender, role

while (rs.next()) {
                String formatted = String.format("""
                                                 idperson: %d
                                                 firstName: %s
                                                 lastName: %s
                                                 email: %s
                                                 password: %s
                                                 birthdate: %s
                                                 gender: %s""", rs.getInt("idperson"),
                        rs.getString("firstName"), rs.getString("lastName"), 
                        rs.getString("email"),rs.getString("password"),
                        rs.getDate("birthdate"),rs.getString("gender"));
                pw.write(formatted);
                pw.write("\n\n");
            }
                       JOptionPane.showMessageDialog(mainFrame, "the export is completed successfully");
           
       } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
            return;
        }
       
    }//GEN-LAST:event_exportPassengerReportActionPerformed

    private void ReadReservationRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReadReservationRecordsActionPerformed

        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter1 = new FileNameExtensionFilter("text file", "txt");
        fc.addChoosableFileFilter(filter1);
        fc.setAcceptAllFileFilterUsed(true);
        int answer = fc.showOpenDialog(ap);
        if (answer == JFileChooser.CANCEL_OPTION) {
            return;
        }
        File f = fc.getSelectedFile();
        //INSTEAD OF INSERTING THE VALUES JUST SHOW THEM ON TABLE ,
        //BECAUSE OF DANGEROUS CONDITOIN VIOLATION POSSIBILITY.
        //AND ALSO GUI IS MORE CONVINIENT FOR USERS
//        String sql = "INSERT INTO Reservation (flightId, passengerId, seatId, reservationDate) VALUES (?,?,?,?) ";
//        try (Connection conn = DriverManager.getConnection(url, user, password); 
//                PreparedStatement ps = conn.prepareStatement(sql); 
//                BufferedReader br = new BufferedReader(new FileReader(f))) {
//            String step;
//            conn.setAutoCommit(false);
////assuming that fields are seperated by comma,(flightId 0, passengerId 1, seatId 2, reservationDate 3)
//            while ((step =br.readLine())!=null) {
//                String[] words= step.split(",");
//                 int flightId;
//                    int passengerId;
//                    int seatId;
//                    String str_date= words[3];
//                try {
//                    flightId= Integer.parseInt(words[0]);
//                    passengerId=Integer.parseInt(words[1]);
//                    seatId=Integer.parseInt(words[2]);
//                    str_date= words[3];
//                } catch (ClassCastException|ArrayIndexOutOfBoundsException e) {
//                     JOptionPane.showMessageDialog(mainFrame, e.getMessage());
//                     return;
//                }
//                ps.setInt(1, flightId);
//                ps.setInt(2,passengerId);
//                ps.setInt(3, seatId);
//                ps.setString(4, str_date);
//                int rowsAffected=ps.executeUpdate();
//                if(rowsAffected!=1){
//                    conn.rollback();
// JOptionPane.showMessageDialog(mainFrame, "info insertion has been cutted do to some error");
//
//                }
//            }
//        } catch (Exception e) {
//        }
        reservationTableModel.setRowCount(0);
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String step;
//assuming that fields are seperated by comma,(idreservation,flightId,passengerId,seatId,reservationDate)
            while ((step = br.readLine()) != null) {
                String[] words = step.split(",");
                int idreservation;
                int flightId;
                int passengerId;
                int seatId;
                String str_date;
                try {
                    idreservation = Integer.parseInt(words[0]);
                    flightId = Integer.parseInt(words[1]);
                    passengerId = Integer.parseInt(words[2]);
                    seatId = Integer.parseInt(words[3]);
                    str_date = words[4];
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(mainFrame, "the file format cannot be read,\nmake sure values are seperated by a comma in the this order:\n(idreservation,flightId,passengerId,seatId,reservationDate)\n " + e.getMessage());
                    return;
                }

                //SHOW THE READ VALUES
                reservationTableModel.addRow(new Object[]{idreservation, flightId, passengerId, seatId, str_date});
            }
            JOptionPane.showMessageDialog(mainFrame, "File records have been shown on the table successfully :)");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
            return;
        }
    }//GEN-LAST:event_ReadReservationRecordsActionPerformed

    private void btn_calculateRevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculateRevenueActionPerformed
        float revenue = 0;
        String str_query = "SELECT * FROM Reservation";         
           try(
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(str_query);){
            
            while (rs.next()) {
                int id = rs.getInt("idreservation");

                float price = FlightOperations.JDBCgetSeatPriceByReservationId(id, url, user, password);
                revenue += price;
            }

            lbl_totalRevenue.setText(String.valueOf(revenue));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
            return;
        }

    }//GEN-LAST:event_btn_calculateRevenueActionPerformed

    private void btn_resertReservationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resertReservationsActionPerformed
        reservationTableModel.setRowCount(0);
          String str_query = "SELECT * FROM Reservation";         
           try(
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(str_query);){
                while (rs.next()) {
                    float price=FlightOperations.JDBCgetSeatPriceByReservationId( rs.getInt("idreservation"), url, user, password);

                reservationTableModel.addRow(new Object[]{
                    rs.getInt("idreservation"),
                    rs.getInt("flightId"),
                    rs.getInt("passengerId"),
                    rs.getInt("seatId"),
                    rs.getDate("reservationDate"),
                    price
                });
            }  } catch (SQLException e) {
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
            return;
        }    
    }//GEN-LAST:event_btn_resertReservationsActionPerformed

    private void btn_resertPassengersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resertPassengersActionPerformed
        passengersTableModel.setRowCount(0);
          String str_query = "SELECT * FROM person where person.role=2";
        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(str_query);) {

            while (rs.next()) {
                //new Object[]{"id","firstName","lastName","email","password","birthdate","gender"

                passengersTableModel.addRow(new Object[]{
                    rs.getInt("idperson"), rs.getString("firstName"), rs.getString("lastName"),
                    rs.getString("email"), rs.getString("password"), rs.getDate("birthdate"), rs.getString("gender")});

//                passengersTableModel.addRow(new Object[]{r.getIdperson(), r.getFirstName(),
//                    r.getLastName(), r.getEmail(), r.getPassword(), r.getBirthdate(), r.getGender()});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
            return;
        }
    }//GEN-LAST:event_btn_resertPassengersActionPerformed

    private void readPassengerRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readPassengerRecordsActionPerformed
//assuming that fields are seperated by a comma
    JFileChooser fc= new JFileChooser();
     fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter1 = new FileNameExtensionFilter("text file", "txt");
        fc.addChoosableFileFilter(filter1);
        fc.setAcceptAllFileFilterUsed(true);
    int answer= fc.showOpenDialog(ap);
    if(answer==JFileChooser.CANCEL_OPTION){
        return;
    }    
    File f = fc.getSelectedFile();
    //"id","firstName","lastName","email","password","birthdate","gender"
passengersTableModel.setRowCount(0);
String step="";
        try (BufferedReader br = new BufferedReader(new FileReader(f))){
            
            while((step=br.readLine())!=null ){
                String[] words=step.split(",");
                if(words.length!=7){
                    throw new IllegalArgumentException("each line of the file has to have 7 field seperated by comma\n"
                            + "id,firstName,lastName,email,password,birthdate,gender\n"+step);
                }
                 int id=Integer.parseInt( words[0].trim());
                 String firstname=words[1];
                 String lastName=words[2];
                 String email=words[3];
                 String password= words[4];
                 String birthDate= words[5];
                 String gender= words[6];
                 passengersTableModel.addRow(new Object[]{id,firstname,lastName,email,password,birthDate,gender});
                 
            }
        } catch (IllegalArgumentException e) {
             JOptionPane.showMessageDialog(mainFrame, e.getMessage());
            return;
        } catch (Exception e) {
             JOptionPane.showMessageDialog(mainFrame, "problem in line: "+step);
            return;
        }
    }//GEN-LAST:event_readPassengerRecordsActionPerformed

    private void ExportBinaryRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportBinaryRecordsActionPerformed
          JFileChooser fc = new JFileChooser();
          fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter1 = new FileNameExtensionFilter("binary data (.dat)", "dat");
        fc.addChoosableFileFilter(filter1);
        fc.setAcceptAllFileFilterUsed(true);
         int answer = fc.showSaveDialog(ap);
        if (answer == JFileChooser.CANCEL_OPTION) {
           return;
        }
       File f = fc.getSelectedFile();
        String str_query = "SELECT * FROM person where person.role=2";
       try(DataOutputStream dos= new DataOutputStream(new FileOutputStream(f) );
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(str_query);){
//idperson, firstName, lastName, email, password, birthdate, gender, role

//while (rs.next()) {
               
    //this is only one line 
//                dos.writeUTF(
//                rs.getInt("idperson")+
//                        rs.getString("firstName")+ rs.getString("lastName")+
//                        rs.getString("email")+rs.getString("password")+
//                        rs.getDate("birthdate")+rs.getString("gender")
//                );
               while (rs.next()) {
    dos.writeInt(rs.getInt("idperson"));                 
    dos.writeUTF(rs.getString("firstName"));
    dos.writeUTF(rs.getString("lastName"));
    dos.writeUTF(rs.getString("email"));
    dos.writeUTF(rs.getString("password"));
    dos.writeUTF(rs.getDate("birthdate").toString());   
    dos.writeUTF(rs.getString("gender"));
}
 //           }
                       JOptionPane.showMessageDialog(mainFrame, "the export is completed successfully");
           
       } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
            return;
        }
    }//GEN-LAST:event_ExportBinaryRecordsActionPerformed

    private void ReadBinaryRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReadBinaryRecordsActionPerformed
 JFileChooser fc= new JFileChooser();
     fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter1 = new FileNameExtensionFilter("binary data (.dat)", "dat");
        fc.addChoosableFileFilter(filter1);
        fc.setAcceptAllFileFilterUsed(true);
    int answer= fc.showOpenDialog(ap);
    if(answer==JFileChooser.CANCEL_OPTION){
        return;
    }    
    File f = fc.getSelectedFile();
    //"id","firstName","lastName","email","password","birthdate","gender"
passengersTableModel.setRowCount(0);

        try (DataInputStream dis= new DataInputStream(new FileInputStream(f))){
          
            while(dis.available()>0){
             
                 int id=dis.readInt();
                 String firstname=dis.readUTF();
                 String lastName=dis.readUTF();
                 String email=dis.readUTF();
                 String password= dis.readUTF();
                 String birthDate= dis.readUTF();
                 String gender= dis.readUTF();
                 passengersTableModel.addRow(new Object[]{id,firstname,lastName,email,password,birthDate,gender});
                 
            }
            
   JOptionPane.showMessageDialog(mainFrame, "the input is shown successfully");

        } catch (IllegalArgumentException e) {
             JOptionPane.showMessageDialog(mainFrame, e.getMessage());
            return;
        } catch (IOException e) {
             JOptionPane.showMessageDialog(mainFrame,e.getMessage() );
            return;
        }
        //00.13 7.6.2025 test these methods
        //THERE IS A SKIPPED LINE!!!
        
    }//GEN-LAST:event_ReadBinaryRecordsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExportBinaryRecords;
    private javax.swing.JButton ReadBinaryRecords;
    private javax.swing.JButton ReadReservationRecords;
    private javax.swing.JButton btn_calculateRevenue;
    private javax.swing.JButton btn_resertPassengers;
    private javax.swing.JButton btn_resertReservations;
    private javax.swing.JButton exportPassengerReport;
    private javax.swing.JButton exportReservationReport;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lbl_totalRevenue;
    private javax.swing.JButton readPassengerRecords;
    // End of variables declaration//GEN-END:variables
}
