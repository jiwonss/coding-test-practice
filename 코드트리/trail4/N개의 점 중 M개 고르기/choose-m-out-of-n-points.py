n, m = map(int, input().split())
points = [tuple(map(int, input().split())) for _ in range(n)]

# Please write your code here.
def dfs(start, selected):
    global result

    if len(selected) == m:
        max_distance = 0
        for i in range(m):
            for j in range(i + 1, m):
                x1, y1 = points[selected[i]]
                x2, y2 = points[selected[j]]
                distance = (x1 - x2) ** 2 + (y1 - y2) ** 2
                max_distance = max(max_distance, distance)
        result = min(result, max_distance)
        return
    
    for i in range(start, n):
        selected.append(i)
        dfs(i + 1, selected)
        selected.pop()

result = float('inf')
dfs(0, [])
print(result)