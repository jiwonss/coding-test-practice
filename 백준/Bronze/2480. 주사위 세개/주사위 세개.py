dice = sorted(list(map(int, input().split())))

temp, num, cnt = dice[0], 0, 0
for i in range(1, 3):
    if dice[i] == temp:
        cnt += 1
        num = dice[i]
    else:
        temp = dice[i]

result = 0
if cnt == 0:
    result = dice[-1] * 100
elif cnt == 1:
    result = 1000 + (num * 100)
else:
    result = 10000 + (num * 1000)
print(result)