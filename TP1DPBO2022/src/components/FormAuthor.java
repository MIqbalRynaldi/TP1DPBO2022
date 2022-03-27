/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package components;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import tp1dpbo2022.*;

/**
 *
 * @author Iqbal Rynaldi
 */
public class FormAuthor extends javax.swing.JPanel {

    /**
     * Creates new form formAuthor
     */
    private String name;
    private String jumlah;
    public String id;
    private File file;
    private PopupMessage popup = new PopupMessage();
    static dbConnection dbcon = new dbConnection();
    
    public FormAuthor() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        inputName = new javax.swing.JTextField();
        inputJumlah = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        btnUploadImg = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();

        fileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        fileChooser.setApproveButtonToolTipText("");
        fileChooser.setDialogTitle("Upload Image");
        fileChooser.setFileFilter(null);

        jLabel1.setText("Nama :");

        jLabel2.setText("Jumlah :");

        Title.setText("Form Author");

        btnUploadImg.setText("Upload ");
        btnUploadImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUploadImgMouseClicked(evt);
            }
        });

        jLabel4.setText("Image :");

        btnSubmit.setBackground(new java.awt.Color(102, 204, 255));
        btnSubmit.setText("Submit");
        btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubmitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUploadImg)
                            .addComponent(inputJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSubmit)
                    .addComponent(Title))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(Title)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUploadImg)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(btnSubmit)
                .addContainerGap(7, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void prosesSubmit(){
        name = inputName.getText();
        jumlah = inputJumlah.getText();
        if(name != null && jumlah != null && file != null){
            String img = file.getName();
            uploadValidasi(file);
            try{
                String sql = "INSERT INTO `author` (`id`, `img`, `nama`, `jumlah_buku`) VALUES (NULL, '"+ img +"', '"+name+"', '"+jumlah+"');";
                dbcon.stm.execute(sql);
                popup.textMessage.setText("Berhasil");
                popup.tampil();
                inputName.setText("");
                inputJumlah.setText("");
                file = null; 
            }catch(Exception e){
                popup.textMessage.setText(e.getMessage());              
                popup.tampil();
            }
        }else{
            popup.textMessage.setText("Data Tidak Boleh Kosong");
            popup.tampil();
        }
    }
    
    public void uploadValidasi(File file){
         try {
            Path copied = Paths.get("src/assest/" + file.getName());
            Path originalPath = Paths.get(file.getAbsolutePath());
            Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
          } catch (IOException e) {
            popup.textMessage.setText("An error occurred.");
            popup.tampil();
        
            e.printStackTrace();
          }
    }
    private void btnUploadImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUploadImgMouseClicked
        // TODO add your handling code here:
        FileFilter ff = new FileNameExtensionFilter("images","jpeg");
        fileChooser.addChoosableFileFilter(ff);   
        fileChooser.setFileFilter(ff);
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            // What to do with the file, e.g. display it in a TextArea
        } else {
            popup.textMessage.setText("File access cancelled by user.");
            popup.tampil();
        
        }
    }//GEN-LAST:event_btnUploadImgMouseClicked

    private void btnSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseClicked
        // TODO add your handling code here:
        prosesSubmit();
    }//GEN-LAST:event_btnSubmitMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel Title;
    public static javax.swing.JButton btnSubmit;
    public static javax.swing.JButton btnUploadImg;
    public static javax.swing.JFileChooser fileChooser;
    public static javax.swing.JTextField inputJumlah;
    public static javax.swing.JTextField inputName;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

    public void setId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}