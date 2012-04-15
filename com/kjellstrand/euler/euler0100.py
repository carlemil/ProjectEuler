# If a box contains twenty-one coloured discs, composed of fifteen blue discs and six 
# red discs, and two discs were taken at random, it can be seen that the probability 
# of taking two blue discs, P(BB) = (15/21)(14/20) = 1/2.

# The next such arrangement, for which there is exactly 50% chance of taking two blue 
# discs at random, is a box containing eighty-five blue discs and thirty-five red discs.

# By finding the first arrangement to contain over 10^12 = 1,000,000,000,000 discs in total, 
# determine the number of blue discs that the box would contain.

import math, time

t = time.time()

#start = 1000000000000.0
#blue = 707106781120.0

#3312555
#5.828422877
#4411350149316

#start = 4411350149316
blue = 4411350149316
red = 1827241049316
loop = True
totalmin=1216936346132000000000000000000

while (loop):
	sum = blue+red
	total = ((blue* (blue-1))*2) - (sum*(sum-1))
	#print "total: " + str(total)
	#sum = blue+red
	#Decimal(1) / Decimal(7)
	#half = (blue / sum) * ((blue-1) / (sum-1))
	#print half
	#if (sum%1000==0):
	#print "sum: %i" % sum
	#print (int(half*1000000)+1)
	if abs(total)<totalmin:
		totalmin=abs(total)
	print total
	if total == 0:
		print "%i" % blue
		#print "red: %i" % red
		loop = False
		red += 1
	elif total > 0:
		#print "red %i " % red
		red += 1
	elif total < 0:
		#print "blue %i " % blue
		blue += 1
	
	#if total > 10000000:
	#		loop = False
	
print "\ntime: " + str(time.time() - t) + " s"
