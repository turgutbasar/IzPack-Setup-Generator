/*
 * This is the main frame for this application.
 */
package org.biz.izpack;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author basar
 */
public class MainFrame extends javax.swing.JFrame {
    
    private String _fileName;
    
    public static Installation installation = new Installation();
    
    private class DlgFocusListener implements WindowFocusListener {
        
        private Class _type;
        
        public DlgFocusListener(Class type) {
            this._type = type;
        }

        public void windowGainedFocus(WindowEvent e) {
        }

        public void windowLostFocus(WindowEvent e) {
            if (_type.equals(Author.class)) {
                populateCBAuthors();
            } else if (_type.equals(Resource.class)) {
                populateLstResources();
            } else if (_type.equals(Jar.class)) {
                populateLstJars();
            } else if (_type.equals(Pack.class)) {
                populateTreePacks();
            }
        }
        
    }
    
    private DlgFocusListener _authorListener;
    
    private DlgFocusListener _resourceListener;
    
    private DlgFocusListener _jarListener;
    
    private DlgFocusListener _packListener;

    public MainFrame() {
        initComponents();
        initLists();
        this._authorListener = new DlgFocusListener(Author.class);
        this._resourceListener = new DlgFocusListener(Resource.class);
        this._jarListener = new DlgFocusListener(Jar.class);
        this._packListener = new DlgFocusListener(Pack.class);
        initLangs();
        initPacks();
    }
    
    private void populateCBAuthors() {
        cb_authors.removeAllItems();
        Author[] authors = installation.getInfo().getAuthors();
        if (authors.length == 0) {
            return;
        }
        for (Author itr : authors) {
            cb_authors.addItem(itr);
        }
    }
    
    private void populateLstResources() {
        ((DefaultListModel<Resource>)lst_res.getModel()).removeAllElements();
        Resource[] resources = installation.getResources().getAllResources();
        if (resources.length == 0) {
            return;
        }
        for (Resource itr : resources) {
            ((DefaultListModel<Resource>)lst_res.getModel()).addElement(itr);
        }
    }
    
    private void populateLstJars() {
        ((DefaultListModel<Jar>)lst_jars.getModel()).removeAllElements();
        Jar[] jars = installation.getJars();
        if (jars.length == 0) {
            return;
        }
        for (Jar itr : jars) {
            ((DefaultListModel<Jar>)lst_jars.getModel()).addElement(itr);
        }
    }
    
    private void populateTreePacks() {
        DefaultTreeModel model = (DefaultTreeModel)tree_packs.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
        root.removeAllChildren();
        model.reload(root);
        // Wierd but OK
        Pack[] packs = installation.getPacks().getPacks();
        if (packs.length == 0) {
            return;
        }
        for (Pack itr : packs) {
            DefaultMutableTreeNode tmpNode = new DefaultMutableTreeNode(itr);
            for (File itr2 : itr.getFiles()) {
                tmpNode.add(new DefaultMutableTreeNode(itr2));
            }
            root.add(tmpNode);
        }
    }
    
    private void initLists() {
        // Lack of other lists
        lst_langs.setModel(new DefaultListModel<LangPack>());
        lst_selectedLangs.setModel(new DefaultListModel<LangPack>());
        lst_res.setModel(new DefaultListModel<Resource>());
        lst_jars.setModel(new DefaultListModel<Jar>()); 
        lst_aPanels.setModel(new DefaultListModel<Panel>());
        lst_used.setModel(new DefaultListModel<Panel>());
    }
        
    private void initLangs() {
        LangPack tr = new LangPack();
        tr.setName("tur");
        LangPack fr = new LangPack();
        fr.setName("fra");
        LangPack en = new LangPack();
        en.setName("eng");
        ((DefaultListModel<LangPack>)lst_langs.getModel()).addElement(tr);
        ((DefaultListModel<LangPack>)lst_langs.getModel()).addElement(en);
        ((DefaultListModel<LangPack>)lst_langs.getModel()).addElement(fr);
    }
    
