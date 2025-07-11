class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        RedBlackTree<Integer> RBT = new RedBlackTree<>();
        long count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            count += RBT.numGreater(nums1[i] - nums2[i] - diff);
            count += map.getOrDefault(nums1[i] - nums2[i] - diff, 0);
            RBT.insert(nums1[i] - nums2[i]);
            map.put(nums1[i] - nums2[i], map.getOrDefault(nums1[i] - nums2[i], 0) +1);
        }
        return count;
    }
    static class RedBlackTree<T extends Comparable<T>> {
        private RedBlackNode<T> nil = new RedBlackNode<T>(), root = nil;
        public RedBlackTree() {
            root.left = nil;
            root.right = nil;
            root.parent = nil;
        }
        private void leftRotate(RedBlackNode<T> x) {
            leftRotateFixup(x);
            RedBlackNode<T> y;
            y = x.right;
            x.right = y.left;
            if (!isNil(y.left)) y.left.parent = x;
            y.parent = x.parent;
            if (isNil(x.parent)) root = y;
            else if (x.parent.left == x) x.parent.left = y;
            else x.parent.right = y;
            y.left = x;
            x.parent = y;
        }
        private void leftRotateFixup(RedBlackNode x) {
            if (isNil(x.left) && isNil(x.right.left)) {
                x.numLeft = 0;
                x.numRight = 0;
                x.right.numLeft = 1;
            } 
            else if (isNil(x.left) && !isNil(x.right.left)) {
                x.numLeft = 0;
                x.numRight = 1 + x.right.left.numLeft + x.right.left.numRight;
                x.right.numLeft = 2 + x.right.left.numLeft + x.right.left.numRight;
            } 
            else if (!isNil(x.left) && isNil(x.right.left)) {
                x.numRight = 0;
                x.right.numLeft = 2 + x.left.numLeft + x.left.numRight;
            } 
            else {
                x.numRight = 1 + x.right.left.numLeft + x.right.left.numRight;
                x.right.numLeft = 3 + x.left.numLeft + x.left.numRight + x.right.left.numLeft + x.right.left.numRight;
            }
        }
        private void rightRotate(RedBlackNode<T> y) {
            rightRotateFixup(y);
            RedBlackNode<T> x = y.left;
            y.left = x.right;
            if (!isNil(x.right)) x.right.parent = y;
            x.parent = y.parent;
            if (isNil(y.parent)) root = x;
            else if (y.parent.right == y) y.parent.right = x;
            else y.parent.left = x;
            x.right = y;
            y.parent = x;
        }
        private void rightRotateFixup(RedBlackNode y) {
            if (isNil(y.right) && isNil(y.left.right)) {
                y.numRight = 0;
                y.numLeft = 0;
                y.left.numRight = 1;
            } 
            else if (isNil(y.right) && !isNil(y.left.right)) {
                y.numRight = 0;
                y.numLeft = 1 + y.left.right.numRight + y.left.right.numLeft;
                y.left.numRight = 2 + y.left.right.numRight + y.left.right.numLeft;
            } 
            else if (!isNil(y.right) && isNil(y.left.right)) {
                y.numLeft = 0;
                y.left.numRight = 2 + y.right.numRight + y.right.numLeft;
            } 
            else {
                y.numLeft = 1 + y.left.right.numRight + y.left.right.numLeft;
                y.left.numRight = 3 + y.right.numRight + y.right.numLeft + y.left.right.numRight + y.left.right.numLeft;
            }
        }
        public void insert(T key) {insert(new RedBlackNode<T>(key));}
        private void insert(RedBlackNode<T> z) {
            RedBlackNode<T> y = nil;
            RedBlackNode<T> x = root;
            while (!isNil(x)) {
                y = x;
                if (z.key.compareTo(x.key) < 0) {
                    x.numLeft++; x = x.left;
                } 
                else {
                    x.numRight++; x = x.right;
                }
            }
            z.parent = y;
            if (isNil(y)) root = z;
            else if (z.key.compareTo(y.key) < 0) y.left = z;
            else y.right = z;
            z.left = nil; z.right = nil; z.color = RedBlackNode.RED;
            insertFixup(z);
        }
        private void insertFixup(RedBlackNode<T> z) {
            RedBlackNode<T> y = nil;
            while (z.parent.color == RedBlackNode.RED) {
                if (z.parent == z.parent.parent.left) {
                    y = z.parent.parent.right;
                    if (y.color == RedBlackNode.RED) {
                        z.parent.color = RedBlackNode.BLACK;
                        y.color = RedBlackNode.BLACK;
                        z.parent.parent.color = RedBlackNode.RED;
                        z = z.parent.parent;
                    } 
                    else if (z == z.parent.right) {
                        z = z.parent;
                        leftRotate(z);
                    } 
                    else {
                        z.parent.color = RedBlackNode.BLACK;
                        z.parent.parent.color = RedBlackNode.RED;
                        rightRotate(z.parent.parent);
                    }
                } 
                else {
                    y = z.parent.parent.left;
                    if (y.color == RedBlackNode.RED) {
                        z.parent.color = RedBlackNode.BLACK;
                        y.color = RedBlackNode.BLACK;
                        z.parent.parent.color = RedBlackNode.RED;
                        z = z.parent.parent;
                    } 
                    else if (z == z.parent.left) {
                        z = z.parent;
                        rightRotate(z);
                    } 
                    else {
                        z.parent.color = RedBlackNode.BLACK;
                        z.parent.parent.color = RedBlackNode.RED;
                        leftRotate(z.parent.parent);
                    }
                }
            }
            root.color = RedBlackNode.BLACK;
        }
        public RedBlackNode<T> treeMinimum(RedBlackNode<T> node) {
            while (!isNil(node.left)) node = node.left;
            return node;
        }
        public RedBlackNode<T> treeSuccessor(RedBlackNode<T> x) {
            if (!isNil(x.left)) return treeMinimum(x.right);
            RedBlackNode<T> y = x.parent;
            while (!isNil(y) && x == y.right) {
                x = y; y = y.parent;
            }
            return y;
        }
        public void remove(RedBlackNode<T> v) {
            RedBlackNode<T> z = search(v.key), x = nil, y = nil;
            if (isNil(z.left) || isNil(z.right)) y = z;
            else  y = treeSuccessor(z);
            if (!isNil(y.left)) x = y.left;
            else x = y.right;
            x.parent = y.parent;
            if (isNil(y.parent)) root = x;
            else if (!isNil(y.parent.left) && y.parent.left == y)  y.parent.left = x;
            else if (!isNil(y.parent.right) && y.parent.right == y)  y.parent.right = x;
            if (y != z) z.key = y.key;
            fixNodeData(x, y);
            if (y.color == RedBlackNode.BLACK)  removeFixup(x);
        }
        private void fixNodeData(RedBlackNode<T> x, RedBlackNode<T> y) {
            RedBlackNode<T> current = nil, track = nil;
            if (isNil(x)) {
                current = y.parent;
                track = y;
            } 
            else {
                current = x.parent;
                track = x;
            }
            while (!isNil(current)) {
                if (y.key != current.key) {
                    if (y.key.compareTo(current.key) > 0) current.numRight--;
                    if (y.key.compareTo(current.key) < 0) current.numLeft--;
                } 
                else {
                    if (isNil(current.left)) current.numLeft--;
                    else if (isNil(current.right)) current.numRight--;
                    else if (track == current.right) current.numRight--;
                    else if (track == current.left) current.numLeft--;
                }
                track = current;
                current = current.parent;
            }
        }
        private void removeFixup(RedBlackNode<T> x) {
            RedBlackNode<T> w;
            while (x != root && x.color == RedBlackNode.BLACK) {
                if (x == x.parent.left) {
                    w = x.parent.right;
                    if (w.color == RedBlackNode.RED) {
                        w.color = RedBlackNode.BLACK;
                        x.parent.color = RedBlackNode.RED;
                        leftRotate(x.parent);
                        w = x.parent.right;
                    }
                    if (w.left.color == RedBlackNode.BLACK && w.right.color == RedBlackNode.BLACK) {
                        w.color = RedBlackNode.RED;
                        x = x.parent;
                    }
                    else {
                        if (w.right.color == RedBlackNode.BLACK) {
                            w.left.color = RedBlackNode.BLACK;
                            w.color = RedBlackNode.RED;
                            rightRotate(w);
                            w = x.parent.right;
                        }
                        w.color = x.parent.color;
                        x.parent.color = RedBlackNode.BLACK;
                        w.right.color = RedBlackNode.BLACK;
                        leftRotate(x.parent);
                        x = root;
                    }
                } 
                else {
                    w = x.parent.left;
                    if (w.color == RedBlackNode.RED) {
                        w.color = RedBlackNode.BLACK;
                        x.parent.color = RedBlackNode.RED;
                        rightRotate(x.parent);
                        w = x.parent.left;
                    }
                    if (w.right.color == RedBlackNode.BLACK && w.left.color == RedBlackNode.BLACK) {
                        w.color = RedBlackNode.RED;
                        x = x.parent;
                    }
                    else {
                        if (w.left.color == RedBlackNode.BLACK) {
                            w.right.color = RedBlackNode.BLACK;
                            w.color = RedBlackNode.RED;
                            leftRotate(w);
                            w = x.parent.left;
                        }
                        w.color = x.parent.color;
                        x.parent.color = RedBlackNode.BLACK;
                        w.left.color = RedBlackNode.BLACK;
                        rightRotate(x.parent);
                        x = root;
                    }
                }
            }
            x.color = RedBlackNode.BLACK;
        }
        public RedBlackNode<T> search(T key) {
            RedBlackNode<T> current = root;
            while (!isNil(current)) {
                if (current.key.equals(key)) return current;
                else if (current.key.compareTo(key) < 0) current = current.right;
                else current = current.left;
            }
            return null;
        }
        public int numGreater(T key) { return findNumGreater(root, key); }
        public int numSmaller(T key) { return findNumSmaller(root, key); }
        public int findNumGreater(RedBlackNode<T> node, T key) {
            if (isNil(node)) return 0;
            else if (key.compareTo(node.key) < 0) return 1 + node.numRight + findNumGreater(node.left, key);
            return findNumGreater(node.right, key);
        }
        public List<T> getGreaterThan(T key, Integer maxReturned) {
            List<T> list = new ArrayList<T>();
            getGreaterThan(root, key, list);
            return list.subList(0, Math.min(maxReturned, list.size()));
        }
        private void getGreaterThan(RedBlackNode<T> node, T key, List<T> list) {
            if (isNil(node)) return;
            else if (node.key.compareTo(key) > 0) {
                getGreaterThan(node.left, key, list);
                list.add(node.key);
                getGreaterThan(node.right, key, list);
            } 
            else getGreaterThan(node.right, key, list);
        }
        public int findNumSmaller(RedBlackNode<T> node, T key) {
            if (isNil(node)) return 0;
            else if (key.compareTo(node.key) <= 0) return findNumSmaller(node.left, key);
            else return 1 + node.numLeft + findNumSmaller(node.right, key);
        }
        private boolean isNil(RedBlackNode node) { return node == nil; }
        public int size() { return root.numLeft + root.numRight + 1; }
    }
    static class RedBlackNode<T extends Comparable<T>> {
        public static final int BLACK = 0, RED = 1;
        public T key;
        RedBlackNode<T> parent, left, right;
        public int numLeft = 0, numRight = 0;
        public int color;
        RedBlackNode() {
            color = BLACK;
            numLeft = 0; numRight = 0;
            parent = null; left = null; right = null;
        }
        RedBlackNode(T key) {
            this();
            this.key = key;
        }
    }
}