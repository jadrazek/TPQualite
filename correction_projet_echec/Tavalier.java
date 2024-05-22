import java.util.ArrayList;

abstract class Tavalier extends Piece {

    public Tavalier() {
        super('B', new Position());
    }

    public Tavalier(char couleur, Position position) {
        super(couleur, position);
    }

    public String getType() {
        return new String("Tavalier");
    }

    public ArrayList<Position> getDeplacementPossible(Plateau pl) {
        ArrayList<Position> liste = new ArrayList<Position>();
        int positionDepartX = this.getPosition().getX();
        int positionDepartY = this.getPosition().getY();

        // Mouvements de la tour

        // Vers le haut
        boolean obstacle = false;
        int indiceX = positionDepartX;
        int indiceY = positionDepartY + 1;
        while (!obstacle && (indiceY < 8)) {
            Piece pi = pl.getCase(indiceX, indiceY);
            if (pi == null)
                liste.add(new Position(indiceX, indiceY));
            else {
                obstacle = true;
                if (pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(indiceX, indiceY));
            }
            indiceY = indiceY + 1;
        }

        // Vers le bas
        obstacle = false;
        indiceY = positionDepartY - 1;
        while (!obstacle && (indiceY >= 0)) {
            Piece pi = pl.getCase(indiceX, indiceY);
            if (pi == null)
                liste.add(new Position(indiceX, indiceY));
            else {
                obstacle = true;
                if (pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(indiceX, indiceY));
            }
            indiceY = indiceY - 1;
        }

        // Vers la gauche
        obstacle = false;
        indiceX = positionDepartX - 1;
        indiceY = positionDepartY;
        while (!obstacle && (indiceX >= 0)) {
            Piece pi = pl.getCase(indiceX, indiceY);
            if (pi == null)
                liste.add(new Position(indiceX, indiceY));
            else {
                obstacle = true;
                if (pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(indiceX, indiceY));
            }
            indiceX = indiceX - 1;
        }

        // Vers la droite
        obstacle = false;
        indiceX = positionDepartX + 1;
        while (!obstacle && (indiceX < 8)) {
            Piece pi = pl.getCase(indiceX, indiceY);
            if (pi == null)
                liste.add(new Position(indiceX, indiceY));
            else {
                obstacle = true;
                if (pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(indiceX, indiceY));
            }
            indiceX = indiceX + 1;
        }

        // Mouvements du cavalier

        int[][] deplacements = {
            {-2, -1}, {-2, 1},
            {-1, -2}, {-1, 2},
            {1, -2}, {1, 2},
            {2, -1}, {2, 1}
        };

        for (int[] deplacement : deplacements) {
            indiceX = positionDepartX + deplacement[0];
            indiceY = positionDepartY + deplacement[1];

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
