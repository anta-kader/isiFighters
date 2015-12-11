package isiFighters;

public class Fighter {

	private String nom;
	
	private int ptVie;
	
	private int ptEnergie;
	
	private Parametres params;
	
	public Fighter(String nom, Parametres p){
		this.setNom(nom);
		this.params = new Parametres(p);
		this.setPtVie(p.getNbMaxPtVie());
		this.setPtEnergie(p.getNbMaxPtEnergie());
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
	
	public void attaque(){
		this.ptEnergie -= this.params.getPtAttaque(); 
	}
	
	public void esquive(){
		this.ptEnergie -= this.params.getPtEsquive();
	}
	
	public void recvoirCoup(){
		int degMin = this.params.getDegatMin();
		int degMax = this.params.getDegatMax();
		this.ptVie -= degMin + Math.random() * (degMax - degMin);
	}
	
	public void bloquerAttaque(){
		this.ptEnergie -= this.params.getPtBloquage();
	}
	
	public boolean reussirAction(){
		this.ptEnergie += this.params.getPtBonus();
		return true;
	}
}