    private void initPacks() {
        Panel panel = new Panel();
        panel.setClassName("HelloPanel");
        ((DefaultListModel<Panel>)lst_aPanels.getModel()).addElement(panel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpnl_mainTabbedPanel = new javax.swing.JTabbedPane();
        cmb_reboot = new javax.swing.JPanel();
        lbl_applicationName = new javax.swing.JLabel();
        tf_applicationName = new javax.swing.JTextField();
        lbl_version = new javax.swing.JLabel();
        tf_version = new javax.swing.JTextField();
        lbl_authors = new javax.swing.JLabel();
        btn_addAuthor = new javax.swing.JButton();
        btn_delAuthor = new javax.swing.JButton();
        lbl_url = new javax.swing.JLabel();
        tf_url = new javax.swing.JTextField();
        cb_runPrivilaged = new javax.swing.JCheckBox();
        cb_authors = new javax.swing.JComboBox();
        btn_editAuthor = new javax.swing.JButton();
        cb_rebootOption = new javax.swing.JComboBox();
        lbl_rebootOption = new javax.swing.JLabel();
        pnl_gui = new javax.swing.JPanel();
        lbl_size = new javax.swing.JLabel();
        tf_width = new javax.swing.JTextField();
        lbl_x = new javax.swing.JLabel();
        tf_height = new javax.swing.JTextField();
        cb_resizable = new javax.swing.JCheckBox();
        cb_useButtonIcons = new javax.swing.JCheckBox();
        cb_useLabelIcons = new javax.swing.JCheckBox();
        lbl_labelGap = new javax.swing.JLabel();
        tf_labelGap = new javax.swing.JTextField();
        pnl_lang = new javax.swing.JPanel();
        lbl_lang = new javax.swing.JLabel();
        sp_langs = new javax.swing.JScrollPane();
        lst_langs = new javax.swing.JList();
        btn_addLang = new javax.swing.JButton();
        btn_removeLang = new javax.swing.JButton();
        sp_selectedLangs = new javax.swing.JScrollPane();
        lst_selectedLangs = new javax.swing.JList();
        lbl_langs = new javax.swing.JLabel();
        lbl_selectedLangs = new javax.swing.JLabel();
        pnl_resources = new javax.swing.JPanel();
        sp_res = new javax.swing.JScrollPane();
        lst_res = new javax.swing.JList();
        btn_addResource = new javax.swing.JButton();
        btn_delResource = new javax.swing.JButton();
        btn_editResource = new javax.swing.JButton();
        lbl_res = new javax.swing.JLabel();
        pnl_jars = new javax.swing.JPanel();
        sp_jars = new javax.swing.JScrollPane();
        lst_jars = new javax.swing.JList();
        btn_addJar = new javax.swing.JButton();
        btn_editJar = new javax.swing.JButton();
        btn_delJar = new javax.swing.JButton();
        lbl_jars = new javax.swing.JLabel();
        pnl_panels = new javax.swing.JPanel();
        lbl_panels = new javax.swing.JLabel();
        btn_right = new javax.swing.JButton();
        btn_left = new javax.swing.JButton();
        sp_used = new javax.swing.JScrollPane();
        lst_used = new javax.swing.JList();
        btn_addPanel = new javax.swing.JButton();
        btn_editPanel = new javax.swing.JButton();
        btn_delPanel = new javax.swing.JButton();
        lbl_avilable = new javax.swing.JLabel();
        lbl_used = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        sp_aPanels = new javax.swing.JScrollPane();
        lst_aPanels = new javax.swing.JList();
        pnl_packs = new javax.swing.JPanel();
        sp_packs = new javax.swing.JScrollPane();
        tree_packs = new javax.swing.JTree();
        lbl_packs = new javax.swing.JLabel();
        btn_addPackorFile = new javax.swing.JButton();
        btn_editPackorFile = new javax.swing.JButton();
        btn_delPackorFile = new javax.swing.JButton();
        pnl_gen = new javax.swing.JPanel();
        lbl_lock = new javax.swing.JLabel();
        lbl_gen = new javax.swing.JLabel();
        btn_gen = new javax.swing.JButton();
        lbl_out = new javax.swing.JLabel();
        btn_out = new javax.swing.JButton();
        btn_lock = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IzPack Setup Creator");

        lbl_applicationName.setText("Application Name : ");

        tf_applicationName.setText("Default Application");
        tf_applicationName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_applicationName_lostfocus(evt);
            }
        });

        lbl_version.setText("Version : ");

        tf_version.setText("Beta");
        tf_version.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_version_lostfocus(evt);
            }
        });

        lbl_authors.setText("Authors : ");

        btn_addAuthor.setBackground(new java.awt.Color(51, 255, 0));
        btn_addAuthor.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        btn_addAuthor.setText("+");
        btn_addAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addAuthor_pressed(evt);
            }
        });

        btn_delAuthor.setBackground(new java.awt.Color(255, 0, 0));
        btn_delAuthor.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        btn_delAuthor.setText("X");
        btn_delAuthor.setMaximumSize(new java.awt.Dimension(39, 19));
        btn_delAuthor.setMinimumSize(new java.awt.Dimension(39, 19));
        btn_delAuthor.setPreferredSize(new java.awt.Dimension(39, 19));
        btn_delAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delAuthor_pressed(evt);
            }
        });

        lbl_url.setText("URL : ");

        tf_url.setText("http://www.kade.com.tr");
        tf_url.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_url_focuslost(evt);
            }
        });

        cb_runPrivilaged.setText("Run Privilaged (Important for Vista)");
        cb_runPrivilaged.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_runPrivilaged_statechanged(evt);
            }
        });

        btn_editAuthor.setBackground(new java.awt.Color(255, 255, 0));
        btn_editAuthor.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        btn_editAuthor.setText("E");
        btn_editAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editAuthor_pressed(evt);
            }
        });

        cb_rebootOption.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ignore", "notice", "ask", "always" }));
        cb_rebootOption.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_reboot_statechanged(evt);
            }
        });

        lbl_rebootOption.setText("Reboot Option : ");

        javax.swing.GroupLayout cmb_rebootLayout = new javax.swing.GroupLayout(cmb_reboot);
        cmb_reboot.setLayout(cmb_rebootLayout);
        cmb_rebootLayout.setHorizontalGroup(
            cmb_rebootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cmb_rebootLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cmb_rebootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_runPrivilaged)
                    .addGroup(cmb_rebootLayout.createSequentialGroup()
                        .addGroup(cmb_rebootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_applicationName)
                            .addComponent(lbl_version)
                            .addComponent(lbl_authors)
                            .addComponent(lbl_url)
                            .addComponent(lbl_rebootOption))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cmb_rebootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_rebootOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cmb_rebootLayout.createSequentialGroup()
                                .addGroup(cmb_rebootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_applicationName, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addComponent(tf_version)
                                    .addComponent(cb_authors, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_addAuthor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_editAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_delAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_url, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        cmb_rebootLayout.setVerticalGroup(
            cmb_rebootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cmb_rebootLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cmb_rebootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_applicationName)
                    .addComponent(tf_applicationName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cmb_rebootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_version)
                    .addComponent(tf_version, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cmb_rebootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cmb_rebootLayout.createSequentialGroup()
                        .addGroup(cmb_rebootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_authors)
                            .addComponent(cb_authors, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(cmb_rebootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_url)
                            .addComponent(tf_url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cmb_rebootLayout.createSequentialGroup()
                        .addGroup(cmb_rebootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_addAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_editAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_delAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)))
                .addGroup(cmb_rebootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_rebootOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_rebootOption))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_runPrivilaged)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        tpnl_mainTabbedPanel.addTab("Information", cmb_reboot);

        lbl_size.setText("Size : ");

        tf_width.setText("320");
        tf_width.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_width_focuslost(evt);
            }
        });

        lbl_x.setText("X");

        tf_height.setText("240");
        tf_height.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_height_focuslost(evt);
            }
        });

        cb_resizable.setText("Resizable");
        cb_resizable.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_resizable_statechanged(evt);
            }
        });

        cb_useButtonIcons.setSelected(true);
        cb_useButtonIcons.setText("Use Icons on Buttons");
        cb_useButtonIcons.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_useButtonIcons_statechanged(evt);
            }
        });

        cb_useLabelIcons.setSelected(true);
        cb_useLabelIcons.setText("Use Icons on Labels");
        cb_useLabelIcons.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_useLabelIcons_statechanged(evt);
            }
        });

        lbl_labelGap.setText("Label Gap : ");

        tf_labelGap.setText("2");
        tf_labelGap.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_labelGap_focuslost(evt);
            }
        });

        javax.swing.GroupLayout pnl_guiLayout = new javax.swing.GroupLayout(pnl_gui);
        pnl_gui.setLayout(pnl_guiLayout);
        pnl_guiLayout.setHorizontalGroup(
            pnl_guiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_guiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_guiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_useLabelIcons)
                    .addComponent(cb_useButtonIcons)
                    .addComponent(cb_resizable)
                    .addGroup(pnl_guiLayout.createSequentialGroup()
                        .addGroup(pnl_guiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_labelGap)
                            .addComponent(lbl_size))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_guiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_width, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(tf_labelGap))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_x)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_height, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 264, Short.MAX_VALUE))
        );
        pnl_guiLayout.setVerticalGroup(
            pnl_guiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_guiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_guiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_size)
                    .addComponent(tf_width, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_x)
                    .addComponent(tf_height, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_guiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_labelGap)
                    .addComponent(tf_labelGap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_resizable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_useButtonIcons)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_useLabelIcons)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        tpnl_mainTabbedPanel.addTab("GUI Settings", pnl_gui);

        lbl_lang.setText("Language : ");

        sp_langs.setViewportView(lst_langs);

        btn_addLang.setText(">>");
        btn_addLang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addLang_pressed(evt);
            }
        });

        btn_removeLang.setText("<<");
        btn_removeLang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeLang_pressed(evt);
            }
        });

        sp_selectedLangs.setViewportView(lst_selectedLangs);

        lbl_langs.setText("Used in Project");

        lbl_selectedLangs.setText("Languages");

        javax.swing.GroupLayout pnl_langLayout = new javax.swing.GroupLayout(pnl_lang);
        pnl_lang.setLayout(pnl_langLayout);
        pnl_langLayout.setHorizontalGroup(
            pnl_langLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_langLayout.createSequentialGroup()
                .addGroup(pnl_langLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_langLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_lang))
                    .addGroup(pnl_langLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(pnl_langLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_langLayout.createSequentialGroup()
                                .addComponent(sp_langs, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnl_langLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_addLang, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_removeLang, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbl_selectedLangs))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_langLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_langs)
                            .addComponent(sp_selectedLangs, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        pnl_langLayout.setVerticalGroup(
            pnl_langLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_langLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_lang)
                .addGap(18, 18, 18)
                .addGroup(pnl_langLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_langLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btn_addLang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_removeLang))
                    .addComponent(sp_selectedLangs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sp_langs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_langLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_selectedLangs)
                    .addComponent(lbl_langs))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        tpnl_mainTabbedPanel.addTab("Language", pnl_lang);

        sp_res.setViewportView(lst_res);

        btn_addResource.setBackground(new java.awt.Color(51, 255, 0));
        btn_addResource.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        btn_addResource.setText("+");
        btn_addResource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addResource_pressed(evt);
            }
        });

        btn_delResource.setBackground(new java.awt.Color(255, 0, 0));
        btn_delResource.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        btn_delResource.setText("X");
        btn_delResource.setMaximumSize(new java.awt.Dimension(39, 19));
        btn_delResource.setMinimumSize(new java.awt.Dimension(39, 19));
        btn_delResource.setPreferredSize(new java.awt.Dimension(39, 19));
        btn_delResource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delResource_pressed(evt);
            }
        });

        btn_editResource.setBackground(new java.awt.Color(255, 255, 0));
        btn_editResource.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        btn_editResource.setText("E");
        btn_editResource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editResource_pressed(evt);
            }
        });

        lbl_res.setText("Resources : ");

        javax.swing.GroupLayout pnl_resourcesLayout = new javax.swing.GroupLayout(pnl_resources);
        pnl_resources.setLayout(pnl_resourcesLayout);
        pnl_resourcesLayout.setHorizontalGroup(
            pnl_resourcesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_resourcesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_resourcesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp_res, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addGroup(pnl_resourcesLayout.createSequentialGroup()
                        .addGroup(pnl_resourcesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_resourcesLayout.createSequentialGroup()
                                .addComponent(btn_addResource)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_editResource, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_delResource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_res))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnl_resourcesLayout.setVerticalGroup(
            pnl_resourcesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_resourcesLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(lbl_res)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp_res, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(pnl_resourcesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_addResource, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delResource, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editResource, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tpnl_mainTabbedPanel.addTab("Resources", pnl_resources);

        sp_jars.setViewportView(lst_jars);

        btn_addJar.setBackground(new java.awt.Color(51, 255, 0));
        btn_addJar.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        btn_addJar.setText("+");
        btn_addJar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addJar_pressed(evt);
            }
        });

        btn_editJar.setBackground(new java.awt.Color(255, 255, 0));
        btn_editJar.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        btn_editJar.setText("E");
        btn_editJar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editJar_pressed(evt);
            }
        });

        btn_delJar.setBackground(new java.awt.Color(255, 0, 0));
        btn_delJar.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        btn_delJar.setText("X");
        btn_delJar.setMaximumSize(new java.awt.Dimension(39, 19));
        btn_delJar.setMinimumSize(new java.awt.Dimension(39, 19));
        btn_delJar.setPreferredSize(new java.awt.Dimension(39, 19));
        btn_delJar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delJar_pressed(evt);
            }
        });

        lbl_jars.setText("Jars : ");

        javax.swing.GroupLayout pnl_jarsLayout = new javax.swing.GroupLayout(pnl_jars);
        pnl_jars.setLayout(pnl_jarsLayout);
        pnl_jarsLayout.setHorizontalGroup(
            pnl_jarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_jarsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_jarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp_jars, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addGroup(pnl_jarsLayout.createSequentialGroup()
                        .addGroup(pnl_jarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_jarsLayout.createSequentialGroup()
                                .addComponent(btn_addJar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_editJar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_delJar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_jars))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnl_jarsLayout.setVerticalGroup(
            pnl_jarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_jarsLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(lbl_jars)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp_jars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(pnl_jarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_addJar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delJar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editJar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tpnl_mainTabbedPanel.addTab("Jars", pnl_jars);

        lbl_panels.setText("Panels : ");

        btn_right.setText(">>");
        btn_right.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addPanel_pressed(evt);
            }
        });

        btn_left.setText("<<");
        btn_left.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removePanel(evt);
            }
        });

        sp_used.setEnabled(false);

        sp_used.setViewportView(lst_used);

        btn_addPanel.setBackground(new java.awt.Color(51, 255, 0));
        btn_addPanel.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        btn_addPanel.setText("+");

        btn_editPanel.setBackground(new java.awt.Color(255, 255, 0));
        btn_editPanel.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        btn_editPanel.setText("E");

        btn_delPanel.setBackground(new java.awt.Color(255, 0, 0));
        btn_delPanel.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        btn_delPanel.setText("X");
        btn_delPanel.setMaximumSize(new java.awt.Dimension(39, 19));
        btn_delPanel.setMinimumSize(new java.awt.Dimension(39, 19));
        btn_delPanel.setPreferredSize(new java.awt.Dimension(39, 19));

        lbl_avilable.setText("Avilable Panels");

        lbl_used.setText("Used In Project");

        jButton1.setText("↓");

        jButton2.setText("↑");

        sp_aPanels.setEnabled(false);

        sp_aPanels.setViewportView(lst_aPanels);

        javax.swing.GroupLayout pnl_panelsLayout = new javax.swing.GroupLayout(pnl_panels);
        pnl_panels.setLayout(pnl_panelsLayout);
        pnl_panelsLayout.setHorizontalGroup(
            pnl_panelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_panelsLayout.createSequentialGroup()
                .addGroup(pnl_panelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_panelsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_panels))
                    .addGroup(pnl_panelsLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(pnl_panelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_panelsLayout.createSequentialGroup()
                                .addComponent(btn_addPanel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_editPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_delPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnl_panelsLayout.createSequentialGroup()
                                .addGroup(pnl_panelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_panelsLayout.createSequentialGroup()
                                        .addComponent(sp_aPanels, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnl_panelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_right, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btn_left, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lbl_avilable))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnl_panelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_used)
                                    .addGroup(pnl_panelsLayout.createSequentialGroup()
                                        .addComponent(sp_used, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnl_panelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        pnl_panelsLayout.setVerticalGroup(
            pnl_panelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_panelsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_panels)
                .addGroup(pnl_panelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_panelsLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btn_right)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_left))
                    .addGroup(pnl_panelsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sp_used, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_panelsLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton2)
                        .addGap(2, 2, 2)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panelsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sp_aPanels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_panelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_avilable)
                    .addComponent(lbl_used))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_panelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_addPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        tpnl_mainTabbedPanel.addTab("Panels", pnl_panels);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("packs");
        tree_packs.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        tree_packs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sp_packs.setViewportView(tree_packs);

        lbl_packs.setText("Packs : ");

        btn_addPackorFile.setBackground(new java.awt.Color(51, 255, 0));
        btn_addPackorFile.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        btn_addPackorFile.setText("+");
        btn_addPackorFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addPackorFile_pressed(evt);
            }
        });

        btn_editPackorFile.setBackground(new java.awt.Color(255, 255, 0));
        btn_editPackorFile.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        btn_editPackorFile.setText("E");
        btn_editPackorFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editPackorFile_pressed(evt);
            }
        });

        btn_delPackorFile.setBackground(new java.awt.Color(255, 0, 0));
        btn_delPackorFile.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        btn_delPackorFile.setText("X");
        btn_delPackorFile.setMaximumSize(new java.awt.Dimension(39, 19));
        btn_delPackorFile.setMinimumSize(new java.awt.Dimension(39, 19));
        btn_delPackorFile.setPreferredSize(new java.awt.Dimension(39, 19));
        btn_delPackorFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delPackorFile_pressed(evt);
            }
        });

        javax.swing.GroupLayout pnl_packsLayout = new javax.swing.GroupLayout(pnl_packs);
        pnl_packs.setLayout(pnl_packsLayout);
        pnl_packsLayout.setHorizontalGroup(
            pnl_packsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_packsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_packsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp_packs)
                    .addGroup(pnl_packsLayout.createSequentialGroup()
                        .addGroup(pnl_packsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_packs)
                            .addGroup(pnl_packsLayout.createSequentialGroup()
                                .addComponent(btn_addPackorFile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_editPackorFile, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_delPackorFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 280, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnl_packsLayout.setVerticalGroup(
            pnl_packsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_packsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_packs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp_packs, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_packsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_addPackorFile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delPackorFile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editPackorFile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        tpnl_mainTabbedPanel.addTab("Packs", pnl_packs);

        lbl_lock.setText("Lock Settings : ");

        lbl_gen.setText("Generate Project : ");

        btn_gen.setBackground(new java.awt.Color(255, 255, 0));
        btn_gen.setText("Generate");
        btn_gen.setEnabled(false);
        btn_gen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generate_pressed(evt);
            }
        });

        lbl_out.setText("Output Location : ");

        btn_out.setText("Browse");
        btn_out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_out_pressed(evt);
            }
        });

        btn_lock.setText("Lock");
        btn_lock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lock_pressed(evt);
            }
        });

        javax.swing.GroupLayout pnl_genLayout = new javax.swing.GroupLayout(pnl_gen);
        pnl_gen.setLayout(pnl_genLayout);
        pnl_genLayout.setHorizontalGroup(
            pnl_genLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_genLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_genLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_genLayout.createSequentialGroup()
                        .addComponent(lbl_gen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_gen))
                    .addGroup(pnl_genLayout.createSequentialGroup()
                        .addGroup(pnl_genLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_out)
                            .addComponent(lbl_lock))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl_genLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_out, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_lock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(246, Short.MAX_VALUE))
        );
        pnl_genLayout.setVerticalGroup(
            pnl_genLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_genLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnl_genLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_out)
                    .addComponent(btn_out))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_genLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_lock)
                    .addComponent(btn_lock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_genLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_gen)
                    .addComponent(btn_gen))
                .addContainerGap(151, Short.MAX_VALUE))
        );

        tpnl_mainTabbedPanel.addTab("Generate", pnl_gen);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpnl_mainTabbedPanel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpnl_mainTabbedPanel)
                .addContainerGap())
        );

        tpnl_mainTabbedPanel.getAccessibleContext().setAccessibleName("info");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_generate_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generate_pressed
        try {                                      
            // Generate Process
            if (_fileName == null)
                return;
            FileOutputStream fos = new FileOutputStream(_fileName);
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Installation.class);
     
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.marshal(installation, fos);
                jaxbMarshaller.marshal(installation, System.out);
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
     
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
	}
    }//GEN-LAST:event_btn_generate_pressed

    private void tf_applicationName_lostfocus(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_applicationName_lostfocus
        if (!tf_applicationName.getText().isEmpty()) {
            installation.getInfo().setAppName(tf_applicationName.getText());
        }
    }//GEN-LAST:event_tf_applicationName_lostfocus

    private void tf_version_lostfocus(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_version_lostfocus
        if (!tf_version.getText().isEmpty()) {
            installation.getInfo().setVersion(tf_version.getText());
        }
    }//GEN-LAST:event_tf_version_lostfocus

    private void btn_addAuthor_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addAuthor_pressed
        AuthorDialog dlg = new AuthorDialog(this, null);
        dlg.setAlwaysOnTop(true);
        dlg.addWindowFocusListener(_authorListener);
        dlg.setVisible(true);  
    }//GEN-LAST:event_btn_addAuthor_pressed

    private void btn_delAuthor_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delAuthor_pressed
        Author selected = (Author)cb_authors.getSelectedItem();
        if (selected == null) {
            return;
        }
        installation.getInfo().removeAuthor(selected);
        populateCBAuthors();
    }//GEN-LAST:event_btn_delAuthor_pressed

    private void btn_editAuthor_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editAuthor_pressed
        Author selected = (Author)cb_authors.getSelectedItem();
        if (selected == null) {
            return;
        }
        installation.getInfo().removeAuthor(selected);
        AuthorDialog dlg = new AuthorDialog(this, selected);
        dlg.setAlwaysOnTop(true);
        dlg.addWindowFocusListener(_authorListener);
        dlg.setVisible(true);
    }//GEN-LAST:event_btn_editAuthor_pressed

    private void tf_url_focuslost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_url_focuslost
        if (!tf_url.getText().isEmpty()) {
            installation.getInfo().setURL(tf_url.getText());
        }
    }//GEN-LAST:event_tf_url_focuslost

    private void cb_runPrivilaged_statechanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_runPrivilaged_statechanged
        installation.getInfo().setRunPrivilaged(cb_runPrivilaged.isSelected());
    }//GEN-LAST:event_cb_runPrivilaged_statechanged

    private void tf_width_focuslost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_width_focuslost
        // TODO : Insert Integer cast try catch
        if (!tf_width.getText().isEmpty()) {
            installation.getGuiPrefs().setWidth(Integer.parseInt(tf_width.getText()));
        }
    }//GEN-LAST:event_tf_width_focuslost

    private void tf_height_focuslost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_height_focuslost
        // TODO : Insert Integer cast try catch
        if (!tf_height.getText().isEmpty()) {
            installation.getGuiPrefs().setHeight(Integer.parseInt(tf_height.getText()));
        }
    }//GEN-LAST:event_tf_height_focuslost

    private void tf_labelGap_focuslost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_labelGap_focuslost
        if (!tf_labelGap.getText().isEmpty()) {
            Modifier labelGap = (Modifier)installation.getGuiPrefs().getModifierByKey("labelGap");
            if (labelGap == null) { 
                labelGap = new Modifier();
                labelGap.setKey("labelGap");
            } else {
                installation.getGuiPrefs().removeModifier(labelGap);
            }
            labelGap.setValue(tf_labelGap.getText());
            installation.getGuiPrefs().addModifier(labelGap);
        }
    }//GEN-LAST:event_tf_labelGap_focuslost

    private void cb_resizable_statechanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_resizable_statechanged
        installation.getGuiPrefs().setResizable(cb_resizable.isSelected());
    }//GEN-LAST:event_cb_resizable_statechanged

    private void cb_useButtonIcons_statechanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_useButtonIcons_statechanged
        Modifier useButtonIcons = installation.getGuiPrefs().getModifierByKey("useButtonIcons");
        if (useButtonIcons == null) { 
            useButtonIcons = new Modifier();
            useButtonIcons.setKey("useButtonIcons");
        } else {
            installation.getGuiPrefs().removeModifier(useButtonIcons);
        }
        useButtonIcons.setValue(cb_useButtonIcons.isSelected()?"yes":"no");
        installation.getGuiPrefs().addModifier(useButtonIcons);
    }//GEN-LAST:event_cb_useButtonIcons_statechanged

    private void cb_useLabelIcons_statechanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_useLabelIcons_statechanged
        Modifier useLabelIcons = installation.getGuiPrefs().getModifierByKey("useLabelIcons");
        if (useLabelIcons == null) { 
            useLabelIcons = new Modifier();
            useLabelIcons.setKey("useLabelIcons");
        } else {
            installation.getGuiPrefs().removeModifier(useLabelIcons);
        }
        useLabelIcons.setValue(cb_useLabelIcons.isSelected()?"yes":"no");
        installation.getGuiPrefs().addModifier(useLabelIcons);
    }//GEN-LAST:event_cb_useLabelIcons_statechanged

    private void btn_addLang_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addLang_pressed
        List<LangPack> languages = lst_langs.getSelectedValuesList();
        if (languages.isEmpty()) {
            return;
        }
        for (LangPack itr : languages) {
            installation.getLocale().addLangPack(itr);
            ((DefaultListModel<LangPack>)(lst_selectedLangs.getModel())).addElement(itr);
            ((DefaultListModel<LangPack>)(lst_langs.getModel())).removeElement(itr);
        }
    }//GEN-LAST:event_btn_addLang_pressed

    private void btn_removeLang_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeLang_pressed
        List<LangPack> languages = lst_selectedLangs.getSelectedValuesList();
        if (languages.isEmpty()) {
            return;
        }
        for (LangPack itr : languages) {
            installation.getLocale().removeLangPack(itr);
            ((DefaultListModel<LangPack>)(lst_langs.getModel())).addElement(itr);
            ((DefaultListModel<LangPack>)(lst_selectedLangs.getModel())).removeElement(itr);
        }
    }//GEN-LAST:event_btn_removeLang_pressed

    private void btn_addResource_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addResource_pressed
        ResourceDialog dlg = new ResourceDialog(this, null);
        dlg.setAlwaysOnTop(true);
        dlg.addWindowFocusListener(_resourceListener);
        dlg.setVisible(true); 
    }//GEN-LAST:event_btn_addResource_pressed

    private void btn_editResource_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editResource_pressed
        List<Resource> selected = lst_res.getSelectedValuesList();
        if (selected.isEmpty()) {
            return;
        }
        if (selected.size() > 1) {
            JOptionPane.showMessageDialog(null, "Please chose only one item at the same time.", "Multiple selection!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        installation.getResources().removeResource(selected.get(0));
        ResourceDialog dlg = new ResourceDialog(this, selected.get(0));
        dlg.setAlwaysOnTop(true);
        dlg.addWindowFocusListener(_resourceListener);
        dlg.setVisible(true); 
    }//GEN-LAST:event_btn_editResource_pressed

    private void btn_delResource_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delResource_pressed
        List<Resource> selected = lst_res.getSelectedValuesList();
        if (selected.isEmpty()) {
            return;
        }
        for (Resource itr : selected) {
            installation.getResources().removeResource(itr);
            ((DefaultListModel<Resource>)lst_res.getModel()).removeElement(itr);
        }
    }//GEN-LAST:event_btn_delResource_pressed

    private void btn_addJar_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addJar_pressed
        JarDialog dlg = new JarDialog(this, null);
        dlg.setAlwaysOnTop(true);
        dlg.addWindowFocusListener(_jarListener);
        dlg.setVisible(true); 
    }//GEN-LAST:event_btn_addJar_pressed

    private void btn_editJar_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editJar_pressed
        List<Jar> selected = lst_jars.getSelectedValuesList();
        if (selected.isEmpty()) {
            return;
        }
        if (selected.size() > 1) {
            JOptionPane.showMessageDialog(null, "Please chose only one item at the same time.", "Multiple selection!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        installation.removeJar(selected.get(0));
        JarDialog dlg = new JarDialog(this, selected.get(0));
        dlg.setAlwaysOnTop(true);
        dlg.addWindowFocusListener(_jarListener);
        dlg.setVisible(true); 
    }//GEN-LAST:event_btn_editJar_pressed

    private void btn_delJar_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delJar_pressed
        List<Jar> selected = lst_jars.getSelectedValuesList();
        if (selected.isEmpty()) {
            return;
        }
        for (Jar itr : selected) {
            installation.removeJar(itr);
            ((DefaultListModel<Jar>)lst_jars.getModel()).removeElement(itr);
        }
    }//GEN-LAST:event_btn_delJar_pressed

    private void btn_addPackorFile_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addPackorFile_pressed
        // Get selected object
        if (tree_packs.getSelectionPaths() == null) {
            return;
        }
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)tree_packs.getSelectionPaths()[0].getLastPathComponent();
        Object selected = selectedNode.getUserObject();
        if (selected.toString().equals("packs")) {
            PackDialog dlg = new PackDialog(this, null);
            dlg.setAlwaysOnTop(true);
            dlg.addWindowFocusListener(_packListener);
            dlg.setVisible(true); 
        } else if (selectedNode.getParent().toString().equals("packs")) {
            installation.getPacks().removePack((Pack)selected);
            FileDialog dlg = new FileDialog(this, (Pack)selected, null);
            dlg.setAlwaysOnTop(true);
            dlg.addWindowFocusListener(_packListener);
            dlg.setVisible(true); 
        }
        
    }//GEN-LAST:event_btn_addPackorFile_pressed

    private void btn_editPackorFile_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editPackorFile_pressed
        // Get selected object
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)tree_packs.getSelectionPaths()[0].getLastPathComponent();
        if (selectedNode == null) {
            return;
        }
        Object selected = selectedNode.getUserObject();
        if (selected instanceof Pack) {
            installation.getPacks().removePack((Pack)selected);
            PackDialog dlg = new PackDialog(this, (Pack)selected);
            dlg.setAlwaysOnTop(true);
            dlg.addWindowFocusListener(_packListener);
            dlg.setVisible(true); 
        } else if (selected instanceof File) {
            Pack parentPack = (Pack)((DefaultMutableTreeNode)selectedNode.getParent()).getUserObject();
            installation.getPacks().removePack(parentPack);
            parentPack.removeFile((File)selected);
            FileDialog dlg = new FileDialog(this, parentPack, (File)selected);
            dlg.setAlwaysOnTop(true);
            dlg.addWindowFocusListener(_packListener);
            dlg.setVisible(true); 
        }
    }//GEN-LAST:event_btn_editPackorFile_pressed

    private void cmb_reboot_statechanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_reboot_statechanged
        installation.getInfo().setRebootAction(cb_rebootOption.getSelectedItem().toString());                
    }//GEN-LAST:event_cmb_reboot_statechanged

    private void btn_out_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_out_pressed
        JFileChooser dlg_outputFileChooser = new JFileChooser();
        dlg_outputFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (dlg_outputFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                System.out.println(dlg_outputFileChooser.getSelectedFile().getAbsolutePath());
                _fileName = dlg_outputFileChooser.getSelectedFile().getAbsolutePath() + "\\install.xml";
        }
    }//GEN-LAST:event_btn_out_pressed

    private void btn_lock_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lock_pressed
        if (_fileName == null) {
            return;
        }
        btn_gen.setEnabled(!btn_gen.isEnabled());
        if (btn_gen.isEnabled() == true) {
            btn_lock.setBackground(Color.green);
            btn_gen.setBackground(Color.green);
        } else {
            btn_lock.setBackground(Color.yellow);
            btn_gen.setBackground(Color.yellow);
        }
        
        //If needed all focus lost
    }//GEN-LAST:event_btn_lock_pressed

    private void btn_delPackorFile_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delPackorFile_pressed
        // Get selected object
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)tree_packs.getSelectionPaths()[0].getLastPathComponent();
        if (selectedNode == null) {
            return;
        }
        Object selected = selectedNode.getUserObject();
        if (selected instanceof Pack) {
            installation.getPacks().removePack((Pack)selected);
        } else if (selected instanceof File) {
            Pack parentPack = (Pack)((DefaultMutableTreeNode)selectedNode.getParent()).getUserObject();
            installation.getPacks().removePack(parentPack);
            parentPack.removeFile((File)selected);
            installation.getPacks().addPack(parentPack);
        }
        populateTreePacks();
    }//GEN-LAST:event_btn_delPackorFile_pressed

    private void btn_addPanel_pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addPanel_pressed
        List<Panel> panels = lst_aPanels.getSelectedValuesList();
        if (panels.isEmpty()) {
            return;
        }
        for (Panel itr : panels) {
            installation.getPanels().addPanel(itr);
            ((DefaultListModel<Panel>)(lst_used.getModel())).addElement(itr);
            ((DefaultListModel<Panel>)(lst_aPanels.getModel())).removeElement(itr);
        }
    }//GEN-LAST:event_btn_addPanel_pressed

    private void btn_removePanel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removePanel
        List<Panel> panels = lst_used.getSelectedValuesList();
        if (panels.isEmpty()) {
            return;
        }
        for (Panel itr : panels) {
            installation.getPanels().removePanel(itr);
            ((DefaultListModel<Panel>)(lst_aPanels.getModel())).addElement(itr);
            ((DefaultListModel<Panel>)(lst_used.getModel())).removeElement(itr);
        }
    }//GEN-LAST:event_btn_removePanel

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addAuthor;
    private javax.swing.JButton btn_addJar;
    private javax.swing.JButton btn_addLang;
    private javax.swing.JButton btn_addPackorFile;
    private javax.swing.JButton btn_addPanel;
    private javax.swing.JButton btn_addResource;
    private javax.swing.JButton btn_delAuthor;
    private javax.swing.JButton btn_delJar;
    private javax.swing.JButton btn_delPackorFile;
    private javax.swing.JButton btn_delPanel;
    private javax.swing.JButton btn_delResource;
    private javax.swing.JButton btn_editAuthor;
    private javax.swing.JButton btn_editJar;
    private javax.swing.JButton btn_editPackorFile;
    private javax.swing.JButton btn_editPanel;
    private javax.swing.JButton btn_editResource;
    private javax.swing.JButton btn_gen;
    private javax.swing.JButton btn_left;
    private javax.swing.JButton btn_lock;
    private javax.swing.JButton btn_out;
    private javax.swing.JButton btn_removeLang;
    private javax.swing.JButton btn_right;
    private javax.swing.JComboBox cb_authors;
    private javax.swing.JComboBox cb_rebootOption;
    private javax.swing.JCheckBox cb_resizable;
    private javax.swing.JCheckBox cb_runPrivilaged;
    private javax.swing.JCheckBox cb_useButtonIcons;
    private javax.swing.JCheckBox cb_useLabelIcons;
    private javax.swing.JPanel cmb_reboot;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel lbl_applicationName;
    private javax.swing.JLabel lbl_authors;
    private javax.swing.JLabel lbl_avilable;
    private javax.swing.JLabel lbl_gen;
    private javax.swing.JLabel lbl_jars;
    private javax.swing.JLabel lbl_labelGap;
    private javax.swing.JLabel lbl_lang;
    private javax.swing.JLabel lbl_langs;
    private javax.swing.JLabel lbl_lock;
    private javax.swing.JLabel lbl_out;
    private javax.swing.JLabel lbl_packs;
    private javax.swing.JLabel lbl_panels;
    private javax.swing.JLabel lbl_rebootOption;
    private javax.swing.JLabel lbl_res;
    private javax.swing.JLabel lbl_selectedLangs;
    private javax.swing.JLabel lbl_size;
    private javax.swing.JLabel lbl_url;
    private javax.swing.JLabel lbl_used;
    private javax.swing.JLabel lbl_version;
    private javax.swing.JLabel lbl_x;
    private javax.swing.JList lst_aPanels;
    private javax.swing.JList lst_jars;
    private javax.swing.JList lst_langs;
    private javax.swing.JList lst_res;
    private javax.swing.JList lst_selectedLangs;
    private javax.swing.JList lst_used;
    private javax.swing.JPanel pnl_gen;
    private javax.swing.JPanel pnl_gui;
    private javax.swing.JPanel pnl_jars;
    private javax.swing.JPanel pnl_lang;
    private javax.swing.JPanel pnl_packs;
    private javax.swing.JPanel pnl_panels;
    private javax.swing.JPanel pnl_resources;
    private javax.swing.JScrollPane sp_aPanels;
    private javax.swing.JScrollPane sp_jars;
    private javax.swing.JScrollPane sp_langs;
    private javax.swing.JScrollPane sp_packs;
    private javax.swing.JScrollPane sp_res;
    private javax.swing.JScrollPane sp_selectedLangs;
    private javax.swing.JScrollPane sp_used;
    private javax.swing.JTextField tf_applicationName;
    private javax.swing.JTextField tf_height;
    private javax.swing.JTextField tf_labelGap;
    private javax.swing.JTextField tf_url;
    private javax.swing.JTextField tf_version;
    private javax.swing.JTextField tf_width;
    private javax.swing.JTabbedPane tpnl_mainTabbedPanel;
    private javax.swing.JTree tree_packs;
    // End of variables declaration//GEN-END:variables
}