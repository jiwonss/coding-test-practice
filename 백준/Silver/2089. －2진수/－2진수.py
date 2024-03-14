from sys import stdin
input = stdin.readline

def solve(n):
  global result
  if n == 0:
    result += '0'
    return
  if n == 1:
    result += '1'
    return
  if n % -2:
    result += '1'
    solve(n // -2 + 1)
  else:
    result += '0'
    solve(n // -2)

N = int(input())

result = ''
solve(N)
print(result[::-1])