package isiFighters;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class PartieFrame extends JFrame{
	
	public PartieFrame(){
		
		this.setTitle("ISI Fighters - Partie");		
		
		this.setSize(750, 600);		
		this.setVisible(true);	
		
		Partie p = new Partie();
		Fighter human = p.getHuman();
		Fighter comp = p.getComputer();
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setContentPane(contentPanel);
		
		JPanel playingPanel = new JPanel();
		playingPanel.setLayout(new GridLayout(1, 2));
		JPanel humanPart = new JPanel();
		humanPart.setBorder(BorderFactory.createTitledBorder("Vous"));	
		JPanel computerPart = new JPanel();
		computerPart.setBorder(BorderFactory.createTitledBorder("Ordinateur"));	
		
		playingPanel.add(humanPart);
		playingPanel.add(computerPart);
		
		this.add(playingPanel);
		
		
		/////comandes
		JPanel coms = new JPanel();
		coms.setLayout(new GridLayout(3, 3));
		JButton bloqueHaut = createButton("1", KeyEvent.VK_NUMPAD1);
		JButton esquiveBas = createButton("2", KeyEvent.VK_NUMPAD2);
		JButton attaqueHaut = createButton("3", KeyEvent.VK_NUMPAD3);
		JButton bloqueAbdomen = createButton("4", KeyEvent.VK_NUMPAD4);
		JButton concentration = createButton("5", KeyEvent.VK_NUMPAD5);
		JButton attaqueAbdomen = createButton("6", KeyEvent.VK_NUMPAD6);
		JButton bloqueBas = createButton("7", KeyEvent.VK_NUMPAD7);
		JButton esquiveHaut = createButton("8", KeyEvent.VK_NUMPAD9);
		JButton attaqueBas = createButton("9", KeyEvent.VK_NUMPAD9);		
		
		coms.add(bloqueHaut);
		coms.add(esquiveBas);
		coms.add(attaqueHaut);
		coms.add(bloqueAbdomen);
		coms.add(concentration);
		coms.add(attaqueAbdomen);
		coms.add(bloqueBas);
		coms.add(esquiveHaut);
		coms.add(attaqueBas);
		
		humanPart.add(coms);
		
		
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
	
	protected JButton createButton(String name, int virtualKey) {
        JButton btn = new JButton(name);
        btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand() + " was clicked");
				
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
        return btn;
	}
}
