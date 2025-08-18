directions = {"U": [-1, 0], "D": [1, 0], "R": [0, -1], "L": [0, 1]}

def out_of_bounds(x, y):
    return not (-5 <= x <= 5 and -5 <= y <= 5)

def solution(dirs):
    x, y = 0, 0
    visited = set()
    for d in dirs:
        nx, ny = x + directions[d][0], y + directions[d][1]
        if out_of_bounds(nx, ny):
            continue
        visited.add((x, y, nx, ny))
        visited.add((nx, ny, x, y))
        x, y = nx, ny
    return len(visited) // 2