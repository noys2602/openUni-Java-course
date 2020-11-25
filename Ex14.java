package university;

public class Ex14 {
	
	//-----------------------------quest 1 ----------------------
	/**
	 * the function will assure that player one wont lose at the end of the game
	 * The explanation of how the method works is described in the private methods
	 * the function complicity of time is O(n) - we are running on array with n elements one time.
     * the function complicity of space is O(1) - the program isnt creating new varibales
	 * @param array - the array of the game
	 */
	 public static void win (int[] arr){
	        //playing the game
		 	boolean tactic = evenVsOdd(arr) ;
		 	String playerOne = "Amir" ;
		 	String playerTwo = "Tamar" ;
		 	game(arr,playerOne,playerTwo,tactic);
	    }
	
	/**
	 * the function gets an array of numbers and checks if the sum of the even slots
	 * values are bigger then the odd slots values 
	 * the function complicity of time is O(n) - we are running on array with n elements one time.
     * the function complicity of space is O(1) - the program isnt creating new varibales
	 * @param array of numbers
	 * @return true if the even slots values are bigger, return false if the odd slots are bigger
	 */
	private static boolean evenVsOdd (int[] array)
	{
		int evenSum = 0 ; // sum of even slots
		int oddSum = 0 ; //sum of odd slots
		
		for (int i=0 ; i<array.length ; i++)
		{
			if (i%2 == 0)
				evenSum = evenSum + array[i] ; // adding the value of the even slots
			else
				oddSum = oddSum + array[i] ; // adding the value of the odd slots
		}
		
		if (evenSum > oddSum) //checks which sum is bigger
			return true ;
		else
			return false ;
			
			
	}

	/**
	 * the function calculate the sum of the choices of the players and print the score of each one of them.
	 * the function complicity of time is O(n) - we are running on array with n elements one time.
     * the function complicity of space is O(1) - the program isnt creating new varibales
	 * @param array of int numbers (the numbers of the game)
	 * @param playerOne player 1 name
	 * @param playerTwo player 2 name
	 * @param tactic which tactic is best for player 1 (choosing even or odd slots)
	 * 
	 */
	private static void game(int[] array, String playerOne, String playerTwo, boolean tactic){
	    	
	    	int playerOneSum = 0;
	        int playerTwoSum = 0;
	        
	        int min = 0;
	        int max = array.length-1;
	        
	        
	        
	        
	        while (min <max)
	        { // running  over the array
	        	
	        	
	        	//player 1 move
	            if(tactic) //if player one needs to move in even slots
	            { 
	                if (min % 2 == 0)
	                {
	                    playerOneSum = playerOneSum + array[min];
	                    System.out.println(playerOne + " took "+array[min] );
	                    min ++;
	                }
	                else 
	                {
	                    playerOneSum = playerOneSum + array[max];
	                    System.out.println(playerOne + " took "+array[max] );
	                    max --;
	                }
	            }
	            else //if player one needs to move in odd slots
	            {
	                if (min % 2 != 0)
	                {
	                    playerOneSum = playerOneSum + array[min];
	                    System.out.println(playerOne + " took "+array[min] );
	                    min ++;
	                }
	                else 
	                {
	                    playerOneSum = playerOneSum + array[max];
	                    System.out.println(playerOne + " took "+array[max] );
	                    max --;
	                }

	            }
	            
	            
	            //player 2 move
	            //player 2 choosing the bigger number from the edges
	            if (array[min] > array[max])
	            {
	                playerTwoSum = playerTwoSum + array[min];
	                System.out.println(playerTwo + " took "+array[min] );
	                min ++;
	            }
	            else
	            {
	                playerTwoSum = playerTwoSum + array[max];
	                System.out.println(playerTwo + " took "+array[max] );
	                max --;
	            }
	        }
	        System.out.println("Final Score:\n"+playerOne + " total " + playerOneSum +"\n"+playerTwo+" total "+playerTwoSum);
	        
	    }
	
	

