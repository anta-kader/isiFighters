package isiFighters;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;



public class ParametresFrame extends JFrame {
		
	
	// Le nombre maximal de points de vie d’un joueur
	static private int nbMaxPtVie = Jeu.params.getNbMaxPtVie();
	
	// Le nombre maximal de points d’énergie d’un joueur
	static private int nbMaxPtEnergie = Jeu.params.getNbMaxPtEnergie();
	
	// Le dégât maximal d’un coup
	static private int degatMax = Jeu.params.getDegatMax();
	
	// Le dégât minimal d’un coup
	static private int degatMin = Jeu.params.getDegatMin();
	
	// Le coefficient d’un coup critique
	static private double coefCritique = Jeu.params.getCoefCritique();
	
	// Temps max accordé pour choisir une action
	static private int tempsMax = Jeu.params.getTempsMax();
	
	// Le nombre de points de vie que l’on gagne lorsqu’on esquive une attaque
	static private int ptEsquive = Jeu.params.getPtEsquive();
	
	// Le nombre de points d’énergie dépensés lorsque l’on fait une attaque
	static private int ptAttaque = Jeu.params.getPtAttaque();
	
	// Le nombre de points d’énergie bonus que l’on obtient lorsqu’on réussit une action 
	static private int ptBonus = Jeu.params.getPtBonus();
	
	// Le nombre de points d’énergie dépensés pour faire une action de blocage 
	static private int ptBloquage = Jeu.params.getPtBloquage();
	
