package defpac;

import java.util.HashMap;
import java.util.Map;

public class MyWood implements Wood {
	private char[][] m_wood;
	private Map<String, MyWoodman>m_woodmanList;
	
	MyWood (char[][] wood){
		m_wood = wood;
		m_woodmanList = new HashMap<String, MyWoodman>();
	}
	
	public void createWoodman(String name, Point start) {
		m_woodmanList.put(name, new MyWoodman(name,start));
	}
	public Action move (String name, Direction direction) {
		if (!m_woodmanList.containsKey(name)) {
			return Action.WoodmanNotFound;
		}		
		Point newLocation = (m_woodmanList.get(name)).GetLocation();
		if ((newLocation.getX() >= m_wood[0].length)||(newLocation.getX() < 0)||
		   (newLocation.getY() >= m_wood.length)||(newLocation.getY() < 0))
		{
			return Action.Fail;
		}
		switch (direction) {
			case Up: 
				newLocation = newLocation.MoveUp();
				break;
			
			case Down: 
				newLocation = newLocation.MoveDown();
				break;
			
			case Left:
				newLocation = newLocation.MoveLeft();
				break;
			
			case Right: 
				newLocation = newLocation.MoveRigth();
				break;
			
			case None: 
				return Action.Ok;
		}
		char movedPoint = m_wood[newLocation.getY()][newLocation.getX()];
		switch(movedPoint) {
			case '1':
				return Action.Fail;
			case '0':
				(m_woodmanList.get(name)).SetLocation(newLocation);
				return Action.Ok;
			case 'K':
				if ((m_woodmanList.get(name)).Kill()) {
					(m_woodmanList.get(name)).SetLocation(newLocation);
					return Action.Dead;
				}
				m_woodmanList.remove(name);
				return Action.WoodmanNotFound;
			case 'L':
				(m_woodmanList.get(name)).AddLife();
				(m_woodmanList.get(name)).SetLocation(newLocation);
				return Action.Life;
			default:
				return null;	
		}
	}
	public boolean equals(Object wood) {
		if (wood == null) return false;
		if (wood.getClass() != MyWood.class) return false;
		MyWood forests = (MyWood) wood;
		char[][] forest = forests.m_wood;
		boolean eq = true;
		for (int j = 0; j < forest[0].length; j++) {
			for (int i = 0; i < forest.length; i++) {
				if (forest[j][i] != m_wood[j][i]) { 
					eq = false;
					break;
				}
			}
		}
		return eq;
		}
}