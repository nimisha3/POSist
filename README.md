# POSist

The code can be run using the Client file with main function for taking input and finding output.
There are added comments in the code corresponding to every query.

Encryption Format :
I am ecrypting the data in  node using it ownerid and the first character of the owner name.
Procedure:
1. Convert first char of owner name into int
2. Add ownerID to this new integer to form the key
3. Add the original data string and this key to a hash map for later decryption
4. Convert the original data string to int
5. Add key to this data in int
6. Convert whole thing into String

And vice versa for decryption.

Also, I have completed 8 out of the given 10 queries. 
 
