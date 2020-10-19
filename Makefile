run: VigenereCipher.class
	java VigenereCipher $(ARGS)

Playfair.class: VigenereCipher.java
	javac VigenereCipher.java

clean:
	rm*.class