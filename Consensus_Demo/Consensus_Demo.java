// package Consensus_Demo;

// ✅ consensus_demo.java - Simulate PoW, PoS, DPoS Consensus Mechanisms

import java.util.*;

public class Consensus_Demo {
    public static void main(String[] args) {

        // Mock Validators
        Random random = new Random();

        // PoW: Select validator with highest power
        Map<String, Integer> miners = new HashMap<>();
        miners.put("Alice", random.nextInt(100));
        miners.put("Bob", random.nextInt(100));
        miners.put("Charlie", random.nextInt(100));

        String powWinner = Collections.max(miners.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("PoW - Mining Power:");
        miners.forEach((k, v) -> System.out.println(k + ", Power: " + v));
        System.out.println("PoW selects the validator with the highest mining power.");
        System.out.println("PoW Selected Validator: " + powWinner);
        System.out.println("--------------------------------------------------");

        // PoS: Select validator with highest stake
        Map<String, Integer> stakers = new HashMap<>();
        stakers.put("Alice", random.nextInt(100));
        stakers.put("Bob", random.nextInt(100));
        stakers.put("Charlie", random.nextInt(100));

        String posWinner = Collections.max(stakers.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("PoS - Staking:");
        stakers.forEach((k, v) -> System.out.println(k + ", Stake: " + v));
        System.out.println("PoS selects the validator with the highest staked coins.");
        System.out.println("PoS Selected Validator: " + posWinner);
        System.out.println("--------------------------------------------------");

        // DPoS: Voters elect a delegate
        Map<String, Integer> votes = new HashMap<>();
        votes.put("Alice", 0);
        votes.put("Bob", 0);
        votes.put("Charlie", 0);

        String[] voters = {"Voter1", "Voter2", "Voter3"};
        for (String voter : voters) {
            String vote = new ArrayList<>(votes.keySet()).get(random.nextInt(3));
            votes.put(vote, votes.get(vote) + 1);
            System.out.println(voter + " voted for " + vote);
        }

        String dposWinner = Collections.max(votes.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("DPoS - Voting Delegates:");
        votes.forEach((k, v) -> System.out.println(k + ", Votes: " + v));
        System.out.println("DPoS selects a delegate by majority voting.");
        System.out.println("DPoS Selected Delegate: " + dposWinner);
    }
} 
