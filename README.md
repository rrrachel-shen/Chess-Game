## Some explanations for my game system:

1. There are four games in all: connect4, TOOT, TOOT2 and connect5. (TOOT and TOOT2 are similar. I wrote them with two different rules.)

2. “project_main.java” is the entry for all the games.

3. “main.java”, “connect4winner.java”, “randomai.java” and “smartai.java” are for the game “connect4”

4. “simpletoot.java”, “simpletootwinner.java” and “simpletootrandomai.java” are for the game “TOOT”. (The rule is: when there is “TOOT” on the board, red wins; when there is “OTTO” on the board, yellow wins.)

5. “mainfortoot.java”, “tootwinner.java”, “randomaitoot.java” are for the game “TOOT2”. (The rule is: when there is “TOOT” on the board with red color, red wins; when there is “OTTO” on the board with yellow color, yellow wins.)

6. “connect5.java”, “connect5winner.java” and “randomaiconnect5.java” are for the game “connect5”.(The difference from connet4 is: player can put chess piece in any place of the board, and need to connect five chess pieces.)


## Overview of the game implementation:

This is the entry for all games. You can:
1.	Enter the game you want to play by clicking on the game name;
2.	Exit the process by clicking “exit”<br>

![1](https://user-images.githubusercontent.com/71359524/94505858-40abfe80-01c9-11eb-93b2-b92d41f3539f.png)



Let’s click “Play Connect4”.

Now we enter the game. You can:
1.	Enlarge the game board by clicking “Add Grids”;
2.	Choose the game mode: play with a person/random AI/smart AI;
3.	Go to the entry page by clicking “reset”;
4.	Place your chess by clicking on the white circle;
5.	If you want to cancel your move and go to the last step, click “regret”.

![2](https://user-images.githubusercontent.com/71359524/94505876-4dc8ed80-01c9-11eb-8885-dbb2df87932d.png)


Let’s place a chess.


![3](https://user-images.githubusercontent.com/71359524/94506028-ae582a80-01c9-11eb-90f5-2c66dc701471.png)


Now it’s the opponent’s turn.

![4](https://user-images.githubusercontent.com/71359524/94506128-e7909a80-01c9-11eb-9f27-6431a2bbbc63.png)

The opponent wins!

![5](https://user-images.githubusercontent.com/71359524/94506217-173fa280-01ca-11eb-9425-d3f0703ce710.png)

Let’s play with an AI.

Every time you place a chess, the AI will take its turn automatically. 

![6](https://user-images.githubusercontent.com/71359524/94506278-3b02e880-01ca-11eb-963c-db1059274f60.png)

The AI wins!

![7](https://user-images.githubusercontent.com/71359524/94506372-74d3ef00-01ca-11eb-9521-66a63e38a1e1.png)

Now let’s reset and play TOOT.

The operations are similar, but don’t forget to choose the character(“T” or “O”) you want to use before placement. In this case, I placed a “T”.

![8](https://user-images.githubusercontent.com/71359524/94506400-8ddca000-01ca-11eb-9708-06e9b0d2eee8.png)

Red wins!

![9](https://user-images.githubusercontent.com/71359524/94506454-ab116e80-01ca-11eb-90bc-6eddb875405e.png)

Now let’s reset and play connect 5.

The initial board is larger, and with different game rules.

![10](https://user-images.githubusercontent.com/71359524/94506505-c7ada680-01ca-11eb-9a13-4742705efdc7.png)

Have fun!

![11](https://user-images.githubusercontent.com/71359524/94506551-df852a80-01ca-11eb-8a85-82af4808ddb7.png)
