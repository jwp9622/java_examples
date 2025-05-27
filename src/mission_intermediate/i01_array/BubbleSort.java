package mission_intermediate.i01_array;

class BubbleSort implements Interface{
	int[] arry;
	
	public int[] getArry() {
		return arry;
	}
	public void setArry(int[] arry) {
		this.arry = arry;
	}

	@Override
	public void sort() {
		
		for(int i=1;i<this.arry.length;i++) {
			for(int j=0;j<this.arry.length-1;j++) {
				if( this.arry[j] > this.arry[j+1]) {
					swap(j,j+1);
				}
			}
		}
	}

	@Override
	public void swap(int i, int j) {
		int temp = this.arry[i];
		this.arry[i] = this.arry[j];
		this.arry[j] = temp;
	}
	
	
	
}
