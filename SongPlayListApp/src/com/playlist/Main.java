package com.playlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class Main {

	private static ArrayList<Album> albums = new ArrayList<>();
	
	public static void main(String[] args) {	
		
		Album album  = new Album("Album1","AC/BC");
		
		album.addSong("TNT", 4.5);
		album.addSong("Highway to Hell", 3.5);
		album.addSong("ThunderStruck", 4.0);
		
		albums.add(album);
		
        Album album1  = new Album("Album2","Neha Kakkar");
		
		album.addSong("Coca Cola", 3.5);
		album.addSong("Phone Number", 4.5);
		album.addSong("Swag", 3.0);
		albums.add(album1);
		
		//creating a linked List to playlist of above arraylist
		
		LinkedList<Song> PlayList_1 = new LinkedList<>();
		
		albums.get(0).addToPlayList("TNT", PlayList_1);
		albums.get(0).addToPlayList("Highway to Hell", PlayList_1);
		albums.get(1).addToPlayList("Coca Cola", PlayList_1);
		albums.get(1).addToPlayList("Swag", PlayList_1);
		
		play(PlayList_1);	
		
		
	}
	
	private static void play(LinkedList<Song> playList) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean quit = false;
		boolean forward  =  true;
		
		
		ListIterator<Song> listIterator = playList.listIterator();
		
		if(playList.size() == 0) {
			System.out.println("This playlist has no song");
		}
		else {
			System.out.println("Now playing " + listIterator.next().toString());
			printMenu();
		}
		while(!quit) {
			int action = sc.nextInt();
			sc.nextLine();
			
	
			switch(action) {
			case 0:
				System.out.println("PlayList complete");
				quit = true;
				break;
			case 1:
				if(!forward) {
					if(listIterator.hasNext()) {
						listIterator.next();
					}
					forward = true;
				}
				if(listIterator.hasNext()) {
					System.out.println("Now playing " + listIterator.next().toString());
				}
				else {
					System.out.println("No Song available.reached to the end of the list");
					forward = false;
					
				}
				break;
			case 2:
				if(forward) {
					if(listIterator.hasPrevious()) {
						listIterator.previous();
					}
					forward = false;
				}
				if(listIterator.hasPrevious()) {
					System.out.println("Now playing "+listIterator.previous().toString());
				}else {
					System.out.println("We are at the first song");
					forward = false;
				}
				break;
				
			case 3:
				if(forward) {
					if(listIterator.hasPrevious()) {
						System.out.println("Now playing "+listIterator.previous().toString());
						forward = false;
					}else {
						System.out.println("We are at the start of the list");
					}
				}else {
					if(listIterator.hasNext()) {
						System.out.println("Now playing " + listIterator.next().toString());
						forward = true;
					}
					else {
						System.out.println("We reached to the end of the list");		
					}	
				}
				break;
				
			case 4:
				printList(playList);
				break;
			case 5:
				printMenu();
				break;
				
			case 6:
				if(playList.size() >0) {
					listIterator.remove();
					if(listIterator.hasNext()) {
						System.out.println("Now playing" + listIterator.next().toString());
						
					}else {
						if(listIterator.hasPrevious())
						System.out.println("Now playing" + listIterator.previous().toString());
					}
				}
			}
		}	
	}
	
	
	private static void printMenu() {
		System.out.println("Available options \n press");
		System.out.println("0 - to quit \n" + 
		        "1 - to play next song \n" + 
				"2 - to play previous song \n" +
				"3 - to replay the current song \n"+
				"4 - list of all songs \n" +
				"5 - print all available option \n" +
				"6 - delete current song "
		);
	}
	
	private static void printList(LinkedList<Song> playList) {
		
		Iterator<Song> iterator = playList.iterator();
		
		System.out.println("...........................");
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("...........................");
	}

}
