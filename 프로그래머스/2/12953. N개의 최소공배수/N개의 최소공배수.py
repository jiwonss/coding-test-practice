from collections import deque

def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a

def lcm(a, b):
    return (a * b) // gcd(a, b)

def solution(arr):
    q = deque(arr)
    while len(q) != 1:
        for i in range(len(q) - 1):
            a, b = q.popleft(), q.popleft()
            q.append(lcm(a, b))
    return q[0]