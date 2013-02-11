/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.biz.izpack.GUI;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.biz.izpack.models.resources.ResourceModel;

/**
 *
 * @author basar
 */
public class ResourceDialog extends javax.swing.JDialog {
    
    private String _fileName;
    
    private ResourceModel _resource;

    /**
     * Creates new form ResourceDialog
     */
    public ResourceDialog(java.awt.Frame parent, ResourceModel selected) {
        super(parent, true);
        initComponents();
        if (this._resource != null) {
            this._resource = selected;
        } else {
            this._resource = new ResourceModel();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_resId = new javax.swing.JLabel();
        tf_resId = new javax.swing.JTextField();
        lbl_resSrc = new javax.swing.JLabel();
        btn_ok = new javax.swing.JButton();
        btn_browse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbl_resId.setText("Id : ");

        tf_resId.setText("Resource Id...");
        tf_resId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_resId_focuslost(evt);
            }
        });

        lbl_resSrc.setText("Source : ");

        btn_ok.setText("OK");
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ok_pressed(evt);
            }
        });

        btn_browse.setText("Browse");
        btn_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browse_pressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_resSrc)
                    .addComponent(lbl_resId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_resId, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_browse)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(btn_ok)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_resId)
                    .addComponent(tf_resId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_resSrc)
                    .addComponent(btn_browse))
                .addGap(18, 18, 18)
                .addComponent(btn_ok)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ok_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ok_pressed
        tf_resId.requestFocus(false);
        if (_fileName == null) {
            return;
        }
        _resource.setId(tf_resId.getText());
        _resource.setSource(_fileName);
        MainFrame.installation.getResourcesModel().getResources().add(_resource);
        this.setVisible(false);
    }//GEN-LAST:event_btn_ok_pressed

    private void tf_resId_focuslost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_resId_focuslost
        if (tf_resId.getText().isEmpty() == true) {
            tf_resId.setText("ID");
            JOptionPane.showMessageDialog(null, "Resource ID cannot be empty.", "Resource ID is empty!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tf_resId_focuslost

    private void btn_browse_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_browse_pressed
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            _fileName = chooser.getSelectedFile().getAbsolutePath();
        }
    }//GEN-LAST:event_btn_browse_pressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_browse;
    private javax.swing.JButton btn_ok;
    private javax.swing.JLabel lbl_resId;
    private javax.swing.JLabel lbl_resSrc;
    private javax.swing.JTextField tf_resId;
    // End of variables declaration//GEN-END:variables
}