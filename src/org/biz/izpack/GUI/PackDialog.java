/*
 * PackDialog is a dialog to allow user to add or edit any package entity.
 */

package org.biz.izpack.GUI;

import javax.swing.JOptionPane;
import org.biz.izpack.models.packs.PackModel;

/**
 *
 * @author basar
 */

public class PackDialog extends javax.swing.JDialog {
    
    private PackModel _pack;
    
    private int _selectedIndex;

    /**
     * Creates new form PackDialog
     */
    public PackDialog(java.awt.Frame parent, PackModel selected, int index) {
        super(parent, true);
        
        initComponents();
        this._selectedIndex = index;
        if (selected != null) {
            this._pack = selected;
        } else {
            this._pack = new PackModel();
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

        lbl_name = new javax.swing.JLabel();
        tf_name = new javax.swing.JTextField();
        lbl_description = new javax.swing.JLabel();
        tf_description = new javax.swing.JTextField();
        cb_required = new javax.swing.JCheckBox();
        btn_ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbl_name.setText("Name : ");

        tf_name.setText("Pack");
        tf_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_name_focuslost(evt);
            }
        });

        lbl_description.setText("Description : ");

        tf_description.setText("Description");
        tf_description.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_description_focuslost(evt);
            }
        });

        cb_required.setText("Required");

        btn_ok.setText("OK");
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ok_pressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_description)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_ok)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tf_description)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cb_required)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_name)
                    .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_description)
                    .addComponent(tf_description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_required)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_ok)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_name_focuslost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_name_focuslost
        if (tf_name.getText().isEmpty() == true) {
            tf_name.setText("Pack");
            JOptionPane.showMessageDialog(null, "Pack Name cannot be empty.", "Pack Name is empty!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tf_name_focuslost

    private void tf_description_focuslost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_description_focuslost
        if (tf_description.getText().isEmpty() == true) {
            tf_description.setText("Description");
            JOptionPane.showMessageDialog(null, "Description cannot be empty.", "Description is empty!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tf_description_focuslost

    private void btn_ok_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ok_pressed
        tf_name.requestFocus(false);
        tf_description.requestFocus(false);
        _pack.setName(tf_name.getText());
        _pack.setDescription(tf_description.getText());
        _pack.setRequired(cb_required.isSelected());
        if (_selectedIndex == -1) {
            MainFrame.installation.getPacksModel().getPacks().remove(_pack);
            MainFrame.installation.getPacksModel().getPacks().add(_pack);
        } else {
            MainFrame.installation.getPacksModel().getPacks().remove(_pack);
            MainFrame.installation.getPacksModel().getPacks().add(_selectedIndex, _pack);    
        }
        this.setVisible(false);
    }//GEN-LAST:event_btn_ok_pressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ok;
    private javax.swing.JCheckBox cb_required;
    private javax.swing.JLabel lbl_description;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JTextField tf_description;
    private javax.swing.JTextField tf_name;
    // End of variables declaration//GEN-END:variables
}
