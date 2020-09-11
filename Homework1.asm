.data
	a: 		.word 0
	b: 		.word 0
	c: 		.word 0
	ans1: 		.word 0
	ans2: 		.word 0
	ans3: 		.word 0
	name: 		.space 20
	namePrompt: 	.asciiz "Enter your name "
	integerPrompt: 	.asciiz "Please enter an integer between 1-100 "
	resultPrompt: 	.asciiz "\nYour answers are:"
	
.text

	# Get and store the user name
	
	li	$v0, 4		# Print string
	la 	$a0, namePrompt
	syscall
	
	li 	$v0, 8		# Get string from user
	la 	$a0, name
	li 	$a1, 20
	syscall
	
	# Get and store 3 integers
	
	li 	$v0, 4		# Print string
	la 	$a0, integerPrompt
	syscall
	
	li 	$v0, 5		# Get integer from user
	syscall
	sw 	$v0, a	
	
	li 	$v0, 4		# Print string
	la 	$a0, integerPrompt
	syscall
	
	li 	$v0, 5		# Get integer from user
	syscall
	sw 	$v0, b
	
	li 	$v0, 4		# Print string
	la 	$a0, integerPrompt
	syscall
	
	li 	$v0, 5		# Get integer from user
	syscall
	sw 	$v0, c
	
	# Calculate ans1, ans2,  ans3
	
	lw 	$s1, a		# Calculate ans1
	lw 	$s2, a
	add 	$t0, $s1, $s2	# (a + a)
	sw 	$t0, ans1
	
	lw 	$s1, ans1
	lw 	$s2, c
	sub 	$t0, $s1, $s2	# (a + a) - c
	sw 	$t0, ans1
	
	lw 	$s1, ans1
	add 	$t0, $s1, 4	# (a + a - c) + 4
	sw 	$t0, ans1
	
	lw 	$s1, a		# Calculate ans2
	sub 	$t0, $s1, 2	# (a - 2)
	sw 	$t0, ans2
	
	lw 	$s1, ans2
	lw 	$s2, c
	sub 	$t0, $s1, $s2	# (a - 2) - c
	sw, 	$t0, ans2
	
	lw 	$s1, ans2
	lw 	$s2, b
	add 	$t0, $s1, $s2	# (a - 2 - c) + b
	sw 	$t0, ans2
	
	lw 	$s1, a		# Calculate ans3
	lw 	$s2, b
	lw 	$s3, c
	add 	$t0, $s1, 3 	# (a + 3)
	sub 	$t1, $s2, 1	# (b - 1)
	add 	$t2, $s3, 3	# (c + 3)
	sub 	$t3, $t0, $t1	# (a + 3) - (b - 1)
	add 	$t3, $t3, $t2	# (a + 3) - (b - 1) + (c + 3)
	sw 	$t3, ans3
	
	# Output 
	
	li 	$v0, 4		# Print name
	la 	$a0, name
	syscall
	
	li 	$v0, 4		# Print result prompt
	la 	$a0, resultPrompt
	syscall
	
	lw 	$a0, ans1	# Output ans1
	li 	$v0, 1
	syscall
	
	li 	$a0, 32		# Printing space
	li 	$v0, 11  
	syscall
	
	lw 	$a0, ans2	# Output ans2
	li 	$v0, 1
	syscall
	
	li 	$a0, 32		# Printing space
	li 	$v0, 11  
	syscall
	
	lw 	$a0, ans3	# Output ans3
	li 	$v0, 1
	syscall
	
	# end program
	li	$v0, 10
	syscall