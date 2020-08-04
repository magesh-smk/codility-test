public final class BinaryGap {

	public static void main(String[] args) {
		BinaryGap binaryGap = new BinaryGap();

		System.out.println(binaryGap.solution(9));
		System.out.println(binaryGap.solution(1041));
		System.out.println(binaryGap.solution(529));
		System.out.println(binaryGap.solution(20));
		System.out.println(binaryGap.solution(15));
	}

	public int solution(int N) {
		String binaryString = Integer.toBinaryString(N);
		int maxLength = 0;
		int length = 0;

		char[] binaryArray = binaryString.toCharArray();
		for (int i = 0; i < binaryArray.length; i++) {
			char digit = binaryArray[i];
			if (digit == '0') {
				length++;
			} else {
				if (maxLength < length) {
					maxLength = length;
				}
				length = 0;
			}
		}
		return maxLength;
	}

}