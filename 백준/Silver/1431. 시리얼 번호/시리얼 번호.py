from sys import stdin
input = stdin.readline

def solve():
    N = int(input())
    serial_number = [input().strip() for _ in range(N)]
    
    serial_number.sort(key=lambda x : (
        len(x),
        sum([int(c) for c in x if c.isdigit()]),
        x
    ))
    
    print(*serial_number, sep="\n")


if __name__ == "__main__":
    solve()