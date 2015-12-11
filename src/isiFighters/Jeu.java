package isiFighters;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


public class Jeu extends JFrame{

	public static Parametres params = new Parametres();
	
	public Jeu() throws IOException{
		this.setTitle("ISI Fighters");		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		      		
		
		//set image background		
    	this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/home.jpg")))));

		//this.setLayout(new BorderLayout());
		
		//bouton pour ouvrir la fenêtre des parametres
		BufferedImage paramsIcon = ImageIO.read(new File("src/params.png"));		
		final JButton paramsButton = new JButton(new ImageIcon(paramsIcon.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH)));
		paramsButton.setOpaque(false);
		paramsButton.setContentAreaFilled(false);
		paramsButton.setBorderPainted(false);
		paramsButton.setBounds(560,20,80,80);
		paramsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(paramsButton, BorderLayout.SOUTH);

        paramsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                    	ParametresFrame j = new ParametresFrame();
                    }
                });
            }
        });

        //bouton pour lancer le jeu
		BufferedImage jeuIcon = ImageIO.read(new File("src/jouer.png"));
		final JButton jeuButton = new JButton(new ImageIcon(jeuIcon.getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH)));
		jeuButton.setOpaque(false);
		jeuButton.setContentAreaFilled(false);
		jeuButton.setBorderPainted(false);
		jeuButton.setBounds(240,400,200,100);
		jeuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(jeuButton, BorderLayout.SOUTH);

        jeuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                    	PartieFrame j = new PartieFrame();
                    }
                });
            }
        });
        

        // application des layouts
        pack();
	}
	
	
	/**
     * programme principal
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	try{
            		Jeu j = new Jeu();
                	j.setSize(680,600);
                    j.setVisible(true);
            	}catch(IOException e){}
            }
        });
    }
}
