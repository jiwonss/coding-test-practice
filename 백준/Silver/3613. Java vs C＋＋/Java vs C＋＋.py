from sys import stdin

input = stdin.readline


def check(name):
    if name[0].isupper():
        return 0
    if name[0] == "_" or name[-1] == "_":
        return 0
    return 1


def convert(name):
    if not check(name):
        return "Error!"

    result = ""
    split_name = name.split("_")

    if len(split_name) <= 1:
        for n in name:
            if n.isupper():
                result += "_" + n.lower()
            else:
                result += n
    else:
        for i, n in enumerate(split_name):
            if n == "" or not n.islower():
                return "Error!"
            if i == 0:
                result += n
            else:
                result += n.capitalize()
    return result


def solve():
    name = input().strip()

    result = convert(name)
    print(result)


if __name__ == "__main__":
    solve()
