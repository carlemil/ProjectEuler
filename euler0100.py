import math

#If a box contains twenty-one coloured discs, composed of fifteen blue discs and six red discs, and two discs were taken at random, it can be seen that the probability of taking two blue discs, P(BB) = (15/21)(14/20) = 1/2.

#The next such arrangement, for which there is exactly 50% chance of taking two blue discs at random, is a box containing eighty-five blue discs and thirty-five red discs.

#By finding the first arrangement to contain over 10^12 = 1,000,000,000,000 discs in total, determine the number of blue discs that the box would contain.

start = 1000 
#1000000000000;
blue = start*0.70710666

while (True):
	sum = blue * (blue - 1) * 2

	val = math.sqrt(sum)
	tot1 = val * (val - 1)
	tot2 = val * (val + 1)

	print "blue: %d" % blue
	print "val: %d" % val
	print "tot1: %d" % tot1
	print "tot2: %d" % tot2
	print "sum: %d" % sum
	print "tot1-sum: %d" % (tot1-sum)
	print "tot2-sum: %d" % (tot2-sum)
	if (tot1 > start and tot1 == sum):
		print "blue: %d" % blue
		print "val: %d" % val
		print "res: %d" % tot
		break
	blue = blue + 1
	break
