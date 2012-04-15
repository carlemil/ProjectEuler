# -*- coding: cp1252 -*-
##Consider the problem of building a wall out of 2x1 and 3x1 bricks
##(horizontalvertical dimensions) such that, for extra strength,
##the gaps between horizontally-adjacent bricks never line up in
##consecutive layers, i.e. never form a "running crack".
##
##For example, the following 93 wall is not acceptable due to the
##running crack shown in red:
##
##There are eight ways of forming a crack-free 93 wall,
##written W(9,3) = 8.
##
##Calculate W(32,10).

#permutera fram alla på en mittenlinje, räkna till kanten från den.
#åt båda hållen och med chache. samt gång ihopp resultaten. funka ???


w = 32
h = 2+2
wall =[ 0 for i in range(h) ]


## byta sa att vi gar nerifran - upp och inte hoger - vanster
def perm(i,b):
    ## use cache for full rows
    ## look in cache to see if we did this one before
    ## cache shoule be array 0-9 with bin trees in. 
    wall[i]+=b

    if wall[i] <= w-2:
        if wall[i] == wall[i-1] or wall[i] == wall[i+1]:
            return 0
    elif wall[i] != w:
        return 0
    
    valids = 0
    for val in range(1,h-1):
        if wall[val] == w:
            valids += 1
    if valids == h-2:
        return 1

    mini = 1
    for i in range(1,h-1):
        if wall[i] < wall[mini]:
            mini = i

    tva = perm(mini,2)
    #print "tva %d" % (tva)
    wall[mini] -= 2
    tre = perm(mini,3)
    wall[mini] -= 3
    return tva + tre


wall =[ 0 for i in range(h) ]
sum_tva = perm(1,2)
wall =[ 0 for i in range(h) ]
sum_tre = perm(1,3)

#print wall
print sum_tva + sum_tre
