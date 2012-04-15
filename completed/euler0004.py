#A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91  99.

#Find the largest palindrome made from the product of two 3-digit numbers.

def is_palindromic(a):
	return str(a) == str(a)[::-1]
seed=999
a = seed
b = seed
max = 0
while a > 1:
	while b >= a:
		if is_palindromic(a*b) and a*b > max:
			max = a*b
		b -= 1
	a -= 1
	b = seed
print max
