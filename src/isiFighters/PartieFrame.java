package isiFighters;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class PartieFrame extends JFrame{
	
	static public Partie p = new Partie();
	
	public PartieFrame(){
		
		this.setTitle("ISI Fighters - Partie");		
		
		this.setSize(750, 600);		
		this.setVisible(true);				
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(196, 0, 4));
		contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setContentPane(contentPanel);
		
		JPanel playingPanel = new JPanel();
		playingPanel.setLayout(new GridLayout(1, 2));
		
		///////////////////////////////////// Computer
		JPanel computerPart = new JPanel();
		computerPart.setBorder(BorderFactory.createTitledBorder("Ordinateur"));	
		computerPart.setLayout(new BorderLayout());
		
		JPanel progessC = new JPanel();
		progessC.setLayout(new GridLayout(2, 1));
		
		final JProgressBar vieC =new JProgressBar(0, Jeu.params.getNbMaxPtVie());
		vieC.setValue(Jeu.params.getNbMaxPtVie());
		vieC.setStringPainted(true);
		final JProgressBar energieC =new JProgressBar(0, Jeu.params.getNbMaxPtEnergie());
		energieC.setValue(Jeu.params.getNbMaxPtVie());
		energieC.setStringPainted(true);
		
		progessC.add(vieC);
		progessC.add(energieC);
		
		computerPart.add(progessC, BorderLayout.NORTH);
		
		try {
			BufferedImage paramsIcon = ImageIO.read(new File("src/computer.jpeg"));
			ImageIcon img = new ImageIcon(paramsIcon.getScaledInstance(300, 500, java.awt.Image.SCALE_SMOOTH));
			JLabel compLabel = new JLabel(img);	
			computerPart.setBackground(new Color(255, 255, 255));
			computerPart.add(compLabel);
		}catch (IOException e){}
		
		////////////////////////////////////// PLayer
		JPanel humanPart = new JPanel();
		humanPart.setBorder(BorderFactory.createTitledBorder("Vous"));	
		humanPart.setLayout(new BorderLayout());		
		
		JPanel progress = new JPanel();
		progress.setLayout(new GridLayout(2, 1));
		
		final JProgressBar vieH =new JProgressBar(0, Jeu.params.getNbMaxPtVie());
		vieH.setValue(Jeu.params.getNbMaxPtVie());
		vieH.setStringPainted(true);
		final JProgressBar energieH =new JProgressBar(0, Jeu.params.getNbMaxPtEnergie());
		energieH.setValue(Jeu.params.getNbMaxPtVie());
		energieH.setStringPainted(true);;
		
		progress.add(vieH);
		progress.add(energieH);
		
		humanPart.add(progress, BorderLayout.NORTH);
		
		JPanel imgCmd = new JPanel();
		imgCmd.setLayout(new GridLayout(2, 1));
		imgCmd.setBackground(new Color(255, 255, 255));
		try {
			BufferedImage paramsIcon = ImageIO.read(new File("src/human.jpg"));
			ImageIcon img = new ImageIcon(paramsIcon.getScaledInstance(175, 300, java.awt.Image.SCALE_SMOOTH));
			JLabel humanLabel = new JLabel(img);			
			imgCmd.add(humanLabel);
		}catch (IOException e){}
					
		try {
			/////comandes
			JPanel coms = new JPanel();
			coms.setLayout(new GridLayout(3, 3));
			JButton bloqueHaut = createButton("src/bTete.png", KeyEvent.VK_NUMPAD1);
			bloqueHaut.addActionListener(buttonAction(1, energieH, vieH, energieC, vieC));
			JButton esquiveBas = createButton("src/eTete.png", KeyEvent.VK_NUMPAD2);
			esquiveBas.addActionListener(buttonAction(2, energieH, vieH, energieC, vieC));
			JButton attaqueHaut = createButton("src/aTete.png", KeyEvent.VK_NUMPAD3);
			attaqueHaut.addActionListener(buttonAction(3, energieH, vieH, energieC, vieC));
			JButton bloqueAbdomen = createButton("src/bAbdomen.png", KeyEvent.VK_NUMPAD4);
			bloqueAbdomen.addActionListener(buttonAction(4, energieH, vieH, energieC, vieC));
			JButton concentration = createButton("src/concentration.png", KeyEvent.VK_NUMPAD5);
			concentration.addActionListener(buttonAction(5, energieH, vieH, energieC, vieC));
			JButton attaqueAbdomen = createButton("src/aAbdomen.png", KeyEvent.VK_NUMPAD6);
			attaqueAbdomen.addActionListener(buttonAction(6, energieH, vieH, energieC, vieC));
			JButton bloqueBas = createButton("src/bJambes.png", KeyEvent.VK_NUMPAD7);
			bloqueBas.addActionListener(buttonAction(7, energieH, vieH, energieC, vieC));
			JButton esquiveHaut = createButton("src/eJambes.png", KeyEvent.VK_NUMPAD9);
			esquiveHaut.addActionListener(buttonAction(8, energieH, vieH, energieC, vieC));
			JButton attaqueBas = createButton("src/aJambes.png", KeyEvent.VK_NUMPAD9);	
			attaqueBas.addActionListener(buttonAction(9, energieH, vieH, energieC, vieC));
			
			coms.add(bloqueHaut);
			coms.add(esquiveBas);
			coms.add(attaqueHaut);
			coms.add(bloqueAbdomen);
			coms.add(concentration);
			coms.add(attaqueAbdomen);
			coms.add(bloqueBas);
			coms.add(esquiveHaut);
			coms.add(attaqueBas);
			
			imgCmd.add(coms);
		} catch(IOException e){}
		humanPart.add(imgCmd);			
		
		playingPanel.add(humanPart);
		playingPanel.add(computerPart);
		
		this.add(playingPanel);
		
		JPanel jeuB = new JPanel();
		JButton play = new JButton("Play");
		play.setPreferredSize(new Dimension(100, 25));
		JButton restart = new JButton("Restart");
		restart.setPreferredSize(new Dimension(100, 25));
		JButton pause = new JButton("Pause");
		pause.setPreferredSize(new Dimension(100, 25));
		jeuB.add(play);
		jeuB.add(restart);
		jeuB.add(pause);
		this.add(jeuB, BorderLayout.SOUTH);
	}
	
	protected JButton createButton(String imgLink, int virtualKey) throws IOException{				
		BufferedImage paramsIcon = ImageIO.read(new File(imgLink));		
		JButton btn = new JButton(new ImageIcon(paramsIcon.getScaledInstance(80, 60, java.awt.Image.SCALE_SMOOTH)));        
        btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				
			}
		});
        //btn.setMargin(new Insets(8, 8, 8, 8));
        InputMap im = btn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = btn.getActionMap();
        im.put(KeyStroke.getKeyStroke(virtualKey, 0), "clickMe");
        am.put("clickMe", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.doClick();
            }
        });
        btn.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        btn.setBackground(new Color(255, 255, 255));
        /*btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);*/
        return btn;
	}
	
	protected ActionListener buttonAction(int action, JProgressBar eH, JProgressBar vH, JProgressBar eC, JProgressBar vC){
		return (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                    	int compAction = PartieFrame.p.getCoupComp();
                    	PartieFrame.p.action(action, compAction);
                    	eH.setValue(p.getHuman().getPtEnergie());
                    	eC.setValue(p.getComputer().getPtEnergie());
                    	vH.setValue(p.getHuman().getPtVie());
                    	vC.setValue(p.getComputer().getPtVie());
                    }
                });
            }
        });
	}
}
