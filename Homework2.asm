# Name: Syed Obaid Quadri
# Purpose of program: This program prompts the user to enter a string. It then loops through 
# the letters in the string to find the number of letters and words in the string and displays it.

.data	
	prompt:		.asciiz "Enter some text"
	message1:	.asciiz " words "
	message2:	.asciiz " characters"
	message3:	.asciiz "Goodbye!"
	strLength:	.word 200	
	string:		.space 100	
	letterCount:	.word 0
	wordCount:	.word 0
	
	
	
.text

		# display the prompt in a dialog box and ask the user to input in a message
	Loop1:	la $a0, prompt
		la $a1, string
		lw $a2, strLength
		li $v0, 54  	# syscall number for displaying dialog box
		syscall
	
		beq $a1, -3, goodbyeMsg  # check if string is empty, if so break out of loop
		beq $a1, -2, goodbyeMsg  # check if user chose cancel
			
		la $a0, string
		lw $a1, strLength
		jal Count
		
		# store the returns of the function Count - $v0, $v1 in memory
		sw $v0, letterCount
		sw $v1, wordCount
		
		# display the string
		la $a0, string
		li $v0, 4
		syscall
		
		# display word count
		lw $a0, wordCount
		li $v0, 1
		syscall
			
		# display "words" after number of words
		la $a0, message1
		li $v0, 4
		syscall
			
		# display letter count
		lw $a0, letterCount
		li $v0, 1
		syscall
		
		# display "letters" after number of letters
		la $a0, message2
		li $v0, 4
		syscall
			
			j Loop1
			
   goodbyeMsg:	la $a0, message3
		li $v0, 59
		syscall
			
		# exit the program
		li $v0, 10
		syscall	
		

		# push $s1 to stack 
	Count:	addi $sp, $sp, -4
		sw $s1, ($sp)
		addi $s1, $a0, 0	
			
		li $t0, 0  # letter count
		li $t1, 1  # word count
		
	Loop2:	lb $t2, ($s1)
		beq $t2, '\n', pop
		beq $t2, '\0', pop
			
		addi $t0, $t0, 1  # increment the letter count
		beq $t2, ' ', wordPlus  # if $t2 is a space, increment the word count
		j stackPlus
		
		
		
     wordPlus:	addi $t1, $t1, 1  # increment the word count

		
    stackPlus:	addi $s1, $s1, 1
		j Loop2
		
		
		# pop $s1 off the stack
	pop:	lw $s1, 0($sp)
		addi $sp, $sp, 4
		
		# store letterCount($t0) and wordCount($t1) in return values $v0, $v1
		addi $v0, $t0, 0
		addi $v1, $t1, 0
		jr $ra
		
	
			
		
