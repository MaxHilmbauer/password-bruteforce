# password-bruteforce
A brute force password cracker built in kotlin.
## Get started
1. Clone the repository from github. Open the project in an IDE of your choice (e.g. [IntelliJ IDEA](https://www.jetbrains.com/idea/)).
2. Start the program
3. Type in a password
4. Cracker starts working (Depending on the length of the password entered, the cracker will need more or less time)
5. Cracker found or did not find password

## Charsets
The password cracker offers three different charsets:
- Set One: upper and lowercase letters
- Set Two: Set One + numbers
- Set Three: Set Two + special characters

All three sets are implemented in the file Charsets. You can switch the charsets by initializing the variable `charsets` in `main()` with another set from the kotlin file `Charset`.

## Length
The password cracker offers a variable length of the password. The default length is four to nine characters. The length is changeable by changing the `lengths` variable in `main()` to your desired length.

