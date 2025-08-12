from sys import stdin
input = stdin.readline

def solve():
    T = int(input())
    for _ in range(T):
        s = input().split()
        for i in range(len(s)):
            s[i] = s[i][::-1]
        result = ' '.join(s)
        print(result)
            

if __name__ == "__main__":
    solve()