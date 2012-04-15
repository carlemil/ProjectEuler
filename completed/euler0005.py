#2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

#What is the smallest number that is evenly divisible by all of the numbers from 1 to 20?
a=0
found_it = False
while not found_it:
	a += 20
	if a%20==0 and a%19==0 and a%18==0 and a%17==0 and a%16==0 and a%15==0 and a%14==0 and a%13==0 and a%12==0 and a%11==0 and a%10==0 and a%9==0 and a%8==0 and a%7==0 and a%6==0 and a%5==0 and a%4==0 and a%3==0 and a%2==0:
		found_it = True
		
print a
