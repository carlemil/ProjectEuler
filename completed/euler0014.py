#The following iterative sequence is defined for the set of positive integers:

#n n/2 (n is even)
#n 3n + 1 (n is odd)

#Using the rule above and starting with 13, we generate the following sequence:
#13 40 20 10 5 16 8 4 2 1
max = 1000000
mem = [-1] * max
mem[0] = 0
mem[1] = 0
#[0, 0, 1, 7, 2, 5, 8, 16, 3, 19, 6, 14, 9, 9, 17, 17, 4, 12, 20, 20,
#

def collatz(n):
    tmp.append(n)
    if n%2==0:
        return n/2
    else:
        return n*3+1

for i in range(1,max):
    tmp = list()
    n = i
    #print "start"
    #print n
    while n != 1:
        #print "asd %d" % (n)
        n = collatz(n)
	if n < max:
	    if mem[n]!=-1:
	        #print "--------%d" % (n)
	        break
    
    mem[i] = len(tmp)+mem[n]
    #print mem[i]
m = 0
for i in range(1,max):
    if mem[m] < mem[i]:
        m = i
print m
    

#print mem
