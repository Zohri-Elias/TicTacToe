import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] tableau = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nom du joueur 1 : ");
        String Joueur1 = scanner.nextLine();
        System.out.print("Nom du joueur 2 : ");
        String Joueur2 = scanner.nextLine();

        while (true) {
            char Jouer = 'X';
            for (int turn = 0; turn < 9; turn++) {
                System.out.println("Plateau actuel :");
                for (int i = 0; i < 3; i++) {
                    System.out.print("| ");
                    for (int j = 0; j < 3; j++) {
                        System.out.print(tableau[i][j] + " | ");
                    }
                    System.out.println();
                    System.out.println("-------------");
                }

                System.out.println((Jouer == 'X' ? Joueur1 : Joueur2) + ", entrez votre coup (ligne et colonne, 1-3) : ");
                int ligne = scanner.nextInt() - 1;
                int colonne = scanner.nextInt() - 1;
                scanner.nextLine();

                if (ligne >= 0 && ligne < 3 && colonne >= 0 && colonne < 3 && tableau[ligne][colonne] == '-') {
                    tableau[ligne][colonne] = Jouer;
                    if ((tableau[0][0] == Jouer && tableau[0][1] == Jouer && tableau[0][2] == Jouer) ||
                            (tableau[1][0] == Jouer && tableau[1][1] == Jouer && tableau[1][2] == Jouer) ||
                            (tableau[2][0] == Jouer && tableau[2][1] == Jouer && tableau[2][2] == Jouer) ||
                            (tableau[0][0] == Jouer && tableau[1][0] == Jouer && tableau[2][0] == Jouer) ||
                            (tableau[0][1] == Jouer && tableau[1][1] == Jouer && tableau[2][1] == Jouer) ||
                            (tableau[0][2] == Jouer && tableau[1][2] == Jouer && tableau[2][2] == Jouer) ||
                            (tableau[0][0] == Jouer && tableau[1][1] == Jouer && tableau[2][2] == Jouer) ||
                            (tableau[0][2] == Jouer && tableau[1][1] == Jouer && tableau[2][0] == Jouer)) {

                        System.out.println("Plateau final :");
                        for (char[] l : tableau) {
                            for (char c : l) {
                                System.out.print(c + " ");
                            }
                            System.out.println();
                        }
                        System.out.println((Jouer == 'X' ? Joueur1 : Joueur2) + " a gagné !");
                        break;
                    }
                    Jouer = (Jouer == 'X') ? 'O' : 'X';
                } else {
                    System.out.println("Coup invalide, réessayez.");
                    turn--;
                }
            }
            System.out.println("Match nul !");
            break;
        }
    }
}
