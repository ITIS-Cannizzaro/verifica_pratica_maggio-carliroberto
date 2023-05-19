import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Frame extends JFrame implements ActionListener {
	
	//Oggetti Primo Frame:

    JLabel n = new JLabel("Inserisci Numero: ");
    JTextArea num = new JTextArea();
    JButton add = new JButton("AGGIUNGI");
    JLabel ord = new JLabel("ArrayList Ordinato: ");
    JTextArea ordinato = new JTextArea();
    JButton vis = new JButton("VISUALIZZA");
    JButton rimuovi = new JButton("RIMUOVI NUMERO");
    ArrayList <Integer> array = new ArrayList<Integer>();
    
    //Oggetti Secondo Frame:
    
    JFrame remove = new JFrame("Rimuovi Numero Array");
    JLabel numRem = new JLabel("Inserisci Numero: ");
    JLabel agg = new JLabel("ArrayList Aggiornato: ");
    JTextArea numRemove = new JTextArea();
    JTextArea ris = new JTextArea();
    JButton update = new JButton("AGGIORNA ARRAY");

    public Frame(){
    	
    	//Creazione Primo Frame aggiungi e ordina:
    	
        super("Ordinamento Array");
        
        Container c = this.getContentPane();
        c.setLayout(null);

        c.add(n);
        n.setBounds(15,17,170, 20);

        c.add(num);
        num.setBounds(135, 17, 170, 20);

        c.add(add);
        add.setBounds(315,15,150,25);
        add.addActionListener(e -> aggiungi());

        c.add(ord);
        ord.setBounds(15,70,170, 20);

        c.add(ordinato);
        ordinato.setBounds(135, 70, 170, 20);

        c.add(vis);
        vis.setBounds(315,68,150,25);
        vis.addActionListener(e -> visualizza());

        c.add(rimuovi);
        rimuovi.setBounds(145,110,150,25);
        rimuovi.addActionListener(e -> delete());

        setSize(500, 200);
        setVisible(true);
        setResizable(false);
        
        //Creazione Secondo Frame per il rimuovi:

        remove.setSize(500, 150);
        remove.setResizable(false);
        remove.setLayout(new FlowLayout());

        remove.add(numRem);
        numRem.setPreferredSize(new Dimension(150, 20));

        remove.add(numRemove);
        numRemove.setPreferredSize(new Dimension(150, 20));

        remove.add(update);
        update.setPreferredSize(new Dimension(350, 20));
        update.addActionListener(e ->aggiorna());

        remove.add(agg);
        agg.setPreferredSize(new Dimension(150, 20));

        remove.add(ris);
        ris.setPreferredSize(new Dimension(150, 20));
    }
    
    //Metodo aggiungi numeri all'arrayList:

    public void aggiungi(){
        int numero = Integer.parseInt(num.getText());
        array.add(numero);
        num.setText("");
    }
    
    //Metodo ordinamento dell'arrayList:

    public void visualizza(){
        int max = 0;
        for(int x=0; x<array.size(); x++){
            for (int y=0; y<array.size()-1; y++){
                if(array.get(y)>array.get(y+1)){
                    max=array.get(y);
                    array.set(y, array.get(y+1));
                    array.set(y+1, max);
                }
            }
        }
        ordinato.setText(""+array);
        ordinato.setEditable(false);
    }
    
    //Metodo per aprire il nuovo frame: 

    public void delete(){
        remove.setVisible(true);
    }
    
    //Metodo per rimuovere e aggiornare l'arrayList:

    public void aggiorna(){
        int n = Integer.parseInt(numRemove.getText());
        for(int i=0; i<array.size(); i++){
            if(n==array.get(i)){
                array.remove(i);
                ris.setText(""+array);
            }
        }
        numRemove.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            aggiungi();
        }
        if(e.getSource()==vis){
            visualizza();
        }
        if(e.getSource()==rimuovi){
            delete();
        }
        if(e.getSource()==update){
            aggiorna();
        }
    }
}
