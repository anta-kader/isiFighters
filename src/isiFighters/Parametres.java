package isiFighters;

public class Parametres {
	
	// Le nombre maximal de points de vie d’un joueur
	private int nbMaxPtVie;
	
	// Le nombre maximal de points d’énergie d’un joueur
	private int nbMaxPtEnergie;
	
	// Le dégât maximal d’un coup
	private int degatMax;
	
	// Le dégât minimal d’un coup
	private int degatMin;
	
	// Le coefficient d’un coup critique
	private double coefCritique;
	
	// Temps max accordé pour choisir une action
	private int tempsMax;
	
	// Le nombre de points de vie que l’on gagne lorsqu’on esquive une attaque
	private int ptEsquive;
	
	// Le nombre de points d’énergie dépensés lorsque l’on fait une attaque
	private int ptAttaque;
	
	// Le nombre de points d’énergie bonus que l’on obtient lorsqu’on réussit une action 
	private int ptBonus;
	
	// Le nombre de points d’énergie dépensés pour faire une action de blocage 
	private int ptBloquage;
	
	public Parametres(){
		this.nbMaxPtEnergie = 100;
		this.nbMaxPtVie = 100;
		this.degatMax = 8;
		this.degatMin = 4;
		this.coefCritique = 2.5;
		this.tempsMax = 5;
		this.ptAttaque = 5;
		this.ptBloquage = 1;
		this.ptBonus = 1;
		this.ptEsquive = 2;
	}
	
	public Parametres(Parametres p){
		this.nbMaxPtEnergie = p.nbMaxPtEnergie;
		this.nbMaxPtVie = p.nbMaxPtVie;
		this.degatMax = p.degatMax;
		this.degatMin = p.degatMin;
		this.coefCritique = p.coefCritique;
		this.tempsMax = p.tempsMax ;
		this.ptAttaque = p.ptAttaque;
		this.ptBloquage = p.ptBloquage;
		this.ptBonus = p.ptBonus;
		this.ptEsquive = p.ptEsquive;
	}
	
	public int getNbMaxPtEnergie(){
		return this.nbMaxPtEnergie;
	}
	
	public void setNbMaxPtEnergie(int nbMaxPtEnergie){
		this.nbMaxPtEnergie = nbMaxPtEnergie;
	}
	
	public int getNbMaxPtVie(){
		return this.nbMaxPtVie;
	}
	
	public void setNbMaxPtVie(int nbMaxPtVie){
		this.nbMaxPtVie = nbMaxPtVie;
	}
	
	public int getDegatMax() {
		return this.degatMax;
	}
	
	public void setDegatMax(int degatMax) throws Exception{
		if (degatMax < this.degatMin) 
			throw new Exception("Le dégat max ne peut pas être inférieur au dégat min !");
		this.degatMax = degatMax;
	}
	
	public int getDegatMin(){
		return this.degatMin;
	}
	
	public void setDegatMin(int degatMin) throws Exception{
		if (degatMin > this.degatMax) 
			throw new Exception("Le dégat min ne peut pas être supérieur au dégat max !");
		this.degatMin = degatMin;
	}
	
	public double getCoefCritique(){
		return this.coefCritique;
	}
	
	public void setCoefCritique(double coefCritique){
		this.coefCritique = coefCritique;
	}
	
	public int getTempsMax(){
		return this.tempsMax;
	}
	
	public void setTempsMax(int tempsMax){
		this.tempsMax = tempsMax;
	}
	
	public int getPtAttaque(){
		return this.ptAttaque;
	}
	
	public void setPtAttaque(int ptAttaque){
		this.ptAttaque = ptAttaque;
	}
	
	public int getPtBloquage(){
		return this.ptBloquage;
	}
	
	public void setPtBloquage(int ptBloquage){
		this.ptBloquage = ptBloquage;
	}
	
	public int getPtBonus(){
		return this.ptBonus;
	}
	
	public void setPtBonus(int ptBonus){
		this.ptBonus = ptBonus;
	}
	
	public int getPtEsquive(){
		return this.ptEsquive;
	}
	
	public void setPtEsquive(int ptEsquive){
		this.ptEsquive = ptEsquive;
	}

}
