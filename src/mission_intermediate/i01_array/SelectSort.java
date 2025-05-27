package mission_intermediate.i01_array;

public class SelectSort implements Interface {
	
	int[] arry;
	public int[] getArry() {
		return arry;
	}
	
	public void setArry(int[] arry) {
		this.arry = arry;
	}
	
	@Override
	public void sort() {
		for(int i=0;i<this.arry.length-1;i++) {
			int min = i;
			for(int j=i+1;j<this.arry.length;j++) {
				
				if(this.arry[j] < this.arry[i]) {
					min = j;
				}
			}
			swap(i,min);
		}
	}
	
	
	@Override
	public void swap(int i, int j) {
		int temp = this.arry[i];
		this.arry[i] = this.arry[j];
		this.arry[j] = temp;
	}
	
}
