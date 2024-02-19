from sys import stdin
input = stdin.readline

n = int(input())
u = set()
for _ in range(n):
    u.add(int(input()))

result = set()
for i in u:
    for j in u:
        result.add(i + j)

answer = []
for i in u:
    for j in u:
        if (i - j) in result:
            answer.append(i)
print(sorted(answer)[-1])