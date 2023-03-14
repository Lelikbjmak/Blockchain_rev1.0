## Description

Small and simple implementation of [blockchain](https://en.wikipedia.org/wiki/Blockchain).

We have entire blockchain.
We produce new Block and try to mine it, after block will be mined it will be approved in blokchain.<br>

As far as u concerned Block consists of:
* previous hash
* data
* next hash
```java
  public class Block {
  
      private String hash; // hash of current block
      private final String previousHash;  // hash of previous block ti make chain
      private final String data;   // data of current block (like BTC comprises amount to transfer etc.)
      private final long timeStamp;  // timestamp of current block
      private int nonce;  // typical counter (count of iterations were made to mine block)
      
      public String calculateBlockHash() {
          return StringUtil.applySha256(previousHash + timeStamp + nonce + data);
      }
      
      getters(...){...}
      
      setters(...){...}
    }
```

We can explain `blockchain` as linkedList. Concept is absolutely the same, if we speak about structure.

We create a blockChain, 'add' several to chain, it indicates that we try to resolve this block, try to unlock it (It's called `mining`).<br>
After our tryouts end and block was exposed it will be added to chain.<br>
We mine blocks according to `diffuculty`, in a nutshell `difficulty` indicates how many possible combinations of hash exist to unlock Block.<br>
Obviously less combinations exist - less time it sonsumes to mine Block.

After we've mined several blocks let's check our chain validity. We must be sure that all block hashes are correct to assert that blockchain is valid.<br>
To reazise what `blockchain` is valid read the article at the beginning of the decsription :)

