package defpac;

import junit.framework.TestCase;

public class MyWoodTest extends TestCase {

	public void testCreateWoodman() {
		char[][] wood = {{'1','1','1','1'},{'1','0','K','1'},{'1','0','L','1'},{'1','1','1','1'}};
		MyWood forest = new MyWood (wood);
		forest.createWoodman("aaa", new Point(1,1));
		assertEquals(forest.move("aaa",Direction.None),Action.Ok);
	}

	public void testMove() {
		char[][] forest = {{'1','1','1','1'},{'1','0','K','1'},{'1','0','L','1'},{'1','1','1','1'}};
		MyWood wood = new MyWood (forest);
		wood.createWoodman("aaa", new Point(1,1));
		assertEquals(wood.move("aaa",Direction.Down),Action.Ok);
		assertEquals(wood.move("aaa",Direction.Right),Action.Life);
		assertEquals(wood.move("aaa",Direction.Up),Action.Dead);
		assertEquals(wood.move("aaa",Direction.Left),Action.Ok);
	}
}