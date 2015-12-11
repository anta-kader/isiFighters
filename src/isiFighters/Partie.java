package isiFighters;


public class Partie {

	private Fighter human;
	private Fighter computer;
	
	public Partie() {		
		
		this.human = new Fighter("Vous", Jeu.params);		
		this.computer = new Fighter("Ordinateur", Jeu.params);
				
	}
	
	public Fighter getHuman(){
		return this.human;
	}
	
	public Fighter getComputer(){
		return this.computer;
	}
	
	
}
