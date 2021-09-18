package exo3;

public class test {

	public static void main(String[] args) {
		
		Process p0 = new Process(0);
		Process p1 = new Process(1);
		
		p0.start();
		p1.start();
		
	}
	    /* cette algorithme ne satisfait pas la condition de progrission les 2 threads vont se trouver
	     *cela est du à l'expiration au cointum de temps allouer au thread actif entre les 2 instructions (flagid=true && falg1-id)
	     * insi par exemple : le 1 thread exe l'ins while puis 2 thread positionne aussi son flag à true 1er thread exe l'instruction while il trouve que le flag du 2eme thread = true
	     * le 2eme thread test à son tour le flag du 1ier thread il le trouve = true à partir de se sénario on constate que les 2 threads vont pouclé indiffiniment au niveau de l'instruction while flag 1-id
	     * => insi aucun thread ne peut acceder à la SC
	     * 
	     */



		/*  EXO3 : interblocage
		    EXO4 : la var de counter est incoherent donc les 2 threads ont accerder au meme temps ds SC
		    donc cette algo ne verifie pas SC
		    sela est due à l'expiration de cuntum de temps allouer au thread actif entre les 2 insts while(actif && occupied)
		    */
}
