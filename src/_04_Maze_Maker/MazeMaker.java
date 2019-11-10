package _04_Maze_Maker;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();
	
	
	public static Maze generateMaze(int w, int h){
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		//4. select a random cell to start
		int wid= randGen.nextInt(w);
		int hei= randGen.nextInt(h);
		Cell random=maze.getCell(wid, hei);
	
		//5. call selectNextPath method with the randomly selected cell
		selectNextPath(random);
		
		return maze;
	}

	//6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		//A. mark cell as visited
		currentCell.hasBeenVisited();
		//B. Get an ArrayList of unvisited neighbors using the current cell and the method below
		ArrayList<Cell> unvisit=new ArrayList<>();
		//C. if has unvisited neighbors,
		unvisit=getUnvisitedNeighbors(currentCell);
		if (unvisit.size()>0) {
			
	int r=randGen.nextInt(unvisit.size());
		
			//C1. select one at random.
			Cell rand=unvisit.get(r);
			//C2. push it to the stack
		uncheckedCells.push(rand);
			//C3. remove the wall between the two cells
		removeWalls(currentCell, rand);
			//C4. make the new cell the current cell and mark it as visited
		currentCell=rand;
		currentCell.hasBeenVisited();
			//C5. call the selectNextPath method with the current cell
			selectNextPath(currentCell);
		}
		//D. if all neighbors are visited
		if (unvisit.size()==0) {
			
		
			//D1. if the stack is not empty
			if (uncheckedCells.size()!=0) {
				
			
				// D1a. pop a cell from the stack
		
				// D1b. make that the current cell
		currentCell=uncheckedCells.pop();
				// D1c. call the selectNextPath method with the current cell
				selectNextPath(currentCell);
			}
		}
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if (c1) {
			
		}
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		return null;
	}
}
