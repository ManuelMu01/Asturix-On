public class Tablero  {

	public Ficha[][] casillas;
	public char tirada;
	
	public Tablero() {
		this.tirada='B';
		casillas=new Ficha[8][8];
		
		for (int x=0;x<8;x++) casillas[x][1]=new Peon(x, 1, 'N');
		for (int x=0;x<8;x++) casillas[x][6]=new Peon(x, 6, 'B');
		
		casillas[0][0]=new Torre(0, 0, 'N');
		casillas[7][0]=new Torre(7, 0, 'N');
		casillas[0][7]=new Torre(0, 7, 'B');
		casillas[7][7]=new Torre(7, 7, 'B');
		
		casillas[1][0]=new Caballo(1, 0, 'N');
		casillas[6][0]=new Caballo(6, 0, 'N');
		casillas[1][7]=new Caballo(1, 7, 'B');
		casillas[6][7]=new Caballo(6, 7, 'B');
		
		casillas[2][0]=new Alfil(2, 0, 'N');
		casillas[5][0]=new Alfil(5, 0, 'N');
		casillas[2][7]=new Alfil(2, 7, 'B');
		casillas[5][7]=new Alfil(5, 7, 'B');
		
		casillas[3][0]=new Reina(3, 0, 'N');
		casillas[3][7]=new Reina(3, 7, 'B');
		
		casillas[4][0]=new Rey(4, 0, 'N');
		casillas[4][7]=new Rey(4, 7, 'B');
		
	}
	public void pintar() {
		System.out.println("     A   B   C   D   E   F   G   H");
		System.out.println("   ┌───┬───┬───┬───┬───┬───┬───┬───┐");
		for (int y=0;y<8;y++) {
			System.out.print  (" "+y+" │");
			for (int x=0;x<8;x++) {
				if (casillas[x][y]==null) {
					System.out.print(((x+y)%2==0)? "░░░":"   ");
				} else {	
					System.out.print(" "+casillas[x][y].forma+" ");
				}
				System.out.print("│");
			}
			System.out.println  ("│ "+y+" ");
		}
	
	}
	public int mover(Posicion posIni, Posicion posFin) {
		
		return 0;
		
	}

}
