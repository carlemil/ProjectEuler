# How many 20 digit numbers n (without any leading zero) 
# exist such that no three consecutive digits of n have 
# a sum greater than 9?

d = [ 0 for i in range(20) ]
d[19] = 1

pos = 0

for i in d:
	#je
