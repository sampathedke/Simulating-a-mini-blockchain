import java.util.*;
import java.security.MessageDigest;      //This library is used to create a secure hash (SHA-256).

public class Block {
    public int index;
    public String timestamp;
    public String data;
    public String previousHash;
    public String hash;
    public int nonce;

    // Constructor to initialize a block
    public Block(int index,String data, String previousHash ){
        this.index=index;  //The position of the block in the chain.
        this.timestamp = new Date().toString();  //The Time when block created
        this.data = data;       //the actual transaction or data
        this.previousHash = previousHash;  //the hash of previous block in the chain
        this.nonce = 0; 
        this.hash = calculateHash();   //the hash is calculated when created,call the calaculateHash() method
    }

    // Implementing SHA-256 Hashing. This is crucial for maintaining the integrity of our blockchain.
public String calculateHash(){

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
}
