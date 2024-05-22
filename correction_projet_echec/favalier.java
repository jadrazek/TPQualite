import java.util.ArrayList;

abstract class Favalier extends Piece{

    public Favalier(){
    super('B', new Position());
    }
       
    public Favalier(char couleur, Position position){
    super(couleur, position);
    }

    public String getType(){
        return new String("Favalier");
    }

    public ArrayList<Position> getDeplacementPossible(Plateau pl)
    {
	ArrayList<Position> liste = new ArrayList<Position>();
	int positionDepartX = this.getPosition().getX();
	int positionDepartY = this.getPosition().getY();

	// Dans les 4 directions

	//Vers le haut-gauche
	boolean obstacle = false;
	int indiceX = positionDepartX - 1;
	int indiceY = positionDepartY + 1;
	while(!obstacle && (indiceX >= 0) && (indiceY < 8)){
	    Piece pi = pl.getCase(indiceX, indiceY);
	    if(pi == null)
		liste.add(new Position(indiceX, indiceY));
	    else{
		obstacle = true;
		if(pi.getCouleur() != this.getCouleur())
		    liste.add(new Position(indiceX, indiceY));
	    }
	    indiceX = indiceX - 1;
	    indiceY = indiceY + 1;
	}
	//Vers le bas-gauche
	obstacle = false;
	indiceX = positionDepartX - 1;
	indiceY = positionDepartY - 1;
	while(!obstacle && (indiceX >= 0) && (indiceY >= 0)){
	    Piece pi = pl.getCase(indiceX, indiceY);
	    if(pi == null)
		liste.add(new Position(indiceX, indiceY));
	    else{
		obstacle = true;
		if(pi.getCouleur() != this.getCouleur())
		    liste.add(new Position(indiceX, indiceY));
	    }
	    indiceX = indiceX - 1;
	    indiceY = indiceY - 1;
	}
	//Vers le haut-droite
	obstacle = false;
	indiceX = positionDepartX + 1;
	indiceY = positionDepartY + 1;
	while(!obstacle && (indiceX < 8) && (indiceY < 8)){
	    Piece pi = pl.getCase(indiceX, indiceY);
	    if(pi == null)
		liste.add(new Position(indiceX, indiceY));
	    else{
		obstacle = true;
		if(pi.getCouleur() != this.getCouleur())
		    liste.add(new Position(indiceX, indiceY));
	    }
	    indiceX = indiceX + 1;
	    indiceY = indiceY + 1;
	}
	//Vers le bas-droite
	obstacle = false;
	indiceX = positionDepartX + 1;
	indiceY = positionDepartY - 1;
	while(!obstacle && (indiceX < 8) && (indiceY >= 0)){
	    Piece pi = pl.getCase(indiceX, indiceY);
	    if(pi == null)
		liste.add(new Position(indiceX, indiceY));
	    else{
		obstacle = true;
		if(pi.getCouleur() != this.getCouleur())
		    liste.add(new Position(indiceX, indiceY));
	    }
	    indiceX = indiceX + 1;
	    indiceY = indiceY - 1;
	}

	return liste;
    }
	private ArrayList<Position> getDeplacementCavalier(Plateau pl) {
        ArrayList<Position> liste = new ArrayList<Position>();
        int positionDepartX = this.getPosition().getX();
        int positionDepartY = this.getPosition().getY();

        int[][] deplacements = {
            {-2, -1}, {-2, 1},
            {-1, -2}, {-1, 2},
            {1, -2}, {1, 2},
            {2, -1}, {2, 1}
        };

        for (int[] deplacement : deplacements) {
            int indiceX = positionDepartX + deplacement[0];
            int indiceY = positionDepartY + deplacement[1];

            if ((indiceX >= 0) && (indiceX < 8) && (indiceY >= 0) && (indiceY < 8)) {
                Piece pi = pl.getCase(indiceX, indiceY);
                if (pi == null)
                    liste.add(new Position(indiceX, indiceY));
                else if (pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(indiceX, indiceY));
            }
        }

        return liste;
    }
}