##Starting in the top left corner of a 2x2 grid, there are 6 routes
##(without backtracking) to the bottom right corner.
##
##How many routes are there through a 20x20 grid?

import math

size = 21
g = [ [i*0 for j in range(i)] for i in range(size)]
g += [ [i*0 for j in range(size-i)] for i in range(size)]

g[1][0]=1
for i in range(2,size*2):
    for j in range(0,size-math.fabs(size-i)):
        if i<=size:
            if j==0:
                g[i][j]=g[i-1][j]
            elif j==i-1:
                g[i][j]=g[i-1][j-1]
            else:
                g[i][j]=g[i-1][j]+g[i-1][j-1]
        else:
            g[i][j]=g[i-1][j]+g[i-1][j+1]

print g[size*2-1][0]
