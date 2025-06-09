package Mining_Simulation;
import java.security.MessageDigest;
import java.util.Date;
class Block {
// Source code is decompiled from a .class file using FernFlower decompiler.
   public int index;
   public String timestamp;
   public String data;
   public String previousHash;
   public String hash;
   public int nonce;

   public Block(int var1, String var2, String var3) {
      this.index = var1;
      this.timestamp = (new Date()).toString();
      this.data = var2;
      this.previousHash = var3;
      this.nonce = 0;
      this.hash = this.calculateHash();
   }

   public String calculateHash() {
     try {
            String input = index + timestamp + data + previousHash + nonce;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            // Convert each byte to hex
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
   }
   // Simulates Proof-of-Work mining: keep changing nonce until hash starts with required 0s
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); // e.g., "0000"
        long startTime = System.currentTimeMillis();

        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Block mined with hash: " + hash);
        System.out.println("Nonce value used: " + nonce);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}
public class Mining_Simulation {
public static void main(String[] args) {
       int difficulty = 4; // Mining difficulty (hash must start with "0000")

        System.out.println("Starting mining for Block 1...");
        Block block1 = new Block(1, "Transaction: Alice pays Bob", "0");
        block1.mineBlock(difficulty);

        System.out.println("\nStarting mining for Block 2...");
        Block block2 = new Block(2, "Transaction: Bob pays Carol", block1.hash);
        block2.mineBlock(difficulty);
}
}



