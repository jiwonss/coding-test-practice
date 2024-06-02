import math

n, k = map(int, input().split())
student = [[0] * 7 for _ in range(2)]

for i in range(n):
    a, b = map(int, input().split())
    student[a][b] += 1

room = 0
for i in student:
    for j in i:
        room += math.ceil(j / k)

print(room)
