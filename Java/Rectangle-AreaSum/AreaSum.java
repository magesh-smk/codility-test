public int Solution(int K, int L, int M, int N, int P, int Q, int R, int S) 
	// Calculate area of rectangle 1
	int width = M - K;
	int height = N - L;
	int area1 = width * height;
	 
	// Calculate area of rectangle 2
	width = R - P;
	height = S - Q;
	int area2 = width * height;
	 
	// Calculate area of intersection
	int intersectWidth = M - P;
	int intersectHeight = S - L;
	int intersectArea = intersectWidth * intersectHeight;
	 
	int sum = -1;
	 
	// If rectangles do not intersect
	if (intersectArea <= 0) {
		// Add the areas of two rectangles
		sum = area1 + area2;	
	} else {
	      // Rectangles do intersect
	      sum = (area1 + area2) - intersectArea;
	}	 
	return sum;
}

public static void main(String[] args) {
 int sum = solution(-4, 1, 2, 6, 0, -1, 4, 3);
 System.out.println("Sum of Rectagles: "+ sum);
}
