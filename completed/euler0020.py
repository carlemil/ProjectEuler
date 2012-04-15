#n! means n  (n  1)  ...  3  2  1

#Find the sum of the digits in the number 100!

b=1
for a in range(1,100):
   b*=a
e = 0
while b>0:
    d = b % 10
    b = b / 10
    e += d
print e

