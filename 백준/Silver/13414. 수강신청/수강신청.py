from sys import stdin
input = stdin.readline


def solve():
    K, L = map(int, input().split())

    waiting_list = {}
    for i in range(L):
        id = input().strip()
        waiting_list[id] = i

    result = sorted(waiting_list.items(), key=lambda x: x[1])
    for k, v in result[:K]:
        print(k)


if __name__ == "__main__":
    solve()
