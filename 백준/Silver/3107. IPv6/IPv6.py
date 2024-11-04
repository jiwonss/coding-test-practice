from sys import stdin

input = stdin.readline


def solve():
    ipv6 = input().strip().split(":")

    idx, group = -1, []
    for i in range(len(ipv6)):
        if ipv6[i] == "":
            if idx == -1:
                idx = len(group)
            continue
        group.append(ipv6[i].zfill(4))

    if len(group) < 8:
        group[idx:idx] = ["0000"] * (8 - len(group))

    print(":".join(group))


if __name__ == "__main__":
    solve()
