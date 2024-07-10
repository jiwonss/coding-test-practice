from sys import stdin
input = stdin.readline


def solve():
    S = input().strip()

    temp = []
    for i in range(len(S)):
        temp.append(S[i:])

    result = sorted(temp)
    for r in result:
        print(r)


if __name__ == "__main__":
    solve()
