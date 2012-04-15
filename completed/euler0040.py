#An irrational decimal fraction is created by concatenating the positive integers:
#
#0.123456789101112131415161718192021...
#
#It can be seen that the 12th digit of the fractional part is 1.
#
#If dn represents the nth digit of the fractional part, find the value of the following expression.
#
#d1 * d10 * d100 * d1000 * d10000 * d100000 * d1000000

max = 1000000
l = [1] * 9
size = 0
i = 0
old_size = 0


while size <= max:
	i += 1
	size += len(str(i))
	if (len(str(size)) != len(str(old_size))):
		res = str(str(i)[len(str(i))-int(str(size)[-1])-1])
		l[len(str(size))] = res
	old_size = size

out = 1
for r in l[1:]:
	out *= int(r)
	
print out

