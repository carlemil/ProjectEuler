##The number 3797 has an interesting property. Being prime itself, it is
##possible to continuously remove digits from left to right, and remain
##prime at each stage: 3797, 797, 97, and 7. Similarly we can work from
##right to left: 3797, 379, 37, and 3.
##
##Find the sum of the only eleven primes that are both truncatable from
##left to right and right to left.
##
##NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.

from tools import is_prime

min = 10
max = 739398
known_primes = [-1]*max

sum = 0
for i in range(min,max):
    s = str(i)
    t = []
    prime = True
    for j in range(0,len(s)):
        temp = s[j:].lstrip('0')
        if temp != '':
            t.append(temp)
    for j in range(1,len(s)+1):
        temp = s[:j]
        if temp != '':
            t.append(temp)
    for sp in t:
        i = int(sp)
        if known_primes[i] == 0:
            prime = False
            break
        if known_primes[i] == -1:
            if is_prime(i):
                known_primes[i] = 1
            else:
                known_primes[i] = 0
                prime = False
                break
    if prime:
        sum += i
print sum
