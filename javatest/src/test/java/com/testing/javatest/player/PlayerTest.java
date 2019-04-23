/**
 * 
 */
package com.testing.javatest.player;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Clase de test para la clase {@link Player}
 * 
 * @author sumel
 *
 */
public class PlayerTest {

	@Test
	public void lossesPlayerWhenIsTooLow() {
		//Dice dice = new Dice(6);
		Dice dice = Mockito.mock(Dice.class);
		Mockito.when(dice.roll()).thenReturn(2);
		
		Player player = new Player(dice, 3);
		
		//assertEquals(false, player.play()); 
		assertFalse(player.play());
	}
	
	@Test
	public void WinPlayerWhenIsBig() {
		
		Dice dice = Mockito.mock(Dice.class);
		Mockito.when(dice.roll()).thenReturn(4);
		
		Player player = new Player(dice, 3);
		
		//assertEquals(true, player.play());
		assertTrue(player.play());
	}	
}

