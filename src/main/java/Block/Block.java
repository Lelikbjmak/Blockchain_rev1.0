package Block;

import java.util.Date;

public class Block {
    private String hash; // hash of current block
    private final String previousHash;  // hash of previous block ti make chain
    private final String data;   // data of current block (like BTC comprises amount to transfer etc.)
    private final long timeStamp;  // timestamp of current block
    private int nonce;  // typical counter (count of iterations were made to mine block)

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateBlockHash();
    }

    public String calculateBlockHash() {
        return StringUtil.applySha256(previousHash + timeStamp + nonce + data);
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        System.out.println(target);
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateBlockHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    public long getTimeStamp() {
        return timeStamp;
    }


}
