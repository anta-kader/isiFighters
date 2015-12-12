package isiFighters;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class Partie {

	private Fighter human;
	private Fighter computer;

	private int code_coup_human;
	private int code_coup_computer;
	
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
	
	public void doAction(){
		while(this.human.getPtVie() > 0 && this.computer.getPtVie() > 0){
			ExecutorService service = Executors.newSingleThreadExecutor();

			try {
			    Runnable r = new Runnable() {
			        @Override
			        public void run() {
			            // Database task
			        }
			    };

			    Future<?> f = service.submit(r);

			    f.get(2, TimeUnit.MINUTES);     // attempt the task for two minutes
			}
			catch (final InterruptedException e) {
			    // The thread was interrupted during sleep, wait or join
			}
			catch (final TimeoutException e) {
			    // Took too long!
			}
			catch (final ExecutionException e) {
			    // An exception from within the Runnable task
			}
			finally {
			    service.shutdown();
			}
		}
	}
	
	public int getCoupComp(){
		return (int) (1 + Math.random() * 8); 
	}
	
	public void action(int actionH, int actionC){
		switch(actionH){
		case 1 ://bloquer haut
			this.human.bloquerAttaque();
			switch (actionC){
				case 1 :
					this.computer.bloquerAttaque();
					break;
				case 2 :
					this.computer.esquive();
					break;
				case 3 :
					this.computer.attaque();
					this.human.reussirAction();
					break;
				case 4 :
					this.computer.bloquerAttaque();
					break;
				case 5 :
					this.computer.concentration = true;
					break;
				case 6 :
					this.computer.attaque();
					this.human.recvoirCoup();
					this.computer.reussirAction();
					break;
				case 7 :
					this.computer.bloquerAttaque();
					break;
				case 8 :
					this.computer.esquive();
					break;
				case 9 :
					this.computer.attaque();
					this.human.recvoirCoup();
					this.computer.reussirAction();
					break;
			}
			break;
		case 2 ://esquive bas
			this.human.esquive();
			switch (actionC){
				case 1 :
					this.computer.bloquerAttaque();
					break;
				case 2 :
					this.computer.esquive();
					break;
				case 3 :
					this.computer.attaque();	
					this.human.reussirEsquive();
					break;
				case 4 :
					this.computer.bloquerAttaque();
					break;
				case 5 :
					this.computer.concentration = true;
					this.computer.reussirAction();
					break;
				case 6 :
					this.computer.attaque();
					this.human.recvoirCoup();
					this.computer.reussirAction();
					break;
				case 7 :
					this.computer.bloquerAttaque();
					break;
				case 8 :
					this.computer.esquive();
					break;
				case 9 :
					this.computer.attaque();
					this.human.recvoirCoup();
					this.computer.reussirAction();
					break;
			}
			break;
		case 3 : //attaque haut
			this.human.attaque();
			switch (actionC){
				case 1 :
					this.computer.bloquerAttaque();
					this.computer.reussirAction();
					break;
				case 2 :
					this.computer.esquive();
					this.computer.reussirEsquive();
					break;
				case 3 :
					this.computer.attaque();	
					this.computer.reussirAction();
					this.computer.recvoirCoup();
					this.human.reussirAction();
					this.human.recvoirCoup();
					break;
				case 4 :
					this.computer.bloquerAttaque();
					this.computer.recvoirCoup();
					this.human.reussirAction();
					break;
				case 5 :
					//this.computer.concentration = true;
					this.computer.recvoirCoup();
					this.human.reussirAction();
					break;
				case 6 :
					this.computer.attaque();
					this.computer.reussirAction();
					this.computer.recvoirCoup();
					this.human.reussirAction();
					this.human.recvoirCoup();
					break;
				case 7 :
					this.computer.bloquerAttaque();
					this.computer.recvoirCoup();
					this.human.reussirAction();
					break;
				case 8 :
					this.computer.esquive();
					this.computer.recvoirCoup();
					this.human.reussirAction();
					break;
				case 9 :
					this.computer.attaque();
					this.computer.reussirAction();
					this.computer.recvoirCoup();
					this.human.reussirAction();
					this.human.recvoirCoup();
					break;
			}
			break;
		case 4 ://abdomen
			this.human.bloquerAttaque();
			switch (actionC){
				case 1 :
					this.computer.bloquerAttaque();
					break;
				case 2 :
					this.computer.esquive();
					break;
				case 3 :
					this.computer.attaque();
					this.computer.reussirAction();
					this.human.recvoirCoup();
					break;
				case 4 :
					this.computer.bloquerAttaque();
					break;
				case 5 :
					this.computer.concentration = true;
					this.computer.reussirAction();
					break;
				case 6 :
					this.computer.attaque();
					this.human.reussirAction();
					break;
				case 7 :
					this.computer.bloquerAttaque();
					break;
				case 8 :
					this.computer.esquive();
					break;
				case 9 :
					this.computer.attaque();
					this.computer.reussirAction();
					this.human.recvoirCoup();
					break;
			}
			break;
		case 5 ://concentration
			this.human.concentration = true;
			switch (actionC){
				case 1 :
					this.computer.bloquerAttaque();
					this.human.reussirAction();
					break;
				case 2 :
					this.computer.esquive();
					this.human.reussirAction();
					break;
				case 3 :
					this.computer.attaque();	
					this.human.concentration = false;
					this.human.recvoirCoup();
					this.computer.reussirAction();
					break;
				case 4 :
					this.computer.bloquerAttaque();
					this.human.reussirAction();
					break;
				case 5 :
					this.computer.concentration = true;
					this.computer.reussirAction();
					this.human.reussirAction();
					break;
				case 6 :
					this.computer.attaque();
					this.human.concentration = false;
					this.human.recvoirCoup();
					this.computer.reussirAction();
					break;
				case 7 :
					this.computer.bloquerAttaque();
					this.human.reussirAction();
					break;
				case 8 :
					this.computer.esquive();
					this.human.reussirAction();
					break;
				case 9 :
					this.computer.attaque();
					this.human.concentration = false;
					this.human.recvoirCoup();
					this.computer.reussirAction();
					break;
			}
			break;
		case 6 : //attaquee abdomen
			this.human.attaque();
			switch (actionC){
				case 1 :
					this.computer.bloquerAttaque();
					this.human.reussirAction();
					this.computer.recvoirCoup();
					break;
				case 2 :
					this.computer.esquive();
					this.human.reussirAction();
					this.computer.recvoirCoup();
					break;
				case 3 :
					this.computer.attaque();
					this.human.reussirAction();
					this.computer.recvoirCoup();
					this.computer.reussirAction();
					this.human.recvoirCoup();
					break;
				case 4 :
					this.computer.bloquerAttaque();
					this.computer.reussirAction();
					break;
				case 5 :
					this.computer.concentration = false;
					this.computer.recvoirCoup();
					break;
				case 6 :
					this.computer.attaque();
					this.human.reussirAction();
					this.computer.recvoirCoup();
					this.computer.reussirAction();
					this.human.recvoirCoup();
					break;
				case 7 :
					this.computer.bloquerAttaque();
					this.human.reussirAction();
					this.computer.recvoirCoup();
					break;
				case 8 :
					this.computer.esquive();
					this.human.reussirAction();
					this.computer.recvoirCoup();
					break;
				case 9 :
					this.computer.attaque();
					this.human.reussirAction();
					this.computer.recvoirCoup();
					this.computer.reussirAction();
					this.human.recvoirCoup();
					break;
			}
			break;
		case 7 : //bloquer jambes
			this.human.bloquerAttaque();
			switch (actionC){
				case 1 :
					this.computer.bloquerAttaque();
					break;
				case 2 :
					this.computer.esquive();
					break;
				case 3 :
					this.computer.attaque();
					this.computer.reussirAction();
					this.human.recvoirCoup();
					break;
				case 4 :
					this.computer.bloquerAttaque();
					break;
				case 5 :
					this.computer.concentration = true;
					this.computer.reussirAction();
					break;
				case 6 :
					this.computer.attaque();
					this.computer.reussirAction();
					this.human.recvoirCoup();
					break;
				case 7 :
					this.computer.bloquerAttaque();
					break;
				case 8 :
					this.computer.esquive();
					break;
				case 9 :
					this.computer.attaque();
					this.human.reussirAction();
					break;
			}
			break;
		case 8 : //esquive haut
			this.human.esquive();
			switch (actionC){
				case 1 :
					this.computer.bloquerAttaque();
					break;
				case 2 :
					this.computer.esquive();
					break;
				case 3 :
					this.computer.attaque();
					this.computer.reussirAction();
					this.human.recvoirCoup();
					break;
				case 4 :
					this.computer.bloquerAttaque();
					break;
				case 5 :
					this.computer.concentration = true;
					this.computer.reussirAction();
					break;
				case 6 :
					this.computer.attaque();
					this.computer.reussirAction();
					this.human.recvoirCoup();
					break;
				case 7 :
					this.computer.bloquerAttaque();
					break;
				case 8 :
					this.computer.esquive();
					break;
				case 9 :
					this.computer.attaque();
					this.human.reussirAction();
					break;
			}
			break;
		case 9 : //attaque jambe
			this.human.attaque();
			switch (actionC){
				case 1 :
					this.computer.bloquerAttaque();
					this.human.reussirAction();
					this.computer.recvoirCoup();
					break;
				case 2 :
					this.computer.esquive();
					this.human.reussirAction();
					this.computer.recvoirCoup();
					break;
				case 3 :
					this.computer.attaque();
					this.human.reussirAction();
					this.computer.reussirAction();
					this.human.recvoirCoup();
					break;
				case 4 :
					this.computer.bloquerAttaque();
					this.human.reussirAction();
					this.computer.recvoirCoup();
					break;
				case 5 :
					this.computer.concentration = false;
					this.human.reussirAction();
					this.computer.recvoirCoup();
					break;
				case 6 :
					this.computer.attaque();
					this.human.reussirAction();
					this.computer.reussirAction();
					this.human.recvoirCoup();
					this.computer.recvoirCoup();
					break;
				case 7 :
					this.computer.bloquerAttaque();
					this.computer.reussirAction();
					break;
				case 8 :
					this.computer.esquive();
					this.computer.reussirAction();
					break;
				case 9 :
					this.computer.attaque();
					this.human.reussirAction();
					this.computer.reussirAction();
					this.human.recvoirCoup();
					this.computer.recvoirCoup();
					break;
			}
			break;
		default :
			break;
		}
	}
}
