# MorpionGame
Ce programme permet de jouer au MORPION 

Fenêtre principale
1- Le "JFrame" est la fenêtre principale qui contient tout le jeu.  
2- Le "JPanel" avec GridLayout est utilisé pour créer la grille de 3*3 avec des boutons. Chaque boutons représente une case morpion

Grille 3*3
1- Une grille de 3*3 est affichée avec des boutons. Chauqe boutons est un carré blanc et l'utilisateur peut cliquer dessus pour placer un X ou un O
2- Les boutons sont interactifs et appellent la méthode "actionPerformed" lors d'un clic

Gestion des tours du joueur :
1- Chaque joueur joue à tour de rôle. Le joueur & utilise X et le joueur 2 utilie O. Le message au dessus de la grille indique quel joueur doit jouer

Verification de la vitoire :
1- Après chaque coup, le programme vérifie s'il y a un alignement de 3 symboles (horizontalement, veticalement ou en diagonale)
2- Si un joueur à gagner, le message au dessus de la grille l'indique.

Bouton de nouvelle partie :
1- Un bouton nouvelle partie permet de réinitialiser l grille et commencer une nouvelle partie

Foncctionnalités supplémentaires a améliorer : 
1- Gestion des couleurs de cases (pour bien distinguer les X et les O)
2- Empêcher l joueur de jouer après la fin (quand aucun gagnant n'est trouvé c'est que c'est un match nul)
3- Personnaliser davantage l'interface graphique, ajouter des icônes, ou utiliser des images pour les croix et les cercles.
