from sys import stdin
input = stdin.readline


def solve():
    idx = 1
    while True:
        L, P, V = map(int, input().split())

        if V == 0:
            break

        result = V // P * L + min(V % P, L)
        print(f'Case {idx}: {result}')
        idx += 1


if __name__ == "__main__":
    solve()