	//-----------------------------quest 2 ----------------------
	/**
	 * the function will calculate and return the max triplet duplication and will print the 3 numbers of the duplication
	 * the function complicity of time is O(n) - we are running on array with n elements one time.
	 * the function complicity of space is O(1) - the program isnt creating new varibales 
	 * @param arr array of positive and negative integers
	 * @return the highest triplet duplication
	 */
	public static int findTriplet (int[] arr)
	{
		final int ZERO = 0;
		

		int min1 = Integer.MAX_VALUE ; //for the lowest number
		int min2 = Integer.MAX_VALUE ; //for the second lowest number
		
		int max1 = Integer.MIN_VALUE ; //for the highest number
		int max2 = Integer.MIN_VALUE ; //for the second highest number
		int max3 = Integer.MIN_VALUE ; //for the third highest number
		
		
		//temporary varibales for swaps 
		int tempMax1 = ZERO; 
		int tempMax2 = ZERO;
		int tempMin1 = ZERO;
		
			for (int i=ZERO ; i < arr.length ; i++)
			{//loop start
				
				
				//finding the lowest 2 numbers in the array
				//3 cases 
				
				//the number in the index i is lower then all the min numbers
				if (arr[i] <min1)
				{
					tempMin1 = min1;
					min1 = arr[i] ;
					
					min2=tempMin1 ;
				}
				//the number in the index i is equal to min1
				else if (arr[i] == min1)
				{
					min2 = arr[i] ;
				}
				//the number in the index i is higher from min1 and lower then min2
				else if (arr[i] < min2 && arr[i] > min1)
				{
					min2 = arr[i] ;
				}
				
				
				//finding the highest 3 numbers in the array
				//5 cases
				
				//the number in the index i is bigger then all the max numbers
				if (arr[i] > max1)  
				{
					tempMax1 = max1 ;
					max1 = arr[i] ;
					
					tempMax2 = max2 ;
					max2 = tempMax1 ;
					
					max3 = tempMax2 ;
					 
				}
				//the number in the index i is equal to max1 and bigger then all the other max numbers
				else if (arr[i] == max1)
				{
					tempMax2 = max2 ; 
					max2 = arr[i] ;
					
					max3 = tempMax2 ;
					 
				}
				//the number in the index i is lower than max1 and bigger then all the other max numbers
				else if (arr[i] > max2 && arr[i] < max1)
				{
					tempMax2 = max2 ;
					max2 = arr[i] ;
					
					max3 = tempMax2;
					 
				}
				//the number in the index i is lower than max1, equal to max2 and bigger then all the other max numbers
				else if (arr[i] == max2 && arr[i] < max1)
				{
					max3 = arr[i];
					 
				}
				//the number in the index i is bigger from only max3
				else if (arr[i] > max3 && arr[i] < max2)//גדול רק מהמקסימלי השלישי
				{
					max3 = arr[i] ;
					 
				}
				
			
			}//loop end
		
		
			
			//finding the biggest duplication
			//case 1 - highest 3 max numbers (array full in only positive numbers)
			//case 2 - highest 3 max numbers (array full in only negative numbers)
			//case 2 - highest positive and 2 lowest negatives (array full in only negative numbers)
			
			
			
		int firstDuplication = max1 * max2 * max3 ; 
		int secondDuplication = max1 * min1 * min2 ;
		
		if (firstDuplication > secondDuplication)
		{
			System.out.print(max1 +"  " + max2 + "  "+max3 );
			return firstDuplication;
		}
		else
		{
			System.out.print(max1 +"  " + min1 + "  "+min2 );
			return secondDuplication;
		}
		
		
		
	}

	
	//---------------------------quest 3-------------------
	/**
	 * the program is recursive and count how many time is the pattern is appering in the main string
	 * @param X for the main string
	 * @param Y for the pattern we want to count
	 * @return
	 */
	public static int  count (String X, String Y)
	{
		int xLen = X.length();
		int yLen = Y.length();
		return pattCount(X,Y,xLen,yLen) ;
		
		
	}
	/**
	 * 
	 * @param X for main string
	 * @param Y for the pattern
	 * @param i indicator for X length
	 * @param j indicator for Y length
	 * @return
	 */
	public static int pattCount(String X, String Y, int i, int j)
	{
		// Base case 1: if only one character is left
		if (i == 1 && j == 1)
			return (X.charAt(0) == Y.charAt(0)) ? 1: 0;

		// Base case 2: if input String X reaches its end,
		if (i == 0) {
			return 0;
		}

		// Base case 3: if pattern Y reaches its end, we have found subsequence
		if (j == 0) {
			return 1;
		}

		// Solution is not possible if number of characters
		// in the String is less than number of characters in the pattern
		if (j > i) {
			return 0;
		}

		// if last character of both String and pattern matches
		// else if last character of String and pattern do not match
		

		return ((X.charAt(i-1) == Y.charAt(j-1)) ? pattCount(X, Y, i - 1, j - 1) : 0) +
				pattCount(X, Y, i - 1, j);
	}
	//---------------------------quest 4-------------------
	/**
	 * the method checks if i,j indexes are valid in the 2d array
	 * @param drm the 2d array
	 * @param i drm row index
	 * @param j drm col index
	 * @return true if the indexes are valid
	 */
	public static boolean isValid(int[][] drm, int i, int j)
	{
		return (i>=0 && i<drm.length && j>=0 && j<drm[i].length) ;
	}
	
