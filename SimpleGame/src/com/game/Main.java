package com.game;

public class Main {

	public static void main(String[] args) {
		
		Player1 player = new Player1( "Sai","sword", 100);
//		System.out.println(player.getName());
//		System.out.println(player.getHealth());
//		System.out.println(player.getWeapon());
		
        player.damageByGun1();
        player.damageByGun2();
        player.damageByGun2();
        player.heal();
//		
//		Player2 play = new Player2( "Sunny","Misson Gun", 100,true);
//		play.damageByGun1();
//		play.damageByGun2();
//		play.damageByGun2();
//		
}

}
