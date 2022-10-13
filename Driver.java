import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class Driver extends javax.swing.JFrame
{
    GameTimer temp = new GameTimer();
    public ArrayList<block> mines = new ArrayList<>();
    public int COLUMNS;
    public int ROWS;
    public int win;
    public int need;
    
    public Driver()
    {
        initComponents();
        info.setVisible(false);
        grid.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        input = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        start = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        info = new javax.swing.JPanel();
        Tag1 = new javax.swing.JLabel();
        Tag2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        grid = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mine Sweeper");
        setName("MineSweeper"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        input.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("COLUMNS:");

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("ROWS:");

        start.setBackground(new java.awt.Color(204, 204, 204));
        start.setText("Start");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartGame(evt);
            }
        });

        javax.swing.GroupLayout inputLayout = new javax.swing.GroupLayout(input);
        input.setLayout(inputLayout);
        inputLayout.setHorizontalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputLayout.createSequentialGroup()
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36))
                    .addGroup(inputLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(15, 15, 15)))
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jSpinner1))
                .addGap(18, 18, 18)
                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        inputLayout.setVerticalGroup(
            inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(inputLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(start)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        info.setBackground(new java.awt.Color(255, 255, 255));

        Tag1.setForeground(new java.awt.Color(0, 0, 0));
        Tag1.setText("Bombs:");

        Tag2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Time:");

        time.setForeground(new java.awt.Color(0, 0, 0));
        time.setText("0");

        javax.swing.GroupLayout infoLayout = new javax.swing.GroupLayout(info);
        info.setLayout(infoLayout);
        infoLayout.setHorizontalGroup(
            infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoLayout.createSequentialGroup()
                        .addComponent(Tag1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tag2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(infoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        infoLayout.setVerticalGroup(
            infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoLayout.createSequentialGroup()
                .addGroup(infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tag1)
                    .addComponent(Tag2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(262, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        grid.setBackground(new java.awt.Color(255, 255, 255));
        grid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        grid.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(grid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grid, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartGame(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartGame
        
        if((Integer)jSpinner2.getValue() == 0 || (Integer)jSpinner1.getValue() == 0)
        {
            JOptionPane.showMessageDialog(null, "Cannot be 0", "Input Error",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            COLUMNS = (Integer)jSpinner2.getValue();
            ROWS = (Integer)jSpinner1.getValue();
            grid.setLayout(new GridLayout(ROWS, COLUMNS));

            for(int i=0;i<ROWS*COLUMNS;i++)
            {
                mines.add(new block());
                mines.get(i).getButton().setBackground(new Color(175, 175, 175));

                mines.get(i).getButton().addMouseListener(new MouseAdapter(){
                                        public void mouseClicked(MouseEvent e)
                                        {
                                            if (e.getButton() == MouseEvent.BUTTON3)
                                            {
                                                TestFlag(e);
                                            }
                                            if (e.getButton() == MouseEvent.BUTTON1)
                                            {
                                                TestBlock(e);
                                            }
                                        }
                });

                mines.get(i).setIndex(i);
                if(i < COLUMNS)
                {
                    mines.get(i).setBorder(true);
                }
                if(i%COLUMNS == 0 || i%COLUMNS == (COLUMNS-1))
                {
                    mines.get(i).setBorder(true);
                }
                if(i >=ROWS*(COLUMNS-1))
                {
                    mines.get(i).setBorder(true);
                }

                grid.add(mines.get(i).getButton());
                grid.repaint();
                grid.revalidate();
            }
            grid.setVisible(true);
            AddBombs();
            CalculateNeighbors();
            
            need = ((COLUMNS*ROWS)-Integer.parseInt(Tag2.getText()));

            input.setVisible(false);
            info.setVisible(true);
            temp.execute();
        }
    }//GEN-LAST:event_StartGame
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Driver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Driver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Driver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Driver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Driver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Tag1;
    private javax.swing.JLabel Tag2;
    private javax.swing.JPanel grid;
    private javax.swing.JPanel info;
    private javax.swing.JPanel input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JButton start;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables

    public void AddBombs()
    {
        int bombs = (int)(Math.random() * ((ROWS - 5) + 1)) + 5;
        
        Random r = new Random();
        
        for(int i=0;i<bombs;i++)
        {
            int index = r.nextInt((((COLUMNS*ROWS)-1) - 0) + 1) + 0;
            mines.get(index).setBomb(true);
            //mines.get(index).getButton().setText("B");
        }
        int count= 0;
        for(int i = 0; i<mines.size();i++)
        {
            if(mines.get(i).getBomb())
                count++;
        }
        Tag2.setText(Integer.toString(count));
    }
    
    public void CalculateNeighbors()
    {
        int count;
        for(int i=0;i<mines.size();i++)
        {
            count = 0;
            if(mines.get(i).getBomb())                                          //IS A BOMB
                ;                                                               
            else                                                                //NOT A BOMB
            {
                if(mines.get(i).getIndex() < COLUMNS)                           //FIRST ROW
                {
                    if(mines.get(i).getIndex() == 0)                            
                    {
                        if(mines.get(i+1).getBomb())
                            count++;
                        if(mines.get(i+COLUMNS).getBomb())
                            count++;
                        if(mines.get(i+COLUMNS+1).getBomb())
                            count++;
                        mines.get(i).setAround(count);
                    }
                    else if(mines.get(i).getIndex() == COLUMNS-1)               
                    {
                        if(mines.get(i-1).getBomb())
                            count++;
                        if(mines.get(i+COLUMNS).getBomb())
                            count++;
                        if(mines.get(i+COLUMNS-1).getBomb())
                            count++;
                        mines.get(i).setAround(count);
                    }
                    else                                                        
                    {
                        if(mines.get(i-1).getBomb())
                            count++;
                        if(mines.get(i+1).getBomb())
                            count++;
                        if(mines.get(i+COLUMNS).getBomb())
                            count++;
                        if(mines.get(i+COLUMNS-1).getBomb())
                            count++;
                        if(mines.get(i+COLUMNS+1).getBomb())
                            count++;
                        mines.get(i).setAround(count);
                    }
                }
                else if(mines.get(i).getIndex()%COLUMNS == 0)                   //FIRST COLUMN
                {
                    if(mines.get(i).getIndex() == 0)                            
                        ;
                    else if(mines.get(i).getIndex() == COLUMNS*(ROWS-1))        
                    {
                        if(mines.get(i+1).getBomb())
                            count++;
                        if(mines.get(i-COLUMNS).getBomb())
                            count++;
                        if(mines.get(i-COLUMNS+1).getBomb())
                            count++;
                        mines.get(i).setAround(count);
                    }
                    else                                                        
                    {
                        if(mines.get(i-COLUMNS).getBomb())
                            count++;
                        if(mines.get(i-COLUMNS+1).getBomb())
                            count++;
                        if(mines.get(i+1).getBomb())
                            count++;
                        if(mines.get(i+COLUMNS).getBomb())
                            count++;
                        if(mines.get(i+COLUMNS+1).getBomb())
                            count++;
                        mines.get(i).setAround(count);
                    }
                }
                else if(mines.get(i).getIndex()%COLUMNS == (COLUMNS-1))         //LAST COLUMN
                {
                    if(mines.get(i).getIndex() == COLUMNS-1)                    
                        ;
                    else if(mines.get(i).getIndex() == (COLUMNS*ROWS)-1)
                    {
                        if(mines.get(i-1).getBomb())
                            count++;
                        if(mines.get(i-COLUMNS).getBomb())
                            count++;
                        if(mines.get(i-COLUMNS-1).getBomb())
                            count++;
                        mines.get(i).setAround(count);
                    }
                    else
                    {
                        if(mines.get(i-COLUMNS).getBomb())
                            count++;
                        if(mines.get(i-COLUMNS-1).getBomb())
                            count++;
                        if(mines.get(i-1).getBomb())
                            count++;
                        if(mines.get(i+COLUMNS-1).getBomb())
                            count++;
                        if(mines.get(i+COLUMNS).getBomb())
                            count++;
                        mines.get(i).setAround(count);
                    }
                }
                else if(mines.get(i).getIndex() > COLUMNS*(ROWS-1))
                {
                    if(mines.get(i).getIndex() == (COLUMNS*ROWS)-1)
                        ;
                    else
                    {
                        if(mines.get(i-1).getBomb())
                            count++;
                        if(mines.get(i-COLUMNS-1).getBomb())
                            count++;
                        if(mines.get(i-COLUMNS).getBomb())
                            count++;
                        if(mines.get(i-COLUMNS+1).getBomb())
                            count++;
                        if(mines.get(i+1).getBomb())
                            count++;
                        mines.get(i).setAround(count);
                    }
                }
                else
                {
                    if(mines.get(i-COLUMNS-1).getBomb())
                        count++;
                    if(mines.get(i-COLUMNS).getBomb())
                        count++;
                    if(mines.get(i-COLUMNS+1).getBomb())
                        count++;
                    if(mines.get(i+1).getBomb())
                        count++;
                    if(mines.get(i+COLUMNS+1).getBomb())
                        count++;
                    if(mines.get(i+COLUMNS).getBomb())
                        count++;
                    if(mines.get(i+COLUMNS-1).getBomb())
                        count++;
                    if(mines.get(i-1).getBomb())
                        count++;
                    mines.get(i).setAround(count);
                }
                //mines.get(i).getButton().setText(""+count);
            }
        }
    }
    
    public void TestFlag(MouseEvent e)
    {
        for(int i=0;i<mines.size();i++)
        {
            if(mines.get(i).getButton() == e.getSource())
            {
                if(mines.get(i).getFlaged())
                    ;
                else if(mines.get(i).getButton().getText().compareTo("") == 0)
                    mines.get(i).getButton().setText("!");
                else
                    mines.get(i).getButton().setText("");
            }
        }
    }
    
    public void TestBlock(MouseEvent e)
    {
        for(int i=0;i<mines.size();i++)
        {
            if(mines.get(i).getButton() == e.getSource())
            {
                if(mines.get(i).getBomb())
                {
                    RevealAll();
                    JOptionPane.showMessageDialog(null, "Failed", "Failed", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                else
                {
                    if(!mines.get(i).getFlaged())
                    {
                        mines.get(i).getButton().setBackground(new Color(239, 239, 239));
                        mines.get(i).getButton().setText(""+mines.get(i).getAround());
                        mines.get(i).getButton().setForeground(TextColor(mines.get(i).getAround()));
                        mines.get(i).setFlaged(true);
                        win++;
                        if(win == need)
                        {
                            temp.cancel(true);
                            JOptionPane.showMessageDialog(null, "Won in "+time.getText()+" seconds!", "WON", JOptionPane.PLAIN_MESSAGE);
                            System.exit(0); 
                        }
                    }
                }
            }
        }
    }
    
    public void RevealAll()
    {
        for(int i=0;i<mines.size();i++)
        {
            if(mines.get(i).getBomb())
                mines.get(i).getButton().setText("B");
            else
            {
                mines.get(i).getButton().setBackground(new Color(226, 226, 226));
                mines.get(i).getButton().setText(""+mines.get(i).getAround());
                mines.get(i).getButton().setForeground(TextColor(mines.get(i).getAround()));
            }
        }
    }
    
    public Color TextColor(int val)
    {
        switch(val)
        {
            case 1: 
                return new Color(224, 83, 188);
            case 2: 
                return new Color(160, 83, 224);
            case 3: 
                return new Color(83, 137, 224);
            case 4: 
                return new Color(83, 224, 193);
            case 5: 
                return new Color(106, 224, 83);
            case 6: 
                return new Color(226, 209, 47);
            case 7: 
                return new Color(234, 152, 37);
            case 8: 
                return new Color(206, 78, 78);
            case 0: 
                return new Color(71, 59, 68);    
        }
        return new Color(211, 211, 211);
    }
    
    public class GameTimer extends SwingWorker<Void,Void>
    {   
        @Override
        public Void doInBackground()
        {
            long startTime = System.currentTimeMillis();
            long elapsedTime;
            int i = 0;
            while(i == 0)
            {
                elapsedTime = (new Date()).getTime() - startTime;
                time.setText(Long.toString(elapsedTime/1000));
                
                if(this.isCancelled())
                    break;
            }
            this.cancel(false);
            return null;
        }
        @Override
        public void done()
        {
            
        }
    }
}