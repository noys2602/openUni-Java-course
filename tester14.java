package university;

public class tester14 {

	
	
	public static void main(String[] args) {
		
		
		  
		 System.out.println("Test for input:");
	        System.out.println("{3,1,1,1,1},");
	        System.out.println("{1,3,1,1,1},");
	        System.out.println("{2,1,3,1,1},");
	        System.out.println("{1,2,1,3,1},");
	        System.out.println("{-1,1,1,1,3}");
	        
	        int[][] drm = { {3,1,1,1,1},
	                        {1,3,1,1,1},
	                        {2,1,3,1,1},
	                        {1,2,1,3,1},
	                        {-1,1,1,1,3}};
	                        
	        int result;
	        
	        System.out.println("\nPrince starts at 0,0:");
	        result = quest4maman14.prince (drm,0,0);
	        System.out.println(result == 5 ? "Test 1 passed." : "Wrong output.\nExpected Output:5\nYour output: " + result);
	        System.out.println("\nPrince starts at 0,1:");
	        result = quest4maman14.prince (drm,0,1);
	        System.out.println(result == -1 ? "Test 2 passed." : "Wrong output.\nExpected Output:-1\nYour output: " + result);
	        System.out.println("\nPrince starts at 0,2:");
	        result = quest4maman14.prince (drm,0,2);
	        System.out.println(result == -1 ? "Test 3 passed." : "Wrong output.\nExpected Output:-1\nYour output: " + result);
	        System.out.println("\nPrince starts at 0,3:");
	        result = quest4maman14.prince (drm,0,3);
	        System.out.println(result == -1 ? "Test 4 passed." : "Wrong output.\nExpected Output:-1\nYour output: " + result);
	        System.out.println("\nPrince starts at 0,4:");
	        result = quest4maman14.prince (drm,0,4);
	        System.out.println(result == -1 ? "Test 5 passed." : "Wrong output.\nExpected Output:-1\nYour output: " + result);
	        System.out.println("\nPrince starts at 1,0:");
	        result = quest4maman14.prince (drm,1,0);
	        System.out.println(result == 4 ? "Test 6 passed." : "Wrong output.\nExpected Output:4\nYour output: " + result);
	        System.out.println("\nPrince starts at 1,1:");
	        result = quest4maman14.prince (drm,1,1);
	        System.out.println(result == 5 ? "Test 7 passed." : "Wrong output.\nExpected Output:5\nYour output: " + result);
	        System.out.println("\nPrince starts at 1,2:");
	        result = quest4maman14.prince (drm,1,2);
	        System.out.println(result == -1 ? "Test 8 passed." : "Wrong output.\nExpected Output:-1\nYour output: " + result);
	        System.out.println("\nPrince starts at 1,3:");
	        result = quest4maman14.prince (drm,1,3);
	        System.out.println(result == -1 ? "Test 9 passed." : "Wrong output.\nExpected Output:-1\nYour output: " + result);
	        System.out.println("\nPrince starts at 1,4:");
	        result = quest4maman14.prince (drm,1,4);
	        System.out.println(result == -1 ? "Test 10 passed." : "Wrong output.\nExpected Output:-1\nYour output: " + result);
	        System.out.println("\nPrince starts at 2,0:");
	        result = quest4maman14.prince (drm,2,0);
	        System.out.println(result == 3 ? "Test 11 passed." : "Wrong output.\nExpected Output:3\nYour output: " + result);
	        System.out.println("\nPrince starts at 2,1:");
	        result = quest4maman14.prince (drm,2,1);
	        System.out.println(result == 4 ? "Test 12 passed." : "Wrong output.\nExpected Output:4\nYour output: " + result);
	        System.out.println("\nPrince starts at 2,2:");
	        result = quest4maman14.prince (drm,2,2);
	        System.out.println(result == 5 ? "Test 13 passed." : "Wrong output.\nExpected Output:5\nYour output: " + result);
	        System.out.println("\nPrince starts at 2,3:");
	        result = quest4maman14.prince (drm,2,3);
	        System.out.println(result == -1 ? "Test 14 passed." : "Wrong output.\nExpected Output:-1\nYour output: " + result);
	        System.out.println("\nPrince starts at 2,4:");
	        result = quest4maman14.prince (drm,2,4);
	        System.out.println(result == -1 ? "Test 15 passed." : "Wrong output.\nExpected Output:-1\nYour output: " + result);
	        System.out.println("\nPrince starts at 3,0:");
	        result = quest4maman14.prince (drm,3,0);
	        System.out.println(result == 2 ? "Test 16 passed." : "Wrong output.\nExpected Output:2\nYour output: " + result);
	        System.out.println("\nPrince starts at 3,1:");
	        result = quest4maman14.prince (drm,3,1);
	        System.out.println(result == 3 ? "Test 17 passed." : "Wrong output.\nExpected Output:3\nYour output: " + result);
	        System.out.println("\nPrince starts at 3,2:");
	        result = quest4maman14.prince (drm,3,2);
	        System.out.println(result == 4 ? "Test 18 passed." : "Wrong output.\nExpected Output:4\nYour output: " + result);
	        System.out.println("\nPrince starts at 3,3:");
	        result = quest4maman14.prince (drm,3,3);
	        System.out.println(result == 5 ? "Test 19 passed." : "Wrong output.\nExpected Output:5\nYour output: " + result);
	        System.out.println("\nPrince starts at 3,4:");
	        result = quest4maman14.prince (drm,3,4);
	        System.out.println(result == -1 ? "Test 20 passed." : "Wrong output.\nExpected Output:-1\nYour output: " + result);
	        System.out.println("\nPrince starts at 4,0:");
	        result = quest4maman14.prince (drm,4,0);
	        System.out.println(result == 1 ? "Test 21 passed." : "Wrong output.\nExpected Output:1\nYour output: " + result);
	        System.out.println("\nPrince starts at 4,1:");
	        result = quest4maman14.prince (drm,4,1);
	        System.out.println(result == 2 ? "Test 22 passed." : "Wrong output.\nExpected Output:2\nYour output: " + result);
	        System.out.println("\nPrince starts at 4,2:");
	        result = quest4maman14.prince (drm,4,2);
	        System.out.println(result == 3 ? "Test 23 passed." : "Wrong output.\nExpected Output:3\nYour output: " + result);
	        System.out.println("\nPrince starts at 4,3:");
	        result = quest4maman14.prince (drm,4,3);
	        System.out.println(result == 4 ? "Test 24 passed." : "Wrong output.\nExpected Output:4\nYour output: " + result);
	        System.out.println("\nPrince starts at 4,4:");
	        result = quest4maman14.prince (drm,4,4);
	        System.out.println(result == 5 ? "Test 25 passed." : "Wrong output.\nExpected Output:5\nYour output: " + result);
			

	}

}
