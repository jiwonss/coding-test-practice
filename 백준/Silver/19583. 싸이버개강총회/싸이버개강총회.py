from sys import stdin
input = stdin.readline


def solve():
    S, E, Q = input().split()

    member, result = {}, set()
    while True:
        try:
            log = input().split()

            if log[0] <= S:
                member[log[1]] = 1

            if E <= log[0] <= Q:
                if member.get(log[1]):
                    result.add(log[1])
        except:
            break
    print(len(result))


if __name__ == "__main__":
    solve()
