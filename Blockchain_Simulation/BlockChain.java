//Blockchain class to manage the list of blocks and provide methods for adding new blocks.
import java.util.ArrayList;
public class BlockChain {
     public ArrayList<Block> chain;

    public BlockChain() {
        chain = new ArrayList<>();
        chain.add(createGenesisBlock()); // First block
    }

    // Creates the first block of the chain
    private Block createGenesisBlock() {                            // createGenesisBlock() method is marked private because: we should never call it from outside the Blockchain class.


        System.out.println("Creating Genesis Block...");
        return new Block(0, "Genesis Block", "0");
    }
    
     // Returns the last block in the chain
    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    // Adds a new block to the chain
    public void addBlock(Block newBlock) {
        newBlock.previousHash = getLatestBlock().hash;
        newBlock.hash = newBlock.calculateHash();
        chain.add(newBlock);
        System.out.println("Block " + newBlock.index + " added to blockchain.");
    }

     // Validates if the blockchain is still secure
    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block current = chain.get(i);
            Block previous = chain.get(i - 1);

            if (!current.hash.equals(current.calculateHash())) {
                System.out.println("Block " + current.index + " has invalid hash.");
                return false;
            }

            if (!current.previousHash.equals(previous.hash)) {
                System.out.println("Block " + current.index + " has invalid previous hash.");
                return false;
            }
        }
        return true;
    }

    // Prints details of all blocks in the chain
    public void printFieldsOfChain() {
        for (Block block : chain) {
            System.out.println("Block Index: " + block.index);
            System.out.println("Data: " + block.data);
            System.out.println("Timestamp: " + block.timestamp);
            System.out.println("Previous Hash: " + block.previousHash);
            System.out.println("Hash: " + block.hash);
            System.out.println("Nonce: " + block.nonce);
            System.out.println("----------------------------------------");
        }
    }
}
