import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {
    int n = 1_000_000_000; // Upper limit
    boolean[] isPrime = new boolean[n + 1];

    for (int i = 2; i <= n; i++) {
      isPrime[i] = true;
    }

    for (int p = 2; p * p <= n; p++) {
      if (isPrime[p]) {
        for (int i = p * p; i <= n; i += p) {
          isPrime[i] = false;
        }
      }
    }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter("primes.txt"))) {
      for (int i = 2; i <= n; i++) {
        if (isPrime[i]) {
          writer.write(Integer.toString(i));
          writer.newLine();
        }
      }
      System.out.println("Prime numbers up to " + n + " have been saved to primes.txt.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