	public ParametresFrame() {
		
		
		this.setTitle("ISI Fighters - Paramètres");		
		
		this.setSize(500, 600);		
		this.setVisible(true);			
					
		JPanel contentPanel = new JPanel();		
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setContentPane(contentPanel);
		
		JPanel content = new JPanel();
		content.setBorder(BorderFactory.createTitledBorder("Paramètres"));		
		content.setLayout(new GridLayout(10, 1));
		
		JPanel vieP = new JPanel();
		vieP.setLayout(new BorderLayout());
			final JLabel labelVie = new JLabel("Nombre maximal de points de vie");		
			vieP.add(labelVie, BorderLayout.WEST);		
			final JComboBox vieCB = new JComboBox();
			for (int i = 1; i <= 10; i++){
				vieCB.addItem(i*50);
			}		
			vieCB.setSelectedItem(Jeu.params.getNbMaxPtVie());	
			vieCB.addItemListener(new ItemListener() {				
				@Override
				public void itemStateChanged(ItemEvent e) {
					ParametresFrame.nbMaxPtVie = (int) vieCB.getSelectedItem();
				}
			});
			vieP.add(vieCB, BorderLayout.EAST);	
			vieP.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
		content.add(vieP);
		
		JPanel energieP = new JPanel();
		energieP.setLayout(new BorderLayout());
			final JLabel labelEnergie = new JLabel("Nombre maximal de points d'energie");		
			energieP.add(labelEnergie, BorderLayout.WEST);		
			final JComboBox energieCB = new JComboBox();
			for (int i = 1; i <= 10; i++){
				energieCB.addItem(i*50);
			}		
			energieCB.setSelectedItem(Jeu.params.getNbMaxPtEnergie());
			energieCB.addItemListener(new ItemListener() {				
				@Override
				public void itemStateChanged(ItemEvent e) {
					ParametresFrame.nbMaxPtEnergie = (int) energieCB.getSelectedItem();
				}
			});
			energieP.add(energieCB, BorderLayout.EAST);	
			energieP .setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
		content.add(energieP);
		
		JPanel bonus = new JPanel();
		bonus.setLayout(new BorderLayout());
			final JLabel labelBonus = new JLabel("Points d'énergie bonus pour une action réussie");		
			bonus.add(labelBonus, BorderLayout.WEST);		
			final JComboBox bonusCB = new JComboBox();
			for (int i = 0; i <= 10; i++){
				bonusCB.addItem(i);
			}		
			bonusCB.setSelectedItem(Jeu.params.getPtBonus());
			bonusCB.addItemListener(new ItemListener() {				
				@Override
				public void itemStateChanged(ItemEvent e) {
					ParametresFrame.ptBonus = (int) bonusCB.getSelectedItem();
				}
			});
			bonus.add(bonusCB, BorderLayout.EAST);
			bonus.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
			content.add(bonus);
		
		JPanel temps = new JPanel();
		temps.setLayout(new BorderLayout());
			final JLabel labelTemps = new JLabel("Temps accordé pour effectué une action (en secondes)");		
			temps.add(labelTemps, BorderLayout.WEST);		
			final JComboBox tempsCB = new JComboBox();
			for (int i = 1; i <= 20; i++){
				tempsCB.addItem(i);
			}		
			tempsCB.setSelectedItem(Jeu.params.getTempsMax());
			tempsCB.addItemListener(new ItemListener() {				
				@Override
				public void itemStateChanged(ItemEvent e) {
					ParametresFrame.tempsMax = (int) tempsCB.getSelectedItem();
				}
			});
			temps.add(tempsCB, BorderLayout.EAST);	
			temps.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
			content.add(temps);
		
		JPanel esquive = new JPanel();
		esquive.setLayout(new BorderLayout());
			final JLabel labelEsquive = new JLabel("Points de vue bonus gagnées pour une esquive réussite");		
			esquive.add(labelEsquive, BorderLayout.WEST);		
			final JComboBox esquiveCB = new JComboBox();
			for (int i = 0; i <= 10; i++){
				esquiveCB.addItem(i);
			}		
			esquiveCB.setSelectedIndex(Jeu.params.getPtEsquive());
			esquive.add(esquiveCB, BorderLayout.EAST);	
			esquive.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
			content.add(esquive);
		
		JPanel degMin = new JPanel();
		degMin.setLayout(new BorderLayout());
			final JLabel labelDegMin = new JLabel("Dégat minimum causé par une attaque");		
			degMin.add(labelDegMin, BorderLayout.WEST);		
			final JComboBox degMinCB = new JComboBox();
			for (int i = 1; i <= 20; i++){
				degMinCB.addItem(i);
			}		
			degMinCB.setSelectedItem(Jeu.params.getDegatMin());
			degMinCB.addItemListener(new ItemListener() {				
				@Override
				public void itemStateChanged(ItemEvent e) {
					ParametresFrame.degatMin = (int) degMinCB.getSelectedItem();
				}
			});
			degMin.add(degMinCB, BorderLayout.EAST);	
			degMin.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
			content.add(degMin);
		
		JPanel degMax = new JPanel();
		degMax.setLayout(new BorderLayout());
			final JLabel labelDegMax = new JLabel("Dégat maximum causé par une attaque");		
			degMax.add(labelDegMax, BorderLayout.WEST);		
			final JComboBox degMaxCB = new JComboBox();
			for (int i = 1; i <= 20; i++){
				degMaxCB.addItem(i);
			}		
			degMaxCB.setSelectedItem(Jeu.params.getDegatMax());
			degMaxCB.addItemListener(new ItemListener() {				
				@Override
				public void itemStateChanged(ItemEvent e) {
					ParametresFrame.degatMax = (int) degMaxCB.getSelectedItem();
				}
			});
			degMax.add(degMaxCB, BorderLayout.EAST);	
			degMax.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
			content.add(degMax);	

		JPanel coefCritique = new JPanel();
		coefCritique.setLayout(new BorderLayout());
			final JLabel labelCoefCritique = new JLabel("Coéfficient d'un coup critique");		
			coefCritique.add(labelCoefCritique, BorderLayout.WEST);		
			final JComboBox coefCritiqueCB = new JComboBox();
			for (int i = 1; i <= 10; i++){
				coefCritiqueCB.addItem(i*0.5);
			}		
			coefCritiqueCB.setSelectedItem(Jeu.params.getCoefCritique());
			coefCritiqueCB.addItemListener(new ItemListener() {				
				@Override
				public void itemStateChanged(ItemEvent e) {
					ParametresFrame.coefCritique = (double) coefCritiqueCB.getSelectedItem();
				}
			});
			coefCritique.add(coefCritiqueCB, BorderLayout.EAST);
			coefCritique.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
			content.add(coefCritique);
		
		JPanel attaque = new JPanel();
		attaque.setLayout(new BorderLayout());
			final JLabel labelCoefAttaque = new JLabel("Point d'énergie dépensées pour une attaque");		
			attaque.add(labelCoefAttaque, BorderLayout.WEST);		
			final JComboBox attaqueCB = new JComboBox();
			for (int i = 1; i <= 20; i++){
				attaqueCB.addItem(i);
			}		
			attaqueCB.setSelectedItem(Jeu.params.getPtAttaque());
			attaqueCB.addItemListener(new ItemListener() {				
				@Override
				public void itemStateChanged(ItemEvent e) {
					ParametresFrame.ptAttaque = (int) attaqueCB.getSelectedItem();
				}
			});
			attaque.add(attaqueCB, BorderLayout.EAST);		
			attaque.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
			content.add(attaque);
	
		JPanel bloquer = new JPanel();
		bloquer.setLayout(new BorderLayout());
			final JLabel labelBloquer = new JLabel("Point d'énergie dépensées pour un bloquage");		
			bloquer.add(labelBloquer, BorderLayout.WEST);		
			final JComboBox bloquerCB = new JComboBox();
			for (int i = 1; i <= 10; i++){
				bloquerCB.addItem(i);
			}		
			bloquerCB.setSelectedItem(Jeu.params.getPtBloquage());
			bloquerCB.addItemListener(new ItemListener() {				
				@Override
				public void itemStateChanged(ItemEvent e) {
					ParametresFrame.ptBloquage = (int) bloquerCB.getSelectedItem();
				}
			});
			bloquer.add(bloquerCB, BorderLayout.EAST);	
			bloquer.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
			content.add(bloquer);
			
		this.add(content);
		
		JPanel boutons = new JPanel();
		boutons.setSize(480, 50);
		final JButton defaut = new JButton("Par défaut");
		defaut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SwingUtilities.invokeLater(new Runnable() {
                    public void run() {                    	
                    	Jeu.params = new Parametres();
                    	setVisible(false);
                    	dispose();                    	
                    	SwingUtilities.updateComponentTreeUI(new ParametresFrame());
                    }
                });
            }
        });
		boutons.add(defaut);
		final JButton enregistrer = new JButton("Enregistrer");
		enregistrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                    	try {
                    	Jeu.params.setDegatMax(ParametresFrame.degatMax);
                    	Jeu.params.setDegatMin(ParametresFrame.degatMin);
                    	Jeu.params.setNbMaxPtEnergie(ParametresFrame.nbMaxPtEnergie);
                    	Jeu.params.setNbMaxPtVie(ParametresFrame.nbMaxPtVie);
                    	Jeu.params.setPtAttaque(ParametresFrame.ptAttaque);
                    	Jeu.params.setPtBloquage(ParametresFrame.ptBloquage);
                    	Jeu.params.setPtBonus(ParametresFrame.ptBonus);
                    	Jeu.params.setPtEsquive(ParametresFrame.ptEsquive);
                    	Jeu.params.setTempsMax(ParametresFrame.tempsMax);
                    	Jeu.params.setCoefCritique(ParametresFrame.coefCritique) ;
                    	}catch (Exception e){
                    		JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
                    	}
                    }
                });
            }
        });
		boutons.add(enregistrer);
		final JButton annuler = new JButton("Annuler");
		annuler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                    	setVisible(false);
                    	dispose();
                    }
                });
            }
        });
		boutons.add(annuler);
		this.add(boutons, BorderLayout.SOUTH);
	}
	
}
