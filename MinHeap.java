import java.util.ArrayList;


/*
 * @author: Nishi Agrawal
 */

/*
 * Min heap data structure using ArrayList
 */
public class MinHeap {
	ArrayList<Integer> heap = new ArrayList<>();
	
	public MinHeap() {
		
	}
	
	public int findMin() {
		if(! heap.isEmpty()) {
			return heap.get(0);
		}
		return -1;
	}
	
	public void heapify(int element, int position) {
		int index = position/2;
		while(element < heap.get(index)) {
			int temp = heap.get(index);
			heap.set(index, element);
			heap.set(position, temp);
			position = index;
			index = index/2;
		}
	}
	
	public void insert(int element) {
		if(heap.isEmpty()) {
			heap.add(element);
		}
		else {
			heap.add(element);
			
			heapify(element, heap.size()-1);
		}
	}
	
	public int delete() {
		if (heap.size() == 0) {
			System.out.println("Removing from an empty heap");
			return -1;
		}
		if(heap.size() == 1) {
			int temp = heap.get(0);
			heap.remove(0);
			return temp;
		}
		int head = heap.get(0);
		int temp = heap.get(heap.size()-1);
		heap.remove(heap.size()-1);
		heap.set(0, temp);
		int position = 0;
		
		while((2*position +1) < heap.size()   ) {
			int left = heap.get(2*position+1);
			int right = Integer.MAX_VALUE;
			
			if(2*position +2 < heap.size()) {
				right =heap.get((2*position) + 2);
			}
			
			if(left < right) {
				if(heap.get(position) < heap.get(2*position + 1)) {
					break;
				}
				temp = heap.get(position);
				heap.set(position, heap.get(2*position+1));
				heap.set(2*position+1, temp);
				position = 2*position+1;
			}
			else {
				temp = heap.get(position);
				heap.set(position, heap.get(2*position + 2));
				heap.set(2*position + 2, temp);
				position = 2*position + 2;
			}
		}
		return head;
		
	}
	
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	
	public int getSize() {
		return heap.size();
	}
	
	public void printing() {
		System.out.println(heap);
	}
	

	public static void main(String[] args) {
		MinHeap mh = new MinHeap();
		mh.insert(5);
		mh.insert(4);
		mh.insert(2);
		mh.insert(8);
		mh.printing();
		mh.delete();
		mh.printing();
		mh.delete();
		mh.printing();
		mh.insert(6);
		mh.printing();
		mh.delete();
		mh.delete();
		mh.printing();

	}

}