	/**
	 * using overloading
	 * A prince is searching  the evil guy. He can go to :
     * until 1 unit to higher roof ,
     * until 2 units to a lower roof
     * the roof heights are represented by 2d positive integers array with only one negetive number(-1)(evil man place)
     * calculating the minimal way path from (i,j) to the evil man(that is x,y arent known) 
	 * @param drm - 2D integers array represent roof tops heights
	 * @param i drm row index
	 * @param j drm col index
	 * @return shortest way from prince to the evil man
	 */
	public static int prince(int[][] drm, int i, int j) {

        boolean[][] visited = new boolean[drm.length][drm[0].length]; //2d array to check if the prince "visited" this square
        int min = prince(drm, i, j, visited, drm[i][j] - 1); // saves shortest way
        if (min == Integer.MAX_VALUE)
            return -1;  
        return min;
    }

	/**
	 * 
	 * @param drm 2d array to run over
	 * @param i drm row index
	 * @param j drm col index
	 * @param visited if the prince was there
	 * @param prev the previous "cell" the prince was
	 * @return
	 */
    private static int prince(int[][] drm, int i, int j, boolean[][] visited, int prev) {
        if (!isValid(drm, i, j) || visited[i][j])
            return Integer.MAX_VALUE;
        if (drm[i][j] == -1)
            return 1;
        if (drm[i][j] < prev - 2 || drm[i][j] > prev + 1)
            return Integer.MAX_VALUE;
        visited[i][j] = true;
        
        //prince possible paths
        int up = prince(drm, i - 1, j, visited, drm[i][j]); // moving up
        int down = prince(drm, i + 1, j, visited, drm[i][j]); // moving down
        int right = prince(drm, i, j - 1, visited, drm[i][j]); // moving right
        int left = prince(drm, i, j + 1, visited, drm[i][j]); // moving left
        
        visited[i][j] = false;
        int min = Math.min(Math.min(up, down), Math.min(right, left)); // saves shortest way
        if (min == Integer.MAX_VALUE)
            return min;
        return min + 1;
    }
	
	public static void main(String[] args)
	{
		System.out.println("\n------------------------------------\nTesting Question 1\n------------------------------------\n");
        System.out.println("Test for input: {16,23,30,13,14,21,19,15}\n");
        int[] coins1 = {16,23,30,13,14,21,19,15};
        Ex14.win(coins1);
       
        System.out.println("\n------------------------------------\nTesting Question 2\n------------------------------------\n");
        System.out.println("Test for input: {-4,1,-8,9,6}\n");
        int[] arr = {-4,1,-8,9,6};
        int result = Ex14.findTriplet (arr);
        System.out.println("\nfindTriplet return value is: " + result);
        System.out.println("\n(Remark to students - Note that the order of the printed numbers is not important)");

        System.out.println("\n------------------------------------\nTesting Question 3\n------------------------------------\n");
        result = Ex14.count ("subsequence","sue");
        System.out.println("count(\"subsequence\",\"sue\") return value is: " + result);

        System.out.println("\n------------------------------------\nTesting Question 4\n------------------------------------\n");
        System.out.println("Test for input:");
        System.out.println("\t{{2,0,1,2,3},");
        System.out.println("\t {2,3,5,5,4},");
        System.out.println("\t {8,-1,6,8,7},,");
        System.out.println("\t {3,4,7,2,4},");
        System.out.println("\t {2,4,3,1,2}}");
        
        int[][] drm = { {2,0,1,2,3},
                        {2,3,5,5,4},
                        {8,-1,6,8,7},
                        {3,4,7,2,4},
                        {2,4,3,1,2}};
        result = Ex14.prince (drm,0,0);
        System.out.println("\nprince (drm,0,0) return value is: " + result);
        result = Ex14.prince (drm,4,4);
        System.out.println("\nprince (drm,4,4) return value is: " + result);
	}
	
	
	
	
	
	

}
