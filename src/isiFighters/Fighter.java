package isiFighters;

public class Fighter {

	private String nom;
	
	private int ptVie;
	
	private int ptEnergie;
	
	public boolean concentration;
	
	private Parametres params;
	
	public Fighter(String nom, Parametres p){
		this.setNom(nom);
		this.params = new Parametres(p);
		this.setPtVie(p.getNbMaxPtVie());
		this.setPtEnergie(p.getNbMaxPtEnergie());
		this.concentration = false;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPtVie() {
		return this.ptVie;
	}

	public void setPtVie(int ptVie) {
		this.ptVie = ptVie;
	}

	public int getPtEnergie() {
		return this.ptEnergie;
	}

	public void setPtEnergie(int ptEnergie) {
		this.ptEnergie = ptEnergie;
	}
	
	//perte énergie
	public void attaque(){
		this.ptEnergie -= this.params.getPtAttaque(); 
	}
	
	//perte énergie
	public void esquive(){
		//this.ptEnergie -= this.params.getPtEsquive();
	}
	
	public void recvoirCoup(){
		int degMin = this.params.getDegatMin();
		int degMax = this.params.getDegatMax();
		this.ptVie -= degMin + Math.random() * (degMax - degMin);
	}
	
	//perte énergie
	public void bloquerAttaque(){
		this.ptEnergie -= this.params.getPtBloquage();
	}
	
	public boolean reussirAction(){
		this.ptEnergie += this.params.getPtBonus();
		return true;
	}
	
	public void reussirEsquive(){
		this.ptVie += this.params.getPtEsquive();
	}
}
