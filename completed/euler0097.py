##The first known prime found to exceed one million digits was discovered in
##1999, and is a Mersenne prime of the form 269725931; it contains exactly
##2,098,960 digits. Subsequently other Mersenne primes, of the form 2p1,
##have been found which contain more digits.
##
##However, in 2004 there was found a massive non-Mersenne prime which contains
##2,357,207 digits: 28433 * 2^7830457+1.
##
##Find the last ten digits of this prime number.

b = 1
je = 10000000000
for a in range(1,7830457+1):
    b = 2 * b
    if (b > je):
        b = b - je

print str(28433 * b + 1)[-10:]
