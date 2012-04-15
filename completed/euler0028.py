## 43 44 45 46 47 48 49 50
## 42 21 22 23 24 25 26 51
## 41 20  7  8  9 10 27 52
## 40 19  6  1  2 11 28 53
## 39 18  5  4  3 12 29 54
## 38 17 16 15 14 13 30 55
## 37 36 35 34 33 32 31 56
##                      57

##1 3 13 31 57
##  2 10 18 26
##1 5 17 37 65
##  4 12 20 28
##1 7 21 43
##  6 14 22
##1 9 25 49
##  8 16 24

a=0
b=0
c=0
d=0
size = 501

t=2
a=1
aa=0
for i in range(1, size):
    a += t
    t += 8
    aa+=a

t=4
b=1
bb=0
for i in range(1, size):
    b += t
    t += 8
    bb+=b
    
t=6
c=1
cc=0
for i in range(1, size):
    c += t
    t += 8
    cc+=c

t=8
d=1
dd=0
for i in range(1, size):
    d += t
    t += 8
    dd+=d

print aa+bb+cc+dd+1

