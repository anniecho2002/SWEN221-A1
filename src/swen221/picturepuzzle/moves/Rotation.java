// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.picturepuzzle.moves;

import swen221.picturepuzzle.model.Board;
import swen221.picturepuzzle.model.Cell;
import swen221.picturepuzzle.model.Location;
import swen221.picturepuzzle.model.Operation;

/**
 * Responsible for rotating the image data in a given cell in a clockwise
 * direction.
 *
 * @author betty
 *
 */
public class Rotation implements Operation {
	/**
	 * Location of cell which is to be rotated.
	 */
	private final Location location;
	/**
	 * Number of steps to rotate (in a clockwise direction) where each step is a
	 * 90degree rotation.
	 */
	private final int steps;

	/**
	 * Construction a rotation for the cell at a given location, rotating a given
	 * number of steps.
	 *
	 * @param loc   Location of cell to be rotated.
	 * @param steps Number of rotations to apply.
	 */
	public Rotation(Location loc, int steps) {
		this.location = loc;
		this.steps = steps;
	}

	/**
	 * Apply rotation to the selected cell.
	 *
	 * @param board Board where rotation is being applied.
	 */
	@Override
	public void apply(Board board) {
		Cell cell = board.getCellAt(this.location);
		if(cell == null) { return; }
		
		int[] oldImage = cell.getImage();
		int[] newImage = new int[oldImage.length];
		int dimension = cell.getWidth();
		
		
		// needs to be rotated by 'step' number of times
		for(int i = 0; i < steps; i++) {
			
			// rgb data is stored in a 1d array, go through old image and put into the new image
			for(int j = 0; j < dimension; j++) {
				for(int k = 0; k < dimension; k++) {
					newImage[j * dimension + k] = oldImage[(dimension - j - 1) * dimension + k];
				}
			}
			
			// go though the new image and set the rgb values
			for(int j = 0; j < dimension; j++) {
				for(int k = 0; k < dimension; k++) {
					cell.setRGB(j, k, newImage[j * dimension + k]);
				}
			}
		}
	
	}
	
}
