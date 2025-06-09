public class Blockchain_Simulation {
    public static void main(String[] args) {
        BlockChain myChain = new BlockChain();

        System.out.println("Adding new blocks...");
        myChain.addBlock(new Block(1, "Transcation: 1000", myChain.getLatestBlock().hash));
        myChain.addBlock(new Block(2, "Transcation: 2000", myChain.getLatestBlock().hash));

        System.out.println("\nCurrent Blockchain State:");
        myChain.printFieldsOfChain();

        System.out.println("\nIs blockchain valid? " + myChain.isChainValid());

        // Simulating tampering
        System.out.println("\nTampering with Block 1 data...");
        myChain.chain.get(1).data = "Transcation: 1500"; // Modifying data
        myChain.chain.get(1).hash = myChain.chain.get(1).calculateHash(); // Recalculate hash

        System.out.println("\n Blockchain After Tampering:");
        myChain.printFieldsOfChain();

        System.out.println("\nIs blockchain still valid? " + myChain.isChainValid());
    }
}
