/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.gui;

import br.com.acme.model.AcademicLibrary;
import br.com.acme.model.Author;
import br.com.acme.model.Book;
import br.com.acme.model.Publication;
import com.acme.logic.ALManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author hibiscus
 */
public class ListBooksForm extends javax.swing.JDialog {

    private AcademicLibrary library;

    /**
     * Creates new form ListBooksForm
     */
    public ListBooksForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        library = ALManager.getInstance();

        populateTable();
    }

    private void populateTable() {
        jlTotal.setText(String.valueOf(library.countBooks()));

        TableModel model = jtBookList.getModel();

        ArrayList<Publication> publications = library.getAllPublications();

        int line = 0;
        for (Publication p : publications) {
            if (p instanceof Book) {
                Book b = (Book) p;
                model.setValueAt(b.getTitle(), line, 0);

                List<Author> authors = b.getAuthors();
                String names = "";
                for (Author a : authors) {
                    names = names + a.getName() + ", ";
                }

                model.setValueAt(names, line, 1);

                model.setValueAt(b.getYear(), line, 2);
                model.setValueAt(b.getVolume(), line, 3);
                model.setValueAt(b.getLanguage(), line, 4);
                model.setValueAt(b.getIsbn(), line, 5);
                model.setValueAt(b.getPages(), line, 6);
                line++;
            }
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

        jLabel1 = new javax.swing.JLabel();
        jspBookList = new javax.swing.JScrollPane();
        jtBookList = new javax.swing.JTable();
        jbClose = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jlTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("List of Books");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Books in your library");

        jtBookList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title", "Authors", "Year", "Volume", "Language", "ISBN", "Number of Pages"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Short.class, java.lang.Byte.class, java.lang.Object.class, java.lang.Long.class, java.lang.Short.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspBookList.setViewportView(jtBookList);

        jbClose.setText("Close");
        jbClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCloseActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Total:");

        jlTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(281, 281, 281))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspBookList, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addComponent(jbClose, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jspBookList, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbClose)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(754, 372));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCloseActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jbCloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbClose;
    private javax.swing.JLabel jlTotal;
    private javax.swing.JScrollPane jspBookList;
    private javax.swing.JTable jtBookList;
    // End of variables declaration//GEN-END:variables
}