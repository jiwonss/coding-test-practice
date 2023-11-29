from sys import stdin
from math import sqrt
input = stdin.readline

def prime_number(x):
    for i in range(2, int(sqrt(x)) + 1):
        if arr[i]:
            j = 2
            while i * j <= n:
                arr[i * j] = 0
                j += 1
                
    for i in range(2, x + 1):
        if arr[i]:
            num.append(i)

n = int(input())
arr = [1] * (n + 1)

num = []
prime_number(n)
num += [0]
left, right = 0, 0
t = num[0]
answer = 0
while  right < len(num) - 1:
    if t < n:
        right += 1
        t += num[right]
    else:
        if t == n:
            answer += 1
            right += 1
            t += num[right]
        t -= num[left]
        left += 1
print(answer)
