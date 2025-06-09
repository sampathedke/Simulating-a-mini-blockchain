Building a Simple Blockchain
This project simulates the core components of blockchain technology using Java. It includes:

✅ Basic blockchain simulation with linked blocks

🔢 Mining simulation with Proof-of-Work (nonce + difficulty)

🗳️ Consensus simulation for PoW, PoS, and DPoS


Folder Structure

Blockchain_Mini_Task/

├── Blockchain_Simulation/

│   ├── Block.java

│   ├── Blockchain.java

│   └── Blockchain_Simulation.java


├── Mining_Simulation/

│   └── Mining_Simulation.java


└── Consensus_Demo/
    ─ Consensus_Demo.java


1. Blockchain Simulation:
   
   i)Created a Block class with:
   
       -index, timestamp, data, previousHash, hash, and nonce
   
   ii)Implemented a simple hash generator using SHA-256
   
   iii)Each block is linked using the previous hash
   
   iV)Display all blocks with their hashes
   
Understanding how tampering one block affects the entire chain.

3. Mining Simulation (Proof of Work):
   
    i)Simulates mining with nonce and difficulty
   
    ii)Hash is recalculated until it starts with "0000" (or more zeros)
   
    iii)Shows final hash, nonce used, and time taken
   
Experienced how computational effort increases with difficulty.


3.Consensus Mechanism Demo (PoW, PoS, DPoS)

  i)PoW: Selects validator with highest mining power
  
  ii)PoS: Selects validator with highest stake
  
  iii)DPoS: Simulates votes from voters and picks the winner

📌 How to Run in Terminal

    Compile:  javac FileName.java
    
    Run:      java FileName
