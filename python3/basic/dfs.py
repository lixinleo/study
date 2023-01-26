def dfs(self, tree):
    if root is None:
        return []
    visited, stack = [], [root]
    while stack:
        node = stack.pop()
        visited.append(node)
        stack.extend(filter(None, [node.right, node.left]))  
        # append right first, so left will be popped first
    return visited
