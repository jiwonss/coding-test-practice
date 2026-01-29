from sys import stdin

input = stdin.readline


def solve():
    X, T = map(int, input().split())

    # 버튼 1개
    for s in [8, 4, 1]:
        if X % s == 0:
            div = X // s
            if div <= T:
                print(1)
                print(f"{T - div} {s}")
                return

    # 버튼 2개
    for s1, s2 in [[8, 4], [8, 1], [4, 1]]:
        div1, mod1 = divmod(X, s1)
        if mod1 % s2 == 0:
            div2 = mod1 // s2
            if div1 + div2 <= T:
                print(2)
                start_time = T - (div1 + div2)
                print(f"{start_time} {s1}")
                print(f"{start_time + div1} {s2}")
                return

    # 버튼 3개
    s1, s2, s3 = 8, 4, 1

    div1, mod1 = divmod(X, s1)
    div2, mod2 = divmod(mod1, s2)
    div3 = mod2 // s3

    if div1 + div2 + div3 <= T:
        print(3)
        start_time = T - (div1 + div2 + div3)
        print(f"{start_time} {s1}")
        print(f"{start_time + div1} {s2}")
        print(f"{start_time + div1 + div2} {s3}")
        return

    print(-1)
    return


if __name__ == "__main__":
    solve()
