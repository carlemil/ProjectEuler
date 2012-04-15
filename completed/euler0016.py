#215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

#What is the sum of the digits of the number 2^1000?

b = 2**1000
e = 0
while b>0:
    e += b % 10
    b = (int)(b / 10)
print e

