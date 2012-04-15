# We shall define a square lamina to be a square outline with a square "hole" so that the
# shape possesses vertical and horizontal symmetry. For example, using exactly thirty-two
# square tiles we can form two different square laminae:

# With one-hundred tiles, and not necessarily using all of the tiles at one time, it is
# possible to form forty-one different square laminae.

# Using up to one million tiles how many different square laminae can be formed?

inner = 2
outer = 2
bound = 1000000
total = 0

def getTileCount(a, b):
    c = 0
    d = (b - a) / 2 + a
    g = ((b - a) / 2 + 1)
    f = d * g * 4 - g * 4
    return f

while inner <= bound/4:
    inner = inner + 1
    outer = inner
    while outer < bound:
        tc = getTileCount(inner, outer)
        if tc <= bound:
            total = total + 1
        else:
            outer = bound
        outer = outer + 2

print "\n\nTOTAL: " + str(total) + "\n"


