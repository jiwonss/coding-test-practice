K, N = map(int, input().split())

# Please write your code here.
def choose(curr_num):
    if curr_num == N:
        print(*answer)
        return

    for i in range(1, K + 1):
        if len(answer) >= 2 and answer[-1] == i and answer[-2] == i:
            continue

        answer.append(i)
        choose(curr_num + 1)
        answer.pop()

answer = []
choose(0)