package org.assignment.three.sorting;

public class Sort {
	
	public void sortArray( int array[], int k){
		
		//first loop
		for(int i=0 ; i<k ; i++)
		{
			//second loop
			for(int j=0 ; j<k-1 ; j++)
			{
				//check if first element is smaller than second element
				if(array[i] < array[j])
				{
					//swap the numbers
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
		
		System.out.println("Sorted List:");
		
		//display array
		for( int l=0; l<k ; l++)
		{
			System.out.println(array[l]);
		}
	}

}
