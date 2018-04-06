package project.euler.me;

import java.math.BigInteger;

public class ProjectEuler1To10 {
	public static void main(String[] args) {
		maxPrimeFactor();
		largestPalindrome();
		lcm();
		sumSqaureDiff();
		NthPrime();
		largestProductInASerie();
		specialPythagoreanTriplet();
	}

	static void specialPythagoreanTriplet() {
		int n = 12;
		System.out.println(specialPythagoreanTriplet(n));
		n = 1000;
		System.out.println(specialPythagoreanTriplet(n));
	}

	static long specialPythagoreanTriplet(int n) {
		for (long a = 1; a < n; a++) {
			for (long b = a + 1; b < n; b++) {
				long c = n - a - b;
				if (a * a + b * b == c * c) // Note: This implies b < c
					return (a * b * c);
			}
		}
		return -1;
	}

	static void largestProductInASerie() {
		String num = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		int n = 4;
		System.out.println(largestProductInASerie(num, n));
		n = 13;
		System.out.println(largestProductInASerie(num, n));
	}

	static long largestProductInASerie(String num, int n) {
		long max = -1;
		for (int i = 0; i + n <= num.length(); i++) {
			long prod = 1;
			for (int j = 0; j < n; j++)
				prod *= num.charAt(i + j) - '0';
			max = Math.max(prod, max);
		}
		return max;
	}

	static boolean isPrime(long n) {
		if (n == 2)
			return true;
		if (n % 2 == 0 || n == 1)
			return false;
		long limit = (long) Math.sqrt(n);
		for (int i = 3; i <= limit; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}

	static void NthPrime() {
		int n = 6;
		System.out.println(NthPrime(n));
		n = 10001;
		System.out.println(NthPrime(n));

	}

	static int NthPrime(int n) {
		int count = 0;
		int i = 1;
		while (count < n) {
			if (isPrime(i))
				++count;
			i++;
		}
		return (i - 1);
	}

	static void sumSqaureDiff() {
		int n = 10;
		System.out.println(sumSqaureDiff(n));
		n = 100;
		System.out.println(sumSqaureDiff(n));
	}

	static int sumSqaureDiff(int n) {
		int sum = 0;
		int sum2 = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
			sum2 += i * i;
		}
		return (sum * sum - sum2);
	}

	static long maxPrimeFactors(long n) {
		// Initialize the maximum prime
		// factor variable with the
		// lowest one
		long maxPrime = -1;

		// Print the number of 2s
		// that divide n
		while (n % 2 == 0) {
			maxPrime = 2;

			// equivalent to n /= 2
			n >>= 1;
		}

		// n must be odd at this point,
		// thus skip the even numbers
		// and iterate only for odd
		// integers
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				maxPrime = i;
				n = n / i;
			}
		}

		// This condition is to handle
		// the case when n is a prime
		// number greater than 2
		if (n > 2)
			maxPrime = n;

		return maxPrime;
	}

	// Function to calculate largest
	// palindrome which isproduct of
	// two n-digits numbers
	static int larrgestPalindrome(int n) {
		int upper_limit = 0;

		// Loop to calculate upper bound
		// (largest number of n-digit)
		for (int i = 1; i <= n; i++) {
			upper_limit *= 10;
			upper_limit += 9;
		}

		// largest number of n-1 digit.
		// One plus this number
		// is lower limit which is
		// product of two numbers.
		int lower_limit = 1 + upper_limit / 10;

		// Initialize result
		int max_product = 0;

		for (int i = upper_limit; i >= lower_limit; i--) {
			for (int j = i; j >= lower_limit; j--) {
				// calculating product of two
				// n-digit numbers
				int product = i * j;
				if (product < max_product)
					break;
				int number = product;
				int reverse = 0;

				// calculating reverse of product
				// to check whether it is
				// palindrome or not
				while (number != 0) {
					reverse = reverse * 10 + number % 10;
					number /= 10;
				}

				// update new product if exist and if
				// greater than previous one
				if (product == reverse && product > max_product)
					max_product = product;
			}
		}
		return max_product;
	}

	private static void maxPrimeFactor() {
		Long n = 15l;
		System.out.println(maxPrimeFactors(n));

		n = 25698751364526l;
		System.out.println(maxPrimeFactors(n));
		n = 600851475143l;
		System.out.println(maxPrimeFactors(n));

	}

	private static void largestPalindrome() {
		int n = 2;
		System.out.println(larrgestPalindrome(n));
		n = 3;
		System.out.println(larrgestPalindrome(n));
	}

	static void lcm() {
		int n = 10;
		System.out.println(lcm(n));
		n = 20;
		System.out.println(lcm(n));
	}

	static long lcm(int n) {
		long ans = 1;
		for (long i = 1; i <= n; i++)
			ans = (ans * i) / (gcdThing(ans, i));
		return ans;
	}

	static long gcdThing(long a, long b) {
		BigInteger b1 = BigInteger.valueOf(a);
		BigInteger b2 = BigInteger.valueOf(b);
		BigInteger gcd = b1.gcd(b2);
		return gcd.longValue();
	}
}
