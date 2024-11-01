from sys import stdin
from collections import Counter

input = stdin.readline


def solve():
    N, M = map(int, input().split())
    dna = [input().strip() for _ in range(N)]

    dna_s, hamming_distace = "", 0
    for k in zip(*dna):
        counter = Counter(k)
        temp = sorted(counter.items(), key=lambda x: (-x[1], x[0]))

        dna_s += temp[0][0]
        hamming_distace += sum([v for _, v in temp[1:]])

    print(dna_s)
    print(hamming_distace)


if __name__ == "__main__":
    solve()
