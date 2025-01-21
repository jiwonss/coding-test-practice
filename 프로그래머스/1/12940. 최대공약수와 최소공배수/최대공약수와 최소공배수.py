def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def lcm(a, b):
    return (a * b) // gcd(a, b)

def solution(n, m):
    a, b = [n, m] if n > m else [m, n]
    return [gcd(a, b), lcm(a, b)]