from collections import Counter
from functools import reduce

def solution(clothes):
    counter = Counter([t for n, t in clothes])
    return reduce(lambda x , y : x * (y + 1), counter.values(), 1) - 1