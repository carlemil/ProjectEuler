#The Fibonacci sequence is defined by the recurrence relation:

#    Fn = Fn1 + Fn2, where F1 = 1 and F2 = 1.

#Hence the first 12 terms will be:

#    F1 = 1
#    F2 = 1
#    F3 = 2
#    F4 = 3
#    F5 = 5
#    F6 = 8
#    F7 = 13
#    F8 = 21
#    F9 = 34
#    F10 = 55
#    F11 = 89
#    F12 = 144

#The 12th term, F12, is the first term to contain three digits.

#What is the first term in the Fibonacci sequence to contain 1000 digits?


t = True
i = 0
a = 0
b = 1
c = 0
while t:
    i += 1
    a = c + b
    if b >= 10**999:
        print i
	t = False
    c = b
    b = a  