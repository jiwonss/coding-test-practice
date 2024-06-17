from sys import stdin
input = stdin.readline

n = int(input())
arr = list(map(int, input().split()))[::-1]

stack, answer = [], []
for i in range(n):
    while stack and stack[-1] <= arr[i]:
        stack.pop()
    if stack:
        answer.append(stack[-1])
    else:
        answer.append(-1)
    stack.append(arr[i])
print(*answer[::-1])