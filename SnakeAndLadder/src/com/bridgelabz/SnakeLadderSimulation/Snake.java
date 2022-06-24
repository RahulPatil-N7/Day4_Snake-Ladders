package com.bridgelabz.SnakeLadderSimulation;

public class Snake {

	public static final int noplay = 0;
	public static final int ladder = 1;
	public static final int snake = 2;
	public static final int start = 0;
	
	public static int position = 0; 
	public static int count = 0;  
	public static int player = 2;
	
	public static void switchPlayer() {
		// U
		if (player == 2) {
			player = 1;
		} else {
			player = 2;
		}

	}
    public static void playerPosition() {
		while(position<100) {
			switchPlayer();
		//UC1 : Player starts at postion 0	
		System.out.println("player Position:" + position);
		
		//UC2 : Player rolls die 1 to 6
		int roll_die = (int) (Math.floor(Math.random() * 10) % 6) + 1; //UC2 : Player rolls die 1 to 6
		
		//UC3 : Player checks options no play,ladder or snake.
		int check_option = (int) (Math.floor(Math.random() * 10) % 3);
		switch (check_option) {
		case noplay:
			//position = 0;
			System.out.println("It's a No PLAY!  player stays in same position!");
			break;
		case ladder:
			position += roll_die;
			System.out.println("It's a LADDER! Player moves ahead by " + roll_die);
			break;
		case snake:
			if ((position != 0) && (position > roll_die)) {
				position -= roll_die;
				System.out.println("It's a SNAKE! Player moves behind by " + roll_die);
			} else {
				position = 0;
				System.out.println("It's a SNAKE! Player moves behinh by " + roll_die);

			}
			break;
		default:
			System.out.println("Error! Please check!");
			break;
		}
		if (position < start) {
			// UC4 : Player restarts from 0
			position = start;
		} else if (position > 100) {
			position -= roll_die;
		}
		count++;
		System.out.println("Current position of the player in the game is : " + position);
		}
    }
    public static void playerWin() {
    	// UC5 : Check position is 100 or not
		while (position != 100) {
			playerPosition();
		}
	}
		public static void main(String[] args) {
		System.out.println("Welcome to Snake and Ladder game simuation!!!!!!!\n");
		playerWin();
		
		//UC7 : Gamee is played bettwen two players,first to reach 100 wins
	    System.out.println("\nPlayer " +player+" won the Game! Congratulations.");
		
	    // UC6 : Number of roll die in game
	    System.out.println("\nNumber of times roll_die:" +count);

	}
}
	
