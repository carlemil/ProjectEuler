#Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

#1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

#Find the sum of all the even-valued terms in the sequence which do not exceed four million.

p=0
t=0
a=1
s=0
while a < 4000000:
	t=a
	a+=p
	p=t
	if a%2==0:
		s+=a
print s
	

