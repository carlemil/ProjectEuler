#The prime factors of 13195 are 5, 7, 13 and 29.

#What is the largest prime factor of the number 600851475143 ?

import math

def is_prime(a):
	i = 1
	asqrt = int(math.sqrt(a))
	while i < asqrt:
		i += 1
		if a % i == 0:
			return False
	return True

bn = 600851475143
a = 0
p = 0
while a<bn:
	a+=1
	if bn%a==0:
		bn = bn/a
		if is_prime(a) and a > p:
			p = a
		a = 1
print p
