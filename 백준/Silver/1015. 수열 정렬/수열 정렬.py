from sys import stdin
input = stdin.readline

def solve():
    N = int(input())
    A = list(map(int, input().split()))
    B = sorted((a, i) for i, a in enumerate(A))

    P = [0] * N
    for b_idx, (v, a_idx) in enumerate(B):
        P[a_idx] = b_idx
    print(*P)

if __name__ == "__main__":
    solve()