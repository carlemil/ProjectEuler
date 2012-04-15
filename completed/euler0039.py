#If p is the perimeter of a right angle triangle with integral length sides, 
#{a,b,c}, there are exactly three solutions for p = 120.
#
#{20,48,52}, {24,45,51}, {30,40,50}
#
#For which value of p  1000, is the number of solutions maximised?

max = 1000
l = [0] * max

for p in range(1, max):
	for a in range(1, p-2):
		for b in range(a+1, p):
			if b+a >= p-1:
				continue
			c = p-(a+b)
			if c < b:
				continue
			if b < c:
				if c*c == b*b + a*a:
					l[p] += 1
	
mn = 0
mi = 0
for i in range(0, max):
	if l[i]>mn:
		mn = l[i]
		mi = i
print mi
