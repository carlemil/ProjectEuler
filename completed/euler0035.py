#The number, 197, is called a circular prime because all rotations of 
#the digits: 197, 971, and 719, are themselves prime.
#
#There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31,
#37, 71, 73, 79, and 97.
#
#How many circular primes are there below one million?

from tools import is_prime
from tools import is_prime_old


cp = 0
for i in range(2,1000000):
    if is_prime_old(i):
        #print i   
        t = str(i)
        is_cp=True
        for j in range(1,len(t)):
            t = t[-1]+t[:-1]
            if not is_prime_old(int(t)):
                is_cp = False
                break
        if is_cp:
            cp += 1
print cp
