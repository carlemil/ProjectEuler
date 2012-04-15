##A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:
##
##    1/2	= 	0.5
##    1/3	= 	0.(3)
##    1/4	= 	0.25
##    1/5	= 	0.2
##    1/6	= 	0.1(6)
##    1/7	= 	0.(142857)
##    1/8	= 	0.125
##    1/9	= 	0.(1)
##    1/10	= 	0.1
#Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be
#seen that 1/7 has a 6-digit recurring cycle.
#Find the value of d 1000 for which 1/d contains the longest recurring cycle
#in its decimal fraction part.

def div_period_langd(nam, tal):
    namnare = nam
    taljare = str(tal)
    i = -1
    rest = 0
    result = ""
    rest_list = list()


    while i < 1000:
        i += 1
        if i < len(taljare):
            tmp = rest * 10 + int(taljare[i])
        else:
            tmp = rest * 10
        div = tmp / namnare 
        rest = tmp - (namnare * div)

        # debug saker
        if i == len(taljare):
            result = result + "."
        result = result + str(div)
        #print result

        if rest in rest_list:
            return len(rest_list) - rest_list.index(rest)
        rest_list.append(rest)
    

max_val = 0
l = 0
for a in range(1,1000):
    tmp = div_period_langd(a,1)
    if max_val < tmp:
        max_val = tmp
	l = a
print l
