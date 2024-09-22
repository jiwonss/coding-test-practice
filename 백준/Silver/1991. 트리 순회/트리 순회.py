from sys import stdin

input = stdin.readline


class BinaryTree:
    def __init__(self) -> None:
        self.tree = {}

    def add(self, root, left, right):
        self.tree[root] = [left, right]

    def preorder(self, node):
        if node != ".":
            print(node, end="")
            self.preorder(self.tree[node][0])
            self.preorder(self.tree[node][1])

    def inorder(self, node):
        if node != ".":
            self.inorder(self.tree[node][0])
            print(node, end="")
            self.inorder(self.tree[node][1])

    def postorder(self, node):
        if node != ".":
            self.postorder(self.tree[node][0])
            self.postorder(self.tree[node][1])
            print(node, end="")


def solve():
    N = int(input())

    binary_tree = BinaryTree()
    for _ in range(N):
        root, left, right = input().split()
        binary_tree.add(root, left, right)

    binary_tree.preorder('A')
    print()
    binary_tree.inorder('A')
    print()
    binary_tree.postorder('A')
    print()


if __name__ == "__main__":
    solve()
