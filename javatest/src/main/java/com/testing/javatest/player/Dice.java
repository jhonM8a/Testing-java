/**
 * 
 */
package com.testing.javatest.player;

import java.util.Random;

/**
 * Clase que representa un dado que usa la clase {@link Player}
 * 
 * 
 * @author sumel
 *
 */
public class Dice {

	private int sides;
	
	public Dice(int sides) {
		
		this.sides = sides;
	}

	public int roll() {
		return new Random().nextInt(sides) + 1;
	}
}
