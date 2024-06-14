from sys import stdin
input = stdin.readline

n = int(input())
stack, answer = [], []
cnt = 1
for _ in range(n):
    k = int(input())
    while cnt <= k:
        stack.append(cnt)
        answer.append("+")
        cnt += 1
    if stack[-1] != k:
        print("NO")
        exit()
    stack.pop()
    answer.append("-")
print('\n'.join(answer))
    
