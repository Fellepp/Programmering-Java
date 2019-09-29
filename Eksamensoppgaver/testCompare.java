public class testCompare{
	public static void main(String[]args){
		int[] testArray = {2,3,1};

		int[] sortArray = new int[testArray.length];
		for (int i = 0; i<testArray.length; i++){
			sortArray[i] = testArray[i];
		}
		for(int start = 0; start<testArray.length; start++){
			int hittilMinst = start;
			for(int j = start+1; j<testArray.length; j++){
				if(sortArray[j] < sortArray[start]) hittilMinst = j;
			}

			int lagring = sortArray[hittilMinst];
			sortArray[hittilMinst] = sortArray[start];
			sortArray[start] = lagring;
			}

			String ut = "";
			for(int i = 0; i<sortArray.length; i++){
				ut += sortArray[i] + ", ";
			}
			System.out.println(ut);
	}
}