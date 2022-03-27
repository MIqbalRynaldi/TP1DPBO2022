/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tp1dpbo2022;
import components.*;
import java.awt.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Iqbal Rynaldi
 */
public class FrameMain extends javax.swing.JFrame {

    /**
     * Creates new form FrameMain
     */
    private ItemBuku[] itembuku;
    private ItemAuthor[] itemauthor;
    private FormAuthor formAuthor;
    private FormBuku formBuku;
    static dbConnection dbcon = new dbConnection();
    private String selectNow;
    public FrameMain() {
        initComponents();
        setItemBuku();
        setFormBuku();
        selectNow = "buku";
    }
    
    public void btnAuthorDelete(ItemAuthor item){
        try {
            // TODO add your handling code here:
            dbcon.stm.execute("DELETE FROM `author` WHERE `author`.`id` = "+item.id+"");
        } catch (SQLException ex) {
            Logger.getLogger(ItemAuthor.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.removeAll();
        revalidate();
        repaint(); 
    }
    public void setItemBuku(){
        panelList.removeAll();
        panelList.setLayout(new GridLayout(0,1,20,20));
        itembuku = new ItemBuku[100];
        try{
            String sql = "Select * from buku";
            ResultSet res = dbcon.query(sql);
            int no = 0;
            while(res.next()){
                itembuku[no] = new ItemBuku(res.getString("id"),res.getString("penerbit"),res.getString("author"),res.getString("desc"),res.getString("img"));
                itembuku[no].btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        setItemBuku();
                    }
                });
                itembuku[no].updateBuku.btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        setItemBuku();
                    }
                });
                panelList.add(itembuku[no]);
                no++;
                System.out.println(res.getString("img"));
            }            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        panelList.revalidate();
        panelList.repaint();        
    }
    
   public void setItemAuthor(){
        panelList.removeAll();
        panelList.setLayout(new GridLayout(0,1,20,20));
        itemauthor = new ItemAuthor[100];
        try{
            String sql = "Select * from author";
            ResultSet res = dbcon.query(sql);
            int no = 0;
            while(res.next()){
                itemauthor[no] = new ItemAuthor(res.getString("id"),res.getString("img"),res.getString("nama"),res.getString("jumlah_buku"));
                itemauthor[no].btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        setItemAuthor();
                    }
                });
                itemauthor[no].updateAuthor.btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        setItemAuthor();
                    }
                });
                panelList.add(itemauthor[no]);
                no++;
            }            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        panelList.revalidate();
        panelList.repaint();        
    }
     
    private void setFormAuthor(){
        panelForm.removeAll();
        panelForm.setLayout(new GridLayout(1,1));
        formAuthor = new FormAuthor();
        formAuthor.btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setItemAuthor();
            }
        });
        panelForm.add(formAuthor);
        panelForm.revalidate();
        panelForm.repaint();    
    }
   
    
    private void setFormBuku(){
        panelForm.removeAll();
        panelForm.setLayout(new GridLayout(1,1));
        try {
            formBuku = new FormBuku();
            formBuku.btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setItemBuku();
            }
        });
        } catch (SQLException ex) {
            Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        panelForm.add(formBuku);
        panelForm.revalidate();
        panelForm.repaint();    
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBuku.setText("Buku");
        btnBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBukuMouseClicked(evt);
            }
        });

        btnAuthor.setText("Author");
        btnAuthor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAuthorMouseClicked(evt);
            }
        });

        btnRefresh.setText("Refresh Data");
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshMouseClicked(evt);
            }
        });

        panelForm.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );
        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setToolTipText("");
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setHorizontalScrollBar(null);

        javax.swing.GroupLayout panelListLayout = new javax.swing.GroupLayout(panelList);
        panelList.setLayout(panelListLayout);
        panelListLayout.setHorizontalGroup(
            panelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
        );
        panelListLayout.setVerticalGroup(
            panelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelList);
        panelList.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuku, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(btnAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnAuthorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAuthorMouseClicked
        setItemAuthor();
        setFormAuthor();
        selectNow = "author";
    }//GEN-LAST:event_btnAuthorMouseClicked

    private void btnBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBukuMouseClicked
        // TODO add your handling code here:
        setItemBuku();
        setFormBuku();
        selectNow = "buku";
    }//GEN-LAST:event_btnBukuMouseClicked

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        // TODO add your handling code here:
        if(selectNow.equals("buku")){
            setItemBuku();
        }else{
            setItemAuthor();
        }
        
    }//GEN-LAST:event_btnRefreshMouseClicked

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
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    final javax.swing.JFileChooser FileChooser = new javax.swing.JFileChooser();
    final javax.swing.JButton btnAuthor = new javax.swing.JButton();
    final javax.swing.JButton btnBuku = new javax.swing.JButton();
    final javax.swing.JButton btnRefresh = new javax.swing.JButton();
    final javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
    final javax.swing.JPanel panelForm = new javax.swing.JPanel();
    final javax.swing.JPanel panelList = new javax.swing.JPanel();
    // End of variables declaration//GEN-END:variables
}
