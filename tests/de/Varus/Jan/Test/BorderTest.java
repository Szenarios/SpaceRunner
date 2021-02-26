package de.Varus.Jan.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import de.Varus.Jan.core.BorderManager;

class BorderTest {

	@Test
	void ClickInsideBorderTest(){
		assertTrue(BorderManager.cordinateInside(new TestDrawable(0, 0, 15, 15), 10, 10));
		assertTrue(BorderManager.cordinateInside(new TestDrawable(5, 3, 5, 7), 7, 10));
		assertFalse(BorderManager.cordinateInside(new TestDrawable(7, 7, 5, 7), 3, 5));
		assertFalse(BorderManager.cordinateInside(new TestDrawable(7, 7, 5, 7), 3, 8));
	}
	
	@Test
	void SquareOverlapSquareTest() {
//		TestDrawable a = new TestDrawable(0, 0, 10, 10); 
//		TestDrawable b = new TestDrawable(5, 5, 10, 10); 
//		TestDrawable c = new TestDrawable(2, 2, 5, 5); 
//		TestDrawable d = new TestDrawable(-5, -5, 7, 2); 
//		TestDrawable e = new TestDrawable(7, 5, 6, 6); 
//		TestDrawable f = new TestDrawable(7, -3, 10, 6); 
		
//		assertTrue(BorderManager.SquareOverlapSquare(a, b));
//		assertTrue(BorderManager.SquareOverlapSquare(a, c));
//		assertTrue(BorderManager.SquareOverlapSquare(a, f));
//		
//		assertFalse(BorderManager.SquareOverlapSquare(b, f));
//		assertFalse(BorderManager.SquareOverlapSquare(d, e));
	}
	
}
