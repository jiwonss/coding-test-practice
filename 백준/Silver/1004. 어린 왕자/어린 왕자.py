from sys import stdin
input = stdin.readline


def solve():
    T = int(input())
    for _ in range(T):
        x1, y1, x2, y2 = map(int, input().split())
        n = int(input())

        count = 0
        for _ in range(n):
            cx, cy, r = map(int, input().split())
            
            start_dist = (x1 - cx) ** 2 + (y1 - cy) ** 2
            end_dist = (x2 - cx) ** 2 + (y2 - cy) ** 2

            start_inside = start_dist < r ** 2
            end_inside = end_dist < r ** 2

            if start_inside != end_inside:
                count += 1

        print(count)

if __name__ == "__main__":
    solve()