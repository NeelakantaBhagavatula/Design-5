// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//Parking Lot - https://www.careercup.com/question?id=5084295966228480
import java.io.*;

import java.util.PriorityQueue;

class GFG {
	public static void main(String[] args) {
		ParkingLot pl = new ParkingLot(10, 20);
		pl.addParkingSpot(3, 2);
		pl.addParkingSpot(1, 2);
		pl.addParkingSpot(1, 1);
		pl.addParkingSpot(2, 1);
		pl.addParkingSpot(3, 1);
		pl.addParkingSpot(2, 2);
		ParkingSpot n = pl.getNextAvailable(); // 1 1
		System.out.println("Parked at Floor: " + n.getFloor() + ", Slot: " + n.getSpot());
		pl.park(); // 1, 1
		ParkingSpot n2 = pl.getNextAvailable(); // 1 2
		System.out.println("Parked at Floor: " + n2.getFloor() + ", Slot: " + n2.getSpot());
		pl.unpark(1, 1); //
		ParkingSpot n1 = pl.getNextAvailable(); // 1 1
		System.out.println("Parked at Floor: " + n1.getFloor() + ", Slot: " + n1.getSpot());
	}

	static class ParkingSpot {
		int floor;
		int spot;

		public ParkingSpot(int floor, int spot) {
			this.floor = floor;
			this.spot = spot;
		}

		public int getSpot() {
			return this.spot;
		}

		public int getFloor() {
			return this.floor;
		}
	}

	static class ParkingLot {
		int maxFloors;
		int spotsPerFloor;

		PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a, b) -> {
			if (a.floor == b.floor)
				return a.spot - b.spot;
			return a.floor - b.floor;
		});

		public ParkingLot(int maxFloors, int spotsPerFloor) {
			this.maxFloors = maxFloors;
			this.spotsPerFloor = spotsPerFloor;
		}

		public ParkingSpot park() {
			if (pq.isEmpty()) {
				throw new IllegalStateException("Parking lot is full");
			}
			ParkingSpot re = pq.remove();
			return re;
		}

		public ParkingSpot getNextAvailable() {
			return pq.peek();
		}

		public void unpark(int floor, int spot) {
			ParkingSpot newSpot = new ParkingSpot(floor, spot);
			pq.add(newSpot);
		}

		public void addParkingSpot(int floor, int spot) {
			if (floor > maxFloors) {
				throw new IllegalArgumentException("floor input greater than max allowed");
			}
			if (spot > spotsPerFloor) {
				throw new IllegalArgumentException("spots input greater than max allowed");

			}
			ParkingSpot newSpot = new ParkingSpot(floor, spot);
			pq.add(newSpot);
		}
	}
}